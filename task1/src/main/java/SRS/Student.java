package SRS;

import Exceptions.StudentNotFoundException;

public class Student {
    private String name;
    private int rollNumber;
    private double mathGrade,englishGrade,chemistryGrade;
    public Student(){}
    public Student(String name,int rollNumber,double mathGrade,double englishGrade,double chemistryGrade){
        this.name=name;
        this.rollNumber=rollNumber;
        this.mathGrade=mathGrade;
        this.englishGrade=englishGrade;
        this.chemistryGrade=chemistryGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public double getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(double mathGrade) {
        this.mathGrade = mathGrade;
    }

    public double getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(double englishGrade) {
        this.englishGrade = englishGrade;
    }

    public double getChemistryGrade() {
        return chemistryGrade;
    }

    public void setChemistryGrade(double chemistryGrade) {
        this.chemistryGrade = chemistryGrade;
    }

    public void tostring() {

        System.out.println("Student name is: " + getName() + "\n"
                + "Roll Number is: " + getRollNumber() + "\n"
                + "Math Grade is: " + getMathGrade() + "\n"
                + "English Grade is: " + getEnglishGrade() + "\n"
                + "Chemistry Grade is: " + getChemistryGrade());
    }
}
