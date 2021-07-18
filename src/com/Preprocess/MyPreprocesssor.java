package com.Preprocess;


import javax.swing.*;

public class MyPreprocesssor
{
    public static void main(String[] args)
    {
        JTextArea text;
        String menu = "1. Choose a file to preprocess\n2. Quit";
        int option = GetData.getInt(menu);

        switch (option){
            case 1:
                Preprocessor p = new Preprocessor();
                p.isValid();
                p.isValid(Symbols.LEFT_PARENTHESIS,Symbols.RIGHT_PARENTHESIS);
                p.isValid(Symbols.LEFT_BRACE,Symbols.RIGHT_BRACE);
                p.isValid(Symbols.LEFT_BRACKET,Symbols.RIGHT_BRACKET);
                if(!p.getIsValid()) {
                    text = new JTextArea("File content: \n" + p.getFileContent() + "\n\n" + "There is a syntax error",10,50);
                }else{
                    text = new JTextArea("File content: \n" + p.getFileContent() + "\n\n" + "No syntax errors",10,50);
                }
                JScrollPane pane = new JScrollPane(text);
                JOptionPane.showMessageDialog(null, pane, "MyPreprocessor",JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Sorry that option is not defined, try a different one", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

}
