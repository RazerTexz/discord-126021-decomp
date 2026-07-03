package p007b.p225i.p408d.p410q.p411x.p412d;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.d.q.x.d.a */
/* JADX INFO: compiled from: ISO8601Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4942a {

    /* JADX INFO: renamed from: a */
    public static final TimeZone f13147a = TimeZone.getTimeZone("UTC");

    /* JADX INFO: renamed from: a */
    public static boolean m6909a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00e1 A[Catch: IllegalArgumentException -> 0x01d0, NumberFormatException -> 0x01d2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01d4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01d4, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:37:0x009c, B:39:0x00a2, B:44:0x00af, B:46:0x00b6, B:57:0x00db, B:59:0x00e1, B:61:0x00e8, B:86:0x0197, B:66:0x00f4, B:67:0x010f, B:68:0x0110, B:72:0x012c, B:74:0x0139, B:77:0x0142, B:79:0x0161, B:82:0x0170, B:83:0x0192, B:85:0x0195, B:71:0x011b, B:88:0x01c8, B:89:0x01cf, B:50:0x00c6, B:51:0x00c9, B:45:0x00b2), top: B:105:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00e8 A[Catch: IllegalArgumentException -> 0x01d0, NumberFormatException -> 0x01d2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01d4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01d4, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:37:0x009c, B:39:0x00a2, B:44:0x00af, B:46:0x00b6, B:57:0x00db, B:59:0x00e1, B:61:0x00e8, B:86:0x0197, B:66:0x00f4, B:67:0x010f, B:68:0x0110, B:72:0x012c, B:74:0x0139, B:77:0x0142, B:79:0x0161, B:82:0x0170, B:83:0x0192, B:85:0x0195, B:71:0x011b, B:88:0x01c8, B:89:0x01cf, B:50:0x00c6, B:51:0x00c9, B:45:0x00b2), top: B:105:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:70:0x011a  */
    /* JADX WARN: Code duplicated, block: B:71:0x011b A[Catch: IllegalArgumentException -> 0x01d0, NumberFormatException -> 0x01d2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01d4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01d4, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:37:0x009c, B:39:0x00a2, B:44:0x00af, B:46:0x00b6, B:57:0x00db, B:59:0x00e1, B:61:0x00e8, B:86:0x0197, B:66:0x00f4, B:67:0x010f, B:68:0x0110, B:72:0x012c, B:74:0x0139, B:77:0x0142, B:79:0x0161, B:82:0x0170, B:83:0x0192, B:85:0x0195, B:71:0x011b, B:88:0x01c8, B:89:0x01cf, B:50:0x00c6, B:51:0x00c9, B:45:0x00b2), top: B:105:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0195 A[Catch: IllegalArgumentException -> 0x01d0, NumberFormatException -> 0x01d2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01d4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01d4, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:37:0x009c, B:39:0x00a2, B:44:0x00af, B:46:0x00b6, B:57:0x00db, B:59:0x00e1, B:61:0x00e8, B:86:0x0197, B:66:0x00f4, B:67:0x010f, B:68:0x0110, B:72:0x012c, B:74:0x0139, B:77:0x0142, B:79:0x0161, B:82:0x0170, B:83:0x0192, B:85:0x0195, B:71:0x011b, B:88:0x01c8, B:89:0x01cf, B:50:0x00c6, B:51:0x00c9, B:45:0x00b2), top: B:105:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01c8 A[Catch: IllegalArgumentException -> 0x01d0, NumberFormatException -> 0x01d2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01d4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01d4, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:37:0x009c, B:39:0x00a2, B:44:0x00af, B:46:0x00b6, B:57:0x00db, B:59:0x00e1, B:61:0x00e8, B:86:0x0197, B:66:0x00f4, B:67:0x010f, B:68:0x0110, B:72:0x012c, B:74:0x0139, B:77:0x0142, B:79:0x0161, B:82:0x0170, B:83:0x0192, B:85:0x0195, B:71:0x011b, B:88:0x01c8, B:89:0x01cf, B:50:0x00c6, B:51:0x00c9, B:45:0x00b2), top: B:105:0x0004 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:71:0x011b, please report this as an issue */
    /* JADX INFO: renamed from: b */
    public static Date m6910b(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i;
        int iM6911c;
        int iM6911c2;
        int iM6911c3;
        int iM6911c4;
        int i2;
        char cCharAt;
        String strSubstring;
        int length;
        TimeZone timeZone;
        char cCharAt2;
        try {
            int index = parsePosition.getIndex();
            int i3 = index + 4;
            int iM6911c5 = m6911c(str, index, i3);
            if (m6909a(str, i3, '-')) {
                i3++;
            }
            int i4 = i3 + 2;
            int iM6911c6 = m6911c(str, i3, i4);
            if (m6909a(str, i4, '-')) {
                i4++;
            }
            int i5 = i4 + 2;
            int iM6911c7 = m6911c(str, i4, i5);
            boolean zM6909a = m6909a(str, i5, 'T');
            if (!zM6909a && str.length() <= i5) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iM6911c5, iM6911c6 - 1, iM6911c7);
                parsePosition.setIndex(i5);
                return gregorianCalendar.getTime();
            }
            if (zM6909a) {
                int i6 = i5 + 1;
                int i7 = i6 + 2;
                iM6911c4 = m6911c(str, i6, i7);
                if (m6909a(str, i7, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR)) {
                    i7++;
                }
                int i8 = i7 + 2;
                iM6911c = m6911c(str, i7, i8);
                if (m6909a(str, i8, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR)) {
                    i8++;
                }
                if (str.length() <= i8 || (cCharAt2 = str.charAt(i8)) == 'Z' || cCharAt2 == '+' || cCharAt2 == '-') {
                    i = iM6911c4;
                    i5 = i8;
                } else {
                    i2 = i8 + 2;
                    iM6911c3 = m6911c(str, i8, i2);
                    if (iM6911c3 > 59 && iM6911c3 < 63) {
                        iM6911c3 = 59;
                    }
                    if (m6909a(str, i2, '.')) {
                        int i9 = i2 + 1;
                        int length2 = i9 + 1;
                        while (true) {
                            if (length2 >= str.length()) {
                                length2 = str.length();
                                break;
                            }
                            char cCharAt3 = str.charAt(length2);
                            if (cCharAt3 < '0' || cCharAt3 > '9') {
                                break;
                                break;
                            }
                            length2++;
                        }
                        int iMin = Math.min(length2, i9 + 3);
                        iM6911c2 = m6911c(str, i9, iMin);
                        int i10 = iMin - i9;
                        if (i10 == 1) {
                            iM6911c2 *= 100;
                        } else if (i10 == 2) {
                            iM6911c2 *= 10;
                        }
                        i2 = length2;
                    } else {
                        iM6911c2 = 0;
                    }
                }
                if (str.length() > i2) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                cCharAt = str.charAt(i2);
                if (cCharAt == 'Z') {
                    timeZone = f13147a;
                    length = i2 + 1;
                } else {
                    if (cCharAt != '+' && cCharAt != '-') {
                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                    }
                    strSubstring = str.substring(i2);
                    if (strSubstring.length() >= 5) {
                        strSubstring = strSubstring + "00";
                    }
                    length = i2 + strSubstring.length();
                    if (!"+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                        timeZone = f13147a;
                    } else {
                        String str3 = "GMT" + strSubstring;
                        TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                        String id2 = timeZone2.getID();
                        if (!id2.equals(str3) && !id2.replace(":", "").equals(str3)) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                        }
                        timeZone = timeZone2;
                    }
                }
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                gregorianCalendar2.setLenient(false);
                gregorianCalendar2.set(1, iM6911c5);
                gregorianCalendar2.set(2, iM6911c6 - 1);
                gregorianCalendar2.set(5, iM6911c7);
                gregorianCalendar2.set(11, iM6911c4);
                gregorianCalendar2.set(12, iM6911c);
                gregorianCalendar2.set(13, iM6911c3);
                gregorianCalendar2.set(14, iM6911c2);
                parsePosition.setIndex(length);
                return gregorianCalendar2.getTime();
            }
            i = 0;
            iM6911c = 0;
            iM6911c2 = 0;
            iM6911c3 = 0;
            int i11 = i5;
            iM6911c4 = i;
            i2 = i11;
            if (str.length() > i2) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            cCharAt = str.charAt(i2);
            if (cCharAt == 'Z') {
                timeZone = f13147a;
                length = i2 + 1;
            } else {
                if (cCharAt != '+') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                }
                strSubstring = str.substring(i2);
                if (strSubstring.length() >= 5) {
                    strSubstring = strSubstring + "00";
                }
                length = i2 + strSubstring.length();
                if ("+0000".equals(strSubstring)) {
                    timeZone = f13147a;
                } else {
                    timeZone = f13147a;
                }
            }
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar(timeZone);
            gregorianCalendar3.setLenient(false);
            gregorianCalendar3.set(1, iM6911c5);
            gregorianCalendar3.set(2, iM6911c6 - 1);
            gregorianCalendar3.set(5, iM6911c7);
            gregorianCalendar3.set(11, iM6911c4);
            gregorianCalendar3.set(12, iM6911c);
            gregorianCalendar3.set(13, iM6911c3);
            gregorianCalendar3.set(14, iM6911c2);
            parsePosition.setIndex(length);
            return gregorianCalendar3.getTime();
        } catch (IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException e) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                StringBuilder sbM833U = C1643a.m833U("(");
                sbM833U.append(e.getClass().getName());
                sbM833U.append(")");
                message = sbM833U.toString();
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    /* JADX INFO: renamed from: c */
    public static int m6911c(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                StringBuilder sbM833U = C1643a.m833U("Invalid number: ");
                sbM833U.append(str.substring(i, i2));
                throw new NumberFormatException(sbM833U.toString());
            }
            i3 = -iDigit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                StringBuilder sbM833U2 = C1643a.m833U("Invalid number: ");
                sbM833U2.append(str.substring(i, i2));
                throw new NumberFormatException(sbM833U2.toString());
            }
            i3 = (i3 * 10) - iDigit2;
            i4 = i5;
        }
        return -i3;
    }
}
