package Task1;

public class Personnel implements Comparable<Personnel>{
    String firstname;
    String lastname;
    String surname;
    int age;
    String position;
    double salary;

    public String getFirstname() {
        return firstname;
    }

    public Personnel(String firstname, String lastname, String surname,
                     int age, String position, double salary){
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }
    public void show(){
        System.out.println("Firstname: " + firstname);
        System.out.println("Lastname: " + lastname);
        System.out.println("Surname: " + surname);
        System.out.println("Age: " + age + " y.o.");
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary + " UAN");
    }

    @Override
    public String toString() {
        return "Firstname: " + firstname + ", Lastname: " + lastname + ", Surname: " + surname +
                ", Age: " + age + ", Position: " + position + ", Salary: " + salary;
    }

    @Override
    public int compareTo(Personnel otherPersonnel) {
        int res = this.firstname.compareTo(otherPersonnel.firstname);
        if(res == 0){
            res = this.lastname.compareTo(otherPersonnel.lastname);

            if(res == 0){
                res = this.surname.compareTo(otherPersonnel.surname);
            }
        }
        return res;
    }
}
