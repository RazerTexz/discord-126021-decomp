package s.a.c2;

import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: s.a.c2.h, reason: use source file name */
/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", f = "Channels.kt", l = {25}, m = "invokeSuspend")
public final class Channels extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Object $element;
    public final /* synthetic */ Channel7 $this_sendBlocking;
    public Object L$0;
    public int label;
    private CoroutineScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Channels(Channel7 channel7, Object obj, Continuation continuation) {
        super(2, continuation);
        this.$this_sendBlocking = channel7;
        this.$element = obj;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Channels channels = new Channels(this.$this_sendBlocking, this.$element, continuation);
        channels.p$ = (CoroutineScope) obj;
        return channels;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Channels channels = new Channels(this.$this_sendBlocking, this.$element, continuation);
        channels.p$ = coroutineScope;
        return channels.invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            Channel7 channel7 = this.$this_sendBlocking;
            Object obj2 = this.$element;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (channel7.o(obj2, this) == coroutine_suspended) {
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
