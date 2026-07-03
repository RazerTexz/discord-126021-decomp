package p007b.p109f.p161j.p167b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p161j.p170e.C1886a;
import p007b.p109f.p161j.p177l.InterfaceC1932d;
import p007b.p109f.p186k.C2038a;

/* JADX INFO: renamed from: b.f.j.b.a */
/* JADX INFO: compiled from: ArtBitmapFactory.java */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class C1850a extends PlatformBitmapFactory {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1932d f3644a;

    /* JADX INFO: renamed from: b */
    public final C1886a f3645b;

    public C1850a(InterfaceC1932d interfaceC1932d, C1886a c1886a) {
        this.f3644a = interfaceC1932d;
        this.f3645b = c1886a;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    /* JADX INFO: renamed from: b */
    public CloseableReference<Bitmap> mo1206b(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap = this.f3644a.get(C2038a.m1540c(i, i2, config));
        C1460d.m527i(Boolean.valueOf(bitmap.getAllocationByteCount() >= C2038a.m1539b(config) * (i * i2)));
        bitmap.reconfigure(i, i2, config);
        return CloseableReference.m8634H(bitmap, this.f3644a, this.f3645b.f3725a);
    }
}
