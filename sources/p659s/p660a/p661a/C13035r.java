package p659s.p660a.p661a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p584w.p585h.C12182b;
import p659s.p660a.AbstractC13045b;

/* JADX INFO: renamed from: s.a.a.r */
/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13035r<T> extends AbstractC13045b<T> implements CoroutineStackFrame {

    /* JADX INFO: renamed from: m */
    public final Continuation<T> f27702m;

    /* JADX WARN: Multi-variable type inference failed */
    public C13035r(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, true);
        this.f27702m = continuation;
    }

    @Override // p659s.p660a.C13116h1
    /* JADX INFO: renamed from: Q */
    public final boolean mo11171Q() {
        return true;
    }

    @Override // p659s.p660a.AbstractC13045b
    /* JADX INFO: renamed from: e0 */
    public void mo11172e0(Object obj) {
        Continuation<T> continuation = this.f27702m;
        continuation.resumeWith(C3404f.m4259X0(obj, continuation));
    }

    @Override // p659s.p660a.C13116h1
    /* JADX INFO: renamed from: v */
    public void mo11173v(Object obj) {
        C13025h.m11149b(C12182b.intercepted(this.f27702m), C3404f.m4259X0(obj, this.f27702m), null, 2);
    }
}
