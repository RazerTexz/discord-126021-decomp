package s.a.d2;

import d0.l;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Flow.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> implements d<T> {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // s.a.d2.d
    public final Object a(e<? super T> eVar, Continuation<? super Unit> continuation) throws Throwable {
        a$a a_a;
        Throwable th;
        s.a.d2.g.e eVar2;
        if (continuation instanceof a$a) {
            a_a = (a$a) continuation;
            int i = a_a.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                a_a.label = i - Integer.MIN_VALUE;
            } else {
                a_a = new a$a(this, continuation);
            }
        } else {
            a_a = new a$a(this, continuation);
        }
        Object obj = a_a.result;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i2 = a_a.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar2 = (s.a.d2.g.e) a_a.L$2;
            try {
                l.throwOnFailure(obj);
                eVar2.releaseIntercepted();
                return Unit.a;
            } catch (Throwable th2) {
                th = th2;
                eVar2.releaseIntercepted();
                throw th;
            }
        }
        l.throwOnFailure(obj);
        s.a.d2.g.e eVar3 = new s.a.d2.g.e(eVar, a_a.getContext());
        try {
            a_a.L$0 = this;
            a_a.L$1 = eVar;
            a_a.L$2 = eVar3;
            a_a.label = 1;
            if (b(eVar3, a_a) == coroutine_suspended) {
                return coroutine_suspended;
            }
            eVar2 = eVar3;
            eVar2.releaseIntercepted();
            return Unit.a;
        } catch (Throwable th3) {
            th = th3;
            eVar2 = eVar3;
            eVar2.releaseIntercepted();
            throw th;
        }
    }

    public abstract Object b(e<? super T> eVar, Continuation<? super Unit> continuation);
}
