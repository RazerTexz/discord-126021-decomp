package b.i.c.m.d.k;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.i.c.m.d.k.j, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsBackgroundWorker2 implements Callable<Void> {
    public final /* synthetic */ Runnable j;

    public CrashlyticsBackgroundWorker2(CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, Runnable runnable) {
        this.j = runnable;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.j.run();
        return null;
    }
}
