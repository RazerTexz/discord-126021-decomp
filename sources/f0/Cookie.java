package f0;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import f0.e0.h.dates;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: renamed from: f0.n, reason: use source file name */
/* JADX INFO: compiled from: Cookie.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Cookie {
    public final String f;
    public final String g;
    public final long h;
    public final String i;
    public final String j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public static final a e = new a(null);
    public static final Pattern a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f3676b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: f0.n$a */
    /* JADX INFO: compiled from: Cookie.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final int a(String str, int i, int i2, boolean z2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && '9' >= cCharAt) || (('a' <= cCharAt && 'z' >= cCharAt) || (('A' <= cCharAt && 'Z' >= cCharAt) || cCharAt == ':'))) == (!z2)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        public final boolean b(String str, String str2) {
            if (Intrinsics3.areEqual(str, str2)) {
                return true;
            }
            if (StringsJVM.endsWith$default(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.') {
                byte[] bArr = Util7.a;
                Intrinsics3.checkParameterIsNotNull(str, "$this$canParseAsIpAddress");
                if (!Util7.f.matches(str)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x00c4  */
        public final long c(String str, int i, int i2) {
            int iA = a(str, i, i2, false);
            Matcher matcher = Cookie.d.matcher(str);
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int iIndexOf$default = -1;
            int i6 = -1;
            int i7 = -1;
            while (iA < i2) {
                int iA2 = a(str, iA + 1, i2, true);
                matcher.region(iA, iA2);
                if (i4 == -1 && matcher.usePattern(Cookie.d).matches()) {
                    String strGroup = matcher.group(1);
                    Intrinsics3.checkExpressionValueIsNotNull(strGroup, "matcher.group(1)");
                    i4 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    Intrinsics3.checkExpressionValueIsNotNull(strGroup2, "matcher.group(2)");
                    i6 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    Intrinsics3.checkExpressionValueIsNotNull(strGroup3, "matcher.group(3)");
                    i7 = Integer.parseInt(strGroup3);
                } else if (i5 == -1 && matcher.usePattern(Cookie.c).matches()) {
                    String strGroup4 = matcher.group(1);
                    Intrinsics3.checkExpressionValueIsNotNull(strGroup4, "matcher.group(1)");
                    i5 = Integer.parseInt(strGroup4);
                } else if (iIndexOf$default == -1) {
                    Pattern pattern = Cookie.f3676b;
                    if (matcher.usePattern(pattern).matches()) {
                        String strGroup5 = matcher.group(1);
                        Intrinsics3.checkExpressionValueIsNotNull(strGroup5, "matcher.group(1)");
                        Locale locale = Locale.US;
                        Intrinsics3.checkExpressionValueIsNotNull(locale, "Locale.US");
                        if (strGroup5 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase = strGroup5.toLowerCase(locale);
                        Intrinsics3.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        String strPattern = pattern.pattern();
                        Intrinsics3.checkExpressionValueIsNotNull(strPattern, "MONTH_PATTERN.pattern()");
                        iIndexOf$default = Strings4.indexOf$default((CharSequence) strPattern, lowerCase, 0, false, 6, (Object) null) / 4;
                    } else if (i3 != -1 && matcher.usePattern(Cookie.a).matches()) {
                        String strGroup6 = matcher.group(1);
                        Intrinsics3.checkExpressionValueIsNotNull(strGroup6, "matcher.group(1)");
                        i3 = Integer.parseInt(strGroup6);
                    }
                } else if (i3 != -1) {
                }
                iA = a(str, iA2 + 1, i2, false);
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
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util7.e);
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

    public Cookie(String str, String str2, long j, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this.f = str;
        this.g = str2;
        this.h = j;
        this.i = str3;
        this.j = str4;
        this.k = z2;
        this.l = z3;
        this.m = z4;
        this.n = z5;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0048  */
    public final boolean a(HttpUrl httpUrl) {
        boolean zAreEqual;
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        if (this.n) {
            zAreEqual = Intrinsics3.areEqual(httpUrl.g, this.i);
        } else {
            String str = httpUrl.g;
            String str2 = this.i;
            if (Intrinsics3.areEqual(str, str2)) {
                zAreEqual = true;
            } else {
                if (StringsJVM.endsWith$default(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.') {
                    byte[] bArr = Util7.a;
                    Intrinsics3.checkParameterIsNotNull(str, "$this$canParseAsIpAddress");
                    if (!Util7.f.matches(str)) {
                        zAreEqual = true;
                    }
                }
                zAreEqual = false;
            }
        }
        if (!zAreEqual) {
            return false;
        }
        String str3 = this.j;
        String strB = httpUrl.b();
        if (Intrinsics3.areEqual(strB, str3) || (StringsJVM.startsWith$default(strB, str3, false, 2, null) && (StringsJVM.endsWith$default(str3, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, false, 2, null) || strB.charAt(str3.length()) == '/'))) {
            return !this.k || httpUrl.c;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (Intrinsics3.areEqual(cookie.f, this.f) && Intrinsics3.areEqual(cookie.g, this.g) && cookie.h == this.h && Intrinsics3.areEqual(cookie.i, this.i) && Intrinsics3.areEqual(cookie.j, this.j) && cookie.k == this.k && cookie.l == this.l && cookie.m == this.m && cookie.n == this.n) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return b.a.f.c.a(this.n) + ((b.a.f.c.a(this.m) + ((b.a.f.c.a(this.l) + ((b.a.f.c.a(this.k) + outline.m(this.j, outline.m(this.i, (a0.a.a.b.a(this.h) + outline.m(this.g, outline.m(this.f, 527, 31), 31)) * 31, 31), 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f);
        sb.append('=');
        sb.append(this.g);
        if (this.m) {
            if (this.h == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                Date date = new Date(this.h);
                dates.a aVar = dates.a;
                Intrinsics3.checkParameterIsNotNull(date, "$this$toHttpDateString");
                String str = dates.a.get().format(date);
                Intrinsics3.checkExpressionValueIsNotNull(str, "STANDARD_DATE_FORMAT.get().format(this)");
                sb.append(str);
            }
        }
        if (!this.n) {
            sb.append("; domain=");
            sb.append(this.i);
        }
        sb.append("; path=");
        sb.append(this.j);
        if (this.k) {
            sb.append("; secure");
        }
        if (this.l) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "toString()");
        return string;
    }
}
