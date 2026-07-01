package j0.l.a;

import java.util.Objects;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: compiled from: DeferredScalarSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a implements Producer {
    public final a<?, ?> j;

    public a$a(a<?, ?> aVar) {
        this.j = aVar;
    }

    @Override // rx.Producer
    public void j(long j) {
        a<?, ?> aVar = this.j;
        Objects.requireNonNull(aVar);
        if (j < 0) {
            throw new IllegalArgumentException(b.d.b.a.a.t("n >= 0 required but it was ", j));
        }
        if (j != 0) {
            Subscriber<? super Object> subscriber = aVar.j;
            do {
                int i = aVar.m.get();
                if (i == 1 || i == 3 || subscriber.isUnsubscribed()) {
                    return;
                }
                if (i == 2) {
                    if (aVar.m.compareAndSet(2, 3)) {
                        subscriber.onNext(aVar.l);
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        subscriber.onCompleted();
                        return;
                    }
                    return;
                }
            } while (!aVar.m.compareAndSet(0, 1));
        }
    }
}
