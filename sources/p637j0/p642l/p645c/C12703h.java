package p637j0.p642l.p645c;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p637j0.p642l.p646d.C12709a;
import p658rx.Scheduler;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.c.h */
/* JADX INFO: compiled from: SchedulePeriodicHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12703h implements Action0 {

    /* JADX INFO: renamed from: j */
    public long f27231j;

    /* JADX INFO: renamed from: k */
    public long f27232k;

    /* JADX INFO: renamed from: l */
    public long f27233l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ long f27234m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ long f27235n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ Action0 f27236o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ C12709a f27237p;

    /* JADX INFO: renamed from: q */
    public final /* synthetic */ C12704i.a f27238q;

    /* JADX INFO: renamed from: r */
    public final /* synthetic */ Scheduler.Worker f27239r;

    /* JADX INFO: renamed from: s */
    public final /* synthetic */ long f27240s;

    public C12703h(long j, long j2, Action0 action0, C12709a c12709a, C12704i.a aVar, Scheduler.Worker worker, long j3) {
        this.f27234m = j;
        this.f27235n = j2;
        this.f27236o = action0;
        this.f27237p = c12709a;
        this.f27238q = aVar;
        this.f27239r = worker;
        this.f27240s = j3;
        this.f27232k = j;
        this.f27233l = j2;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0045  */
    @Override // p658rx.functions.Action0
    public void call() {
        long nanos;
        long j;
        this.f27236o.call();
        if (this.f27237p.isUnsubscribed()) {
            return;
        }
        C12704i.a aVar = this.f27238q;
        if (aVar != null) {
            nanos = aVar.m10806a();
        } else {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Objects.requireNonNull(this.f27239r);
            nanos = timeUnit.toNanos(System.currentTimeMillis());
        }
        long j2 = C12704i.f27241a;
        long j3 = nanos + j2;
        long j4 = this.f27232k;
        if (j3 >= j4) {
            long j5 = this.f27240s;
            if (nanos >= j4 + j5 + j2) {
                long j6 = this.f27240s;
                j = nanos + j6;
                long j7 = this.f27231j + 1;
                this.f27231j = j7;
                this.f27233l = j - (j6 * j7);
            } else {
                long j8 = this.f27233l;
                long j9 = this.f27231j + 1;
                this.f27231j = j9;
                j = (j9 * j5) + j8;
            }
        } else {
            long j10 = this.f27240s;
            j = nanos + j10;
            long j11 = this.f27231j + 1;
            this.f27231j = j11;
            this.f27233l = j - (j10 * j11);
        }
        this.f27232k = nanos;
        this.f27237p.m10809a(this.f27239r.mo10741b(this, j - nanos, TimeUnit.NANOSECONDS));
    }
}
