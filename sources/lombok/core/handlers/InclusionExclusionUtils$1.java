package lombok.core.handlers;

import java.util.Comparator;
import lombok.ToString$Include;
import lombok.core.LombokNode;

/* JADX INFO: Add missing generic type declarations: [L] */
/* JADX INFO: loaded from: app.apk:lombok/core/handlers/InclusionExclusionUtils$1.SCL.lombok */
class InclusionExclusionUtils$1<L> implements Comparator<InclusionExclusionUtils$Included<L, ToString$Include>> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return compare((InclusionExclusionUtils$Included) obj, (InclusionExclusionUtils$Included) obj2);
    }

    InclusionExclusionUtils$1() {
    }

    public int compare(InclusionExclusionUtils$Included<L, ToString$Include> inclusionExclusionUtils$Included, InclusionExclusionUtils$Included<L, ToString$Include> inclusionExclusionUtils$Included2) {
        return InclusionExclusionUtils.access$0(inclusionExclusionUtils$Included.getInc() == null ? 0 : inclusionExclusionUtils$Included.getInc().rank(), inclusionExclusionUtils$Included2.getInc() == null ? 0 : inclusionExclusionUtils$Included2.getInc().rank(), (LombokNode) inclusionExclusionUtils$Included.getNode(), (LombokNode) inclusionExclusionUtils$Included2.getNode());
    }
}
