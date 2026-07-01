package j0.m;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: renamed from: j0.m.b, reason: use source file name */
/* JADX INFO: compiled from: ConnectableObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ConnectableObservable<T> extends Observable<T> {
    public ConnectableObservable(Observable.a<T> aVar) {
        super(aVar);
    }

    public abstract void k0(Action1<? super Subscription> action1);
}
