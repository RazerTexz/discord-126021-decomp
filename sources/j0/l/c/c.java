package j0.l.c;

import java.util.concurrent.Executor;
import rx.Scheduler;
import rx.Scheduler$Worker;

/* JADX INFO: compiled from: ExecutorScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends Scheduler {
    public final Executor a;

    public c(Executor executor) {
        this.a = executor;
    }

    @Override // rx.Scheduler
    public Scheduler$Worker a() {
        return new c$a(this.a);
    }
}
