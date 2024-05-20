package Exceptions;

import java.io.IOException;

public class EmployeeNotFoundException extends IOException {
    public EmployeeNotFoundException(){
        super("the employee is not recorded");
    }
}