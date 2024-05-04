import java.util.Objects;

public class Country {
    private String name;
    private String capital;
    private int population;
    private double area;

    public Country(String name, String capital, int population, double area) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Country("+ getName() + ") - Capital(" + getCapital() + ") - Area(" + area + ")";
        return "";
    }

    @Override
    public boolean equals(Object o) {
        Country country = (Country) o;
        return population == country.population &&
                Double.compare(country.area, area) == 0 &&
                Objects.equals(name, country.name) &&
                Objects.equals(capital, country.capital);
    }
}
