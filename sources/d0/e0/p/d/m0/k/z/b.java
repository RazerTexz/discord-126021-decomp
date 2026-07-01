package d0.e0.p.d.m0.k.z;

import d0.e0.p.d.m0.m.o;
import d0.z.d.m;

/* JADX INFO: compiled from: SamConversionResolverImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {
    public final Iterable<Object> a;

    public b(o oVar, Iterable<? extends Object> iterable) {
        m.checkNotNullParameter(oVar, "storageManager");
        m.checkNotNullParameter(iterable, "samWithReceiverResolvers");
        this.a = iterable;
        oVar.createCacheWithNullableValues();
    }
}
