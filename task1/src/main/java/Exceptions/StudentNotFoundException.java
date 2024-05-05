package Exceptions;

import java.io.IOException;

public class StudentNotFoundException extends IOException {
    public StudentNotFoundException(){
        super("the student is not recorded");
    }
}