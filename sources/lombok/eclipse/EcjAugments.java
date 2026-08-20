package lombok.eclipse;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import lombok.core.FieldAugment;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.SourceMethod;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/EcjAugments.SCL.lombok */
public final class EcjAugments {
    public static final FieldAugment<FieldDeclaration, Boolean> FieldDeclaration_booleanLazyGetter = FieldAugment.augment(FieldDeclaration.class, Boolean.TYPE, "lombok$booleanLazyGetter");
    public static final FieldAugment<ASTNode, Boolean> ASTNode_handled = FieldAugment.augment(ASTNode.class, Boolean.TYPE, "lombok$handled");
    public static final FieldAugment<ASTNode, ASTNode> ASTNode_generatedBy = FieldAugment.augment(ASTNode.class, ASTNode.class, "$generatedBy");
    public static final FieldAugment<Annotation, Boolean> Annotation_applied = FieldAugment.augment(Annotation.class, Boolean.TYPE, "lombok$applied");

    private EcjAugments() {
    }

    /* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/EcjAugments$EclipseAugments.SCL.lombok */
    public static final class EclipseAugments {
        public static final FieldAugment<CompilationUnit, Map<String, String>> CompilationUnit_javadoc = FieldAugment.augment(CompilationUnit.class, Map.class, "$javadoc");
        public static final FieldAugment<CompilationUnit, ConcurrentMap<String, List<SourceMethod>>> CompilationUnit_delegateMethods = FieldAugment.augment(CompilationUnit.class, ConcurrentMap.class, "$delegateMethods");

        private EclipseAugments() {
        }
    }
}
