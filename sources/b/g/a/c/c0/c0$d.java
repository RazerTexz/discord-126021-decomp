package b.g.a.c.c0;

/* JADX INFO: compiled from: POJOPropertyBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c0$d<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0$d<T> f688b;
    public final b.g.a.c.t c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    public c0$d(T t, c0$d<T> c0_d, b.g.a.c.t tVar, boolean z2, boolean z3, boolean z4) {
        this.a = t;
        this.f688b = c0_d;
        b.g.a.c.t tVar2 = (tVar == null || tVar.d()) ? null : tVar;
        this.c = tVar2;
        if (z2) {
            if (tVar2 == null) {
                throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
            }
            if (!tVar.c()) {
                z2 = false;
            }
        }
        this.d = z2;
        this.e = z3;
        this.f = z4;
    }

    public c0$d<T> a(c0$d<T> c0_d) {
        c0$d<T> c0_d2 = this.f688b;
        return c0_d2 == null ? c(c0_d) : c(c0_d2.a(c0_d));
    }

    public c0$d<T> b() {
        c0$d<T> c0_d = this.f688b;
        if (c0_d == null) {
            return this;
        }
        c0$d<T> c0_dB = c0_d.b();
        if (this.c != null) {
            return c0_dB.c == null ? c(null) : c(c0_dB);
        }
        if (c0_dB.c != null) {
            return c0_dB;
        }
        boolean z2 = this.e;
        if (z2 == c0_dB.e) {
            return c(c0_dB);
        }
        return z2 ? c(null) : c0_dB;
    }

    public c0$d<T> c(c0$d<T> c0_d) {
        return c0_d == this.f688b ? this : new c0$d<>(this.a, c0_d, this.c, this.d, this.e, this.f);
    }

    public c0$d<T> d() {
        c0$d<T> c0_dD;
        if (!this.f) {
            c0$d<T> c0_d = this.f688b;
            return (c0_d == null || (c0_dD = c0_d.d()) == this.f688b) ? this : c(c0_dD);
        }
        c0$d<T> c0_d2 = this.f688b;
        if (c0_d2 == null) {
            return null;
        }
        return c0_d2.d();
    }

    public c0$d<T> e() {
        return this.f688b == null ? this : new c0$d<>(this.a, null, this.c, this.d, this.e, this.f);
    }

    public c0$d<T> f() {
        c0$d<T> c0_d = this.f688b;
        c0$d<T> c0_dF = c0_d == null ? null : c0_d.f();
        return this.e ? c(c0_dF) : c0_dF;
    }

    public String toString() {
        String str = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", this.a.toString(), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.d));
        if (this.f688b == null) {
            return str;
        }
        StringBuilder sbX = b.d.b.a.a.X(str, ", ");
        sbX.append(this.f688b.toString());
        return sbX.toString();
    }
}
