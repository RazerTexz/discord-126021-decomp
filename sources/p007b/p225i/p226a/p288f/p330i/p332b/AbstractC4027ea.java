package p007b.p225i.p226a.p288f.p330i.p332b;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import p007b.p225i.p226a.p288f.p313h.p325l.C3756n0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3782p0;

/* JADX INFO: renamed from: b.i.a.f.i.b.ea */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4027ea {

    /* JADX INFO: renamed from: a */
    public String f10698a;

    /* JADX INFO: renamed from: b */
    public int f10699b;

    /* JADX INFO: renamed from: c */
    public Boolean f10700c;

    /* JADX INFO: renamed from: d */
    public Boolean f10701d;

    /* JADX INFO: renamed from: e */
    public Long f10702e;

    /* JADX INFO: renamed from: f */
    public Long f10703f;

    public AbstractC4027ea(String str, int i) {
        this.f10698a = str;
        this.f10699b = i;
    }

    /* JADX INFO: renamed from: b */
    public static Boolean m5588b(long j, C3756n0 c3756n0) {
        try {
            return m5592f(new BigDecimal(j), c3756n0, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static Boolean m5589c(Boolean bool, boolean z2) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z2);
    }

    /* JADX INFO: renamed from: d */
    public static Boolean m5590d(String str, C3756n0 c3756n0) {
        if (!C4163q9.m5827P(str)) {
            return null;
        }
        try {
            return m5592f(new BigDecimal(str), c3756n0, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public static Boolean m5591e(String str, C3782p0 c3782p0, C4157q3 c4157q3) {
        List<String> listM5163A;
        C3782p0.b bVar = C3782p0.b.REGEXP;
        C3782p0.b bVar2 = C3782p0.b.IN_LIST;
        Objects.requireNonNull(c3782p0, "null reference");
        if (str == null || !c3782p0.m5165u() || c3782p0.m5166v() == C3782p0.b.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (c3782p0.m5166v() == bVar2) {
            if (c3782p0.m5164B() == 0) {
                return null;
            }
        } else if (!c3782p0.m5167w()) {
            return null;
        }
        C3782p0.b bVarM5166v = c3782p0.m5166v();
        boolean zM5170z = c3782p0.m5170z();
        String strM5168x = (zM5170z || bVarM5166v == bVar || bVarM5166v == bVar2) ? c3782p0.m5168x() : c3782p0.m5168x().toUpperCase(Locale.ENGLISH);
        if (c3782p0.m5164B() == 0) {
            listM5163A = null;
        } else {
            listM5163A = c3782p0.m5163A();
            if (!zM5170z) {
                ArrayList arrayList = new ArrayList(listM5163A.size());
                Iterator<String> it = listM5163A.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                listM5163A = Collections.unmodifiableList(arrayList);
            }
        }
        String str2 = bVarM5166v == bVar ? strM5168x : null;
        if (bVarM5166v == bVar2) {
            if (listM5163A == null || listM5163A.size() == 0) {
                return null;
            }
        } else if (strM5168x == null) {
            return null;
        }
        if (!zM5170z && bVarM5166v != bVar) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (C3979aa.f10554a[bVarM5166v.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str2, zM5170z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (c4157q3 == null) {
                        return null;
                    }
                    c4157q3.f11144i.m5861b("Invalid regular expression in REGEXP audience filter. expression", str2);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(strM5168x));
            case 3:
                return Boolean.valueOf(str.endsWith(strM5168x));
            case 4:
                return Boolean.valueOf(str.contains(strM5168x));
            case 5:
                return Boolean.valueOf(str.equals(strM5168x));
            case 6:
                return Boolean.valueOf(listM5163A.contains(str));
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: f */
    public static Boolean m5592f(BigDecimal bigDecimal, C3756n0 c3756n0, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Objects.requireNonNull(c3756n0, "null reference");
        if (c3756n0.m5116u() && c3756n0.m5117v() != C3756n0.a.UNKNOWN_COMPARISON_TYPE) {
            C3756n0.a aVarM5117v = c3756n0.m5117v();
            C3756n0.a aVar = C3756n0.a.BETWEEN;
            if (aVarM5117v == aVar) {
                if (!c3756n0.m5112A() || !c3756n0.m5114C()) {
                    return null;
                }
            } else if (!c3756n0.m5120y()) {
                return null;
            }
            C3756n0.a aVarM5117v2 = c3756n0.m5117v();
            if (c3756n0.m5117v() == aVar) {
                if (C4163q9.m5827P(c3756n0.m5113B()) && C4163q9.m5827P(c3756n0.m5115D())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(c3756n0.m5113B());
                        bigDecimal4 = new BigDecimal(c3756n0.m5115D());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!C4163q9.m5827P(c3756n0.m5121z())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(c3756n0.m5121z());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (aVarM5117v2 == aVar) {
                if (bigDecimal3 == null) {
                    return null;
                }
            } else if (bigDecimal2 != null) {
            }
            int i = C3979aa.f10555b[aVarM5117v2.ordinal()];
            boolean z2 = false;
            if (i == 1) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == -1);
            }
            if (i == 2) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 1);
            }
            if (i == 3) {
                if (d == 0.0d) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                }
                if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) == -1) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            }
            if (i == 4) {
                if (bigDecimal.compareTo(bigDecimal3) != -1 && bigDecimal.compareTo(bigDecimal4) != 1) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public abstract int mo5593a();

    /* JADX INFO: renamed from: g */
    public abstract boolean mo5594g();

    /* JADX INFO: renamed from: h */
    public abstract boolean mo5595h();
}
