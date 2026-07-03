package p659s.p660a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p584w.p585h.C12182b;
import p659s.p660a.p661a.C13025h;
import p659s.p660a.p661a.C13035r;

/* JADX INFO: renamed from: s.a.i0 */
/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13118i0<T> extends C13035r<T> {

    /* JADX INFO: renamed from: n */
    public static final AtomicIntegerFieldUpdater f27856n = AtomicIntegerFieldUpdater.newUpdater(C13118i0.class, "_decision");
    public volatile int _decision;

    public C13118i0(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
        this._decision = 0;
    }

    @Override // p659s.p660a.p661a.C13035r, p659s.p660a.AbstractC13045b
    /* JADX INFO: renamed from: e0 */
    public void mo11172e0(Object obj) {
        boolean z2;
        while (true) {
            int i = this._decision;
            z2 = false;
            if (i != 0) {
                if (i == 1) {
                    break;
                } else {
                    throw new IllegalStateException("Already resumed".toString());
                }
            } else if (f27856n.compareAndSet(this, 0, 2)) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return;
        }
        C13025h.m11149b(C12182b.intercepted(this.f27702m), C3404f.m4259X0(obj, this.f27702m), null, 2);
    }

    @Override // p659s.p660a.p661a.C13035r, p659s.p660a.C13116h1
    /* JADX INFO: renamed from: v */
    public void mo11173v(Object obj) {
        mo11172e0(obj);
    }
}
