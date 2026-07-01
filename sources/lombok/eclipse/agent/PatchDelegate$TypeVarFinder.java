package lombok.eclipse.agent;

import java.util.HashSet;
import java.util.Set;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate$TypeVarFinder.SCL.lombok */
public class PatchDelegate$TypeVarFinder extends PatchDelegate$EclipseTypeBindingScanner {
    private Set<String> typeVars = new HashSet();

    public Set<String> getTypeVariables() {
        return this.typeVars;
    }

    @Override // lombok.eclipse.agent.PatchDelegate$EclipseTypeBindingScanner
    public void visitTypeVariable(TypeVariableBinding binding) {
        if (binding.sourceName != null) {
            this.typeVars.add(new String(binding.sourceName));
        }
        super.visitTypeVariable(binding);
    }
}
