package lombok.eclipse.agent;

import org.eclipse.jdt.internal.compiler.lookup.ClassScope;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate$ClassScopeEntry.SCL.lombok */
class PatchDelegate$ClassScopeEntry {
    final ClassScope scope;
    String corruptedPath;

    PatchDelegate$ClassScopeEntry(ClassScope scope) {
        this.scope = scope;
    }
}
