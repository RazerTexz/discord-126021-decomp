package b.i.a.f.e.o;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@d0.w.i.a.e(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {113}, m = "suspendAndThrow")
public final class f$h extends d0.w.i.a.d {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public f$h(Continuation continuation) {
        super(continuation);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return f.i1(null, this);
    }
}
