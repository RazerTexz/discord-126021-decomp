package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.w */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12681w implements Action0 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Observable f27067j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Subscriber f27068k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ AtomicLong f27069l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ Scheduler.Worker f27070m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ Action0 f27071n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ AtomicBoolean f27072o;

    /* JADX INFO: renamed from: j0.l.a.w$a */
    /* JADX INFO: compiled from: OnSubscribeRedo.java */
    public class a extends Subscriber<Object> {
        public a(Subscriber subscriber) {
            super(subscriber);
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            C12681w.this.f27068k.onCompleted();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            C12681w.this.f27068k.onError(th);
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(Object obj) {
            if (C12681w.this.f27068k.isUnsubscribed()) {
                return;
            }
            if (C12681w.this.f27069l.get() <= 0) {
                C12681w.this.f27072o.compareAndSet(false, true);
            } else {
                C12681w c12681w = C12681w.this;
                c12681w.f27070m.mo10740a(c12681w.f27071n);
            }
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            producer.mo10704j(RecyclerView.FOREVER_NS);
        }
    }

    public C12681w(C12687y c12687y, Observable observable, Subscriber subscriber, AtomicLong atomicLong, Scheduler.Worker worker, Action0 action0, AtomicBoolean atomicBoolean) {
        this.f27067j = observable;
        this.f27068k = subscriber;
        this.f27069l = atomicLong;
        this.f27070m = worker;
        this.f27071n = action0;
        this.f27072o = atomicBoolean;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        this.f27067j.m11107i0(new a(this.f27068k));
    }
}
