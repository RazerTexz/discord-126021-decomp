package j0.l.c;

import j0.l.c.SchedulePeriodicHelper2;
import j0.l.d.SequentialSubscription;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.c.h, reason: use source file name */
/* JADX INFO: compiled from: SchedulePeriodicHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SchedulePeriodicHelper implements Action0 {
    public long j;
    public long k;
    public long l;
    public final /* synthetic */ long m;
    public final /* synthetic */ long n;
    public final /* synthetic */ Action0 o;
    public final /* synthetic */ SequentialSubscription p;
    public final /* synthetic */ SchedulePeriodicHelper2.a q;
    public final /* synthetic */ Scheduler.Worker r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ long f3790s;

    public SchedulePeriodicHelper(long j, long j2, Action0 action0, SequentialSubscription sequentialSubscription, SchedulePeriodicHelper2.a aVar, Scheduler.Worker worker, long j3) {
        this.m = j;
        this.n = j2;
        this.o = action0;
        this.p = sequentialSubscription;
        this.q = aVar;
        this.r = worker;
        this.f3790s = j3;
        this.k = j;
        this.l = j2;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0045  */
    @Override // rx.functions.Action0
    public void call() {
        long nanos;
        long j;
        this.o.call();
        if (this.p.isUnsubscribed()) {
            return;
        }
        SchedulePeriodicHelper2.a aVar = this.q;
        if (aVar != null) {
            nanos = aVar.a();
        } else {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Objects.requireNonNull(this.r);
            nanos = timeUnit.toNanos(System.currentTimeMillis());
        }
        long j2 = SchedulePeriodicHelper2.a;
        long j3 = nanos + j2;
        long j4 = this.k;
        if (j3 >= j4) {
            long j5 = this.f3790s;
            if (nanos >= j4 + j5 + j2) {
                long j6 = this.f3790s;
                j = nanos + j6;
                long j7 = this.j + 1;
                this.j = j7;
                this.l = j - (j6 * j7);
            } else {
                long j8 = this.l;
                long j9 = this.j + 1;
                this.j = j9;
                j = (j9 * j5) + j8;
            }
        } else {
            long j10 = this.f3790s;
            j = nanos + j10;
            long j11 = this.j + 1;
            this.j = j11;
            this.l = j - (j10 * j11);
        }
        this.k = nanos;
        this.p.a(this.r.b(this, j - nanos, TimeUnit.NANOSECONDS));
    }
}
