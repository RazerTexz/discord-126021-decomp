package s.a;

import d0.Exceptions;
import d0.Result2;
import d0.Result3;
import d0.z.d.Intrinsics3;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import s.a.a.DispatchedContinuation;
import s.a.a.ThreadContext;
import s.a.e2.Tasks4;
import s.a.e2.Tasks5;

/* JADX INFO: renamed from: s.a.j0, reason: use source file name */
/* JADX INFO: compiled from: DispatchedTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DispatchedTask<T> extends Tasks4 {
    public int l;

    public DispatchedTask(int i) {
        this.l = i;
    }

    public void b(Object obj, Throwable th) {
    }

    public abstract Continuation<T> d();

    public Throwable e(Object obj) {
        if (!(obj instanceof CompletionState2)) {
            obj = null;
        }
        CompletionState2 completionState2 = (CompletionState2) obj;
        if (completionState2 != null) {
            return completionState2.f3846b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T j(Object obj) {
        return obj;
    }

    public final void l(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            Exceptions.addSuppressed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        Intrinsics3.checkNotNull(th);
        b.i.a.f.e.o.f.u0(d().getContext(), new c0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object m();

    @Override // java.lang.Runnable
    public final void run() {
        Object objM97constructorimpl;
        Object objM97constructorimpl2;
        Tasks5 tasks5 = this.k;
        try {
            Continuation<T> continuationD = d();
            if (continuationD == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuationD;
            Continuation<T> continuation = dispatchedContinuation.r;
            CoroutineContext context = continuation.getContext();
            Object objM = m();
            Object objB = ThreadContext.b(context, dispatchedContinuation.p);
            try {
                Throwable thE = e(objM);
                Job job = (thE == null && b.i.a.f.e.o.f.B0(this.l)) ? (Job) context.get(Job.INSTANCE) : null;
                if (job != null && !job.a()) {
                    CancellationException cancellationExceptionQ = job.q();
                    b(objM, cancellationExceptionQ);
                    Result2.a aVar = Result2.j;
                    continuation.resumeWith(Result2.m97constructorimpl(Result3.createFailure(cancellationExceptionQ)));
                } else if (thE != null) {
                    Result2.a aVar2 = Result2.j;
                    continuation.resumeWith(Result2.m97constructorimpl(Result3.createFailure(thE)));
                } else {
                    T tJ = j(objM);
                    Result2.a aVar3 = Result2.j;
                    continuation.resumeWith(Result2.m97constructorimpl(tJ));
                }
                Unit unit = Unit.a;
                ThreadContext.a(context, objB);
                try {
                    Result2.a aVar4 = Result2.j;
                    tasks5.f();
                    objM97constructorimpl2 = Result2.m97constructorimpl(unit);
                } catch (Throwable th) {
                    Result2.a aVar5 = Result2.j;
                    objM97constructorimpl2 = Result2.m97constructorimpl(Result3.createFailure(th));
                }
                l(null, Result2.m99exceptionOrNullimpl(objM97constructorimpl2));
            } catch (Throwable th2) {
                ThreadContext.a(context, objB);
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                Result2.a aVar6 = Result2.j;
                tasks5.f();
                objM97constructorimpl = Result2.m97constructorimpl(Unit.a);
            } catch (Throwable th4) {
                Result2.a aVar7 = Result2.j;
                objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th4));
            }
            l(th3, Result2.m99exceptionOrNullimpl(objM97constructorimpl));
        }
    }
}
