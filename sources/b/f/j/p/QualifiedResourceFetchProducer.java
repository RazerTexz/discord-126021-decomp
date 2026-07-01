package b.f.j.p;

import android.content.ContentResolver;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.g.PooledByteBufferFactory;
import b.f.j.j.EncodedImage2;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.b1, reason: use source file name */
/* JADX INFO: compiled from: QualifiedResourceFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class QualifiedResourceFetchProducer extends LocalFetchProducer {
    public final ContentResolver c;

    public QualifiedResourceFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.c = contentResolver;
    }

    @Override // b.f.j.p.LocalFetchProducer
    public EncodedImage2 d(ImageRequest imageRequest) throws IOException {
        InputStream inputStreamOpenInputStream = this.c.openInputStream(imageRequest.c);
        AnimatableValueParser.y(inputStreamOpenInputStream, "ContentResolver returned null InputStream");
        return c(inputStreamOpenInputStream, -1);
    }

    @Override // b.f.j.p.LocalFetchProducer
    public String e() {
        return "QualifiedResourceFetchProducer";
    }
}
