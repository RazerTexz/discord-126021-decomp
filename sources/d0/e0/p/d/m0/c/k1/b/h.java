package d0.e0.p.d.m0.c.k1.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends d implements d0.e0.p.d.m0.e.a.k0.e {
    public final Object[] c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d0.e0.p.d.m0.g.e eVar, Object[] objArr) {
        super(eVar);
        d0.z.d.m.checkNotNullParameter(objArr, "values");
        this.c = objArr;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.e
    public List<d> getElements() {
        Object[] objArr = this.c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            d$a d_a = d.a;
            d0.z.d.m.checkNotNull(obj);
            arrayList.add(d_a.create(obj, null));
        }
        return arrayList;
    }
}
