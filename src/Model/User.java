package Model;

import java.util.ArrayList;

public class User {
    private UserDAO dao;

    private int id;
    private String username;
    private String password;
    private String email;
    private String telemovel;
    private ArrayList<Integer> likes;

    public User(int id, String username, String password, String email, String telemovel, ArrayList<Integer> likes){
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

    public void setUsername(String username) {
        this.username = username;
        dao.setUsername(id, username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        dao.setPassword(id, password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
        dao.setTelemovel(id, telemovel);
    }

    public ArrayList<Integer> getLikes() {
        return likes;
    }

    public int getLikeId(int id){
        return likes.get(id);
    }

    public void addLike(int idh) {
        likes.add(idh);
        dao.addLike(id,idh);
    }
}
