package b.f.j.j;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* JADX INFO: compiled from: CloseableStaticBitmap.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends b implements b.f.d.h.c {
    public CloseableReference<Bitmap> l;
    public volatile Bitmap m;
    public final i n;
    public final int o;
    public final int p;

    public d(Bitmap bitmap, b.f.d.h.f<Bitmap> fVar, i iVar, int i) {
        this.m = bitmap;
        Bitmap bitmap2 = this.m;
        Objects.requireNonNull(fVar);
        this.l = CloseableReference.D(bitmap2, fVar);
        this.n = iVar;
        this.o = i;
        this.p = 0;
    }

    @Override // b.f.j.j.c
    public i b() {
        return this.n;
    }

    @Override // b.f.j.j.c
    public int c() {
        return b.f.k.a.d(this.m);
    }

    @Override // b.f.j.j.c, java.io.Closeable, java.lang.AutoCloseable
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

    @Override // b.f.j.j.b
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

    @Override // b.f.j.j.c
    public synchronized boolean isClosed() {
        return this.l == null;
    }

    public d(CloseableReference<Bitmap> closeableReference, i iVar, int i, int i2) {
        CloseableReference<Bitmap> closeableReferenceF = closeableReference.f();
        Objects.requireNonNull(closeableReferenceF);
        this.l = closeableReferenceF;
        this.m = closeableReferenceF.u();
        this.n = iVar;
        this.o = i;
        this.p = i2;
    }
}
