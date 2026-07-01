package i0.d0.a;

import j0.o.o;
import java.util.Objects;
import retrofit2.Response;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: compiled from: ResultOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$a<R> extends Subscriber<Response<R>> {
    public final Subscriber<? super d<R>> j;

    public e$a(Subscriber<? super d<R>> subscriber) {
        super(subscriber);
        this.j = subscriber;
    }

    @Override // j0.g
    public void onCompleted() {
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        try {
            Subscriber<? super d<R>> subscriber = this.j;
            Objects.requireNonNull(th, "error == null");
            subscriber.onNext(new d(null, th));
            this.j.onCompleted();
        } catch (Throwable th2) {
            try {
                this.j.onError(th2);
            } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused) {
                Objects.requireNonNull(o.a.b());
            } catch (Throwable th3) {
                b.i.a.f.e.o.f.o1(th3);
                new CompositeException(th2, th3);
                Objects.requireNonNull(o.a.b());
            }
        }
    }

    @Override // j0.g
    public void onNext(Object obj) {
        Response response = (Response) obj;
        Subscriber<? super d<R>> subscriber = this.j;
        Objects.requireNonNull(response, "response == null");
        subscriber.onNext(new d(response, null));
    }
}
