package p007b.p109f.p115d.p117b;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: b.f.d.b.c */
/* JADX INFO: compiled from: DefaultSerialExecutorService.java */
/* JADX INFO: loaded from: classes.dex */
public class C1672c extends C1671b implements InterfaceExecutorServiceC1675f {
    public C1672c(Executor executor) {
        super("SerialExecutor", 1, executor, new LinkedBlockingQueue());
    }

    @Override // p007b.p109f.p115d.p117b.C1671b, java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
