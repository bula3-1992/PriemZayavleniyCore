package utils;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author 003-0818
 */
public class DateUtils {

    public Calendar convertDatetoCalendar(String date) throws ParseException {
        if (date == null || date.length() == 0) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        cal.setTime(sdf.parse(date));
        return cal;
    }

    public Date convertCalendartoDate(Calendar calendar) throws ParseException {

        Date date = calendar.getTime();
        return date;
    }

    public Date createDate(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        if (date.contains(".")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            cal.setTime(sdf.parse(date));
        } else if (date.contains("/")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            cal.setTime(sdf.parse(date));
        }
        return cal.getTime();
    }
}
