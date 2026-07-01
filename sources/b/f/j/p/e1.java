package b.f.j.p;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: StatefulProducerRunnable.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e1<T> implements Runnable {
    public final AtomicInteger j = new AtomicInteger(0);
    public final l<T> k;
    public final z0 l;
    public final String m;
    public final x0 n;

    public e1(l<T> lVar, z0 z0Var, x0 x0Var, String str) {
        this.k = lVar;
        this.l = z0Var;
        this.m = str;
        this.n = x0Var;
        z0Var.e(x0Var, str);
    }

    public void a() {
        if (this.j.compareAndSet(0, 2)) {
            e();
        }
    }

    public abstract void b(T t);

    public Map<String, String> c(T t) {
        return null;
    }

    public abstract T d() throws Exception;

    public void e() {
        z0 z0Var = this.l;
        x0 x0Var = this.n;
        String str = this.m;
        z0Var.g(x0Var, str);
        z0Var.d(x0Var, str, null);
        this.k.d();
    }

    public void f(Exception exc) {
        z0 z0Var = this.l;
        x0 x0Var = this.n;
        String str = this.m;
        z0Var.g(x0Var, str);
        z0Var.k(x0Var, str, exc, null);
        this.k.c(exc);
    }

    public void g(T t) {
        z0 z0Var = this.l;
        x0 x0Var = this.n;
        String str = this.m;
        z0Var.j(x0Var, str, z0Var.g(x0Var, str) ? c(t) : null);
        this.k.b(t, 1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.j.compareAndSet(0, 1)) {
            try {
                T tD = d();
                this.j.set(3);
                try {
                    g(tD);
                } finally {
                    b(tD);
                }
            } catch (Exception e) {
                this.j.set(4);
                f(e);
            }
        }
    }
}
