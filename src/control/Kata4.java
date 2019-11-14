package control;

import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

public class Kata4 {

    public static void main(String[] args) {        
        String fileName = new String("email.txt");
        /* I */ List<Mail> listMail = MailListReader.read(fileName);
        /* P */ Histogram histogram = MailHistogramBuilder.build(listMail);
        /* O */ HistogramDisplay histogramdisplay = new HistogramDisplay(histogram);
        /* O */ histogramdisplay.execute();
    } 
}
