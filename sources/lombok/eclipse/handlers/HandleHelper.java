package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.experimental.Helper;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleHelper.SCL.lombok */
public class HandleHelper extends EclipseAnnotationHandler<Helper> {
    private Statement[] getStatementsFromAstNode(ASTNode node) {
        if (node instanceof Block) {
            return ((Block) node).statements;
        }
        if (node instanceof AbstractMethodDeclaration) {
            return ((AbstractMethodDeclaration) node).statements;
        }
        if (node instanceof SwitchStatement) {
            return ((SwitchStatement) node).statements;
        }
        return null;
    }

    private void setStatementsOfAstNode(ASTNode node, Statement[] statements) {
        if (!(node instanceof Block)) {
            if (!(node instanceof AbstractMethodDeclaration)) {
                if (!(node instanceof SwitchStatement)) {
                    throw new IllegalArgumentException("Can't set statements on node type: " + node.getClass());
                }
                ((SwitchStatement) node).statements = statements;
                return;
            }
            ((AbstractMethodDeclaration) node).statements = statements;
            return;
        }
        ((Block) node).statements = statements;
    }

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Helper> annotation, Annotation ast, EclipseNode annotationNode) {
        char[] name;
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.HELPER_FLAG_USAGE, "@Helper");
        EclipseNode annotatedType = annotationNode.up();
        EclipseNode containingBlock = annotatedType == null ? null : annotatedType.directUp();
        Statement[] origStatements = getStatementsFromAstNode(containingBlock == null ? null : containingBlock.get());
        if (annotatedType == null || annotatedType.getKind() != AST.Kind.TYPE || origStatements == null) {
            annotationNode.addError("@Helper is legal only on method-local classes.");
            return;
        }
        Statement statement = (TypeDeclaration) annotatedType.get();
        int indexOfType = -1;
        for (int i = 0; i < origStatements.length; i++) {
            if (origStatements[i] == statement) {
                indexOfType = i;
                break;
            }
        }
        List<String> knownMethodNames = new ArrayList<>();
        for (AbstractMethodDeclaration methodOfHelper : ((TypeDeclaration) statement).methods) {
            if ((methodOfHelper instanceof MethodDeclaration) && (name = methodOfHelper.selector) != null && name.length > 0 && name[0] != '<') {
                knownMethodNames.add(new String(name));
            }
        }
        Collections.sort(knownMethodNames);
        final String[] knownMethodNames_ = (String[]) knownMethodNames.toArray(new String[0]);
        final char[] helperName = new char[((TypeDeclaration) statement).name.length + 1];
        final boolean[] helperUsed = new boolean[1];
        helperName[0] = '$';
        System.arraycopy(((TypeDeclaration) statement).name, 0, helperName, 1, helperName.length - 1);
        ASTVisitor visitor = new ASTVisitor() { // from class: lombok.eclipse.handlers.HandleHelper.1
            public boolean visit(MessageSend messageSend, BlockScope scope) {
                if (messageSend.receiver instanceof ThisReference) {
                    if ((messageSend.receiver.bits & 4) == 0) {
                        return true;
                    }
                } else if (messageSend.receiver != null) {
                    return true;
                }
                char[] name2 = messageSend.selector;
                if (name2 == null || name2.length == 0 || name2[0] == '<') {
                    return true;
                }
                String n = new String(name2);
                if (Arrays.binarySearch(knownMethodNames_, n) < 0) {
                    return true;
                }
                messageSend.receiver = new SingleNameReference(helperName, messageSend.nameSourcePosition);
                helperUsed[0] = true;
                return true;
            }
        };
        for (int i2 = indexOfType + 1; i2 < origStatements.length; i2++) {
            origStatements[i2].traverse(visitor, (BlockScope) null);
        }
        if (!helperUsed[0]) {
            annotationNode.addWarning("No methods of this helper class are ever used.");
            return;
        }
        Statement[] newStatements = new Statement[origStatements.length + 1];
        System.arraycopy(origStatements, 0, newStatements, 0, indexOfType + 1);
        System.arraycopy(origStatements, indexOfType + 1, newStatements, indexOfType + 2, (origStatements.length - indexOfType) - 1);
        LocalDeclaration decl = new LocalDeclaration(helperName, 0, 0);
        decl.modifiers |= 16;
        AllocationExpression alloc = new AllocationExpression();
        alloc.type = new SingleTypeReference(((TypeDeclaration) statement).name, 0L);
        decl.initialization = alloc;
        decl.type = new SingleTypeReference(((TypeDeclaration) statement).name, 0L);
        SetGeneratedByVisitor sgbvVisitor = new SetGeneratedByVisitor(annotationNode.get());
        decl.traverse(sgbvVisitor, (BlockScope) null);
        newStatements[indexOfType + 1] = decl;
        setStatementsOfAstNode(containingBlock.get(), newStatements);
    }
}
