package pl.java.companyApp.company;

import pl.java.companyApp.writer.EmployeeWriter;
import pl.java.companyApp.writer.WriterFactory;

import java.util.Scanner;

public class Main {

    private static Scanner reading = new Scanner(System.in);

    public static void main(String[] args) {
        Company company = new Company("xxx");
        System.out.println("Witaj w firmie!");
        boolean logout = false;
        while (!logout) {
            printMenu();
            System.out.println("Wybór: ");
            int choose = reading.nextInt();
            switch (choose) {
                case 1:
                    showEmployees(company);
                    break;
                case 2:
                    insertEmployee(company);
                    break;
                case 5: {
                    System.out.println("Podaj nazwe pliku");
                    String fileName = reading.next();
                    System.out.println("Zapisuje do pliku " + fileName + "...");

                    EmployeeWriter writer = WriterFactory.createWriter(fileName);
                    if (writer != null) {
                        writer.write(company.getEmployees());
                    } else {
                        System.out.println("Nie obslugiwane rozszerzenie - obslugiwane to .txt i .xml");
                    }
                    break;
                }
                case 0:
                    logout = true;
                    break;
            }
        }
    }

    private static void showEmployees(Company company) {
        Employee[] employees = company.getEmployees();
        for (Employee empl : employees) {
            System.out.println(empl.toString());
        }
    }

    private static void insertEmployee(Company company) {
        // pobierz dane o nowym pracowniku
        System.out.println("Podaj imie");
        String name = reading.next();
        System.out.println("Podaj nazwisko");
        String lastName = reading.next();
        System.out.println("Podaj pensje");
        double salary = reading.nextDouble();
        // wywołaj metodę dodajPracownika() na obiekcie typu Firma
        Employee empl = new Employee(name, lastName, salary);
        boolean result = company.addEmployee(empl);

        String message = result ? "Nowy pracownik został dodany" : "Nie udało się dodać pracownika";

        System.out.println(message);
    }

    private static void printMenu() {
        System.out.println("1. Wyswietl pracownikow");
        System.out.println("2. Dodaj nowego pracownika");
        System.out.println("3. Usun pracownika");
        System.out.println("4. Wczytaj z pliku");
        System.out.println("5. Zapisz do pliku");
        System.out.println("0. Wyjście");
    }
}
