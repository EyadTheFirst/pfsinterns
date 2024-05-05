package Exceptions;

import java.io.IOException;

public class StudentIsAlreadyRecorded extends IOException {
    public StudentIsAlreadyRecorded(){
        super("this student is already recorded");
    }
}
