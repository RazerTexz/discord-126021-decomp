package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.d */
/* JADX INFO: compiled from: CompanionObjectMappingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11284d {
    public static final boolean isMappedIntrinsicCompanionObject(C11283c c11283c, InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(c11283c, "<this>");
        C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
        if (C11787e.isCompanionObject(interfaceC11330e)) {
            Set<C11712a> classIds = c11283c.getClassIds();
            C11712a classId = C11836a.getClassId(interfaceC11330e);
            if (C12163u.contains(classIds, classId == null ? null : classId.getOuterClassId())) {
                return true;
            }
        }
        return false;
    }
}
