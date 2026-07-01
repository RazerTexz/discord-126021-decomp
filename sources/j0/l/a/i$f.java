package j0.l.a;

import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeCreate.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i$f<T> extends i$a<T> {
    private static final long serialVersionUID = 4127754106204442833L;

    public i$f(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    public abstract void c();

    public void onNext(T t) {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        if (get() == 0) {
            c();
        } else {
            this.actual.onNext(t);
            b.i.a.f.e.o.f.U0(this, 1L);
        }
    }
}
