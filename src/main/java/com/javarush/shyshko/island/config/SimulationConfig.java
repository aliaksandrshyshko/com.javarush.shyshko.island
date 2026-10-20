package main.java.com.javarush.shyshko.island.config;

import lombok.Builder;
import lombok.Getter;
import main.java.com.javarush.shyshko.island.model.organism.Plant;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Animal;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Organism;
import main.java.com.javarush.shyshko.island.model.organism.herbivore.*;
import main.java.com.javarush.shyshko.island.model.organism.predator.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
public class SimulationConfig {
    private final int mapWidth;
    private final int mapHeight;

    private static final Map<Class<? extends Animal>, Map<Class<? extends Organism>, Integer>> targetMatrix = new HashMap<>();

    static {

        //Вероятности для волка
        Map<Class<? extends Organism>, Integer> wolfRules = new HashMap<>();
        wolfRules.put(Horse.class, 10);
        wolfRules.put(Deer.class, 15);
        wolfRules.put(Rabbit.class, 60);
        wolfRules.put(Mouse.class, 80);
        wolfRules.put(Goat.class, 60);
        wolfRules.put(Sheep.class, 70);
        wolfRules.put(Boar.class, 80);
        wolfRules.put(Buffalo.class, 10);
        wolfRules.put(Duck.class, 40);
        targetMatrix.put(Wolf.class, wolfRules);

        //Вероятности для удава
        Map<Class<? extends Organism>, Integer> boaRules = new HashMap<>();
        boaRules.put(Fox.class, 15);
        boaRules.put(Rabbit.class, 20);
        boaRules.put(Mouse.class, 40);
        boaRules.put(Duck.class, 10);
        targetMatrix.put(Boa.class, boaRules);

        //Вероятности для лисы
        Map<Class<? extends Organism>, Integer> foxRules = new HashMap<>();
        foxRules.put(Rabbit.class, 70);
        foxRules.put(Mouse.class, 90);
        foxRules.put(Duck.class, 60);
        foxRules.put(Caterpillar.class, 40);
        targetMatrix.put(Fox.class, foxRules);

        //Вероятности для медведя
        Map<Class<? extends Organism>, Integer> bearRules = new HashMap<>();
        bearRules.put(Boa.class, 80);
        bearRules.put(Horse.class, 40);
        bearRules.put(Deer.class, 80);
        bearRules.put(Rabbit.class, 80);
        bearRules.put(Mouse.class, 90);
        bearRules.put(Goat.class, 70);
        bearRules.put(Sheep.class, 70);
        bearRules.put(Boar.class, 50);
        bearRules.put(Buffalo.class, 20);
        bearRules.put(Duck.class, 10);
        targetMatrix.put(Bear.class, bearRules);

        //Вероятности для орла
        Map<Class<? extends Organism>, Integer> eagleRules = new HashMap<>();
        eagleRules.put(Fox.class, 10);
        eagleRules.put(Rabbit.class, 90);
        eagleRules.put(Mouse.class, 90);
        eagleRules.put(Duck.class, 80);
        targetMatrix.put(Eagle.class, eagleRules);

        //Вероятности для лошади
        Map<Class<? extends Organism>, Integer> horseRules = new HashMap<>();
        horseRules.put(Plant.class, 100);
        targetMatrix.put(Horse.class, horseRules);

        //Вероятности для оленя
        Map<Class<? extends Organism>, Integer> deerRules = new HashMap<>();
        deerRules.put(Plant.class, 100);
        targetMatrix.put(Deer.class, deerRules);

        //Вероятности для кролика
        Map<Class<? extends Organism>, Integer> rabbitRules = new HashMap<>();
        rabbitRules.put(Plant.class, 100);
        targetMatrix.put(Rabbit.class, rabbitRules);

        //Вероятности для мыши
        Map<Class<? extends Organism>, Integer> mouseRules = new HashMap<>();
        mouseRules.put(Plant.class, 100);
        mouseRules.put(Caterpillar.class, 90);
        targetMatrix.put(Mouse.class, mouseRules);

        //Вероятности для козы
        Map<Class<? extends Organism>, Integer> goatRules = new HashMap<>();
        goatRules.put(Plant.class, 100);
        targetMatrix.put(Goat.class, goatRules);

        //Вероятности для овцы
        Map<Class<? extends Organism>, Integer> sheepRules = new HashMap<>();
        sheepRules.put(Plant.class, 100);
        targetMatrix.put(Sheep.class, sheepRules);

        //Вероятности для кабана
        Map<Class<? extends Organism>, Integer> boarRules = new HashMap<>();
        boarRules.put(Plant.class, 100);
        boarRules.put(Caterpillar.class, 90);
        boarRules.put(Mouse.class, 50);
        targetMatrix.put(Boar.class, boarRules);

        //Вероятности для буйвола
        Map<Class<? extends Organism>, Integer> buffaloRules = new HashMap<>();
        buffaloRules.put(Plant.class, 100);
        targetMatrix.put(Buffalo.class, buffaloRules);

        //Вероятности для утки
        Map<Class<? extends Organism>, Integer> duckRules = new HashMap<>();
        duckRules.put(Plant.class, 100);
        duckRules.put(Caterpillar.class, 90);
        targetMatrix.put(Duck.class, duckRules);

        //Вероятности для гусеницы
        Map<Class<? extends Organism>, Integer> caterpillarRules = new HashMap<>();
        caterpillarRules.put(Caterpillar.class, 100);
        targetMatrix.put(Caterpillar.class, caterpillarRules);


    }

    public static int getProbability(Class<? extends Animal> attacker, Class<? extends Organism> victim) {
        if(!targetMatrix.containsKey(attacker)) {
            return 0;
        }
        return targetMatrix.get(attacker).getOrDefault(victim,0);
    }


}
