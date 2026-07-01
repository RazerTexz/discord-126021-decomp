package s.a.c2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes3.dex */
@d0.w.i.a.e(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", f = "Channels.kt", l = {25}, m = "invokeSuspend")
public final class h extends d0.w.i.a.k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Object $element;
    public final /* synthetic */ s $this_sendBlocking;
    public Object L$0;
    public int label;
    private CoroutineScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(s sVar, Object obj, Continuation continuation) {
        super(2, continuation);
        this.$this_sendBlocking = sVar;
        this.$element = obj;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        h hVar = new h(this.$this_sendBlocking, this.$element, continuation);
        hVar.p$ = (CoroutineScope) obj;
        return hVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        h hVar = new h(this.$this_sendBlocking, this.$element, continuation);
        hVar.p$ = coroutineScope;
        return hVar.invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            d0.l.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            s sVar = this.$this_sendBlocking;
            Object obj2 = this.$element;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (sVar.o(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d0.l.throwOnFailure(obj);
        }
        return Unit.a;
    }
}
