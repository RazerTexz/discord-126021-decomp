package j0.l.a;

import java.util.List;
import rx.Observable$b;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorToObservableList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n2<T> implements Observable$b<List<T>, T> {
    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        j0.l.b.b bVar = new j0.l.b.b(subscriber);
        m2 m2Var = new m2(this, bVar, subscriber);
        subscriber.add(m2Var);
        subscriber.setProducer(bVar);
        return m2Var;
    }
}
