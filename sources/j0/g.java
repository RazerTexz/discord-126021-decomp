package j0;

/* JADX INFO: compiled from: Observer.java */
/* JADX INFO: loaded from: classes3.dex */
public interface g<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
