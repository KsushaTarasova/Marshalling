package org.gson.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.gson.domain.Staff;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class GsonExample1 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                //.setExclusionStrategies(new CustomExclusionStrategy(List.class))
                .setPrettyPrinting()
                .create();
        Staff staff = createStaffObject("Oleg", 35),
                staff1 = createStaffObject("Natasha", 27);
        List<Staff> list = new ArrayList<>();
        list.add(staff);
        list.add(staff1);
        try (FileWriter writer = new FileWriter("src/main/resources/student.json")) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Staff createStaffObject(String name, int age) {

        Staff staff = new Staff();

        staff.setName(name);
        staff.setAge(age);
        staff.setPosition(new String[]{"Founder", "SEO", "coder"});
        Map<String, BigDecimal> salary = new HashMap<>() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        return staff;

    }

}
