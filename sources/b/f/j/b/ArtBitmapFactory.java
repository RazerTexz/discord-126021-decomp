package b.f.j.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import b.c.a.a0.AnimatableValueParser;
import b.f.j.e.CloseableReferenceFactory;
import b.f.j.l.BitmapPool;
import b.f.k.BitmapUtil;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* JADX INFO: renamed from: b.f.j.b.a, reason: use source file name */
/* JADX INFO: compiled from: ArtBitmapFactory.java */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class ArtBitmapFactory extends PlatformBitmapFactory {
    public final BitmapPool a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CloseableReferenceFactory f552b;

    public ArtBitmapFactory(BitmapPool bitmapPool, CloseableReferenceFactory closeableReferenceFactory) {
        this.a = bitmapPool;
        this.f552b = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> b(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap = this.a.get(BitmapUtil.c(i, i2, config));
        AnimatableValueParser.i(Boolean.valueOf(bitmap.getAllocationByteCount() >= BitmapUtil.b(config) * (i * i2)));
        bitmap.reconfigure(i, i2, config);
        return CloseableReference.H(bitmap, this.a, this.f552b.a);
    }
}
