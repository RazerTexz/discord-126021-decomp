package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.functions.Action0;
import p658rx.observers.SerializedSubscriber;

/* JADX INFO: renamed from: j0.l.a.n1 */
/* JADX INFO: compiled from: OperatorSampleWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12652n1<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final long f26948j;

    /* JADX INFO: renamed from: k */
    public final TimeUnit f26949k;

    /* JADX INFO: renamed from: l */
    public final Scheduler f26950l;

    /* JADX INFO: renamed from: j0.l.a.n1$a */
    /* JADX INFO: compiled from: OperatorSampleWithTime.java */
    public static final class a<T> extends Subscriber<T> implements Action0 {

        /* JADX INFO: renamed from: j */
        public static final Object f26951j = new Object();

        /* JADX INFO: renamed from: k */
        public final Subscriber<? super T> f26952k;

        /* JADX INFO: renamed from: l */
        public final AtomicReference<Object> f26953l = new AtomicReference<>(f26951j);

        public a(Subscriber<? super T> subscriber) {
            this.f26952k = subscriber;
        }

        /* JADX INFO: renamed from: a */
        public final void m10775a() {
            AtomicReference<Object> atomicReference = this.f26953l;
            Object obj = f26951j;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                try {
                    this.f26952k.onNext(andSet);
                } catch (Throwable th) {
                    C3404f.m4325o1(th);
                    onError(th);
                }
            }
        }

        @Override // p658rx.functions.Action0
        public void call() {
            m10775a();
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            m10775a();
            this.f26952k.onCompleted();
            unsubscribe();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            this.f26952k.onError(th);
            unsubscribe();
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            this.f26953l.set(t);
        }

        @Override // p658rx.Subscriber
        public void onStart() {
            request(RecyclerView.FOREVER_NS);
        }
    }

    public C12652n1(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f26948j = j;
        this.f26949k = timeUnit;
        this.f26950l = scheduler;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        Scheduler.Worker workerMo10739a = this.f26950l.mo10739a();
        subscriber.add(workerMo10739a);
        a aVar = new a(serializedSubscriber);
        subscriber.add(aVar);
        long j = this.f26948j;
        workerMo10739a.m11120c(aVar, j, j, this.f26949k);
        return aVar;
    }
}
