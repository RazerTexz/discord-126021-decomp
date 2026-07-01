package lombok.eclipse.agent;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate$1.SCL.lombok */
class PatchDelegate$1 extends ThreadLocal<List<PatchDelegate$ClassScopeEntry>> {
    @Override // java.lang.ThreadLocal
    protected /* bridge */ /* synthetic */ List<PatchDelegate$ClassScopeEntry> initialValue() {
        return initialValue();
    }

    PatchDelegate$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.ThreadLocal
    protected List<PatchDelegate$ClassScopeEntry> initialValue() {
        return new ArrayList();
    }
}
