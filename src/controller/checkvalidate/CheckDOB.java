package controller.checkvalidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckDOB {
    private static Pattern pattern;
    private static final String DOB_REGEX = "(?:0[1-9]|[12][0-9]|3[01])[-/.](?:0[1-9]|1[012])[-/.](?:19\\d{2}|20[01][0-9]|2020)\\b";

    public CheckDOB(){
        pattern = Pattern.compile(DOB_REGEX);
    }

    public boolean validate(String regex){
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
