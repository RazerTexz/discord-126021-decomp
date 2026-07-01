package s.a;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes3.dex */
@d0.w.i.a.e(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {101}, m = "withTimeoutOrNull")
public final class h$a extends d0.w.i.a.d {
    public long J$0;
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    public h$a(Continuation continuation) {
        super(continuation);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return h.b(0L, null, this);
    }
}
