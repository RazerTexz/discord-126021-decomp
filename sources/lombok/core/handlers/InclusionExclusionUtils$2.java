package lombok.core.handlers;

import java.util.Comparator;
import lombok.EqualsAndHashCode$Include;
import lombok.core.LombokNode;

/* JADX INFO: Add missing generic type declarations: [L] */
/* JADX INFO: loaded from: app.apk:lombok/core/handlers/InclusionExclusionUtils$2.SCL.lombok */
class InclusionExclusionUtils$2<L> implements Comparator<InclusionExclusionUtils$Included<L, EqualsAndHashCode$Include>> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return compare((InclusionExclusionUtils$Included) obj, (InclusionExclusionUtils$Included) obj2);
    }

    InclusionExclusionUtils$2() {
    }

    public int compare(InclusionExclusionUtils$Included<L, EqualsAndHashCode$Include> inclusionExclusionUtils$Included, InclusionExclusionUtils$Included<L, EqualsAndHashCode$Include> inclusionExclusionUtils$Included2) {
        return InclusionExclusionUtils.access$0(inclusionExclusionUtils$Included.hasExplicitRank() ? inclusionExclusionUtils$Included.getInc().rank() : HandlerUtil.defaultEqualsAndHashcodeIncludeRank(((LombokNode) InclusionExclusionUtils$Included.access$0(inclusionExclusionUtils$Included)).fieldOrMethodBaseType()), inclusionExclusionUtils$Included2.hasExplicitRank() ? inclusionExclusionUtils$Included2.getInc().rank() : HandlerUtil.defaultEqualsAndHashcodeIncludeRank(((LombokNode) InclusionExclusionUtils$Included.access$0(inclusionExclusionUtils$Included2)).fieldOrMethodBaseType()), (LombokNode) inclusionExclusionUtils$Included.getNode(), (LombokNode) inclusionExclusionUtils$Included2.getNode());
    }
}
