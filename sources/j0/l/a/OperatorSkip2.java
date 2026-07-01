package j0.l.a;

import b.d.b.a.outline;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.t1, reason: use source file name */
/* JADX INFO: compiled from: OperatorSkip.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorSkip2<T> implements Observable.b<T, T> {
    public final int j;

    public OperatorSkip2(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(outline.q("n >= 0 required but it was ", i));
        }
        this.j = i;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new OperatorSkip(this, subscriber, subscriber);
    }
}
