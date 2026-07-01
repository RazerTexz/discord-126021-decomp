package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class w$a extends Subscriber<Object> {
    public final /* synthetic */ w j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w$a(w wVar, Subscriber subscriber) {
        super(subscriber);
        this.j = wVar;
    }

    @Override // j0.g
    public void onCompleted() {
        this.j.k.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.j.k.onError(th);
    }

    @Override // j0.g
    public void onNext(Object obj) {
        if (this.j.k.isUnsubscribed()) {
            return;
        }
        if (this.j.l.get() <= 0) {
            this.j.o.compareAndSet(false, true);
        } else {
            w wVar = this.j;
            wVar.m.a(wVar.n);
        }
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        producer.j(RecyclerView.FOREVER_NS);
    }
}
