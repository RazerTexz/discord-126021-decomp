package d0.e0.p.d.m0.b;

import d0.t.u;
import java.util.Set;

/* JADX INFO: compiled from: CompanionObjectMappingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final boolean isMappedIntrinsicCompanionObject(c cVar, d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "<this>");
        d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
        if (d0.e0.p.d.m0.k.e.isCompanionObject(eVar)) {
            Set<d0.e0.p.d.m0.g.a> classIds = cVar.getClassIds();
            d0.e0.p.d.m0.g.a classId = d0.e0.p.d.m0.k.x.a.getClassId(eVar);
            if (u.contains(classIds, classId == null ? null : classId.getOuterClassId())) {
                return true;
            }
        }
        return false;
    }
}
