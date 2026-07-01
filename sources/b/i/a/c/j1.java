package b.i.a.c;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: Format.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j1 implements w0 {
    public static final j1 j = new j1$b().a();
    public static final w0$a<j1> k = h0.a;
    public final long A;
    public final int B;
    public final int C;
    public final float D;
    public final int E;
    public final float F;

    @Nullable
    public final byte[] G;
    public final int H;

    @Nullable
    public final b.i.a.c.g3.n I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public final int P;
    public int Q;

    @Nullable
    public final String l;

    @Nullable
    public final String m;

    @Nullable
    public final String n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f1017s;

    @Nullable
    public final String t;

    @Nullable
    public final Metadata u;

    @Nullable
    public final String v;

    @Nullable
    public final String w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f1018x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<byte[]> f1019y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public final DrmInitData f1020z;

    public j1(j1$b j1_b, j1$a j1_a) {
        this.l = j1_b.a;
        this.m = j1_b.f1021b;
        this.n = b.i.a.c.f3.e0.C(j1_b.c);
        this.o = j1_b.d;
        this.p = j1_b.e;
        int i = j1_b.f;
        this.q = i;
        int i2 = j1_b.g;
        this.r = i2;
        this.f1017s = i2 != -1 ? i2 : i;
        this.t = j1_b.h;
        this.u = j1_b.i;
        this.v = j1_b.j;
        this.w = j1_b.k;
        this.f1018x = j1_b.l;
        List<byte[]> list = j1_b.m;
        this.f1019y = list == null ? Collections.emptyList() : list;
        DrmInitData drmInitData = j1_b.n;
        this.f1020z = drmInitData;
        this.A = j1_b.o;
        this.B = j1_b.p;
        this.C = j1_b.q;
        this.D = j1_b.r;
        int i3 = j1_b.f1022s;
        this.E = i3 == -1 ? 0 : i3;
        float f = j1_b.t;
        this.F = f == -1.0f ? 1.0f : f;
        this.G = j1_b.u;
        this.H = j1_b.v;
        this.I = j1_b.w;
        this.J = j1_b.f1023x;
        this.K = j1_b.f1024y;
        this.L = j1_b.f1025z;
        int i4 = j1_b.A;
        this.M = i4 == -1 ? 0 : i4;
        int i5 = j1_b.B;
        this.N = i5 != -1 ? i5 : 0;
        this.O = j1_b.C;
        int i6 = j1_b.D;
        if (i6 != 0 || drmInitData == null) {
            this.P = i6;
        } else {
            this.P = 1;
        }
    }

    @Nullable
    public static <T> T b(@Nullable T t, @Nullable T t2) {
        return t != null ? t : t2;
    }

    public static String d(int i) {
        return Integer.toString(i, 36);
    }

    public j1$b a() {
        return new j1$b(this, null);
    }

    public boolean c(j1 j1Var) {
        if (this.f1019y.size() != j1Var.f1019y.size()) {
            return false;
        }
        for (int i = 0; i < this.f1019y.size(); i++) {
            if (!Arrays.equals(this.f1019y.get(i), j1Var.f1019y.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || j1.class != obj.getClass()) {
            return false;
        }
        j1 j1Var = (j1) obj;
        int i2 = this.Q;
        return (i2 == 0 || (i = j1Var.Q) == 0 || i2 == i) && this.o == j1Var.o && this.p == j1Var.p && this.q == j1Var.q && this.r == j1Var.r && this.f1018x == j1Var.f1018x && this.A == j1Var.A && this.B == j1Var.B && this.C == j1Var.C && this.E == j1Var.E && this.H == j1Var.H && this.J == j1Var.J && this.K == j1Var.K && this.L == j1Var.L && this.M == j1Var.M && this.N == j1Var.N && this.O == j1Var.O && this.P == j1Var.P && Float.compare(this.D, j1Var.D) == 0 && Float.compare(this.F, j1Var.F) == 0 && b.i.a.c.f3.e0.a(this.l, j1Var.l) && b.i.a.c.f3.e0.a(this.m, j1Var.m) && b.i.a.c.f3.e0.a(this.t, j1Var.t) && b.i.a.c.f3.e0.a(this.v, j1Var.v) && b.i.a.c.f3.e0.a(this.w, j1Var.w) && b.i.a.c.f3.e0.a(this.n, j1Var.n) && Arrays.equals(this.G, j1Var.G) && b.i.a.c.f3.e0.a(this.u, j1Var.u) && b.i.a.c.f3.e0.a(this.I, j1Var.I) && b.i.a.c.f3.e0.a(this.f1020z, j1Var.f1020z) && c(j1Var);
    }

    public int hashCode() {
        if (this.Q == 0) {
            String str = this.l;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.m;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.n;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31;
            String str4 = this.t;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.u;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.v;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.w;
            this.Q = ((((((((((((((((Float.floatToIntBits(this.F) + ((((Float.floatToIntBits(this.D) + ((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f1018x) * 31) + ((int) this.A)) * 31) + this.B) * 31) + this.C) * 31)) * 31) + this.E) * 31)) * 31) + this.H) * 31) + this.J) * 31) + this.K) * 31) + this.L) * 31) + this.M) * 31) + this.N) * 31) + this.O) * 31) + this.P;
        }
        return this.Q;
    }

    public String toString() {
        String str = this.l;
        String str2 = this.m;
        String str3 = this.v;
        String str4 = this.w;
        String str5 = this.t;
        int i = this.f1017s;
        String str6 = this.n;
        int i2 = this.B;
        int i3 = this.C;
        float f = this.D;
        int i4 = this.J;
        int i5 = this.K;
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str6, b.d.b.a.a.b(str5, b.d.b.a.a.b(str4, b.d.b.a.a.b(str3, b.d.b.a.a.b(str2, b.d.b.a.a.b(str, 104)))))), "Format(", str, ", ", str2);
        b.d.b.a.a.s0(sbS, ", ", str3, ", ", str4);
        sbS.append(", ");
        sbS.append(str5);
        sbS.append(", ");
        sbS.append(i);
        sbS.append(", ");
        sbS.append(str6);
        sbS.append(", [");
        sbS.append(i2);
        sbS.append(", ");
        sbS.append(i3);
        sbS.append(", ");
        sbS.append(f);
        sbS.append("], [");
        sbS.append(i4);
        sbS.append(", ");
        sbS.append(i5);
        sbS.append("])");
        return sbS.toString();
    }
}
