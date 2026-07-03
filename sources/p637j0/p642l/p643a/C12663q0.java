package p637j0.p642l.p643a;

import java.util.concurrent.TimeUnit;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.observers.SerializedSubscriber;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.q0 */
/* JADX INFO: compiled from: OperatorDebounceWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12663q0<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final long f26993j;

    /* JADX INFO: renamed from: k */
    public final TimeUnit f26994k;

    /* JADX INFO: renamed from: l */
    public final Scheduler f26995l;

    /* JADX INFO: renamed from: j0.l.a.q0$a */
    /* JADX INFO: compiled from: OperatorDebounceWithTime.java */
    public static final class a<T> {

        /* JADX INFO: renamed from: a */
        public int f26996a;

        /* JADX INFO: renamed from: b */
        public T f26997b;

        /* JADX INFO: renamed from: c */
        public boolean f26998c;

        /* JADX INFO: renamed from: d */
        public boolean f26999d;

        /* JADX INFO: renamed from: e */
        public boolean f27000e;
    }

    public C12663q0(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f26993j = j;
        this.f26994k = timeUnit;
        this.f26995l = scheduler;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerMo10739a = this.f26995l.mo10739a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(workerMo10739a);
        serializedSubscriber.add(serialSubscription);
        return new C12659p0(this, subscriber, serialSubscription, workerMo10739a, serializedSubscriber);
    }
}
