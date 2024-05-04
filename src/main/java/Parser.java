import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public List<Country> sortByName(){
        List<Country> sortedByName = new ArrayList<>(countries);
        Collections.sort(sortedByName, new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                return country1.getName().compareTo(country2.getName());
            }
        });

        return  sortedByName;
    }

    public List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        Collections.sort(sortedByPopulation, new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                return Integer.compare( country1.getPopulation(),country2.getPopulation());
            }
        });
        return sortedByPopulation;
    }

    public List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>(countries);
        Collections.sort(sortedByArea, new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                return Double.compare( country1.getArea(),country2.getArea());
            }
        });
        return sortedByArea;
    }

    public void setUp() throws IOException {
        Document doc = Jsoup.parse(new File("src/Resources/country-list.html"), "UTF-8");
        Elements countryDivs = doc.select("div.country");
        countries = new ArrayList<>();
        for(Element div : countryDivs)
        {
            Element countryName = div.select("h3.country-name").first();
            Element countryPopulation = div.select("div.country-info span.country-population").first();

            Element countryCapital = div.select("div.country-info span.country-capital").first();

            Element countryArea = div.select("div.country-info span.country-area").first();

            Country country = new Country(countryName.text(),countryCapital.text(), Integer.parseInt(countryPopulation.text()), Double.parseDouble(countryArea.text()));
            countries.add(country);
        }
    }

    public static void main(String[] args) {
}
