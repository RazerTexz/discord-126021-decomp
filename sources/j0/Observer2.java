package j0;

/* JADX INFO: renamed from: j0.g, reason: use source file name */
/* JADX INFO: compiled from: Observer.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Observer2<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
