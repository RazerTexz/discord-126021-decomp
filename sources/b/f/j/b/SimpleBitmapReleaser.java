package b.f.j.b;

import android.graphics.Bitmap;
import b.f.d.h.ResourceReleaser;

/* JADX INFO: renamed from: b.f.j.b.b, reason: use source file name */
/* JADX INFO: compiled from: SimpleBitmapReleaser.java */
/* JADX INFO: loaded from: classes2.dex */
public class SimpleBitmapReleaser implements ResourceReleaser<Bitmap> {
    public static SimpleBitmapReleaser a;

    public static SimpleBitmapReleaser a() {
        if (a == null) {
            a = new SimpleBitmapReleaser();
        }
        return a;
    }

    @Override // b.f.d.h.ResourceReleaser
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
