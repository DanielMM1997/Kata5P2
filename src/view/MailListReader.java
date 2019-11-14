package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReader {

    public static List<Mail> read(String fileName) {
        List<Mail> list = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader (new File(fileName)));
            IteratorReader iteratorreader = new IteratorReader(reader);
            for (String line : iteratorreader) {
                if (Mail.isMail(line)){
                    list.add(new Mail(line));
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("ERROR " + e.getMessage());
        }catch(IOException ex){
            System.out.println("ERROR " + ex.getMessage());
        }
        return list;
    }

}
