package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.l.a.OperatorDebounceWithTime2;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.p0, reason: use source file name */
/* JADX INFO: compiled from: OperatorDebounceWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorDebounceWithTime<T> extends Subscriber<T> {
    public final OperatorDebounceWithTime2.a<T> j;
    public final Subscriber<?> k;
    public final /* synthetic */ SerialSubscription l;
    public final /* synthetic */ Scheduler.Worker m;
    public final /* synthetic */ SerializedSubscriber n;
    public final /* synthetic */ OperatorDebounceWithTime2 o;

    /* JADX INFO: renamed from: j0.l.a.p0$a */
    /* JADX INFO: compiled from: OperatorDebounceWithTime.java */
    public class a implements Action0 {
        public final /* synthetic */ int j;

        public a(int i) {
            this.j = i;
        }

        @Override // rx.functions.Action0
        public void call() {
            OperatorDebounceWithTime operatorDebounceWithTime = OperatorDebounceWithTime.this;
            OperatorDebounceWithTime2.a<T> aVar = operatorDebounceWithTime.j;
            int i = this.j;
            SerializedSubscriber serializedSubscriber = operatorDebounceWithTime.n;
            Subscriber<?> subscriber = operatorDebounceWithTime.k;
            synchronized (aVar) {
                if (!aVar.e && aVar.c && i == aVar.a) {
                    T t = aVar.f3778b;
                    aVar.f3778b = null;
                    aVar.c = false;
                    aVar.e = true;
                    try {
                        serializedSubscriber.onNext(t);
                        synchronized (aVar) {
                            if (aVar.d) {
                                serializedSubscriber.onCompleted();
                            } else {
                                aVar.e = false;
                            }
                        }
                    } catch (Throwable th) {
                        b.i.a.f.e.o.f.p1(th, subscriber, t);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorDebounceWithTime(OperatorDebounceWithTime2 operatorDebounceWithTime2, Subscriber subscriber, SerialSubscription serialSubscription, Scheduler.Worker worker, SerializedSubscriber serializedSubscriber) {
        super(subscriber);
        this.o = operatorDebounceWithTime2;
        this.l = serialSubscription;
        this.m = worker;
        this.n = serializedSubscriber;
        this.j = new OperatorDebounceWithTime2.a<>();
        this.k = this;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        OperatorDebounceWithTime2.a<T> aVar = this.j;
        SerializedSubscriber serializedSubscriber = this.n;
        synchronized (aVar) {
            if (aVar.e) {
                aVar.d = true;
                return;
            }
            T t = aVar.f3778b;
            boolean z2 = aVar.c;
            aVar.f3778b = null;
            aVar.c = false;
            aVar.e = true;
            if (z2) {
                try {
                    serializedSubscriber.onNext(t);
                } catch (Throwable th) {
                    b.i.a.f.e.o.f.p1(th, this, t);
                    return;
                }
            }
            serializedSubscriber.onCompleted();
        }
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.n.j.onError(th);
        unsubscribe();
        OperatorDebounceWithTime2.a<T> aVar = this.j;
        synchronized (aVar) {
            aVar.a++;
            aVar.f3778b = null;
            aVar.c = false;
        }
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        int i;
        OperatorDebounceWithTime2.a<T> aVar = this.j;
        synchronized (aVar) {
            aVar.f3778b = t;
            aVar.c = true;
            i = aVar.a + 1;
            aVar.a = i;
        }
        SerialSubscription serialSubscription = this.l;
        Scheduler.Worker worker = this.m;
        a aVar2 = new a(i);
        OperatorDebounceWithTime2 operatorDebounceWithTime2 = this.o;
        serialSubscription.a(worker.b(aVar2, operatorDebounceWithTime2.j, operatorDebounceWithTime2.k));
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
