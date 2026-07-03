package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicLong;
import p637j0.C12580f;
import p637j0.p642l.p644b.C12693a;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.functions.Action0;
import p658rx.subjects.Subject;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.t */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12672t implements Action0 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Subscriber f27042j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Subject f27043k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C12693a f27044l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ AtomicLong f27045m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ SerialSubscription f27046n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C12687y f27047o;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: j0.l.a.t$a */
    /* JADX INFO: compiled from: OnSubscribeRedo.java */
    public class a<T> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public boolean f27048j;

        public a() {
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            if (this.f27048j) {
                return;
            }
            this.f27048j = true;
            unsubscribe();
            C12672t.this.f27043k.onNext(C12580f.f26688a);
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            if (this.f27048j) {
                return;
            }
            this.f27048j = true;
            unsubscribe();
            C12672t.this.f27043k.onNext(new C12580f(C12580f.a.OnError, null, th));
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            long j;
            if (this.f27048j) {
                return;
            }
            C12672t.this.f27042j.onNext(t);
            do {
                j = C12672t.this.f27045m.get();
                if (j == RecyclerView.FOREVER_NS) {
                    break;
                }
            } while (!C12672t.this.f27045m.compareAndSet(j, j - 1));
            C12672t.this.f27044l.m10796b(1L);
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            C12672t.this.f27044l.m10797c(producer);
        }
    }

    public C12672t(C12687y c12687y, Subscriber subscriber, Subject subject, C12693a c12693a, AtomicLong atomicLong, SerialSubscription serialSubscription) {
        this.f27047o = c12687y;
        this.f27042j = subscriber;
        this.f27043k = subject;
        this.f27044l = c12693a;
        this.f27045m = atomicLong;
        this.f27046n = serialSubscription;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // p658rx.functions.Action0
    public void call() {
        if (this.f27042j.isUnsubscribed()) {
            return;
        }
        a aVar = new a();
        this.f27046n.m11139a(aVar);
        this.f27047o.f27120j.m11107i0(aVar);
    }
}
