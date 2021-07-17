package com.Preprocess;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.*;


public class BasicFile {
    //reference variable to store the chosen file
    File f;
    private String fContent ="";

    /**
     * Parameterless constructor
     * Uses JFileChooser to allow user to select a file
     * from the root directory of the program
     */
    public BasicFile(){
        JFileChooser choose = new JFileChooser(".");
        int status = choose.showOpenDialog(null);

        try{
            if(status != JFileChooser.APPROVE_OPTION)
                throw new IOException();

            f = choose.getSelectedFile();

            if(!f.exists())
                throw new FileNotFoundException();

            display(f.getName(),"File has been chosen", JOptionPane.INFORMATION_MESSAGE);
        }catch (FileNotFoundException e){

            display("File not found ...", e.toString(), JOptionPane.WARNING_MESSAGE);

        } catch (IOException e){

            display("Approve option was not selected", e.toString(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public String readFile(){
        String read = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(this.f));
            while((read = br.readLine()) != null) {
                this.fContent += read;
            }

            br.close();
        }catch(FileNotFoundException e){
            display("File was not found\nerror message: "+e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
        }catch (IOException e){
            display("Input error\nerror message: "+e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return this.fContent;
    }

    public File getFile(){
        return this.f;
    }

    void display(String msg, String s, int t) {
        JOptionPane.showMessageDialog(null, msg, s, t);
    }
}

