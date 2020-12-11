package com.avsk.User;

import com.avsk.MainScreen;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

public class Login extends JFrame implements ActionListener, KeyListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private List<User> users;

    public Login(){
        //Get user list
        Users tempUsers = new Users();
        tempUsers.readUsers();
        users = tempUsers.getUsers();

        //Initialize frame and panel
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(460, 200);
        frame.setResizable(false);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(480, 200);
        Path path = FileSystems.getDefault().getPath(".");
        String imagePath = path.normalize().toAbsolutePath() + "\\braces_big.png";
        ImageIcon icon = new ImageIcon(imagePath);
        frame.setIconImage(icon.getImage());

        userTextField = new JTextField();
        passwordField = new JPasswordField();

        //Define label and textfield composition
        userNameLabel = new JLabel("Username/Email:");
        userNameLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        userNameLabel.setBounds(20, 20, 160, 30);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        passwordLabel.setBounds(20, 60, 160, 30);

        userTextField.setBounds(200, 20, 220, 30);
        userTextField.setFont(new Font("Calibri", Font.PLAIN, 17));
        passwordField.setBounds(200, 60, 220, 30);
        passwordField.setFont(new Font("Calibri", Font.PLAIN, 17));

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        loginButton.setVerticalTextPosition(SwingConstants.CENTER);
        loginButton.setFocusable(false);
        loginButton.setBackground(new Color(207, 207, 255));
        loginButton.setBounds(70, 100, 120, 40);
        loginButton.addActionListener((e) -> {
            checkUserName();
        });

        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        registerButton.setVerticalTextPosition(SwingConstants.CENTER);
        registerButton.setFocusable(false);
        registerButton.setBackground(new Color(207, 207, 255));
        registerButton.setBounds(210, 100, 120, 40);
        registerButton.addActionListener((e) -> {
            registerUser();
        });

        //Add components
        panel.add(userNameLabel);
        panel.add(passwordLabel);
        panel.add(userTextField);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);
        userTextField.addKeyListener(this);
        passwordField.addKeyListener(this);
        frame.add(panel);


        //Make frame visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void checkUserName(){
        //Check if user exists
        String name = userTextField.getText();
        String tempPassword = null;
        boolean userMatch = false;
        for(User user : users){
            if ((name.equals(user.getUserName())) || (name.equals(user.getEmail()))){
                userMatch = true;
                tempPassword = user.getPassword();
            }
        }
        if (userMatch){
            //Check if password is correct
            String password = new String(passwordField.getPassword());
            if (password.equals(tempPassword)){
                frame.dispose();
                MainScreen mainScreen = new MainScreen();
            }else{
                JOptionPane.showMessageDialog(null, "UserName or Password incorrect!", "Login Error", JOptionPane.ERROR_MESSAGE);
                passwordField.setText("");
            }
        }else{
            JOptionPane.showMessageDialog(null, "UserName or Password incorrect!", "Login Error", JOptionPane.ERROR_MESSAGE);
            passwordField.setText("");
        }
    }

    private void registerUser(){
        frame.dispose();
        RegisterUser register = new RegisterUser(users);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        switch (key) {
            default:
                if (key == KeyEvent.VK_ENTER) checkUserName();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
