package lombok.eclipse.agent;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lombok.patcher.MethodTarget;
import lombok.patcher.TargetMatcher;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/EclipsePatcher$3.SCL.lombok */
class EclipsePatcher$3 implements TargetMatcher {
    EclipsePatcher$3() {
    }

    @Override // lombok.patcher.TargetMatcher
    public boolean matches(String classSpec, String methodName, String descriptor) {
        if (!"convert".equals(methodName)) {
            return false;
        }
        List<String> fullDesc = MethodTarget.decomposeFullDesc(descriptor);
        return !ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(fullDesc.get(0)) && fullDesc.size() >= 2 && fullDesc.get(1).startsWith("Lorg/eclipse/jdt/internal/compiler/ast/");
    }

    @Override // lombok.patcher.TargetMatcher
    public String describe() {
        return "ASTConverter:[all relevant]";
    }

    @Override // lombok.patcher.TargetMatcher
    public Collection<String> getAffectedClasses() {
        return Collections.singleton("org.eclipse.jdt.core.dom.ASTConverter");
    }
}
