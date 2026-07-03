package p007b.p225i.p226a.p228b.p231j;

import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.b.j.h */
/* JADX INFO: compiled from: SafeLoggingExecutor.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExecutorC2441h implements Executor {

    /* JADX INFO: renamed from: j */
    public final Executor f5279j;

    /* JADX INFO: renamed from: b.i.a.b.j.h$a */
    /* JADX INFO: compiled from: SafeLoggingExecutor.java */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final Runnable f5280j;

        public a(Runnable runnable) {
            this.f5280j = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f5280j.run();
            } catch (Exception e) {
                C1460d.m504c0("Executor", "Background execution failure.", e);
            }
        }
    }

    public ExecutorC2441h(Executor executor) {
        this.f5279j = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f5279j.execute(new a(runnable));
    }
}
