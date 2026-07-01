package i0.d0.a;

import j0.o.RxJavaPlugins;
import java.util.Objects;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: renamed from: i0.d0.a.e, reason: use source file name */
/* JADX INFO: compiled from: ResultOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ResultOnSubscribe<T> implements Observable.a<Result4<T>> {
    public final Observable.a<Response<T>> j;

    /* JADX INFO: renamed from: i0.d0.a.e$a */
    /* JADX INFO: compiled from: ResultOnSubscribe.java */
    public static class a<R> extends Subscriber<Response<R>> {
        public final Subscriber<? super Result4<R>> j;

        public a(Subscriber<? super Result4<R>> subscriber) {
            super(subscriber);
            this.j = subscriber;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            this.j.onCompleted();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            try {
                Subscriber<? super Result4<R>> subscriber = this.j;
                Objects.requireNonNull(th, "error == null");
                subscriber.onNext(new Result4(null, th));
                this.j.onCompleted();
            } catch (Throwable th2) {
                try {
                    this.j.onError(th2);
                } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused) {
                    Objects.requireNonNull(RxJavaPlugins.a.b());
                } catch (Throwable th3) {
                    b.i.a.f.e.o.f.o1(th3);
                    new CompositeException(th2, th3);
                    Objects.requireNonNull(RxJavaPlugins.a.b());
                }
            }
        }

        @Override // j0.Observer2
        public void onNext(Object obj) {
            Response response = (Response) obj;
            Subscriber<? super Result4<R>> subscriber = this.j;
            Objects.requireNonNull(response, "response == null");
            subscriber.onNext(new Result4(response, null));
        }
    }

    public ResultOnSubscribe(Observable.a<Response<T>> aVar) {
        this.j = aVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        this.j.call((Response<T>) new a((Subscriber) obj));
    }
}
