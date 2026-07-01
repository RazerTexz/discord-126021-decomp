package s.a.d2;

import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.DebugMetadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import s.a.d2.g.SafeCollector3;

/* JADX INFO: renamed from: s.a.d2.a, reason: use source file name */
/* JADX INFO: compiled from: Flow.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Flow2<T> implements Flow3<T> {

    /* JADX INFO: renamed from: s.a.d2.a$a */
    /* JADX INFO: compiled from: Flow.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {212}, m = "collect")
    public static final class a extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Flow2.this.a(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // s.a.d2.Flow3
    public final Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) throws Throwable {
        a aVar;
        Throwable th;
        SafeCollector3 safeCollector3;
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
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            safeCollector3 = (SafeCollector3) aVar.L$2;
            try {
                Result3.throwOnFailure(obj);
                safeCollector3.releaseIntercepted();
                return Unit.a;
            } catch (Throwable th2) {
                th = th2;
                safeCollector3.releaseIntercepted();
                throw th;
            }
        }
        Result3.throwOnFailure(obj);
        SafeCollector3 safeCollector4 = new SafeCollector3(flowCollector, aVar.getContext());
        try {
            aVar.L$0 = this;
            aVar.L$1 = flowCollector;
            aVar.L$2 = safeCollector4;
            aVar.label = 1;
            if (b(safeCollector4, aVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            safeCollector3 = safeCollector4;
            safeCollector3.releaseIntercepted();
            return Unit.a;
        } catch (Throwable th3) {
            th = th3;
            safeCollector3 = safeCollector4;
            safeCollector3.releaseIntercepted();
            throw th;
        }
    }

    public abstract Object b(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);
}
