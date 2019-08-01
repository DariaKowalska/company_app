package pl.java.companyApp.writer;

import pl.java.companyApp.company.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

public class XmlEmployeeWriter implements EmployeeWriter {

    private String path;

    public XmlEmployeeWriter(String path) {
        this.path = path;
    }
    @Override
    public void write(Employee[] employees) {
        try {
            JAXBContext context = JAXBContext.newInstance(EmployeeCollection.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(new EmployeeCollection(employees), new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @XmlRootElement(name = "pracownicy")
    private static class EmployeeCollection {
        @XmlElement
        private Employee[] employees;

        private EmployeeCollection() {}

        EmployeeCollection(Employee[] employees) {
            this.employees = employees;
        }
    }
}
