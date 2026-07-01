package s.a.c2;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes3.dex */
@d0.w.i.a.e(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {157}, m = "awaitClose")
public final class l$a extends d0.w.i.a.d {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    public l$a(Continuation continuation) {
        super(continuation);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return l.a(null, null, this);
    }
}
