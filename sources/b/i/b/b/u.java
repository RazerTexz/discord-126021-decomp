package b.i.b.b;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: compiled from: MapMaker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1649b = -1;
    public int c = -1;

    @MonotonicNonNullDecl
    public v$p d;

    @MonotonicNonNullDecl
    public v$p e;

    @MonotonicNonNullDecl
    public b.i.b.a.d<Object> f;

    public v$p a() {
        return (v$p) b.i.a.f.e.o.f.W(this.d, v$p.j);
    }

    public v$p b() {
        return (v$p) b.i.a.f.e.o.f.W(this.e, v$p.j);
    }

    public <K, V> ConcurrentMap<K, V> c() {
        if (!this.a) {
            int i = this.f1649b;
            if (i == -1) {
                i = 16;
            }
            int i2 = this.c;
            if (i2 == -1) {
                i2 = 4;
            }
            return new ConcurrentHashMap(i, 0.75f, i2);
        }
        v$b0<Object, Object, v$e> v_b0 = v.j;
        v$p v_p = v$p.k;
        v$p v_pA = a();
        v$p v_p2 = v$p.j;
        if (v_pA == v_p2 && b() == v_p2) {
            return new v(this, v$q$a.a);
        }
        if (a() == v_p2 && b() == v_p) {
            return new v(this, v$s$a.a);
        }
        if (a() == v_p && b() == v_p2) {
            return new v(this, v$w$a.a);
        }
        if (a() == v_p && b() == v_p) {
            return new v(this, v$y$a.a);
        }
        throw new AssertionError();
    }

    public u d(v$p v_p) {
        v$p v_p2 = this.d;
        b.i.a.f.e.o.f.G(v_p2 == null, "Key strength was already set to %s", v_p2);
        Objects.requireNonNull(v_p);
        this.d = v_p;
        if (v_p != v$p.j) {
            this.a = true;
        }
        return this;
    }

    public String toString() {
        b.i.b.a.g gVar = new b.i.b.a.g(u.class.getSimpleName(), null);
        int i = this.f1649b;
        if (i != -1) {
            gVar.a("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != -1) {
            gVar.a("concurrencyLevel", i2);
        }
        v$p v_p = this.d;
        if (v_p != null) {
            String strU1 = b.i.a.f.e.o.f.u1(v_p.toString());
            b.i.b.a.g$a g_a = new b.i.b.a.g$a(null);
            gVar.c.c = g_a;
            gVar.c = g_a;
            g_a.f1644b = strU1;
            g_a.a = "keyStrength";
        }
        v$p v_p2 = this.e;
        if (v_p2 != null) {
            String strU2 = b.i.a.f.e.o.f.u1(v_p2.toString());
            b.i.b.a.g$a g_a2 = new b.i.b.a.g$a(null);
            gVar.c.c = g_a2;
            gVar.c = g_a2;
            g_a2.f1644b = strU2;
            g_a2.a = "valueStrength";
        }
        if (this.f != null) {
            b.i.b.a.g$a g_a3 = new b.i.b.a.g$a(null);
            gVar.c.c = g_a3;
            gVar.c = g_a3;
            g_a3.f1644b = "keyEquivalence";
        }
        return gVar.toString();
    }
}
