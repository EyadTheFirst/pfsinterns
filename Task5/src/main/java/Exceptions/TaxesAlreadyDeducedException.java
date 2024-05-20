package Exceptions;

import java.io.IOException;

public class TaxesAlreadyDeducedException extends IOException {
    public TaxesAlreadyDeducedException(){
        super("the employee's taxes is already deduced");
    }
}

