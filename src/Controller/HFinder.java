package Controller;


import Model.Hotel;
import Model.HotelDAO;
import Model.User;
import Model.UserDAO;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HFinder{
    private HotelDAO daoH;
    private UserDAO daoU;

    private ArrayList<Hotel> hotels;
    private ArrayList<User> users;



    public HFinder() throws IOException {
        daoH = new HotelDAO("saves\\hotels.save");
        daoU = new UserDAO("saves\\users.save");
        this.hotels = daoH.getHotels();
        this.users = daoU.getUsers();
    }

    public void editProfile(int idu, String username, String password, String confPassword, String email, String telemovel) throws Exception{
        if(!password.equals(confPassword)) throw new Exception();
        users.get(idu).setUsername(username);
        users.get(idu).setPassword(password);
        users.get(idu).setEmail(email);
        users.get(idu).setTelemovel(telemovel);
    }


    public void addFav(int idu, int idh) throws IOException {
        users.get(idu).addLike(idh);
        boolean b = users.get(idu).addLike(idh);
        if(b) hotels.get(idh).addLike(idh);
    }



    public void removeFav(int idu, int idh) throws IOException {
        users.get(idu).removeLike(idh);
        boolean b = users.get(idu).removeLike(idh);
        if(b) hotels.get(idh).removeLike();
    }

    public int register(String username, String password, String confPassword, String email, String telemovel) throws Exception{
        if(!password.equals(confPassword)) throw new Exception();
        int idu = daoU.getNextId();
        System.out.println("bbbb"+idu);
        users.add(new User(daoU, idu, username, password, email, telemovel, new ArrayList<>()));
        daoU.add(username, password, email, telemovel);
        return idu;
    }

    public int login(String username, String password) throws Exception{
        for(User u : users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u.getId();
            }
        }
        throw new Exception();
    }

    public ArrayList<String> getListLikes(int idu){
        ArrayList<String> ret = new ArrayList<>();
        for(Integer idh : users.get(idu).getLikes()){
            ret.add(hotels.get(idh).toString());
        }
        return ret;
    }


    public ArrayList<String> getListHotels(int dist){
        ArrayList<String> ret = new ArrayList<>();
        for(Hotel h : hotels){
            if(dist == h.getLocation().getDistrito()){
                ret.add(h.toString());
            }
        }
        return ret;
    }

    public int getHotelLikesIndex(int idu, int idLike){
        return users.get(idu).getLikeId(idLike);
    }

    public boolean distritoHasHotels(int dist){
        for(Hotel h : hotels){
            if(dist == h.getLocation().getDistrito()){
                return true;
            }
        }
        return false;
    }

    public String getHotelLocationString(int ind){
        return hotels.get(ind).getLocationString();
    }
    public String getHotelDescriptionString(int ind){
        return "<html>" + hotels.get(ind).getDescriptionString() + "</html>";
    }
    public String getHotelTypeString(int ind){
        return hotels.get(ind).getTypeString();
    }
    public String getHotelCapacityString(int ind){
        return hotels.get(ind).getCapacityString();
    }
    public String getHotelLikesString(int ind){
        return hotels.get(ind).getLikesString();
    }

    public String getDistrictString(int dist){
        switch(dist) {
            case 0:
                return "Viana do castelo";

            case 1:
                return "Braga";

            case 2:
                return "Vila Real";

            case 3:
                return "Bragança";

            case 4:
                return "Porto";

            case 5:
                return "Aveiro";

            case 6:
                return "Viseu";

            case 7:
                return "Guarda";

            case 8:
                return "Coimbra";

            case 9:
                return "Castelo Branco";

            case 10:
                return "Leiria";

            case 11:
                return "Santarém";

            case 12:
                return "Portalegre";

            case 13:
                return "Lisboa";

            case 14:
                return "Setubal";

            case 15:
                return "Evora";

            case 16:
                return "Beja";

            case 17:
                return "Faro";

            case 18:
                return "Madeira";

            case 19:
                return "Acores";
        }
        return "";
    }

}
