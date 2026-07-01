package lombok.eclipse.agent;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lombok.patcher.MethodTarget;
import lombok.patcher.TargetMatcher;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/EclipsePatcher$4.SCL.lombok */
class EclipsePatcher$4 implements TargetMatcher {
    EclipsePatcher$4() {
    }

    @Override // lombok.patcher.TargetMatcher
    public boolean matches(String classSpec, String methodName, String descriptor) {
        if (!methodName.startsWith("convert")) {
            return false;
        }
        List<String> fullDesc = MethodTarget.decomposeFullDesc(descriptor);
        return fullDesc.size() >= 2 && fullDesc.get(1).startsWith("Lorg/eclipse/jdt/internal/compiler/ast/");
    }

    @Override // lombok.patcher.TargetMatcher
    public String describe() {
        return "ASTConverter::(all relevant)";
    }

    @Override // lombok.patcher.TargetMatcher
    public Collection<String> getAffectedClasses() {
        return Collections.singleton("org.eclipse.jdt.core.dom.ASTConverter");
    }
}
