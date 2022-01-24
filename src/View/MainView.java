package View;

import Controller.HFinder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class ImagePanel extends JPanel {
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}

class FirstView implements ActionListener{
    private JFrame main;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        new FirstView();
    }

    public FirstView(){
        main = new JFrame("HFinder");
        main.setSize(720,760);
        main.setLayout(null);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main.setResizable(false);
        main.setVisible(true);

        JButton button = new JButton("Entrar");
        button.setBounds(250,300,220,100);
        button.addActionListener(this);
        main.add(button);
        button.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        main.dispose();
        try {
            new MainView(new HFinder(), false, 0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


public class MainView implements ActionListener {
    private HFinder controller;
    private boolean auth;
    private int authId;

    private JFrame main;

    //Main menu
    private Icon logoPic = new ImageIcon("images\\logo.png");

    private ArrayList<JButton> dists;
    private JButton login;
    private JButton register;
    private JButton logout;
    private JButton edit;
    private JButton editLikes;




    public MainView(HFinder controller, boolean auth, int authId) throws IOException {

        this.controller = controller;
        this.auth = auth;
        this.authId = authId;


        BufferedImage mapaPng = ImageIO.read(new File("images\\mapa.png"));
        ImagePanel mapaPanel = new ImagePanel(mapaPng);

        main = new JFrame("HFinder");
        main.setSize(720,760);

        main.setContentPane(mapaPanel);

        main.setLayout(null);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main.setResizable(false);
        main.setVisible(true);

        ArrayList<Rectangle> distPos = new ArrayList<>();
        distPos.add(new Rectangle(385,51,15,15));// Viana do castelo
        distPos.add(new Rectangle(420,74,15,15));// Braga
        distPos.add(new Rectangle(488,109,15,15));// Vila Real
        distPos.add(new Rectangle(597,42,15,15));// Bragança
        distPos.add(new Rectangle(399,124,15,15));// Porto
        distPos.add(new Rectangle(397,198,15,15));// Aveiro
        distPos.add(new Rectangle(469,200,15,15));// Viseu
        distPos.add(new Rectangle(540,218,15,15));// Guarda
        distPos.add(new Rectangle(428,263,15,15));// Coimbra
        distPos.add(new Rectangle(509,322,15,15));// Castelo Branco
        distPos.add(new Rectangle(380,326,15,15));// Leiria
        distPos.add(new Rectangle(388,393,15,15));// Santarém
        distPos.add(new Rectangle(521,393,15,15));// Portalegre
        distPos.add(new Rectangle(338,465,15,15));// Lisboa
        distPos.add(new Rectangle(365,493,15,15));// Setubal
        distPos.add(new Rectangle(455,482,15,15));// Evora
        distPos.add(new Rectangle(448,566,15,15));// Beja
        distPos.add(new Rectangle(471,706,15,15));// Faro
        distPos.add(new Rectangle(139,437,15,15));// Madeira
        distPos.add(new Rectangle(136,254,15,15));// Acores



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
        login.setBounds(2,2,100,20);
        main.add(login);

        //Registo
        register = new JButton("Registar");
        register.addActionListener(this);
        register.setBounds(103,2,100,20);
        main.add(register);

        //TerminarSessao
        logout = new JButton("Logout");
        logout.addActionListener(this);
        logout.setBounds(2,2,100,30);
        main.add(logout);

        //editar perfil
        edit = new JButton("Editar perfil");
        edit.addActionListener(this);
        edit.setBounds(104,2,100,30);
        main.add(edit);

        //editar gostos
        editLikes = new JButton("Editar gostos");
        editLikes.addActionListener(this);
        editLikes.setBounds(206,2,100,30);
        main.add(editLikes);

        baseFrame();
    }

    public void baseFrame(){
        if(auth){
            register.setVisible(false);
            login.setVisible(false);
            logout.setVisible(true);
            edit.setVisible(true);
            editLikes.setVisible(true);
        }else{
            register.setVisible(true);
            login.setVisible(true);
            logout.setVisible(false);
            edit.setVisible(false);
            editLikes.setVisible(false);
        }
        for(int i = 0; i < 20; i++){
            if(controller.distritoHasHotels(i)) dists.get(i).setVisible(true);
            else dists.get(i).setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (int i = 0; i < 20; i++) {
                if (e.getSource() == dists.get(i)) {
                    main.dispose();
                    new UserView(i, controller, auth, authId);
                    break;
                }
            }
            if(e.getSource() == logout){
                main.dispose();
                new FirstView();
            } else if (e.getSource() == login) {
                main.dispose();
                new UserView(100, controller, false, authId);
            } else if (e.getSource() == register) {
                main.dispose();
                new UserView(200, controller, false, authId);
            }else if(e.getSource() == edit){
                main.dispose();
                new UserView(600+authId,controller,auth,authId);
            }else if(e.getSource() == editLikes){
                main.dispose();
                new UserView(300,controller,auth,authId);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
