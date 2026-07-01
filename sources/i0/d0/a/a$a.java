package i0.d0.a;

import j0.o.o;
import java.util.Objects;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: compiled from: BodyOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a<R> extends Subscriber<Response<R>> {
    public final Subscriber<? super R> j;
    public boolean k;

    public a$a(Subscriber<? super R> subscriber) {
        super(subscriber);
        this.j = subscriber;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.k) {
            return;
        }
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (!this.k) {
            this.j.onError(th);
        } else {
            new AssertionError("This should never happen! Report as a Retrofit bug with the full stacktrace.").initCause(th);
            Objects.requireNonNull(o.a.b());
        }
    }

    @Override // j0.g
    public void onNext(Object obj) {
        Response response = (Response) obj;
        if (response.a()) {
            this.j.onNext((Object) response.f3824b);
            return;
        }
        this.k = true;
        HttpException httpException = new HttpException(response);
        try {
            this.j.onError(httpException);
        } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused) {
            Objects.requireNonNull(o.a.b());
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            new CompositeException(httpException, th);
            Objects.requireNonNull(o.a.b());
        }
    }
}
