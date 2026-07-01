package s.a.d2.g;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Continuation<Object> {
    public static final d j = new d();

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return d0.w.f.j;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
    }
}
