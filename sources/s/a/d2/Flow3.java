package s.a.d2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: s.a.d2.d, reason: use source file name */
/* JADX INFO: compiled from: Flow.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Flow3<T> {
    Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);
}
