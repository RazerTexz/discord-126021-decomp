package b.i.a.c;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: Timeline.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o2$c implements w0 {
    public static final Object j = new Object();
    public static final Object k = new Object();
    public static final o1 l;
    public static final w0$a<o2$c> m;
    public long A;
    public int B;
    public int C;
    public long D;

    @Nullable
    @Deprecated
    public Object o;

    @Nullable
    public Object q;
    public long r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f1042s;
    public long t;
    public boolean u;
    public boolean v;

    @Deprecated
    public boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public o1$g f1043x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1044y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f1045z;
    public Object n = j;
    public o1 p = l;

    static {
        o1$i o1_i;
        o1$d$a o1_d_a = new o1$d$a();
        o1$f$a o1_f_a = new o1$f$a(null);
        List listEmptyList = Collections.emptyList();
        b.i.b.b.p<Object> pVar = b.i.b.b.h0.l;
        o1$g$a o1_g_a = new o1$g$a();
        Uri uri = Uri.EMPTY;
        b.c.a.a0.d.D(o1_f_a.f1037b == null || o1_f_a.a != null);
        if (uri != null) {
            o1_i = new o1$i(uri, null, o1_f_a.a != null ? new o1$f(o1_f_a, null) : null, null, listEmptyList, null, pVar, null, null);
        } else {
            o1_i = null;
        }
        l = new o1("com.google.android.exoplayer2.Timeline", o1_d_a.a(), o1_i, new o1$g(o1_g_a, null), p1.j, null);
        m = q0.a;
    }

    public static String d(int i) {
        return Integer.toString(i, 36);
    }

    public long a() {
        return b.i.a.c.f3.e0.M(this.f1045z);
    }

    public long b() {
        return b.i.a.c.f3.e0.M(this.A);
    }

    public boolean c() {
        b.c.a.a0.d.D(this.w == (this.f1043x != null));
        return this.f1043x != null;
    }

    public o2$c e(Object obj, @Nullable o1 o1Var, @Nullable Object obj2, long j2, long j3, long j4, boolean z2, boolean z3, @Nullable o1$g o1_g, long j5, long j6, int i, int i2, long j7) {
        o1$h o1_h;
        this.n = obj;
        this.p = o1Var != null ? o1Var : l;
        this.o = (o1Var == null || (o1_h = o1Var.l) == null) ? null : o1_h.g;
        this.q = obj2;
        this.r = j2;
        this.f1042s = j3;
        this.t = j4;
        this.u = z2;
        this.v = z3;
        this.w = o1_g != null;
        this.f1043x = o1_g;
        this.f1045z = j5;
        this.A = j6;
        this.B = i;
        this.C = i2;
        this.D = j7;
        this.f1044y = false;
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !o2$c.class.equals(obj.getClass())) {
            return false;
        }
        o2$c o2_c = (o2$c) obj;
        return b.i.a.c.f3.e0.a(this.n, o2_c.n) && b.i.a.c.f3.e0.a(this.p, o2_c.p) && b.i.a.c.f3.e0.a(this.q, o2_c.q) && b.i.a.c.f3.e0.a(this.f1043x, o2_c.f1043x) && this.r == o2_c.r && this.f1042s == o2_c.f1042s && this.t == o2_c.t && this.u == o2_c.u && this.v == o2_c.v && this.f1044y == o2_c.f1044y && this.f1045z == o2_c.f1045z && this.A == o2_c.A && this.B == o2_c.B && this.C == o2_c.C && this.D == o2_c.D;
    }

    public int hashCode() {
        int iHashCode = (this.p.hashCode() + ((this.n.hashCode() + 217) * 31)) * 31;
        Object obj = this.q;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        o1$g o1_g = this.f1043x;
        int iHashCode3 = (iHashCode2 + (o1_g != null ? o1_g.hashCode() : 0)) * 31;
        long j2 = this.r;
        int i = (iHashCode3 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.f1042s;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.t;
        int i3 = (((((((i2 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.u ? 1 : 0)) * 31) + (this.v ? 1 : 0)) * 31) + (this.f1044y ? 1 : 0)) * 31;
        long j5 = this.f1045z;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.A;
        int i5 = (((((i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.B) * 31) + this.C) * 31;
        long j7 = this.D;
        return i5 + ((int) (j7 ^ (j7 >>> 32)));
    }
}
