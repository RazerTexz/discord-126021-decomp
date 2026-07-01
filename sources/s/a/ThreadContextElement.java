package s.a;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: renamed from: s.a.v1, reason: use source file name */
/* JADX INFO: compiled from: ThreadContextElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ThreadContextElement<S> extends CoroutineContext.Element {
    S C(CoroutineContext coroutineContext);

    void y(CoroutineContext coroutineContext, S s2);
}
