package p007b.p109f.p161j.p177l;

import android.graphics.Bitmap;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p161j.p177l.C1935g;
import p007b.p109f.p186k.C2038a;

/* JADX INFO: renamed from: b.f.j.l.e */
/* JADX INFO: compiled from: BitmapPoolBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1933e extends AbstractC1945q<Bitmap> {
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // p007b.p109f.p161j.p177l.AbstractC1945q
    /* JADX INFO: renamed from: a */
    public Bitmap mo1373a(int i) {
        Object objPollFirst;
        C1935g<T> c1935g = this.f3951b;
        synchronized (c1935g) {
            C1935g.b bVar = (C1935g.b) c1935g.f3931a.get(i);
            if (bVar == null) {
                objPollFirst = null;
            } else {
                objPollFirst = bVar.f3936c.pollFirst();
                c1935g.m1380a((C1935g.b<T>) bVar);
            }
        }
        if (objPollFirst != null) {
            synchronized (this) {
                this.f3950a.remove(objPollFirst);
            }
        }
        Bitmap bitmap = (Bitmap) objPollFirst;
        if (bitmap == null || !m1375d(bitmap)) {
            return null;
        }
        bitmap.eraseColor(0);
        return bitmap;
    }

    @Override // p007b.p109f.p161j.p177l.AbstractC1945q
    /* JADX INFO: renamed from: b */
    public int mo1374b(Bitmap bitmap) {
        return C2038a.m1541d(bitmap);
    }

    /* JADX INFO: renamed from: d */
    public boolean m1375d(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        if (bitmap.isRecycled()) {
            C1691a.m988p("BitmapPoolBackend", "Cannot reuse a recycled bitmap: %s", bitmap);
            return false;
        }
        if (bitmap.isMutable()) {
            return true;
        }
        C1691a.m988p("BitmapPoolBackend", "Cannot reuse an immutable bitmap: %s", bitmap);
        return false;
    }
}
