package Exceptions;

import java.io.IOException;

public class NotNumericalValue extends IOException {
    public NotNumericalValue(){
        super("Please enter numerical value");
    }
}
