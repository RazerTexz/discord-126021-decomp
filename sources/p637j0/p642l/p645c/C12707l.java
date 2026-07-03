package p637j0.p642l.p645c;

import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Scheduler;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.c.l */
/* JADX INFO: compiled from: SleepingAction.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12707l implements Action0 {

    /* JADX INFO: renamed from: j */
    public final Action0 f27247j;

    /* JADX INFO: renamed from: k */
    public final Scheduler.Worker f27248k;

    /* JADX INFO: renamed from: l */
    public final long f27249l;

    public C12707l(Action0 action0, Scheduler.Worker worker, long j) {
        this.f27247j = action0;
        this.f27248k = worker;
        this.f27249l = j;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        if (this.f27248k.isUnsubscribed()) {
            return;
        }
        long j = this.f27249l;
        Objects.requireNonNull(this.f27248k);
        long jCurrentTimeMillis = j - System.currentTimeMillis();
        if (jCurrentTimeMillis > 0) {
            try {
                Thread.sleep(jCurrentTimeMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                C3404f.m4253V0(e);
                throw null;
            }
        }
        if (this.f27248k.isUnsubscribed()) {
            return;
        }
        this.f27247j.call();
    }
}
