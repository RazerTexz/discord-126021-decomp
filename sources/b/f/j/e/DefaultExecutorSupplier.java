package b.f.j.e;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: renamed from: b.f.j.e.b, reason: use source file name */
/* JADX INFO: compiled from: DefaultExecutorSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultExecutorSupplier implements ExecutorSupplier {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f568b;
    public final Executor c;
    public final ScheduledExecutorService e;
    public final Executor a = Executors.newFixedThreadPool(2, new PriorityThreadFactory2(10, "FrescoIoBoundExecutor", true));
    public final Executor d = Executors.newFixedThreadPool(1, new PriorityThreadFactory2(10, "FrescoLightWeightBackgroundExecutor", true));

    public DefaultExecutorSupplier(int i) {
        this.f568b = Executors.newFixedThreadPool(i, new PriorityThreadFactory2(10, "FrescoDecodeExecutor", true));
        this.c = Executors.newFixedThreadPool(i, new PriorityThreadFactory2(10, "FrescoBackgroundExecutor", true));
        this.e = Executors.newScheduledThreadPool(i, new PriorityThreadFactory2(10, "FrescoBackgroundExecutor", true));
    }

    @Override // b.f.j.e.ExecutorSupplier
    public Executor a() {
        return this.f568b;
    }

    @Override // b.f.j.e.ExecutorSupplier
    public Executor b() {
        return this.d;
    }

    @Override // b.f.j.e.ExecutorSupplier
    public Executor c() {
        return this.c;
    }

    @Override // b.f.j.e.ExecutorSupplier
    public Executor d() {
        return this.a;
    }

    @Override // b.f.j.e.ExecutorSupplier
    public Executor e() {
        return this.a;
    }

    @Override // b.f.j.e.ExecutorSupplier
    public Executor f() {
        return this.a;
    }

    @Override // b.f.j.e.ExecutorSupplier
    public ScheduledExecutorService g() {
        return this.e;
    }
}
