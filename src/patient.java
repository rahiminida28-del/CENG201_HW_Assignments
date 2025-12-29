 //patients information

public class patient {
   public int id;    // here you can write patient id number
     public String name; // here you can mention patients fullname
    public int sickness; // here you can mention what is the problem
    public int age; // write patient age
    public patient(int id, String name, int sickness, int age) {
        this.id = id;
        this.name = name;
        this.sickness = sickness;
        this.age = age;

    }
    // I am using this method to read all thing  clearly

    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name + ", Sickness: " + this.sickness + ", Age: " + this.age;
    }
    }
