package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.n.c0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4358c0<TResult> extends Task<TResult> {

    /* JADX INFO: renamed from: a */
    public final Object f11471a = new Object();

    /* JADX INFO: renamed from: b */
    public final C4382z<TResult> f11472b = new C4382z<>();

    /* JADX INFO: renamed from: c */
    public boolean f11473c;

    /* JADX INFO: renamed from: d */
    public volatile boolean f11474d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public TResult f11475e;

    /* JADX INFO: renamed from: f */
    public Exception f11476f;

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    /* JADX INFO: renamed from: a */
    public final Task<TResult> mo6006a(@NonNull Executor executor, @NonNull InterfaceC4355b interfaceC4355b) {
        this.f11472b.m6031a(new C4372p(executor, interfaceC4355b));
        m6028w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    /* JADX INFO: renamed from: b */
    public final Task<TResult> mo6007b(@NonNull InterfaceC4357c<TResult> interfaceC4357c) {
        this.f11472b.m6031a(new C4374r(C4363g.f11479a, interfaceC4357c));
        m6028w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    /* JADX INFO: renamed from: c */
    public final Task<TResult> mo6008c(@NonNull Executor executor, @NonNull InterfaceC4357c<TResult> interfaceC4357c) {
        this.f11472b.m6031a(new C4374r(executor, interfaceC4357c));
        m6028w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    /* JADX INFO: renamed from: d */
    public final Task<TResult> mo6009d(@NonNull InterfaceC4359d interfaceC4359d) {
        mo6010e(C4363g.f11479a, interfaceC4359d);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    /* JADX INFO: renamed from: e */
    public final Task<TResult> mo6010e(@NonNull Executor executor, @NonNull InterfaceC4359d interfaceC4359d) {
        this.f11472b.m6031a(new C4376t(executor, interfaceC4359d));
        m6028w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    /* JADX INFO: renamed from: f */
    public final Task<TResult> mo6011f(@NonNull InterfaceC4361e<? super TResult> interfaceC4361e) {
        mo6012g(C4363g.f11479a, interfaceC4361e);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    /* JADX INFO: renamed from: g */
    public final Task<TResult> mo6012g(@NonNull Executor executor, @NonNull InterfaceC4361e<? super TResult> interfaceC4361e) {
        this.f11472b.m6031a(new C4378v(executor, interfaceC4361e));
        m6028w();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    /* JADX INFO: renamed from: h */
    public final <TContinuationResult> Task<TContinuationResult> mo6013h(@NonNull InterfaceC4353a<TResult, TContinuationResult> interfaceC4353a) {
        return mo6014i(C4363g.f11479a, interfaceC4353a);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    /* JADX INFO: renamed from: i */
    public final <TContinuationResult> Task<TContinuationResult> mo6014i(@NonNull Executor executor, @NonNull InterfaceC4353a<TResult, TContinuationResult> interfaceC4353a) {
        C4358c0 c4358c0 = new C4358c0();
        this.f11472b.m6031a(new C4368l(executor, interfaceC4353a, c4358c0));
        m6028w();
        return c4358c0;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    /* JADX INFO: renamed from: j */
    public final <TContinuationResult> Task<TContinuationResult> mo6015j(@NonNull Executor executor, @NonNull InterfaceC4353a<TResult, Task<TContinuationResult>> interfaceC4353a) {
        C4358c0 c4358c0 = new C4358c0();
        this.f11472b.m6031a(new C4370n(executor, interfaceC4353a, c4358c0));
        m6028w();
        return c4358c0;
    }

    @Override // com.google.android.gms.tasks.Task
    @Nullable
    /* JADX INFO: renamed from: k */
    public final Exception mo6016k() {
        Exception exc;
        synchronized (this.f11471a) {
            exc = this.f11476f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: l */
    public final TResult mo6017l() {
        TResult tresult;
        synchronized (this.f11471a) {
            C1460d.m435G(this.f11473c, "Task is not yet complete");
            if (this.f11474d) {
                throw new CancellationException("Task is already canceled.");
            }
            Exception exc = this.f11476f;
            if (exc != null) {
                throw new RuntimeExecutionException(exc);
            }
            tresult = this.f11475e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: m */
    public final <X extends Throwable> TResult mo6018m(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f11471a) {
            C1460d.m435G(this.f11473c, "Task is not yet complete");
            if (this.f11474d) {
                throw new CancellationException("Task is already canceled.");
            }
            if (cls.isInstance(this.f11476f)) {
                throw cls.cast(this.f11476f);
            }
            Exception exc = this.f11476f;
            if (exc != null) {
                throw new RuntimeExecutionException(exc);
            }
            tresult = this.f11475e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: n */
    public final boolean mo6019n() {
        return this.f11474d;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: o */
    public final boolean mo6020o() {
        boolean z2;
        synchronized (this.f11471a) {
            z2 = this.f11473c;
        }
        return z2;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: p */
    public final boolean mo6021p() {
        boolean z2;
        synchronized (this.f11471a) {
            z2 = false;
            if (this.f11473c && !this.f11474d && this.f11476f == null) {
                z2 = true;
            }
        }
        return z2;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    /* JADX INFO: renamed from: q */
    public final <TContinuationResult> Task<TContinuationResult> mo6022q(@NonNull InterfaceC4362f<TResult, TContinuationResult> interfaceC4362f) {
        Executor executor = C4363g.f11479a;
        C4358c0 c4358c0 = new C4358c0();
        this.f11472b.m6031a(new C4380x(executor, interfaceC4362f, c4358c0));
        m6028w();
        return c4358c0;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    /* JADX INFO: renamed from: r */
    public final <TContinuationResult> Task<TContinuationResult> mo6023r(Executor executor, InterfaceC4362f<TResult, TContinuationResult> interfaceC4362f) {
        C4358c0 c4358c0 = new C4358c0();
        this.f11472b.m6031a(new C4380x(executor, interfaceC4362f, c4358c0));
        m6028w();
        return c4358c0;
    }

    /* JADX INFO: renamed from: s */
    public final void m6024s(@Nullable TResult tresult) {
        synchronized (this.f11471a) {
            m6027v();
            this.f11473c = true;
            this.f11475e = tresult;
        }
        this.f11472b.m6032b(this);
    }

    /* JADX INFO: renamed from: t */
    public final void m6025t(@NonNull Exception exc) {
        C1460d.m595z(exc, "Exception must not be null");
        synchronized (this.f11471a) {
            m6027v();
            this.f11473c = true;
            this.f11476f = exc;
        }
        this.f11472b.m6032b(this);
    }

    /* JADX INFO: renamed from: u */
    public final boolean m6026u() {
        synchronized (this.f11471a) {
            if (this.f11473c) {
                return false;
            }
            this.f11473c = true;
            this.f11474d = true;
            this.f11472b.m6032b(this);
            return true;
        }
    }

    /* JADX INFO: renamed from: v */
    public final void m6027v() {
        String strM822J;
        if (this.f11473c) {
            int i = DuplicateTaskCompletionException.f20844j;
            if (!mo6020o()) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception excMo6016k = mo6016k();
            if (excMo6016k != null) {
                strM822J = "failure";
            } else if (mo6021p()) {
                String strValueOf = String.valueOf(mo6017l());
                strM822J = C1643a.m822J(new StringBuilder(strValueOf.length() + 7), "result ", strValueOf);
            } else {
                strM822J = mo6019n() ? "cancellation" : "unknown issue";
            }
            String strValueOf2 = String.valueOf(strM822J);
        }
    }

    /* JADX INFO: renamed from: w */
    public final void m6028w() {
        synchronized (this.f11471a) {
            if (this.f11473c) {
                this.f11472b.m6032b(this);
            }
        }
    }
}
