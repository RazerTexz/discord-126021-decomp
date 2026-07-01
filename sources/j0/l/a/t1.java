package j0.l.a;

import rx.Observable$b;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorSkip.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t1<T> implements Observable$b<T, T> {
    public final int j;

    public t1(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(b.d.b.a.a.q("n >= 0 required but it was ", i));
        }
        this.j = i;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new s1(this, subscriber, subscriber);
    }
}
