package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.w, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeRedo4 implements Action0 {
    public final /* synthetic */ Observable j;
    public final /* synthetic */ Subscriber k;
    public final /* synthetic */ AtomicLong l;
    public final /* synthetic */ Scheduler.Worker m;
    public final /* synthetic */ Action0 n;
    public final /* synthetic */ AtomicBoolean o;

    /* JADX INFO: renamed from: j0.l.a.w$a */
    /* JADX INFO: compiled from: OnSubscribeRedo.java */
    public class a extends Subscriber<Object> {
        public a(Subscriber subscriber) {
            super(subscriber);
        }

        @Override // j0.Observer2
        public void onCompleted() {
            OnSubscribeRedo4.this.k.onCompleted();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            OnSubscribeRedo4.this.k.onError(th);
        }

        @Override // j0.Observer2
        public void onNext(Object obj) {
            if (OnSubscribeRedo4.this.k.isUnsubscribed()) {
                return;
            }
            if (OnSubscribeRedo4.this.l.get() <= 0) {
                OnSubscribeRedo4.this.o.compareAndSet(false, true);
            } else {
                OnSubscribeRedo4 onSubscribeRedo4 = OnSubscribeRedo4.this;
                onSubscribeRedo4.m.a(onSubscribeRedo4.n);
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            producer.j(RecyclerView.FOREVER_NS);
        }
    }

    public OnSubscribeRedo4(OnSubscribeRedo6 onSubscribeRedo6, Observable observable, Subscriber subscriber, AtomicLong atomicLong, Scheduler.Worker worker, Action0 action0, AtomicBoolean atomicBoolean) {
        this.j = observable;
        this.k = subscriber;
        this.l = atomicLong;
        this.m = worker;
        this.n = action0;
        this.o = atomicBoolean;
    }

    @Override // rx.functions.Action0
    public void call() {
        this.j.i0(new a(this.k));
    }
}
