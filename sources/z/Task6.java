package z;

import bolts.ExecutorException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: z.g, reason: use source file name */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public class Task6<TResult> {
    public static final ExecutorService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f3860b;
    public static final Executor c;
    public static Task6<?> d;
    public static Task6<Boolean> e;
    public static Task6<Boolean> f;
    public boolean h;
    public boolean i;
    public TResult j;
    public Exception k;
    public boolean l;
    public final Object g = new Object();
    public List<Continuation3<TResult, Void>> m = new ArrayList();

    static {
        BoltsExecutors boltsExecutors = BoltsExecutors.a;
        a = boltsExecutors.f3858b;
        f3860b = boltsExecutors.c;
        c = AndroidExecutors.a.e;
        d = new Task6<>((Object) null);
        e = new Task6<>(Boolean.TRUE);
        f = new Task6<>(Boolean.FALSE);
        new Task6(true);
    }

    public Task6() {
    }

    public static <TResult> Task6<TResult> a(Callable<TResult> callable, Executor executor) {
        TaskCompletionSource2 taskCompletionSource2 = new TaskCompletionSource2();
        try {
            executor.execute(new Task5(taskCompletionSource2, callable));
        } catch (Exception e2) {
            taskCompletionSource2.b(new ExecutorException(e2));
        }
        return taskCompletionSource2.a;
    }

    public static <TResult> Task6<TResult> c(Exception exc) {
        boolean z2;
        Task6<TResult> task6 = new Task6<>();
        synchronized (task6.g) {
            z2 = false;
            if (!task6.h) {
                task6.h = true;
                task6.k = exc;
                task6.l = false;
                task6.g.notifyAll();
                task6.f();
                z2 = true;
            }
        }
        if (z2) {
            return task6;
        }
        throw new IllegalStateException("Cannot set the error on a completed task.");
    }

    public <TContinuationResult> Task6<TContinuationResult> b(Continuation3<TResult, TContinuationResult> continuation3) {
        boolean z2;
        Executor executor = f3860b;
        TaskCompletionSource2 taskCompletionSource2 = new TaskCompletionSource2();
        synchronized (this.g) {
            synchronized (this.g) {
                z2 = this.h;
            }
            if (!z2) {
                this.m.add(new Task3(this, taskCompletionSource2, continuation3, executor));
            }
        }
        if (z2) {
            try {
                executor.execute(new Task4(taskCompletionSource2, continuation3, this));
            } catch (Exception e2) {
                taskCompletionSource2.b(new ExecutorException(e2));
            }
        }
        return taskCompletionSource2.a;
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
            Iterator<Continuation3<TResult, Void>> it = this.m.iterator();
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

    public Task6(TResult tresult) {
        h(tresult);
    }

    public Task6(boolean z2) {
        if (z2) {
            g();
        } else {
            h(null);
        }
    }
}
