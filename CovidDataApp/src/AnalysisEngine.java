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

        for (int i = 0; i < results.length; i++)
        {
            results[i] = data[i].getCovidCases();
            
        }
        
        return results;
    }
    public double[] CasesPerCapita(){
    	for(int i = 0; i < results.length; i++)
    	{
    		results[i] = data[i].getCovidCases() / data[i].getPopulation();
    	
    	}
        return results;
    }
    public double[] GrowthRate(){
    	for (int i = 0; i < results.length; i++)
    	{
    		results[i] = ((data[i].getCovidCases() - data[i].getCovidWeekAgo())/data[i].getCovidWeekAgo() *100)/10;
    	}
    	
        return results;
    }
    public double[] TotalMaleCases(){
    	for(int i = 0; i < results.length; i++) {
    		results[i] = data[i].getCovidMale();
    		
    	}
        

        return results;
    }
    public double[] TotalFemaleCases(){
    	for(int i = 0; i < results.length; i++)
    		results[i] = data[i].getCovidFemale();

  

        return results;
    }
  
    
    public double[] MalePerCapita() {
    	for(int i = 0; i < results.length; i++)
    	{
    		results[i] = data[i].getCovidMale() / data[i].getPopulation();
    	
    	}
        return results;
    	
    }
    
    public double[] FemalePerCapita() {
    	for(int i = 0; i < results.length; i++)
    	{
    		results[i] = data[i].getCovidFemale() / data[i].getPopulation();
    	
    	}
        return results;
    	
    }
    
    public double[] GrowthRateOneDay() {
        for (int i = 0; i < results.length; i++) 
        {
            results[i] = ((data[i].getCovidCases()-data[i].getCovidYesterday())/data[i].getCovidYesterday() * 100)/10;
        }
        return results;
    }
    
	public double[] proportionCalc(double[]results) {
		
		double[] proportions = new double[results.length];
    	for(int i =1; i < results.length; i++) 
        {
        	double smallest = results[0];
        	if (results[i] < smallest)
        		smallest = results[i];
        		
        		for(int j = 0; j <results.length; j++)
        		{
        			
        			proportions[j] = results[j] / smallest;
        			
        		}
        }	
    	return (proportions);
	}
}