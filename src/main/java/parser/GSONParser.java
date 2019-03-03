package parser;


import com.google.gson.Gson;
import model.Bank;
import model.DepositType;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class GSONParser implements Parser<Bank> {
    File file;

    public GSONParser(File file) {
        this.file = file;
    }

    @Override
    public void writeJSON(List<Bank> list) {
        Gson gson = new Gson();

        try (FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(list, list.getClass(), fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Bank> readJSON() {
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader(file);
             Reader reader = new BufferedReader(fileReader)) {

            return gson.fromJson(reader, ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
