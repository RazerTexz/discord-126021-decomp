package rx.subjects;

import j0.g;
import rx.Observable;
import rx.Observable$a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Subject<T, R> extends Observable<R> implements g<T> {
    public Subject(Observable$a<R> observable$a) {
        super(observable$a);
    }
}
