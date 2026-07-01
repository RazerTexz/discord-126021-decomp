package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.Notification;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.u, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeRedo2 extends Subscriber<Notification<?>> {
    public final /* synthetic */ Subscriber j;
    public final /* synthetic */ OnSubscribeRedo3 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnSubscribeRedo2(OnSubscribeRedo3 onSubscribeRedo3, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.k = onSubscribeRedo3;
        this.j = subscriber2;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.j.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.j.onError(th);
    }

    @Override // j0.Observer2
    public void onNext(Object obj) {
        Notification notification = (Notification) obj;
        Notification.a aVar = notification.f3768b;
        if ((aVar == Notification.a.OnCompleted) && this.k.j.l) {
            this.j.onCompleted();
            return;
        }
        if ((aVar == Notification.a.OnError) && this.k.j.m) {
            this.j.onError(notification.c);
        } else {
            this.j.onNext(notification);
        }
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        producer.j(RecyclerView.FOREVER_NS);
    }
}
