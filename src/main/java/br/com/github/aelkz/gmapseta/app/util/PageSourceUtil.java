package br.com.github.aelkz.gmapseta.app.util;

public class PageSourceUtil {

    /**
     * Apply a fix for kilometers value in case of not finding the correct index value.
     * Google maps application switches route in 0.1 depending on page load. (weird)
     * http://stackoverflow.com/questions/15625556/java-adding-and-subtracting-doubles-are-giving-strange-results
     * @param htmlSource
     * @param kilometers
     * @return
     */
    public static int getStartIndex(String htmlSource, Double kilometers) {
        int index = 0;
        double kilometers_fix = kilometers-0.1;

        System.out.println("step A:"+kilometers);
        index = htmlSource.indexOf(getKilometersAsText(kilometers));
        if (index == -1) {
            System.out.println("step B:"+kilometers_fix);
            index = htmlSource.indexOf(getKilometersAsText(kilometers_fix));
        }
        return index;
    }

    /**
     * Convert double value of kilometers as text description
     * @param kilometers
     * @return
     */
    public static String getKilometersAsText(Double kilometers) {
        String text = String.valueOf(kilometers)+" km";
        return text.replace('.',',');
    }

}
