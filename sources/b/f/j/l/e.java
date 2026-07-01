package b.f.j.l;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: BitmapPoolBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends q<Bitmap> {
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // b.f.j.l.q
    public Bitmap a(int i) {
        Object objPollFirst;
        g<T> gVar = this.f598b;
        synchronized (gVar) {
            g$b g_b = (g$b) gVar.a.get(i);
            if (g_b == null) {
                objPollFirst = null;
            } else {
                objPollFirst = g_b.c.pollFirst();
                gVar.a((g$b<T>) g_b);
            }
        }
        if (objPollFirst != null) {
            synchronized (this) {
                this.a.remove(objPollFirst);
            }
        }
        Bitmap bitmap = (Bitmap) objPollFirst;
        if (bitmap == null || !d(bitmap)) {
            return null;
        }
        bitmap.eraseColor(0);
        return bitmap;
    }

    @Override // b.f.j.l.q
    public int b(Bitmap bitmap) {
        return b.f.k.a.d(bitmap);
    }

    public boolean d(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        if (bitmap.isRecycled()) {
            b.f.d.e.a.p("BitmapPoolBackend", "Cannot reuse a recycled bitmap: %s", bitmap);
            return false;
        }
        if (bitmap.isMutable()) {
            return true;
        }
        b.f.d.e.a.p("BitmapPoolBackend", "Cannot reuse an immutable bitmap: %s", bitmap);
        return false;
    }
}
