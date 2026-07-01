package j0.l.a;

import j0.Notification;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.v, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeRedo3 implements Observable.b<Notification<?>, Notification<?>> {
    public final /* synthetic */ OnSubscribeRedo6 j;

    public OnSubscribeRedo3(OnSubscribeRedo6 onSubscribeRedo6) {
        this.j = onSubscribeRedo6;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new OnSubscribeRedo2(this, subscriber, subscriber);
    }
}
