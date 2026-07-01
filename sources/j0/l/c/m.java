package j0.l.c;

import rx.Scheduler;
import rx.Scheduler$Worker;

/* JADX INFO: compiled from: TrampolineScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends Scheduler {
    public static final m a = new m();

    @Override // rx.Scheduler
    public Scheduler$Worker a() {
        return new m$a();
    }
}
