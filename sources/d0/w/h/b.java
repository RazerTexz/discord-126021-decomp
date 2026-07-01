package d0.w.h;

import d0.w.f;
import d0.w.i.a.d;
import d0.w.i.a.g;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: IntrinsicsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        m.checkNotNullParameter(function2, "$this$createCoroutineUnintercepted");
        m.checkNotNullParameter(continuation, "completion");
        Continuation<?> continuationProbeCoroutineCreated = g.probeCoroutineCreated(continuation);
        if (function2 instanceof d0.w.i.a.a) {
            return ((d0.w.i.a.a) function2).create(r, continuationProbeCoroutineCreated);
        }
        CoroutineContext context = continuationProbeCoroutineCreated.getContext();
        return context == f.j ? new b$a(continuationProbeCoroutineCreated, continuationProbeCoroutineCreated, function2, r) : new b$b(continuationProbeCoroutineCreated, context, continuationProbeCoroutineCreated, context, function2, r);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> intercepted(Continuation<? super T> continuation) {
        Continuation<T> continuation2;
        m.checkNotNullParameter(continuation, "$this$intercepted");
        d dVar = (d) (!(continuation instanceof d) ? null : continuation);
        return (dVar == null || (continuation2 = (Continuation<T>) dVar.intercepted()) == null) ? continuation : continuation2;
    }
}
