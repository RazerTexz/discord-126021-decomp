package b.i.a.c;

import android.os.Handler;
import androidx.annotation.Nullable;
import b.i.a.c.a3.b0$a;
import b.i.a.c.a3.b0$a$a;
import b.i.a.c.a3.k0$a;
import b.i.a.c.w2.s$a;
import b.i.a.c.w2.s$a$a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/* JADX INFO: compiled from: MediaSourceList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u1 {
    public final u1$d d;
    public final b0$a e;
    public final s$a f;
    public final HashMap<u1$c, u1$b> g;
    public final Set<u1$c> h;
    public boolean j;

    @Nullable
    public b.i.a.c.e3.a0 k;
    public b.i.a.c.a3.k0 i = new k0$a(0, new Random());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IdentityHashMap<b.i.a.c.a3.x, u1$c> f1137b = new IdentityHashMap<>();
    public final Map<Object, u1$c> c = new HashMap();
    public final List<u1$c> a = new ArrayList();

    public u1(u1$d u1_d, @Nullable b.i.a.c.s2.g1 g1Var, Handler handler) {
        this.d = u1_d;
        b0$a b0_a = new b0$a();
        this.e = b0_a;
        s$a s_a = new s$a();
        this.f = s_a;
        this.g = new HashMap<>();
        this.h = new HashSet();
        if (g1Var != null) {
            b0_a.c.add(new b0$a$a(handler, g1Var));
            s_a.c.add(new s$a$a(handler, g1Var));
        }
    }

    public o2 a(int i, List<u1$c> list, b.i.a.c.a3.k0 k0Var) {
        if (!list.isEmpty()) {
            this.i = k0Var;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                u1$c u1_c = list.get(i2 - i);
                if (i2 > 0) {
                    u1$c u1_c2 = this.a.get(i2 - 1);
                    u1_c.d = u1_c2.a.n.p() + u1_c2.d;
                    u1_c.e = false;
                    u1_c.c.clear();
                } else {
                    u1_c.d = 0;
                    u1_c.e = false;
                    u1_c.c.clear();
                }
                b(i2, u1_c.a.n.p());
                this.a.add(i2, u1_c);
                this.c.put(u1_c.f1139b, u1_c);
                if (this.j) {
                    g(u1_c);
                    if (this.f1137b.isEmpty()) {
                        this.h.add(u1_c);
                    } else {
                        u1$b u1_b = this.g.get(u1_c);
                        if (u1_b != null) {
                            u1_b.a.d(u1_b.f1138b);
                        }
                    }
                }
            }
        }
        return c();
    }

    public final void b(int i, int i2) {
        while (i < this.a.size()) {
            this.a.get(i).d += i2;
            i++;
        }
    }

    public o2 c() {
        if (this.a.isEmpty()) {
            return o2.j;
        }
        int iP = 0;
        for (int i = 0; i < this.a.size(); i++) {
            u1$c u1_c = this.a.get(i);
            u1_c.d = iP;
            iP += u1_c.a.n.p();
        }
        return new c2(this.a, this.i);
    }

    public final void d() {
        Iterator<u1$c> it = this.h.iterator();
        while (it.hasNext()) {
            u1$c next = it.next();
            if (next.c.isEmpty()) {
                u1$b u1_b = this.g.get(next);
                if (u1_b != null) {
                    u1_b.a.d(u1_b.f1138b);
                }
                it.remove();
            }
        }
    }

    public int e() {
        return this.a.size();
    }

    public final void f(u1$c u1_c) {
        if (u1_c.e && u1_c.c.isEmpty()) {
            u1$b u1_bRemove = this.g.remove(u1_c);
            Objects.requireNonNull(u1_bRemove);
            u1_bRemove.a.a(u1_bRemove.f1138b);
            u1_bRemove.a.c(u1_bRemove.c);
            u1_bRemove.a.g(u1_bRemove.c);
            this.h.remove(u1_c);
        }
    }

    public final void g(u1$c u1_c) {
        b.i.a.c.a3.v vVar = u1_c.a;
        n0 n0Var = new n0(this);
        u1$a u1_a = new u1$a(this, u1_c);
        this.g.put(u1_c, new u1$b(vVar, n0Var, u1_a));
        Handler handler = new Handler(b.i.a.c.f3.e0.o(), null);
        Objects.requireNonNull(vVar);
        b0$a b0_a = vVar.c;
        Objects.requireNonNull(b0_a);
        b0_a.c.add(new b0$a$a(handler, u1_a));
        Handler handler2 = new Handler(b.i.a.c.f3.e0.o(), null);
        s$a s_a = vVar.d;
        Objects.requireNonNull(s_a);
        s_a.c.add(new s$a$a(handler2, u1_a));
        vVar.l(n0Var, this.k);
    }

    public void h(b.i.a.c.a3.x xVar) {
        u1$c u1_cRemove = this.f1137b.remove(xVar);
        Objects.requireNonNull(u1_cRemove);
        u1_cRemove.a.j(xVar);
        u1_cRemove.c.remove(((b.i.a.c.a3.u) xVar).j);
        if (!this.f1137b.isEmpty()) {
            d();
        }
        f(u1_cRemove);
    }

    public final void i(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            u1$c u1_cRemove = this.a.remove(i3);
            this.c.remove(u1_cRemove.f1139b);
            b(i3, -u1_cRemove.a.n.p());
            u1_cRemove.e = true;
            if (this.j) {
                f(u1_cRemove);
            }
        }
    }
}
