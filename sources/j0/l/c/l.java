package j0.l.c;

import java.util.Objects;
import rx.Scheduler$Worker;
import rx.functions.Action0;

/* JADX INFO: compiled from: SleepingAction.java */
/* JADX INFO: loaded from: classes3.dex */
public class l implements Action0 {
    public final Action0 j;
    public final Scheduler$Worker k;
    public final long l;

    public l(Action0 action0, Scheduler$Worker scheduler$Worker, long j) {
        this.j = action0;
        this.k = scheduler$Worker;
        this.l = j;
    }

    @Override // rx.functions.Action0
    public void call() {
        if (this.k.isUnsubscribed()) {
            return;
        }
        long j = this.l;
        Objects.requireNonNull(this.k);
        long jCurrentTimeMillis = j - System.currentTimeMillis();
        if (jCurrentTimeMillis > 0) {
            try {
                Thread.sleep(jCurrentTimeMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                b.i.a.f.e.o.f.V0(e);
                throw null;
            }
        }
        if (this.k.isUnsubscribed()) {
            return;
        }
        this.j.call();
    }
}
