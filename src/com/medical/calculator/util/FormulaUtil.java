package com.medical.calculator.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FormulaUtil {

	
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
}
