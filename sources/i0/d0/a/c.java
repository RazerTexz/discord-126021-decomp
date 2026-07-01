package i0.d0.a;

import retrofit2.Response;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: CallExecuteOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c<T> implements Observable$a<Response<T>> {
    public final i0.d<T> j;

    public c(i0.d<T> dVar) {
        this.j = dVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        i0.d<T> dVarL = this.j.L();
        b bVar = new b(dVarL, subscriber);
        subscriber.add(bVar);
        subscriber.setProducer(bVar);
        try {
            bVar.c(dVarL.execute());
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            bVar.b(th);
        }
    }
}
