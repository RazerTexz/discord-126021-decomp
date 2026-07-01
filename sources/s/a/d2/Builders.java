package s.a.d2;

import d0.Result3;
import d0.w.CoroutineContextImpl4;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.DebugMetadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Produce;
import s.a.c2.BufferOverflow;

/* JADX INFO: renamed from: s.a.d2.b, reason: use source file name */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Builders<T> extends Builders2<T> {
    public final Function2<Produce<? super T>, Continuation<? super Unit>, Object> e;

    /* JADX INFO: renamed from: s.a.d2.b$a */
    /* JADX INFO: compiled from: Builders.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {358}, m = "collectTo")
    public static final class a extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Builders.this.b(null, this);
        }
    }

    public Builders(Function2 function2, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2) {
        super(function2, (i2 & 2) != 0 ? CoroutineContextImpl4.j : null, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : null);
        this.e = function2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // s.a.d2.g.ChannelFlow
    public Object b(Produce<? super T> produce, Continuation<? super Unit> continuation) {
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
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = aVar.label;
        if (i2 == 0) {
            Result3.throwOnFailure(obj);
            aVar.L$0 = this;
            aVar.L$1 = produce;
            aVar.label = 1;
            Object objInvoke = this.d.invoke(produce, aVar);
            if (objInvoke != Intrinsics2.getCOROUTINE_SUSPENDED()) {
                objInvoke = Unit.a;
            }
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            produce = (Produce) aVar.L$1;
            Result3.throwOnFailure(obj);
        }
        if (produce.p()) {
            return Unit.a;
        }
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }
}
