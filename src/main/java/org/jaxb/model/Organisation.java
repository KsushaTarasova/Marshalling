package org.jaxb.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "organisation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organisation {
    private String name;
    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;

    public Organisation() {
    }

    public Organisation(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
