package z;

import bolts.ExecutorException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public class g<TResult> {
    public static final ExecutorService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f3860b;
    public static final Executor c;
    public static g<?> d;
    public static g<Boolean> e;
    public static g<Boolean> f;
    public boolean h;
    public boolean i;
    public TResult j;
    public Exception k;
    public boolean l;
    public final Object g = new Object();
    public List<c<TResult, Void>> m = new ArrayList();

    static {
        b bVar = b.a;
        a = bVar.f3858b;
        f3860b = bVar.c;
        c = a.a.e;
        d = new g<>((Object) null);
        e = new g<>(Boolean.TRUE);
        f = new g<>(Boolean.FALSE);
        new g(true);
    }

    public g() {
    }

    public static <TResult> g<TResult> a(Callable<TResult> callable, Executor executor) {
        h hVar = new h();
        try {
            executor.execute(new f(hVar, callable));
        } catch (Exception e2) {
            hVar.b(new ExecutorException(e2));
        }
        return hVar.a;
    }

    public static <TResult> g<TResult> c(Exception exc) {
        boolean z2;
        g<TResult> gVar = new g<>();
        synchronized (gVar.g) {
            z2 = false;
            if (!gVar.h) {
                gVar.h = true;
                gVar.k = exc;
                gVar.l = false;
                gVar.g.notifyAll();
                gVar.f();
                z2 = true;
            }
        }
        if (z2) {
            return gVar;
        }
        throw new IllegalStateException("Cannot set the error on a completed task.");
    }

    public <TContinuationResult> g<TContinuationResult> b(c<TResult, TContinuationResult> cVar) {
        boolean z2;
        Executor executor = f3860b;
        h hVar = new h();
        synchronized (this.g) {
            synchronized (this.g) {
                z2 = this.h;
            }
            if (!z2) {
                this.m.add(new d(this, hVar, cVar, executor));
            }
        }
        if (z2) {
            try {
                executor.execute(new e(hVar, cVar, this));
            } catch (Exception e2) {
                hVar.b(new ExecutorException(e2));
            }
        }
        return hVar.a;
    }

    public Exception d() {
        Exception exc;
        synchronized (this.g) {
            exc = this.k;
            if (exc != null) {
                this.l = true;
            }
        }
        return exc;
    }

    public boolean e() {
        boolean z2;
        synchronized (this.g) {
            z2 = d() != null;
        }
        return z2;
    }

    public final void f() {
        synchronized (this.g) {
            Iterator<c<TResult, Void>> it = this.m.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.m = null;
        }
    }

    public boolean g() {
        synchronized (this.g) {
            if (this.h) {
                return false;
            }
            this.h = true;
            this.i = true;
            this.g.notifyAll();
            f();
            return true;
        }
    }

    public boolean h(TResult tresult) {
        synchronized (this.g) {
            if (this.h) {
                return false;
            }
            this.h = true;
            this.j = tresult;
            this.g.notifyAll();
            f();
            return true;
        }
    }

    public g(TResult tresult) {
        h(tresult);
    }

    public g(boolean z2) {
        if (z2) {
            g();
        } else {
            h(null);
        }
    }
}
