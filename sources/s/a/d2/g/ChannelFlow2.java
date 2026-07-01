package s.a.d2.g;

import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Produce;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: s.a.d2.g.b, reason: use source file name */
/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
public final class ChannelFlow2<T> extends ContinuationImpl6 implements Function2<Produce<? super T>, Continuation<? super Unit>, Object> {
    public Object L$0;
    public int label;
    private Produce p$0;
    public final /* synthetic */ ChannelFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlow2(ChannelFlow channelFlow, Continuation continuation) {
        super(2, continuation);
        this.this$0 = channelFlow;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelFlow2 channelFlow2 = new ChannelFlow2(this.this$0, continuation);
        channelFlow2.p$0 = (Produce) obj;
        return channelFlow2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        ChannelFlow2 channelFlow2 = new ChannelFlow2(this.this$0, continuation);
        channelFlow2.p$0 = (Produce) obj;
        return channelFlow2.invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            Produce<? super T> produce = this.p$0;
            ChannelFlow channelFlow = this.this$0;
            this.L$0 = produce;
            this.label = 1;
            if (channelFlow.b(produce, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
        }
        return Unit.a;
    }
}
