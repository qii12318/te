package inutil;

import java.io.IOException;
import java.security.Security;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

public class InputDB implements InputInterface {
    public String setInput(ArrayList<String> sentences,String message){
        Security.setProperty("jdk.tls.disabledAlgorithms","SSLv3, RC4, DES, MD5withRSA, DH keySize < 1024, EC keySize < 224, 3DES_EDE_CBC, anon, NULL, include jdk.disabled.namedCurves");
        String driverName="jdbc.jar";
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=English";
        String userName="sa0";
        String userPwd="123456";
        try (Connection con=DriverManager.getConnection(dbURL, userName, userPwd)){
            ResultSet re=con.createStatement().executeQuery("select * from sentencestable)");
            while (re.next()){
                sentences.add((re.getString("sentences"))) ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "数据库输入暂不可用";
        }
        return "数据库输入成功";
    }
    
}
