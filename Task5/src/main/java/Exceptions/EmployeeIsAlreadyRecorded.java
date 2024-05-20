package Exceptions;

import java.io.IOException;

public class EmployeeIsAlreadyRecorded extends IOException {
    public EmployeeIsAlreadyRecorded(){
        super("this Employee is already recorded");
    }
}
