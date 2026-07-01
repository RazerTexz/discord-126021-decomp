package s.a;

import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.DebugProbes;
import d0.z.d.TypeIntrinsics;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Timeout3;

/* JADX INFO: renamed from: s.a.h, reason: use source file name */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Builders5 {

    /* JADX INFO: renamed from: s.a.h$a */
    /* JADX INFO: compiled from: Timeout.kt */
    @DebugMetadata(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {101}, m = "withTimeoutOrNull")
    public static final class a extends ContinuationImpl3 {
        public long J$0;
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
            return Builders5.b(0L, null, this);
        }
    }

    public static final <U, T extends U> Object a(Timeout4<U, ? super T> timeout4, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws Throwable {
        Object completionState2;
        Object objR;
        timeout4.n(false, true, new o0(timeout4, b.i.a.f.e.o.f.i0(timeout4.m.getContext()).x(timeout4.n, timeout4, timeout4.k)));
        timeout4.f0();
        try {
            if (function2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            completionState2 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(timeout4, timeout4);
            if (completionState2 != Intrinsics2.getCOROUTINE_SUSPENDED() && (objR = timeout4.R(completionState2)) != i1.f3841b) {
                if (!(objR instanceof CompletionState2)) {
                    return i1.a(objR);
                }
                Throwable th = ((CompletionState2) objR).f3846b;
                if (((th instanceof Timeout3) && ((Timeout3) th).coroutine == timeout4) ? false : true) {
                    throw th;
                }
                if (completionState2 instanceof CompletionState2) {
                    throw ((CompletionState2) completionState2).f3846b;
                }
                return completionState2;
            }
            return Intrinsics2.getCOROUTINE_SUSPENDED();
        } catch (Throwable th2) {
            completionState2 = new CompletionState2(th2, false, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, s.a.x1] */
    public static final <T> Object b(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        a aVar;
        Timeout3 e;
        Ref$ObjectRef ref$ObjectRef;
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
            if (j <= 0) {
                return null;
            }
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            try {
                aVar.J$0 = j;
                aVar.L$0 = function2;
                aVar.L$1 = ref$ObjectRef2;
                aVar.label = 1;
                ?? r2 = (T) new Timeout4(j, aVar);
                ref$ObjectRef2.element = r2;
                Object objA = a(r2, function2);
                if (objA == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                    DebugProbes.probeCoroutineSuspended(aVar);
                }
                return objA == coroutine_suspended ? coroutine_suspended : objA;
            } catch (Timeout3 e2) {
                e = e2;
                ref$ObjectRef = ref$ObjectRef2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) aVar.L$1;
            try {
                Result3.throwOnFailure(obj);
                return obj;
            } catch (Timeout3 e3) {
                e = e3;
            }
        }
        if (e.coroutine == ((Timeout4) ref$ObjectRef.element)) {
            return null;
        }
        throw e;
    }
}
