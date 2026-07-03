package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p644b.C12693a;
import p637j0.p652o.C12774l;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.e1 */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12616e1<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public boolean f26772j;

    /* JADX INFO: renamed from: k */
    public long f26773k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Subscriber f26774l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C12693a f26775m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ SerialSubscription f26776n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C12620f1 f26777o;

    /* JADX INFO: renamed from: j0.l.a.e1$a */
    /* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
    public class a extends Subscriber<T> {
        public a() {
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            C12616e1.this.f26774l.onCompleted();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            C12616e1.this.f26774l.onError(th);
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            C12616e1.this.f26774l.onNext(t);
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            C12616e1.this.f26775m.m10797c(producer);
        }
    }

    public C12616e1(C12620f1 c12620f1, Subscriber subscriber, C12693a c12693a, SerialSubscription serialSubscription) {
        this.f26777o = c12620f1;
        this.f26774l = subscriber;
        this.f26775m = c12693a;
        this.f26776n = serialSubscription;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        if (this.f26772j) {
            return;
        }
        this.f26772j = true;
        this.f26774l.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        if (this.f26772j) {
            C3404f.m4325o1(th);
            C12774l.m10863b(th);
            return;
        }
        this.f26772j = true;
        try {
            unsubscribe();
            a aVar = new a();
            this.f26776n.m11139a(aVar);
            long j = this.f26773k;
            if (j != 0) {
                this.f26775m.m10796b(j);
            }
            this.f26777o.f26788j.call(th).m11107i0(aVar);
        } catch (Throwable th2) {
            Subscriber subscriber = this.f26774l;
            C3404f.m4325o1(th2);
            subscriber.onError(th2);
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        if (this.f26772j) {
            return;
        }
        this.f26773k++;
        this.f26774l.onNext(t);
    }

    @Override // p658rx.Subscriber
    public void setProducer(Producer producer) {
        this.f26775m.m10797c(producer);
    }
}
