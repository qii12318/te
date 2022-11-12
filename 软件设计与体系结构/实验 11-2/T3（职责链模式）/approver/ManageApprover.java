package approver;

import java.util.ArrayList;

import manageutil.ManageMove;
import manageutil.ManageSort;

public class ManageApprover extends Approver{
    @Override
    public
    String processRequest(ArrayList<String> sentences, String type, String message) {
        // TODO Auto-generated method stub
        switch (type.split(" ")[1]){
            case "m":   return new ManageMove().setManage(sentences,Integer.valueOf(message.split(" ")[0]),
                        Integer.valueOf(message.split(" ")[1]) );
            case "s":   return new ManageSort().setManage(sentences, 0, 0);
        }
        return null;
    }
}
