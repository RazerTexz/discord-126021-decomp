package j0;

import rx.Subscription;

/* JADX INFO: compiled from: CompletableSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public interface e {
    void a(Subscription subscription);

    void onCompleted();

    void onError(Throwable th);
}
