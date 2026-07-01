package b.f.j.p;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.ParcelFileDescriptor;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: LocalVideoThumbnailProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class k0$a extends e1<CloseableReference<b.f.j.j.c>> {
    public final /* synthetic */ z0 o;
    public final /* synthetic */ x0 p;
    public final /* synthetic */ ImageRequest q;
    public final /* synthetic */ k0 r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0$a(k0 k0Var, l lVar, z0 z0Var, x0 x0Var, String str, z0 z0Var2, x0 x0Var2, ImageRequest imageRequest) {
        super(lVar, z0Var, x0Var, str);
        this.r = k0Var;
        this.o = z0Var2;
        this.p = x0Var2;
        this.q = imageRequest;
    }

    @Override // b.f.j.p.e1
    public void b(CloseableReference<b.f.j.j.c> closeableReference) {
        CloseableReference<b.f.j.j.c> closeableReference2 = closeableReference;
        Class<CloseableReference> cls = CloseableReference.j;
        if (closeableReference2 != null) {
            closeableReference2.close();
        }
    }

    @Override // b.f.j.p.e1
    public Map c(CloseableReference<b.f.j.j.c> closeableReference) {
        return b.f.d.d.f.of("createdThumbnail", String.valueOf(closeableReference != null));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0027  */
    @Override // b.f.j.p.e1
    public CloseableReference<b.f.j.j.c> d() throws Exception {
        String strC;
        Bitmap frameAtTime;
        int i;
        try {
            strC = k0.c(this.r, this.q);
        } catch (IllegalArgumentException unused) {
            strC = null;
        }
        if (strC != null) {
            b.f.j.d.e eVar = this.q.j;
            if ((eVar != null ? eVar.a : 2048) > 96) {
                i = 1;
            } else {
                if ((eVar != null ? eVar.f566b : 2048) > 96) {
                    i = 1;
                } else {
                    i = 3;
                }
            }
            frameAtTime = ThumbnailUtils.createVideoThumbnail(strC, i);
        } else {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.r.f621b.openFileDescriptor(this.q.c, "r");
                Objects.requireNonNull(parcelFileDescriptorOpenFileDescriptor);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
            } catch (FileNotFoundException unused2) {
                frameAtTime = null;
            }
        }
        if (frameAtTime == null) {
            return null;
        }
        b.f.j.j.d dVar = new b.f.j.j.d(frameAtTime, b.f.j.b.b.a(), b.f.j.j.h.a, 0);
        this.p.d("image_format", "thumbnail");
        dVar.e(this.p.a());
        return CloseableReference.A(dVar);
    }

    @Override // b.f.j.p.e1
    public void f(Exception exc) {
        super.f(exc);
        this.o.c(this.p, "VideoThumbnailProducer", false);
        this.p.n("local");
    }

    @Override // b.f.j.p.e1
    public void g(CloseableReference<b.f.j.j.c> closeableReference) {
        CloseableReference<b.f.j.j.c> closeableReference2 = closeableReference;
        super.g(closeableReference2);
        this.o.c(this.p, "VideoThumbnailProducer", closeableReference2 != null);
        this.p.n("local");
    }
}
