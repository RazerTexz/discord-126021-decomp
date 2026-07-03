package p007b.p109f.p132g.p133a.p134a;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p117b.C1676g;
import p007b.p109f.p132g.p138b.AbstractC1749a;
import p007b.p109f.p132g.p138b.C1750b;
import p007b.p109f.p161j.p162a.p164b.InterfaceC1840a;
import p007b.p109f.p161j.p168c.InterfaceC1876w;
import p007b.p109f.p161j.p170e.C1893h;
import p007b.p109f.p161j.p170e.C1898m;
import p007b.p109f.p161j.p174i.InterfaceC1914a;
import p007b.p109f.p161j.p175j.AbstractC1917c;

/* JADX INFO: renamed from: b.f.g.a.a.e */
/* JADX INFO: compiled from: PipelineDraweeControllerBuilderSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class C1734e implements Supplier<C1733d> {

    /* JADX INFO: renamed from: a */
    public final Context f3187a;

    /* JADX INFO: renamed from: b */
    public final C1893h f3188b;

    /* JADX INFO: renamed from: c */
    public final C1735f f3189c;

    public C1734e(Context context) {
        AbstractC1749a abstractC1749a;
        C1898m c1898m = C1898m.f3788a;
        C1460d.m591y(c1898m, "ImagePipelineFactory was not initialized!");
        this.f3187a = context;
        if (c1898m.f3799l == null) {
            c1898m.f3799l = c1898m.m1295a();
        }
        C1893h c1893h = c1898m.f3799l;
        this.f3188b = c1893h;
        C1735f c1735f = new C1735f();
        this.f3189c = c1735f;
        Resources resources = context.getResources();
        synchronized (AbstractC1749a.class) {
            if (AbstractC1749a.f3253a == null) {
                AbstractC1749a.f3253a = new C1750b();
            }
            abstractC1749a = AbstractC1749a.f3253a;
        }
        InterfaceC1840a interfaceC1840aM1296b = c1898m.m1296b();
        InterfaceC1914a interfaceC1914aMo1189a = interfaceC1840aM1296b == null ? null : interfaceC1840aM1296b.mo1189a(context);
        if (C1676g.f3090k == null) {
            C1676g.f3090k = new C1676g();
        }
        C1676g c1676g = C1676g.f3090k;
        InterfaceC1876w<CacheKey, AbstractC1917c> interfaceC1876w = c1893h.f3737e;
        c1735f.f3190a = resources;
        c1735f.f3191b = abstractC1749a;
        c1735f.f3192c = interfaceC1914aMo1189a;
        c1735f.f3193d = c1676g;
        c1735f.f3194e = interfaceC1876w;
        c1735f.f3195f = null;
        c1735f.f3196g = null;
    }

    @Override // com.facebook.common.internal.Supplier
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1733d get() {
        C1733d c1733d = new C1733d(this.f3187a, this.f3189c, this.f3188b, null, null);
        c1733d.f3186q = null;
        return c1733d;
    }
}
