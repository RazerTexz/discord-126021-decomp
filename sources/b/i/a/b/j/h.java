package b.i.a.b.j;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SafeLoggingExecutor.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements Executor {
    public final Executor j;

    public h(Executor executor) {
        this.j = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.j.execute(new h$a(runnable));
    }
}
