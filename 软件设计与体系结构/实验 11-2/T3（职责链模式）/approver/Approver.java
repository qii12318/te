package approver;

import java.util.ArrayList;

public abstract class Approver{
    Approver nextApprover;
    public abstract String processRequest(ArrayList<String>sentences,String type,String message) ;
}