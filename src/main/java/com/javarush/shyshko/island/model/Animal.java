package main.java.com.javarush.shyshko.island.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Override
    public String getIcon() {
        return icon;
    }

    public boolean isDead() {
        return isDead;
    }

    public void die() {
        this.isDead = true;
    }

    public boolean hasMultipliedThisStep() {
        return hasMultipliedThisStep;
    }

    public void setHasMultipliedThisStep(boolean multiplied) {
        this.hasMultipliedThisStep = multiplied;
    }

    public void eat(Location loc) {
        if (isDead || currentSatiety >= foodNeeded ) {
            return;
        }
        List targets = new ArrayList(loc.getOrganisms());
        Random rand = new Random();

        for (Object food : targets) {
            if (this instanceof Wolf && food instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) food;
                if (!rabbit.isDead() && rand.nextInt(100) < 60) {
                    rabbit.die();
                    loc.removeOrganism(rabbit);
                    this.currentSatiety = Math.min(foodNeeded, this.currentSatiety + rabbit.getWeight());
                    System.out.println(this.getIcon() + " съел " + rabbit.getIcon());
                    break;
                }
            } else if (this instanceof Rabbit && food instanceof Plant) {
                Plant plant = (Plant) food;
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
                if (!potential.isDead() && !potential.hasMultipliedThisStep()) {
                    partner = potential;
                    break;
                }
            }
        }

        if(partner != null) {
            Animal baby = spawnChild();
            if(baby != null) {
                baby.setMyLocation(loc);
                loc.addOrganism(baby);
                this.hasMultipliedThisStep = true;
                partner.setHasMultipliedThisStep(true);
                System.out.println("Родился " + baby.getIcon());
            }
        }
    }

    protected abstract Animal spawnChild();

    public void move(Location[][] grid) {
        if(isDead || maxSpeed == 0) {
            return;
        }

        Random random = new Random();
        int step = random.nextInt(maxSpeed + 1);
        if(step == 0) {
            return;
        }

        int newX = Math.clamp(myLocation.getX() + random.nextInt(-step, step + 1), 0, 99);
        int newY = Math.clamp(myLocation.getY() + random.nextInt(-step, step + 1), 0, 19);

        Location target = grid[newY][newX];
        int count = 0;
        List targetList = target.getOrganisms();

        for (Object o : targetList) {
            if (o.getClass().equals(this.getClass())) {
                count++;
            }
        }
        if(count <maxOnCell) {
            myLocation.removeOrganism(this);
            this.setMyLocation(target);
            target.addOrganism(this);
        }


    }

    public void passStep() {
        this.currentSatiety -= (this.foodNeeded * 0.15);
        if(this.currentSatiety <= 0) {
            die();
            System.out.println(this.getIcon() + " умер от голода");
        } else {
            String satietyStr = String.format("%.2f", this.currentSatiety);
            System.out.println(this.getIcon() + " прожил этот шаг. Текущая сытость: " + satietyStr + "/" + this.foodNeeded);
        }
    }
}
