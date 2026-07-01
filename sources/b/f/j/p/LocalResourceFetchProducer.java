package b.f.j.p;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import b.f.d.g.PooledByteBufferFactory;
import b.f.j.j.EncodedImage2;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.i0, reason: use source file name */
/* JADX INFO: compiled from: LocalResourceFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class LocalResourceFetchProducer extends LocalFetchProducer {
    public final Resources c;

    public LocalResourceFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Resources resources) {
        super(executor, pooledByteBufferFactory);
        this.c = resources;
    }

    @Override // b.f.j.p.LocalFetchProducer
    public EncodedImage2 d(ImageRequest imageRequest) throws IOException {
        int length;
        Resources resources = this.c;
        String path = imageRequest.c.getPath();
        Objects.requireNonNull(path);
        InputStream inputStreamOpenRawResource = resources.openRawResource(Integer.parseInt(path.substring(1)));
        AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = null;
        try {
            try {
                Resources resources2 = this.c;
                String path2 = imageRequest.c.getPath();
                Objects.requireNonNull(path2);
                assetFileDescriptorOpenRawResourceFd = resources2.openRawResourceFd(Integer.parseInt(path2.substring(1)));
                length = (int) assetFileDescriptorOpenRawResourceFd.getLength();
            } catch (Resources.NotFoundException unused) {
                length = -1;
                if (assetFileDescriptorOpenRawResourceFd != null) {
                }
                return c(inputStreamOpenRawResource, length);
            } catch (Throwable th) {
                if (assetFileDescriptorOpenRawResourceFd != null) {
                    try {
                        assetFileDescriptorOpenRawResourceFd.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
            assetFileDescriptorOpenRawResourceFd.close();
        } catch (IOException unused3) {
        }
        return c(inputStreamOpenRawResource, length);
    }

    @Override // b.f.j.p.LocalFetchProducer
    public String e() {
        return "LocalResourceFetchProducer";
    }
}
