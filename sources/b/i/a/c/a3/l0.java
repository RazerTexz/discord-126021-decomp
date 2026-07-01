package b.i.a.c.a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import b.i.a.c.o1;
import b.i.a.c.o1$d$a;
import b.i.a.c.o1$f;
import b.i.a.c.o1$f$a;
import b.i.a.c.o1$g;
import b.i.a.c.o1$g$a;
import b.i.a.c.o1$i;
import b.i.a.c.o2;
import b.i.a.c.o2$b;
import b.i.a.c.o2$c;
import b.i.a.c.p1;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: SinglePeriodTimeline.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends o2 {
    public static final Object k = new Object();
    public final long l;
    public final long m;
    public final boolean n;

    @Nullable
    public final o1 o;

    @Nullable
    public final o1$g p;

    static {
        o1$d$a o1_d_a = new o1$d$a();
        o1$f$a o1_f_a = new o1$f$a(null);
        List listEmptyList = Collections.emptyList();
        b.i.b.b.p<Object> pVar = b.i.b.b.h0.l;
        o1$g$a o1_g_a = new o1$g$a();
        Uri uri = Uri.EMPTY;
        b.c.a.a0.d.D(o1_f_a.f1037b == null || o1_f_a.a != null);
        if (uri != null) {
            new o1$i(uri, null, o1_f_a.a != null ? new o1$f(o1_f_a, null) : null, null, listEmptyList, null, pVar, null, null);
        }
        o1_d_a.a();
        new o1$g(o1_g_a, null);
        p1 p1Var = p1.j;
    }

    public l0(long j, boolean z2, boolean z3, boolean z4, @Nullable Object obj, o1 o1Var) {
        o1$g o1_g = z4 ? o1Var.m : null;
        this.l = j;
        this.m = j;
        this.n = z2;
        Objects.requireNonNull(o1Var);
        this.o = o1Var;
        this.p = o1_g;
    }

    @Override // b.i.a.c.o2
    public int b(Object obj) {
        return k.equals(obj) ? 0 : -1;
    }

    @Override // b.i.a.c.o2
    public o2$b g(int i, o2$b o2_b, boolean z2) {
        b.c.a.a0.d.t(i, 0, 1);
        Object obj = z2 ? k : null;
        long j = this.l;
        Objects.requireNonNull(o2_b);
        o2_b.f(null, obj, 0, j, 0L, b.i.a.c.a3.p0.c.j, false);
        return o2_b;
    }

    @Override // b.i.a.c.o2
    public int i() {
        return 1;
    }

    @Override // b.i.a.c.o2
    public Object m(int i) {
        b.c.a.a0.d.t(i, 0, 1);
        return k;
    }

    @Override // b.i.a.c.o2
    public o2$c o(int i, o2$c o2_c, long j) {
        b.c.a.a0.d.t(i, 0, 1);
        o2_c.e(o2$c.j, this.o, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.n, false, this.p, 0L, this.m, 0, 0, 0L);
        return o2_c;
    }

    @Override // b.i.a.c.o2
    public int p() {
        return 1;
    }
}
