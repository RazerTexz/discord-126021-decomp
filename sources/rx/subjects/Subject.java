package rx.subjects;

import j0.Observer2;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Subject<T, R> extends Observable<R> implements Observer2<T> {
    public Subject(Observable.a<R> aVar) {
        super(aVar);
    }
}
