package p007b.p195g.p196a.p205c.p219i0;

import androidx.core.app.NotificationManagerCompat;
import com.discord.utilities.time.TimeUtils;
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
import p007b.p195g.p196a.p198b.p200p.C2126f;

/* JADX INFO: renamed from: b.g.a.c.i0.r */
/* JADX INFO: compiled from: StdDateFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2356r extends DateFormat {

    /* JADX INFO: renamed from: j */
    public static final Pattern f4968j = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");

    /* JADX INFO: renamed from: k */
    public static final Pattern f4969k;

    /* JADX INFO: renamed from: l */
    public static final String[] f4970l;

    /* JADX INFO: renamed from: m */
    public static final TimeZone f4971m;

    /* JADX INFO: renamed from: n */
    public static final Locale f4972n;

    /* JADX INFO: renamed from: o */
    public static final DateFormat f4973o;

    /* JADX INFO: renamed from: p */
    public static final C2356r f4974p;

    /* JADX INFO: renamed from: q */
    public static final Calendar f4975q;
    public Boolean _lenient;
    public final Locale _locale;
    private boolean _tzSerializedWithColon;

    /* JADX INFO: renamed from: r */
    public transient TimeZone f4976r;

    /* JADX INFO: renamed from: s */
    public transient Calendar f4977s;

    /* JADX INFO: renamed from: t */
    public transient DateFormat f4978t;

    static {
        try {
            f4969k = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");
            f4970l = new String[]{"yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", TimeUtils.UTCFormat.SHORT};
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            f4971m = timeZone;
            Locale locale = Locale.US;
            f4972n = locale;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale);
            f4973o = simpleDateFormat;
            simpleDateFormat.setTimeZone(timeZone);
            f4974p = new C2356r();
            f4975q = new GregorianCalendar(timeZone, locale);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public C2356r() {
        this._tzSerializedWithColon = true;
        this._locale = f4972n;
    }

    /* JADX INFO: renamed from: f */
    public static int m2204f(String str, int i) {
        return (str.charAt(i + 1) - '0') + ((str.charAt(i) - '0') * 10);
    }

    /* JADX INFO: renamed from: g */
    public static int m2205g(String str, int i) {
        return (str.charAt(i + 3) - '0') + ((str.charAt(i + 2) - '0') * 10) + ((str.charAt(i + 1) - '0') * 100) + ((str.charAt(i) - '0') * 1000);
    }

    /* JADX INFO: renamed from: j */
    public static void m2206j(StringBuffer stringBuffer, int i) {
        int i2 = i / 10;
        if (i2 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i2 + 48));
            i -= i2 * 10;
        }
        stringBuffer.append((char) (i + 48));
    }

    /* JADX INFO: renamed from: k */
    public static void m2207k(StringBuffer stringBuffer, int i) {
        int i2 = i / 100;
        if (i2 == 0) {
            stringBuffer.append('0');
            stringBuffer.append('0');
        } else {
            if (i2 > 99) {
                stringBuffer.append(i2);
            } else {
                m2206j(stringBuffer, i2);
            }
            i -= i2 * 100;
        }
        m2206j(stringBuffer, i);
    }

    /* JADX INFO: renamed from: b */
    public Calendar m2208b(TimeZone timeZone) {
        Calendar calendar = this.f4977s;
        if (calendar == null) {
            calendar = (Calendar) f4975q.clone();
            this.f4977s = calendar;
        }
        if (!calendar.getTimeZone().equals(timeZone)) {
            calendar.setTimeZone(timeZone);
        }
        calendar.setLenient(isLenient());
        return calendar;
    }

    @Override // java.text.DateFormat, java.text.Format
    public Object clone() {
        return new C2356r(this.f4976r, this._locale, this._lenient, this._tzSerializedWithColon);
    }

    @Override // java.text.DateFormat
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone = this.f4976r;
        if (timeZone == null) {
            timeZone = f4971m;
        }
        Calendar calendarM2208b = m2208b(timeZone);
        calendarM2208b.setTime(date);
        int i = calendarM2208b.get(1);
        if (calendarM2208b.get(0) != 0) {
            if (i > 9999) {
                stringBuffer.append('+');
            }
            m2207k(stringBuffer, i);
        } else if (i == 1) {
            stringBuffer.append("+0000");
        } else {
            stringBuffer.append('-');
            m2207k(stringBuffer, i - 1);
        }
        stringBuffer.append('-');
        m2206j(stringBuffer, calendarM2208b.get(2) + 1);
        stringBuffer.append('-');
        m2206j(stringBuffer, calendarM2208b.get(5));
        stringBuffer.append('T');
        m2206j(stringBuffer, calendarM2208b.get(11));
        stringBuffer.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        m2206j(stringBuffer, calendarM2208b.get(12));
        stringBuffer.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        m2206j(stringBuffer, calendarM2208b.get(13));
        stringBuffer.append('.');
        int i2 = calendarM2208b.get(14);
        int i3 = i2 / 100;
        if (i3 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i3 + 48));
            i2 -= i3 * 100;
        }
        m2206j(stringBuffer, i2);
        int offset = timeZone.getOffset(calendarM2208b.getTimeInMillis());
        if (offset != 0) {
            int i4 = offset / 60000;
            int iAbs = Math.abs(i4 / 60);
            int iAbs2 = Math.abs(i4 % 60);
            stringBuffer.append(offset < 0 ? '-' : '+');
            m2206j(stringBuffer, iAbs);
            if (this._tzSerializedWithColon) {
                stringBuffer.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
            }
            m2206j(stringBuffer, iAbs2);
        } else if (this._tzSerializedWithColon) {
            stringBuffer.append("+00:00");
        } else {
            stringBuffer.append("+0000");
        }
        return stringBuffer;
    }

    @Override // java.text.DateFormat
    public TimeZone getTimeZone() {
        return this.f4976r;
    }

    /* JADX INFO: renamed from: h */
    public Date m2209h(String str) throws ParseException, IllegalArgumentException {
        char c;
        String str2;
        int length = str.length();
        TimeZone timeZone = f4971m;
        if (this.f4976r != null && 'Z' != str.charAt(length - 1)) {
            timeZone = this.f4976r;
        }
        Calendar calendarM2208b = m2208b(timeZone);
        calendarM2208b.clear();
        int iCharAt = 0;
        if (length > 10) {
            Matcher matcher = f4969k.matcher(str);
            if (matcher.matches()) {
                int iStart = matcher.start(2);
                int iEnd = matcher.end(2);
                int i = iEnd - iStart;
                if (i > 1) {
                    int iM2204f = m2204f(str, iStart + 1) * 3600;
                    if (i >= 5) {
                        iM2204f += m2204f(str, iEnd - 2) * 60;
                    }
                    calendarM2208b.set(15, str.charAt(iStart) == '-' ? iM2204f * NotificationManagerCompat.IMPORTANCE_UNSPECIFIED : iM2204f * 1000);
                    calendarM2208b.set(16, 0);
                }
                calendarM2208b.set(m2205g(str, 0), m2204f(str, 5) - 1, m2204f(str, 8), m2204f(str, 11), m2204f(str, 14), (length <= 16 || str.charAt(16) != ':') ? 0 : m2204f(str, 17));
                int iStart2 = matcher.start(1) + 1;
                int iEnd2 = matcher.end(1);
                if (iStart2 >= iEnd2) {
                    calendarM2208b.set(14, 0);
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
                    calendarM2208b.set(14, iCharAt);
                }
                return calendarM2208b.getTime();
            }
            c = 1;
            str2 = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
        } else {
            if (f4968j.matcher(str).matches()) {
                calendarM2208b.set(m2205g(str, 0), m2204f(str, 5) - 1, m2204f(str, 8), 0, 0, 0);
                calendarM2208b.set(14, 0);
                return calendarM2208b.getTime();
            }
            str2 = TimeUtils.UTCFormat.SHORT;
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
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Date m2210i(String str, ParsePosition parsePosition) throws ParseException {
        DateFormat simpleDateFormat;
        boolean z2;
        if (str.length() >= 7 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(3)) && str.charAt(4) == '-' && Character.isDigit(str.charAt(5))) {
            try {
                return m2209h(str);
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
                String str2 = C2126f.f4553b;
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
                return new Date(C2126f.m1697a(str));
            } catch (NumberFormatException unused) {
                throw new ParseException(String.format("Timestamp value %s out of 64-bit value range", str), parsePosition.getErrorIndex());
            }
        }
        if (this.f4978t == null) {
            DateFormat dateFormat = f4973o;
            TimeZone timeZone = this.f4976r;
            Locale locale = this._locale;
            Boolean bool = this._lenient;
            if (locale.equals(f4972n)) {
                simpleDateFormat = (DateFormat) dateFormat.clone();
                if (timeZone != null) {
                    simpleDateFormat.setTimeZone(timeZone);
                }
            } else {
                simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale);
                if (timeZone == null) {
                    timeZone = f4971m;
                }
                simpleDateFormat.setTimeZone(timeZone);
            }
            if (bool != null) {
                simpleDateFormat.setLenient(bool.booleanValue());
            }
            this.f4978t = simpleDateFormat;
        }
        return this.f4978t.parse(str, parsePosition);
    }

    @Override // java.text.DateFormat
    public boolean isLenient() {
        Boolean bool = this._lenient;
        return bool == null || bool.booleanValue();
    }

    /* JADX INFO: renamed from: l */
    public C2356r m2211l(Locale locale) {
        return locale.equals(this._locale) ? this : new C2356r(this.f4976r, locale, this._lenient, this._tzSerializedWithColon);
    }

    /* JADX INFO: renamed from: m */
    public C2356r m2212m(TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = f4971m;
        }
        TimeZone timeZone2 = this.f4976r;
        return (timeZone == timeZone2 || timeZone.equals(timeZone2)) ? this : new C2356r(timeZone, this._locale, this._lenient, this._tzSerializedWithColon);
    }

    @Override // java.text.DateFormat
    public Date parse(String str) throws ParseException {
        String strTrim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date dateM2210i = m2210i(strTrim, parsePosition);
        if (dateM2210i != null) {
            return dateM2210i;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : f4970l) {
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
        this.f4978t = null;
    }

    @Override // java.text.DateFormat
    public void setTimeZone(TimeZone timeZone) {
        if (timeZone.equals(this.f4976r)) {
            return;
        }
        this.f4978t = null;
        this.f4976r = timeZone;
    }

    public String toString() {
        return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", C2356r.class.getName(), this.f4976r, this._locale, this._lenient);
    }

    public C2356r(TimeZone timeZone, Locale locale, Boolean bool, boolean z2) {
        this._tzSerializedWithColon = true;
        this.f4976r = timeZone;
        this._locale = locale;
        this._lenient = bool;
        this._tzSerializedWithColon = z2;
    }

    @Override // java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        try {
            return m2210i(str, parsePosition);
        } catch (ParseException unused) {
            return null;
        }
    }
}
