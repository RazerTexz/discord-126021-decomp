package s.a.d2;

import d0.l;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T> extends c<T> {
    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> e;

    public b(Function2 function2, CoroutineContext coroutineContext, int i, s.a.c2.e eVar, int i2) {
        super(function2, (i2 & 2) != 0 ? d0.w.f.j : null, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? s.a.c2.e.SUSPEND : null);
        this.e = function2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // s.a.d2.g.a
    public Object b(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        b$a b_a;
        if (continuation instanceof b$a) {
            b_a = (b$a) continuation;
            int i = b_a.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                b_a.label = i - Integer.MIN_VALUE;
            } else {
                b_a = new b$a(this, continuation);
            }
        } else {
            b_a = new b$a(this, continuation);
        }
        Object obj = b_a.result;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i2 = b_a.label;
        if (i2 == 0) {
            l.throwOnFailure(obj);
            b_a.L$0 = this;
            b_a.L$1 = producerScope;
            b_a.label = 1;
            Object objInvoke = this.d.invoke(producerScope, b_a);
            if (objInvoke != d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                objInvoke = Unit.a;
            }
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            producerScope = (ProducerScope) b_a.L$1;
            l.throwOnFailure(obj);
        }
        if (producerScope.p()) {
            return Unit.a;
        }
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }
}
