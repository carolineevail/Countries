/**
 * Created by Caroline on 2/11/16.
 */
public class Country {
    private String countryName;
    private String countryAbbreviation;

    public Country(String countryName, String countryAbbreviation) {
        this.countryName = countryName;
        this.countryAbbreviation = countryAbbreviation;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countryAbbreviation='" + countryAbbreviation + '\'' +
                '}';
    }
}

