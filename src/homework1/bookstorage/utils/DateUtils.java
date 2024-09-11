package homework1.bookstorage.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtils {

  private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");

  public static Date parseDate(String date) throws ParseException {
    return SDF.parse(date);
  }

  public static String parseString(Date date) {
    return SDF.format(date);
  }

}
