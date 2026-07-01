package b.f.j.p;

import b.f.j.r.FrescoSystrace;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.p.f1, reason: use source file name */
/* JADX INFO: compiled from: ThreadHandoffProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class ThreadHandoffProducer<T> implements Producer2<T> {
    public final Producer2<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadHandoffProducerQueue f610b;

    /* JADX INFO: renamed from: b.f.j.p.f1$a */
    /* JADX INFO: compiled from: ThreadHandoffProducer.java */
    public class a extends StatefulProducerRunnable<T> {
        public final /* synthetic */ ProducerListener2 o;
        public final /* synthetic */ ProducerContext p;
        public final /* synthetic */ Consumer2 q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer2 consumer2, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ProducerListener2 producerListener3, ProducerContext producerContext2, Consumer2 consumer3) {
            super(consumer2, producerListener2, producerContext, str);
            this.o = producerListener3;
            this.p = producerContext2;
            this.q = consumer3;
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public void b(T t) {
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public T d() throws Exception {
            return null;
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public void g(T t) {
            this.o.j(this.p, "BackgroundThreadHandoffProducer", null);
            ThreadHandoffProducer.this.a.b(this.q, this.p);
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.f1$b */
    /* JADX INFO: compiled from: ThreadHandoffProducer.java */
    public class b extends BaseProducerContextCallbacks {
        public final /* synthetic */ StatefulProducerRunnable a;

        public b(StatefulProducerRunnable statefulProducerRunnable) {
            this.a = statefulProducerRunnable;
        }

        @Override // b.f.j.p.ProducerContextCallbacks
        public void a() {
            this.a.a();
            ThreadHandoffProducerQueue threadHandoffProducerQueue = ThreadHandoffProducer.this.f610b;
            StatefulProducerRunnable statefulProducerRunnable = this.a;
            ThreadHandoffProducerQueueImpl threadHandoffProducerQueueImpl = (ThreadHandoffProducerQueueImpl) threadHandoffProducerQueue;
            synchronized (threadHandoffProducerQueueImpl) {
                threadHandoffProducerQueueImpl.a.remove(statefulProducerRunnable);
            }
        }
    }

    public ThreadHandoffProducer(Producer2<T> producer2, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        Objects.requireNonNull(producer2);
        this.a = producer2;
        this.f610b = threadHandoffProducerQueue;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<T> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.b();
            ProducerListener2 producerListener2O = producerContext.o();
            Objects.requireNonNull(producerContext.g().getExperiments());
            a aVar = new a(consumer2, producerListener2O, producerContext, "BackgroundThreadHandoffProducer", producerListener2O, producerContext, consumer2);
            producerContext.f(new b(aVar));
            ThreadHandoffProducerQueueImpl threadHandoffProducerQueueImpl = (ThreadHandoffProducerQueueImpl) this.f610b;
            synchronized (threadHandoffProducerQueueImpl) {
                threadHandoffProducerQueueImpl.f614b.execute(aVar);
            }
            FrescoSystrace.b();
        } catch (Throwable th) {
            FrescoSystrace.b();
            throw th;
        }
    }
}
