package ua.lviv.iot.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HyphenToUnderscoreParser {

    private static final String HYPHEN_INSIDE_WORDS_REGEX = "(?<=\\w)-+(?=\\w)";
    private static final String UNDERSCORE = "_";

    public String parse(String input){
        if(input == null) throw new IllegalArgumentException();
        return parse(input, input.length());
    }

    public String parse(String input, int indexToCheckExclusive){
        if(input == null) throw new IllegalArgumentException();

        Pattern pattern = Pattern.compile(HYPHEN_INSIDE_WORDS_REGEX);
        Matcher matcher = pattern.matcher(input);
        StringBuilder builder = new StringBuilder(input);
        while(matcher.find() && matcher.end() < indexToCheckExclusive){
            builder.replace(matcher.start(), matcher.end(), UNDERSCORE);
        }

        return builder.toString();
    }

    public void parseToStdOut(String input){
        System.out.print(parse(input));
    }


    public void parseToStdOut(String input, int indexToCheckExclusive){
        System.out.print(parse(input, indexToCheckExclusive));
    }
}
