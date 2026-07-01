package b.f.j.p;

import b.f.d.g.PooledByteBufferFactory;
import b.f.j.j.EncodedImage2;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.h0, reason: use source file name */
/* JADX INFO: compiled from: LocalFileFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class LocalFileFetchProducer extends LocalFetchProducer {
    public LocalFileFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        super(executor, pooledByteBufferFactory);
    }

    @Override // b.f.j.p.LocalFetchProducer
    public EncodedImage2 d(ImageRequest imageRequest) throws IOException {
        return c(new FileInputStream(imageRequest.a().toString()), (int) imageRequest.a().length());
    }

    @Override // b.f.j.p.LocalFetchProducer
    public String e() {
        return "LocalFileFetchProducer";
    }
}
