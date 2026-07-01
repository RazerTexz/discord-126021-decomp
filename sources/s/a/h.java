package s.a;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h {
    public static final <U, T extends U> Object a(x1<U, ? super T> x1Var, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws Throwable {
        Object wVar;
        Object objR;
        x1Var.n(false, true, new o0(x1Var, b.i.a.f.e.o.f.i0(x1Var.m.getContext()).x(x1Var.n, x1Var, x1Var.k)));
        x1Var.f0();
        try {
            if (function2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            wVar = ((Function2) d0.z.d.e0.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(x1Var, x1Var);
            if (wVar != d0.w.h.c.getCOROUTINE_SUSPENDED() && (objR = x1Var.R(wVar)) != i1.f3841b) {
                if (!(objR instanceof w)) {
                    return i1.a(objR);
                }
                Throwable th = ((w) objR).f3846b;
                if (((th instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th).coroutine == x1Var) ? false : true) {
                    throw th;
                }
                if (wVar instanceof w) {
                    throw ((w) wVar).f3846b;
                }
                return wVar;
            }
            return d0.w.h.c.getCOROUTINE_SUSPENDED();
        } catch (Throwable th2) {
            wVar = new w(th2, false, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, s.a.x1] */
    public static final <T> Object b(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        h$a h_a;
        TimeoutCancellationException e;
        Ref$ObjectRef ref$ObjectRef;
        if (continuation instanceof h$a) {
            h_a = (h$a) continuation;
            int i = h_a.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                h_a.label = i - Integer.MIN_VALUE;
            } else {
                h_a = new h$a(continuation);
            }
        } else {
            h_a = new h$a(continuation);
        }
        Object obj = h_a.result;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i2 = h_a.label;
        if (i2 == 0) {
            d0.l.throwOnFailure(obj);
            if (j <= 0) {
                return null;
            }
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            try {
                h_a.J$0 = j;
                h_a.L$0 = function2;
                h_a.L$1 = ref$ObjectRef2;
                h_a.label = 1;
                ?? r2 = (T) new x1(j, h_a);
                ref$ObjectRef2.element = r2;
                Object objA = a(r2, function2);
                if (objA == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                    d0.w.i.a.g.probeCoroutineSuspended(h_a);
                }
                return objA == coroutine_suspended ? coroutine_suspended : objA;
            } catch (TimeoutCancellationException e2) {
                e = e2;
                ref$ObjectRef = ref$ObjectRef2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) h_a.L$1;
            try {
                d0.l.throwOnFailure(obj);
                return obj;
            } catch (TimeoutCancellationException e3) {
                e = e3;
            }
        }
        if (e.coroutine == ((x1) ref$ObjectRef.element)) {
            return null;
        }
        throw e;
    }
}
