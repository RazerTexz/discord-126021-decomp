package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import java.lang.annotation.Annotation;
import lombok.Builder;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.experimental.SuperBuilder;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/handlers/HandleBuilderDefault.SCL.lombok */
@HandlerPriority(-1025)
public class HandleBuilderDefault extends JavacAnnotationHandler<Builder.Default> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Builder.Default> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        JavacNode annotatedField = annotationNode.m10925up();
        if (annotatedField.getKind() != AST.Kind.FIELD) {
            return;
        }
        JavacNode classWithAnnotatedField = annotatedField.m10925up();
        if (!JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) Builder.class, classWithAnnotatedField) && !JavacHandlerUtil.hasAnnotation("lombok.experimental.Builder", classWithAnnotatedField) && !JavacHandlerUtil.hasAnnotation((Class<? extends Annotation>) SuperBuilder.class, classWithAnnotatedField)) {
            annotationNode.addWarning("@Builder.Default requires @Builder or @SuperBuilder on the class for it to mean anything.");
            JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) Builder.Default.class);
        }
        if (ast.annotationType instanceof JCTree.JCFieldAccess) {
            JCTree.JCFieldAccess jfa = ast.annotationType;
            if ((jfa.selected instanceof JCTree.JCIdent) && jfa.selected.name.contentEquals("Builder") && jfa.name.contentEquals("Default")) {
                JCTree.JCFieldAccess newJfaSel = annotationNode.getTreeMaker().Select(annotationNode.getTreeMaker().Ident(annotationNode.toName("lombok")), jfa.selected.name);
                jfa.selected = newJfaSel;
            }
        }
    }
}
