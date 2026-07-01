package b.f.j.p;

import android.util.Pair;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.i1, reason: use source file name */
/* JADX INFO: compiled from: ThrottlingProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class ThrottlingProducer<T> implements Producer2<T> {
    public final Producer2<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f616b;
    public final ConcurrentLinkedQueue<Pair<Consumer2<T>, ProducerContext>> c;
    public final Executor d;

    /* JADX INFO: renamed from: b.f.j.p.i1$b */
    /* JADX INFO: compiled from: ThrottlingProducer.java */
    public class b extends DelegatingConsumer<T, T> {

        /* JADX INFO: renamed from: b.f.j.p.i1$b$a */
        /* JADX INFO: compiled from: ThrottlingProducer.java */
        public class a implements Runnable {
            public final /* synthetic */ Pair j;

            public a(Pair pair) {
                this.j = pair;
            }

            @Override // java.lang.Runnable
            public void run() {
                ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                Pair pair = this.j;
                Consumer2 consumer2 = (Consumer2) pair.first;
                ProducerContext producerContext = (ProducerContext) pair.second;
                Objects.requireNonNull(throttlingProducer);
                producerContext.o().j(producerContext, "ThrottlingProducer", null);
                throttlingProducer.a.b(new b(consumer2, null), producerContext);
            }
        }

        public b(Consumer2 consumer2, a aVar) {
            super(consumer2);
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void g() {
            this.f632b.d();
            n();
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void h(Throwable th) {
            this.f632b.c(th);
            n();
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
        @Override // b.f.j.p.BaseConsumer
        public void i(T r2, int r3) {
            /*
                r1 = this;
                b.f.j.p.l<O> r0 = r1.f632b
                r0.b(r2, r3)
                boolean r2 = b.f.j.p.BaseConsumer.e(r3)
                if (r2 == 0) goto Le
                r1.n()
            Le:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.ThrottlingProducer.b.i(java.lang.Object, int):void");
        }

        public final void n() {
            Pair<Consumer2<T>, ProducerContext> pairPoll;
            synchronized (ThrottlingProducer.this) {
                pairPoll = ThrottlingProducer.this.c.poll();
                if (pairPoll == null) {
                    ThrottlingProducer.this.f616b--;
                }
            }
            if (pairPoll != null) {
                ThrottlingProducer.this.d.execute(new a(pairPoll));
            }
        }
    }

    public ThrottlingProducer(int i, Executor executor, Producer2<T> producer2) {
        Objects.requireNonNull(executor);
        this.d = executor;
        Objects.requireNonNull(producer2);
        this.a = producer2;
        this.c = new ConcurrentLinkedQueue<>();
        this.f616b = 0;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<T> consumer2, ProducerContext producerContext) {
        boolean z2;
        producerContext.o().e(producerContext, "ThrottlingProducer");
        synchronized (this) {
            int i = this.f616b;
            z2 = true;
            if (i >= 5) {
                this.c.add(Pair.create(consumer2, producerContext));
            } else {
                this.f616b = i + 1;
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        producerContext.o().j(producerContext, "ThrottlingProducer", null);
        this.a.b(new b(consumer2, null), producerContext);
    }
}
