package b.i.a.f.e.o;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Await.kt */
/* JADX INFO: loaded from: classes3.dex */
@d0.w.i.a.e(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {26}, m = "awaitAll")
public final class f$e extends d0.w.i.a.d {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public f$e(Continuation continuation) {
        super(continuation);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return f.l(null, this);
    }
}
