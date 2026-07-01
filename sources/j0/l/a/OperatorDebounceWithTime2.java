package j0.l.a;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.q0, reason: use source file name */
/* JADX INFO: compiled from: OperatorDebounceWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorDebounceWithTime2<T> implements Observable.b<T, T> {
    public final long j;
    public final TimeUnit k;
    public final Scheduler l;

    /* JADX INFO: renamed from: j0.l.a.q0$a */
    /* JADX INFO: compiled from: OperatorDebounceWithTime.java */
    public static final class a<T> {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public T f3778b;
        public boolean c;
        public boolean d;
        public boolean e;
    }

    public OperatorDebounceWithTime2(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.j = j;
        this.k = timeUnit;
        this.l = scheduler;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerA = this.l.a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(workerA);
        serializedSubscriber.add(serialSubscription);
        return new OperatorDebounceWithTime(this, subscriber, serialSubscription, workerA, serializedSubscriber);
    }
}
