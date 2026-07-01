package b.i.c.m.d.k;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements Callable<Void> {
    public final /* synthetic */ Runnable j;

    public j(i iVar, Runnable runnable) {
        this.j = runnable;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.j.run();
        return null;
    }
}
