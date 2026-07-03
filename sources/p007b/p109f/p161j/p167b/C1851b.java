package p007b.p109f.p161j.p167b;

import android.graphics.Bitmap;
import p007b.p109f.p115d.p123h.InterfaceC1709f;

/* JADX INFO: renamed from: b.f.j.b.b */
/* JADX INFO: compiled from: SimpleBitmapReleaser.java */
/* JADX INFO: loaded from: classes2.dex */
public class C1851b implements InterfaceC1709f<Bitmap> {

    /* JADX INFO: renamed from: a */
    public static C1851b f3646a;

    /* JADX INFO: renamed from: a */
    public static C1851b m1207a() {
        if (f3646a == null) {
            f3646a = new C1851b();
        }
        return f3646a;
    }

    @Override // p007b.p109f.p115d.p123h.InterfaceC1709f
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
