package j0.q;

import rx.subjects.Subject;

/* JADX INFO: compiled from: ReplaySubject.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> extends Subject<T, T> {
    public static final Object[] k = new Object[0];
    public final a$d<T> l;

    public a(a$d<T> a_d) {
        super(a_d);
        this.l = a_d;
    }

    @Override // j0.g
    public void onCompleted() {
        this.l.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.l.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        this.l.onNext(t);
    }
}
