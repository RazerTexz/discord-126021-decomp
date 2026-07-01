package s.a.d2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: s.a.d2.e, reason: use source file name */
/* JADX INFO: compiled from: FlowCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface FlowCollector<T> {
    Object emit(T t, Continuation<? super Unit> continuation);
}
