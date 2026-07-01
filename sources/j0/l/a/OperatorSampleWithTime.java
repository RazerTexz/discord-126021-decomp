package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

/* JADX INFO: renamed from: j0.l.a.n1, reason: use source file name */
/* JADX INFO: compiled from: OperatorSampleWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorSampleWithTime<T> implements Observable.b<T, T> {
    public final long j;
    public final TimeUnit k;
    public final Scheduler l;

    /* JADX INFO: renamed from: j0.l.a.n1$a */
    /* JADX INFO: compiled from: OperatorSampleWithTime.java */
    public static final class a<T> extends Subscriber<T> implements Action0 {
        public static final Object j = new Object();
        public final Subscriber<? super T> k;
        public final AtomicReference<Object> l = new AtomicReference<>(j);

        public a(Subscriber<? super T> subscriber) {
            this.k = subscriber;
        }

        public final void a() {
            AtomicReference<Object> atomicReference = this.l;
            Object obj = j;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                try {
                    this.k.onNext(andSet);
                } catch (Throwable th) {
                    b.i.a.f.e.o.f.o1(th);
                    onError(th);
                }
            }
        }

        @Override // rx.functions.Action0
        public void call() {
            a();
        }

        @Override // j0.Observer2
        public void onCompleted() {
            a();
            this.k.onCompleted();
            unsubscribe();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            this.k.onError(th);
            unsubscribe();
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            this.l.set(t);
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(RecyclerView.FOREVER_NS);
        }
    }

    public OperatorSampleWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.j = j;
        this.k = timeUnit;
        this.l = scheduler;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        Scheduler.Worker workerA = this.l.a();
        subscriber.add(workerA);
        a aVar = new a(serializedSubscriber);
        subscriber.add(aVar);
        long j = this.j;
        workerA.c(aVar, j, j, this.k);
        return aVar;
    }
}
