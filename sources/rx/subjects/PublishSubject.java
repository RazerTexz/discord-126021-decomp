package rx.subjects;

/* JADX INFO: loaded from: classes3.dex */
public final class PublishSubject<T> extends Subject<T, T> {
    public final PublishSubject$b<T> k;

    public PublishSubject(PublishSubject$b<T> publishSubject$b) {
        super(publishSubject$b);
        this.k = publishSubject$b;
    }

    public static <T> PublishSubject<T> k0() {
        return new PublishSubject<>(new PublishSubject$b());
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
