package s.a;

import d0.Result2;
import d0.Result3;
import d0.w.Continuation2;
import d0.w.h.Intrinsics2;
import d0.w.i.a.DebugProbes;
import d0.z.d.TypeIntrinsics;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import s.a.a.ThreadContext;

/* JADX INFO: renamed from: s.a.b, reason: use source file name */
/* JADX INFO: compiled from: AbstractCoroutine.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractCoroutine<T> extends h1 implements Job, Continuation<T>, CoroutineScope {
    public final CoroutineContext k;
    public final CoroutineContext l;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z2) {
        super(z2);
        this.l = coroutineContext;
        this.k = coroutineContext.plus(this);
    }

    @Override // s.a.h1
    public String B() {
        return getClass().getSimpleName() + " was cancelled";
    }

    @Override // s.a.h1
    public final void O(Throwable th) {
        b.i.a.f.e.o.f.u0(this.k, th);
    }

    @Override // s.a.h1
    public String T() {
        boolean z2 = CoroutineContext2.a;
        return super.T();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    @Override // s.a.h1
    public final void W(Object obj) {
        if (!(obj instanceof CompletionState2)) {
            h0(obj);
        } else {
            CompletionState2 completionState2 = (CompletionState2) obj;
            g0(completionState2.f3846b, completionState2._handled);
        }
    }

    @Override // s.a.h1
    public final void X() {
        i0();
    }

    @Override // s.a.h1, kotlinx.coroutines.Job
    public boolean a() {
        return super.a();
    }

    public void e0(Object obj) {
        v(obj);
    }

    public final void f0() {
        P((Job) this.l.get(Job.INSTANCE));
    }

    public void g0(Throwable th, boolean z2) {
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.k;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.k;
    }

    public void h0(T t) {
    }

    public void i0() {
    }

    public final <R> void j0(CoroutineStart coroutineStart, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        f0();
        int iOrdinal = coroutineStart.ordinal();
        if (iOrdinal == 0) {
            b.i.a.f.e.o.f.f1(function2, r, this, null, 4);
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                Continuation2.startCoroutine(function2, r, this);
                return;
            }
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Continuation continuationProbeCoroutineCreated = DebugProbes.probeCoroutineCreated(this);
            try {
                CoroutineContext coroutineContext = this.k;
                Object objB = ThreadContext.b(coroutineContext, null);
                try {
                    if (function2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    }
                    Object objInvoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, continuationProbeCoroutineCreated);
                    ThreadContext.a(coroutineContext, objB);
                    if (objInvoke != Intrinsics2.getCOROUTINE_SUSPENDED()) {
                        Result2.a aVar = Result2.j;
                        continuationProbeCoroutineCreated.resumeWith(Result2.m97constructorimpl(objInvoke));
                    }
                } catch (Throwable th) {
                    ThreadContext.a(coroutineContext, objB);
                    throw th;
                }
            } catch (Throwable th2) {
                Result2.a aVar2 = Result2.j;
                continuationProbeCoroutineCreated.resumeWith(Result2.m97constructorimpl(Result3.createFailure(th2)));
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object objR = R(b.i.a.f.e.o.f.v1(obj, null));
        if (objR == i1.f3841b) {
            return;
        }
        e0(objR);
    }
}
