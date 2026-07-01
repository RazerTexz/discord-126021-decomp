package s.a.a;

import d0.Result2;
import d0.Result3;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import s.a.CompletionState3;
import s.a.q0;
import s.a.w1;

/* JADX INFO: renamed from: s.a.a.h, reason: use source file name */
/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DispatchedContinuation2 {
    public static final Symbol3 a = new Symbol3("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Symbol3 f3827b = new Symbol3("REUSABLE_CLAIMED");

    public static final <T> void a(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, Unit> function1) {
        boolean z2;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation.resumeWith(obj);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Object objV1 = b.i.a.f.e.o.f.v1(obj, function1);
        if (dispatchedContinuation.q.isDispatchNeeded(dispatchedContinuation.getContext())) {
            dispatchedContinuation.n = objV1;
            dispatchedContinuation.l = 1;
            dispatchedContinuation.q.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
            return;
        }
        w1 w1Var = w1.f3847b;
        q0 q0VarA = w1.a();
        if (q0VarA.N()) {
            dispatchedContinuation.n = objV1;
            dispatchedContinuation.l = 1;
            q0VarA.J(dispatchedContinuation);
            return;
        }
        q0VarA.L(true);
        try {
            Job job = (Job) dispatchedContinuation.getContext().get(Job.INSTANCE);
            if (job == null || job.a()) {
                z2 = false;
            } else {
                CancellationException cancellationExceptionQ = job.q();
                if (objV1 instanceof CompletionState3) {
                    ((CompletionState3) objV1).f3848b.invoke(cancellationExceptionQ);
                }
                Result2.a aVar = Result2.j;
                dispatchedContinuation.resumeWith(Result2.m97constructorimpl(Result3.createFailure(cancellationExceptionQ)));
                z2 = true;
            }
            if (!z2) {
                CoroutineContext context = dispatchedContinuation.getContext();
                Object objB = ThreadContext.b(context, dispatchedContinuation.p);
                try {
                    dispatchedContinuation.r.resumeWith(obj);
                    ThreadContext.a(context, objB);
                } catch (Throwable th) {
                    ThreadContext.a(context, objB);
                    throw th;
                }
            }
            while (q0VarA.R()) {
            }
        } catch (Throwable th2) {
            try {
                dispatchedContinuation.l(th2, null);
            } finally {
                q0VarA.H(true);
            }
        }
    }

    public static /* synthetic */ void b(Continuation continuation, Object obj, Function1 function1, int i) {
        int i2 = i & 2;
        a(continuation, obj, null);
    }
}
