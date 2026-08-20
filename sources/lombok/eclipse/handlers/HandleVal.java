package lombok.eclipse.handlers;

import lombok.ConfigurationKeys;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.DeferUntilPostDiet;
import lombok.eclipse.EclipseASTAdapter;
import lombok.eclipse.EclipseNode;
import lombok.val;
import lombok.var;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.ForStatement;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/handlers/HandleVal.SCL.lombok */
@DeferUntilPostDiet
@HandlerPriority(65536)
public class HandleVal extends EclipseASTAdapter {
    @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
    public void visitLocal(EclipseNode localNode, LocalDeclaration local) {
        TypeReference type = local.type;
        boolean isVal = EclipseHandlerUtil.typeMatches((Class<?>) val.class, localNode, type);
        boolean isVar = EclipseHandlerUtil.typeMatches((Class<?>) var.class, localNode, type);
        if (isVal || isVar) {
            if (isVal) {
                HandlerUtil.handleFlagUsage(localNode, ConfigurationKeys.VAL_FLAG_USAGE, "val");
            }
            if (isVar) {
                HandlerUtil.handleFlagUsage(localNode, ConfigurationKeys.VAR_FLAG_USAGE, "var");
            }
            boolean variableOfForEach = false;
            if (localNode.directUp().get() instanceof ForeachStatement) {
                ForeachStatement fs = localNode.directUp().get();
                variableOfForEach = fs.elementVariable == local;
            }
            String annotation = isVal ? "val" : "var";
            if (local.initialization == null && !variableOfForEach) {
                localNode.addError("'" + annotation + "' on a local variable requires an initializer expression");
                return;
            }
            if (local.initialization instanceof ArrayInitializer) {
                localNode.addError("'" + annotation + "' is not compatible with array initializer expressions. Use the full form (new int[] { ... } instead of just { ... })");
                return;
            }
            ForStatement forStatement = (ASTNode) localNode.directUp().get();
            if (isVal && (forStatement instanceof ForStatement)) {
                localNode.addError("'val' is not allowed in old-style for loops");
                return;
            }
            if ((forStatement instanceof ForStatement) && forStatement.initializations != null && forStatement.initializations.length > 1) {
                localNode.addError("'var' is not allowed in old-style for loops if there is more than 1 initializer");
                return;
            }
            if (local.initialization != null && local.initialization.getClass().getName().equals("org.eclipse.jdt.internal.compiler.ast.LambdaExpression")) {
                localNode.addError("'" + annotation + "' is not allowed with lambda expressions.");
            } else if (isVar && (local.initialization instanceof NullLiteral)) {
                localNode.addError("variable initializer is 'null'");
            }
        }
    }
}
