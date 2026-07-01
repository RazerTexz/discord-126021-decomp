package b.f.j.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import b.f.j.l.d;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* JADX INFO: compiled from: ArtBitmapFactory.java */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class a extends PlatformBitmapFactory {
    public final d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.j.e.a f552b;

    public a(d dVar, b.f.j.e.a aVar) {
        this.a = dVar;
        this.f552b = aVar;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> b(int i, int i2, Bitmap$Config bitmap$Config) {
        Bitmap bitmap = this.a.get(b.f.k.a.c(i, i2, bitmap$Config));
        b.c.a.a0.d.i(Boolean.valueOf(bitmap.getAllocationByteCount() >= b.f.k.a.b(bitmap$Config) * (i * i2)));
        bitmap.reconfigure(i, i2, bitmap$Config);
        return CloseableReference.H(bitmap, this.a, this.f552b.a);
    }
}
