package p007b.p225i.p361c.p369m.p370d.p373k;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.i.c.m.d.k.j */
/* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC4634j implements Callable<Void> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Runnable f12322j;

    public CallableC4634j(C4631i c4631i, Runnable runnable) {
        this.f12322j = runnable;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f12322j.run();
        return null;
    }
}
