package Inheritance.student;

/**
 * Created by teacher on 05.02.17.
 */
public class Student extends Man {
    int yearOfStudy;

    public Student(String name, int age, boolean male, double weight, int yearOfStudy) {
        super(name, age, male, weight);
        this.yearOfStudy = yearOfStudy;
    }

    public Student() {
        super();
        this.yearOfStudy = 1;
    }

    @Override
    public String toString() {
        return super.toString()+" "+ yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void incYearOfStudy() {
        this.yearOfStudy++;
    }

    public Student myClone(){
        return  new Student(name,age,male,weight,yearOfStudy);
    }


}
