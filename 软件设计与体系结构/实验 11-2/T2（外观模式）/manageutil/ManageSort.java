package manageutil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManageSort implements ManageInterface{
    @Override
    public String setManage(ArrayList<String> sentences, int num, int pos) {
        Collections.sort(sentences,new Comparator<String>() {
            public int compare(String s1, String s2) {
                String s3=s1.toLowerCase();
                String s4=s2.toLowerCase();
                return s3.charAt(0)-s4.charAt(0);
            };
        });
        return "已完成排序";
    }
}