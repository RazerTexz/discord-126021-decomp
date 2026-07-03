package p007b.p109f.p161j.p177l;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.memory.BasePool;
import p007b.p109f.p115d.p122g.InterfaceC1696c;

/* JADX INFO: renamed from: b.f.j.l.h */
/* JADX INFO: compiled from: BucketsBitmapPool.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(21)
public class C1936h extends BasePool<Bitmap> implements InterfaceC1932d {
    public C1936h(InterfaceC1696c interfaceC1696c, C1953y c1953y, InterfaceC1954z interfaceC1954z, boolean z2) {
        super(interfaceC1696c, c1953y, interfaceC1954z);
        this.f19557j = z2;
        m8699m();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: e */
    public Bitmap mo1382e(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: g */
    public void mo1383g(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: i */
    public int mo1384i(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: j */
    public int mo1385j(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: k */
    public int mo1386k(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: l */
    public Bitmap mo1387l(C1934f<Bitmap> c1934f) {
        Bitmap bitmap = (Bitmap) super.mo1387l(c1934f);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: o */
    public boolean mo1388o(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        return !bitmap2.isRecycled() && bitmap2.isMutable();
    }
}
