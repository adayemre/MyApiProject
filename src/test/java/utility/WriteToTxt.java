package utility;
import pojos.Registrant;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class WriteToTxt {
    public static void generateData(Registrant registrant, String fileName){
        try {
            FileWriter fileWriter = new FileWriter(fileName);//creates the file

            BufferedWriter writer = new BufferedWriter(fileWriter);//this creates the records in the file

            writer.append(registrant.getFirstName()+","+registrant.getLastName()+","+registrant.getLogin()+","+registrant.getSsn()+"\n");
            writer.close();
        }catch (Exception e){
        }
    }
}