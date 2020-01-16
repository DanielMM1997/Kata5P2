package view;

import java.util.List;
import model.Histogram;
import model.Mail;

public class MailHistogramBuilder {

    public static Histogram build(List<String> listMail) {
        Histogram<String> histogram = new Histogram();
        for (String mail : listMail) {
            histogram.increment(mail);
        }
        return histogram;
    }
    
}
