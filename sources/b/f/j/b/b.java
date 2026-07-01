package b.f.j.b;

import android.graphics.Bitmap;
import b.f.d.h.f;

/* JADX INFO: compiled from: SimpleBitmapReleaser.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements f<Bitmap> {
    public static b a;

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    @Override // b.f.d.h.f
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
