package Model;

import java.io.IOException;
import java.util.ArrayList;

public class User {
    private UserDAO dao;

    private int id;
    private String username;
    private String password;
    private String email;
    private String telemovel;
    private ArrayList<Integer> likes;

    public User(UserDAO dao, int id, String username, String password, String email, String telemovel, ArrayList<Integer> likes){
        this.dao = dao;
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telemovel = telemovel;
        this.likes = likes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws IOException {
        this.username = username;
        dao.setUsername(id, username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws IOException {
        this.password = password;
        dao.setPassword(id, password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IOException {
        this.email = email;
        dao.setEmail(id, email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) throws IOException {
        this.telemovel = telemovel;
        dao.setTelemovel(id, telemovel);
    }

    public ArrayList<Integer> getLikes() {
        return likes;
    }

    public int getLikeId(int id){
        return likes.get(id);
    }

    public boolean addLike(int idh) throws IOException {
        boolean b = dao.addLike(id,idh);
        if(b) likes.add(idh);
        return b;
    }

    public boolean removeLike(int idh) throws IOException {
        boolean b = dao.removeLike(id,idh);
        if(b) likes.remove(idh);
        return b;
    }




    /*public ArrayList<Integer> getLikes(String line){
        ArrayList<Integer> ret = new ArrayList<>();
        String[] aux = line.split(".");
        for(String s: aux){
            ret.add(Integer.parseInt(s));
        }
        return ret;
    }*/
}
