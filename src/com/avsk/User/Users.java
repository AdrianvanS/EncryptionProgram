package com.avsk.User;

import javax.swing.*;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Users {

    List<User> users;
    HashMap<Character, Character> key;

    public Users(){
        users = new ArrayList<>();
        key = new HashMap<>();
        setKey();
//        readUsers();
    }

    public void addUser(String firstName, String lastName, String userName, String email, String password){
        User user = new User(firstName, lastName, userName, email, password);
        boolean check = userExists(user);
        if (!check){
            users.add(new User(firstName, lastName, userName, email, password));
        }else{
            System.out.println("User exists!");
        }
    }

    public List<User> getUsers(){
        return users;
    }

    public void setUsers(List<User> someUsers){
        users = someUsers;
    }

    private boolean userExists(User user){
        boolean result = false;
        String userName = user.getUserName();
        String email = user.getEmail();
        for (User x : users){
            if ((userName.equals(x.getUserName())) || (email.equals(x.getEmail()))) result = true;
            break;
        }
        return result;
    }

    //---------Read Users start-------------

    public void readUsers(){
        read();
    }

    private void read(){
        Path path = FileSystems.getDefault().getPath(".");
        String filePath = path.normalize().toAbsolutePath() + "\\users.dat";
        try(DataInputStream userFile = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)))){
            boolean eof = false;
            while (!eof){
                try{
                    //Decrypt firstName
                    String tempFirstName = userFile.readUTF();
                    String firstName = decrypt(tempFirstName);
                    //Decrypt lastName
                    String tempLastName = userFile.readUTF();
                    String lastName = decrypt(tempLastName);
                    //Decrypt userName
                    String tempUserName = userFile.readUTF();
                    String userName = decrypt(tempUserName);
                    //Decrypt email
                    String tempEmail = userFile.readUTF();
                    String email = decrypt(tempEmail);
                    //Decrypt password
                    String tempPassword = userFile.readUTF();
                    String password = decrypt(tempPassword);

                    //Add user
                    addUser(firstName, lastName, userName, email, password);
                }catch (EOFException e){
                    eof = true;
                }
            }
        }catch (IOException f){
            JOptionPane.showMessageDialog(null, "Error reading from file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //----------Read Users end--------------

    //---------Write Users start-------------

    public void writeUsers(){
        write();
    }

    private void write(){
        if (users.size() > 0){
            try (DataOutputStream userFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("users.dat")))){
                for (User user : users){
                    //Encrypt firstName
                    String tempFirstName = encrypt(user.getFirstName());
                    userFile.writeUTF(tempFirstName);
                    //Encrypt lastName
                    String tempLastName = encrypt(user.getLastName());
                    userFile.writeUTF(tempLastName);
                    //Encrypt userName
                    String tempUserName = encrypt(user.getUserName());
                    userFile.writeUTF(tempUserName);
                    //Encrypt email
                    String tempEmail = encrypt(user.getEmail());
                    userFile.writeUTF(tempEmail);
                    //Encrypt password
                    String tempPassword = encrypt(user.getPassword());
                    userFile.writeUTF(tempPassword);
                }
            }catch (IOException e){
                JOptionPane .showMessageDialog(null, "Error writing data to file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane .showMessageDialog(null, "No users to save to file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //----------Write Users end--------------

    private String encrypt(String s){
        char[] a = s.toCharArray();
        StringBuilder newText = new StringBuilder("");
        for (char c : a){
            for (Character x : key.keySet()){
                if (c == x) newText.append(key.get(x));
            }
        }
        return newText.toString();
    }

    private String decrypt(String s){
        char[] letters = s.toCharArray();
        StringBuilder newText = new StringBuilder("");
        for (char c : letters){
            for (Character x : key.keySet()){
                if (c == key.get(x)) newText.append(x);
            }
        }
        return newText.toString();
    }

    private void setKey(){
        String listString = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        String keyString = "cp$&n;8K<|GYi4,IUQ0~sg(R/}t=]k'J\"b_*%d#{wDAzuSf2LoE[\\^:Wv3mH6+aNh9`l 7V-xBTPreq!FXy.)CM@j?>Z15O";
        char[] listArray = listString.toCharArray();
        char[] keyArray = keyString.toCharArray();
        for (int i = 0; i < keyArray.length; i++){
            key.put(listArray[i], keyArray[i]);
        }

    }
}
