package Model;

import Model.Location;

import java.io.IOException;

public class Hotel {
    private HotelDAO dao;

    private int id;
    private String name;
    private Location location;
    private String description;
    private String type;
    private int capacity;
    private int likes;


    public Hotel(HotelDAO dao, int id, String name, Location location, String description, String type, int capacity, int likes) {
        this.dao = dao;
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.type = type;
        this.capacity = capacity;
        this.likes = likes;
    }

    public void removeLike() throws IOException {
        likes--;
        dao.removeLike(id);
    }

    public void addLike(int id) throws IOException {
        likes++;
        dao.addLike(id);
    }

    public Location getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getLikes() {
        return likes;
    }

    public String getNameString() {
        return name;
    }

    public String getLocationString() {
        return location.toString();
    }

    public String getDescriptionString() {
        return description;
    }

    public String getTypeString() {
        return type;
    }

    public String getCapacityString() {
        return String.valueOf(capacity);
    }

    public String getLikesString() {
        return String.valueOf(likes);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDescription(String descricao) {
        description = descricao;
    }

    public void setType(String restauracao) {
        type = restauracao;
    }

    public void setCapacity(int lotacao) {
        capacity = lotacao;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

}
