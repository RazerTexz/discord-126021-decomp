package p007b.p195g.p196a.p205c.p215g0;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2263m;
import p007b.p195g.p196a.p205c.p219i0.C2359u;

/* JADX INFO: renamed from: b.g.a.c.g0.p */
/* JADX INFO: compiled from: SerializerCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2247p {

    /* JADX INFO: renamed from: a */
    public final HashMap<C2359u, AbstractC2364n<Object>> f4815a = new HashMap<>(64);

    /* JADX INFO: renamed from: b */
    public final AtomicReference<C2263m> f4816b = new AtomicReference<>();

    /* JADX INFO: renamed from: a */
    public AbstractC2364n<Object> m2008a(AbstractC2360j abstractC2360j) {
        AbstractC2364n<Object> abstractC2364n;
        synchronized (this) {
            abstractC2364n = this.f4815a.get(new C2359u(abstractC2360j, false));
        }
        return abstractC2364n;
    }

    /* JADX INFO: renamed from: b */
    public AbstractC2364n<Object> m2009b(Class<?> cls) {
        AbstractC2364n<Object> abstractC2364n;
        synchronized (this) {
            abstractC2364n = this.f4815a.get(new C2359u(cls, false));
        }
        return abstractC2364n;
    }
}
