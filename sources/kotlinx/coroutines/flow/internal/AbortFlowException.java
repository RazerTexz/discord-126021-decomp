package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import p659s.p660a.p664d2.InterfaceC13083e;

/* JADX INFO: compiled from: FlowExceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AbortFlowException extends CancellationException {
    private final InterfaceC13083e<?> owner;

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
