package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: kotlinx.coroutines.TimeoutCancellationException, reason: use source file name */
/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Timeout3 extends CancellationException {
    public final Job coroutine;

    public Timeout3(String str, Job job) {
        super(str);
        this.coroutine = job;
    }
}
