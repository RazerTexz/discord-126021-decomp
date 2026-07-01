package lombok.javac.handlers;

import com.discord.api.permission.Permission;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCNewArray;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import java.lang.annotation.Annotation;
import lombok.ConfigurationKeys;
import lombok.Synchronized;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleSynchronized.SCL.lombok */
@HandlerPriority(1024)
public class HandleSynchronized extends JavacAnnotationHandler<Synchronized> {
    private static final String INSTANCE_LOCK_NAME = "$lock";
    private static final String STATIC_LOCK_NAME = "$LOCK";

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Synchronized> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        JCTree$JCExpression lockNode;
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.SYNCHRONIZED_FLAG_USAGE, "@Synchronized");
        if (JavacHandlerUtil.inNetbeansEditor(annotationNode)) {
            return;
        }
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) Synchronized.class);
        JavacNode methodNode = annotationNode.up();
        if (methodNode == null || methodNode.getKind() != AST$Kind.METHOD || !(methodNode.get() instanceof JCTree$JCMethodDecl)) {
            annotationNode.addError("@Synchronized is legal only on methods.");
            return;
        }
        JCTree$JCMethodDecl method = methodNode.get();
        if ((method.mods.flags & Permission.VIEW_CHANNEL) != 0) {
            annotationNode.addError("@Synchronized is legal only on concrete methods.");
            return;
        }
        boolean[] isStatic = new boolean[1];
        isStatic[0] = (method.mods.flags & 8) != 0;
        String lockName = annotation.getInstance().value();
        boolean autoMake = false;
        if (lockName.length() == 0) {
            autoMake = true;
            lockName = isStatic[0] ? STATIC_LOCK_NAME : INSTANCE_LOCK_NAME;
        }
        JavacTreeMaker maker = methodNode.getTreeMaker().at(ast.pos);
        Context context = methodNode.getContext();
        JavacNode typeNode = JavacHandlerUtil.upToTypeNode(annotationNode);
        JavacHandlerUtil$MemberExistsResult exists = JavacHandlerUtil$MemberExistsResult.NOT_EXISTS;
        if (typeNode != null && (typeNode.get() instanceof JCTree$JCClassDecl)) {
            for (JCTree$JCVariableDecl jCTree$JCVariableDecl : typeNode.get().defs) {
                if ((jCTree$JCVariableDecl instanceof JCTree$JCVariableDecl) && jCTree$JCVariableDecl.name.contentEquals(lockName)) {
                    exists = JavacHandlerUtil.getGeneratedBy(jCTree$JCVariableDecl) == null ? JavacHandlerUtil$MemberExistsResult.EXISTS_BY_USER : JavacHandlerUtil$MemberExistsResult.EXISTS_BY_LOMBOK;
                    boolean st = (jCTree$JCVariableDecl.mods.flags & 8) != 0;
                    if (isStatic[0] && !st) {
                        annotationNode.addError("The field " + lockName + " is non-static and this cannot be used on this static method");
                        return;
                    }
                    isStatic[0] = st;
                }
            }
        }
        if (exists == JavacHandlerUtil$MemberExistsResult.NOT_EXISTS) {
            if (!autoMake) {
                annotationNode.addError("The field " + lockName + " does not exist.");
                return;
            }
            JCTree$JCExpression objectType = JavacHandlerUtil.genJavaLangTypeRef(methodNode, ast.pos, "Object");
            JCTree$JCNewArray newObjectArray = maker.NewArray(JavacHandlerUtil.genJavaLangTypeRef(methodNode, ast.pos, "Object"), List.of(maker.Literal(Javac.CTC_INT, 0)), null);
            JCTree$JCVariableDecl fieldDecl = JavacHandlerUtil.recursiveSetGeneratedBy(maker.VarDef(maker.Modifiers(18 | (isStatic[0] ? 8 : 0)), methodNode.toName(lockName), objectType, newObjectArray), ast, context);
            JavacHandlerUtil.injectFieldAndMarkGenerated(methodNode.up(), fieldDecl);
        }
        if (method.body == null) {
            return;
        }
        if (isStatic[0]) {
            lockNode = JavacHandlerUtil.namePlusTypeParamsToTypeReference(maker, typeNode, methodNode.toName(lockName), false, List.nil());
        } else {
            lockNode = maker.Select(maker.Ident(methodNode.toName("this")), methodNode.toName(lockName));
        }
        JavacHandlerUtil.recursiveSetGeneratedBy(lockNode, ast, context);
        method.body = JavacHandlerUtil.setGeneratedBy(maker.Block(0L, List.of(JavacHandlerUtil.setGeneratedBy(maker.Synchronized(lockNode, method.body), ast, context))), ast, context);
        methodNode.rebuild();
    }
}
