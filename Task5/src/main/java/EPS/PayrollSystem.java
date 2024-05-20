package EPS;

import Exceptions.EmployeeIsAlreadyRecorded;
import Exceptions.EmployeeNotFoundException;
import Exceptions.InvaliedGenderException;
import Exceptions.TaxesAlreadyDeducedException;

import java.util.LinkedList;
import java.util.Queue;

public class PayrollSystem {
    public static Queue<employee> DataBase=new LinkedList<>();

    public static void Add(String name, int age, char gender,double salary) throws InvaliedGenderException, EmployeeIsAlreadyRecorded {
        int size = DataBase.size();
        boolean e = false;
        if (DataBase.isEmpty())
            DataBase.add(new employee(name, age, gender, salary));
        else {
            for (int i = 0; i < size; i++) {
                if (DataBase.peek().getName().equals(name)) {
                    e = true;
                    break;
                }
                else
                    DataBase.add(DataBase.remove());
            }
            if (e)
                throw new EmployeeIsAlreadyRecorded();
            DataBase.add(new employee(name, age, gender, salary));
        }
    }
    public static void ChangeSalary(String name,double updated) throws EmployeeNotFoundException {
        int size = DataBase.size();
        boolean e = true;
        if (DataBase.isEmpty())
            throw new EmployeeNotFoundException();
        else {
            for (int i = 0; i < size; i++) {
                if (DataBase.peek().getName().equals(name)) {
                    e = false;
                    break;
                }
                else
                    DataBase.add(DataBase.remove());
            }
            if (e)
                throw new EmployeeNotFoundException();
            DataBase.peek().setSalary(updated);
        }
    }
    public static void taxes(String name, double taxes) throws EmployeeNotFoundException, TaxesAlreadyDeducedException {
        int size = DataBase.size();
        boolean e = true;
        if (DataBase.isEmpty())
            throw new EmployeeNotFoundException();
        else {
            for (int i = 0; i < size; i++) {
                if (DataBase.peek().getName().equals(name)) {
                    e = false;
                    break;
                }
                else
                    DataBase.add(DataBase.remove());
            }
            if (e)
                throw new EmployeeNotFoundException();
            if (DataBase.peek().getTaxes()==0) {
                DataBase.peek().setTaxes(taxes);
                DataBase.peek().updatePayroll();
            }
            else
                throw new TaxesAlreadyDeducedException();
        }
    }
    public static void deduction(String name, double deduction, String reason) throws EmployeeNotFoundException, TaxesAlreadyDeducedException {
        int size = DataBase.size();
        boolean e = true;
        if (DataBase.isEmpty())
            throw new EmployeeNotFoundException();
        else {
            for (int i = 0; i < size; i++) {
                if (DataBase.peek().getName().equals(name)) {
                    e = false;
                    break;
                }
                else
                    DataBase.add(DataBase.remove());
            }
            if (e)
                throw new EmployeeNotFoundException();
            DataBase.peek().getDeduction().add(deduction);
            DataBase.peek().getDeductionR().add(reason);
            DataBase.peek().updatePayroll();
        }
    }
    public static void payslip(String name) throws EmployeeNotFoundException {
        int size = DataBase.size();
        boolean e = true;
        if (DataBase.isEmpty())
            throw new EmployeeNotFoundException();
        else {
            for (int i = 0; i < size; i++) {
                if (DataBase.peek().getName().equals(name)) {
                    e = false;
                    break;
                }
                else
                    DataBase.add(DataBase.remove());
            }
            if (e)
                throw new EmployeeNotFoundException();
            DataBase.peek().PayrollDetails();
        }
    }
}
