package parser;

import model.Bank;
import model.DepositType;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class App {
    public   String json = "src/main/resources/json/bank.json";
    public   String schema = "src/main/resources/json/bankSchema.json";
    public List<Bank> list;

    public App(String json, String schema, List<Bank> list) {
        this.json = json;
        this.schema = schema;
        this.list = list;
    }

    @SuppressWarnings("unchecked")
    private void parse(Parser parser){
        System.out.println("Saved: " + list);
        parser.writeJSON(list);
        System.out.println("Retrieved" + parser.readJSON());
    }
    public void jackson(){  //TODO
        JacksonParser jacksonParser = new JacksonParser(new File(json));
        parse(jacksonParser);
    }
    public void gson(){
        GSONParser gsonParser = new GSONParser(new File(json));
        parse(gsonParser);
    }
    public void validate(){
        try {
            System.out.println(new JSONValidator().isValid(new File(json),new File(schema)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static List<Bank> generate(int number){
        List<Bank> banks = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < number; i++){
            int temp;
            banks.add(new Bank(i,"Bank","Country",
                    EnumSet.of(
                   DepositType.values()[
                            random.nextInt(DepositType.values().length)]),
                    "Depositor",
                    i,
                    random.nextInt(1000),
                    1,
                    LocalDate.now().plusYears(2+ random.nextInt(10))));
        }
        return banks;
    }

    public static void main(String[] args) throws IOException {
        App app1 = new App("src/main/resources/json/bank1.json","src/main/resources/json/bankSchema.json",App.generate(5));
        App app2 = new App("src/main/resources/json/bank2.json","src/main/resources/json/bankSchema.json",App.generate(5));
        app1.jackson();
        app2.gson();

    }


}
