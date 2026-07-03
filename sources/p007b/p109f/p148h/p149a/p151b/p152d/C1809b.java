package p007b.p109f.p148h.p149a.p151b.p152d;

import android.graphics.Bitmap;
import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import java.util.Iterator;
import java.util.Objects;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p148h.p149a.p151b.InterfaceC1806b;
import p007b.p109f.p161j.p162a.p165c.C1847c;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1918d;
import p007b.p109f.p161j.p175j.C1922h;

/* JADX INFO: renamed from: b.f.h.a.b.d.b */
/* JADX INFO: compiled from: FrescoFrameCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C1809b implements InterfaceC1806b {

    /* JADX INFO: renamed from: a */
    public final C1847c f3509a;

    /* JADX INFO: renamed from: b */
    public final boolean f3510b;

    /* JADX INFO: renamed from: c */
    public final SparseArray<CloseableReference<AbstractC1917c>> f3511c = new SparseArray<>();

    /* JADX INFO: renamed from: d */
    public CloseableReference<AbstractC1917c> f3512d;

    public C1809b(C1847c c1847c, boolean z2) {
        this.f3509a = c1847c;
        this.f3510b = z2;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: g */
    public static CloseableReference<Bitmap> m1157g(CloseableReference<AbstractC1917c> closeableReference) {
        CloseableReference<Bitmap> closeableReferenceM8636n;
        try {
            if (!CloseableReference.m8640y(closeableReference) || !(closeableReference.m8642u() instanceof C1918d)) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return null;
            }
            C1918d c1918d = (C1918d) closeableReference.m8642u();
            synchronized (c1918d) {
                closeableReferenceM8636n = CloseableReference.m8636n(c1918d.f3886l);
            }
            closeableReference.close();
            return closeableReferenceM8636n;
        } catch (Throwable th) {
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReference != null) {
                closeableReference.close();
            }
            throw th;
        }
    }

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    /* JADX INFO: renamed from: a */
    public synchronized CloseableReference<Bitmap> mo1151a(int i, int i2, int i3) {
        CacheKey next;
        CloseableReference<AbstractC1917c> closeableReference = null;
        if (!this.f3510b) {
            return null;
        }
        C1847c c1847c = this.f3509a;
        while (true) {
            synchronized (c1847c) {
                Iterator<CacheKey> it = c1847c.f3637d.iterator();
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
            CloseableReference<AbstractC1917c> closeableReferenceMo1227b = c1847c.f3635b.mo1227b(next);
            if (closeableReferenceMo1227b != null) {
                closeableReference = closeableReferenceMo1227b;
                break;
            }
        }
        return m1157g(closeableReference);
    }

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    /* JADX INFO: renamed from: b */
    public synchronized void mo1152b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference closeableReference2 = null;
        try {
            CloseableReference<AbstractC1917c> closeableReferenceM8632A = CloseableReference.m8632A(new C1918d(closeableReference, C1922h.f3908a, 0, 0));
            if (closeableReferenceM8632A == null) {
                if (closeableReferenceM8632A != null) {
                    closeableReferenceM8632A.close();
                }
                return;
            }
            C1847c c1847c = this.f3509a;
            CloseableReference<AbstractC1917c> closeableReferenceMo1228c = c1847c.f3635b.mo1228c(new C1847c.b(c1847c.f3634a, i), closeableReferenceM8632A, c1847c.f3636c);
            if (CloseableReference.m8640y(closeableReferenceMo1228c)) {
                CloseableReference<AbstractC1917c> closeableReference3 = this.f3511c.get(i);
                if (closeableReference3 != null) {
                    closeableReference3.close();
                }
                this.f3511c.put(i, closeableReferenceMo1228c);
                int i3 = C1691a.f3102a;
            }
            closeableReferenceM8632A.close();
        } catch (Throwable th) {
            if (0 != 0) {
                closeableReference2.close();
            }
            throw th;
        }
    }

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    /* JADX INFO: renamed from: c */
    public synchronized boolean mo1153c(int i) {
        C1847c c1847c;
        c1847c = this.f3509a;
        return c1847c.f3635b.contains(new C1847c.b(c1847c.f3634a, i));
    }

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    public synchronized void clear() {
        CloseableReference<AbstractC1917c> closeableReference = this.f3512d;
        Class<CloseableReference> cls = CloseableReference.f19438j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.f3512d = null;
        for (int i = 0; i < this.f3511c.size(); i++) {
            CloseableReference<AbstractC1917c> closeableReferenceValueAt = this.f3511c.valueAt(i);
            if (closeableReferenceValueAt != null) {
                closeableReferenceValueAt.close();
            }
        }
        this.f3511c.clear();
    }

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    /* JADX INFO: renamed from: d */
    public synchronized CloseableReference<Bitmap> mo1154d(int i) {
        C1847c c1847c;
        c1847c = this.f3509a;
        return m1157g(c1847c.f3635b.get(new C1847c.b(c1847c.f3634a, i)));
    }

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    /* JADX INFO: renamed from: e */
    public synchronized void mo1155e(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference<AbstractC1917c> closeableReferenceM8632A;
        try {
            synchronized (this) {
                Objects.requireNonNull(closeableReference);
                synchronized (this) {
                    CloseableReference<AbstractC1917c> closeableReference2 = this.f3511c.get(i);
                    if (closeableReference2 != null) {
                        this.f3511c.delete(i);
                        Class<CloseableReference> cls = CloseableReference.f19438j;
                        closeableReference2.close();
                        int i3 = C1691a.f3102a;
                    }
                    throw th;
                }
                return;
            }
            closeableReferenceM8632A = CloseableReference.m8632A(new C1918d(closeableReference, C1922h.f3908a, 0, 0));
            if (closeableReferenceM8632A != null) {
                CloseableReference<AbstractC1917c> closeableReference3 = this.f3512d;
                if (closeableReference3 != null) {
                    closeableReference3.close();
                }
                C1847c c1847c = this.f3509a;
                this.f3512d = c1847c.f3635b.mo1228c(new C1847c.b(c1847c.f3634a, i), closeableReferenceM8632A, c1847c.f3636c);
            }
            if (closeableReferenceM8632A != null) {
                closeableReferenceM8632A.close();
            }
            return;
        } catch (Throwable th) {
            if (closeableReferenceM8632A != null) {
                closeableReferenceM8632A.close();
            }
            throw th;
        }
        closeableReferenceM8632A = null;
    }

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    /* JADX INFO: renamed from: f */
    public synchronized CloseableReference<Bitmap> mo1156f(int i) {
        return m1157g(CloseableReference.m8636n(this.f3512d));
    }
}
