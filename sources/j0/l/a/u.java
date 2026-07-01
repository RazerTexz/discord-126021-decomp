package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class u extends Subscriber<j0.f<?>> {
    public final /* synthetic */ Subscriber j;
    public final /* synthetic */ v k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(v vVar, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.k = vVar;
        this.j = subscriber2;
    }

    @Override // j0.g
    public void onCompleted() {
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.j.onError(th);
    }

    @Override // j0.g
    public void onNext(Object obj) {
        j0.f fVar = (j0.f) obj;
        j0.f$a f_a = fVar.f3768b;
        if ((f_a == j0.f$a.OnCompleted) && this.k.j.l) {
            this.j.onCompleted();
            return;
        }
        if ((f_a == j0.f$a.OnError) && this.k.j.m) {
            this.j.onError(fVar.c);
        } else {
            this.j.onNext(fVar);
        }
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        producer.j(RecyclerView.FOREVER_NS);
    }
}
