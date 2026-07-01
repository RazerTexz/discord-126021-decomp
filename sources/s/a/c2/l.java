package s.a.c2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(ProducerScope<?> producerScope, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        l$a l_a;
        if (continuation instanceof l$a) {
            l_a = (l$a) continuation;
            int i = l_a.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                l_a.label = i - Integer.MIN_VALUE;
            } else {
                l_a = new l$a(continuation);
            }
        } else {
            l_a = new l$a(continuation);
        }
        Object obj = l_a.result;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i2 = l_a.label;
        try {
            if (i2 == 0) {
                d0.l.throwOnFailure(obj);
                if (!(((Job) l_a.getContext().get(Job.h)) == producerScope)) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
                }
                l_a.L$0 = producerScope;
                l_a.L$1 = function0;
                l_a.label = 1;
                s.a.l lVar = new s.a.l(d0.w.h.b.intercepted(l_a), 1);
                lVar.A();
                producerScope.l(new l$b(lVar));
                Object objU = lVar.u();
                if (objU == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                    d0.w.i.a.g.probeCoroutineSuspended(l_a);
                }
                if (objU == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function0 = (Function0) l_a.L$1;
                d0.l.throwOnFailure(obj);
            }
            function0.invoke();
            return Unit.a;
        } catch (Throwable th) {
            function0.invoke();
            throw th;
        }
    }
}
