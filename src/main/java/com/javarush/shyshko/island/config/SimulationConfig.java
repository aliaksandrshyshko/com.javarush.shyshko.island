package main.java.com.javarush.shyshko.island.config;

import lombok.Builder;
import lombok.Getter;
import main.java.com.javarush.shyshko.island.model.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
public class SimulationConfig {
    private final int mapWidth;
    private final int mapHeight;

    private static final Map<Class<? extends Animal>, Map<Class<? extends Organism>, Integer>> targetMatrix = new HashMap<>();

    static {
        Map<Class<? extends Organism>, Integer> wolfRules = new HashMap<>();
        wolfRules.put(Rabbit.class, 60);
        targetMatrix.put(Wolf.class, wolfRules);

        Map<Class<? extends Organism>, Integer> rabbitRules = new HashMap<>();
        rabbitRules.put(Plant.class, 100);
        targetMatrix.put(Rabbit.class, rabbitRules);
    }

    public static int getProbability(Class<? extends Animal> attacker, Class<? extends Organism> victim) {
        if(!targetMatrix.containsKey(attacker)) {
            return 0;
        }
        return targetMatrix.get(attacker).getOrDefault(victim,0);
    }


}
