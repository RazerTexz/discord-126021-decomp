package p007b.p225i.p361c.p398s;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.c.s.j */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ExecutorC4819j implements Executor {

    /* JADX INFO: renamed from: j */
    public static final Executor f12870j = new ExecutorC4819j();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
