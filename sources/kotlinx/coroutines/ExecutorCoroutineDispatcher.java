package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {
    static {
        new ExecutorCoroutineDispatcher$a(null);
    }

    public abstract Executor H();
}
