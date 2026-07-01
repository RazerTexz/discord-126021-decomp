package b.f.j.j;

import android.graphics.Bitmap;
import b.f.j.a.a.AnimatedImageResult;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.j.j.a, reason: use source file name */
/* JADX INFO: compiled from: CloseableAnimatedImage.java */
/* JADX INFO: loaded from: classes.dex */
public class CloseableAnimatedImage extends CloseableImage {
    public AnimatedImageResult l;
    public boolean m = true;

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult) {
        this.l = animatedImageResult;
    }

    @Override // b.f.j.j.CloseableImage
    public synchronized int c() {
        AnimatedImageResult animatedImageResult;
        animatedImageResult = this.l;
        return animatedImageResult == null ? 0 : animatedImageResult.a.j();
    }

    @Override // b.f.j.j.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            AnimatedImageResult animatedImageResult = this.l;
            if (animatedImageResult == null) {
                return;
            }
            this.l = null;
            synchronized (animatedImageResult) {
                CloseableReference<Bitmap> closeableReference = animatedImageResult.f544b;
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                animatedImageResult.f544b = null;
                CloseableReference.t(animatedImageResult.c);
                animatedImageResult.c = null;
            }
        }
    }

    @Override // b.f.j.j.CloseableImage
    public boolean d() {
        return this.m;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getHeight() {
        AnimatedImageResult animatedImageResult;
        animatedImageResult = this.l;
        return animatedImageResult == null ? 0 : animatedImageResult.a.getHeight();
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getWidth() {
        AnimatedImageResult animatedImageResult;
        animatedImageResult = this.l;
        return animatedImageResult == null ? 0 : animatedImageResult.a.getWidth();
    }

    @Override // b.f.j.j.CloseableImage
    public synchronized boolean isClosed() {
        return this.l == null;
    }
}
