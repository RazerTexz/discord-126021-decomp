package b.f.j.p;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: LocalResourceFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class i0 extends g0 {
    public final Resources c;

    public i0(Executor executor, b.f.d.g.g gVar, Resources resources) {
        super(executor, gVar);
        this.c = resources;
    }

    @Override // b.f.j.p.g0
    public b.f.j.j.e d(ImageRequest imageRequest) throws IOException {
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
            } catch (Resources$NotFoundException unused) {
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

    @Override // b.f.j.p.g0
    public String e() {
        return "LocalResourceFetchProducer";
    }
}
