package b.f.d.b;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: b.f.d.b.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultSerialExecutorService.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultSerialExecutorService extends ConstrainedExecutorService implements SerialExecutorService {
    public DefaultSerialExecutorService(Executor executor) {
        super("SerialExecutor", 1, executor, new LinkedBlockingQueue());
    }

    @Override // b.f.d.b.ConstrainedExecutorService, java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
