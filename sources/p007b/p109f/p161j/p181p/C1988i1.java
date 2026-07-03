package p007b.p109f.p161j.p181p;

import android.util.Pair;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.i1 */
/* JADX INFO: compiled from: ThrottlingProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1988i1<T> implements InterfaceC2018w0<T> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2018w0<T> f4082a;

    /* JADX INFO: renamed from: b */
    public int f4083b;

    /* JADX INFO: renamed from: c */
    public final ConcurrentLinkedQueue<Pair<InterfaceC1995l<T>, InterfaceC2020x0>> f4084c;

    /* JADX INFO: renamed from: d */
    public final Executor f4085d;

    /* JADX INFO: renamed from: b.f.j.p.i1$b */
    /* JADX INFO: compiled from: ThrottlingProducer.java */
    public class b extends AbstractC2003p<T, T> {

        /* JADX INFO: renamed from: b.f.j.p.i1$b$a */
        /* JADX INFO: compiled from: ThrottlingProducer.java */
        public class a implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ Pair f4087j;

            public a(Pair pair) {
                this.f4087j = pair;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1988i1 c1988i1 = C1988i1.this;
                Pair pair = this.f4087j;
                InterfaceC1995l interfaceC1995l = (InterfaceC1995l) pair.first;
                InterfaceC2020x0 interfaceC2020x0 = (InterfaceC2020x0) pair.second;
                Objects.requireNonNull(c1988i1);
                interfaceC2020x0.mo1457o().mo1363j(interfaceC2020x0, "ThrottlingProducer", null);
                c1988i1.f4082a.mo1417b(new b(interfaceC1995l, null), interfaceC2020x0);
            }
        }

        public b(InterfaceC1995l interfaceC1995l, a aVar) {
            super(interfaceC1995l);
        }

        @Override // p007b.p109f.p161j.p181p.AbstractC2003p, p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: g */
        public void mo1318g() {
            this.f4179b.mo1426d();
            m1479n();
        }

        @Override // p007b.p109f.p161j.p181p.AbstractC2003p, p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: h */
        public void mo1319h(Throwable th) {
            this.f4179b.mo1425c(th);
            m1479n();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v2 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(T r2, int r3) {
            /*
                r1 = this;
                b.f.j.p.l<O> r0 = r1.f4179b
                r0.mo1424b(r2, r3)
                boolean r2 = p007b.p109f.p161j.p181p.AbstractC1965b.m1419e(r3)
                if (r2 == 0) goto Le
                r1.m1479n()
            Le:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C1988i1.b.mo1320i(java.lang.Object, int):void");
        }

        /* JADX INFO: renamed from: n */
        public final void m1479n() {
            Pair<InterfaceC1995l<T>, InterfaceC2020x0> pairPoll;
            synchronized (C1988i1.this) {
                pairPoll = C1988i1.this.f4084c.poll();
                if (pairPoll == null) {
                    C1988i1.this.f4083b--;
                }
            }
            if (pairPoll != null) {
                C1988i1.this.f4085d.execute(new a(pairPoll));
            }
        }
    }

    public C1988i1(int i, Executor executor, InterfaceC2018w0<T> interfaceC2018w0) {
        Objects.requireNonNull(executor);
        this.f4085d = executor;
        Objects.requireNonNull(interfaceC2018w0);
        this.f4082a = interfaceC2018w0;
        this.f4084c = new ConcurrentLinkedQueue<>();
        this.f4083b = 0;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<T> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        boolean z2;
        interfaceC2020x0.mo1457o().mo1358e(interfaceC2020x0, "ThrottlingProducer");
        synchronized (this) {
            int i = this.f4083b;
            z2 = true;
            if (i >= 5) {
                this.f4084c.add(Pair.create(interfaceC1995l, interfaceC2020x0));
            } else {
                this.f4083b = i + 1;
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        interfaceC2020x0.mo1457o().mo1363j(interfaceC2020x0, "ThrottlingProducer", null);
        this.f4082a.mo1417b(new b(interfaceC1995l, null), interfaceC2020x0);
    }
}
