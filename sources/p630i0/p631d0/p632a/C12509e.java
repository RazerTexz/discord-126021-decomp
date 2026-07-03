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

/* JADX INFO: renamed from: i0.d0.a.e */
/* JADX INFO: compiled from: ResultOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12509e<T> implements Observable.InterfaceC13005a<C12508d<T>> {

    /* JADX INFO: renamed from: j */
    public final Observable.InterfaceC13005a<Response<T>> f26503j;

    /* JADX INFO: renamed from: i0.d0.a.e$a */
    /* JADX INFO: compiled from: ResultOnSubscribe.java */
    public static class a<R> extends Subscriber<Response<R>> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super C12508d<R>> f26504j;

        public a(Subscriber<? super C12508d<R>> subscriber) {
            super(subscriber);
            this.f26504j = subscriber;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            this.f26504j.onCompleted();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            try {
                Subscriber<? super C12508d<R>> subscriber = this.f26504j;
                Objects.requireNonNull(th, "error == null");
                subscriber.onNext(new C12508d(null, th));
                this.f26504j.onCompleted();
            } catch (Throwable th2) {
                try {
                    this.f26504j.onError(th2);
                } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused) {
                    Objects.requireNonNull(C12777o.f27384a.m10869b());
                } catch (Throwable th3) {
                    C3404f.m4325o1(th3);
                    new CompositeException(th2, th3);
                    Objects.requireNonNull(C12777o.f27384a.m10869b());
                }
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(Object obj) {
            Response response = (Response) obj;
            Subscriber<? super C12508d<R>> subscriber = this.f26504j;
            Objects.requireNonNull(response, "response == null");
            subscriber.onNext(new C12508d(response, null));
        }
    }

    public C12509e(Observable.InterfaceC13005a<Response<T>> interfaceC13005a) {
        this.f26503j = interfaceC13005a;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        this.f26503j.call((Response<T>) new a((Subscriber) obj));
    }
}
