public class Country {

    private String name;
    private int CovidCases;
    private double[] Coordinates;
    private double CovidMale;
    private double CovidFemale;
    private int CovidWeekAgo;
    private int CovidYesterday;
    private int Population;

    public Country() {

        name = "";
        Coordinates = new double[]{0.0, 0.0};
        CovidCases = 0;
        CovidFemale = 0;
        CovidMale = 0;
        CovidWeekAgo = 0;
        CovidWeekAgo = 0;
        Population = 0;

    }

    public Country(String Nm, int C19Cases, double[] coordinates, double covidMale, double covidFemale, int covidWeekAgo, int covidYesterday, int Pop) {

        name = Nm;
        CovidCases = C19Cases;
        CovidYesterday = covidYesterday;
        CovidWeekAgo = covidWeekAgo;
        CovidMale = covidMale;
        CovidFemale = covidFemale;
        Coordinates = coordinates;
        Population = Pop;

    }

    public void setName(String Nm) {
        name = Nm;
    }

    public String getName() {
        return name;
    }

    public void setCovidCases(int C19Cases) {

        CovidCases = C19Cases;
    }

    public int getCovidCases() {
        return CovidCases;
    }

    public double getCovidFemale() {
        return CovidFemale;
    }

    public double getCovidMale() {
        return CovidMale;
    }

    public int getCovidWeekAgo() {
        return CovidWeekAgo;
    }

    public int getCovidYesterday() {
        return CovidYesterday;
    }

    public double[] getCoordinates() {
        return Coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        Coordinates = coordinates;
    }

    public void setCovidFemale(double covidFemale) {
        CovidFemale = covidFemale;
    }

    public void setCovidMale(double covidMale) {
        CovidMale = covidMale;
    }

    public void setCovidWeekAgo(int covidWeekAgo) {
        CovidWeekAgo = covidWeekAgo;
    }

    public void setCovidYesterday(int covidYesterday) {
        CovidYesterday = covidYesterday;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public int getPopulation() {
        return Population;
    }
}

