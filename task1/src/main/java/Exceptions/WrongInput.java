package Exceptions;

import java.io.IOException;

public class WrongInput extends IOException {
    public WrongInput(){
        super("Wrong Input");
    }
}
