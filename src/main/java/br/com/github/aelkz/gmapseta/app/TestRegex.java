package br.com.github.aelkz.gmapseta.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void _main(String[] args) { // renamed for packing purposes (uncoment for testing)
        String source = "27,5 km\\\",0]\\n,[1836,\\\"31 min\\\"]\\n,null,null,null,[null,null,null,[null,null,[null,null,-15.7938408,-47.911347199999994]\\n,[null,null,-15.658040399999999,-47.801899999999996]\\n]\\n]\\n,null,null,[[1784,\\\"30 min\\\"]\\n,1,3,[1702,\\\"28 min\\\"]\\n,[1671,2030,\\\"28 - 34 min\\\"]\\n,[1819]\\n]\\n]\\n,[[[null,null,[27518,\\\"27,5 km\\\",0]\\n,[1838,\\\"31 min\\\"]\\n,null,null,\n";
        System.out.println(extractTime(source)[0]);
        System.out.println(extractTime(source)[1]);
    }

    public static String[] extractTime(String src) {
        System.out.println(src);
        // (\d{2,3}\smin)(.{1,20})(\d{2,3}\smin)
        Pattern p = Pattern.compile("(\\d{2,3}\\smin)(.{1,20})(\\d{2,3}\\smin)",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(src);
        String values[] = new String[]{"",""};
        if(m.find()) {
            System.out.println(m.group(1));
            System.out.println(m.group(3));
        }else {
            System.out.println("not match found.");
        }
        return values;
    }

}
