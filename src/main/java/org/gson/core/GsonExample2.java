package org.gson.core;

import com.google.gson.Gson;
import org.gson.domain.Staff;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class GsonExample2 {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("src/main/resources/student.json")) {
            ArrayList<Staff> list = gson.fromJson(reader, ArrayList.class);
            System.out.println(list);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
