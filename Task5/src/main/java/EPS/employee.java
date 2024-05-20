package EPS;

import Exceptions.EmployeeNotFoundException;
import Exceptions.InvaliedGenderException;

import java.util.ArrayList;

import static EPS.PayrollSystem.DataBase;

public class employee extends info {
    private double salary;
    private ArrayList<Double> deduction;
    private ArrayList<String> deductionR;
    private double taxes = 0;
    private double payroll;
    private int numberOfHoursWorked = 0;

    public employee(String name, int age, char gender, double salary) throws InvaliedGenderException {
        super(name, age, gender);
        this.salary = salary;
        this.payroll=salary;
        taxes=0;
        deduction = new ArrayList<>();
        deductionR = new ArrayList<>();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<Double> getDeduction() {
        return deduction;
    }

    public void setDeduction(ArrayList<Double> deduction) {
        this.deduction = deduction;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getPayroll() {
        return payroll;
    }

    public ArrayList<String> getDeductionR() {
        return deductionR;
    }

    public void setDeductionR(ArrayList<String> deductionR) {
        this.deductionR = deductionR;
    }

    public void setPayroll(double payroll) {
        this.payroll = payroll;
    }

    public int getNumberOfHoursWorked() {
        return numberOfHoursWorked;
    }

    public void setNumberOfHoursWorked(int numberOfHoursWorked) {
        this.numberOfHoursWorked = numberOfHoursWorked;
    }

    public static double getmoney(String name) throws EmployeeNotFoundException {
        int size = DataBase.size();
        boolean e = true;
        if (DataBase.isEmpty())
            throw new EmployeeNotFoundException();
        else {
            for (int i = 0; i < size; i++) {
                if (DataBase.peek().getName().equals(name)) {
                    e = false;
                    break;
                } else
                    DataBase.add(DataBase.remove());
            }
            if (e)
                throw new EmployeeNotFoundException();
            DataBase.peek().updatePayroll();
            return DataBase.peek().getPayroll();
        }
    }

    public void updatePayroll(){
        double DeductionSum=0;
        for (int i = 0; i < getDeduction().size(); i++) {
            DeductionSum+=getDeduction().get(i);
        }
        this.setPayroll(this.getSalary()-this.getTaxes()-DeductionSum);
    }
    public static StringBuilder PayrollDetailsn(String name) throws EmployeeNotFoundException {
        int size = DataBase.size();
        boolean e = true;
        if (DataBase.isEmpty())
            throw new EmployeeNotFoundException();
        else {
            for (int i = 0; i < size; i++) {
                if (DataBase.peek().getName().equals(name)) {
                    e = false;
                    break;
                } else
                    DataBase.add(DataBase.remove());
            }
            if (e)
                throw new EmployeeNotFoundException();
            DataBase.peek().updatePayroll();
            return DataBase.peek().PayrollDetails();
        }
    }
    public StringBuilder PayrollDetails(){
        StringBuilder r= new StringBuilder();
        r.append("Original Salary: ").append(getSalary()).append("\n").append("Taxes: (-) ").append(getTaxes()).append("\n");
        for (int i = 0; i < getDeduction().size(); i++) {
            r.append("Deduction because of ").append(getDeductionR().get(i)).append(" : (-) ").append(getDeduction().get(i)).append("\n");
        }
        r.append("-----------------------").append("\n");
        r.append("the payroll is: ").append(getPayroll());
        return r;
    }
}
