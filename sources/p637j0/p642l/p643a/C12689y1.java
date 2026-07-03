package p637j0.p642l.p643a;

import android.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import p637j0.p642l.p646d.EnumC12710b;
import p637j0.p642l.p647e.C12719i;
import p637j0.p642l.p647e.p648n.C12728e;
import p637j0.p652o.C12774l;
import p637j0.p655r.C12785a;
import p637j0.p655r.C12787c;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.exceptions.CompositeException;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.y1 */
/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12689y1<T> implements Observable.InterfaceC13006b<T, Observable<? extends T>> {

    /* JADX INFO: renamed from: j */
    public final boolean f27125j;

    /* JADX INFO: renamed from: j0.l.a.y1$a */
    /* JADX INFO: compiled from: OperatorSwitch.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final C12689y1<Object> f27126a = new C12689y1<>(false);
    }

    /* JADX INFO: renamed from: j0.l.a.y1$b */
    /* JADX INFO: compiled from: OperatorSwitch.java */
    public static final class b<T> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final long f27127j;

        /* JADX INFO: renamed from: k */
        public final c<T> f27128k;

        public b(long j, c<T> cVar) {
            this.f27127j = j;
            this.f27128k = cVar;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            c<T> cVar = this.f27128k;
            long j = this.f27127j;
            synchronized (cVar) {
                if (cVar.f27133n.get() != j) {
                    return;
                }
                cVar.f27141v = false;
                cVar.f27138s = null;
                cVar.m10791b();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            boolean zM10792c;
            c<T> cVar = this.f27128k;
            long j = this.f27127j;
            synchronized (cVar) {
                if (cVar.f27133n.get() == j) {
                    zM10792c = cVar.m10792c(th);
                    cVar.f27141v = false;
                    cVar.f27138s = null;
                } else {
                    zM10792c = true;
                }
            }
            if (zM10792c) {
                cVar.m10791b();
            } else {
                C12774l.m10863b(th);
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to j0.l.a.y1$b<T> for r6v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // p637j0.InterfaceC12581g
        public void onNext(T r7) {
            /*
                r6 = this;
                j0.l.a.y1$c<T> r0 = r6.f27128k
                monitor-enter(r0)
                java.util.concurrent.atomic.AtomicLong r1 = r0.f27133n     // Catch: java.lang.Throwable -> L1f
                long r1 = r1.get()     // Catch: java.lang.Throwable -> L1f
                long r3 = r6.f27127j     // Catch: java.lang.Throwable -> L1f
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L11
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L1f
                goto L1e
            L11:
                j0.l.e.n.e<java.lang.Object> r1 = r0.f27134o     // Catch: java.lang.Throwable -> L1f
                if (r7 != 0) goto L17
                java.lang.Object r7 = p637j0.p642l.p643a.C12614e.f26769b     // Catch: java.lang.Throwable -> L1f
            L17:
                r1.m10830e(r6, r7)     // Catch: java.lang.Throwable -> L1f
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L1f
                r0.m10791b()
            L1e:
                return
            L1f:
                r7 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L1f
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: p637j0.p642l.p643a.C12689y1.b.onNext(java.lang.Object):void");
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            c<T> cVar = this.f27128k;
            long j = this.f27127j;
            synchronized (cVar) {
                if (cVar.f27133n.get() != j) {
                    return;
                }
                long j2 = cVar.f27137r;
                cVar.f27138s = producer;
                producer.mo10704j(j2);
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.a.y1$c */
    /* JADX INFO: compiled from: OperatorSwitch.java */
    public static final class c<T> extends Subscriber<Observable<? extends T>> {

        /* JADX INFO: renamed from: j */
        public static final Throwable f27129j = new Throwable("Terminal error");

        /* JADX INFO: renamed from: k */
        public final Subscriber<? super T> f27130k;

        /* JADX INFO: renamed from: m */
        public final boolean f27132m;

        /* JADX INFO: renamed from: p */
        public boolean f27135p;

        /* JADX INFO: renamed from: q */
        public boolean f27136q;

        /* JADX INFO: renamed from: r */
        public long f27137r;

        /* JADX INFO: renamed from: s */
        public Producer f27138s;

        /* JADX INFO: renamed from: t */
        public volatile boolean f27139t;

        /* JADX INFO: renamed from: u */
        public Throwable f27140u;

        /* JADX INFO: renamed from: v */
        public boolean f27141v;

        /* JADX INFO: renamed from: l */
        public final SerialSubscription f27131l = new SerialSubscription();

        /* JADX INFO: renamed from: n */
        public final AtomicLong f27133n = new AtomicLong();

        /* JADX INFO: renamed from: o */
        public final C12728e<Object> f27134o = new C12728e<>(C12719i.f27283j);

        public c(Subscriber<? super T> subscriber, boolean z2) {
            this.f27130k = subscriber;
            this.f27132m = z2;
        }

        /* JADX INFO: renamed from: a */
        public boolean m10790a(boolean z2, boolean z3, Throwable th, C12728e<Object> c12728e, Subscriber<? super T> subscriber, boolean z4) {
            if (this.f27132m) {
                if (!z2 || z3 || !z4) {
                    return false;
                }
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onCompleted();
                }
                return true;
            }
            if (th != null) {
                c12728e.clear();
                subscriber.onError(th);
                return true;
            }
            if (!z2 || z3 || !z4) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        /* JADX INFO: renamed from: b */
        public void m10791b() {
            Throwable th;
            Throwable th2;
            synchronized (this) {
                if (this.f27135p) {
                    this.f27136q = true;
                    return;
                }
                this.f27135p = true;
                boolean z2 = this.f27141v;
                long j = this.f27137r;
                Throwable th3 = this.f27140u;
                if (th3 != null && th3 != (th2 = f27129j) && !this.f27132m) {
                    this.f27140u = th2;
                }
                C12728e<Object> c12728e = this.f27134o;
                AtomicLong atomicLong = this.f27133n;
                Subscriber<? super T> subscriber = this.f27130k;
                long j2 = j;
                Throwable th4 = th3;
                boolean z3 = this.f27139t;
                while (true) {
                    long j3 = 0;
                    while (j3 != j2) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        boolean zIsEmpty = c12728e.isEmpty();
                        if (m10790a(z3, z2, th4, c12728e, subscriber, zIsEmpty)) {
                            return;
                        }
                        if (zIsEmpty) {
                            break;
                        }
                        b bVar = (b) c12728e.poll();
                        R.anim animVar = (Object) C12614e.m10745b(c12728e.poll());
                        if (atomicLong.get() == bVar.f27127j) {
                            subscriber.onNext(animVar);
                            j3++;
                        }
                    }
                    if (j3 == j2) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        if (m10790a(this.f27139t, z2, th4, c12728e, subscriber, c12728e.isEmpty())) {
                            return;
                        }
                    }
                    synchronized (this) {
                        long j4 = this.f27137r;
                        if (j4 != RecyclerView.FOREVER_NS) {
                            j4 -= j3;
                            this.f27137r = j4;
                        }
                        j2 = j4;
                        if (!this.f27136q) {
                            this.f27135p = false;
                            return;
                        }
                        this.f27136q = false;
                        z3 = this.f27139t;
                        z2 = this.f27141v;
                        th4 = this.f27140u;
                        if (th4 != null && th4 != (th = f27129j) && !this.f27132m) {
                            this.f27140u = th;
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: c */
        public boolean m10792c(Throwable th) {
            Throwable th2 = this.f27140u;
            if (th2 == f27129j) {
                return false;
            }
            if (th2 == null) {
                this.f27140u = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).m11122b());
                arrayList.add(th);
                this.f27140u = new CompositeException(arrayList);
            } else {
                this.f27140u = new CompositeException(th2, th);
            }
            return true;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            this.f27139t = true;
            m10791b();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            boolean zM10792c;
            synchronized (this) {
                zM10792c = m10792c(th);
            }
            if (!zM10792c) {
                C12774l.m10863b(th);
            } else {
                this.f27139t = true;
                m10791b();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(Object obj) {
            b bVar;
            Observable observable = (Observable) obj;
            long jIncrementAndGet = this.f27133n.incrementAndGet();
            Subscription subscription = this.f27131l.f27657j.get();
            if (subscription == EnumC12710b.INSTANCE) {
                subscription = C12787c.f27422a;
            }
            if (subscription != null) {
                subscription.unsubscribe();
            }
            synchronized (this) {
                bVar = new b(jIncrementAndGet, this);
                this.f27141v = true;
                this.f27138s = null;
            }
            this.f27131l.m11139a(bVar);
            observable.m11107i0(bVar);
        }
    }

    public C12689y1(boolean z2) {
        this.f27125j = z2;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        c cVar = new c(subscriber, this.f27125j);
        subscriber.add(cVar);
        cVar.f27130k.add(cVar.f27131l);
        cVar.f27130k.add(new C12785a(new C12692z1(cVar)));
        cVar.f27130k.setProducer(new C12601a2(cVar));
        return cVar;
    }
}
