package b.f.j.p;

import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.l.TriState;
import b.f.j.d.Priority2;
import b.f.j.r.FrescoSystrace;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: renamed from: b.f.j.p.l0, reason: use source file name */
/* JADX INFO: compiled from: MultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MultiplexProducer<K, T extends Closeable> implements Producer2<T> {

    @VisibleForTesting
    public final Map<K, MultiplexProducer<K, T>.b> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Producer2<T> f622b;
    public final boolean c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: b.f.j.p.l0$b */
    /* JADX INFO: compiled from: MultiplexProducer.java */
    @VisibleForTesting
    public class b {
        public final K a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArraySet<Pair<Consumer2<T>, ProducerContext>> f623b = new CopyOnWriteArraySet<>();
        public T c;
        public float d;
        public int e;
        public BaseProducerContext f;
        public MultiplexProducer<K, T>.b.a g;

        /* JADX INFO: renamed from: b.f.j.p.l0$b$a */
        /* JADX INFO: compiled from: MultiplexProducer.java */
        public class a extends BaseConsumer<T> {
            public a(a aVar) {
            }

            @Override // b.f.j.p.BaseConsumer
            public void g() {
                try {
                    FrescoSystrace.b();
                    b bVar = b.this;
                    synchronized (bVar) {
                        if (bVar.g == this) {
                            bVar.g = null;
                            bVar.f = null;
                            bVar.b(bVar.c);
                            bVar.c = null;
                            bVar.i(TriState.UNSET);
                        }
                    }
                    FrescoSystrace.b();
                } catch (Throwable th) {
                    FrescoSystrace.b();
                    throw th;
                }
            }

            @Override // b.f.j.p.BaseConsumer
            public void h(Throwable th) {
                try {
                    FrescoSystrace.b();
                    b.this.f(this, th);
                } finally {
                    FrescoSystrace.b();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
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
            @Override // b.f.j.p.BaseConsumer
            public void i(Object obj, int i) {
                Closeable closeable = (Closeable) obj;
                try {
                    FrescoSystrace.b();
                    b.this.g(this, closeable, i);
                } finally {
                    FrescoSystrace.b();
                }
            }

            @Override // b.f.j.p.BaseConsumer
            public void j(float f) {
                try {
                    FrescoSystrace.b();
                    b.this.h(this, f);
                } finally {
                    FrescoSystrace.b();
                }
            }
        }

        public b(K k) {
            this.a = k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(Consumer2<T> consumer2, ProducerContext producerContext) {
            MultiplexProducer<K, T>.b bVar;
            Pair<Consumer2<T>, ProducerContext> pairCreate = Pair.create(consumer2, producerContext);
            synchronized (this) {
                MultiplexProducer multiplexProducer = MultiplexProducer.this;
                K k = this.a;
                synchronized (multiplexProducer) {
                    bVar = multiplexProducer.a.get(k);
                }
                if (bVar != this) {
                    return false;
                }
                this.f623b.add(pairCreate);
                List<ProducerContextCallbacks> listK = k();
                List<ProducerContextCallbacks> listL = l();
                List<ProducerContextCallbacks> listJ = j();
                Closeable closeableC = this.c;
                float f = this.d;
                int i = this.e;
                BaseProducerContext.s(listK);
                BaseProducerContext.t(listL);
                BaseProducerContext.r(listJ);
                synchronized (pairCreate) {
                    synchronized (this) {
                        if (closeableC != this.c) {
                            closeableC = null;
                        } else if (closeableC != null) {
                            closeableC = MultiplexProducer.this.c(closeableC);
                        }
                    }
                    if (closeableC != null) {
                        if (f > 0.0f) {
                            consumer2.a(f);
                        }
                        consumer2.b(closeableC, i);
                        b(closeableC);
                    }
                }
                producerContext.f(new MultiplexProducer2(this, pairCreate));
                return true;
            }
        }

        public final void b(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public final synchronized boolean c() {
            Iterator<Pair<Consumer2<T>, ProducerContext>> it = this.f623b.iterator();
            while (it.hasNext()) {
                if (((ProducerContext) it.next().second).p()) {
                    return true;
                }
            }
            return false;
        }

        public final synchronized boolean d() {
            Iterator<Pair<Consumer2<T>, ProducerContext>> it = this.f623b.iterator();
            while (it.hasNext()) {
                if (!((ProducerContext) it.next().second).k()) {
                    return false;
                }
            }
            return true;
        }

        public final synchronized Priority2 e() {
            Priority2 priority2;
            priority2 = Priority2.LOW;
            Iterator<Pair<Consumer2<T>, ProducerContext>> it = this.f623b.iterator();
            while (it.hasNext()) {
                Priority2 priority2C = ((ProducerContext) it.next().second).c();
                if (priority2.ordinal() <= priority2C.ordinal()) {
                    priority2 = priority2C;
                }
            }
            return priority2;
        }

        public void f(MultiplexProducer<K, T>.b.a aVar, Throwable th) {
            synchronized (this) {
                if (this.g != aVar) {
                    return;
                }
                this.f623b.clear();
                MultiplexProducer.this.e(this.a, this);
                b(this.c);
                this.c = null;
                for (Pair<Consumer2<T>, ProducerContext> pair : this.f623b) {
                    synchronized (pair) {
                        ((ProducerContext) pair.second).o().k((ProducerContext) pair.second, MultiplexProducer.this.d, th, null);
                        ((Consumer2) pair.first).c(th);
                    }
                }
            }
        }

        public void g(MultiplexProducer<K, T>.b.a aVar, T t, int i) {
            synchronized (this) {
                if (this.g != aVar) {
                    return;
                }
                b(this.c);
                this.c = null;
                int size = this.f623b.size();
                if (BaseConsumer.f(i)) {
                    this.c = (T) MultiplexProducer.this.c(t);
                    this.e = i;
                } else {
                    this.f623b.clear();
                    MultiplexProducer.this.e(this.a, this);
                }
                for (Pair<Consumer2<T>, ProducerContext> pair : this.f623b) {
                    synchronized (pair) {
                        if (BaseConsumer.e(i)) {
                            ((ProducerContext) pair.second).o().j((ProducerContext) pair.second, MultiplexProducer.this.d, null);
                            BaseProducerContext baseProducerContext = this.f;
                            if (baseProducerContext != null) {
                                ((ProducerContext) pair.second).j(baseProducerContext.h);
                            }
                            ((ProducerContext) pair.second).d(MultiplexProducer.this.e, Integer.valueOf(size));
                        }
                        ((Consumer2) pair.first).b(t, i);
                    }
                }
            }
        }

        public void h(MultiplexProducer<K, T>.b.a aVar, float f) {
            synchronized (this) {
                if (this.g != aVar) {
                    return;
                }
                this.d = f;
                for (Pair<Consumer2<T>, ProducerContext> pair : this.f623b) {
                    synchronized (pair) {
                        ((Consumer2) pair.first).a(f);
                    }
                }
            }
        }

        public final void i(TriState triState) {
            synchronized (this) {
                boolean z2 = true;
                AnimatableValueParser.i(Boolean.valueOf(this.f == null));
                AnimatableValueParser.i(Boolean.valueOf(this.g == null));
                if (this.f623b.isEmpty()) {
                    MultiplexProducer.this.e(this.a, this);
                    return;
                }
                ProducerContext producerContext = (ProducerContext) this.f623b.iterator().next().second;
                BaseProducerContext baseProducerContext = new BaseProducerContext(producerContext.e(), producerContext.getId(), null, producerContext.o(), producerContext.b(), producerContext.q(), d(), c(), e(), producerContext.g());
                this.f = baseProducerContext;
                baseProducerContext.j(producerContext.a());
                Objects.requireNonNull(triState);
                if (triState != TriState.UNSET) {
                    BaseProducerContext baseProducerContext2 = this.f;
                    int iOrdinal = triState.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal != 1) {
                            if (iOrdinal == 2) {
                                throw new IllegalStateException("No boolean equivalent for UNSET");
                            }
                            throw new IllegalStateException("Unrecognized TriState value: " + triState);
                        }
                        z2 = false;
                    }
                    baseProducerContext2.d("started_as_prefetch", Boolean.valueOf(z2));
                }
                MultiplexProducer<K, T>.b.a aVar = new a(null);
                this.g = aVar;
                MultiplexProducer.this.f622b.b(aVar, this.f);
            }
        }

        public final synchronized List<ProducerContextCallbacks> j() {
            BaseProducerContext baseProducerContext = this.f;
            ArrayList arrayList = null;
            if (baseProducerContext == null) {
                return null;
            }
            boolean zC = c();
            synchronized (baseProducerContext) {
                if (zC != baseProducerContext.k) {
                    baseProducerContext.k = zC;
                    arrayList = new ArrayList(baseProducerContext.m);
                }
            }
            return arrayList;
        }

        public final synchronized List<ProducerContextCallbacks> k() {
            BaseProducerContext baseProducerContext = this.f;
            ArrayList arrayList = null;
            if (baseProducerContext == null) {
                return null;
            }
            boolean zD = d();
            synchronized (baseProducerContext) {
                if (zD != baseProducerContext.i) {
                    baseProducerContext.i = zD;
                    arrayList = new ArrayList(baseProducerContext.m);
                }
            }
            return arrayList;
        }

        public final synchronized List<ProducerContextCallbacks> l() {
            BaseProducerContext baseProducerContext = this.f;
            if (baseProducerContext == null) {
                return null;
            }
            return baseProducerContext.v(e());
        }
    }

    public MultiplexProducer(Producer2<T> producer2, String str, String str2) {
        this.f622b = producer2;
        this.a = new HashMap();
        this.c = false;
        this.d = str;
        this.e = str2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<T> consumer2, ProducerContext producerContext) {
        boolean z2;
        MultiplexProducer<K, T>.b bVar;
        try {
            FrescoSystrace.b();
            producerContext.o().e(producerContext, this.d);
            K kD = d(producerContext);
            do {
                z2 = false;
                synchronized (this) {
                    synchronized (this) {
                        bVar = this.a.get(kD);
                    }
                }
                if (bVar == null) {
                    synchronized (this) {
                        bVar = new b(kD);
                        this.a.put(kD, bVar);
                        z2 = true;
                    }
                }
            } while (!bVar.a(consumer2, producerContext));
            if (z2) {
                bVar.i(TriState.f(producerContext.k()));
            }
            FrescoSystrace.b();
        } catch (Throwable th) {
            FrescoSystrace.b();
            throw th;
        }
    }

    public abstract T c(T t);

    public abstract K d(ProducerContext producerContext);

    public synchronized void e(K k, MultiplexProducer<K, T>.b bVar) {
        if (this.a.get(k) == bVar) {
            this.a.remove(k);
        }
    }

    public MultiplexProducer(Producer2<T> producer2, String str, String str2, boolean z2) {
        this.f622b = producer2;
        this.a = new HashMap();
        this.c = z2;
        this.d = str;
        this.e = str2;
    }
}
