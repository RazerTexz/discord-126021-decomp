package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.b.k$a;
import d0.e0.p.d.m0.m.n;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.y;
import java.util.Map;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends b {
    public static final /* synthetic */ KProperty<Object>[] g = {a0.property1(new y(a0.getOrCreateKotlinClass(i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    public final d0.e0.p.d.m0.m.j h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d0.e0.p.d.m0.e.a.k0.a aVar, d0.e0.p.d.m0.e.a.i0.g gVar) {
        super(gVar, aVar, k$a.A);
        m.checkNotNullParameter(aVar, "annotation");
        m.checkNotNullParameter(gVar, "c");
        this.h = gVar.getStorageManager().createLazyValue(new i$a(this));
    }

    @Override // d0.e0.p.d.m0.e.a.g0.b, d0.e0.p.d.m0.c.g1.c
    public Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<Object>> getAllValueArguments() {
        return (Map) n.getValue(this.h, this, (KProperty<?>) g[0]);
    }
}
