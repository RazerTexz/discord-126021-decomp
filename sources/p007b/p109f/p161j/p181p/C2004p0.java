package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.concurrent.CancellationException;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p161j.p169d.C1880a;
import p007b.p109f.p161j.p175j.C1919e;
import p686z.C13202g;
import p686z.InterfaceC13198c;

/* JADX INFO: renamed from: b.f.j.p.p0 */
/* JADX INFO: compiled from: PartialDiskCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2004p0 implements InterfaceC13198c<C1919e, Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ InterfaceC2024z0 f4180a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ InterfaceC2020x0 f4181b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ InterfaceC1995l f4182c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ CacheKey f4183d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C2008r0 f4184e;

    public C2004p0(C2008r0 c2008r0, InterfaceC2024z0 interfaceC2024z0, InterfaceC2020x0 interfaceC2020x0, InterfaceC1995l interfaceC1995l, CacheKey cacheKey) {
        this.f4184e = c2008r0;
        this.f4180a = interfaceC2024z0;
        this.f4181b = interfaceC2020x0;
        this.f4182c = interfaceC1995l;
        this.f4183d = cacheKey;
    }

    @Override // p686z.InterfaceC13198c
    /* JADX INFO: renamed from: a */
    public Void mo1510a(C13202g<C1919e> c13202g) throws Exception {
        boolean z2;
        C1919e c1919e;
        synchronized (c13202g.f27983g) {
            z2 = c13202g.f27985i;
        }
        if (z2 || (c13202g.m11370e() && (c13202g.m11369d() instanceof CancellationException))) {
            this.f4180a.mo1357d(this.f4181b, "PartialDiskCacheProducer", null);
            this.f4182c.mo1426d();
        } else if (c13202g.m11370e()) {
            this.f4180a.mo1364k(this.f4181b, "PartialDiskCacheProducer", c13202g.m11369d(), null);
            this.f4184e.m1512d(this.f4182c, this.f4181b, this.f4183d, null);
        } else {
            synchronized (c13202g.f27983g) {
                c1919e = c13202g.f27986j;
            }
            C1919e c1919e2 = c1919e;
            if (c1919e2 != null) {
                InterfaceC2024z0 interfaceC2024z0 = this.f4180a;
                InterfaceC2020x0 interfaceC2020x0 = this.f4181b;
                interfaceC2024z0.mo1363j(interfaceC2020x0, "PartialDiskCacheProducer", C2008r0.m1511c(interfaceC2024z0, interfaceC2020x0, true, c1919e2.m1344n()));
                int iM1344n = c1919e2.m1344n() - 1;
                C1460d.m527i(Boolean.valueOf(iM1344n > 0));
                c1919e2.f3900s = new C1880a(0, iM1344n);
                int iM1344n2 = c1919e2.m1344n();
                ImageRequest imageRequestMo1447e = this.f4181b.mo1447e();
                C1880a c1880a = imageRequestMo1447e.f19594l;
                if (c1880a != null && c1880a.f3704a >= 0 && iM1344n >= c1880a.f3705b) {
                    this.f4181b.mo1451i("disk", "partial");
                    this.f4180a.mo1356c(this.f4181b, "PartialDiskCacheProducer", true);
                    this.f4182c.mo1424b(c1919e2, 9);
                } else {
                    this.f4182c.mo1424b(c1919e2, 8);
                    ImageRequestBuilder imageRequestBuilderM8723b = ImageRequestBuilder.m8723b(imageRequestMo1447e.f19585c);
                    imageRequestBuilderM8723b.f19617f = imageRequestMo1447e.f19591i;
                    imageRequestBuilderM8723b.f19626o = imageRequestMo1447e.f19594l;
                    imageRequestBuilderM8723b.f19618g = imageRequestMo1447e.f19584b;
                    imageRequestBuilderM8723b.f19620i = imageRequestMo1447e.f19589g;
                    imageRequestBuilderM8723b.f19621j = imageRequestMo1447e.f19590h;
                    imageRequestBuilderM8723b.f19613b = imageRequestMo1447e.f19596n;
                    imageRequestBuilderM8723b.f19614c = imageRequestMo1447e.f19597o;
                    imageRequestBuilderM8723b.f19623l = imageRequestMo1447e.f19601s;
                    imageRequestBuilderM8723b.f19619h = imageRequestMo1447e.f19588f;
                    imageRequestBuilderM8723b.f19622k = imageRequestMo1447e.f19595m;
                    imageRequestBuilderM8723b.f19615d = imageRequestMo1447e.f19592j;
                    imageRequestBuilderM8723b.f19625n = imageRequestMo1447e.f19602t;
                    imageRequestBuilderM8723b.f19616e = imageRequestMo1447e.f19593k;
                    imageRequestBuilderM8723b.f19624m = imageRequestMo1447e.f19600r;
                    imageRequestBuilderM8723b.f19627p = imageRequestMo1447e.f19603u;
                    int i = iM1344n2 - 1;
                    C1460d.m527i(Boolean.valueOf(i >= 0));
                    imageRequestBuilderM8723b.f19626o = new C1880a(i, Integer.MAX_VALUE);
                    this.f4184e.m1512d(this.f4182c, new C1973d1(imageRequestBuilderM8723b.m8724a(), this.f4181b), this.f4183d, c1919e2);
                }
            } else {
                InterfaceC2024z0 interfaceC2024z1 = this.f4180a;
                InterfaceC2020x0 interfaceC2020x1 = this.f4181b;
                interfaceC2024z1.mo1363j(interfaceC2020x1, "PartialDiskCacheProducer", C2008r0.m1511c(interfaceC2024z1, interfaceC2020x1, false, 0));
                this.f4184e.m1512d(this.f4182c, this.f4181b, this.f4183d, c1919e2);
            }
        }
        return null;
    }
}
