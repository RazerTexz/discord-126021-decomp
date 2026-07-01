package j0.l.a;

import j0.Single2;
import j0.SingleSubscriber;
import rx.Observable;

/* JADX INFO: renamed from: j0.l.a.e0, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeSingle.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeSingle2<T> implements Single2.a<T> {
    public final Observable<T> j;

    public OnSubscribeSingle2(Observable<T> observable) {
        this.j = observable;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        SingleSubscriber singleSubscriber = (SingleSubscriber) obj;
        OnSubscribeSingle onSubscribeSingle = new OnSubscribeSingle(this, singleSubscriber);
        singleSubscriber.j.a(onSubscribeSingle);
        this.j.i0(onSubscribeSingle);
    }
}
