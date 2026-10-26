package main.java.com.javarush.shyshko.island.model.organism.abstraction;

import java.util.List;
import java.util.Random;
import java.util.function.BiPredicate;

import lombok.Getter;
import lombok.Setter;
import main.java.com.javarush.shyshko.island.config.SimulationConfig;
import main.java.com.javarush.shyshko.island.factory.OrganismFactory;
import main.java.com.javarush.shyshko.island.model.Island;
import main.java.com.javarush.shyshko.island.model.Location;
import main.java.com.javarush.shyshko.island.factory.OrganismType;

@Getter
@Setter
public abstract class Animal extends Organism {

    protected double currentSatiety;
    protected boolean isDead = false;
    protected boolean hasMultipliedThisStep = false;
    protected int maxSpeed;
    protected double foodNeeded;
    protected BiPredicate<Animal, Organism> huntingStrategy;

    public Animal(OrganismType type,
                  String name,
                  double weight,
                  int maxSpeed,
                  double foodNeeded,
                  BiPredicate<Animal, Organism> huntingStrategy) {
        super(type, name, weight);
        this.foodNeeded = foodNeeded;
        this.currentSatiety = foodNeeded / 2;
        this.huntingStrategy = huntingStrategy;
        this.maxSpeed = maxSpeed;
    }

    public void eat(Location loc) {
        if (isDead || currentSatiety >= foodNeeded) {
            return;
        }
        Random rand = new Random();

        for (Organism food : loc.getOrganismsOfType(Organism.class)) {
            if (huntingStrategy.test(this, food)) {

                    int probability = SimulationConfig.getProbability(this.getType(), food.getType());
                    if (probability > 0 && rand.nextInt(100) < probability) {

                        if (food instanceof Animal animal) {
                            animal.setDead(true);
                        }
                        loc.removeOrganism(food);
                        this.currentSatiety = Math.min(foodNeeded, this.currentSatiety + food.getWeight());
                        break;
                    }
            }
        }
    }


    public void multiply(Location loc) {
        if (isDead || hasMultipliedThisStep) {
            return;
        }

        List<Organism> list = loc.getOrganisms();
        int count = 0;
        for (Object object : list) {
            if (object.getClass().equals(this.getClass())) {
                count++;
            }
        }
        if (count >= maxOnCell) {
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

        if (partner != null) {
            Animal baby = (Animal) OrganismFactory.createOrganism(this.getType());
            baby.setMyLocation(loc);
            loc.addOrganism(baby);
            this.setHasMultipliedThisStep(true);
            partner.setHasMultipliedThisStep(true);
        }
    }

    public void move(Island island) {
        if (isDead || maxSpeed == 0) {
            return;
        }

        Random random = new Random();
        int step = random.nextInt(maxSpeed + 1);
        if (step == 0) {
            return;
        }

        int newX = myLocation.getX() + random.nextInt(-step, step + 1);
        int newY = myLocation.getY() + random.nextInt(-step, step + 1);

        if (newX < 0) {
            newX = 0;
        }
        if (newX >= island.getWidth()) {
            newX = island.getWidth() - 1;
        }
        if (newY < 0) {
            newY = 0;
        }
        if (newY >= island.getHeight()) {
            newY = island.getHeight() - 1;
        }
        Location target = island.getLocation(newX, newY);
        if (target != null) {
            myLocation.moveAnimal(this, target);
        }
    }

    public void passTact() {
        if (this.isDead()) {
            return;
        }

        this.currentSatiety -= (this.foodNeeded * 0.30);
        if (this.currentSatiety <= 0) {
            setDead(true);
        }
        this.setHasMultipliedThisStep(false);
    }
}
