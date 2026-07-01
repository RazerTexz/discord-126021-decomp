package j0.l.a;

import rx.Observable;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: EmptyObservableHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public enum c implements Observable$a<Object> {
    INSTANCE;

    public static final Observable<Object> k = Observable.h0(INSTANCE);

    @Override // rx.functions.Action1
    public void call(Object obj) {
        ((Subscriber) obj).onCompleted();
    }
}
