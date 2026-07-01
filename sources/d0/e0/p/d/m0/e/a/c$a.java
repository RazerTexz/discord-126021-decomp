package d0.e0.p.d.m0.e.a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a {
    public final d0.e0.p.d.m0.c.g1.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3310b;

    public c$a(d0.e0.p.d.m0.c.g1.c cVar, int i) {
        d0.z.d.m.checkNotNullParameter(cVar, "typeQualifier");
        this.a = cVar;
        this.f3310b = i;
    }

    public final d0.e0.p.d.m0.c.g1.c component1() {
        return this.a;
    }

    public final List<a> component2() {
        a[] aVarArrValuesCustom = a.valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            a aVar = aVarArrValuesCustom[i];
            boolean z2 = true;
            if (!((this.f3310b & (1 << aVar.ordinal())) != 0)) {
                if (!((this.f3310b & 8) != 0) || aVar == a.TYPE_PARAMETER_BOUNDS) {
                    z2 = false;
                }
            }
            if (z2) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
