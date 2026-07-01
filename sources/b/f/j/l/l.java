package b.f.j.l;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import java.util.Objects;

/* JADX INFO: compiled from: DummyBitmapPool.java */
/* JADX INFO: loaded from: classes3.dex */
public class l implements d {
    @Override // b.f.d.g.e
    public Bitmap get(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Bitmap$Config.RGB_565);
    }

    @Override // b.f.d.g.e, b.f.d.h.f
    public void release(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Objects.requireNonNull(bitmap);
        bitmap.recycle();
    }
}
