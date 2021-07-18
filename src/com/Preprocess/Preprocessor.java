package com.Preprocess;

import javax.swing.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class Preprocessor
{
    Stack s;
    BasicFile bf;
    private boolean isValid = true;
    private String fileContent = "";

    public Preprocessor()
    {
        this.s = new Stack();
        this.bf = new BasicFile();
        this.fileContent = this.bf.readFile();

    }

    public String getFileContent(){
        return fileContent;
    }

    public boolean isValid()
    {
        for (int count = 0; count < this.fileContent.length(); count++)
        {
            char character = this.fileContent.charAt(count);
            try
            {
                if (character == Symbols.FORWARD_SLASH && this.fileContent.charAt(count + 1) == Symbols.STAR)
                {
                    s.push(Symbols.STAR);

                }else if(character == Symbols.FORWARD_SLASH && this.fileContent.charAt(count - 1) == Symbols.STAR)
                {
                    try
                    {
                        s.pop();
                    } catch (EmptyStackException e)
                    {
                        this.isValid = false;
                    }
                }
            } catch (IndexOutOfBoundsException e)
            {
                continue;
            }
        }

        //If there is anything inside of the stack we know
        //the symbols are not balanced
        if (!s.isEmpty())
        {
            isValid = false;
        }

        return this.isValid;
    }


    public boolean isValid(char left, char right)
    {
        for (int count = 0; count < fileContent.length(); count++)
        {
            char character = fileContent.charAt(count);
            if (character == left)
            {
                s.push(character);
            }else if(character == right)
                    try
                    {
                        s.pop();
                    } catch (EmptyStackException e)
                    {
                        this.isValid = false;
                    }
            }
        //If there is anything inside of the stack we know
        //the symbols are not balanced
        if (!s.isEmpty())
        {
            isValid = false;
        }

        return isValid;
    }

    public boolean getIsValid(){
        return this.isValid;
    }
    void display(String msg, String s, int t)
    {
        JOptionPane.showMessageDialog(null, msg, s, t);
    }
}
