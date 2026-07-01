package b.f.h.a.b.d;

import android.graphics.Bitmap;
import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import b.f.j.a.c.c$b;
import b.f.j.j.h;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: FrescoFrameCache.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements b.f.h.a.b.b {
    public final b.f.j.a.c.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f528b;
    public final SparseArray<CloseableReference<b.f.j.j.c>> c = new SparseArray<>();
    public CloseableReference<b.f.j.j.c> d;

    public b(b.f.j.a.c.c cVar, boolean z2) {
        this.a = cVar;
        this.f528b = z2;
    }

    @VisibleForTesting
    public static CloseableReference<Bitmap> g(CloseableReference<b.f.j.j.c> closeableReference) {
        CloseableReference<Bitmap> closeableReferenceN;
        try {
            if (!CloseableReference.y(closeableReference) || !(closeableReference.u() instanceof b.f.j.j.d)) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return null;
            }
            b.f.j.j.d dVar = (b.f.j.j.d) closeableReference.u();
            synchronized (dVar) {
                closeableReferenceN = CloseableReference.n(dVar.l);
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

    @Override // b.f.h.a.b.b
    public synchronized CloseableReference<Bitmap> a(int i, int i2, int i3) {
        CacheKey next;
        CloseableReference<b.f.j.j.c> closeableReference = null;
        if (!this.f528b) {
            return null;
        }
        b.f.j.a.c.c cVar = this.a;
        while (true) {
            synchronized (cVar) {
                Iterator<CacheKey> it = cVar.d.iterator();
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
            CloseableReference<b.f.j.j.c> closeableReferenceB = cVar.f549b.b(next);
            if (closeableReferenceB != null) {
                closeableReference = closeableReferenceB;
                break;
            }
        }
        return g(closeableReference);
    }

    @Override // b.f.h.a.b.b
    public synchronized void b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference closeableReference2 = null;
        try {
            CloseableReference<b.f.j.j.c> closeableReferenceA = CloseableReference.A(new b.f.j.j.d(closeableReference, h.a, 0, 0));
            if (closeableReferenceA == null) {
                if (closeableReferenceA != null) {
                    closeableReferenceA.close();
                }
                return;
            }
            b.f.j.a.c.c cVar = this.a;
            CloseableReference<b.f.j.j.c> closeableReferenceC = cVar.f549b.c(new c$b(cVar.a, i), closeableReferenceA, cVar.c);
            if (CloseableReference.y(closeableReferenceC)) {
                CloseableReference<b.f.j.j.c> closeableReference3 = this.c.get(i);
                if (closeableReference3 != null) {
                    closeableReference3.close();
                }
                this.c.put(i, closeableReferenceC);
                int i3 = b.f.d.e.a.a;
            }
            closeableReferenceA.close();
        } catch (Throwable th) {
            if (0 != 0) {
                closeableReference2.close();
            }
            throw th;
        }
    }

    @Override // b.f.h.a.b.b
    public synchronized boolean c(int i) {
        b.f.j.a.c.c cVar;
        cVar = this.a;
        return cVar.f549b.contains(new c$b(cVar.a, i));
    }

    @Override // b.f.h.a.b.b
    public synchronized void clear() {
        CloseableReference<b.f.j.j.c> closeableReference = this.d;
        Class<CloseableReference> cls = CloseableReference.j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.d = null;
        for (int i = 0; i < this.c.size(); i++) {
            CloseableReference<b.f.j.j.c> closeableReferenceValueAt = this.c.valueAt(i);
            if (closeableReferenceValueAt != null) {
                closeableReferenceValueAt.close();
            }
        }
        this.c.clear();
    }

    @Override // b.f.h.a.b.b
    public synchronized CloseableReference<Bitmap> d(int i) {
        b.f.j.a.c.c cVar;
        cVar = this.a;
        return g(cVar.f549b.get(new c$b(cVar.a, i)));
    }

    @Override // b.f.h.a.b.b
    public synchronized void e(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference<b.f.j.j.c> closeableReferenceA;
        try {
            synchronized (this) {
                Objects.requireNonNull(closeableReference);
                synchronized (this) {
                    CloseableReference<b.f.j.j.c> closeableReference2 = this.c.get(i);
                    if (closeableReference2 != null) {
                        this.c.delete(i);
                        Class<CloseableReference> cls = CloseableReference.j;
                        closeableReference2.close();
                        int i3 = b.f.d.e.a.a;
                    }
                    throw th;
                }
                return;
            }
            closeableReferenceA = CloseableReference.A(new b.f.j.j.d(closeableReference, h.a, 0, 0));
            if (closeableReferenceA != null) {
                CloseableReference<b.f.j.j.c> closeableReference3 = this.d;
                if (closeableReference3 != null) {
                    closeableReference3.close();
                }
                b.f.j.a.c.c cVar = this.a;
                this.d = cVar.f549b.c(new c$b(cVar.a, i), closeableReferenceA, cVar.c);
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

    @Override // b.f.h.a.b.b
    public synchronized CloseableReference<Bitmap> f(int i) {
        return g(CloseableReference.n(this.d));
    }
}
