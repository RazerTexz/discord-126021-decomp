package p007b.p109f.p148h.p149a.p151b.p152d;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import p007b.p109f.p148h.p149a.p151b.InterfaceC1806b;

/* JADX INFO: renamed from: b.f.h.a.b.d.c */
/* JADX INFO: compiled from: KeepLastFrameCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C1810c implements InterfaceC1806b {

    /* JADX INFO: renamed from: a */
    public int f3513a = -1;

    /* JADX INFO: renamed from: b */
    public CloseableReference<Bitmap> f3514b;

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    /* JADX INFO: renamed from: a */
    public synchronized CloseableReference<Bitmap> mo1151a(int i, int i2, int i3) {
        CloseableReference<Bitmap> closeableReferenceM8636n;
        try {
            closeableReferenceM8636n = CloseableReference.m8636n(this.f3514b);
            m1158g();
        } catch (Throwable th) {
            m1158g();
            throw th;
        }
        return closeableReferenceM8636n;
    }

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    /* JADX INFO: renamed from: b */
    public void mo1152b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
    }

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    /* JADX INFO: renamed from: c */
    public synchronized boolean mo1153c(int i) {
        return i == this.f3513a && CloseableReference.m8640y(this.f3514b);
    }

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    public synchronized void clear() {
        m1158g();
    }

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    /* JADX INFO: renamed from: d */
    public synchronized CloseableReference<Bitmap> mo1154d(int i) {
        if (this.f3513a != i) {
            return null;
        }
        return CloseableReference.m8636n(this.f3514b);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:10:0x001b, B:12:0x0021, B:13:0x0024), top: B:19:0x0003 }] */
    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    /* JADX INFO: renamed from: e */
    public synchronized void mo1155e(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference<Bitmap> closeableReference2;
        if (closeableReference == null) {
            closeableReference2 = this.f3514b;
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
            this.f3514b = CloseableReference.m8636n(closeableReference);
            this.f3513a = i;
            return;
        }
        if (this.f3514b != null && closeableReference.m8642u().equals(this.f3514b.m8642u())) {
            return;
        }
        closeableReference2 = this.f3514b;
        Class<CloseableReference> cls2 = CloseableReference.f19438j;
        if (closeableReference2 != null) {
            closeableReference2.close();
        }
        this.f3514b = CloseableReference.m8636n(closeableReference);
        this.f3513a = i;
        return;
        throw th;
    }

    @Override // p007b.p109f.p148h.p149a.p151b.InterfaceC1806b
    /* JADX INFO: renamed from: f */
    public synchronized CloseableReference<Bitmap> mo1156f(int i) {
        return CloseableReference.m8636n(this.f3514b);
    }

    /* JADX INFO: renamed from: g */
    public final synchronized void m1158g() {
        CloseableReference<Bitmap> closeableReference = this.f3514b;
        Class<CloseableReference> cls = CloseableReference.f19438j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.f3514b = null;
        this.f3513a = -1;
    }
}
