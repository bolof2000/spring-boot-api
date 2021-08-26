package utils;

import com.github.javafaker.Faker;
import org.json.simple.JSONObject;

import java.util.Locale;

public class DataGenerator {

    public static Locale locale = new Locale("en", "US");

    static Faker faker = new Faker(locale);

    public static String departmentTestData(){
        String departmentAddress = faker.address().streetAddress();
        String departmentName = faker.company().profession();
        String departmentCode = faker.code().isbn13();


        JSONObject departmentData = new JSONObject();

        departmentData.put("departmentAddress",departmentAddress);
        departmentData.put("departmentName",departmentName);
        departmentData.put("departmentCode",departmentCode);


        return departmentData.toJSONString();
    }

    public static void main(String[] args){
        System.out.println(departmentTestData());
    }
}
