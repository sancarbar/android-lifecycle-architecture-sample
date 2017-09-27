package co.gdg.android.lifecycleComponents.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Santiago Carrillo
 */

public class DateUtil
{

    public static String formatTime( String format, Date date )
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat( format, Locale.getDefault() );
        dateFormat.setTimeZone( Calendar.getInstance().getTimeZone() );
        return dateFormat.format( date );
    }
}
