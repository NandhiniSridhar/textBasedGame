package com.company;
import javax.swing.*;
import java.awt.*;

public class Terminal {
    JFrame frame;

    Terminal(){
        frame = new JFrame("Console!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        //createInternal();
        writeText("hii");
        frame.setVisible(true);
    }

    public void playGame(){
        System.out.print("in playGame()");
        writeText("hi");
        System.out.println("returning");
        return;
    }

    public void writeText(String write){
        System.out.println("in writeText");
        JLabel prompt = new JLabel("TextOnlyLabel");
        //JTextField text = new JTextField(50);
        prompt.setText(write);
        JPanel p = new JPanel();
        p.add(prompt);
        frame.add(p);
        return;
    }

    private void createInternal(){
        JLabel prompt = new JLabel("TextOnlyLabel");
        //JTextField text = new JTextField(50);
        prompt.setText("Enter character name");

        JPanel p = new JPanel();
        p.add(prompt);
        frame.add(p);
        //frame.getContentPane().add(text);
    }
}//class Terminal
