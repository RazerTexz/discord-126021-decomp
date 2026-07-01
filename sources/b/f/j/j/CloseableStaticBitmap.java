package b.f.j.j;

import android.graphics.Bitmap;
import b.f.d.h.HasBitmap;
import b.f.d.h.ResourceReleaser;
import b.f.k.BitmapUtil;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.j.d, reason: use source file name */
/* JADX INFO: compiled from: CloseableStaticBitmap.java */
/* JADX INFO: loaded from: classes.dex */
public class CloseableStaticBitmap extends CloseableBitmap implements HasBitmap {
    public CloseableReference<Bitmap> l;
    public volatile Bitmap m;
    public final QualityInfo n;
    public final int o;
    public final int p;

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i) {
        this.m = bitmap;
        Bitmap bitmap2 = this.m;
        Objects.requireNonNull(resourceReleaser);
        this.l = CloseableReference.D(bitmap2, resourceReleaser);
        this.n = qualityInfo;
        this.o = i;
        this.p = 0;
    }

    @Override // b.f.j.j.CloseableImage
    public QualityInfo b() {
        return this.n;
    }

    @Override // b.f.j.j.CloseableImage
    public int c() {
        return BitmapUtil.d(this.m);
    }

    @Override // b.f.j.j.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference<Bitmap> closeableReference;
        synchronized (this) {
            closeableReference = this.l;
            this.l = null;
            this.m = null;
        }
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    @Override // b.f.j.j.CloseableBitmap
    public Bitmap f() {
        return this.m;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        int i;
        if (this.o % 180 != 0 || (i = this.p) == 5 || i == 7) {
            Bitmap bitmap = this.m;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getWidth();
        }
        Bitmap bitmap2 = this.m;
        if (bitmap2 == null) {
            return 0;
        }
        return bitmap2.getHeight();
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        int i;
        if (this.o % 180 != 0 || (i = this.p) == 5 || i == 7) {
            Bitmap bitmap = this.m;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight();
        }
        Bitmap bitmap2 = this.m;
        if (bitmap2 == null) {
            return 0;
        }
        return bitmap2.getWidth();
    }

    @Override // b.f.j.j.CloseableImage
    public synchronized boolean isClosed() {
        return this.l == null;
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i, int i2) {
        CloseableReference<Bitmap> closeableReferenceF = closeableReference.f();
        Objects.requireNonNull(closeableReferenceF);
        this.l = closeableReferenceF;
        this.m = closeableReferenceF.u();
        this.n = qualityInfo;
        this.o = i;
        this.p = i2;
    }
}
