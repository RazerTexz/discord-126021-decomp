package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.f.v;
import d0.e0.p.d.m0.f.w;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$a {
    public i$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final i create(w wVar) {
        m.checkNotNullParameter(wVar, "table");
        if (wVar.getRequirementCount() == 0) {
            return getEMPTY();
        }
        List<v> requirementList = wVar.getRequirementList();
        m.checkNotNullExpressionValue(requirementList, "table.requirementList");
        return new i(requirementList, null);
    }

    public final i getEMPTY() {
        return i.access$getEMPTY$cp();
    }
}
