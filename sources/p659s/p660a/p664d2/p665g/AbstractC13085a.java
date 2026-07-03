package p659s.p660a.p664d2.p665g;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.ProducerScope;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p580t.C12163u;
import p507d0.p584w.C12179f;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p659s.p660a.C13168z;
import p659s.p660a.p663c2.C13066m;
import p659s.p660a.p663c2.EnumC13058e;
import p659s.p660a.p664d2.InterfaceC13082d;
import p659s.p660a.p664d2.InterfaceC13083e;

/* JADX INFO: renamed from: s.a.d2.g.a */
/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC13085a<T> implements InterfaceC13082d {

    /* JADX INFO: renamed from: a */
    public final CoroutineContext f27784a;

    /* JADX INFO: renamed from: b */
    public final int f27785b;

    /* JADX INFO: renamed from: c */
    public final EnumC13058e f27786c;

    /* JADX INFO: renamed from: s.a.d2.g.a$a */
    /* JADX INFO: compiled from: ChannelFlow.kt */
    @InterfaceC12188e(m10084c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", m10085f = "ChannelFlow.kt", m10086l = {Opcodes.I2D}, m10087m = "invokeSuspend")
    public static final class a extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ InterfaceC13083e $collector;
        public Object L$0;
        public int label;

        /* JADX INFO: renamed from: p$ */
        private CoroutineScope f27787p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC13083e interfaceC13083e, Continuation continuation) {
            super(2, continuation);
            this.$collector = interfaceC13083e;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.$collector, continuation);
            aVar.f27787p$ = (CoroutineScope) obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            a aVar = new a(this.$collector, continuation);
            aVar.f27787p$ = coroutineScope;
            return aVar.invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.f27787p$;
                InterfaceC13083e interfaceC13083e = this.$collector;
                AbstractC13085a abstractC13085a = AbstractC13085a.this;
                CoroutineContext coroutineContext = abstractC13085a.f27784a;
                int i2 = abstractC13085a.f27785b;
                if (i2 == -3) {
                    i2 = -2;
                }
                EnumC13058e enumC13058e = abstractC13085a.f27786c;
                CoroutineStart coroutineStart = CoroutineStart.ATOMIC;
                C13086b c13086b = new C13086b(abstractC13085a, null);
                C13066m c13066m = new C13066m(C13168z.m11354a(coroutineScope, coroutineContext), C3404f.m4271b(i2, enumC13058e, null, 4));
                c13066m.m11191j0(coroutineStart, c13066m, c13086b);
                this.L$0 = coroutineScope;
                this.label = 1;
                Object objM4249U = C3404f.m4249U(interfaceC13083e, c13066m, true, this);
                if (objM4249U != C12183c.getCOROUTINE_SUSPENDED()) {
                    objM4249U = Unit.f27425a;
                }
                if (objM4249U == coroutine_suspended) {
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

    public AbstractC13085a(CoroutineContext coroutineContext, int i, EnumC13058e enumC13058e) {
        this.f27784a = coroutineContext;
        this.f27785b = i;
        this.f27786c = enumC13058e;
    }

    @Override // p659s.p660a.p664d2.InterfaceC13082d
    /* JADX INFO: renamed from: a */
    public Object mo11246a(InterfaceC13083e<? super T> interfaceC13083e, Continuation<? super Unit> continuation) throws Throwable {
        Object objM4225M = C3404f.m4225M(new a(interfaceC13083e, null), continuation);
        return objM4225M == C12183c.getCOROUTINE_SUSPENDED() ? objM4225M : Unit.f27425a;
    }

    /* JADX INFO: renamed from: b */
    public abstract Object mo11248b(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation);

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        if (this.f27784a != C12179f.f25237j) {
            StringBuilder sbM833U = C1643a.m833U("context=");
            sbM833U.append(this.f27784a);
            arrayList.add(sbM833U.toString());
        }
        if (this.f27785b != -3) {
            StringBuilder sbM833U2 = C1643a.m833U("capacity=");
            sbM833U2.append(this.f27785b);
            arrayList.add(sbM833U2.toString());
        }
        if (this.f27786c != EnumC13058e.SUSPEND) {
            StringBuilder sbM833U3 = C1643a.m833U("onBufferOverflow=");
            sbM833U3.append(this.f27786c);
            arrayList.add(sbM833U3.toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return C1643a.m820H(sb, C12163u.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null), ']');
    }
}
