package p007b.p195g.p196a.p197a;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: renamed from: b.g.a.a.i */
/* JADX INFO: compiled from: JsonFormat.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC2081i {

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

        /* JADX INFO: renamed from: a */
        public static final b f4406a = new b(0, 0);

        /* JADX INFO: renamed from: b */
        public final int f4407b;

        /* JADX INFO: renamed from: c */
        public final int f4408c;

        public b(int i, int i2) {
            this.f4407b = i;
            this.f4408c = i2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f4407b == this.f4407b && bVar.f4408c == this.f4408c;
        }

        public int hashCode() {
            return this.f4408c + this.f4407b;
        }

        public String toString() {
            return this == f4406a ? "EMPTY" : String.format("(enabled=0x%x,disabled=0x%x)", Integer.valueOf(this.f4407b), Integer.valueOf(this.f4408c));
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

        /* JADX INFO: renamed from: f */
        public boolean m1596f() {
            return this == NUMBER || this == NUMBER_INT || this == NUMBER_FLOAT;
        }
    }

    /* JADX INFO: renamed from: b.g.a.a.i$d */
    /* JADX INFO: compiled from: JsonFormat.java */
    public static class d implements Serializable {

        /* JADX INFO: renamed from: j */
        public static final d f4421j = new d("", c.ANY, "", "", b.f4406a, null);
        private static final long serialVersionUID = 1;
        private final b _features;
        private final Boolean _lenient;
        private final Locale _locale;
        private final String _pattern;
        private final c _shape;
        private final String _timezoneStr;

        /* JADX INFO: renamed from: k */
        public transient TimeZone f4422k;

        public d() {
            this("", c.ANY, "", "", b.f4406a, null);
        }

        /* JADX INFO: renamed from: a */
        public static <T> boolean m1597a(T t, T t2) {
            if (t == null) {
                return t2 == null;
            }
            if (t2 == null) {
                return false;
            }
            return t.equals(t2);
        }

        /* JADX INFO: renamed from: b */
        public Boolean m1598b(a aVar) {
            b bVar = this._features;
            Objects.requireNonNull(bVar);
            int iOrdinal = 1 << aVar.ordinal();
            if ((bVar.f4408c & iOrdinal) != 0) {
                return Boolean.FALSE;
            }
            if ((iOrdinal & bVar.f4407b) != 0) {
                return Boolean.TRUE;
            }
            return null;
        }

        /* JADX INFO: renamed from: c */
        public Locale m1599c() {
            return this._locale;
        }

        /* JADX INFO: renamed from: d */
        public String m1600d() {
            return this._pattern;
        }

        /* JADX INFO: renamed from: e */
        public c m1601e() {
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
            return this._shape == dVar._shape && this._features.equals(dVar._features) && m1597a(this._lenient, dVar._lenient) && m1597a(this._timezoneStr, dVar._timezoneStr) && m1597a(this._pattern, dVar._pattern) && m1597a(this.f4422k, dVar.f4422k) && m1597a(this._locale, dVar._locale);
        }

        /* JADX INFO: renamed from: f */
        public TimeZone m1602f() {
            TimeZone timeZone = this.f4422k;
            if (timeZone != null) {
                return timeZone;
            }
            String str = this._timezoneStr;
            if (str == null) {
                return null;
            }
            TimeZone timeZone2 = TimeZone.getTimeZone(str);
            this.f4422k = timeZone2;
            return timeZone2;
        }

        /* JADX INFO: renamed from: g */
        public boolean m1603g() {
            return this._locale != null;
        }

        /* JADX INFO: renamed from: h */
        public boolean m1604h() {
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

        /* JADX INFO: renamed from: i */
        public boolean m1605i() {
            return this._shape != c.ANY;
        }

        /* JADX INFO: renamed from: j */
        public boolean m1606j() {
            String str;
            return (this.f4422k == null && ((str = this._timezoneStr) == null || str.isEmpty())) ? false : true;
        }

        /* JADX INFO: renamed from: k */
        public final d m1607k(d dVar) {
            d dVar2;
            String str;
            TimeZone timeZone;
            if (dVar == null || dVar == (dVar2 = f4421j) || dVar == this) {
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
                    int i = bVar2.f4408c;
                    int i2 = bVar2.f4407b;
                    if (i != 0 || i2 != 0) {
                        int i3 = bVar.f4407b;
                        if (i3 == 0 && bVar.f4408c == 0) {
                            bVar = bVar2;
                        } else {
                            int i4 = ((~i) & i3) | i2;
                            int i5 = bVar.f4408c;
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
                timeZone = this.f4422k;
            } else {
                timeZone = dVar.f4422k;
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
            this.f4422k = timeZone;
            this._timezoneStr = str2;
            this._features = bVar == null ? b.f4406a : bVar;
            this._lenient = bool;
        }
    }

    EnumC2090m0 lenient() default EnumC2090m0.DEFAULT;

    String locale() default "##default";

    String pattern() default "";

    c shape() default c.ANY;

    String timezone() default "##default";

    a[] with() default {};

    a[] without() default {};
}
