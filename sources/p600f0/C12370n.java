package p600f0;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p021f.C0897c;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p606h.C12297c;

/* JADX INFO: renamed from: f0.n */
/* JADX INFO: compiled from: Cookie.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12370n {

    /* JADX INFO: renamed from: f */
    public final String f25947f;

    /* JADX INFO: renamed from: g */
    public final String f25948g;

    /* JADX INFO: renamed from: h */
    public final long f25949h;

    /* JADX INFO: renamed from: i */
    public final String f25950i;

    /* JADX INFO: renamed from: j */
    public final String f25951j;

    /* JADX INFO: renamed from: k */
    public final boolean f25952k;

    /* JADX INFO: renamed from: l */
    public final boolean f25953l;

    /* JADX INFO: renamed from: m */
    public final boolean f25954m;

    /* JADX INFO: renamed from: n */
    public final boolean f25955n;

    /* JADX INFO: renamed from: e */
    public static final a f25946e = new a(null);

    /* JADX INFO: renamed from: a */
    public static final Pattern f25942a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: b */
    public static final Pattern f25943b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: c */
    public static final Pattern f25944c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: d */
    public static final Pattern f25945d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: f0.n$a */
    /* JADX INFO: compiled from: Cookie.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final int m10385a(String str, int i, int i2, boolean z2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && '9' >= cCharAt) || (('a' <= cCharAt && 'z' >= cCharAt) || (('A' <= cCharAt && 'Z' >= cCharAt) || cCharAt == ':'))) == (!z2)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        /* JADX INFO: renamed from: b */
        public final boolean m10386b(String str, String str2) {
            if (C12238m.areEqual(str, str2)) {
                return true;
            }
            if (C12103t.endsWith$default(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.') {
                byte[] bArr = C12272c.f25397a;
                C12238m.checkParameterIsNotNull(str, "$this$canParseAsIpAddress");
                if (!C12272c.f25402f.matches(str)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x00c4  */
        /* JADX INFO: renamed from: c */
        public final long m10387c(String str, int i, int i2) {
            int iM10385a = m10385a(str, i, i2, false);
            Matcher matcher = C12370n.f25945d.matcher(str);
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int iIndexOf$default = -1;
            int i6 = -1;
            int i7 = -1;
            while (iM10385a < i2) {
                int iM10385a2 = m10385a(str, iM10385a + 1, i2, true);
                matcher.region(iM10385a, iM10385a2);
                if (i4 == -1 && matcher.usePattern(C12370n.f25945d).matches()) {
                    String strGroup = matcher.group(1);
                    C12238m.checkExpressionValueIsNotNull(strGroup, "matcher.group(1)");
                    i4 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    C12238m.checkExpressionValueIsNotNull(strGroup2, "matcher.group(2)");
                    i6 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    C12238m.checkExpressionValueIsNotNull(strGroup3, "matcher.group(3)");
                    i7 = Integer.parseInt(strGroup3);
                } else if (i5 == -1 && matcher.usePattern(C12370n.f25944c).matches()) {
                    String strGroup4 = matcher.group(1);
                    C12238m.checkExpressionValueIsNotNull(strGroup4, "matcher.group(1)");
                    i5 = Integer.parseInt(strGroup4);
                } else if (iIndexOf$default == -1) {
                    Pattern pattern = C12370n.f25943b;
                    if (matcher.usePattern(pattern).matches()) {
                        String strGroup5 = matcher.group(1);
                        C12238m.checkExpressionValueIsNotNull(strGroup5, "matcher.group(1)");
                        Locale locale = Locale.US;
                        C12238m.checkExpressionValueIsNotNull(locale, "Locale.US");
                        if (strGroup5 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase = strGroup5.toLowerCase(locale);
                        C12238m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        String strPattern = pattern.pattern();
                        C12238m.checkExpressionValueIsNotNull(strPattern, "MONTH_PATTERN.pattern()");
                        iIndexOf$default = C12106w.indexOf$default((CharSequence) strPattern, lowerCase, 0, false, 6, (Object) null) / 4;
                    } else if (i3 != -1 && matcher.usePattern(C12370n.f25942a).matches()) {
                        String strGroup6 = matcher.group(1);
                        C12238m.checkExpressionValueIsNotNull(strGroup6, "matcher.group(1)");
                        i3 = Integer.parseInt(strGroup6);
                    }
                } else if (i3 != -1) {
                }
                iM10385a = m10385a(str, iM10385a2 + 1, i2, false);
            }
            if (70 <= i3 && 99 >= i3) {
                i3 += 1900;
            }
            if (i3 >= 0 && 69 >= i3) {
                i3 += 2000;
            }
            if (!(i3 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(iIndexOf$default != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= i5 && 31 >= i5)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i4 >= 0 && 23 >= i4)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i6 >= 0 && 59 >= i6)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i7 >= 0 && 59 >= i7)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(C12272c.f25401e);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, iIndexOf$default - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i6);
            gregorianCalendar.set(13, i7);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    public C12370n(String str, String str2, long j, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this.f25947f = str;
        this.f25948g = str2;
        this.f25949h = j;
        this.f25950i = str3;
        this.f25951j = str4;
        this.f25952k = z2;
        this.f25953l = z3;
        this.f25954m = z4;
        this.f25955n = z5;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0048  */
    /* JADX INFO: renamed from: a */
    public final boolean m10384a(C12379w c12379w) {
        boolean zAreEqual;
        C12238m.checkParameterIsNotNull(c12379w, "url");
        if (this.f25955n) {
            zAreEqual = C12238m.areEqual(c12379w.f25979g, this.f25950i);
        } else {
            String str = c12379w.f25979g;
            String str2 = this.f25950i;
            if (C12238m.areEqual(str, str2)) {
                zAreEqual = true;
            } else {
                if (C12103t.endsWith$default(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.') {
                    byte[] bArr = C12272c.f25397a;
                    C12238m.checkParameterIsNotNull(str, "$this$canParseAsIpAddress");
                    if (!C12272c.f25402f.matches(str)) {
                        zAreEqual = true;
                    }
                }
                zAreEqual = false;
            }
        }
        if (!zAreEqual) {
            return false;
        }
        String str3 = this.f25951j;
        String strM10400b = c12379w.m10400b();
        if (C12238m.areEqual(strM10400b, str3) || (C12103t.startsWith$default(strM10400b, str3, false, 2, null) && (C12103t.endsWith$default(str3, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, false, 2, null) || strM10400b.charAt(str3.length()) == '/'))) {
            return !this.f25952k || c12379w.f25975c;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C12370n) {
            C12370n c12370n = (C12370n) obj;
            if (C12238m.areEqual(c12370n.f25947f, this.f25947f) && C12238m.areEqual(c12370n.f25948g, this.f25948g) && c12370n.f25949h == this.f25949h && C12238m.areEqual(c12370n.f25950i, this.f25950i) && C12238m.areEqual(c12370n.f25951j, this.f25951j) && c12370n.f25952k == this.f25952k && c12370n.f25953l == this.f25953l && c12370n.f25954m == this.f25954m && c12370n.f25955n == this.f25955n) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return C0897c.m186a(this.f25955n) + ((C0897c.m186a(this.f25954m) + ((C0897c.m186a(this.f25953l) + ((C0897c.m186a(this.f25952k) + C1643a.m863m(this.f25951j, C1643a.m863m(this.f25950i, (C0002b.m3a(this.f25949h) + C1643a.m863m(this.f25948g, C1643a.m863m(this.f25947f, 527, 31), 31)) * 31, 31), 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f25947f);
        sb.append('=');
        sb.append(this.f25948g);
        if (this.f25954m) {
            if (this.f25949h == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                Date date = new Date(this.f25949h);
                C12297c.a aVar = C12297c.f25526a;
                C12238m.checkParameterIsNotNull(date, "$this$toHttpDateString");
                String str = C12297c.f25526a.get().format(date);
                C12238m.checkExpressionValueIsNotNull(str, "STANDARD_DATE_FORMAT.get().format(this)");
                sb.append(str);
            }
        }
        if (!this.f25955n) {
            sb.append("; domain=");
            sb.append(this.f25950i);
        }
        sb.append("; path=");
        sb.append(this.f25951j);
        if (this.f25952k) {
            sb.append("; secure");
        }
        if (this.f25953l) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        C12238m.checkExpressionValueIsNotNull(string, "toString()");
        return string;
    }
}
