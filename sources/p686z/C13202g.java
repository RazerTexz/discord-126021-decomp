package p686z;

import bolts.ExecutorException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: z.g */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public class C13202g<TResult> {

    /* JADX INFO: renamed from: a */
    public static final ExecutorService f27977a;

    /* JADX INFO: renamed from: b */
    public static final Executor f27978b;

    /* JADX INFO: renamed from: c */
    public static final Executor f27979c;

    /* JADX INFO: renamed from: d */
    public static C13202g<?> f27980d;

    /* JADX INFO: renamed from: e */
    public static C13202g<Boolean> f27981e;

    /* JADX INFO: renamed from: f */
    public static C13202g<Boolean> f27982f;

    /* JADX INFO: renamed from: h */
    public boolean f27984h;

    /* JADX INFO: renamed from: i */
    public boolean f27985i;

    /* JADX INFO: renamed from: j */
    public TResult f27986j;

    /* JADX INFO: renamed from: k */
    public Exception f27987k;

    /* JADX INFO: renamed from: l */
    public boolean f27988l;

    /* JADX INFO: renamed from: g */
    public final Object f27983g = new Object();

    /* JADX INFO: renamed from: m */
    public List<InterfaceC13198c<TResult, Void>> f27989m = new ArrayList();

    static {
        C13197b c13197b = C13197b.f27965a;
        f27977a = c13197b.f27966b;
        f27978b = c13197b.f27967c;
        f27979c = C13196a.f27960a.f27964e;
        f27980d = new C13202g<>((Object) null);
        f27981e = new C13202g<>(Boolean.TRUE);
        f27982f = new C13202g<>(Boolean.FALSE);
        new C13202g(true);
    }

    public C13202g() {
    }

    /* JADX INFO: renamed from: a */
    public static <TResult> C13202g<TResult> m11366a(Callable<TResult> callable, Executor executor) {
        C13203h c13203h = new C13203h();
        try {
            executor.execute(new RunnableC13201f(c13203h, callable));
        } catch (Exception e) {
            c13203h.m11375b(new ExecutorException(e));
        }
        return c13203h.f27990a;
    }

    /* JADX INFO: renamed from: c */
    public static <TResult> C13202g<TResult> m11367c(Exception exc) {
        boolean z2;
        C13202g<TResult> c13202g = new C13202g<>();
        synchronized (c13202g.f27983g) {
            z2 = false;
            if (!c13202g.f27984h) {
                c13202g.f27984h = true;
                c13202g.f27987k = exc;
                c13202g.f27988l = false;
                c13202g.f27983g.notifyAll();
                c13202g.m11371f();
                z2 = true;
            }
        }
        if (z2) {
            return c13202g;
        }
        throw new IllegalStateException("Cannot set the error on a completed task.");
    }

    /* JADX INFO: renamed from: b */
    public <TContinuationResult> C13202g<TContinuationResult> m11368b(InterfaceC13198c<TResult, TContinuationResult> interfaceC13198c) {
        boolean z2;
        Executor executor = f27978b;
        C13203h c13203h = new C13203h();
        synchronized (this.f27983g) {
            synchronized (this.f27983g) {
                z2 = this.f27984h;
            }
            if (!z2) {
                this.f27989m.add(new C13199d(this, c13203h, interfaceC13198c, executor));
            }
        }
        if (z2) {
            try {
                executor.execute(new RunnableC13200e(c13203h, interfaceC13198c, this));
            } catch (Exception e) {
                c13203h.m11375b(new ExecutorException(e));
            }
        }
        return c13203h.f27990a;
    }

    /* JADX INFO: renamed from: d */
    public Exception m11369d() {
        Exception exc;
        synchronized (this.f27983g) {
            exc = this.f27987k;
            if (exc != null) {
                this.f27988l = true;
            }
        }
        return exc;
    }

    /* JADX INFO: renamed from: e */
    public boolean m11370e() {
        boolean z2;
        synchronized (this.f27983g) {
            z2 = m11369d() != null;
        }
        return z2;
    }

    /* JADX INFO: renamed from: f */
    public final void m11371f() {
        synchronized (this.f27983g) {
            Iterator<InterfaceC13198c<TResult, Void>> it = this.f27989m.iterator();
            while (it.hasNext()) {
                try {
                    it.next().mo1510a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f27989m = null;
        }
    }

    /* JADX INFO: renamed from: g */
    public boolean m11372g() {
        synchronized (this.f27983g) {
            if (this.f27984h) {
                return false;
            }
            this.f27984h = true;
            this.f27985i = true;
            this.f27983g.notifyAll();
            m11371f();
            return true;
        }
    }

    /* JADX INFO: renamed from: h */
    public boolean m11373h(TResult tresult) {
        synchronized (this.f27983g) {
            if (this.f27984h) {
                return false;
            }
            this.f27984h = true;
            this.f27986j = tresult;
            this.f27983g.notifyAll();
            m11371f();
            return true;
        }
    }

    public C13202g(TResult tresult) {
        m11373h(tresult);
    }

    public C13202g(boolean z2) {
        if (z2) {
            m11372g();
        } else {
            m11373h(null);
        }
    }
}
