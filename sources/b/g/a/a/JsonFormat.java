package b.g.a.a;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: renamed from: b.g.a.a.i, reason: use source file name */
/* JADX INFO: compiled from: JsonFormat.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonFormat {

    /* JADX INFO: renamed from: b.g.a.a.i$a */
    /* JADX INFO: compiled from: JsonFormat.java */
    public enum a {
        ACCEPT_SINGLE_VALUE_AS_ARRAY,
        ACCEPT_CASE_INSENSITIVE_PROPERTIES,
        ACCEPT_CASE_INSENSITIVE_VALUES,
        WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,
        WRITE_DATES_WITH_ZONE_ID,
        WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED,
        WRITE_SORTED_MAP_ENTRIES,
        ADJUST_DATES_TO_CONTEXT_TIME_ZONE
    }

    /* JADX INFO: renamed from: b.g.a.a.i$b */
    /* JADX INFO: compiled from: JsonFormat.java */
    public static class b {
        public static final b a = new b(0, 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f654b;
        public final int c;

        public b(int i, int i2) {
            this.f654b = i;
            this.c = i2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f654b == this.f654b && bVar.c == this.c;
        }

        public int hashCode() {
            return this.c + this.f654b;
        }

        public String toString() {
            return this == a ? "EMPTY" : String.format("(enabled=0x%x,disabled=0x%x)", Integer.valueOf(this.f654b), Integer.valueOf(this.c));
        }
    }

    /* JADX INFO: renamed from: b.g.a.a.i$c */
    /* JADX INFO: compiled from: JsonFormat.java */
    public enum c {
        ANY,
        NATURAL,
        SCALAR,
        ARRAY,
        OBJECT,
        NUMBER,
        NUMBER_FLOAT,
        NUMBER_INT,
        STRING,
        BOOLEAN,
        BINARY;

        public boolean f() {
            return this == NUMBER || this == NUMBER_INT || this == NUMBER_FLOAT;
        }
    }

    /* JADX INFO: renamed from: b.g.a.a.i$d */
    /* JADX INFO: compiled from: JsonFormat.java */
    public static class d implements Serializable {
        public static final d j = new d("", c.ANY, "", "", b.a, null);
        private static final long serialVersionUID = 1;
        private final b _features;
        private final Boolean _lenient;
        private final Locale _locale;
        private final String _pattern;
        private final c _shape;
        private final String _timezoneStr;
        public transient TimeZone k;

        public d() {
            this("", c.ANY, "", "", b.a, null);
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

        public Boolean b(a aVar) {
            b bVar = this._features;
            Objects.requireNonNull(bVar);
            int iOrdinal = 1 << aVar.ordinal();
            if ((bVar.c & iOrdinal) != 0) {
                return Boolean.FALSE;
            }
            if ((iOrdinal & bVar.f654b) != 0) {
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

        public c e() {
            return this._shape;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != d.class) {
                return false;
            }
            d dVar = (d) obj;
            return this._shape == dVar._shape && this._features.equals(dVar._features) && a(this._lenient, dVar._lenient) && a(this._timezoneStr, dVar._timezoneStr) && a(this._pattern, dVar._pattern) && a(this.k, dVar.k) && a(this._locale, dVar._locale);
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
            return this._shape != c.ANY;
        }

        public boolean j() {
            String str;
            return (this.k == null && ((str = this._timezoneStr) == null || str.isEmpty())) ? false : true;
        }

        public final d k(d dVar) {
            d dVar2;
            String str;
            TimeZone timeZone;
            if (dVar == null || dVar == (dVar2 = j) || dVar == this) {
                return this;
            }
            if (this == dVar2) {
                return dVar;
            }
            String str2 = dVar._pattern;
            if (str2 == null || str2.isEmpty()) {
                str2 = this._pattern;
            }
            String str3 = str2;
            c cVar = dVar._shape;
            if (cVar == c.ANY) {
                cVar = this._shape;
            }
            c cVar2 = cVar;
            Locale locale = dVar._locale;
            if (locale == null) {
                locale = this._locale;
            }
            Locale locale2 = locale;
            b bVar = this._features;
            if (bVar == null) {
                bVar = dVar._features;
            } else {
                b bVar2 = dVar._features;
                if (bVar2 != null) {
                    int i = bVar2.c;
                    int i2 = bVar2.f654b;
                    if (i != 0 || i2 != 0) {
                        int i3 = bVar.f654b;
                        if (i3 == 0 && bVar.c == 0) {
                            bVar = bVar2;
                        } else {
                            int i4 = ((~i) & i3) | i2;
                            int i5 = bVar.c;
                            int i6 = i | ((~i2) & i5);
                            if (i4 != i3 || i6 != i5) {
                                bVar = new b(i4, i6);
                            }
                        }
                    }
                }
            }
            b bVar3 = bVar;
            Boolean bool = dVar._lenient;
            if (bool == null) {
                bool = this._lenient;
            }
            Boolean bool2 = bool;
            String str4 = dVar._timezoneStr;
            if (str4 == null || str4.isEmpty()) {
                str = this._timezoneStr;
                timeZone = this.k;
            } else {
                timeZone = dVar.k;
                str = str4;
            }
            return new d(str3, cVar2, locale2, str, timeZone, bVar3, bool2);
        }

        public String toString() {
            return String.format("JsonFormat.Value(pattern=%s,shape=%s,lenient=%s,locale=%s,timezone=%s,features=%s)", this._pattern, this._shape, this._lenient, this._locale, this._timezoneStr, this._features);
        }

        public d(String str, c cVar, String str2, String str3, b bVar, Boolean bool) {
            this(str, cVar, (str2 == null || str2.length() == 0 || "##default".equals(str2)) ? null : new Locale(str2), (str3 == null || str3.length() == 0 || "##default".equals(str3)) ? null : str3, null, bVar, bool);
        }

        public d(String str, c cVar, Locale locale, String str2, TimeZone timeZone, b bVar, Boolean bool) {
            this._pattern = str == null ? "" : str;
            this._shape = cVar == null ? c.ANY : cVar;
            this._locale = locale;
            this.k = timeZone;
            this._timezoneStr = str2;
            this._features = bVar == null ? b.a : bVar;
            this._lenient = bool;
        }
    }

    OptBoolean lenient() default OptBoolean.DEFAULT;

    String locale() default "##default";

    String pattern() default "";

    c shape() default c.ANY;

    String timezone() default "##default";

    a[] with() default {};

    a[] without() default {};
}
