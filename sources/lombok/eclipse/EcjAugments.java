package lombok.eclipse;

import lombok.core.FieldAugment;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/EcjAugments.SCL.lombok */
public final class EcjAugments {
    public static final FieldAugment<FieldDeclaration, Boolean> FieldDeclaration_booleanLazyGetter = FieldAugment.augment(FieldDeclaration.class, Boolean.TYPE, "lombok$booleanLazyGetter");
    public static final FieldAugment<ASTNode, Boolean> ASTNode_handled = FieldAugment.augment(ASTNode.class, Boolean.TYPE, "lombok$handled");
    public static final FieldAugment<ASTNode, ASTNode> ASTNode_generatedBy = FieldAugment.augment(ASTNode.class, ASTNode.class, "$generatedBy");
    public static final FieldAugment<Annotation, Boolean> Annotation_applied = FieldAugment.augment(Annotation.class, Boolean.TYPE, "lombok$applied");

    private EcjAugments() {
    }
}
