package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.annotation.Annotation;
import lombok.Cleanup;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.delombok.LombokOptionsFactory;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/handlers/HandleCleanup.SCL.lombok */
public class HandleCleanup extends JavacAnnotationHandler<Cleanup> {
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Cleanup> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        List<JCTree.JCStatement> statements;
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.CLEANUP_FLAG_USAGE, "@Cleanup");
        if (JavacHandlerUtil.inNetbeansEditor(annotationNode)) {
            return;
        }
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) Cleanup.class);
        String cleanupName = annotation.getInstance().value();
        if (cleanupName.length() == 0) {
            annotationNode.addError("cleanupName cannot be the empty string.");
            return;
        }
        if (annotationNode.m10925up().getKind() != AST.Kind.LOCAL) {
            annotationNode.addError("@Cleanup is legal only on local variable declarations.");
            return;
        }
        JCTree.JCStatement jCStatement = (JCTree.JCVariableDecl) annotationNode.m10925up().get();
        if (((JCTree.JCVariableDecl) jCStatement).init == null) {
            annotationNode.addError("@Cleanup variable declarations need to be initialized.");
            return;
        }
        JavacNode ancestor = annotationNode.m10925up().directUp();
        JCTree.JCBlock jCBlock = (JCTree) ancestor.get();
        if (jCBlock instanceof JCTree.JCBlock) {
            statements = jCBlock.stats;
        } else if (jCBlock instanceof JCTree.JCCase) {
            statements = ((JCTree.JCCase) jCBlock).stats;
        } else if (jCBlock instanceof JCTree.JCMethodDecl) {
            statements = ((JCTree.JCMethodDecl) jCBlock).body.stats;
        } else {
            annotationNode.addError("@Cleanup is legal only on a local variable declaration inside a block.");
            return;
        }
        boolean seenDeclaration = false;
        ListBuffer<JCTree.JCStatement> newStatements = new ListBuffer<>();
        ListBuffer<JCTree.JCStatement> tryBlock = new ListBuffer<>();
        for (JCTree.JCStatement statement : statements) {
            if (!seenDeclaration) {
                if (statement == jCStatement) {
                    seenDeclaration = true;
                }
                newStatements.append(statement);
            } else {
                tryBlock.append(statement);
            }
        }
        if (!seenDeclaration) {
            annotationNode.addError("LOMBOK BUG: Can't find this local variable declaration inside its parent.");
            return;
        }
        doAssignmentCheck(annotationNode, tryBlock.toList(), ((JCTree.JCVariableDecl) jCStatement).name);
        JavacTreeMaker maker = annotationNode.getTreeMaker();
        JCTree.JCFieldAccess cleanupMethod = maker.Select(maker.Ident(((JCTree.JCVariableDecl) jCStatement).name), annotationNode.toName(cleanupName));
        List<JCTree.JCStatement> cleanupCall = List.of(maker.Exec(maker.Apply(List.nil(), cleanupMethod, List.nil())));
        JCTree.JCExpression preventNullAnalysis = preventNullAnalysis(maker, annotationNode, maker.Ident(((JCTree.JCVariableDecl) jCStatement).name));
        JCTree.JCBinary isNull = maker.Binary(Javac.CTC_NOT_EQUAL, preventNullAnalysis, maker.Literal(Javac.CTC_BOT, null));
        JCTree.JCIf ifNotNullCleanup = maker.m10940If(isNull, maker.Block(0L, cleanupCall), null);
        Context context = annotationNode.getContext();
        JCTree.JCBlock finalizer = (JCTree.JCBlock) JavacHandlerUtil.recursiveSetGeneratedBy(maker.Block(0L, List.of(ifNotNullCleanup)), ast, context);
        newStatements.append(JavacHandlerUtil.setGeneratedBy(maker.Try((JCTree.JCBlock) JavacHandlerUtil.setGeneratedBy(maker.Block(0L, tryBlock.toList()), ast, context), List.nil(), finalizer), ast, context));
        if (jCBlock instanceof JCTree.JCBlock) {
            jCBlock.stats = newStatements.toList();
        } else if (jCBlock instanceof JCTree.JCCase) {
            ((JCTree.JCCase) jCBlock).stats = newStatements.toList();
        } else {
            if (!(jCBlock instanceof JCTree.JCMethodDecl)) {
                throw new AssertionError("Should not get here");
            }
            ((JCTree.JCMethodDecl) jCBlock).body.stats = newStatements.toList();
        }
        ancestor.rebuild();
    }

    public JCTree.JCExpression preventNullAnalysis(JavacTreeMaker maker, JavacNode node, JCTree.JCExpression expression) {
        if (LombokOptionsFactory.getDelombokOptions(node.getContext()).getFormatPreferences().danceAroundIdeChecks()) {
            JCTree.JCMethodInvocation singletonList = maker.Apply(List.nil(), JavacHandlerUtil.chainDotsString(node, "java.util.Collections.singletonList"), List.of(expression));
            JCTree.JCMethodInvocation cleanedExpr = maker.Apply(List.nil(), maker.Select(singletonList, node.toName("get")), List.of(maker.Literal(Javac.CTC_INT, 0)));
            return cleanedExpr;
        }
        return expression;
    }

    public void doAssignmentCheck(JavacNode node, List<JCTree.JCStatement> statements, Name name) {
        for (JCTree.JCStatement statement : statements) {
            doAssignmentCheck0(node, statement, name);
        }
    }

    public void doAssignmentCheck0(JavacNode node, JCTree statement, Name name) {
        JavacNode problemNode;
        if (statement instanceof JCTree.JCAssign) {
            doAssignmentCheck0(node, ((JCTree.JCAssign) statement).rhs, name);
        }
        if (statement instanceof JCTree.JCExpressionStatement) {
            doAssignmentCheck0(node, ((JCTree.JCExpressionStatement) statement).expr, name);
        }
        if (statement instanceof JCTree.JCVariableDecl) {
            doAssignmentCheck0(node, ((JCTree.JCVariableDecl) statement).init, name);
        }
        if (statement instanceof JCTree.JCTypeCast) {
            doAssignmentCheck0(node, ((JCTree.JCTypeCast) statement).expr, name);
        }
        if ((statement instanceof JCTree.JCIdent) && ((JCTree.JCIdent) statement).name.contentEquals(name) && (problemNode = node.getNodeFor(statement)) != null) {
            problemNode.addWarning("You're assigning an auto-cleanup variable to something else. This is a bad idea.");
        }
    }
}
