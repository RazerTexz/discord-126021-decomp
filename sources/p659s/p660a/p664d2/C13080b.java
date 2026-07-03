package p659s.p660a.p664d2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import p507d0.C12113l;
import p507d0.p584w.C12179f;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p659s.p660a.p663c2.EnumC13058e;

/* JADX INFO: renamed from: s.a.d2.b */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13080b<T> extends C13081c<T> {

    /* JADX INFO: renamed from: e */
    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> f27781e;

    /* JADX INFO: renamed from: s.a.d2.b$a */
    /* JADX INFO: compiled from: Builders.kt */
    @InterfaceC12188e(m10084c = "kotlinx.coroutines.flow.CallbackFlowBuilder", m10085f = "Builders.kt", m10086l = {358}, m10087m = "collectTo")
    public static final class a extends AbstractC12187d {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return C13080b.this.mo11248b(null, this);
        }
    }

    public C13080b(Function2 function2, CoroutineContext coroutineContext, int i, EnumC13058e enumC13058e, int i2) {
        super(function2, (i2 & 2) != 0 ? C12179f.f25237j : null, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? EnumC13058e.SUSPEND : null);
        this.f27781e = function2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // p659s.p660a.p664d2.p665g.AbstractC13085a
    /* JADX INFO: renamed from: b */
    public Object mo11248b(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        a aVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.label = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = aVar.label;
        if (i2 == 0) {
            C12113l.throwOnFailure(obj);
            aVar.L$0 = this;
            aVar.L$1 = producerScope;
            aVar.label = 1;
            Object objInvoke = this.f27782d.invoke(producerScope, aVar);
            if (objInvoke != C12183c.getCOROUTINE_SUSPENDED()) {
                objInvoke = Unit.f27425a;
            }
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            producerScope = (ProducerScope) aVar.L$1;
            C12113l.throwOnFailure(obj);
        }
        if (producerScope.mo11225p()) {
            return Unit.f27425a;
        }
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }
}
