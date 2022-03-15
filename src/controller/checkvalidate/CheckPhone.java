package controller.checkvalidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPhone {
    private static Pattern pattern;
    private static final String PHONE_REGEX = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";

    public CheckPhone(){
        pattern = Pattern.compile(PHONE_REGEX);
    }

    public boolean validate(String regex){
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
