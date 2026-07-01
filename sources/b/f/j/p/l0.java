package b.f.j.p;

import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l0<K, T extends Closeable> implements w0<T> {

    @VisibleForTesting
    public final Map<K, l0<K, T>.l0$b> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0<T> f622b;
    public final boolean c;
    public final String d;
    public final String e;

    public l0(w0<T> w0Var, String str, String str2) {
        this.f622b = w0Var;
        this.a = new HashMap();
        this.c = false;
        this.d = str;
        this.e = str2;
    }

    @Override // b.f.j.p.w0
    public void b(l<T> lVar, x0 x0Var) {
        boolean z2;
        l0<K, T>.l0$b l0_b;
        try {
            b.f.j.r.b.b();
            x0Var.o().e(x0Var, this.d);
            K kD = d(x0Var);
            do {
                z2 = false;
                synchronized (this) {
                    synchronized (this) {
                        l0_b = this.a.get(kD);
                    }
                }
                if (l0_b == null) {
                    synchronized (this) {
                        l0_b = new l0$b(this, kD);
                        this.a.put(kD, l0_b);
                        z2 = true;
                    }
                }
            } while (!l0_b.a(lVar, x0Var));
            if (z2) {
                l0_b.i(b.f.d.l.a.f(x0Var.k()));
            }
            b.f.j.r.b.b();
        } catch (Throwable th) {
            b.f.j.r.b.b();
            throw th;
        }
    }

    public abstract T c(T t);

    public abstract K d(x0 x0Var);

    /* JADX WARN: Incorrect inner types in method signature: (TK;Lb/f/j/p/l0<TK;TT;>.b;)V */
    public synchronized void e(Object obj, l0$b l0_b) {
        if (this.a.get(obj) == l0_b) {
            this.a.remove(obj);
        }
    }

    public l0(w0<T> w0Var, String str, String str2, boolean z2) {
        this.f622b = w0Var;
        this.a = new HashMap();
        this.c = z2;
        this.d = str;
        this.e = str2;
    }
}
