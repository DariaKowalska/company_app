package pl.java.companyApp.writer;

public class WriterFactory {

    public static EmployeeWriter createWriter(String path) {
        if (path.endsWith(".txt")) {
            return new TxtEmployeeWriter(path);
        } else if (path.endsWith(".xml")) {
            return new XmlEmployeeWriter(path);
        } else {
            return null;
        }
    }
}
