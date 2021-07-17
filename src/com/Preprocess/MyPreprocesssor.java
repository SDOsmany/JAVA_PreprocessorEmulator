package com.Preprocess;

public class MyPreprocesssor
{
    public static void main(String[] args)
    {
        Preprocessor p = new Preprocessor();
        p.isValid();
        System.out.println("this is the /*"+p.getIsValid());
        p.isValid(Symbols.LEFT_PARENTHESIS,Symbols.RIGHT_PARENTHESIS);
        System.out.println("this is the ()"+p.getIsValid());
        p.isValid(Symbols.LEFT_BRACE,Symbols.RIGHT_BRACE);
        System.out.println("this is the {}"+p.getIsValid());
        p.isValid(Symbols.LEFT_BRACKET,Symbols.RIGHT_BRACKET);
        System.out.println("this is the []"+p.getIsValid());
    }
}
