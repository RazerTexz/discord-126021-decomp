package b.i.a.f.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class c0<TResult> extends Task<TResult> {
    public final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z<TResult> f1592b = new z<>();
    public boolean c;
    public volatile boolean d;

    @Nullable
    public TResult e;
    public Exception f;

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> a(@NonNull Executor executor, @NonNull b bVar) {
        this.f1592b.a(new p(executor, bVar));
        w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> b(@NonNull c<TResult> cVar) {
        this.f1592b.a(new r(g.a, cVar));
        w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> c(@NonNull Executor executor, @NonNull c<TResult> cVar) {
        this.f1592b.a(new r(executor, cVar));
        w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> d(@NonNull d dVar) {
        e(g.a, dVar);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> e(@NonNull Executor executor, @NonNull d dVar) {
        this.f1592b.a(new t(executor, dVar));
        w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> f(@NonNull e<? super TResult> eVar) {
        g(g.a, eVar);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> g(@NonNull Executor executor, @NonNull e<? super TResult> eVar) {
        this.f1592b.a(new v(executor, eVar));
        w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> h(@NonNull a<TResult, TContinuationResult> aVar) {
        return i(g.a, aVar);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> i(@NonNull Executor executor, @NonNull a<TResult, TContinuationResult> aVar) {
        c0 c0Var = new c0();
        this.f1592b.a(new l(executor, aVar, c0Var));
        w();
        return c0Var;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> j(@NonNull Executor executor, @NonNull a<TResult, Task<TContinuationResult>> aVar) {
        c0 c0Var = new c0();
        this.f1592b.a(new n(executor, aVar, c0Var));
        w();
        return c0Var;
    }

    @Override // com.google.android.gms.tasks.Task
    @Nullable
    public final Exception k() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult l() {
        TResult tresult;
        synchronized (this.a) {
            b.c.a.a0.d.G(this.c, "Task is not yet complete");
            if (this.d) {
                throw new CancellationException("Task is already canceled.");
            }
            Exception exc = this.f;
            if (exc != null) {
                throw new RuntimeExecutionException(exc);
            }
            tresult = this.e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <X extends Throwable> TResult m(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.a) {
            b.c.a.a0.d.G(this.c, "Task is not yet complete");
            if (this.d) {
                throw new CancellationException("Task is already canceled.");
            }
            if (cls.isInstance(this.f)) {
                throw cls.cast(this.f);
            }
            Exception exc = this.f;
            if (exc != null) {
                throw new RuntimeExecutionException(exc);
            }
            tresult = this.e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean n() {
        return this.d;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean o() {
        boolean z2;
        synchronized (this.a) {
            z2 = this.c;
        }
        return z2;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean p() {
        boolean z2;
        synchronized (this.a) {
            z2 = false;
            if (this.c && !this.d && this.f == null) {
                z2 = true;
            }
        }
        return z2;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> q(@NonNull f<TResult, TContinuationResult> fVar) {
        Executor executor = g.a;
        c0 c0Var = new c0();
        this.f1592b.a(new x(executor, fVar, c0Var));
        w();
        return c0Var;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> r(Executor executor, f<TResult, TContinuationResult> fVar) {
        c0 c0Var = new c0();
        this.f1592b.a(new x(executor, fVar, c0Var));
        w();
        return c0Var;
    }

    public final void s(@Nullable TResult tresult) {
        synchronized (this.a) {
            v();
            this.c = true;
            this.e = tresult;
        }
        this.f1592b.b(this);
    }

    public final void t(@NonNull Exception exc) {
        b.c.a.a0.d.z(exc, "Exception must not be null");
        synchronized (this.a) {
            v();
            this.c = true;
            this.f = exc;
        }
        this.f1592b.b(this);
    }

    public final boolean u() {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.d = true;
            this.f1592b.b(this);
            return true;
        }
    }

    public final void v() {
        String strJ;
        if (this.c) {
            int i = DuplicateTaskCompletionException.j;
            if (!o()) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception excK = k();
            if (excK != null) {
                strJ = "failure";
            } else if (p()) {
                String strValueOf = String.valueOf(l());
                strJ = b.d.b.a.a.J(new StringBuilder(strValueOf.length() + 7), "result ", strValueOf);
            } else {
                strJ = n() ? "cancellation" : "unknown issue";
            }
            String strValueOf2 = String.valueOf(strJ);
        }
    }

    public final void w() {
        synchronized (this.a) {
            if (this.c) {
                this.f1592b.b(this);
            }
        }
    }
}
