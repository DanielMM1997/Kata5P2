package control;

import java.util.List;
import model.*;
import view.*;

public class Kata4 {
    
    private static Histogram histogram;
    private static List<String> listMail;
    private static HistogramDisplay histogramdisplay;
    
    public static void main(String[] args) throws Exception {        
        execute();
    }   
    
    private static void execute() throws Exception {
        input();
        process();
        output();
    }
    
    private static void input() {
        listMail = MailListReaderDB.read("email.txt");
    }
    
    private static void process() throws Exception {
        String URL = "jdbc:sqlite:Kata5_DB.db";
        DataBase db = new DataBase(URL);
        db.open();
        histogram = MailHistogramBuilder.build(listMail);  
        db.close();
    }

    private static void output() {
        histogramdisplay = new HistogramDisplay(histogram);
        histogramdisplay.execute();
    }
}