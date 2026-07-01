package b.f.h.a.b.d;

import android.graphics.Bitmap;
import b.f.h.a.b.BitmapFrameCache;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.h.a.b.d.d, reason: use source file name */
/* JADX INFO: compiled from: NoOpCache.java */
/* JADX INFO: loaded from: classes.dex */
public class NoOpCache implements BitmapFrameCache {
    @Override // b.f.h.a.b.BitmapFrameCache
    public CloseableReference<Bitmap> a(int i, int i2, int i3) {
        return null;
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public void b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public boolean c(int i) {
        return false;
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public void clear() {
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public CloseableReference<Bitmap> d(int i) {
        return null;
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public void e(int i, CloseableReference<Bitmap> closeableReference, int i2) {
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public CloseableReference<Bitmap> f(int i) {
        return null;
    }
}
