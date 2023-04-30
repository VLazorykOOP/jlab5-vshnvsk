package Task1;

public class Engineer extends Worker implements Comparable<Personnel>{
    int discharge;
    public Engineer(String firstname, String lastname, String surname, int age,
                    String position, double salary, String specialization, int discharge){
        super(firstname, lastname, surname, age, position, salary, specialization);
        this.discharge = discharge;
    }

    @Override
    public String toString() {
        return super.toString() + ", Discharge: " + discharge;
    }

    @Override
    public void show(){
        super.show();
        System.out.println("Discharge: " + discharge);
    }
}
