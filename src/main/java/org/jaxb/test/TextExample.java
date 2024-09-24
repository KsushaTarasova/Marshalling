package org.jaxb.test;

import org.jaxb.model.Department;
import org.jaxb.model.Employee;
import org.jaxb.model.Organisation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TextExample {
    private static final String XML_FILE = "src\\main\\resources\\dept-info.xml";

    public static void main(String[] args) {
        Employee emp1 = new Employee("E01", "Tom", null),
                emp2 = new Employee("E02", "Mary", "E01"),
                emp3 = new Employee("E03", "John", null),
                emp4 = new Employee("E04", "Bob", null),
                emp5 = new Employee("E05", "Kate", "E04"),
                emp6 = new Employee("E63", "Alice", null);

        List<Employee> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        Department dept = new Department("D01", "ACCOUNTING", "NEW YORK");
        dept.setEmployees(list);
        List<Employee> list1 = new ArrayList<>();
        list1.add(emp4);
        list1.add(emp5);
        list1.add(emp6);
        Department dept1 = new Department("D02", "ABC", "Gomel");
        dept1.setEmployees(list1);
        List<Department> list2 = new ArrayList<>();
        list2.add(dept);
        list2.add(dept1);
        Organisation org = new Organisation("Org", list2);

        try {
            JAXBContext context = JAXBContext.newInstance(Organisation.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(org, System.out);
            File outFile = new File(XML_FILE);
            m.marshal(org, outFile);
            System.err.println("Write to file: " + outFile.getAbsolutePath());

            Unmarshaller um = context.createUnmarshaller();
            Organisation deptFromFile1 = (Organisation) um.unmarshal(new FileReader(XML_FILE));
            List<Department> deps = deptFromFile1.getDepartments();
            for (Department dep : deps) {
                System.out.println("Department: " + dep.getDeptName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
