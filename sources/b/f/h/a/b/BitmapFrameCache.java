package b.f.h.a.b;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.h.a.b.b, reason: use source file name */
/* JADX INFO: compiled from: BitmapFrameCache.java */
/* JADX INFO: loaded from: classes.dex */
public interface BitmapFrameCache {
    CloseableReference<Bitmap> a(int i, int i2, int i3);

    void b(int i, CloseableReference<Bitmap> closeableReference, int i2);

    boolean c(int i);

    void clear();

    CloseableReference<Bitmap> d(int i);

    void e(int i, CloseableReference<Bitmap> closeableReference, int i2);

    CloseableReference<Bitmap> f(int i);
}
