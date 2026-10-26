package main.java.com.javarush.shyshko.island.config;

import main.java.com.javarush.shyshko.island.factory.OrganismType;

import java.util.EnumMap;
import java.util.Map;

public final class SimulationConfig {

    private static final Map<OrganismType, Map<OrganismType, Integer>> targetMatrix = new EnumMap<>(OrganismType.class);

    static {
        // Вероятности для волка
        Map<OrganismType, Integer> wolfRules = new EnumMap<>(OrganismType.class);
        wolfRules.put(OrganismType.HORSE, 10);
        wolfRules.put(OrganismType.DEER, 15);
        wolfRules.put(OrganismType.RABBIT, 60);
        wolfRules.put(OrganismType.MOUSE, 80);
        wolfRules.put(OrganismType.GOAT, 60);
        wolfRules.put(OrganismType.SHEEP, 70);
        wolfRules.put(OrganismType.BOAR, 80);
        wolfRules.put(OrganismType.BUFFALO, 10);
        wolfRules.put(OrganismType.DUCK, 40);
        targetMatrix.put(OrganismType.WOLF, wolfRules);

        // Вероятности для удава
        Map<OrganismType, Integer> boaRules = new EnumMap<>(OrganismType.class);
        boaRules.put(OrganismType.FOX, 15);
        boaRules.put(OrganismType.RABBIT, 20);
        boaRules.put(OrganismType.MOUSE, 40);
        boaRules.put(OrganismType.DUCK, 10);
        targetMatrix.put(OrganismType.BOA, boaRules);

        // Вероятности для лисы
        Map<OrganismType, Integer> foxRules = new EnumMap<>(OrganismType.class);
        foxRules.put(OrganismType.RABBIT, 70);
        foxRules.put(OrganismType.MOUSE, 90);
        foxRules.put(OrganismType.DUCK, 60);
        foxRules.put(OrganismType.CATERPILLAR, 40);
        targetMatrix.put(OrganismType.FOX, foxRules);

        // Вероятности для медведя
        Map<OrganismType, Integer> bearRules = new EnumMap<>(OrganismType.class);
        bearRules.put(OrganismType.BOA, 80);
        bearRules.put(OrganismType.HORSE, 40);
        bearRules.put(OrganismType.DEER, 80);
        bearRules.put(OrganismType.RABBIT, 80);
        bearRules.put(OrganismType.MOUSE, 90);
        bearRules.put(OrganismType.GOAT, 70);
        bearRules.put(OrganismType.SHEEP, 70);
        bearRules.put(OrganismType.BOAR, 50);
        bearRules.put(OrganismType.BUFFALO, 20);
        bearRules.put(OrganismType.DUCK, 10);
        targetMatrix.put(OrganismType.BEAR, bearRules);

        // Вероятности для орла
        Map<OrganismType, Integer> eagleRules = new EnumMap<>(OrganismType.class);
        eagleRules.put(OrganismType.FOX, 10);
        eagleRules.put(OrganismType.RABBIT, 90);
        eagleRules.put(OrganismType.MOUSE, 90);
        eagleRules.put(OrganismType.DUCK, 80);
        targetMatrix.put(OrganismType.EAGLE, eagleRules);

        // Вероятности для травоядных (едят растения)
        configureHerbivore(OrganismType.HORSE);
        configureHerbivore(OrganismType.DEER);
        configureHerbivore(OrganismType.RABBIT);
        configureHerbivore(OrganismType.GOAT);
        configureHerbivore(OrganismType.SHEEP);
        configureHerbivore(OrganismType.BUFFALO);

        // Вероятности для мыши
        Map<OrganismType, Integer> mouseRules = new EnumMap<>(OrganismType.class);
        mouseRules.put(OrganismType.PLANT, 100);
        mouseRules.put(OrganismType.CATERPILLAR, 90);
        targetMatrix.put(OrganismType.MOUSE, mouseRules);

        // Вероятности для кабана
        Map<OrganismType, Integer> boarRules = new EnumMap<>(OrganismType.class);
        boarRules.put(OrganismType.PLANT, 100);
        boarRules.put(OrganismType.CATERPILLAR, 90);
        boarRules.put(OrganismType.MOUSE, 50);
        targetMatrix.put(OrganismType.BOAR, boarRules);

        // Вероятности для утки
        Map<OrganismType, Integer> duckRules = new EnumMap<>(OrganismType.class);
        duckRules.put(OrganismType.PLANT, 100);
        duckRules.put(OrganismType.CATERPILLAR, 90);
        targetMatrix.put(OrganismType.DUCK, duckRules);

        // Вероятности для гусеницы
        Map<OrganismType, Integer> caterpillarRules = new EnumMap<>(OrganismType.class);
        caterpillarRules.put(OrganismType.PLANT, 100);
        targetMatrix.put(OrganismType.CATERPILLAR, caterpillarRules);
    }

    private static void configureHerbivore(OrganismType herbivoreType) {
        Map<OrganismType, Integer> rules = new EnumMap<>(OrganismType.class);
        rules.put(OrganismType.PLANT, 100);
        targetMatrix.put(herbivoreType, rules);
    }

    public static int getProbability(OrganismType attacker, OrganismType victim) {
        Map<OrganismType, Integer> attackerRules = targetMatrix.get(attacker);
        if (attackerRules == null) {
            return 0;
        }
        return attackerRules.getOrDefault(victim, 0);
    }
}
