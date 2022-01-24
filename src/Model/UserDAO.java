package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UserDAO {
    private String filename;
    private ArrayList<String[]> file;
    private int size;

    public UserDAO(String filename) throws IOException {
        this.filename = filename;
        this.file = readFile();


    }

    public int getNextId(){
        return size;
    }

    public void add(String username,String password,String email,String telemovel) throws IOException {
        file = readFile();
        String s = username + "," + password + "," + email + "," + telemovel + ", ";
        file.add(s.split(","));
        size++;
        writeFile();
    }



    public ArrayList<User> getUsers() throws IOException {
        File file = new File(filename);
        BufferedReader read = new BufferedReader(new FileReader(file));
        this.file = readFile();
        String line;
        ArrayList<User> ret = new ArrayList<>();
        int ind = 0;
        while((line = read.readLine()) != null){
            String[] userStrings = line.split(",");
            ret.add(new User(this,ind, userStrings[0],  userStrings[1],userStrings[2],userStrings[3],getLikes(userStrings[4])));
            ind++;
        }
        read.close();
        return ret;
    }


    public void writeFile() throws IOException {
        StringBuilder str = new StringBuilder();
        File file = new File(filename);
        BufferedWriter write = new BufferedWriter(new FileWriter(file));
        for(String[] line : this.file){
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


    public ArrayList<String[]> readFile() throws IOException {
        File file = new File(filename);
        BufferedReader read = new BufferedReader(new FileReader(file));
        String line;
        ArrayList<String[]> aux = new ArrayList<>();
        size = 0;
        while((line = read.readLine()) != null){
            aux.add(line.split(","));
            size++;
        }
        read.close();
        return aux;
    }


    public boolean removeLike(int idu, int idh) throws IOException {
        file = readFile();
        ArrayList<Integer> aux = getLikes(file.get(idu)[4]);
        if(aux.contains(idh)) {
            aux.removeAll(Collections.singletonList(idh));
            setLikes(idu, aux);
            writeFile();
            return true;
        }
        return false;
    }

    public boolean addLike(int idu, int idh) throws IOException {
        file = readFile();
        ArrayList<Integer> aux = getLikes(file.get(idu)[4]);
        System.out.println(aux);
        if(aux.contains(idh)) return false;
        aux.add(idh);
        setLikes(idu,aux);
        writeFile();
        return true;
    }



    public ArrayList<Integer> getLikes(String line) throws IOException {
        file = readFile();
        ArrayList<Integer> ret = new ArrayList<>();
        if(!line.contains(" ")) ret.add(Integer.parseInt(line));
        else {
            String[] aux = line.split(" ");
            System.out.println("aduabufnjk"+ Arrays.toString(aux));
            for (String s : aux) {
                System.out.println(s);
                ret.add(Integer.parseInt(s));
            }
        }
        return ret;
    }

    public void setLikes(int idu, ArrayList<Integer> likes) throws IOException {
        file = readFile();
        StringBuilder s = new StringBuilder();
        boolean fst = true;
        for(Integer i : likes){
            s.append(i);
            s.append(" ");

        }
        if(likes.size() == 0) s.append(" ");
        file.get(idu)[4] = s.toString();
        writeFile();
    }


    public void setUsername(int idu, String username) throws IOException {
        file = readFile();
        file.get(idu)[0] = username;
        writeFile();
    }

    public void setPassword(int idu, String password) throws IOException {
        file = readFile();
        file.get(idu)[1] = password;
        writeFile();
    }

    public void setEmail(int idu, String email) throws IOException {
        file = readFile();
        file.get(idu)[2] = email;
        writeFile();
    }

    public void setTelemovel(int idu, String telemovel) throws IOException {
        file = readFile();
        file.get(idu)[3] = telemovel;
        writeFile();
    }

}
