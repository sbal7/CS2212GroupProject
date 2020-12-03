public class Country {

    private String name;
    private int CovidCases;
    private int [] Coordinates;
    private int CovidMale;
    private int CovidFemale;
    private int CovidWeekAgo;
    private int CovidYesterday;

    public Country(){

        name = "";
        Coordinates = new int[]{0,0};
        CovidCases = 0;
        CovidFemale = 0;
        CovidMale = 0;
        CovidWeekAgo = 0;
        CovidWeekAgo = 0;

    }
    public Country(String Nm, int C19Cases, int [] coordinates, int covidMale, int covidFemale, int covidWeekAgo, int covidYesterday ){

        name = Nm;
        CovidCases = C19Cases;
        CovidYesterday = covidYesterday;
        CovidWeekAgo = covidWeekAgo;
        CovidMale = covidMale;
        CovidFemale = covidFemale;
        Coordinates = coordinates;

    }
    public void setName(String Nm){
        name = Nm;
    }
    public String getName(){
        return name;
    }
    public void setCovidCases(int C19Cases){

        CovidCases = C19Cases;
    }
    public int getCovidCases(){
        return CovidCases;
    }

    public int getCovidFemale() {
        return CovidFemale;
    }

    public int getCovidMale() {
        return CovidMale;
    }

    public int getCovidWeekAgo() {
        return CovidWeekAgo;
    }

    public int getCovidYesterday() {
        return CovidYesterday;
    }

    public int[] getCoordinates() {
        return Coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        Coordinates = coordinates;
    }

    public void setCovidFemale(int covidFemale) {
        CovidFemale = covidFemale;
    }

    public void setCovidMale(int covidMale) {
        CovidMale = covidMale;
    }

    public void setCovidWeekAgo(int covidWeekAgo) {
        CovidWeekAgo = covidWeekAgo;
    }

    public void setCovidYesterday(int covidYesterday) {
        CovidYesterday = covidYesterday;
    }
}

