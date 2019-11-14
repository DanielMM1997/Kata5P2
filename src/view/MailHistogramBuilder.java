package view;

import java.util.List;
import model.Histogram;
import model.Mail;

public class MailHistogramBuilder {

    public static Histogram build(List<Mail> listMail) {
        Histogram<String> histogram = new Histogram();
        for (Mail mail : listMail) {
            histogram.increment(mail.getDomain());
        }
        return histogram;
    }
    
}
