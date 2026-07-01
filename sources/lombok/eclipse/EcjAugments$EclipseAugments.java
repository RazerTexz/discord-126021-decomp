package lombok.eclipse;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import lombok.core.FieldAugment;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.SourceMethod;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/EcjAugments$EclipseAugments.SCL.lombok */
public final class EcjAugments$EclipseAugments {
    public static final FieldAugment<CompilationUnit, Map<String, String>> CompilationUnit_javadoc = FieldAugment.augment(CompilationUnit.class, Map.class, "$javadoc");
    public static final FieldAugment<CompilationUnit, ConcurrentMap<String, List<SourceMethod>>> CompilationUnit_delegateMethods = FieldAugment.augment(CompilationUnit.class, ConcurrentMap.class, "$delegateMethods");

    private EcjAugments$EclipseAugments() {
    }
}
