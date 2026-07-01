package j0.m;

import rx.Observable;
import rx.Observable$a;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: ConnectableObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> extends Observable<T> {
    public b(Observable$a<T> observable$a) {
        super(observable$a);
    }

    public abstract void k0(Action1<? super Subscription> action1);
}
