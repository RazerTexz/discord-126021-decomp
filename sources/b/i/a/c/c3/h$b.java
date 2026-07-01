package b.i.a.c.c3;

import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.j1;
import b.i.b.b.k0;
import java.util.Locale;

/* JADX INFO: compiled from: DefaultTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$b implements Comparable<h$b> {
    public final boolean j;

    @Nullable
    public final String k;
    public final h$d l;
    public final boolean m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f899s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;

    public h$b(j1 j1Var, h$d h_d, int i) {
        int i2;
        int iC;
        String[] strArrH;
        int iC2;
        this.l = h_d;
        this.k = h.g(j1Var.n);
        this.m = h.e(i, false);
        int i3 = 0;
        while (true) {
            i2 = Integer.MAX_VALUE;
            if (i3 >= h_d.w.size()) {
                i3 = Integer.MAX_VALUE;
                iC = 0;
                break;
            } else {
                iC = h.c(j1Var, h_d.w.get(i3), false);
                if (iC > 0) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        this.o = i3;
        this.n = iC;
        this.p = Integer.bitCount(j1Var.p & h_d.f906x);
        this.f899s = (j1Var.o & 1) != 0;
        int i4 = j1Var.J;
        this.t = i4;
        this.u = j1Var.K;
        int i5 = j1Var.f1017s;
        this.v = i5;
        this.j = (i5 == -1 || i5 <= h_d.f908z) && (i4 == -1 || i4 <= h_d.f907y);
        int i6 = e0.a;
        Configuration configuration = Resources.getSystem().getConfiguration();
        int i7 = e0.a;
        if (i7 >= 24) {
            strArrH = e0.H(configuration.getLocales().toLanguageTags(), ",");
        } else {
            String[] strArr = new String[1];
            Locale locale = configuration.locale;
            strArr[0] = i7 >= 21 ? locale.toLanguageTag() : locale.toString();
            strArrH = strArr;
        }
        for (int i8 = 0; i8 < strArrH.length; i8++) {
            strArrH[i8] = e0.C(strArrH[i8]);
        }
        int i9 = 0;
        while (true) {
            if (i9 >= strArrH.length) {
                i9 = Integer.MAX_VALUE;
                iC2 = 0;
                break;
            } else {
                iC2 = h.c(j1Var, strArrH[i9], false);
                if (iC2 > 0) {
                    break;
                } else {
                    i9++;
                }
            }
        }
        this.q = i9;
        this.r = iC2;
        for (int i10 = 0; i10 < h_d.A.size(); i10++) {
            String str = j1Var.w;
            if (str != null && str.equals(h_d.A.get(i10))) {
                i2 = i10;
                break;
            }
        }
        this.w = i2;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(h$b h_b) {
        return f(h_b);
    }

    public int f(h$b h_b) {
        Object objB = (this.j && this.m) ? h.c : h.c.b();
        b.i.b.b.j jVarC = b.i.b.b.j.a.c(this.m, h_b.m);
        Integer numValueOf = Integer.valueOf(this.o);
        Integer numValueOf2 = Integer.valueOf(h_b.o);
        k0 k0Var = k0.j;
        b.i.b.b.j jVarB = jVarC.b(numValueOf, numValueOf2, k0Var).a(this.n, h_b.n).a(this.p, h_b.p).c(this.j, h_b.j).b(Integer.valueOf(this.w), Integer.valueOf(h_b.w), k0Var).b(Integer.valueOf(this.v), Integer.valueOf(h_b.v), this.l.E ? h.c.b() : h.d).c(this.f899s, h_b.f899s).b(Integer.valueOf(this.q), Integer.valueOf(h_b.q), k0Var).a(this.r, h_b.r).b(Integer.valueOf(this.t), Integer.valueOf(h_b.t), objB).b(Integer.valueOf(this.u), Integer.valueOf(h_b.u), objB);
        Integer numValueOf3 = Integer.valueOf(this.v);
        Integer numValueOf4 = Integer.valueOf(h_b.v);
        if (!e0.a(this.k, h_b.k)) {
            objB = h.d;
        }
        return jVarB.b(numValueOf3, numValueOf4, objB).e();
    }
}
