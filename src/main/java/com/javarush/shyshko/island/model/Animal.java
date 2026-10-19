package main.java.com.javarush.shyshko.island.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;
import main.java.com.javarush.shyshko.island.factory.OrganismFactory;

@Getter
@Setter
public abstract class Animal extends Organism {

    protected double maxWeight;
    protected int maxOnCell;
    protected int maxSpeed;
    protected double foodNeeded;
    protected double currentSatiety;
    protected boolean isDead = false;
    protected boolean hasMultipliedThisStep = false;
    protected String icon;


    public Animal(double maxWeight,
                  int maxOnCell,
                  int maxSpeed,
                  double foodNeeded,
                  String icon) {
        super(maxWeight);
        this.maxWeight = maxWeight;
        this.maxOnCell = maxOnCell;
        this.maxSpeed = maxSpeed;
        this.foodNeeded = foodNeeded;
        this.currentSatiety = foodNeeded / 2;
        this.icon = icon;
    }

    public void eat(Location loc) {
        if (isDead || currentSatiety >= foodNeeded ) {
            return;
        }
        List targets = new ArrayList(loc.getOrganisms());
        Random rand = new Random();

        for (Object food : targets) {
            if (this instanceof Wolf && food instanceof Rabbit rabbit) {
                if (!rabbit.isDead() && rand.nextInt(100) < 60) {
                    rabbit.setDead(true);
                    loc.removeOrganism(rabbit);
                    this.currentSatiety = Math.min(foodNeeded, this.currentSatiety + rabbit.getWeight());
                    System.out.println(this.getIcon() + " съел " + rabbit.getIcon());
                    break;
                }
            } else if (this instanceof Rabbit && food instanceof Plant plant) {
                loc.removeOrganism(plant);
                this.currentSatiety = Math.min(foodNeeded, this.currentSatiety + plant.getWeight());
                System.out.println(this.getIcon() + " съел " + plant.getIcon());
                break;
            }
        }
    }

    public void multiply(Location loc) {
        if(isDead || hasMultipliedThisStep) {
            return;
        }

        List list = loc.getOrganisms();
        int count =0;
        for (Object object : list) {
            if (object.getClass().equals(this.getClass())) {
                count++;
            }
        }
        if(count >= maxOnCell) {
            return;
        }

        Animal partner = null;
        for (Object o : list) {
            if (o.getClass().equals(this.getClass()) && o != this) {
                Animal potential = (Animal) o;
                if (!potential.isDead() && !potential.isHasMultipliedThisStep()) {
                    partner = potential;
                    break;
                }
            }
        }

        if(partner != null) {
            String typeName = this.getClass().getSimpleName();
            Animal baby = (Animal) OrganismFactory.createOrganism(typeName);
            if(baby != null) {
                baby.setMyLocation(loc);
                loc.addOrganism(baby);
                this.setHasMultipliedThisStep(true);
                partner.setHasMultipliedThisStep(true);
                System.out.println("Фабрика создала " + baby.getIcon());
            }
        }
    }

    public void move(IslandMap islandMap) {
        if(isDead || maxSpeed == 0) {
            return;
        }

        Random random = new Random();
        int step = random.nextInt(maxSpeed + 1);
        if(step == 0) {
            return;
        }

        int newX = myLocation.getX() + random.nextInt(-step, step + 1);
        int newY = myLocation.getY() + random.nextInt(-step, step + 1);

        if(newX < 0) {
            newX = 0;
        }
        if(newX >= islandMap.getWidth()) {
            newX = islandMap.getWidth() -1;
        }
        if(newY < 0) {
            newY = 0;
        }
        if(newY >= islandMap.getHeight()) {
            newY = islandMap.getHeight() -1;
        }

        Location target = islandMap.getLocation(newX, newY);
        if(target == null) {
            return;
        }
        int count = 0;
        List targetList = target.getOrganisms();
        for (Object o : targetList) {
            if (o.getClass().equals(this.getClass())) {
                count++;
            }
        }
        if(count < maxOnCell) {
            myLocation.removeOrganism(this);
            target.addOrganism(this);
            System.out.println(this.getIcon() + " переместился в клетку [" + newX + ", " + newY + "]");
        }


    }

    public void passStep() {
        this.currentSatiety -= (this.foodNeeded * 0.15);
        if(this.currentSatiety <= 0) {
            setDead(true);
            System.out.println(this.getIcon() + " умер от голода");
        } else {
            String satietyStr = String.format("%.2f", this.currentSatiety);
            System.out.println(this.getIcon() + " прожил этот шаг. Текущая сытость: " + satietyStr + "/" + this.foodNeeded);
        }
    }
}
