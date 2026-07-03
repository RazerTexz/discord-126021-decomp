package p007b.p109f.p161j.p175j;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import p007b.p109f.p161j.p162a.p163a.C1838e;

/* JADX INFO: renamed from: b.f.j.j.a */
/* JADX INFO: compiled from: CloseableAnimatedImage.java */
/* JADX INFO: loaded from: classes.dex */
public class C1915a extends AbstractC1917c {

    /* JADX INFO: renamed from: l */
    public C1838e f3882l;

    /* JADX INFO: renamed from: m */
    public boolean f3883m = true;

    public C1915a(C1838e c1838e) {
        this.f3882l = c1838e;
    }

    @Override // p007b.p109f.p161j.p175j.AbstractC1917c
    /* JADX INFO: renamed from: c */
    public synchronized int mo1330c() {
        C1838e c1838e;
        c1838e = this.f3882l;
        return c1838e == null ? 0 : c1838e.f3609a.mo1184j();
    }

    @Override // p007b.p109f.p161j.p175j.AbstractC1917c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            C1838e c1838e = this.f3882l;
            if (c1838e == null) {
                return;
            }
            this.f3882l = null;
            synchronized (c1838e) {
                CloseableReference<Bitmap> closeableReference = c1838e.f3610b;
                Class<CloseableReference> cls = CloseableReference.f19438j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                c1838e.f3610b = null;
                CloseableReference.m8639t(c1838e.f3611c);
                c1838e.f3611c = null;
            }
        }
    }

    @Override // p007b.p109f.p161j.p175j.AbstractC1917c
    /* JADX INFO: renamed from: d */
    public boolean mo1331d() {
        return this.f3883m;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getHeight() {
        C1838e c1838e;
        c1838e = this.f3882l;
        return c1838e == null ? 0 : c1838e.f3609a.getHeight();
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getWidth() {
        C1838e c1838e;
        c1838e = this.f3882l;
        return c1838e == null ? 0 : c1838e.f3609a.getWidth();
    }

    @Override // p007b.p109f.p161j.p175j.AbstractC1917c
    public synchronized boolean isClosed() {
        return this.f3882l == null;
    }
}
