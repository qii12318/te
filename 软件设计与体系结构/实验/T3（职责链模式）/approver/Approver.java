package approver;

import java.util.ArrayList;

public abstract class Approver{
    Approver nextApprover;
    abstract String processRequest(ArrayList<String>sentences,String message) ;
}