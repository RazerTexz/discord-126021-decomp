package s.a;

import d0.k$a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import s.a.a.a;

/* JADX INFO: compiled from: AbstractCoroutine.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> extends h1 implements Job, Continuation<T>, CoroutineScope {
    public final CoroutineContext k;
    public final CoroutineContext l;

    public b(CoroutineContext coroutineContext, boolean z2) {
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
        boolean z2 = z.a;
        return super.T();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    @Override // s.a.h1
    public final void W(Object obj) {
        if (!(obj instanceof w)) {
            h0(obj);
        } else {
            w wVar = (w) obj;
            g0(wVar.f3846b, wVar._handled);
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
        P((Job) this.l.get(Job.h));
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
                d0.w.e.startCoroutine(function2, r, this);
                return;
            }
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Continuation continuationProbeCoroutineCreated = d0.w.i.a.g.probeCoroutineCreated(this);
            try {
                CoroutineContext coroutineContext = this.k;
                Object objB = a.b(coroutineContext, null);
                try {
                    if (function2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    }
                    Object objInvoke = ((Function2) d0.z.d.e0.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, continuationProbeCoroutineCreated);
                    a.a(coroutineContext, objB);
                    if (objInvoke != d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                        k$a k_a = d0.k.j;
                        continuationProbeCoroutineCreated.resumeWith(d0.k.m97constructorimpl(objInvoke));
                    }
                } catch (Throwable th) {
                    a.a(coroutineContext, objB);
                    throw th;
                }
            } catch (Throwable th2) {
                k$a k_a2 = d0.k.j;
                continuationProbeCoroutineCreated.resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(th2)));
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
