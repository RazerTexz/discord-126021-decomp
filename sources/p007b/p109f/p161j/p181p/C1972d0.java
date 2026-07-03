package p007b.p109f.p161j.p181p;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.d0 */
/* JADX INFO: compiled from: LocalAssetFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1972d0 extends AbstractC1981g0 {

    /* JADX INFO: renamed from: c */
    public final AssetManager f4039c;

    public C1972d0(Executor executor, InterfaceC1700g interfaceC1700g, AssetManager assetManager) {
        super(executor, interfaceC1700g);
        this.f4039c = assetManager;
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: d */
    public C1919e mo1428d(ImageRequest imageRequest) throws IOException {
        int length;
        InputStream inputStreamOpen = this.f4039c.open(imageRequest.f19585c.getPath().substring(1), 2);
        AssetFileDescriptor assetFileDescriptorOpenFd = null;
        try {
            try {
                assetFileDescriptorOpenFd = this.f4039c.openFd(imageRequest.f19585c.getPath().substring(1));
                length = (int) assetFileDescriptorOpenFd.getLength();
            } catch (IOException unused) {
                length = -1;
                if (assetFileDescriptorOpenFd != null) {
                }
                return m1478c(inputStreamOpen, length);
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
        return m1478c(inputStreamOpen, length);
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: e */
    public String mo1429e() {
        return "LocalAssetFetchProducer";
    }
}
