package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import s.a.d2.FlowCollector;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.AbortFlowException, reason: use source file name */
/* JADX INFO: compiled from: FlowExceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FlowExceptions extends CancellationException {
    private final FlowCollector<?> owner;

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
