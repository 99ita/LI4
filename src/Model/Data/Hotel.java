package Model.Data;

import Model.Location;

public class Hotel {
    public Hotel(Location location, String descricao, String restauracao, int lotacao, int gostos) {
        this.location = location;
        Descricao = descricao;
        Restauracao = restauracao;
        Lotacao = lotacao;
        this.gostos = gostos;
    }

   private Location location;
   private String Descricao;
   private String Restauracao;
   private int Lotacao;
   private int gostos;

    public Location getLocation() {
        return location;
    }


    public String getDescricao() {
        return Descricao;
    }

    public String getRestauracao() {
        return Restauracao;
    }

    public int getLotacao() {
        return Lotacao;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public void setRestauracao(String restauracao) {
        Restauracao = restauracao;
    }

    public void setLotacao(int lotacao) {
        Lotacao = lotacao;
    }

    public void setGostos(int gostos) {
        this.gostos = gostos;
    }

    public int getGostos() {
        return gostos;
    }
}
