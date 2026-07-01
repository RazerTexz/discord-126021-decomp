package i0.d0.a;

import retrofit2.Response;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: BodyOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> implements Observable$a<T> {
    public final Observable$a<Response<T>> j;

    public a(Observable$a<Response<T>> observable$a) {
        this.j = observable$a;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        this.j.call((Response<T>) new a$a((Subscriber) obj));
    }
}
