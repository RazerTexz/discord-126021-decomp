package b.f.j.j;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: CloseableAnimatedImage.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    public b.f.j.a.a.e l;
    public boolean m = true;

    public a(b.f.j.a.a.e eVar) {
        this.l = eVar;
    }

    @Override // b.f.j.j.c
    public synchronized int c() {
        b.f.j.a.a.e eVar;
        eVar = this.l;
        return eVar == null ? 0 : eVar.a.j();
    }

    @Override // b.f.j.j.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            b.f.j.a.a.e eVar = this.l;
            if (eVar == null) {
                return;
            }
            this.l = null;
            synchronized (eVar) {
                CloseableReference<Bitmap> closeableReference = eVar.f544b;
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                eVar.f544b = null;
                CloseableReference.t(eVar.c);
                eVar.c = null;
            }
        }
    }

    @Override // b.f.j.j.c
    public boolean d() {
        return this.m;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getHeight() {
        b.f.j.a.a.e eVar;
        eVar = this.l;
        return eVar == null ? 0 : eVar.a.getHeight();
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getWidth() {
        b.f.j.a.a.e eVar;
        eVar = this.l;
        return eVar == null ? 0 : eVar.a.getWidth();
    }

    @Override // b.f.j.j.c
    public synchronized boolean isClosed() {
        return this.l == null;
    }
}
