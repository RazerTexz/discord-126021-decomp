package p659s.p660a.p663c2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;

/* JADX INFO: renamed from: s.a.c2.h */
/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC12188e(m10084c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", m10085f = "Channels.kt", m10086l = {25}, m10087m = "invokeSuspend")
public final class C13061h extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Object $element;
    public final /* synthetic */ InterfaceC13072s $this_sendBlocking;
    public Object L$0;
    public int label;

    /* JADX INFO: renamed from: p$ */
    private CoroutineScope f27762p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13061h(InterfaceC13072s interfaceC13072s, Object obj, Continuation continuation) {
        super(2, continuation);
        this.$this_sendBlocking = interfaceC13072s;
        this.$element = obj;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C13061h c13061h = new C13061h(this.$this_sendBlocking, this.$element, continuation);
        c13061h.f27762p$ = (CoroutineScope) obj;
        return c13061h;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        C13061h c13061h = new C13061h(this.$this_sendBlocking, this.$element, continuation);
        c13061h.f27762p$ = coroutineScope;
        return c13061h.invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            C12113l.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.f27762p$;
            InterfaceC13072s interfaceC13072s = this.$this_sendBlocking;
            Object obj2 = this.$element;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (interfaceC13072s.mo11224o(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
        }
        return Unit.f27425a;
    }
}
