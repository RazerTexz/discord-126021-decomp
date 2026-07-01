package b.f.j.l;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: DummyTrackingInUseBitmapPool.java */
/* JADX INFO: loaded from: classes3.dex */
public class m implements d {
    public final Set<Bitmap> a = Collections.newSetFromMap(new IdentityHashMap());

    @Override // b.f.d.g.e
    public Bitmap get(int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Bitmap$Config.RGB_565);
        this.a.add(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    @Override // b.f.d.g.e, b.f.d.h.f
    public void release(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Objects.requireNonNull(bitmap);
        this.a.remove(bitmap);
        bitmap.recycle();
    }
}
