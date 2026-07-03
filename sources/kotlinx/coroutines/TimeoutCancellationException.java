package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TimeoutCancellationException extends CancellationException {
    public final Job coroutine;

    public TimeoutCancellationException(String str, Job job) {
        super(str);
        this.coroutine = job;
    }
}
