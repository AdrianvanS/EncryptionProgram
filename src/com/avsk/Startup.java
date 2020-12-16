package com.avsk;

import com.avsk.User.Login;
import com.avsk.User.RegisterUser;
import com.avsk.User.User;
import com.avsk.User.Users;

import javax.swing.*;
import java.util.List;

public class Startup {

    public static void main(String[] args) {

        Startup start = new Startup();
        Splash2 splash2 = new Splash2();
        splash2.setStart(start);
//        Users users = new Users();
//        users.readUsers();
//        RegisterUser register = new RegisterUser(users.getUsers());

    }

    public void discardFrame(JFrame frame){
        frame.dispose();
        Login login = new Login();

    }
}
