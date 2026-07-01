package b.f.j.l;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.f.j.l.m, reason: use source file name */
/* JADX INFO: compiled from: DummyTrackingInUseBitmapPool.java */
/* JADX INFO: loaded from: classes3.dex */
public class DummyTrackingInUseBitmapPool implements BitmapPool {
    public final Set<Bitmap> a = Collections.newSetFromMap(new IdentityHashMap());

    @Override // b.f.d.g.Pool2
    public Bitmap get(int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Bitmap.Config.RGB_565);
        this.a.add(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    @Override // b.f.d.g.Pool2, b.f.d.h.ResourceReleaser
    public void release(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Objects.requireNonNull(bitmap);
        this.a.remove(bitmap);
        bitmap.recycle();
    }
}
