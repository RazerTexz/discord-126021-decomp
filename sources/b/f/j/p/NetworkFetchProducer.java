package b.f.j.p;

import android.os.SystemClock;
import b.f.d.g.ByteArrayPool;
import b.f.d.g.PooledByteBufferFactory;
import b.f.d.g.PooledByteBufferOutputStream;
import b.f.j.d.BytesRange;
import b.f.j.j.EncodedImage2;
import b.f.j.j.EncodedImageOrigin;
import b.f.j.p.HttpUrlConnectionNetworkFetcher;
import b.f.j.p.NetworkFetcher2;
import b.f.j.r.FrescoSystrace;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.p.n0, reason: use source file name */
/* JADX INFO: compiled from: NetworkFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class NetworkFetchProducer implements Producer2<EncodedImage2> {
    public final PooledByteBufferFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteArrayPool f629b;
    public final NetworkFetcher2 c;

    /* JADX INFO: renamed from: b.f.j.p.n0$a */
    /* JADX INFO: compiled from: NetworkFetchProducer.java */
    public class a implements NetworkFetcher2.a {
        public final /* synthetic */ FetchState2 a;

        public a(FetchState2 fetchState2) {
            this.a = fetchState2;
        }

        public void a(Throwable th) {
            NetworkFetchProducer networkFetchProducer = NetworkFetchProducer.this;
            FetchState2 fetchState2 = this.a;
            Objects.requireNonNull(networkFetchProducer);
            fetchState2.a().k(fetchState2.f642b, "NetworkFetchProducer", th, null);
            fetchState2.a().c(fetchState2.f642b, "NetworkFetchProducer", false);
            fetchState2.f642b.n("network");
            fetchState2.a.c(th);
        }

        public void b(InputStream inputStream, int i) throws Throwable {
            FrescoSystrace.b();
            NetworkFetchProducer networkFetchProducer = NetworkFetchProducer.this;
            FetchState2 fetchState2 = this.a;
            PooledByteBufferOutputStream pooledByteBufferOutputStreamE = i > 0 ? networkFetchProducer.a.e(i) : networkFetchProducer.a.a();
            byte[] bArr = networkFetchProducer.f629b.get(16384);
            while (true) {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 < 0) {
                        NetworkFetcher2 networkFetcher2 = networkFetchProducer.c;
                        int i3 = ((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStreamE).l;
                        HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher = (HttpUrlConnectionNetworkFetcher) networkFetcher2;
                        Objects.requireNonNull(httpUrlConnectionNetworkFetcher);
                        ((HttpUrlConnectionNetworkFetcher.a) fetchState2).f = httpUrlConnectionNetworkFetcher.c.now();
                        networkFetchProducer.c(pooledByteBufferOutputStreamE, fetchState2);
                        networkFetchProducer.f629b.release(bArr);
                        pooledByteBufferOutputStreamE.close();
                        FrescoSystrace.b();
                        return;
                    }
                    if (i2 > 0) {
                        pooledByteBufferOutputStreamE.write(bArr, 0, i2);
                        networkFetchProducer.d(pooledByteBufferOutputStreamE, fetchState2);
                        int i4 = ((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStreamE).l;
                        fetchState2.a.a(i > 0 ? i4 / i : 1.0f - ((float) Math.exp(((double) (-i4)) / 50000.0d)));
                    }
                } catch (Throwable th) {
                    networkFetchProducer.f629b.release(bArr);
                    pooledByteBufferOutputStreamE.close();
                    throw th;
                }
            }
        }
    }

    public NetworkFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher2 networkFetcher2) {
        this.a = pooledByteBufferFactory;
        this.f629b = byteArrayPool;
        this.c = networkFetcher2;
    }

    public static void e(PooledByteBufferOutputStream pooledByteBufferOutputStream, int i, BytesRange bytesRange, Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) throws Throwable {
        CloseableReference closeableReferenceA = CloseableReference.A(((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStream).b());
        EncodedImage2 encodedImage2 = null;
        try {
            EncodedImage2 encodedImage3 = new EncodedImage2(closeableReferenceA);
            try {
                encodedImage3.f590s = null;
                encodedImage3.q();
                producerContext.h(EncodedImageOrigin.NETWORK);
                consumer2.b(encodedImage3, i);
                encodedImage3.close();
                if (closeableReferenceA != null) {
                    closeableReferenceA.close();
                }
            } catch (Throwable th) {
                th = th;
                encodedImage2 = encodedImage3;
                if (encodedImage2 != null) {
                    encodedImage2.close();
                }
                if (closeableReferenceA != null) {
                    closeableReferenceA.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        producerContext.o().e(producerContext, "NetworkFetchProducer");
        Objects.requireNonNull((HttpUrlConnectionNetworkFetcher) this.c);
        HttpUrlConnectionNetworkFetcher.a aVar = new HttpUrlConnectionNetworkFetcher.a(consumer2, producerContext);
        NetworkFetcher2 networkFetcher2 = this.c;
        a aVar2 = new a(aVar);
        HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher = (HttpUrlConnectionNetworkFetcher) networkFetcher2;
        Objects.requireNonNull(httpUrlConnectionNetworkFetcher);
        aVar.d = httpUrlConnectionNetworkFetcher.c.now();
        producerContext.f(new HttpUrlConnectionNetworkFetcher3(httpUrlConnectionNetworkFetcher, httpUrlConnectionNetworkFetcher.f604b.submit(new HttpUrlConnectionNetworkFetcher2(httpUrlConnectionNetworkFetcher, aVar, aVar2)), aVar2));
    }

    public void c(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState2 fetchState2) throws Throwable {
        HashMap map;
        int i = ((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStream).l;
        if (fetchState2.a().g(fetchState2.f642b, "NetworkFetchProducer")) {
            Objects.requireNonNull((HttpUrlConnectionNetworkFetcher) this.c);
            HttpUrlConnectionNetworkFetcher.a aVar = (HttpUrlConnectionNetworkFetcher.a) fetchState2;
            map = new HashMap(4);
            map.put("queue_time", Long.toString(aVar.e - aVar.d));
            map.put("fetch_time", Long.toString(aVar.f - aVar.e));
            map.put("total_time", Long.toString(aVar.f - aVar.d));
            map.put("image_size", Integer.toString(i));
        } else {
            map = null;
        }
        ProducerListener2 producerListener2A = fetchState2.a();
        producerListener2A.j(fetchState2.f642b, "NetworkFetchProducer", map);
        producerListener2A.c(fetchState2.f642b, "NetworkFetchProducer", true);
        fetchState2.f642b.n("network");
        e(pooledByteBufferOutputStream, 1, null, fetchState2.a, fetchState2.f642b);
    }

    public void d(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState2 fetchState2) throws Throwable {
        boolean z2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (fetchState2.f642b.p()) {
            Objects.requireNonNull(this.c);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || jUptimeMillis - fetchState2.c < 100) {
            return;
        }
        fetchState2.c = jUptimeMillis;
        fetchState2.a().a(fetchState2.f642b, "NetworkFetchProducer", "intermediate_result");
        e(pooledByteBufferOutputStream, 0, null, fetchState2.a, fetchState2.f642b);
    }
}
