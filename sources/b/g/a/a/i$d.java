package b.g.a.a;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: compiled from: JsonFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$d implements Serializable {
    public static final i$d j = new i$d("", i$c.ANY, "", "", i$b.a, null);
    private static final long serialVersionUID = 1;
    private final i$b _features;
    private final Boolean _lenient;
    private final Locale _locale;
    private final String _pattern;
    private final i$c _shape;
    private final String _timezoneStr;
    public transient TimeZone k;

    public i$d() {
        this("", i$c.ANY, "", "", i$b.a, null);
    }

    public static <T> boolean a(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        if (t2 == null) {
            return false;
        }
        return t.equals(t2);
    }

    public Boolean b(i$a i_a) {
        i$b i_b = this._features;
        Objects.requireNonNull(i_b);
        int iOrdinal = 1 << i_a.ordinal();
        if ((i_b.c & iOrdinal) != 0) {
            return Boolean.FALSE;
        }
        if ((iOrdinal & i_b.f654b) != 0) {
            return Boolean.TRUE;
        }
        return null;
    }

    public Locale c() {
        return this._locale;
    }

    public String d() {
        return this._pattern;
    }

    public i$c e() {
        return this._shape;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != i$d.class) {
            return false;
        }
        i$d i_d = (i$d) obj;
        return this._shape == i_d._shape && this._features.equals(i_d._features) && a(this._lenient, i_d._lenient) && a(this._timezoneStr, i_d._timezoneStr) && a(this._pattern, i_d._pattern) && a(this.k, i_d.k) && a(this._locale, i_d._locale);
    }

    public TimeZone f() {
        TimeZone timeZone = this.k;
        if (timeZone != null) {
            return timeZone;
        }
        String str = this._timezoneStr;
        if (str == null) {
            return null;
        }
        TimeZone timeZone2 = TimeZone.getTimeZone(str);
        this.k = timeZone2;
        return timeZone2;
    }

    public boolean g() {
        return this._locale != null;
    }

    public boolean h() {
        String str = this._pattern;
        return str != null && str.length() > 0;
    }

    public int hashCode() {
        String str = this._timezoneStr;
        int iHashCode = str == null ? 1 : str.hashCode();
        String str2 = this._pattern;
        if (str2 != null) {
            iHashCode ^= str2.hashCode();
        }
        int iHashCode2 = this._shape.hashCode() + iHashCode;
        Boolean bool = this._lenient;
        if (bool != null) {
            iHashCode2 ^= bool.hashCode();
        }
        Locale locale = this._locale;
        if (locale != null) {
            iHashCode2 += locale.hashCode();
        }
        return this._features.hashCode() ^ iHashCode2;
    }

    public boolean i() {
        return this._shape != i$c.ANY;
    }

    public boolean j() {
        String str;
        return (this.k == null && ((str = this._timezoneStr) == null || str.isEmpty())) ? false : true;
    }

    public final i$d k(i$d i_d) {
        i$d i_d2;
        String str;
        TimeZone timeZone;
        if (i_d == null || i_d == (i_d2 = j) || i_d == this) {
            return this;
        }
        if (this == i_d2) {
            return i_d;
        }
        String str2 = i_d._pattern;
        if (str2 == null || str2.isEmpty()) {
            str2 = this._pattern;
        }
        String str3 = str2;
        i$c i_c = i_d._shape;
        if (i_c == i$c.ANY) {
            i_c = this._shape;
        }
        i$c i_c2 = i_c;
        Locale locale = i_d._locale;
        if (locale == null) {
            locale = this._locale;
        }
        Locale locale2 = locale;
        i$b i_b = this._features;
        if (i_b == null) {
            i_b = i_d._features;
        } else {
            i$b i_b2 = i_d._features;
            if (i_b2 != null) {
                int i = i_b2.c;
                int i2 = i_b2.f654b;
                if (i != 0 || i2 != 0) {
                    int i3 = i_b.f654b;
                    if (i3 == 0 && i_b.c == 0) {
                        i_b = i_b2;
                    } else {
                        int i4 = ((~i) & i3) | i2;
                        int i5 = i_b.c;
                        int i6 = i | ((~i2) & i5);
                        if (i4 != i3 || i6 != i5) {
                            i_b = new i$b(i4, i6);
                        }
                    }
                }
            }
        }
        i$b i_b3 = i_b;
        Boolean bool = i_d._lenient;
        if (bool == null) {
            bool = this._lenient;
        }
        Boolean bool2 = bool;
        String str4 = i_d._timezoneStr;
        if (str4 == null || str4.isEmpty()) {
            str = this._timezoneStr;
            timeZone = this.k;
        } else {
            timeZone = i_d.k;
            str = str4;
        }
        return new i$d(str3, i_c2, locale2, str, timeZone, i_b3, bool2);
    }

    public String toString() {
        return String.format("JsonFormat.Value(pattern=%s,shape=%s,lenient=%s,locale=%s,timezone=%s,features=%s)", this._pattern, this._shape, this._lenient, this._locale, this._timezoneStr, this._features);
    }

    public i$d(String str, i$c i_c, String str2, String str3, i$b i_b, Boolean bool) {
        this(str, i_c, (str2 == null || str2.length() == 0 || "##default".equals(str2)) ? null : new Locale(str2), (str3 == null || str3.length() == 0 || "##default".equals(str3)) ? null : str3, null, i_b, bool);
    }

    public i$d(String str, i$c i_c, Locale locale, String str2, TimeZone timeZone, i$b i_b, Boolean bool) {
        this._pattern = str == null ? "" : str;
        this._shape = i_c == null ? i$c.ANY : i_c;
        this._locale = locale;
        this.k = timeZone;
        this._timezoneStr = str2;
        this._features = i_b == null ? i$b.a : i_b;
        this._lenient = bool;
    }
}
