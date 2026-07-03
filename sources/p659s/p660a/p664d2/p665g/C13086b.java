package p659s.p660a.p664d2.p665g;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: s.a.d2.g.b */
/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC12188e(m10084c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", m10085f = "ChannelFlow.kt", m10086l = {60}, m10087m = "invokeSuspend")
public final class C13086b<T> extends AbstractC12194k implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    public Object L$0;
    public int label;
    private ProducerScope p$0;
    public final /* synthetic */ AbstractC13085a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13086b(AbstractC13085a abstractC13085a, Continuation continuation) {
        super(2, continuation);
        this.this$0 = abstractC13085a;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C13086b c13086b = new C13086b(this.this$0, continuation);
        c13086b.p$0 = (ProducerScope) obj;
        return c13086b;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        C13086b c13086b = new C13086b(this.this$0, continuation);
        c13086b.p$0 = (ProducerScope) obj;
        return c13086b.invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            C12113l.throwOnFailure(obj);
            ProducerScope<? super T> producerScope = this.p$0;
            AbstractC13085a abstractC13085a = this.this$0;
            this.L$0 = producerScope;
            this.label = 1;
            if (abstractC13085a.mo11248b(producerScope, this) == coroutine_suspended) {
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
