package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.m.o;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: DeserializedAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a implements d0.e0.p.d.m0.c.g1.g {
    public static final /* synthetic */ KProperty<Object>[] j = {a0.property1(new y(a0.getOrCreateKotlinClass(a.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    public final d0.e0.p.d.m0.m.j k;

    public a(o oVar, Function0<? extends List<? extends d0.e0.p.d.m0.c.g1.c>> function0) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(function0, "compute");
        this.k = oVar.createLazyValue(function0);
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public d0.e0.p.d.m0.c.g1.c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return d0.e0.p.d.m0.c.g1.g$b.findAnnotation(this, bVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean hasAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return d0.e0.p.d.m0.c.g1.g$b.hasAnnotation(this, bVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean isEmpty() {
        return ((List) d0.e0.p.d.m0.m.n.getValue(this.k, this, (KProperty<?>) j[0])).isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<d0.e0.p.d.m0.c.g1.c> iterator() {
        return ((List) d0.e0.p.d.m0.m.n.getValue(this.k, this, (KProperty<?>) j[0])).iterator();
    }
}
