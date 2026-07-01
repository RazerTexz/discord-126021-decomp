package b.g.a.c.i0;

import androidx.core.app.NotificationManagerCompat;
import com.discord.utilities.time.TimeUtils$UTCFormat;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: StdDateFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public class r extends DateFormat {
    public static final Pattern j = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");
    public static final Pattern k;
    public static final String[] l;
    public static final TimeZone m;
    public static final Locale n;
    public static final DateFormat o;
    public static final r p;
    public static final Calendar q;
    public Boolean _lenient;
    public final Locale _locale;
    private boolean _tzSerializedWithColon;
    public transient TimeZone r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public transient Calendar f729s;
    public transient DateFormat t;

    static {
        try {
            k = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");
            l = new String[]{"yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", TimeUtils$UTCFormat.SHORT};
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            m = timeZone;
            Locale locale = Locale.US;
            n = locale;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale);
            o = simpleDateFormat;
            simpleDateFormat.setTimeZone(timeZone);
            p = new r();
            q = new GregorianCalendar(timeZone, locale);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public r() {
        this._tzSerializedWithColon = true;
        this._locale = n;
    }

    public static int f(String str, int i) {
        return (str.charAt(i + 1) - '0') + ((str.charAt(i) - '0') * 10);
    }

    public static int g(String str, int i) {
        return (str.charAt(i + 3) - '0') + ((str.charAt(i + 2) - '0') * 10) + ((str.charAt(i + 1) - '0') * 100) + ((str.charAt(i) - '0') * 1000);
    }

    public static void j(StringBuffer stringBuffer, int i) {
        int i2 = i / 10;
        if (i2 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i2 + 48));
            i -= i2 * 10;
        }
        stringBuffer.append((char) (i + 48));
    }

    public static void k(StringBuffer stringBuffer, int i) {
        int i2 = i / 100;
        if (i2 == 0) {
            stringBuffer.append('0');
            stringBuffer.append('0');
        } else {
            if (i2 > 99) {
                stringBuffer.append(i2);
            } else {
                j(stringBuffer, i2);
            }
            i -= i2 * 100;
        }
        j(stringBuffer, i);
    }

    public Calendar b(TimeZone timeZone) {
        Calendar calendar = this.f729s;
        if (calendar == null) {
            calendar = (Calendar) q.clone();
            this.f729s = calendar;
        }
        if (!calendar.getTimeZone().equals(timeZone)) {
            calendar.setTimeZone(timeZone);
        }
        calendar.setLenient(isLenient());
        return calendar;
    }

    @Override // java.text.DateFormat, java.text.Format
    public Object clone() {
        return new r(this.r, this._locale, this._lenient, this._tzSerializedWithColon);
    }

    @Override // java.text.DateFormat
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone = this.r;
        if (timeZone == null) {
            timeZone = m;
        }
        Calendar calendarB = b(timeZone);
        calendarB.setTime(date);
        int i = calendarB.get(1);
        if (calendarB.get(0) != 0) {
            if (i > 9999) {
                stringBuffer.append('+');
            }
            k(stringBuffer, i);
        } else if (i == 1) {
            stringBuffer.append("+0000");
        } else {
            stringBuffer.append('-');
            k(stringBuffer, i - 1);
        }
        stringBuffer.append('-');
        j(stringBuffer, calendarB.get(2) + 1);
        stringBuffer.append('-');
        j(stringBuffer, calendarB.get(5));
        stringBuffer.append('T');
        j(stringBuffer, calendarB.get(11));
        stringBuffer.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        j(stringBuffer, calendarB.get(12));
        stringBuffer.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        j(stringBuffer, calendarB.get(13));
        stringBuffer.append('.');
        int i2 = calendarB.get(14);
        int i3 = i2 / 100;
        if (i3 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i3 + 48));
            i2 -= i3 * 100;
        }
        j(stringBuffer, i2);
        int offset = timeZone.getOffset(calendarB.getTimeInMillis());
        if (offset != 0) {
            int i4 = offset / 60000;
            int iAbs = Math.abs(i4 / 60);
            int iAbs2 = Math.abs(i4 % 60);
            stringBuffer.append(offset < 0 ? '-' : '+');
            j(stringBuffer, iAbs);
            if (this._tzSerializedWithColon) {
                stringBuffer.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
            }
            j(stringBuffer, iAbs2);
        } else if (this._tzSerializedWithColon) {
            stringBuffer.append("+00:00");
        } else {
            stringBuffer.append("+0000");
        }
        return stringBuffer;
    }

    @Override // java.text.DateFormat
    public TimeZone getTimeZone() {
        return this.r;
    }

    public Date h(String str) throws ParseException, IllegalArgumentException {
        char c;
        String str2;
        int length = str.length();
        TimeZone timeZone = m;
        if (this.r != null && 'Z' != str.charAt(length - 1)) {
            timeZone = this.r;
        }
        Calendar calendarB = b(timeZone);
        calendarB.clear();
        int iCharAt = 0;
        if (length > 10) {
            Matcher matcher = k.matcher(str);
            if (matcher.matches()) {
                int iStart = matcher.start(2);
                int iEnd = matcher.end(2);
                int i = iEnd - iStart;
                if (i > 1) {
                    int iF = f(str, iStart + 1) * 3600;
                    if (i >= 5) {
                        iF += f(str, iEnd - 2) * 60;
                    }
                    calendarB.set(15, str.charAt(iStart) == '-' ? iF * NotificationManagerCompat.IMPORTANCE_UNSPECIFIED : iF * 1000);
                    calendarB.set(16, 0);
                }
                calendarB.set(g(str, 0), f(str, 5) - 1, f(str, 8), f(str, 11), f(str, 14), (length <= 16 || str.charAt(16) != ':') ? 0 : f(str, 17));
                int iStart2 = matcher.start(1) + 1;
                int iEnd2 = matcher.end(1);
                if (iStart2 >= iEnd2) {
                    calendarB.set(14, 0);
                } else {
                    int i2 = iEnd2 - iStart2;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3 && i2 > 9) {
                                    throw new ParseException(String.format("Cannot parse date \"%s\": invalid fractional seconds '%s'; can use at most 9 digits", str, matcher.group(1).substring(1)), iStart2);
                                }
                                iCharAt = 0 + (str.charAt(iStart2 + 2) - '0');
                            }
                            iCharAt += (str.charAt(iStart2 + 1) - '0') * 10;
                        }
                        iCharAt += (str.charAt(iStart2) - '0') * 100;
                    }
                    calendarB.set(14, iCharAt);
                }
                return calendarB.getTime();
            }
            c = 1;
            str2 = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
        } else {
            if (j.matcher(str).matches()) {
                calendarB.set(g(str, 0), f(str, 5) - 1, f(str, 8), 0, 0, 0);
                calendarB.set(14, 0);
                return calendarB.getTime();
            }
            str2 = TimeUtils$UTCFormat.SHORT;
            c = 1;
        }
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[c] = str2;
        objArr[2] = this._lenient;
        throw new ParseException(String.format("Cannot parse date \"%s\": while it seems to fit format '%s', parsing fails (leniency? %s)", objArr), 0);
    }

    @Override // java.text.DateFormat
    public int hashCode() {
        return System.identityHashCode(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x009f, code lost:
    
        if (r0 != false) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Date i(String str, ParsePosition parsePosition) throws ParseException {
        DateFormat simpleDateFormat;
        boolean z2;
        if (str.length() >= 7 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(3)) && str.charAt(4) == '-' && Character.isDigit(str.charAt(5))) {
            try {
                return h(str);
            } catch (IllegalArgumentException e) {
                throw new ParseException(String.format("Cannot parse date \"%s\", problem: %s", str, e.getMessage()), parsePosition.getErrorIndex());
            }
        }
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            char cCharAt = str.charAt(length);
            if (cCharAt < '0' || cCharAt > '9') {
                if (length > 0 || cCharAt != '-') {
                    break;
                }
            }
        }
        if (length < 0) {
            if (str.charAt(0) != '-') {
                String str2 = b.g.a.b.p.f.f668b;
                int length2 = str2.length();
                int length3 = str.length();
                if (length3 >= length2) {
                    if (length3 <= length2) {
                        int i = 0;
                        while (true) {
                            if (i < length2) {
                                int iCharAt = str.charAt(i) - str2.charAt(i);
                                if (iCharAt == 0) {
                                    i++;
                                } else if (iCharAt < 0) {
                                }
                            }
                            z2 = true;
                        }
                    }
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            try {
                return new Date(b.g.a.b.p.f.a(str));
            } catch (NumberFormatException unused) {
                throw new ParseException(String.format("Timestamp value %s out of 64-bit value range", str), parsePosition.getErrorIndex());
            }
        }
        if (this.t == null) {
            DateFormat dateFormat = o;
            TimeZone timeZone = this.r;
            Locale locale = this._locale;
            Boolean bool = this._lenient;
            if (locale.equals(n)) {
                simpleDateFormat = (DateFormat) dateFormat.clone();
                if (timeZone != null) {
                    simpleDateFormat.setTimeZone(timeZone);
                }
            } else {
                simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale);
                if (timeZone == null) {
                    timeZone = m;
                }
                simpleDateFormat.setTimeZone(timeZone);
            }
            if (bool != null) {
                simpleDateFormat.setLenient(bool.booleanValue());
            }
            this.t = simpleDateFormat;
        }
        return this.t.parse(str, parsePosition);
    }

    @Override // java.text.DateFormat
    public boolean isLenient() {
        Boolean bool = this._lenient;
        return bool == null || bool.booleanValue();
    }

    public r l(Locale locale) {
        return locale.equals(this._locale) ? this : new r(this.r, locale, this._lenient, this._tzSerializedWithColon);
    }

    public r m(TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = m;
        }
        TimeZone timeZone2 = this.r;
        return (timeZone == timeZone2 || timeZone.equals(timeZone2)) ? this : new r(timeZone, this._locale, this._lenient, this._tzSerializedWithColon);
    }

    @Override // java.text.DateFormat
    public Date parse(String str) throws ParseException {
        String strTrim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date dateI = i(strTrim, parsePosition);
        if (dateI != null) {
            return dateI;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : l) {
            if (sb.length() > 0) {
                sb.append("\", \"");
            } else {
                sb.append('\"');
            }
            sb.append(str2);
        }
        sb.append('\"');
        throw new ParseException(String.format("Cannot parse date \"%s\": not compatible with any of standard forms (%s)", strTrim, sb.toString()), parsePosition.getErrorIndex());
    }

    @Override // java.text.DateFormat
    public void setLenient(boolean z2) {
        Boolean boolValueOf = Boolean.valueOf(z2);
        Boolean bool = this._lenient;
        if (boolValueOf == bool || (boolValueOf != null && boolValueOf.equals(bool))) {
            return;
        }
        this._lenient = boolValueOf;
        this.t = null;
    }

    @Override // java.text.DateFormat
    public void setTimeZone(TimeZone timeZone) {
        if (timeZone.equals(this.r)) {
            return;
        }
        this.t = null;
        this.r = timeZone;
    }

    public String toString() {
        return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", r.class.getName(), this.r, this._locale, this._lenient);
    }

    public r(TimeZone timeZone, Locale locale, Boolean bool, boolean z2) {
        this._tzSerializedWithColon = true;
        this.r = timeZone;
        this._locale = locale;
        this._lenient = bool;
        this._tzSerializedWithColon = z2;
    }

    @Override // java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        try {
            return i(str, parsePosition);
        } catch (ParseException unused) {
            return null;
        }
    }
}
