package com.avsk.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

public class RegisterUser extends JFrame implements ActionListener {

    private List<User> users;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

    private JFrame frame;
    private JPanel panel;

    JLabel firstNameLabel;
    JLabel lastNameLabel;
    JLabel userNameLabel;
    JLabel emailLabel;
    JLabel passwordLabel;

    JTextField firstNameField;
    JTextField lastNameField;
    JTextField userNameField;
    JTextField emailField;
    JTextField passwordField;

    JButton registerButton;
    JButton cancelButton;

    //Validation
    private boolean validFirstName;
    private JLabel fNameValidLabel;

    private boolean validLastName;
    private JLabel lNameValidLabel;

    private boolean validUserName;
    private JLabel userNameValidLabel;

    private boolean validEmail;
    private JLabel emailValidLabel;

    private boolean validPassword;
    private JLabel passwordValidLabel;

    public RegisterUser(List<User> users){
        this.users = users;



        frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Register New User");
        frame.setSize(500, 500);
        Path path = FileSystems.getDefault().getPath(".");
        String imagePath = path.normalize().toAbsolutePath() + "\\braces_big.png";
        ImageIcon icon = new ImageIcon(imagePath);
        frame.setIconImage(icon.getImage());
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        validFirstName = false;
        fNameValidLabel = new JLabel("Should only contain letters!");
        fNameValidLabel.setFont(new Font("Calibri", Font.PLAIN, 10));
        fNameValidLabel.setBounds(310, 55, 170, 30);
        fNameValidLabel.setVisible(false);
        panel.add(fNameValidLabel);

        validLastName = false;
        lNameValidLabel = new JLabel("Should only contain letters!");
        lNameValidLabel.setFont(new Font("Calibri", Font.PLAIN, 10));
        lNameValidLabel.setBounds(310, 115, 170, 30);
        lNameValidLabel.setVisible(false);
        panel.add(lNameValidLabel);

        validUserName = false;
        userNameValidLabel = new JLabel("No spaces allowed!");
        userNameValidLabel.setFont(new Font("Calibri", Font.PLAIN, 10));
        userNameValidLabel.setBounds(345, 175, 170, 30);
        userNameValidLabel.setVisible(false);
        panel.add(userNameValidLabel);

        validEmail = false;
        emailValidLabel = new JLabel("Must contain an '@'");
        emailValidLabel.setFont(new Font("Calibri", Font.PLAIN, 10));
        emailValidLabel.setBounds(340, 235, 160, 30);
        emailValidLabel.setVisible(false);
        panel.add(emailValidLabel);

        //----------------Labels start----------------

        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        firstNameLabel.setBounds(60, 30, 160, 30);
        panel.add(firstNameLabel);

        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        lastNameLabel.setBounds(60, 90, 160, 30);
        panel.add(lastNameLabel);

        userNameLabel = new JLabel("Username:");
        userNameLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        userNameLabel.setBounds(60, 150, 160, 30);
        panel.add(userNameLabel);

        emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        emailLabel.setBounds(60, 210, 160, 30);
        panel.add(emailLabel);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        passwordLabel.setBounds(60, 270, 160, 30);
        panel.add(passwordLabel);

        //-----------------Labels end-----------------

        //----------------TextFields start----------------

        firstNameField = new JTextField();
        firstNameField.setBounds(200, 30, 220, 30);
        firstNameField.setFont(new Font("Calibri", Font.PLAIN, 17));
        firstNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (firstNameField.getText().length() > 20){
                    fNameValidLabel.setText("Too many characters!");
                    fNameValidLabel.setVisible(true);
                }else{
                    fNameValidLabel.setText("Should only contain letters!");
                    boolean valid = checkFirstName();
                    validFirstName = valid;
                    if (!validFirstName) {
                        fNameValidLabel.setVisible(true);
                    }else{
                        fNameValidLabel.setVisible(false);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (firstNameField.getText().length() > 20){
                    fNameValidLabel.setText("Too many characters!");
                    fNameValidLabel.setVisible(true);
                }else{
                    fNameValidLabel.setText("Should only contain letters!");
                    boolean valid = checkFirstName();
                    validFirstName = valid;
                    if (!validFirstName) {
                        fNameValidLabel.setVisible(true);
                    }else{
                        fNameValidLabel.setVisible(false);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        panel.add(firstNameField);

        //--------------------------------------------------------------------

        lastNameField = new JTextField();
        lastNameField.setBounds(200, 90, 220, 30);
        lastNameField.setFont(new Font("Calibri", Font.PLAIN, 17));
        lastNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (lastNameField.getText().length() > 20){
                    lNameValidLabel.setText("Too many characters!");
                    lNameValidLabel.setVisible(true);
                }else{
                    lNameValidLabel.setText("Should only contain letters!");
                    boolean valid = checkLastName();
                    validLastName = valid;
                    if (!validLastName) {
                        lNameValidLabel.setVisible(true);
                    }else{
                        lNameValidLabel.setVisible(false);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (lastNameField.getText().length() > 20){
                    lNameValidLabel.setText("Too many characters!");
                    lNameValidLabel.setVisible(true);
                }else{
                    lNameValidLabel.setText("Should only contain letters!");
                    boolean valid = checkLastName();
                    validLastName = valid;
                    if (!validLastName) {
                        lNameValidLabel.setVisible(true);
                    }else{
                        lNameValidLabel.setVisible(false);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        panel.add(lastNameField);

        //--------------------------------------------------------------------

        userNameField = new JTextField();
        userNameField.setBounds(200, 150, 220, 30);
        userNameField.setFont(new Font("Calibri", Font.PLAIN, 17));
        userNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                boolean valid = checkUserName();
                validUserName = valid;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        panel.add(userNameField);

        //--------------------------------------------------------------------

        emailField = new JTextField();
        emailField.setBounds(200, 210, 220, 30);
        emailField.setFont(new Font("Calibri", Font.PLAIN, 17));
        emailField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                boolean valid = checkEmailAddress();
                validEmail = valid;
                if (!valid){
                    emailValidLabel.setVisible(true);
                }else{
                    emailValidLabel.setVisible(false);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                boolean valid = checkEmailAddress();
                validEmail = valid;
                if (!valid){
                    if (emailField.getText().length() == 0){
                        emailValidLabel.setVisible(false);
                    }else{
                        emailValidLabel.setVisible(true);
                    }
                }else{
                    emailValidLabel.setVisible(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        panel.add(emailField);

        //--------------------------------------------------------------------

        passwordField = new JTextField();
        passwordField.setBounds(200, 270, 220, 30);
        passwordField.setFont(new Font("Calibri", Font.PLAIN, 17));
        panel.add(passwordField);

        //-----------------TextFields end-----------------

        //----------------Buttons start----------------

        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        registerButton.setVerticalTextPosition(SwingConstants.CENTER);
        registerButton.setFocusable(false);
        registerButton.setBackground(new Color(207, 207, 255));
        registerButton.setBounds(100, 350, 120, 40);
        panel.add(registerButton);
        registerButton.setEnabled(false);
        registerButton.addActionListener((e) -> {

        });

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        cancelButton.setVerticalTextPosition(SwingConstants.CENTER);
        cancelButton.setFocusable(false);
        cancelButton.setBackground(new Color(207, 207, 255));
        cancelButton.setBounds(250, 350, 120, 40);
        panel.add(cancelButton);
        cancelButton.addActionListener((e) -> {
            frame.dispose();
            Login login = new Login();
        });


        //-----------------Buttons end-----------------

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private boolean checkFirstName(){
        String fName = firstNameField.getText();
        fName =  fName.replaceAll("[a-zA-Z ]", "");
        if (fName.length() > 0){
            return false;
        }else{
            return true;
        }
    }

    private boolean checkLastName(){
        String lName = lastNameField.getText();
        lName =  lName.replaceAll("[a-zA-Z ]", "");
        if (lName.length() > 0){
            return false;
        }else{
            return true;
        }
    }

    private boolean checkUserName(){
        String uName = userNameField.getText();
        uName = uName.replaceAll("[^ ]", "");
        if (uName.length() > 0){
            return false;
        }else{
            return true;
        }
    }

    private boolean checkEmailAddress(){
        boolean result = false;
        char[] letters = emailField.getText().toCharArray();
        for (char c : letters){
            if (c == '@') result = true;
        }
        return result;
    }
}
