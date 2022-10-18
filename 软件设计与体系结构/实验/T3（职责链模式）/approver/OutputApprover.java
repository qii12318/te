package approver;

import java.util.ArrayList;

public class OutputApprover extends Approver{
    OutputApprover(){
        this.nextApprover=new InputApprover();
    }
    @Override
    String processRequest(ArrayList<String> sentences) {
        // TODO Auto-generated method stub
        return null;
    }
}
