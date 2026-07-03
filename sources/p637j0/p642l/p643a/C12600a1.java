package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.C12575a;
import p637j0.p642l.p647e.C12713c;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.exceptions.MissingBackpressureException;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.a1 */
/* JADX INFO: compiled from: OperatorOnBackpressureBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12600a1<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final C12575a.b f26727j;

    /* JADX INFO: renamed from: j0.l.a.a1$a */
    /* JADX INFO: compiled from: OperatorOnBackpressureBuffer.java */
    public static final class a<T> extends Subscriber<T> implements C12713c.a {

        /* JADX INFO: renamed from: l */
        public final Subscriber<? super T> f26730l;

        /* JADX INFO: renamed from: p */
        public final C12575a.b f26734p;

        /* JADX INFO: renamed from: j */
        public final ConcurrentLinkedQueue<Object> f26728j = new ConcurrentLinkedQueue<>();

        /* JADX INFO: renamed from: m */
        public final AtomicBoolean f26731m = new AtomicBoolean(false);

        /* JADX INFO: renamed from: k */
        public final AtomicLong f26729k = null;

        /* JADX INFO: renamed from: o */
        public final Action0 f26733o = null;

        /* JADX INFO: renamed from: n */
        public final C12713c f26732n = new C12713c(this);

        public a(Subscriber<? super T> subscriber, Long l, Action0 action0, C12575a.b bVar) {
            this.f26730l = subscriber;
            this.f26734p = bVar;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() throws Throwable {
            if (this.f26731m.get()) {
                return;
            }
            C12713c c12713c = this.f26732n;
            c12713c.terminated = true;
            c12713c.m10810a();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) throws Throwable {
            if (this.f26731m.get()) {
                return;
            }
            C12713c c12713c = this.f26732n;
            if (c12713c.terminated) {
                return;
            }
            c12713c.exception = th;
            c12713c.terminated = true;
            c12713c.m10810a();
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0040  */
        /* JADX WARN: Code duplicated, block: B:44:0x006b A[EDGE_INSN: B:44:0x006b->B:33:0x006b BREAK  A[LOOP:0: B:5:0x0008->B:46:?], SYNTHETIC] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) throws Throwable {
            boolean z2;
            Object obj;
            boolean z3 = false;
            if (this.f26729k == null) {
                z3 = true;
                break;
            }
            while (true) {
                long j = this.f26729k.get();
                if (j <= 0) {
                    try {
                        if (this.f26734p.mo10731a()) {
                            Object objPoll = this.f26728j.poll();
                            AtomicLong atomicLong = this.f26729k;
                            if (atomicLong != null && objPoll != null) {
                                atomicLong.incrementAndGet();
                            }
                            if (objPoll != null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } else {
                            z2 = false;
                        }
                    } catch (MissingBackpressureException e) {
                        if (this.f26731m.compareAndSet(false, true)) {
                            unsubscribe();
                            this.f26730l.onError(e);
                        }
                    }
                    Action0 action0 = this.f26733o;
                    if (action0 == null) {
                        if (z2) {
                            break;
                            break;
                        }
                        break;
                    }
                    try {
                        action0.call();
                        if (z2) {
                            break;
                        } else {
                            break;
                        }
                    } catch (Throwable th) {
                        C3404f.m4325o1(th);
                        C12713c c12713c = this.f26732n;
                        if (!c12713c.terminated) {
                            c12713c.exception = th;
                            c12713c.terminated = true;
                            c12713c.m10810a();
                        }
                    }
                }
                if (this.f26729k.compareAndSet(j, j - 1)) {
                    z3 = true;
                    break;
                }
            }
            if (z3) {
                ConcurrentLinkedQueue<Object> concurrentLinkedQueue = this.f26728j;
                if (t == null) {
                    obj = t;
                    obj = C12614e.f26769b;
                }
                obj = t;
                concurrentLinkedQueue.offer(obj);
                this.f26732n.m10810a();
            }
        }

        @Override // p658rx.Subscriber
        public void onStart() {
            request(RecyclerView.FOREVER_NS);
        }
    }

    /* JADX INFO: renamed from: j0.l.a.a1$b */
    /* JADX INFO: compiled from: OperatorOnBackpressureBuffer.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public static final C12600a1<?> f26735a = new C12600a1<>();
    }

    public C12600a1() {
        int i = C12575a.f26683a;
        this.f26727j = C12575a.a.f26684a;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, null, null, this.f26727j);
        subscriber.add(aVar);
        subscriber.setProducer(aVar.f26732n);
        return aVar;
    }
}
