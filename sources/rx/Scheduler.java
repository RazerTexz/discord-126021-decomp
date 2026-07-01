package rx;

import j0.l.c.SchedulePeriodicHelper;
import j0.l.c.SchedulePeriodicHelper2;
import j0.l.d.SequentialSubscription;
import java.util.concurrent.TimeUnit;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Scheduler {

    public static abstract class Worker implements Subscription {
        public abstract Subscription a(Action0 action0);

        public abstract Subscription b(Action0 action0, long j, TimeUnit timeUnit);

        public Subscription c(Action0 action0, long j, long j2, TimeUnit timeUnit) {
            int i = SchedulePeriodicHelper2.f3791b;
            long nanos = timeUnit.toNanos(j2);
            long nanos2 = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
            long nanos3 = timeUnit.toNanos(j) + nanos2;
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
            sequentialSubscription.a(b(new SchedulePeriodicHelper(nanos2, nanos3, action0, sequentialSubscription2, null, this, nanos), j, timeUnit));
            return sequentialSubscription2;
        }
    }

    public abstract Worker a();
}
