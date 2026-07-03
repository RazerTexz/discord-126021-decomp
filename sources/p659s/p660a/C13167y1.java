package p659s.p660a;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: renamed from: s.a.y1 */
/* JADX INFO: compiled from: Unconfined.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13167y1 extends CoroutineDispatcher {

    /* JADX INFO: renamed from: j */
    public static final C13167y1 f27922j = new C13167y1();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (((C13044a2) coroutineContext.get(C13044a2.f27713j)) == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
