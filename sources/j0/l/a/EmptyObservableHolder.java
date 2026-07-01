package j0.l.a;

import rx.Observable;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.c, reason: use source file name */
/* JADX INFO: compiled from: EmptyObservableHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EmptyObservableHolder implements Observable.a<Object> {
    INSTANCE;

    public static final Observable<Object> k = Observable.h0(INSTANCE);

    @Override // rx.functions.Action1
    public void call(Object obj) {
        ((Subscriber) obj).onCompleted();
    }
}
