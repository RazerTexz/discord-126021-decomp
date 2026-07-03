package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p643a.C12663q0;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.functions.Action0;
import p658rx.observers.SerializedSubscriber;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.p0 */
/* JADX INFO: compiled from: OperatorDebounceWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12659p0<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public final C12663q0.a<T> f26973j;

    /* JADX INFO: renamed from: k */
    public final Subscriber<?> f26974k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ SerialSubscription f26975l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ Scheduler.Worker f26976m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ SerializedSubscriber f26977n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C12663q0 f26978o;

    /* JADX INFO: renamed from: j0.l.a.p0$a */
    /* JADX INFO: compiled from: OperatorDebounceWithTime.java */
    public class a implements Action0 {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f26979j;

        public a(int i) {
            this.f26979j = i;
        }

        @Override // p658rx.functions.Action0
        public void call() {
            C12659p0 c12659p0 = C12659p0.this;
            C12663q0.a<T> aVar = c12659p0.f26973j;
            int i = this.f26979j;
            SerializedSubscriber serializedSubscriber = c12659p0.f26977n;
            Subscriber<?> subscriber = c12659p0.f26974k;
            synchronized (aVar) {
                if (!aVar.f27000e && aVar.f26998c && i == aVar.f26996a) {
                    T t = aVar.f26997b;
                    aVar.f26997b = null;
                    aVar.f26998c = false;
                    aVar.f27000e = true;
                    try {
                        serializedSubscriber.onNext(t);
                        synchronized (aVar) {
                            if (aVar.f26999d) {
                                serializedSubscriber.onCompleted();
                            } else {
                                aVar.f27000e = false;
                            }
                        }
                    } catch (Throwable th) {
                        C3404f.m4329p1(th, subscriber, t);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12659p0(C12663q0 c12663q0, Subscriber subscriber, SerialSubscription serialSubscription, Scheduler.Worker worker, SerializedSubscriber serializedSubscriber) {
        super(subscriber);
        this.f26978o = c12663q0;
        this.f26975l = serialSubscription;
        this.f26976m = worker;
        this.f26977n = serializedSubscriber;
        this.f26973j = new C12663q0.a<>();
        this.f26974k = this;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        C12663q0.a<T> aVar = this.f26973j;
        SerializedSubscriber serializedSubscriber = this.f26977n;
        synchronized (aVar) {
            if (aVar.f27000e) {
                aVar.f26999d = true;
                return;
            }
            T t = aVar.f26997b;
            boolean z2 = aVar.f26998c;
            aVar.f26997b = null;
            aVar.f26998c = false;
            aVar.f27000e = true;
            if (z2) {
                try {
                    serializedSubscriber.onNext(t);
                } catch (Throwable th) {
                    C3404f.m4329p1(th, this, t);
                    return;
                }
            }
            serializedSubscriber.onCompleted();
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f26977n.f27646j.onError(th);
        unsubscribe();
        C12663q0.a<T> aVar = this.f26973j;
        synchronized (aVar) {
            aVar.f26996a++;
            aVar.f26997b = null;
            aVar.f26998c = false;
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        int i;
        C12663q0.a<T> aVar = this.f26973j;
        synchronized (aVar) {
            aVar.f26997b = t;
            aVar.f26998c = true;
            i = aVar.f26996a + 1;
            aVar.f26996a = i;
        }
        SerialSubscription serialSubscription = this.f26975l;
        Scheduler.Worker worker = this.f26976m;
        a aVar2 = new a(i);
        C12663q0 c12663q0 = this.f26978o;
        serialSubscription.m11139a(worker.mo10741b(aVar2, c12663q0.f26993j, c12663q0.f26994k));
    }

    @Override // p658rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
