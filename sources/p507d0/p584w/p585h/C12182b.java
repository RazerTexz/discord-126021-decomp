package p507d0.p584w.p585h;

import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import p507d0.C12113l;
import p507d0.p584w.C12179f;
import p507d0.p584w.p586i.p587a.AbstractC12184a;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.AbstractC12192i;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p592z.p594d.C12224e0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.h.b */
/* JADX INFO: compiled from: IntrinsicsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12182b {

    /* JADX INFO: renamed from: d0.w.h.b$a */
    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class a extends AbstractC12192i {
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

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                C12113l.throwOnFailure(obj);
                return obj;
            }
            this.label = 1;
            C12113l.throwOnFailure(obj);
            Function2 function2 = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(function2, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((Function2) C12224e0.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(this.$receiver$inlined, this);
        }
    }

    /* JADX INFO: renamed from: d0.w.h.b$b */
    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class b extends AbstractC12187d {
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

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                C12113l.throwOnFailure(obj);
                return obj;
            }
            this.label = 1;
            C12113l.throwOnFailure(obj);
            Function2 function2 = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(function2, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((Function2) C12224e0.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(this.$receiver$inlined, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        C12238m.checkNotNullParameter(function2, "$this$createCoroutineUnintercepted");
        C12238m.checkNotNullParameter(continuation, "completion");
        Continuation<?> continuationProbeCoroutineCreated = C12190g.probeCoroutineCreated(continuation);
        if (function2 instanceof AbstractC12184a) {
            return ((AbstractC12184a) function2).create(r, continuationProbeCoroutineCreated);
        }
        CoroutineContext context = continuationProbeCoroutineCreated.getContext();
        return context == C12179f.f25237j ? new a(continuationProbeCoroutineCreated, continuationProbeCoroutineCreated, function2, r) : new b(continuationProbeCoroutineCreated, context, continuationProbeCoroutineCreated, context, function2, r);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> intercepted(Continuation<? super T> continuation) {
        Continuation<T> continuation2;
        C12238m.checkNotNullParameter(continuation, "$this$intercepted");
        AbstractC12187d abstractC12187d = (AbstractC12187d) (!(continuation instanceof AbstractC12187d) ? null : continuation);
        return (abstractC12187d == null || (continuation2 = (Continuation<T>) abstractC12187d.intercepted()) == null) ? continuation : continuation2;
    }
}
