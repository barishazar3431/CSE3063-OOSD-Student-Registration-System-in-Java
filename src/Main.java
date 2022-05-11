import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

    public static void main(String[] args) {

        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
        registrationSystem.startTheSimulation();
    }

    public static ArrayList<String> getNamesList() {
        ArrayList<String> names = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            Object nameObj = parser.parse(new FileReader("names.json"));
            JSONObject nameJson =  (JSONObject) nameObj;
            JSONArray name = (JSONArray) nameJson.get("names");
            for (Object o : name) {
                names.add((String) o);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }

        return names;
    }

    public static ArrayList<String> getSurnamesList()  {
        ArrayList<String> surnames = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            Object surnameObj = parser.parse(new FileReader("surnames.json"));
            JSONObject surnameJson =  (JSONObject) surnameObj;
            JSONArray surname = (JSONArray) surnameJson.get("surnames");
            for (Object o : surname) {
                surnames.add((String) o);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }

        return surnames;
    }
}