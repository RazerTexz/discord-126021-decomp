package b.f.h.a.b.d;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: KeepLastFrameCache.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements b.f.h.a.b.b {
    public int a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CloseableReference<Bitmap> f529b;

    @Override // b.f.h.a.b.b
    public synchronized CloseableReference<Bitmap> a(int i, int i2, int i3) {
        CloseableReference<Bitmap> closeableReferenceN;
        try {
            closeableReferenceN = CloseableReference.n(this.f529b);
            g();
        } catch (Throwable th) {
            g();
            throw th;
        }
        return closeableReferenceN;
    }

    @Override // b.f.h.a.b.b
    public void b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
    }

    @Override // b.f.h.a.b.b
    public synchronized boolean c(int i) {
        return i == this.a && CloseableReference.y(this.f529b);
    }

    @Override // b.f.h.a.b.b
    public synchronized void clear() {
        g();
    }

    @Override // b.f.h.a.b.b
    public synchronized CloseableReference<Bitmap> d(int i) {
        if (this.a != i) {
            return null;
        }
        return CloseableReference.n(this.f529b);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:10:0x001b, B:12:0x0021, B:13:0x0024), top: B:19:0x0003 }] */
    @Override // b.f.h.a.b.b
    public synchronized void e(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference<Bitmap> closeableReference2;
        if (closeableReference == null) {
            closeableReference2 = this.f529b;
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
            this.f529b = CloseableReference.n(closeableReference);
            this.a = i;
            return;
        }
        if (this.f529b != null && closeableReference.u().equals(this.f529b.u())) {
            return;
        }
        closeableReference2 = this.f529b;
        Class<CloseableReference> cls2 = CloseableReference.j;
        if (closeableReference2 != null) {
            closeableReference2.close();
        }
        this.f529b = CloseableReference.n(closeableReference);
        this.a = i;
        return;
        throw th;
    }

    @Override // b.f.h.a.b.b
    public synchronized CloseableReference<Bitmap> f(int i) {
        return CloseableReference.n(this.f529b);
    }

    public final synchronized void g() {
        CloseableReference<Bitmap> closeableReference = this.f529b;
        Class<CloseableReference> cls = CloseableReference.j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.f529b = null;
        this.a = -1;
    }
}
