package Exceptions;

import java.io.IOException;

public class InvaliedGenderException extends IOException {
    public InvaliedGenderException(){
        super("Invalid gender");
    }
}
