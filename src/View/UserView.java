package View;

import Controller.HFinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UserView implements ActionListener {
    private HFinder controller;
    private boolean auth;
    private int authId;
    private int hotelId;
    private int currFrame; //0 - Base; 1- login; 2- register; 3- listingHotels
    private JFrame main;

    //Login/registo menu
    private JLabel username;
    private JLabel password;
    private JLabel confPassword;
    private JLabel email;
    private JLabel telemovel;
    private JLabel erro;
    private JLabel success;
    private JLabel editPTitle;
    private JLabel loginTitle;
    private JLabel registerTitle;

    private JTextField usernameText;
    private JPasswordField passwordText;
    private JPasswordField confPasswordText;
    private JTextField emailText;
    private JTextField telemovelText;
    //edit
    private JLabel usernameCurr ;
    private JLabel passwordCurr;
    private JLabel emailCurr;
    private JLabel telemovelCurr;

    private JButton confirm;
    private JButton back;
    private JLabel moreInfoTitle;

    //Listagem Hotel
    private JLabel listingHotelsTitle;
    private JButton select;

    private JPanel panel;
    private JList<String> listAux1;

    //Listagem likes
    private JLabel listingHotelsTitleL;
    private JButton deleteL;

    private JPanel panelL;
    private JList<String> listAux1L;

    //+info

    private JLabel location, description, type, capacity, likes;
    private JLabel locationt, descriptiont, typet, capacityt, likest;
    private JButton addFav;

    public UserView(int currFrame, HFinder controller, boolean auth,int authId) throws IOException {
        this.authId = authId;

        this.auth = auth;
        this.controller = controller;
        this.currFrame = currFrame;

        main = new JFrame("HFinder");
        main.setSize(720,760);
        main.setLayout(null);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main.setResizable(false);
        main.setVisible(true);



        //--------------------------login/registo/editar--------------------------


        editPTitle = new JLabel("Editar Perfil");
        editPTitle.setFont(new Font("Calibri", Font.BOLD, 30));
        editPTitle.setBounds(300,40,300,50);
        main.add(editPTitle);

        loginTitle = new JLabel("Login");
        loginTitle.setFont(new Font("Calibri", Font.BOLD, 30));
        loginTitle.setBounds(320,40,300,50);
        main.add(loginTitle);

        registerTitle = new JLabel("Registo");
        registerTitle.setFont(new Font("Calibri", Font.BOLD, 30));
        registerTitle.setBounds(300,40,300,50);
        main.add(registerTitle);

        confirm = new JButton("Confirmar");
        confirm.setBounds(395,450,200,50);
        confirm.addActionListener(this);
        main.add(confirm);

        back = new JButton("Voltar");
        back.setBounds(100,450,200,50);
        back.addActionListener(this);
        main.add(back);

        username = new JLabel("Nome de Usuário:");
        username.setBounds(150,150,200,30);
        main.add(username);
        usernameText = new JTextField();
        usernameText.setBounds(290,150,200,30);
        main.add(usernameText);

        password = new JLabel("Password:");
        password.setBounds(150,175,200,30);
        main.add(password);
        passwordText = new JPasswordField();
        passwordText.setBounds(290,175,200,30);
        main.add(passwordText);

        confPassword = new JLabel("Confirme Password:");
        confPassword.setBounds(150,200,200,30);
        main.add(confPassword);
        confPasswordText = new JPasswordField();
        confPasswordText.setBounds(290,200,200,30);
        main.add(confPasswordText);


        email = new JLabel("Email:");
        email.setBounds(150,225,200,30);
        main.add(email);
        emailText = new JTextField();
        emailText.setBounds(290,225,200,30);
        main.add(emailText);

        telemovel = new JLabel("Número de Telemovel:");
        telemovel.setBounds(150,250,200,30);
        main.add(telemovel);
        telemovelText = new JTextField();
        telemovelText.setBounds(290,250,200,30);
        main.add(telemovelText);

        erro = new JLabel("Dados inválidos!");
        erro.setBounds(400,500,100,20);
        main.add(erro);

        success = new JLabel("Sucesso!");
        success.setBounds(400,500,100,20);
        main.add(success);


        select = new JButton("Consultar + Informações");
        select.addActionListener(this);
        select.setBounds(395, 450, 200, 50);
        main.add(select);


        System.out.println(currFrame);
        if(currFrame < 20){
            listingHotels(currFrame,true);
        }else if(currFrame == 100){
            login(true);
        }else if(currFrame == 200){
            register(true);
        }else if(currFrame == 300){
            listingLikes(true);
        }else if(currFrame >= 600){
            editProfile(true);
        }

    }


    public void clearAll(){
        erro.setVisible(false);
        success.setVisible(false);
        login(false);
        register(false);
        listingHotels(0,false);
        moreInfo(0, false);
        editProfile(false);
        listingLikes(false);
    }


    public void editProfile(boolean b){
        if(b){
            usernameCurr = new JLabel("abcd");//controller.getUsernameString(authId);
            usernameCurr.setBounds(500,150,100,20);
            main.add(usernameCurr);
            passwordCurr = new JLabel("efgh");//controller.getPasswordString(authId);
            passwordCurr.setBounds(500,175,100,20);
            main.add(passwordCurr);
            emailCurr = new JLabel("ijkl");//controller.getEmailString(authId);
            emailCurr.setBounds(500,225,100,20);
            main.add(emailCurr);
            telemovelCurr = new JLabel("mnop");//controller.getTelemovelString(authId);
            telemovelCurr.setBounds(500,250,100,20);
            main.add(telemovelCurr);

            clearAll();
        }




        if(usernameCurr != null)usernameCurr.setVisible(b);
        if(passwordCurr != null)passwordCurr.setVisible(b);
        if(emailCurr != null)emailCurr.setVisible(b);
        if(telemovelCurr != null)telemovelCurr.setVisible(b);

        confirm.setVisible(b);
        back.setVisible(b);

        username.setVisible(b);
        usernameText.setVisible(b);

        password.setVisible(b);
        passwordText.setVisible(b);

        confPassword.setVisible(b);
        confPasswordText.setVisible(b);

        email.setVisible(b);
        emailText.setVisible(b);

        telemovel.setVisible(b);
        telemovelText.setVisible(b);

        editPTitle.setVisible(b);
        currFrame = 600+authId;

    }

    public void moreInfo(int dist, boolean b){
        if(b){
            moreInfoTitle = new JLabel("Informações de "); // controller.getHotelNomeString(dist));
            moreInfoTitle.setFont(new Font("Calibri", Font.BOLD, 30));
            moreInfoTitle.setBounds(230,40,300,50);
            main.add(moreInfoTitle);
            addFav = new JButton("Adicionar Gosto");

            location = new JLabel(controller.getHotelLocationString(dist));
            description = new JLabel(controller.getHotelDescriptionString(dist));
            type = new JLabel(controller.getHotelTypeString(dist));
            capacity = new JLabel(controller.getHotelCapacityString(dist));
            likes = new JLabel(controller.getHotelLikesString(dist));

            locationt = new JLabel("Morada:");
            descriptiont = new JLabel("Descrição");
            typet = new JLabel("Tipo");
            capacityt = new JLabel("Capacidade");
            likest = new JLabel("Gostos");


            addFav.setBounds(395,450,200,50);
            addFav.addActionListener(this);

            location.setBounds(340, 150, 300, 30);
            description.setBounds(340, 200, 300, 30);
            type.setBounds(340, 250, 300, 30);
            capacity.setBounds(340, 300, 300, 30);
            likes.setBounds(340, 350, 300, 30);

            locationt.setBounds(190, 150, 200, 30);
            descriptiont.setBounds(190, 200, 200, 30);
            typet.setBounds(190, 250, 200, 30);
            capacityt.setBounds(190, 300, 200, 30);
            likest.setBounds(190, 350, 200, 30);

            main.add(addFav);

            main.add(location);
            main.add(description);
            main.add(type);
            main.add(capacity);
            main.add(likes);

            main.add(locationt);
            main.add(descriptiont);
            main.add(typet);
            main.add(capacityt);
            main.add(likest);

            clearAll();
        }

        if(addFav != null) addFav.setVisible(b&&auth);
        if(location != null) location.setVisible(b);
        if(description != null) description.setVisible(b);
        if(type != null) type.setVisible(b);
        if(capacity != null) capacity.setVisible(b);
        if(likes != null) likes.setVisible(b);

        if(locationt != null) locationt.setVisible(b);
        if(descriptiont != null) descriptiont.setVisible(b);
        if(typet != null) typet.setVisible(b);
        if(capacityt != null) capacityt.setVisible(b);
        if(likest != null) likest.setVisible(b);
        if(moreInfoTitle != null) moreInfoTitle.setVisible(b);
        back.setVisible(b);
        currFrame = 300+dist;

    }
    public void listingLikes(boolean b){
        if(b){
            DefaultListModel<String> listAux = new DefaultListModel<>();
            for (String h : controller.getListLikes(authId)){
                listAux.addElement(h);
            }
            panelL = new JPanel(new BorderLayout());
            panelL.setBounds(120, 120, 480, 300);
            JScrollPane scrollPaneL = new JScrollPane();

            listAux1L = new JList<>(listAux);
            scrollPaneL.setViewportView(listAux1L);
            listAux1L.setLayoutOrientation(JList.VERTICAL);
            panelL.add(scrollPaneL);
            listingHotelsTitleL = new JLabel("Hoteis com like");
            listingHotelsTitleL.setFont(new Font("Calibri", Font.BOLD, 30));
            listingHotelsTitleL.setBounds(230,40,300,50);
            deleteL = new JButton("Remover gosto");
            deleteL.addActionListener(this);
            deleteL.setBounds(260,550,200,50);


            main.add(panelL);
            main.add(listingHotelsTitleL);
            main.add(deleteL);

            clearAll();
        }
        if(panelL != null) panelL.setVisible(b);
        if(listingHotelsTitleL != null) listingHotelsTitleL.setVisible(b);
        if(back != null) back.setVisible(b);
        if(select != null) select.setVisible(b);
        if(deleteL != null) deleteL.setVisible(b);
        currFrame = 300;
    }



    public void listingHotels(int dist, boolean b){
        if(b){
            DefaultListModel<String> listAux = new DefaultListModel<>();
            for (String h : controller.getListHotels(dist)){
                listAux.addElement(h);
            }
            panel = new JPanel(new BorderLayout());
            listAux1 = new JList<>(listAux);
            panel.setBounds(120, 120, 480, 300);
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setViewportView(listAux1);
            listAux1.setLayoutOrientation(JList.VERTICAL);
            panel.add(scrollPane);
            listingHotelsTitle = new JLabel("Hoteis em " + controller.getDistrictString(dist));
            listingHotelsTitle.setFont(new Font("Calibri", Font.BOLD, 30));
            listingHotelsTitle.setBounds(230,40,300,50);
            main.add(panel);
            main.add(listingHotelsTitle);
            main.add(select);

            clearAll();
        }
        if(panel != null) panel.setVisible(b);
        if(listingHotelsTitle != null) listingHotelsTitle.setVisible(b);
        if(back != null) back.setVisible(b);
        select.setVisible(b);
        currFrame = dist;
    }

    public void login(boolean b){
        if(b)clearAll();

        loginTitle.setVisible(b);
        main.add(loginTitle);


        confirm.setVisible(b);
        back.setVisible(b);

        username.setVisible(b);
        usernameText.setVisible(b);

        password.setVisible(b);
        passwordText.setVisible(b);
        currFrame = 100;
    }

    public void register(boolean b){
        if(b)clearAll();
        confirm.setVisible(b);
        back.setVisible(b);

        username.setVisible(b);
        usernameText.setVisible(b);

        password.setVisible(b);
        passwordText.setVisible(b);

        confPassword.setVisible(b);
        confPasswordText.setVisible(b);

        email.setVisible(b);
        emailText.setVisible(b);

        telemovel.setVisible(b);
        telemovelText.setVisible(b);
        registerTitle.setVisible(b);
        currFrame = 200;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deleteL){
            try {
                controller.removeFav(authId,hotelId);
                listingLikes(true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (e.getSource() == back) {
            main.dispose();
            try {
                new MainView(controller, auth, authId);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            currFrame = 0;
        } else if (e.getSource() == confirm) {
            switch (currFrame) {
                case 100:
                    try {
                        authId = controller.login(usernameText.getText(), String.valueOf(passwordText.getPassword()));
                        success.setVisible(true);
                        auth = true;
                        break;
                    } catch (Exception ex) {
                        erro.setVisible(true);
                        auth = false;
                    }
                case 200:
                    try {
                        authId = controller.register(usernameText.getText(), String.valueOf(passwordText.getPassword()), String.valueOf(confPasswordText.getPassword()), emailText.getText(), telemovelText.getText());
                        System.out.println(usernameText.getText() + String.valueOf(passwordText.getPassword()) + String.valueOf(confPasswordText.getPassword()) + emailText.getText() + telemovelText.getText());
                        success.setVisible(true);
                        auth = true;
                        break;
                    } catch (Exception ex) {
                        erro.setVisible(true);
                        auth = false;
                    }
                default:
                    try {
                        controller.editProfile(authId, usernameText.getText(), String.valueOf(passwordText.getPassword()), String.valueOf(confPasswordText.getPassword()), emailText.getText(), telemovelText.getText());
                        success.setVisible(true);
                    } catch (Exception ex) {
                        erro.setVisible(true);
                    }
                    break;
            }
        }else if(e.getSource() == select){
            if(currFrame == 300){
                hotelId = controller.getHotelLikesIndex(authId,listAux1L.getSelectedIndex());
            }else {
                hotelId = listAux1.getSelectedIndex();
            }
            moreInfo(hotelId, true);
        }else if(e.getSource() == addFav){
            try {
                controller.addFav(authId,hotelId);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
