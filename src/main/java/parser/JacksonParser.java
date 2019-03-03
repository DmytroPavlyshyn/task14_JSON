package parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Bank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JacksonParser implements Parser<Bank> {
    File file;
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.findAndRegisterModules();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }
    public JacksonParser(File file) {
        this.file = file;
    }

    @Override
    public List<Bank> readJSON()  {
        try {
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Bank.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void writeJSON(List<Bank> list) {
        try {
            objectMapper.writeValue(file,list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
