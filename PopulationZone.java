public abstract class PopulationZone {
    private static final int MAX_AGE = 100;
    private String name;
    private int population;
    private double growthRate;
    private int[] populationByAge;

    public PopulationZone(String _name, int[] _populationByAge) { ... }

    public PopulationZone(String _name, int[] _populationByAge, double _growthRate) { ... }

    public String getName() { ... }

    public double getGrowth() { ... }

    public double setGrowth(double newGrowthRate) { ... }

    public int totalPopulation() { ... }

    public int populationBelow(int threshold) { ... }

    public void yearPass() { ... }
}