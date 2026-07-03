package p507d0.p584w.p586i.p587a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: renamed from: d0.w.i.a.c */
/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12186c implements Continuation<Object> {

    /* JADX INFO: renamed from: j */
    public static final C12186c f25244j = new C12186c();

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
