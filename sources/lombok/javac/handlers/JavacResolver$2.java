package lombok.javac.handlers;

import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import lombok.javac.JavacNode;
import lombok.javac.JavacResolution;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacResolver$2.SCL.lombok */
enum JavacResolver$2 extends JavacResolver {
    JavacResolver$2(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.javac.handlers.JavacResolver
    public Type resolveMember(JavacNode node, JCTree$JCExpression expr) {
        Type type = expr.type;
        if (type == null) {
            try {
                JCTree$JCExpression resolvedExpression = new JavacResolution(node.getContext()).resolveMethodMember(node).get(expr);
                if (resolvedExpression != null) {
                    type = resolvedExpression.type;
                }
            } catch (Exception unused) {
            }
        }
        return type;
    }
}
