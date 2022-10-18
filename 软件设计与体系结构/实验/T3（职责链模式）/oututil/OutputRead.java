package oututil;

import java.util.ArrayList;

public class OutputRead implements OutputInterface {
    @Override
    public String setOutput(ArrayList<String> sentences, String message) {
        String outcome="";
        for(int i=0;i<sentences.size();i++){
            outcome+=""+(i+1)+"、"+sentences.get(i)+"\n";
        }
        return outcome;
    }
}
