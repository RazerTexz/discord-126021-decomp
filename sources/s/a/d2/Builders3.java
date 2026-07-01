package s.a.d2;

import d0.w.h.Intrinsics2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: s.a.d2.f, reason: use source file name */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Builders3<T> extends Flow2<T> {
    public final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> a;

    /* JADX WARN: Multi-variable type inference failed */
    public Builders3(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.a = function2;
    }

    @Override // s.a.d2.Flow2
    public Object b(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object objInvoke = this.a.invoke(flowCollector, continuation);
        return objInvoke == Intrinsics2.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.a;
    }
}
