package br.com.github.aelkz.gmapseta.app.util;

import java.math.BigDecimal;

public class PageSourceUtil {

    /**
     * Apply a fix for kilometers value in case of not finding the correct index value.
     * Google maps application switches route in 0.1 depending on page load. (weird)
     * http://stackoverflow.com/questions/15625556/java-adding-and-subtracting-doubles-are-giving-strange-results
     * http://stackoverflow.com/questions/322749/retain-precision-with-double-in-java
     * @param htmlSource
     * @param kilometers
     * @return
     */
    public static int getStartIndex(String htmlSource, BigDecimal kilometers) {
        int index = 0;

        // http://stackoverflow.com/questions/7186204/bigdecimal-to-use-new-or-valueof
        //BigDecimal bd1 = new BigDecimal("29.2");
        //System.out.println(bd1.subtract(new BigDecimal("0.1")));

        index = htmlSource.indexOf(getKilometersAsText(kilometers));
        if (index == -1) {
            index = htmlSource.indexOf(getKilometersAsText((kilometers.subtract(BigDecimal.valueOf(0.1)))));
        }
        return index;
    }

    /**
     * Convert double value of kilometers as text description
     * @param kilometers
     * @return
     */
    public static String getKilometersAsText(BigDecimal kilometers) {
        String text = String.valueOf(kilometers)+" km";
        return text.replace('.',',');
    }

}
