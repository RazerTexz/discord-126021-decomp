package b.f.h.a.b.d;

import android.graphics.Bitmap;
import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import b.f.d.e.FLog;
import b.f.h.a.b.BitmapFrameCache;
import b.f.j.a.c.AnimatedFrameCache;
import b.f.j.j.CloseableImage;
import b.f.j.j.CloseableStaticBitmap;
import b.f.j.j.ImmutableQualityInfo;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.h.a.b.d.b, reason: use source file name */
/* JADX INFO: compiled from: FrescoFrameCache.java */
/* JADX INFO: loaded from: classes.dex */
public class FrescoFrameCache implements BitmapFrameCache {
    public final AnimatedFrameCache a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f528b;
    public final SparseArray<CloseableReference<CloseableImage>> c = new SparseArray<>();
    public CloseableReference<CloseableImage> d;

    public FrescoFrameCache(AnimatedFrameCache animatedFrameCache, boolean z2) {
        this.a = animatedFrameCache;
        this.f528b = z2;
    }

    @VisibleForTesting
    public static CloseableReference<Bitmap> g(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference<Bitmap> closeableReferenceN;
        try {
            if (!CloseableReference.y(closeableReference) || !(closeableReference.u() instanceof CloseableStaticBitmap)) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return null;
            }
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableReference.u();
            synchronized (closeableStaticBitmap) {
                closeableReferenceN = CloseableReference.n(closeableStaticBitmap.l);
            }
            closeableReference.close();
            return closeableReferenceN;
        } catch (Throwable th) {
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReference != null) {
                closeableReference.close();
            }
            throw th;
        }
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public synchronized CloseableReference<Bitmap> a(int i, int i2, int i3) {
        CacheKey next;
        CloseableReference<CloseableImage> closeableReference = null;
        if (!this.f528b) {
            return null;
        }
        AnimatedFrameCache animatedFrameCache = this.a;
        while (true) {
            synchronized (animatedFrameCache) {
                Iterator<CacheKey> it = animatedFrameCache.d.iterator();
                if (it.hasNext()) {
                    next = it.next();
                    it.remove();
                } else {
                    next = null;
                }
            }
            if (next == null) {
                break;
            }
            CloseableReference<CloseableImage> closeableReferenceB = animatedFrameCache.f549b.b(next);
            if (closeableReferenceB != null) {
                closeableReference = closeableReferenceB;
                break;
            }
        }
        return g(closeableReference);
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public synchronized void b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference closeableReference2 = null;
        try {
            CloseableReference<CloseableImage> closeableReferenceA = CloseableReference.A(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.a, 0, 0));
            if (closeableReferenceA == null) {
                if (closeableReferenceA != null) {
                    closeableReferenceA.close();
                }
                return;
            }
            AnimatedFrameCache animatedFrameCache = this.a;
            CloseableReference<CloseableImage> closeableReferenceC = animatedFrameCache.f549b.c(new AnimatedFrameCache.b(animatedFrameCache.a, i), closeableReferenceA, animatedFrameCache.c);
            if (CloseableReference.y(closeableReferenceC)) {
                CloseableReference<CloseableImage> closeableReference3 = this.c.get(i);
                if (closeableReference3 != null) {
                    closeableReference3.close();
                }
                this.c.put(i, closeableReferenceC);
                int i3 = FLog.a;
            }
            closeableReferenceA.close();
        } catch (Throwable th) {
            if (0 != 0) {
                closeableReference2.close();
            }
            throw th;
        }
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public synchronized boolean c(int i) {
        AnimatedFrameCache animatedFrameCache;
        animatedFrameCache = this.a;
        return animatedFrameCache.f549b.contains(new AnimatedFrameCache.b(animatedFrameCache.a, i));
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public synchronized void clear() {
        CloseableReference<CloseableImage> closeableReference = this.d;
        Class<CloseableReference> cls = CloseableReference.j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.d = null;
        for (int i = 0; i < this.c.size(); i++) {
            CloseableReference<CloseableImage> closeableReferenceValueAt = this.c.valueAt(i);
            if (closeableReferenceValueAt != null) {
                closeableReferenceValueAt.close();
            }
        }
        this.c.clear();
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public synchronized CloseableReference<Bitmap> d(int i) {
        AnimatedFrameCache animatedFrameCache;
        animatedFrameCache = this.a;
        return g(animatedFrameCache.f549b.get(new AnimatedFrameCache.b(animatedFrameCache.a, i)));
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public synchronized void e(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference<CloseableImage> closeableReferenceA;
        try {
            synchronized (this) {
                Objects.requireNonNull(closeableReference);
                synchronized (this) {
                    CloseableReference<CloseableImage> closeableReference2 = this.c.get(i);
                    if (closeableReference2 != null) {
                        this.c.delete(i);
                        Class<CloseableReference> cls = CloseableReference.j;
                        closeableReference2.close();
                        int i3 = FLog.a;
                    }
                    throw th;
                }
                return;
            }
            closeableReferenceA = CloseableReference.A(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.a, 0, 0));
            if (closeableReferenceA != null) {
                CloseableReference<CloseableImage> closeableReference3 = this.d;
                if (closeableReference3 != null) {
                    closeableReference3.close();
                }
                AnimatedFrameCache animatedFrameCache = this.a;
                this.d = animatedFrameCache.f549b.c(new AnimatedFrameCache.b(animatedFrameCache.a, i), closeableReferenceA, animatedFrameCache.c);
            }
            if (closeableReferenceA != null) {
                closeableReferenceA.close();
            }
            return;
        } catch (Throwable th) {
            if (closeableReferenceA != null) {
                closeableReferenceA.close();
            }
            throw th;
        }
        closeableReferenceA = null;
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public synchronized CloseableReference<Bitmap> f(int i) {
        return g(CloseableReference.n(this.d));
    }
}
