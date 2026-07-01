package b.f.j.p;

import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: MultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public class l0$b {
    public final K a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<Pair<l<T>, x0>> f623b = new CopyOnWriteArraySet<>();

    /* JADX INFO: Incorrect field signature: TT; */
    public Closeable c;
    public float d;
    public int e;
    public d f;

    /* JADX WARN: Incorrect inner types in field signature: Lb/f/j/p/l0<TK;TT;>.b.a; */
    public l0$b$a g;
    public final /* synthetic */ l0 h;

    public l0$b(l0 l0Var, K k) {
        this.h = l0Var;
        this.a = k;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public boolean a(l<T> lVar, x0 x0Var) {
        l0<K, T>.l0$b l0_b;
        Pair pairCreate = Pair.create(lVar, x0Var);
        synchronized (this) {
            l0 l0Var = this.h;
            K k = this.a;
            synchronized (l0Var) {
                l0_b = l0Var.a.get(k);
            }
            if (l0_b != this) {
                return false;
            }
            this.f623b.add((Pair<l<T>, x0>) pairCreate);
            List<y0> listK = k();
            List<y0> listL = l();
            List<y0> listJ = j();
            Closeable closeableC = this.c;
            float f = this.d;
            int i = this.e;
            d.s(listK);
            d.t(listL);
            d.r(listJ);
            synchronized (pairCreate) {
                synchronized (this) {
                    if (closeableC != this.c) {
                        closeableC = null;
                    } else if (closeableC != null) {
                        closeableC = this.h.c(closeableC);
                    }
                }
                if (closeableC != null) {
                    if (f > 0.0f) {
                        lVar.a(f);
                    }
                    lVar.b(closeableC, i);
                    b(closeableC);
                }
            }
            x0Var.f(new m0(this, pairCreate));
            return true;
        }
    }

    public final void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final synchronized boolean c() {
        Iterator it = this.f623b.iterator();
        while (it.hasNext()) {
            if (((x0) ((Pair) it.next()).second).p()) {
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean d() {
        Iterator it = this.f623b.iterator();
        while (it.hasNext()) {
            if (!((x0) ((Pair) it.next()).second).k()) {
                return false;
            }
        }
        return true;
    }

    public final synchronized b.f.j.d.d e() {
        b.f.j.d.d dVar;
        dVar = b.f.j.d.d.LOW;
        Iterator it = this.f623b.iterator();
        while (it.hasNext()) {
            b.f.j.d.d dVarC = ((x0) ((Pair) it.next()).second).c();
            if (dVar.ordinal() <= dVarC.ordinal()) {
                dVar = dVarC;
            }
        }
        return dVar;
    }

    /* JADX WARN: Incorrect inner types in method signature: (Lb/f/j/p/l0<TK;TT;>.b.a;Ljava/lang/Throwable;)V */
    public void f(l0$b$a l0_b_a, Throwable th) {
        synchronized (this) {
            if (this.g != l0_b_a) {
                return;
            }
            Iterator it = this.f623b.iterator();
            this.f623b.clear();
            this.h.e(this.a, this);
            b(this.c);
            this.c = null;
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                synchronized (pair) {
                    ((x0) pair.second).o().k((x0) pair.second, this.h.d, th, null);
                    ((l) pair.first).c(th);
                }
            }
        }
    }

    /* JADX WARN: Incorrect inner types in method signature: (Lb/f/j/p/l0<TK;TT;>.b.a;TT;I)V */
    public void g(l0$b$a l0_b_a, Closeable closeable, int i) {
        synchronized (this) {
            if (this.g != l0_b_a) {
                return;
            }
            b(this.c);
            this.c = null;
            Iterator it = this.f623b.iterator();
            int size = this.f623b.size();
            if (b.f(i)) {
                this.c = this.h.c(closeable);
                this.e = i;
            } else {
                this.f623b.clear();
                this.h.e(this.a, this);
            }
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                synchronized (pair) {
                    if (b.e(i)) {
                        ((x0) pair.second).o().j((x0) pair.second, this.h.d, null);
                        d dVar = this.f;
                        if (dVar != null) {
                            ((x0) pair.second).j(dVar.h);
                        }
                        ((x0) pair.second).d(this.h.e, Integer.valueOf(size));
                    }
                    ((l) pair.first).b(closeable, i);
                }
            }
        }
    }

    /* JADX WARN: Incorrect inner types in method signature: (Lb/f/j/p/l0<TK;TT;>.b.a;F)V */
    public void h(l0$b$a l0_b_a, float f) {
        synchronized (this) {
            if (this.g != l0_b_a) {
                return;
            }
            this.d = f;
            Iterator it = this.f623b.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                synchronized (pair) {
                    ((l) pair.first).a(f);
                }
            }
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void i(b.f.d.l.a aVar) {
        synchronized (this) {
            boolean z2 = true;
            b.c.a.a0.d.i(Boolean.valueOf(this.f == null));
            b.c.a.a0.d.i(Boolean.valueOf(this.g == null));
            if (this.f623b.isEmpty()) {
                this.h.e(this.a, this);
                return;
            }
            x0 x0Var = (x0) ((Pair) this.f623b.iterator().next()).second;
            d dVar = new d(x0Var.e(), x0Var.getId(), null, x0Var.o(), x0Var.b(), x0Var.q(), d(), c(), e(), x0Var.g());
            this.f = dVar;
            dVar.j(x0Var.a());
            Objects.requireNonNull(aVar);
            if (aVar != b.f.d.l.a.UNSET) {
                d dVar2 = this.f;
                int iOrdinal = aVar.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        if (iOrdinal == 2) {
                            throw new IllegalStateException("No boolean equivalent for UNSET");
                        }
                        throw new IllegalStateException("Unrecognized TriState value: " + aVar);
                    }
                    z2 = false;
                }
                dVar2.d("started_as_prefetch", Boolean.valueOf(z2));
            }
            l0$b$a l0_b_a = new l0$b$a(this, null);
            this.g = l0_b_a;
            this.h.f622b.b(l0_b_a, this.f);
        }
    }

    public final synchronized List<y0> j() {
        d dVar = this.f;
        ArrayList arrayList = null;
        if (dVar == null) {
            return null;
        }
        boolean zC = c();
        synchronized (dVar) {
            if (zC != dVar.k) {
                dVar.k = zC;
                arrayList = new ArrayList(dVar.m);
            }
        }
        return arrayList;
    }

    public final synchronized List<y0> k() {
        d dVar = this.f;
        ArrayList arrayList = null;
        if (dVar == null) {
            return null;
        }
        boolean zD = d();
        synchronized (dVar) {
            if (zD != dVar.i) {
                dVar.i = zD;
                arrayList = new ArrayList(dVar.m);
            }
        }
        return arrayList;
    }

    public final synchronized List<y0> l() {
        d dVar = this.f;
        if (dVar == null) {
            return null;
        }
        return dVar.v(e());
    }
}
