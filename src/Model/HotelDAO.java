package Model;


import java.io.*;
import java.util.ArrayList;

public class HotelDAO {
    String filename;
    ArrayList<String[]> file;

    public HotelDAO(String filename) throws IOException {
        this.filename = filename;
        this.file = readFile();
    }

    public ArrayList<Hotel> getHotels() throws IOException {
        File f = new File(filename);
        BufferedReader read = new BufferedReader(new FileReader(f));

        this.file = readFile();
        String line = "";
        ArrayList<Hotel> ret = new ArrayList<>();
        int ind = 0;
        while((line = read.readLine()) != null){
            String[] hotelStrings = line.split(",");
            ret.add(new Hotel(this,ind, hotelStrings[0], new Location(Integer.parseInt(hotelStrings[1]), hotelStrings[2], hotelStrings[3], hotelStrings[4]), hotelStrings[5],hotelStrings[6],Integer.parseInt(hotelStrings[7]), Integer.parseInt(hotelStrings[8])));
            ind++;
        }
        read.close();
        return ret;
    }


    public ArrayList<String[]> readFile() throws IOException {
        File f = new File(filename);
        BufferedReader read = new BufferedReader(new FileReader(f));
        String line;
        ArrayList<String[]> aux = new ArrayList<>();
        while((line = read.readLine()) != null){
            aux.add(line.split(","));
        }
        read.close();
        return aux;
    }

    public void writeFile() throws IOException {
        StringBuilder str = new StringBuilder();
        File f = new File(filename);
        BufferedWriter write = new BufferedWriter(new FileWriter(f));
        for(String[] line : file){
            boolean fst = true;
            for(String s : line){
                if(!fst) str.append(",").append(s);
                else{fst = false; str.append(s);}
            }
            str.append(System.lineSeparator());
        }
        write.write(str.toString());
        write.flush();
        write.close();
    }





    public void addLike(int idh) throws IOException {
        file = readFile();
        int likes = Integer.parseInt(file.get(idh)[8]);
        likes++;
        file.get(idh)[8] = String.valueOf(likes);;
        writeFile();
    }


    public void removeLike(int idh) throws IOException {
        file = readFile();
        int likes = Integer.parseInt(file.get(idh)[8]);
        likes--;
        file.get(idh)[8] = String.valueOf(likes);;
        writeFile();
    }
}
