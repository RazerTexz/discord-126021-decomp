package b.f.j.p;

import b.f.j.j.CloseableImage;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: b.f.j.p.o, reason: use source file name */
/* JADX INFO: compiled from: DelayProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class DelayProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final Producer2<CloseableReference<CloseableImage>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f631b;

    /* JADX INFO: renamed from: b.f.j.p.o$a */
    /* JADX INFO: compiled from: DelayProducer.java */
    public class a implements Runnable {
        public final /* synthetic */ Consumer2 j;
        public final /* synthetic */ ProducerContext k;

        public a(Consumer2 consumer2, ProducerContext producerContext) {
            this.j = consumer2;
            this.k = producerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            DelayProducer.this.a.b(this.j, this.k);
        }
    }

    public DelayProducer(Producer2<CloseableReference<CloseableImage>> producer2, ScheduledExecutorService scheduledExecutorService) {
        this.a = producer2;
        this.f631b = scheduledExecutorService;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        ImageRequest imageRequestE = producerContext.e();
        ScheduledExecutorService scheduledExecutorService = this.f631b;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new a(consumer2, producerContext), imageRequestE.u, TimeUnit.MILLISECONDS);
        } else {
            this.a.b(consumer2, producerContext);
        }
    }
}
