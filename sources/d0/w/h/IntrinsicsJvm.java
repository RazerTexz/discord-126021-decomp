package d0.w.h;

import d0.Result3;
import d0.w.CoroutineContextImpl4;
import d0.w.i.a.ContinuationImpl;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.ContinuationImpl4;
import d0.w.i.a.DebugProbes;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: d0.w.h.b, reason: use source file name */
/* JADX INFO: compiled from: IntrinsicsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public class IntrinsicsJvm {

    /* JADX INFO: renamed from: d0.w.h.b$a */
    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class a extends ContinuationImpl4 {
        public final /* synthetic */ Continuation $completion;
        public final /* synthetic */ Object $receiver$inlined;
        public final /* synthetic */ Function2 $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Continuation continuation, Continuation continuation2, Function2 function2, Object obj) {
            super(continuation2);
            this.$completion = continuation;
            this.$this_createCoroutineUnintercepted$inlined = function2;
            this.$receiver$inlined = obj;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                Result3.throwOnFailure(obj);
                return obj;
            }
            this.label = 1;
            Result3.throwOnFailure(obj);
            Function2 function2 = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(function2, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(this.$receiver$inlined, this);
        }
    }

    /* JADX INFO: renamed from: d0.w.h.b$b */
    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class b extends ContinuationImpl3 {
        public final /* synthetic */ Continuation $completion;
        public final /* synthetic */ CoroutineContext $context;
        public final /* synthetic */ Object $receiver$inlined;
        public final /* synthetic */ Function2 $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Continuation continuation, CoroutineContext coroutineContext, Continuation continuation2, CoroutineContext coroutineContext2, Function2 function2, Object obj) {
            super(continuation2, coroutineContext2);
            this.$completion = continuation;
            this.$context = coroutineContext;
            this.$this_createCoroutineUnintercepted$inlined = function2;
            this.$receiver$inlined = obj;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                Result3.throwOnFailure(obj);
                return obj;
            }
            this.label = 1;
            Result3.throwOnFailure(obj);
            Function2 function2 = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(function2, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(this.$receiver$inlined, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics3.checkNotNullParameter(function2, "$this$createCoroutineUnintercepted");
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        Continuation<?> continuationProbeCoroutineCreated = DebugProbes.probeCoroutineCreated(continuation);
        if (function2 instanceof ContinuationImpl) {
            return ((ContinuationImpl) function2).create(r, continuationProbeCoroutineCreated);
        }
        CoroutineContext context = continuationProbeCoroutineCreated.getContext();
        return context == CoroutineContextImpl4.j ? new a(continuationProbeCoroutineCreated, continuationProbeCoroutineCreated, function2, r) : new b(continuationProbeCoroutineCreated, context, continuationProbeCoroutineCreated, context, function2, r);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> intercepted(Continuation<? super T> continuation) {
        Continuation<T> continuation2;
        Intrinsics3.checkNotNullParameter(continuation, "$this$intercepted");
        ContinuationImpl3 continuationImpl3 = (ContinuationImpl3) (!(continuation instanceof ContinuationImpl3) ? null : continuation);
        return (continuationImpl3 == null || (continuation2 = (Continuation<T>) continuationImpl3.intercepted()) == null) ? continuation : continuation2;
    }
}
