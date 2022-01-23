package View;

import Controller.HFinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainView implements ActionListener {
    private boolean auth;
    private HFinder controller;
    private JFrame main;

    //Main menu
    private Icon logoPic = new ImageIcon("images\\logo.png");
    private Icon mapaPic = new ImageIcon("images\\mapa.png");

    private JLabel mapa;
    private ArrayList<JButton> dists;
    private JButton login;
    private JButton register;
    private JButton logout;

    //Login/registo menu
    private JLabel username;
    private JLabel password;
    private JLabel confPassword;
    private JLabel email;
    private JLabel telemovel;
    private JLabel erro;

    private JTextField usernameText;
    private JTextField passwordText;
    private JTextField confPasswordText;
    private JTextField emailText;
    private JTextField telemovelText;


    private JButton confirm;
    private JButton back;

    //Listagem
    private JLabel distrito;
    private JButton select;

    private DefaultListModel<String> listAux;
    private JPanel panel;
    private JList<String> listAux1;
    private JScrollPane scrollPane;




    public MainView(){
        auth = false;
        main = new JFrame("HFinder");
        ArrayList<Rectangle> distPos = new ArrayList<>();
        distPos.add(new Rectangle(1,2,10,10));// Viana do castelo
        distPos.add(new Rectangle(1,2,10,10));// Braga
        distPos.add(new Rectangle(1,2,10,10));// Vila Real
        distPos.add(new Rectangle(1,2,10,10));// Bragança
        distPos.add(new Rectangle(1,2,10,10));// Porto
        distPos.add(new Rectangle(1,2,10,10));// Aveiro
        distPos.add(new Rectangle(1,2,10,10));// Viseu
        distPos.add(new Rectangle(1,2,10,10));// Guarda
        distPos.add(new Rectangle(1,2,10,10));// Coimbra
        distPos.add(new Rectangle(1,2,10,10));// Castelo Branco
        distPos.add(new Rectangle(1,2,10,10));// Leiria
        distPos.add(new Rectangle(1,2,10,10));// Santarém
        distPos.add(new Rectangle(1,2,10,10));// Portalegre
        distPos.add(new Rectangle(1,2,10,10));// Lisboa
        distPos.add(new Rectangle(1,2,10,10));// Setubal
        distPos.add(new Rectangle(1,2,10,10));// Evora
        distPos.add(new Rectangle(1,2,10,10));// Beja
        distPos.add(new Rectangle(1,2,10,10));// Faro
        distPos.add(new Rectangle(1,2,10,10));// Madeira
        distPos.add(new Rectangle(1,2,10,10));// Acores

        //Mapa
        mapa = new JLabel(mapaPic);
        main.add(mapa);


        //--------------------------Main menu--------------------------
        //Butoes em cada distrito
        dists = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            dists.add(new JButton(logoPic));
            dists.get(i).addActionListener(this);
            dists.get(i).setBounds(distPos.get(i));
            main.add(dists.get(i));
        }

        //Login
        login = new JButton("Login");
        login.addActionListener(this);
        login.setBounds(1,2,3,4);
        main.add(login);

        //Registo
        register = new JButton("Registar");
        register.addActionListener(this);
        register.setBounds(1,2,3,4);
        main.add(register);

        //TerminarSessao
        logout = new JButton("Logout");
        logout.addActionListener(this);
        logout.setBounds(1,2,3,4);
        main.add(logout);


        //--------------------------login--------------------------

        confirm = new JButton("Confirmar");
        confirm.setBounds(1,2,3,4);
        main.add(confirm);

        back = new JButton("Voltar");
        back.setBounds(1,2,3,4);
        main.add(back);

        username = new JLabel("Usuário:");
        username.setBounds(1,2,3,4);
        main.add(username);

        password = new JLabel("Password:");
        password.setBounds(1,2,3,4);
        main.add(password);

        erro = new JLabel("Dados inválidos!");
        erro.setBounds(1,2,3,4);
        main.add(erro);



        //--------------------------Registo--------------------------

        confirm = new JButton("Confirmar");
        confirm.setBounds(1,2,3,4);
        main.add(confirm);

        back = new JButton("Voltar");
        back.setBounds(1,2,3,4);
        main.add(back);

        username = new JLabel("Nome de Usuário:");
        username.setBounds(1,2,3,4);
        main.add(username);
        usernameText = new JTextField();
        usernameText.setBounds(1,2,3,4);
        main.add(usernameText);

        password = new JLabel("Password:");
        password.setBounds(1,2,3,4);
        main.add(password);
        passwordText = new JPasswordField();
        passwordText.setBounds(1,2,3,4);
        main.add(passwordText);

        confPassword = new JLabel("Confirme Password:");
        confPassword.setBounds(1,2,3,4);
        main.add(confPassword);
        confPasswordText = new JPasswordField();
        confPasswordText.setBounds(1,2,3,4);
        main.add(confPasswordText);


        email = new JLabel("Email:");
        email.setBounds(1,2,3,4);
        main.add(email);
        emailText = new JTextField();
        emailText.setBounds(1,2,3,4);
        main.add(emailText);

        telemovel = new JLabel("Número de Telemovel:");
        telemovel.setBounds(1,2,3,4);
        main.add(telemovel);
        telemovelText = new JTextField();
        telemovelText.setBounds(1,2,3,4);
        main.add(telemovelText);

        erro = new JLabel("Dados inválidos!");
        erro.setBounds(1,2,3,4);
        main.add(erro);



    }

    public void clearAll(){
        hideMap();
        login(false);
        register(false);
        listing(0,false);
    }

    public void listing(int dist, boolean b){
        if(b){
            DefaultListModel<String> listAux = new DefaultListModel<>();
            for (String h : controller.getListHotels(dist)){
                listAux.addElement(h);
            }
            panel = new JPanel(new BorderLayout());
            listAux1 = new JList<>(listAux);
            panel.setBounds(60, 60, 495, 300);
            scrollPane = new JScrollPane();
            select = new JButton("Consultar Informação");
            scrollPane.setViewportView(listAux1);
            listAux1.setLayoutOrientation(JList.VERTICAL);
            panel.add(scrollPane);
            main.add(panel);

            distrito = new JLabel("Hoteis em " + controller.getDistrictString(dist));
            clearAll();
            panel.setVisible(true);
            distrito.setVisible(true);
            back.setVisible(true);
            select.setVisible(true);

        }else{
            panel.setVisible(false);
            distrito.setVisible(false);
            back.setVisible(false);
            select.setVisible(false);

        }
    }

    public void login(boolean b){
        clearAll();
        confirm.setVisible(b);
        back.setVisible(b);
        username.setVisible(b);
        password.setVisible(b);
    }

    public void register(boolean b){
        clearAll();
        confirm.setVisible(b);
        back.setVisible(b);
        username.setVisible(b);
        password.setVisible(b);
        confPassword.setVisible(b);
        email.setVisible(b);
        telemovel.setVisible(b);
    }

    public void baseFrame(){
        clearAll();
        mapa.setVisible(true);
        if(auth){
            register.setVisible(false);
            login.setVisible(false);
            logout.setVisible(true);
        }else{
            register.setVisible(true);
            login.setVisible(true);
            logout.setVisible(false);
        }
        for(int i = 0; i < 20; i++){
            if(controller.distHasHotels(i)) dists.get(i).setVisible(true);
            else dists.get(i).setVisible(false);
        }
    }


    public void hideMap(){
        mapa.setVisible(false);

        register.setVisible(false);
        login.setVisible(false);
        logout.setVisible(false);

        for(int i = 0; i < 20; i++){
            dists.get(i).setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean done = false;
        for(int i = 0; i < 20; i++){
            if (e.getSource() == dists.get(i)){
                listing(i);
                done = true;
                break;
            }
        }
        if(!done){
            if(e.getSource() == login){
                login(true);
            } else if (e.getSource() == register){
                register(true);
            }
        }
    }
}
