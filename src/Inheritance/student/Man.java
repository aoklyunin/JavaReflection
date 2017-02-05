package Inheritance.student;

/**
 * Created by teacher on 05.02.17.
 */
public class Man {
    String name;
    int age;
    boolean male;
    double weight;

    public Man(String name, int age, boolean male, double weight) {
        this.name = name;
        this.age = age;
        this.male = male;
        this.weight = weight;
    }

    public Man() {
        this.name = "Ivan";
        this.age = 18;
        this.male = false;
        this.weight = 60;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public Man myClone(){
        return  new Man(name,age,male,weight);
    }

    @Override
    public String toString() {
        return name + ':' + age + "/"+ (male?"female":"male") +" (" + weight +")";
    }
}
