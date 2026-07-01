package lombok.core.handlers;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: app.apk:lombok/core/handlers/InclusionExclusionUtils$Included.SCL.lombok */
public class InclusionExclusionUtils$Included<L, I extends Annotation> {
    private final L node;
    private final I inc;
    private final boolean defaultInclude;
    private final boolean explicitRank;

    static /* synthetic */ Object access$0(InclusionExclusionUtils$Included inclusionExclusionUtils$Included) {
        return inclusionExclusionUtils$Included.node;
    }

    public InclusionExclusionUtils$Included(L node, I inc, boolean defaultInclude, boolean explicitRank) {
        this.node = node;
        this.inc = inc;
        this.defaultInclude = defaultInclude;
        this.explicitRank = explicitRank;
    }

    public L getNode() {
        return this.node;
    }

    public I getInc() {
        return this.inc;
    }

    public boolean isDefaultInclude() {
        return this.defaultInclude;
    }

    public boolean hasExplicitRank() {
        return this.explicitRank;
    }
}
