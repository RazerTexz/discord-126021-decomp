package p630i0.p631d0.p632a;

import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p652o.C12777o;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.exceptions.CompositeException;
import p658rx.exceptions.OnCompletedFailedException;
import p658rx.exceptions.OnErrorFailedException;
import p658rx.exceptions.OnErrorNotImplementedException;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;

/* JADX INFO: renamed from: i0.d0.a.a */
/* JADX INFO: compiled from: BodyOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12505a<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final Observable.InterfaceC13005a<Response<T>> f26497j;

    /* JADX INFO: renamed from: i0.d0.a.a$a */
    /* JADX INFO: compiled from: BodyOnSubscribe.java */
    public static class a<R> extends Subscriber<Response<R>> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super R> f26498j;

        /* JADX INFO: renamed from: k */
        public boolean f26499k;

        public a(Subscriber<? super R> subscriber) {
            super(subscriber);
            this.f26498j = subscriber;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            if (this.f26499k) {
                return;
            }
            this.f26498j.onCompleted();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            if (!this.f26499k) {
                this.f26498j.onError(th);
            } else {
                new AssertionError("This should never happen! Report as a Retrofit bug with the full stacktrace.").initCause(th);
                Objects.requireNonNull(C12777o.f27384a.m10869b());
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(Object obj) {
            Response response = (Response) obj;
            if (response.m11057a()) {
                this.f26498j.onNext(response.f27632b);
                return;
            }
            this.f26499k = true;
            HttpException httpException = new HttpException(response);
            try {
                this.f26498j.onError(httpException);
            } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused) {
                Objects.requireNonNull(C12777o.f27384a.m10869b());
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                new CompositeException(httpException, th);
                Objects.requireNonNull(C12777o.f27384a.m10869b());
            }
        }
    }

    public C12505a(Observable.InterfaceC13005a<Response<T>> interfaceC13005a) {
        this.f26497j = interfaceC13005a;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        this.f26497j.call((Response<T>) new a((Subscriber) obj));
    }
}
