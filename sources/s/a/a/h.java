package s.a.a;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import s.a.q0;
import s.a.w1;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final t a = new t("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f3827b = new t("REUSABLE_CLAIMED");

    public static final <T> void a(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, Unit> function1) {
        boolean z2;
        if (!(continuation instanceof g)) {
            continuation.resumeWith(obj);
            return;
        }
        g gVar = (g) continuation;
        Object objV1 = b.i.a.f.e.o.f.v1(obj, function1);
        if (gVar.q.isDispatchNeeded(gVar.getContext())) {
            gVar.n = objV1;
            gVar.l = 1;
            gVar.q.dispatch(gVar.getContext(), gVar);
            return;
        }
        w1 w1Var = w1.f3847b;
        q0 q0VarA = w1.a();
        if (q0VarA.N()) {
            gVar.n = objV1;
            gVar.l = 1;
            q0VarA.J(gVar);
            return;
        }
        q0VarA.L(true);
        try {
            Job job = (Job) gVar.getContext().get(Job.h);
            if (job == null || job.a()) {
                z2 = false;
            } else {
                CancellationException cancellationExceptionQ = job.q();
                if (objV1 instanceof s.a.x) {
                    ((s.a.x) objV1).f3848b.invoke(cancellationExceptionQ);
                }
                d0.k$a k_a = d0.k.j;
                gVar.resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(cancellationExceptionQ)));
                z2 = true;
            }
            if (!z2) {
                CoroutineContext context = gVar.getContext();
                Object objB = a.b(context, gVar.p);
                try {
                    gVar.r.resumeWith(obj);
                    a.a(context, objB);
                } catch (Throwable th) {
                    a.a(context, objB);
                    throw th;
                }
            }
            while (q0VarA.R()) {
            }
        } catch (Throwable th2) {
            try {
                gVar.l(th2, null);
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
