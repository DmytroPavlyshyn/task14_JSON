package parser;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONValidator {
    boolean isValid(File jsonFile, File schemaFile) throws FileNotFoundException {

        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(new FileReader(schemaFile)));
        JSONArray jsonSubject = new JSONArray(
                new JSONTokener(new FileReader(jsonFile)));

        Schema schema = SchemaLoader.load(jsonSchema);

        try {
            schema.validate(jsonSubject);
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
}
