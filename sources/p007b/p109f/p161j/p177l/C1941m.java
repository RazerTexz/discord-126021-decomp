package p007b.p109f.p161j.p177l;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.f.j.l.m */
/* JADX INFO: compiled from: DummyTrackingInUseBitmapPool.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1941m implements InterfaceC1932d {

    /* JADX INFO: renamed from: a */
    public final Set<Bitmap> f3943a = Collections.newSetFromMap(new IdentityHashMap());

    @Override // p007b.p109f.p115d.p122g.InterfaceC1698e
    public Bitmap get(int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Bitmap.Config.RGB_565);
        this.f3943a.add(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    @Override // p007b.p109f.p115d.p122g.InterfaceC1698e, p007b.p109f.p115d.p123h.InterfaceC1709f
    public void release(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Objects.requireNonNull(bitmap);
        this.f3943a.remove(bitmap);
        bitmap.recycle();
    }
}
