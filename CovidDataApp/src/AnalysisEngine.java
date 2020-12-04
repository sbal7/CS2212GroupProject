public class AnalysisEngine {

    double[]results;
    Country[]data;

    public AnalysisEngine(){

        results = new double[0];
    }
    public AnalysisEngine(Country[]dataArray){

        results = new double[dataArray.length];
        data = dataArray;
    }
    public double[] TotalCovidCases(){

        for (int i = 0; i < results.length; i++){
            results[i] = data[i].getCovidCases();
        }

        return results;
    }
    public double[] CasesPerCapita(){

        return results;
    }
    public double[] GrowthRate(){

        return results;
    }
    public double[] TotalMaleCases(){

        //Will need error handling for missing data

        return results;
    }
    public double[] TotalFemaleCases(){

        //Will need error handling for missing data

        return results;
    }
    public double[] MaleToFemaleRatio(){


        //Will need error handling for missing data

        return results;
    }

}
