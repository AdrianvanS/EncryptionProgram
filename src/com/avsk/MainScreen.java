package com.avsk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class MainScreen extends JFrame implements ActionListener {

    //Key: !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}~
    //Key:29S'fOsP@C#KH<0DwrZq]{lbt\4-VLB`mIF.)oM1%+&;^jge k7W>8?aXA_=p6i}Unc3Y[G/Ju|*:d,(!xER~NTQ$vyz5h"

    JFrame mainFrame;
    JButton encryptButton;
    JButton decryptButton;
    JButton clearEncrypt;
    JButton clearDecrypt;
    HashMap<Character, Character> key;
    JTextArea left;
    JTextArea right;

    public MainScreen() {
        key = new HashMap<>();
        setKey();
//        printKey();
        mainFrame = new JFrame();
        mainFrame.setTitle("Encryption Program");
        ImageIcon image = new ImageIcon("braces_big.png");
        mainFrame.setIconImage(image.getImage());

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 0, 0));

        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new GridLayout(1, 6, 0, 0));
        labelsPanel.setPreferredSize(new Dimension(1000, 500));

        //-------------Buttons---------------------
        encryptButton = new JButton("Encrypt");
        encryptButton.setFocusable(false);
        encryptButton.addActionListener((e) ->{
            encrypt();
        });
        decryptButton = new JButton("Decrypt");
        decryptButton.setFocusable(false);
        decryptButton.addActionListener((e) ->{
            decrypt();
        });
        clearEncrypt = new JButton("Clear");
        clearEncrypt.setFocusable(false);
        clearEncrypt.addActionListener((e) -> {left.setText("");});

        clearDecrypt = new JButton("Clear");
        clearDecrypt.setFocusable(false);
        clearDecrypt.addActionListener((e) -> {right.setText("");});


        buttonsPanel.add(encryptButton);
        buttonsPanel.add(clearEncrypt);
        buttonsPanel.add(decryptButton);
        buttonsPanel.add(clearDecrypt);
        //-------------Buttons---------------------

        left = new JTextArea();

//        JScrollPane scrollLeft = new JScrollPane(left, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane scrollLeft = new JScrollPane(left, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        left.setFont(new Font("Calibri", Font.PLAIN, 18));
        left.setWrapStyleWord(true);
        left.setLineWrap(true);
        left.setEditable(true);
        left.setBackground(Color.lightGray);

        right = new JTextArea();
        JScrollPane scrollRight = new JScrollPane(right, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        right.setFont(new Font("Calibri", Font.PLAIN, 18));
        right.setEditable(true);
        right.setWrapStyleWord(true);
        right.setLineWrap(true);
        right.setBackground(Color.white);

        labelsPanel.add(scrollLeft);
        labelsPanel.add(scrollRight);

        content.add(buttonsPanel, BorderLayout.NORTH);
        content.add(labelsPanel, BorderLayout.CENTER);

        mainFrame.setContentPane(content);

        mainFrame.setSize(1000, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void setKey(){
        String listString = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        String keyString = "gzEa,sY%7?PH8K|)(Z1xQ{/t_j\"\\.D5JB4#&SCe;M*2:m-]hw@=9bki>6pXRV0LUIFo+` Gn!r$3AulO'dcqyv~<N^f[T}W";
        char[] listArray = listString.toCharArray();
        char[] keyArray = keyString.toCharArray();
        for (int i = 0; i < keyArray.length; i++){
            key.put(listArray[i], keyArray[i]);
        }

    }

    private void printKey(){
        for (Character c : key.keySet()){
            System.out.print(c + " -> " + key.get(c) + "\n");
        }
    }



    private void encrypt(){

        String text = left.getText();
        right.setText("");
        char[] letters = text.toCharArray();
        StringBuilder newText = new StringBuilder("");
        for (char c : letters){
            for (Character x : key.keySet()){
                if (c == x ) newText.append(key.get(x));
            }
        }
        String result = newText.toString();
        right.setText(result);
    }

    private void decrypt(){
        String text = right.getText();
        left.setText("");
        char[] letters = text.toCharArray();
        StringBuilder newText = new StringBuilder("");
        for (char c : letters){
            for (Character x : key.keySet()){
                if (c == key.get(x)) newText.append(x);
            }
        }
        String result = newText.toString();
        left.setText(result);

    }
}
