package pl.java.companyApp.writer;

import pl.java.companyApp.company.Employee;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtEmployeeWriter implements EmployeeWriter {

    private String path;

    public TxtEmployeeWriter(String path) {
        this.path = path;
    }

    @Override
    public void write(Employee[] employees) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
            for (Employee p : employees) {
                writer.write(p.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
