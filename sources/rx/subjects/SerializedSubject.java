package rx.subjects;

import j0.n.SerializedObserver;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
public class SerializedSubject<T, R> extends Subject<T, R> {
    public final SerializedObserver<T> k;

    public class a implements Observable.a<R> {
        public final /* synthetic */ Subject j;

        public a(Subject subject) {
            this.j = subject;
        }

        @Override // rx.functions.Action1
        public void call(Object obj) {
            this.j.i0((Subscriber) obj);
        }
    }

    public SerializedSubject(Subject<T, R> subject) {
        super(new a(subject));
        this.k = new SerializedObserver<>(subject);
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.k.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.k.onError(th);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        this.k.onNext(t);
    }
}
