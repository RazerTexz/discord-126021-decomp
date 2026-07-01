package j0.l.a;

import rx.Observable;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeDoOnEach.java */
/* JADX INFO: loaded from: classes3.dex */
public class k<T> implements Observable$a<T> {
    public final j0.g<? super T> j;
    public final Observable<T> k;

    public k(Observable<T> observable, j0.g<? super T> gVar) {
        this.k = observable;
        this.j = gVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        this.k.i0(new k$a((Subscriber) obj, this.j));
    }
}
