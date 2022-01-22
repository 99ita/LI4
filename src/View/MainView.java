package View;

import Controller.HFinder;

import javax.swing.*;
import java.util.ArrayList;

public class MainView {
    private HFinder controller;
    private JFrame main;

    //Map
    private Icon logoPic = new ImageIcon("images\\logo.png");
    private Icon mapaPic = new ImageIcon("images\\mapa.png");

    private JLabel mapa;
    private ArrayList<JButton> dists;


    public MainView(){
        mapa = new JLabel(mapaPic);

        dists = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            dists.add(new JButton(logoPic));
        }

    }


}
