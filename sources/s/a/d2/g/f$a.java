package s.a.d2.g;

import d0.z.d.k;
import d0.z.d.l;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f$a extends k implements Function3<s.a.d2.e<? super Object>, Object, Continuation<? super Unit>, Object> {
    public f$a() {
        super(3, s.a.d2.e.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(s.a.d2.e<? super Object> eVar, Object obj, Continuation<? super Unit> continuation) {
        l.mark(0);
        Object objEmit = eVar.emit(obj, continuation);
        l.mark(2);
        l.mark(1);
        return objEmit;
    }
}
