package b.i.a.f.i.b;

import b.i.a.f.h.l.n0$a;
import b.i.a.f.h.l.p0$b;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ea {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1531b;
    public Boolean c;
    public Boolean d;
    public Long e;
    public Long f;

    public ea(String str, int i) {
        this.a = str;
        this.f1531b = i;
    }

    public static Boolean b(long j, b.i.a.f.h.l.n0 n0Var) {
        try {
            return f(new BigDecimal(j), n0Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean c(Boolean bool, boolean z2) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z2);
    }

    public static Boolean d(String str, b.i.a.f.h.l.n0 n0Var) {
        if (!q9.P(str)) {
            return null;
        }
        try {
            return f(new BigDecimal(str), n0Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean e(String str, b.i.a.f.h.l.p0 p0Var, q3 q3Var) {
        List<String> listA;
        p0$b p0_b = p0$b.REGEXP;
        p0$b p0_b2 = p0$b.IN_LIST;
        Objects.requireNonNull(p0Var, "null reference");
        if (str == null || !p0Var.u() || p0Var.v() == p0$b.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (p0Var.v() == p0_b2) {
            if (p0Var.B() == 0) {
                return null;
            }
        } else if (!p0Var.w()) {
            return null;
        }
        p0$b p0_bV = p0Var.v();
        boolean z2 = p0Var.z();
        String strX = (z2 || p0_bV == p0_b || p0_bV == p0_b2) ? p0Var.x() : p0Var.x().toUpperCase(Locale.ENGLISH);
        if (p0Var.B() == 0) {
            listA = null;
        } else {
            listA = p0Var.A();
            if (!z2) {
                ArrayList arrayList = new ArrayList(listA.size());
                Iterator<String> it = listA.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                listA = Collections.unmodifiableList(arrayList);
            }
        }
        String str2 = p0_bV == p0_b ? strX : null;
        if (p0_bV == p0_b2) {
            if (listA == null || listA.size() == 0) {
                return null;
            }
        } else if (strX == null) {
            return null;
        }
        if (!z2 && p0_bV != p0_b) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (aa.a[p0_bV.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str2, z2 ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (q3Var == null) {
                        return null;
                    }
                    q3Var.i.b("Invalid regular expression in REGEXP audience filter. expression", str2);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(strX));
            case 3:
                return Boolean.valueOf(str.endsWith(strX));
            case 4:
                return Boolean.valueOf(str.contains(strX));
            case 5:
                return Boolean.valueOf(str.equals(strX));
            case 6:
                return Boolean.valueOf(listA.contains(str));
            default:
                return null;
        }
    }

    public static Boolean f(BigDecimal bigDecimal, b.i.a.f.h.l.n0 n0Var, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Objects.requireNonNull(n0Var, "null reference");
        if (n0Var.u() && n0Var.v() != n0$a.UNKNOWN_COMPARISON_TYPE) {
            n0$a n0_aV = n0Var.v();
            n0$a n0_a = n0$a.BETWEEN;
            if (n0_aV == n0_a) {
                if (!n0Var.A() || !n0Var.C()) {
                    return null;
                }
            } else if (!n0Var.y()) {
                return null;
            }
            n0$a n0_aV2 = n0Var.v();
            if (n0Var.v() == n0_a) {
                if (q9.P(n0Var.B()) && q9.P(n0Var.D())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(n0Var.B());
                        bigDecimal4 = new BigDecimal(n0Var.D());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!q9.P(n0Var.z())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(n0Var.z());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (n0_aV2 == n0_a) {
                if (bigDecimal3 == null) {
                    return null;
                }
            } else if (bigDecimal2 != null) {
            }
            int i = aa.f1519b[n0_aV2.ordinal()];
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

    public abstract int a();

    public abstract boolean g();

    public abstract boolean h();
}
