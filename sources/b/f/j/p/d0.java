package b.f.j.p;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: LocalAssetFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class d0 extends g0 {
    public final AssetManager c;

    public d0(Executor executor, b.f.d.g.g gVar, AssetManager assetManager) {
        super(executor, gVar);
        this.c = assetManager;
    }

    @Override // b.f.j.p.g0
    public b.f.j.j.e d(ImageRequest imageRequest) throws IOException {
        int length;
        InputStream inputStreamOpen = this.c.open(imageRequest.c.getPath().substring(1), 2);
        AssetFileDescriptor assetFileDescriptorOpenFd = null;
        try {
            try {
                assetFileDescriptorOpenFd = this.c.openFd(imageRequest.c.getPath().substring(1));
                length = (int) assetFileDescriptorOpenFd.getLength();
            } catch (IOException unused) {
                length = -1;
                if (assetFileDescriptorOpenFd != null) {
                }
                return c(inputStreamOpen, length);
            } catch (Throwable th) {
                if (assetFileDescriptorOpenFd != null) {
                    try {
                        assetFileDescriptorOpenFd.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
            assetFileDescriptorOpenFd.close();
        } catch (IOException unused3) {
        }
        return c(inputStreamOpen, length);
    }

    @Override // b.f.j.p.g0
    public String e() {
        return "LocalAssetFetchProducer";
    }
}
