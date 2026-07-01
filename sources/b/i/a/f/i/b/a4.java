package b.i.a.f.i.b;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.c.a.a0.AnimatableValueParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a4 {
    public long A;
    public long B;
    public long C;
    public String D;
    public boolean E;
    public long F;
    public long G;
    public final u4 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1513b;
    public String c;
    public String d;
    public String e;
    public String f;
    public long g;
    public long h;
    public long i;
    public String j;
    public long k;
    public String l;
    public long m;
    public long n;
    public boolean o;
    public long p;
    public boolean q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f1514s;
    public Boolean t;
    public long u;
    public List<String> v;
    public String w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f1515x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f1516y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f1517z;

    @WorkerThread
    public a4(u4 u4Var, String str) {
        Objects.requireNonNull(u4Var, "null reference");
        AnimatableValueParser.w(str);
        this.a = u4Var;
        this.f1513b = str;
        u4Var.f().b();
    }

    @WorkerThread
    public final void A(String str) {
        this.a.f().b();
        this.E |= !t9.q0(this.f, str);
        this.f = str;
    }

    @WorkerThread
    public final String B() {
        this.a.f().b();
        return this.w;
    }

    @WorkerThread
    public final void C(long j) {
        AnimatableValueParser.l(j >= 0);
        this.a.f().b();
        this.E = (this.g != j) | this.E;
        this.g = j;
    }

    @WorkerThread
    public final void D(String str) {
        this.a.f().b();
        this.E |= !t9.q0(this.j, str);
        this.j = str;
    }

    @WorkerThread
    public final String E() {
        this.a.f().b();
        return this.e;
    }

    @WorkerThread
    public final void F(long j) {
        this.a.f().b();
        this.E |= this.F != j;
        this.F = j;
    }

    @WorkerThread
    public final void G(String str) {
        this.a.f().b();
        this.E |= !t9.q0(this.l, str);
        this.l = str;
    }

    @WorkerThread
    public final String H() {
        this.a.f().b();
        return this.f;
    }

    @WorkerThread
    public final void I(long j) {
        this.a.f().b();
        this.E |= this.G != j;
        this.G = j;
    }

    @WorkerThread
    public final void J(String str) {
        this.a.f().b();
        this.E |= !t9.q0(this.D, str);
        this.D = str;
    }

    @WorkerThread
    public final long K() {
        this.a.f().b();
        return this.h;
    }

    @WorkerThread
    public final long L() {
        this.a.f().b();
        return this.i;
    }

    @WorkerThread
    public final String M() {
        this.a.f().b();
        return this.j;
    }

    @WorkerThread
    public final long N() {
        this.a.f().b();
        return this.k;
    }

    @WorkerThread
    public final String O() {
        this.a.f().b();
        return this.l;
    }

    @WorkerThread
    public final long P() {
        this.a.f().b();
        return this.m;
    }

    @WorkerThread
    public final long Q() {
        this.a.f().b();
        return this.n;
    }

    @WorkerThread
    public final void R(long j) {
        this.a.f().b();
        this.E |= this.p != j;
        this.p = j;
    }

    @WorkerThread
    public final long S() {
        this.a.f().b();
        return this.u;
    }

    @WorkerThread
    public final boolean T() {
        this.a.f().b();
        return this.o;
    }

    @WorkerThread
    public final long U() {
        this.a.f().b();
        return this.g;
    }

    @WorkerThread
    public final long V() {
        this.a.f().b();
        return this.F;
    }

    @WorkerThread
    public final long W() {
        this.a.f().b();
        return this.G;
    }

    @WorkerThread
    public final void X() {
        this.a.f().b();
        long j = this.g + 1;
        if (j > 2147483647L) {
            this.a.g().i.b("Bundle index overflow. appId", q3.s(this.f1513b));
            j = 0;
        }
        this.E = true;
        this.g = j;
    }

    @WorkerThread
    public final void a(long j) {
        this.a.f().b();
        this.E |= this.h != j;
        this.h = j;
    }

    @WorkerThread
    public final void b(Boolean bool) {
        boolean zEquals;
        this.a.f().b();
        boolean z2 = this.E;
        Boolean bool2 = this.t;
        if (bool2 == null && bool == null) {
            zEquals = true;
        } else {
            zEquals = bool2 == null ? false : bool2.equals(bool);
        }
        this.E = z2 | (!zEquals);
        this.t = bool;
    }

    @WorkerThread
    public final void c(String str) {
        this.a.f().b();
        this.E |= !t9.q0(this.c, str);
        this.c = str;
    }

    @WorkerThread
    public final void d(@Nullable List<String> list) {
        boolean zEquals;
        this.a.f().b();
        List<String> list2 = this.v;
        if (list2 == null && list == null) {
            zEquals = true;
        } else {
            zEquals = list2 == null ? false : list2.equals(list);
        }
        if (zEquals) {
            return;
        }
        this.E = true;
        this.v = list != null ? new ArrayList(list) : null;
    }

    @WorkerThread
    public final void e(boolean z2) {
        this.a.f().b();
        this.E |= this.o != z2;
        this.o = z2;
    }

    @WorkerThread
    public final String f() {
        this.a.f().b();
        String str = this.D;
        J(null);
        return str;
    }

    @WorkerThread
    public final long g() {
        this.a.f().b();
        return this.p;
    }

    @WorkerThread
    public final boolean h() {
        this.a.f().b();
        return this.q;
    }

    @WorkerThread
    public final boolean i() {
        this.a.f().b();
        return this.r;
    }

    @WorkerThread
    public final Boolean j() {
        this.a.f().b();
        return this.t;
    }

    @Nullable
    @WorkerThread
    public final List<String> k() {
        this.a.f().b();
        return this.v;
    }

    @WorkerThread
    public final void l(long j) {
        this.a.f().b();
        this.E |= this.i != j;
        this.i = j;
    }

    @WorkerThread
    public final void m(String str) {
        this.a.f().b();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !t9.q0(this.d, str);
        this.d = str;
    }

    @WorkerThread
    public final void n(boolean z2) {
        this.a.f().b();
        this.E |= this.q != z2;
        this.q = z2;
    }

    @WorkerThread
    public final String o() {
        this.a.f().b();
        return this.f1513b;
    }

    @WorkerThread
    public final void p(long j) {
        this.a.f().b();
        this.E |= this.k != j;
        this.k = j;
    }

    @WorkerThread
    public final void q(String str) {
        this.a.f().b();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !t9.q0(this.f1514s, str);
        this.f1514s = str;
    }

    @WorkerThread
    public final void r(boolean z2) {
        this.a.f().b();
        this.E |= this.r != z2;
        this.r = z2;
    }

    @WorkerThread
    public final String s() {
        this.a.f().b();
        return this.c;
    }

    @WorkerThread
    public final void t(long j) {
        this.a.f().b();
        this.E |= this.m != j;
        this.m = j;
    }

    @WorkerThread
    public final void u(String str) {
        this.a.f().b();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !t9.q0(this.w, str);
        this.w = str;
    }

    @WorkerThread
    public final String v() {
        this.a.f().b();
        return this.d;
    }

    @WorkerThread
    public final void w(long j) {
        this.a.f().b();
        this.E |= this.n != j;
        this.n = j;
    }

    @WorkerThread
    public final void x(String str) {
        this.a.f().b();
        this.E |= !t9.q0(this.e, str);
        this.e = str;
    }

    @WorkerThread
    public final String y() {
        this.a.f().b();
        return this.f1514s;
    }

    @WorkerThread
    public final void z(long j) {
        this.a.f().b();
        this.E |= this.u != j;
        this.u = j;
    }
}
