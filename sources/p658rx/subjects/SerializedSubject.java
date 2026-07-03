package p658rx.subjects;

import p637j0.p651n.C12760c;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
public class SerializedSubject<T, R> extends Subject<T, R> {

    /* JADX INFO: renamed from: k */
    public final C12760c<T> f27653k;

    /* JADX INFO: renamed from: rx.subjects.SerializedSubject$a */
    public class C13017a implements Observable.InterfaceC13005a<R> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Subject f27654j;

        public C13017a(Subject subject) {
            this.f27654j = subject;
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            this.f27654j.m11107i0((Subscriber) obj);
        }
    }

    public SerializedSubject(Subject<T, R> subject) {
        super(new C13017a(subject));
        this.f27653k = new C12760c<>(subject);
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27653k.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27653k.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        this.f27653k.onNext(t);
    }
}
