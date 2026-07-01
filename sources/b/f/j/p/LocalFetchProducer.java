package b.f.j.p;

import b.f.d.d.Closeables;
import b.f.d.g.PooledByteBufferFactory;
import b.f.j.j.EncodedImage2;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.g0, reason: use source file name */
/* JADX INFO: compiled from: LocalFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LocalFetchProducer implements Producer2<EncodedImage2> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f612b;

    /* JADX INFO: renamed from: b.f.j.p.g0$a */
    /* JADX INFO: compiled from: LocalFetchProducer.java */
    public class a extends StatefulProducerRunnable<EncodedImage2> {
        public final /* synthetic */ ImageRequest o;
        public final /* synthetic */ ProducerListener2 p;
        public final /* synthetic */ ProducerContext q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer2 consumer2, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ImageRequest imageRequest, ProducerListener2 producerListener3, ProducerContext producerContext2) {
            super(consumer2, producerListener2, producerContext, str);
            this.o = imageRequest;
            this.p = producerListener3;
            this.q = producerContext2;
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public void b(EncodedImage2 encodedImage2) {
            EncodedImage2 encodedImage3 = encodedImage2;
            if (encodedImage3 != null) {
                encodedImage3.close();
            }
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public EncodedImage2 d() throws Exception {
            EncodedImage2 encodedImage2D = LocalFetchProducer.this.d(this.o);
            if (encodedImage2D == null) {
                this.p.c(this.q, LocalFetchProducer.this.e(), false);
                this.q.n("local");
                return null;
            }
            encodedImage2D.q();
            this.p.c(this.q, LocalFetchProducer.this.e(), true);
            this.q.n("local");
            return encodedImage2D;
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.g0$b */
    /* JADX INFO: compiled from: LocalFetchProducer.java */
    public class b extends BaseProducerContextCallbacks {
        public final /* synthetic */ StatefulProducerRunnable a;

        public b(LocalFetchProducer localFetchProducer, StatefulProducerRunnable statefulProducerRunnable) {
            this.a = statefulProducerRunnable;
        }

        @Override // b.f.j.p.ProducerContextCallbacks
        public void a() {
            this.a.a();
        }
    }

    public LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        this.a = executor;
        this.f612b = pooledByteBufferFactory;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2O = producerContext.o();
        ImageRequest imageRequestE = producerContext.e();
        producerContext.i("local", "fetch");
        a aVar = new a(consumer2, producerListener2O, producerContext, e(), imageRequestE, producerListener2O, producerContext);
        producerContext.f(new b(this, aVar));
        this.a.execute(aVar);
    }

    public EncodedImage2 c(InputStream inputStream, int i) throws IOException {
        CloseableReference closeableReferenceA = null;
        try {
            closeableReferenceA = i <= 0 ? CloseableReference.A(this.f612b.c(inputStream)) : CloseableReference.A(this.f612b.d(inputStream, i));
            EncodedImage2 encodedImage2 = new EncodedImage2(closeableReferenceA);
            Closeables.b(inputStream);
            if (closeableReferenceA != null) {
                closeableReferenceA.close();
            }
            return encodedImage2;
        } catch (Throwable th) {
            Closeables.b(inputStream);
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReferenceA != null) {
                closeableReferenceA.close();
            }
            throw th;
        }
    }

    public abstract EncodedImage2 d(ImageRequest imageRequest) throws IOException;

    public abstract String e();
}
