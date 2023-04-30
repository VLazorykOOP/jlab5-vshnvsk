import java.util.*;
import java.io.*;
import Task1.*;
import static Checkers.onlyNumbers.*;
import static Checkers.onlyLetters.*;
import static Checkers.positive.*;
public class Task1 {
    public static void main(String[] args) {

        List<Worker> workers = readWorkerFromFile();
        List<Administration> administrations = readAdministrationFromFile();
        List<Engineer> engineers = readEngineerFromFile();

        System.out.println("Information about Workers: ");
        for(Worker w : workers){
            System.out.println(w);
        }
        System.out.println(" ");

        System.out.println("Information about Administration: ");
        for(Administration a : administrations){
            System.out.println(a);
        }
        System.out.println(" ");

        System.out.println("Information about Engineer:");
        for(Engineer e : engineers){
            System.out.println(e);
        }
        System.out.println(" ");

        Collections.sort(workers);
        Collections.sort(administrations);
        Collections.sort(engineers);

        System.out.println("---After sorting by name---");

        System.out.println("Information about Workers: ");
        for(Worker w : workers){
            System.out.println(w);
        }
        System.out.println(" ");

        System.out.println("Information about Administration: ");
        for(Administration a : administrations){
            System.out.println(a);
        }
        System.out.println(" ");

        System.out.println("Information about Engineer:");
        for(Engineer e : engineers){
            System.out.println(e);
        }
        System.out.println(" ");

        addPersonnel(workers, administrations, engineers);
        Collections.sort(workers);
        Collections.sort(administrations);
        Collections.sort(engineers);

        System.out.println("---Sorting after adding---");

        System.out.println("Information about Workers: ");
        for(Worker w : workers){
            System.out.println(w);
        }
        System.out.println(" ");

        System.out.println("Information about Administration: ");
        for(Administration a : administrations){
            System.out.println(a);
        }
        System.out.println(" ");

        System.out.println("Information about Engineer:");
        for(Engineer e : engineers){
            System.out.println(e);
        }
        System.out.println(" ");

        List<Personnel> personnels = new ArrayList<>();
        personnels.addAll(workers);
        personnels.addAll(administrations);
        personnels.addAll(engineers);
        Collections.sort(personnels);

        System.out.println("---Sorted list---");
        for (Personnel p : personnels){
            System.out.println(p);
        }

        Comparator<Personnel> personnelComparator = Comparator.comparing(Personnel::getFirstname);
        Collections.sort(personnels, personnelComparator);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("files" + File.separator + "output.txt"))){
            for(Personnel p : personnels){
                writer.write(p + " ");
                writer.newLine();
            }
        } catch (IOException e){
            System.out.println("Error reading data from file: " + e.getMessage());
        }
    }

    static List<Worker> readWorkerFromFile() {
        List<Worker> workers = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader("files" + File.separator + "Worker.txt"))){
            String line;
            while ((line = fileReader.readLine()) != null){
                String[] parts = line.split(",");
                String firstname = parts[0];
                String lastname = parts[1];
                String surname = parts[2];
                int age = Integer.parseInt(parts[3]);
                String position = parts[4];
                double salary = Double.parseDouble(parts[5]);
                String specialization = parts[6];
                Worker worker = new Worker(firstname, lastname, surname, age, position, salary, specialization);
                workers.add(worker);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: invalid number format: " + e.getMessage());
        }
        return workers;
    }

    static List<Administration> readAdministrationFromFile() {
        List<Administration> administrations = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader("files" + File.separator + "Administration.txt"))){
            String line;
            while ((line = fileReader.readLine()) != null){
                String[] parts = line.split(",");
                String firstname = parts[0];
                String lastname = parts[1];
                String surname = parts[2];
                int age = Integer.parseInt(parts[3]);
                String position = parts[4];
                double salary = Double.parseDouble(parts[5]);
                double bonus = Double.parseDouble(parts[6]);
                double salaryWithBonus = Double.parseDouble(parts[7]);
                Administration administration = new Administration(firstname, lastname, surname, age, position, salary, bonus, salaryWithBonus);
                administrations.add(administration);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: invalid number format: " + e.getMessage());
        }
        return administrations;
    }

    static List<Engineer> readEngineerFromFile(){
        List<Engineer> engineers = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader("files" + File.separator + "Engineer.txt"))){
            String line;
            while ((line = fileReader.readLine()) != null){
                String[] parts = line.split(",");
                String firstname = parts[0];
                String lastname = parts[1];
                String surname = parts[2];
                int age = Integer.parseInt(parts[3]);
                String position = parts[4];
                double salary = Double.parseDouble(parts[5]);
                String specialization = parts[6];
                int discharge = Integer.parseInt(parts[7]);
                Engineer engineer = new Engineer(firstname, lastname, surname, age, position, salary, specialization, discharge);
                engineers.add(engineer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: invalid number format: " + e.getMessage());
        }
        return engineers;
    }

    static void addPersonnel(List<Worker> workers, List<Administration> administrations, List<Engineer> engineers){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of personnel:");
        int n = getPositiveInteger();

        int category = 1;
        for (int i = 0; i < n; i++){
            do{
                System.out.println("Select the personnel category:");
                System.out.println("1. Administration");
                System.out.println("2. Worker");
                System.out.println("3. Engineer");
                System.out.println("4. Exit");
                category = getPositiveInteger();
            } while (category < 1 || category > 4);

            switch (category){
                case 1:
                    System.out.println("Enter firstname: ");
                    String firstname = getString();

                    System.out.println("Enter lastname: ");
                    String lastname = getString();

                    System.out.println("Enter surname: ");
                    String surname = getString();

                    System.out.println("Enter age: ");
                    int age = getPositiveInteger();

                    System.out.println("Enter position: ");
                    String position = getString();

                    System.out.println("Enter salary: ");
                    double salary = getDouble();

                    System.out.println("Enter bonus:");
                    double bonus = getDouble();

                    double salaryWithBonus = salary + bonus;
                    Administration administration = new Administration(firstname, lastname, surname,
                            age, position, salary, bonus, salaryWithBonus);
                    administrations.add(administration);
                    break;
                case 2:
                    System.out.println("Enter firstname: ");
                    String firstname1 = getString();

                    System.out.println("Enter lastname: ");
                    String lastname1 = getString();

                    System.out.println("Enter surname: ");
                    String surname1 = getString();

                    System.out.println("Enter age: ");
                    int age1 = getPositiveInteger();

                    System.out.println("Enter position: ");
                    String position1 = getString();

                    System.out.println("Enter salary: ");
                    double salary1 = getDouble();

                    System.out.println("Enter specialization: ");
                    String specialization = getString();

                    Worker worker = new Worker(firstname1, lastname1, surname1, age1, position1,
                            salary1, specialization);
                    workers.add(worker);
                    break;
                case 3:
                    System.out.println("Enter firstname: ");
                    String firstname2 = getString();

                    System.out.println("Enter lastname: ");
                    String lastname2 = getString();

                    System.out.println("Enter surname: ");
                    String surname2 = getString();

                    System.out.println("Enter age: ");
                    int age2 = getPositiveInteger();

                    System.out.println("Enter position: ");
                    String position2 = getString();

                    System.out.println("Enter salary: ");
                    double salary2 = getDouble();

                    System.out.println("Enter specialization: ");
                    String specialization2 = getString();

                    int discharge;
                    do{
                        System.out.println("Enter discharge (1, 2, 3):");
                        discharge = getPositiveInteger();
                    }while (discharge < 1 || discharge > 3);

                    Engineer engineer = new Engineer(firstname2, lastname2, surname2, age2,
                            position2, salary2, specialization2, discharge);
                    engineers.add(engineer);
                    break;
                case 4:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("No matches!");
            }
        }
    }
}

