package p007b.p225i.p361c.p406w;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.c.w.e */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ExecutorC4867e implements Executor {

    /* JADX INFO: renamed from: j */
    public static final Executor f13020j = new ExecutorC4867e();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
