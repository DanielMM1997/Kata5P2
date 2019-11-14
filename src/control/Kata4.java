package control;

import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

public class Kata4 {
    
    private static Histogram histogram;
    private static List<Mail> listMail;
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
        //String fileName = new String("email.txt");
        listMail = MailListReader.read("email.txt");
    }
    
    private static void process() throws Exception {
        histogram = MailHistogramBuilder.build(listMail);        
    }

    private static void output() {
        histogramdisplay = new HistogramDisplay(histogram);
        histogramdisplay.execute();
    }
}