package Controller;


import Model.Data.Hotel;

import java.util.HashMap;
import java.util.Map;

public class HFinder{
    private Map<Integer, Hotel> hotels;
    private Map<Integer,String> users;
    private int idh;
    private int idu;



    public HFinder(){
        this.hotels = new HashMap<>();
        this.users = new HashMap<>();
        this.idh = 0;
        this.idu = 0;
    }




}
