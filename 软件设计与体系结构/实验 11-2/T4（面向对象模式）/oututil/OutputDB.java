package oututil;
import java.security.Security;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OutputDB implements OutputInterface {
    public String setOutput(ArrayList<String> sentences,String message){
        Security.setProperty("jdk.tls.disabledAlgorithms",
        "SSLv3, RC4, DES, MD5withRSA, DH keySize < 1024, EC keySize < 224, 3DES_EDE_CBC, anon, NULL, include jdk.disabled.namedCurves");
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=English";
        String userName="sa0";
        String userPwd="123456";
        try (Connection con=DriverManager.getConnection(dbURL, userName, userPwd)){
            ResultSet re=con.createStatement().executeQuery("delete * from sentencestable");
            int Sno=1;
            for(int i=0;i<sentences.size();i++){
                re=con.createStatement().executeQuery(
                    "insert into sentencestable values (Sno,sen)  values ("+Sno+i
                    +", '"+sentences.get(i)+"')");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "数据库输出暂不可用";
        }
        return "数据库输出成功";
    }
    
}
