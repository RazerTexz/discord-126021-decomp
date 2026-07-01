package j0.l.a;

import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeCreate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i$g<T> extends i$a<T> {
    private static final long serialVersionUID = 3776720187248809713L;

    public i$g(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    @Override // j0.g
    public void onNext(T t) {
        long j;
        if (this.actual.isUnsubscribed()) {
            return;
        }
        this.actual.onNext(t);
        do {
            j = get();
            if (j == 0) {
                return;
            }
        } while (!compareAndSet(j, j - 1));
    }
}
