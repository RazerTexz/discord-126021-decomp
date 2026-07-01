package b.i.a.f.e.o;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes3.dex */
@d0.w.i.a.e(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {50, 61}, m = "emitAllImpl$FlowKt__ChannelsKt")
public final class f$f extends d0.w.i.a.d {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;

    public f$f(Continuation continuation) {
        super(continuation);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return f.U(null, null, false, this);
    }
}
