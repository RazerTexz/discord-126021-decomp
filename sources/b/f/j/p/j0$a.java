package b.f.j.p;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Size;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;

/* JADX INFO: compiled from: LocalThumbnailBitmapProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class j0$a extends e1<CloseableReference<b.f.j.j.c>> {
    public final /* synthetic */ z0 o;
    public final /* synthetic */ x0 p;
    public final /* synthetic */ ImageRequest q;
    public final /* synthetic */ CancellationSignal r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ j0 f619s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0$a(j0 j0Var, l lVar, z0 z0Var, x0 x0Var, String str, z0 z0Var2, x0 x0Var2, ImageRequest imageRequest, CancellationSignal cancellationSignal) {
        super(lVar, z0Var, x0Var, str);
        this.f619s = j0Var;
        this.o = z0Var2;
        this.p = x0Var2;
        this.q = imageRequest;
        this.r = cancellationSignal;
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

    @Override // b.f.j.p.e1
    public CloseableReference<b.f.j.j.c> d() throws Exception {
        ContentResolver contentResolver = this.f619s.f618b;
        Uri uri = this.q.c;
        b.f.j.d.e eVar = this.q.j;
        Bitmap bitmapLoadThumbnail = contentResolver.loadThumbnail(uri, new Size(eVar != null ? eVar.a : 2048, eVar != null ? eVar.f566b : 2048), this.r);
        if (bitmapLoadThumbnail == null) {
            return null;
        }
        b.f.j.j.d dVar = new b.f.j.j.d(bitmapLoadThumbnail, b.f.j.b.b.a(), b.f.j.j.h.a, 0);
        this.p.d("image_format", "thumbnail");
        dVar.e(this.p.a());
        return CloseableReference.A(dVar);
    }

    @Override // b.f.j.p.e1
    public void e() {
        super.e();
        this.r.cancel();
    }

    @Override // b.f.j.p.e1
    public void f(Exception exc) {
        super.f(exc);
        this.o.c(this.p, "LocalThumbnailBitmapProducer", false);
        this.p.n("local");
    }

    @Override // b.f.j.p.e1
    public void g(CloseableReference<b.f.j.j.c> closeableReference) {
        CloseableReference<b.f.j.j.c> closeableReference2 = closeableReference;
        super.g(closeableReference2);
        this.o.c(this.p, "LocalThumbnailBitmapProducer", closeableReference2 != null);
        this.p.n("local");
    }
}
