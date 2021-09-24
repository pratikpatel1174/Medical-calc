package com.medical.calculator.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class FormulaUtil {

	//False Positive Rate
	public static Map<String,BigDecimal> getFalsePositiveRate(Long param1,Long param2) {
		
		 BigDecimal falsePositive=BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(param2)).multiply(BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(param1)));
		 BigDecimal trueNegative=BigDecimal.valueOf(param2).multiply(BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(param2)));
		// BigDecimal falseNegativeRate=BigDecimal.valueOf(100).multiply(falsePositive).divide(falsePositive.add(trueNegative));
		
		Map<String,BigDecimal> falsePositiveRateResultMap=new HashMap<>();
		falsePositiveRateResultMap.put("False Positive", falsePositive);
		falsePositiveRateResultMap.put("True Negative", trueNegative);
		//falsePositiveRateResultMap.put("False Positive Rate", falseNegativeRate);
		
		return falsePositiveRateResultMap;
	}
	
	//False Negative Rate
	public static Map<String,BigDecimal> getFalseNegativeRate(Long param1,Long param2){
		
		BigDecimal falsenegative = BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(param2)).multiply(BigDecimal.valueOf(param1));
		BigDecimal truepositive = BigDecimal.valueOf(param2).multiply(BigDecimal.valueOf(param1));
		//BigDecimal pretestodds =  BigDecimal.valueOf(param1).divide(BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(param1)));
		BigDecimal pretestodds =  BigDecimal.valueOf(param1).divide(BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(param1)), 3, RoundingMode.HALF_UP);
		/*BigDecimal falsenegativerate = (BigDecimal.valueOf(100).multiply(falsenegative)).divide(BigDecimal.valueOf(truepositive.add(falsenegative)));*/
		BigDecimal falsenegativerate = (BigDecimal.valueOf(100).multiply(falsenegative)).divide((truepositive.add(falsenegative)));
		
		Map<String,BigDecimal> falseNegativeRateResultMap = new HashMap<>();
		falseNegativeRateResultMap.put("False Negative", falsenegativerate);
		falseNegativeRateResultMap.put("True Positive", truepositive);
		falseNegativeRateResultMap.put("Pre Test Odds", pretestodds);
		falseNegativeRateResultMap.put("False Negative Rate", falsenegative);
		
		return falseNegativeRateResultMap;
	}
	
	//Prevalence Rate
	public static Map<String,BigDecimal> getPrevelanceRate(Long param1,Long param2) {
		
		BigDecimal prevelancerate=(BigDecimal.valueOf(param1).divide(BigDecimal.valueOf(param2), 3, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100));
		
		Map<String,BigDecimal> prevelanceRate=new HashMap<>();
		prevelanceRate.put("Prevalence Rate", prevelancerate);
		return prevelanceRate;
	}
	
	//IncidenceRate 
	public static Map<String,BigDecimal> getIncidenceRate(Long param1,Long param2,Long param3){
		
		BigDecimal incidencerate = ((BigDecimal.valueOf(param1).divide(BigDecimal.valueOf(param2), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(param3))));
		Map<String,BigDecimal> incidenceRate=new HashMap<>();
		incidenceRate.put("Incidence Rate", incidencerate);
		
		return incidenceRate;
	}
}
