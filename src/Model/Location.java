package Model;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private int distrito;
    private String concelho;
    private String freguesia;
    private String morada;



    public Location(int distrito, String concelho, String freguesia, String morada){
        this.distrito = distrito;
        this.concelho = concelho;
        this.freguesia = freguesia;
        this.morada = morada;
    }


    public int getDistrito() {
        return distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public String getConcelho() {
        return concelho;
    }

    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    public String getFreguesia() {
        return freguesia;
    }

    public void setFreguesia(String freguesia) {
        this.freguesia = freguesia;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    @Override
    public String toString() {
        return "Location:" +
                "   -Distrito: '" + distrito + '\'' +
                "\n   -Concelho: '" + concelho + '\'' +
                "\n   -Freguesia: '" + freguesia + '\'' +
                "\n   -Morada: '" + morada + '\'' +
                '\n';
    }
}
