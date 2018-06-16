package helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Config {

    public Config() {
    }

    public Date convertDate(String dateString) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("d-MM-yy");
        Date date = formatter.parse(dateString);
        return date;
    }
}
