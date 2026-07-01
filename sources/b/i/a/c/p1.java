package b.i.a.c;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: MediaMetadata.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p1 implements w0 {
    public static final p1 j = new p1$b().a();
    public static final w0$a<p1> k = l0.a;

    @Nullable
    public final Integer A;

    @Nullable
    public final Boolean B;

    @Nullable
    @Deprecated
    public final Integer C;

    @Nullable
    public final Integer D;

    @Nullable
    public final Integer E;

    @Nullable
    public final Integer F;

    @Nullable
    public final Integer G;

    @Nullable
    public final Integer H;

    @Nullable
    public final Integer I;

    @Nullable
    public final CharSequence J;

    @Nullable
    public final CharSequence K;

    @Nullable
    public final CharSequence L;

    @Nullable
    public final Integer M;

    @Nullable
    public final Integer N;

    @Nullable
    public final CharSequence O;

    @Nullable
    public final CharSequence P;

    @Nullable
    public final Bundle Q;

    @Nullable
    public final CharSequence l;

    @Nullable
    public final CharSequence m;

    @Nullable
    public final CharSequence n;

    @Nullable
    public final CharSequence o;

    @Nullable
    public final CharSequence p;

    @Nullable
    public final CharSequence q;

    @Nullable
    public final CharSequence r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final Uri f1046s;

    @Nullable
    public final d2 t;

    @Nullable
    public final d2 u;

    @Nullable
    public final byte[] v;

    @Nullable
    public final Integer w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public final Uri f1047x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public final Integer f1048y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public final Integer f1049z;

    public p1(p1$b p1_b, p1$a p1_a) {
        this.l = p1_b.a;
        this.m = p1_b.f1050b;
        this.n = p1_b.c;
        this.o = p1_b.d;
        this.p = p1_b.e;
        this.q = p1_b.f;
        this.r = p1_b.g;
        this.f1046s = p1_b.h;
        this.t = p1_b.i;
        this.u = p1_b.j;
        this.v = p1_b.k;
        this.w = p1_b.l;
        this.f1047x = p1_b.m;
        this.f1048y = p1_b.n;
        this.f1049z = p1_b.o;
        this.A = p1_b.p;
        this.B = p1_b.q;
        Integer num = p1_b.r;
        this.C = num;
        this.D = num;
        this.E = p1_b.f1051s;
        this.F = p1_b.t;
        this.G = p1_b.u;
        this.H = p1_b.v;
        this.I = p1_b.w;
        this.J = p1_b.f1052x;
        this.K = p1_b.f1053y;
        this.L = p1_b.f1054z;
        this.M = p1_b.A;
        this.N = p1_b.B;
        this.O = p1_b.C;
        this.P = p1_b.D;
        this.Q = p1_b.E;
    }

    public static String b(int i) {
        return Integer.toString(i, 36);
    }

    public p1$b a() {
        return new p1$b(this, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p1.class != obj.getClass()) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return b.i.a.c.f3.e0.a(this.l, p1Var.l) && b.i.a.c.f3.e0.a(this.m, p1Var.m) && b.i.a.c.f3.e0.a(this.n, p1Var.n) && b.i.a.c.f3.e0.a(this.o, p1Var.o) && b.i.a.c.f3.e0.a(this.p, p1Var.p) && b.i.a.c.f3.e0.a(this.q, p1Var.q) && b.i.a.c.f3.e0.a(this.r, p1Var.r) && b.i.a.c.f3.e0.a(this.f1046s, p1Var.f1046s) && b.i.a.c.f3.e0.a(this.t, p1Var.t) && b.i.a.c.f3.e0.a(this.u, p1Var.u) && Arrays.equals(this.v, p1Var.v) && b.i.a.c.f3.e0.a(this.w, p1Var.w) && b.i.a.c.f3.e0.a(this.f1047x, p1Var.f1047x) && b.i.a.c.f3.e0.a(this.f1048y, p1Var.f1048y) && b.i.a.c.f3.e0.a(this.f1049z, p1Var.f1049z) && b.i.a.c.f3.e0.a(this.A, p1Var.A) && b.i.a.c.f3.e0.a(this.B, p1Var.B) && b.i.a.c.f3.e0.a(this.D, p1Var.D) && b.i.a.c.f3.e0.a(this.E, p1Var.E) && b.i.a.c.f3.e0.a(this.F, p1Var.F) && b.i.a.c.f3.e0.a(this.G, p1Var.G) && b.i.a.c.f3.e0.a(this.H, p1Var.H) && b.i.a.c.f3.e0.a(this.I, p1Var.I) && b.i.a.c.f3.e0.a(this.J, p1Var.J) && b.i.a.c.f3.e0.a(this.K, p1Var.K) && b.i.a.c.f3.e0.a(this.L, p1Var.L) && b.i.a.c.f3.e0.a(this.M, p1Var.M) && b.i.a.c.f3.e0.a(this.N, p1Var.N) && b.i.a.c.f3.e0.a(this.O, p1Var.O) && b.i.a.c.f3.e0.a(this.P, p1Var.P);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.f1046s, this.t, this.u, Integer.valueOf(Arrays.hashCode(this.v)), this.w, this.f1047x, this.f1048y, this.f1049z, this.A, this.B, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P});
    }
}
