package PracticeCode;

import java.util.ArrayList;

public class Demographics {
    private ArrayList<PopulationZone> countries;

    public double teenRatio(PopulationZone z) {
        return (double) (z.populationBelow(20) - z.populationBelow(13)) / z.totalPopulation();
    }

    public String findMostTeens() {
        if (countries.size() == 0)
            return null;
        String mostTeensCountry = countries.get(0).getName();
        double highestRatio = teenRatio(countries.get(0));
        for (int i = 1; i < countries.size(); i++)
            if (highestRatio < teenRatio(countries.get(i))) {
                highestRatio = teenRatio(countries.get(i));
                mostTeensCountry = countries.get(i).getName();
            }
        return mostTeensCountry;
    }
}