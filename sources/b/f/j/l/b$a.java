package b.f.j.l;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: BitmapCounter.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a implements b.f.d.h.f<Bitmap> {
    public final /* synthetic */ b a;

    public b$a(b bVar) {
        this.a = bVar;
    }

    @Override // b.f.d.h.f
    public void release(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        try {
            this.a.a(bitmap2);
        } finally {
            bitmap2.recycle();
        }
    }
}
