package p007b.p109f.p161j.p181p;

import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p109f.p115d.p119d.C1683f;
import p007b.p109f.p161j.p168c.C1859f;
import p007b.p109f.p161j.p168c.C1867n;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.s */
/* JADX INFO: compiled from: DiskCacheReadProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2009s implements InterfaceC2018w0<C1919e> {

    /* JADX INFO: renamed from: a */
    public final C1859f f4202a;

    /* JADX INFO: renamed from: b */
    public final C1859f f4203b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1862i f4204c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC2018w0<C1919e> f4205d;

    public C2009s(C1859f c1859f, C1859f c1859f2, InterfaceC1862i interfaceC1862i, InterfaceC2018w0<C1919e> interfaceC2018w0) {
        this.f4202a = c1859f;
        this.f4203b = c1859f2;
        this.f4204c = interfaceC1862i;
        this.f4205d = interfaceC2018w0;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: c */
    public static Map<String, String> m1516c(InterfaceC2024z0 interfaceC2024z0, InterfaceC2020x0 interfaceC2020x0, boolean z2, int i) {
        if (interfaceC2024z0.mo1360g(interfaceC2020x0, "DiskCacheProducer")) {
            return z2 ? C1683f.m968of("cached_value_found", String.valueOf(z2), "encodedImageSize", String.valueOf(i)) : C1683f.m967of("cached_value_found", String.valueOf(z2));
        }
        return null;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        ImageRequest imageRequestMo1447e = interfaceC2020x0.mo1447e();
        if (!interfaceC2020x0.mo1447e().m8720b(16)) {
            if (interfaceC2020x0.mo1459q().m8722g() < ImageRequest.EnumC10667c.DISK_CACHE.m8722g()) {
                this.f4205d.mo1417b(interfaceC1995l, interfaceC2020x0);
                return;
            } else {
                interfaceC2020x0.mo1451i("disk", "nil-result_read");
                interfaceC1995l.mo1424b(null, 1);
                return;
            }
        }
        interfaceC2020x0.mo1457o().mo1358e(interfaceC2020x0, "DiskCacheProducer");
        CacheKey cacheKeyM1230b = ((C1867n) this.f4204c).m1230b(imageRequestMo1447e, interfaceC2020x0.mo1444b());
        C1859f c1859f = imageRequestMo1447e.f19584b == ImageRequest.EnumC10666b.SMALL ? this.f4203b : this.f4202a;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        c1859f.m1219e(cacheKeyM1230b, atomicBoolean).m11368b(new C2005q(this, interfaceC2020x0.mo1457o(), interfaceC2020x0, interfaceC1995l));
        interfaceC2020x0.mo1448f(new C2007r(this, atomicBoolean));
    }
}
