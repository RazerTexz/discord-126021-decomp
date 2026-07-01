package rx.subjects;

import j0.n.c;

/* JADX INFO: loaded from: classes3.dex */
public class SerializedSubject<T, R> extends Subject<T, R> {
    public final c<T> k;

    public SerializedSubject(Subject<T, R> subject) {
        super(new SerializedSubject$a(subject));
        this.k = new c<>(subject);
    }

    @Override // j0.g
    public void onCompleted() {
        this.k.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.k.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        this.k.onNext(t);
    }
}
