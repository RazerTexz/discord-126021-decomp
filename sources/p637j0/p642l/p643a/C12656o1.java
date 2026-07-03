package p637j0.p642l.p643a;

import android.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.InterfaceC12581g;
import p637j0.p642l.p647e.p648n.C12729f;
import p637j0.p642l.p647e.p649o.C12749s;
import p637j0.p642l.p647e.p649o.C12755y;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.functions.Func0;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.o1 */
/* JADX INFO: compiled from: OperatorScan.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12656o1<R, T> implements Observable.InterfaceC13006b<R, T> {

    /* JADX INFO: renamed from: j */
    public static final Object f26957j = new Object();

    /* JADX INFO: renamed from: k */
    public final Func0<R> f26958k;

    /* JADX INFO: renamed from: l */
    public final Func2<R, ? super T, R> f26959l;

    /* JADX INFO: renamed from: j0.l.a.o1$a */
    /* JADX INFO: compiled from: OperatorScan.java */
    public class a implements Func0<R> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Object f26960j;

        public a(Object obj) {
            this.f26960j = obj;
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public R call() {
            return (R) this.f26960j;
        }
    }

    /* JADX INFO: renamed from: j0.l.a.o1$b */
    /* JADX INFO: compiled from: OperatorScan.java */
    public static final class b<R> implements Producer, InterfaceC12581g<R> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super R> f26961j;

        /* JADX INFO: renamed from: k */
        public final Queue<Object> f26962k;

        /* JADX INFO: renamed from: l */
        public boolean f26963l;

        /* JADX INFO: renamed from: m */
        public boolean f26964m;

        /* JADX INFO: renamed from: n */
        public long f26965n;

        /* JADX INFO: renamed from: o */
        public final AtomicLong f26966o;

        /* JADX INFO: renamed from: p */
        public volatile Producer f26967p;

        /* JADX INFO: renamed from: q */
        public volatile boolean f26968q;

        /* JADX INFO: renamed from: r */
        public Throwable f26969r;

        public b(R r, Subscriber<? super R> subscriber) {
            this.f26961j = subscriber;
            Queue<Object> c12749s = C12755y.m10858b() ? new C12749s<>() : new C12729f<>();
            this.f26962k = c12749s;
            c12749s.offer(r == null ? (R) C12614e.f26769b : r);
            this.f26966o = new AtomicLong();
        }

        /* JADX INFO: renamed from: a */
        public boolean m10776a(boolean z2, boolean z3, Subscriber<? super R> subscriber) {
            if (subscriber.isUnsubscribed()) {
                return true;
            }
            if (!z2) {
                return false;
            }
            Throwable th = this.f26969r;
            if (th != null) {
                subscriber.onError(th);
                return true;
            }
            if (!z3) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        /* JADX INFO: renamed from: b */
        public void m10777b() {
            synchronized (this) {
                if (this.f26963l) {
                    this.f26964m = true;
                    return;
                }
                this.f26963l = true;
                Subscriber<? super R> subscriber = this.f26961j;
                Queue<Object> queue = this.f26962k;
                AtomicLong atomicLong = this.f26966o;
                long jM4250U0 = atomicLong.get();
                while (!m10776a(this.f26968q, queue.isEmpty(), subscriber)) {
                    long j = 0;
                    while (j != jM4250U0) {
                        boolean z2 = this.f26968q;
                        Object objPoll = queue.poll();
                        boolean z3 = objPoll == null;
                        if (m10776a(z2, z3, subscriber)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        R r = (Object) C12614e.m10745b(objPoll);
                        try {
                            subscriber.onNext(r);
                            j++;
                        } catch (Throwable th) {
                            C3404f.m4329p1(th, subscriber, r);
                            return;
                        }
                    }
                    if (j != 0 && jM4250U0 != RecyclerView.FOREVER_NS) {
                        jM4250U0 = C3404f.m4250U0(atomicLong, j);
                    }
                    synchronized (this) {
                        if (!this.f26964m) {
                            this.f26963l = false;
                            return;
                        }
                        this.f26964m = false;
                    }
                }
            }
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
            if (j < 0) {
                throw new IllegalArgumentException(C1643a.m877t("n >= required but it was ", j));
            }
            if (j != 0) {
                C3404f.m4276c0(this.f26966o, j);
                Producer producer = this.f26967p;
                if (producer == null) {
                    synchronized (this.f26966o) {
                        producer = this.f26967p;
                        if (producer == null) {
                            this.f26965n = C3404f.m4287f(this.f26965n, j);
                        }
                    }
                }
                if (producer != null) {
                    producer.mo10704j(j);
                }
                m10777b();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            this.f26968q = true;
            m10777b();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            this.f26969r = th;
            this.f26968q = true;
            m10777b();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // p637j0.InterfaceC12581g
        public void onNext(R r) {
            Queue<Object> queue = this.f26962k;
            Object obj = r;
            if (r == null) {
                obj = C12614e.f26769b;
            }
            queue.offer(obj);
            m10777b();
        }
    }

    public C12656o1(R r, Func2<R, ? super T, R> func2) {
        this.f26958k = new a(r);
        this.f26959l = func2;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        R rCall = this.f26958k.call();
        if (rCall == f26957j) {
            return new C12660p1(this, subscriber, subscriber);
        }
        b bVar = new b(rCall, subscriber);
        C12664q1 c12664q1 = new C12664q1(this, rCall, bVar);
        subscriber.add(c12664q1);
        subscriber.setProducer(bVar);
        return c12664q1;
    }
}
