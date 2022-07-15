package PracticeCode;

public abstract class PopulationZone {
    protected /* private */ static final int MAX_AGE = 100;
    protected /* private */ String name;
    protected /* private */ int population;
    protected /* private */ double growthRate;
    protected /* private */ int[] populationByAge;

    public PopulationZone(String _name, int[] _populationByAge) {}

    public PopulationZone(String _name, int[] _populationByAge, double _growthRate) {}

    public abstract String getName();

    public abstract double getGrowth();

    public abstract double setGrowth(double newGrowthRate);

    public abstract int totalPopulation();

    public abstract int populationBelow(int threshold);

    public abstract void yearPass();
}