package p007b.p109f.p161j.p181p;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.i0 */
/* JADX INFO: compiled from: LocalResourceFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1987i0 extends AbstractC1981g0 {

    /* JADX INFO: renamed from: c */
    public final Resources f4081c;

    public C1987i0(Executor executor, InterfaceC1700g interfaceC1700g, Resources resources) {
        super(executor, interfaceC1700g);
        this.f4081c = resources;
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: d */
    public C1919e mo1428d(ImageRequest imageRequest) throws IOException {
        int length;
        Resources resources = this.f4081c;
        String path = imageRequest.f19585c.getPath();
        Objects.requireNonNull(path);
        InputStream inputStreamOpenRawResource = resources.openRawResource(Integer.parseInt(path.substring(1)));
        AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = null;
        try {
            try {
                Resources resources2 = this.f4081c;
                String path2 = imageRequest.f19585c.getPath();
                Objects.requireNonNull(path2);
                assetFileDescriptorOpenRawResourceFd = resources2.openRawResourceFd(Integer.parseInt(path2.substring(1)));
                length = (int) assetFileDescriptorOpenRawResourceFd.getLength();
            } catch (Resources.NotFoundException unused) {
                length = -1;
                if (assetFileDescriptorOpenRawResourceFd != null) {
                }
                return m1478c(inputStreamOpenRawResource, length);
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
        return m1478c(inputStreamOpenRawResource, length);
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: e */
    public String mo1429e() {
        return "LocalResourceFetchProducer";
    }
}
