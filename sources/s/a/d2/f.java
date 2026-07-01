package s.a.d2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f<T> extends a<T> {
    public final Function2<e<? super T>, Continuation<? super Unit>, Object> a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function2<? super e<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.a = function2;
    }

    @Override // s.a.d2.a
    public Object b(e<? super T> eVar, Continuation<? super Unit> continuation) {
        Object objInvoke = this.a.invoke(eVar, continuation);
        return objInvoke == d0.w.h.c.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.a;
    }
}
