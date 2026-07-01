package lombok.javac.handlers;

import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacResolver$3.SCL.lombok */
enum JavacResolver$3 extends JavacResolver {
    JavacResolver$3(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.javac.handlers.JavacResolver
    public Type resolveMember(JavacNode node, JCTree$JCExpression expr) {
        JavacNode classNode;
        Type type = METHOD.resolveMember(node, expr);
        if (type == null) {
            JavacNode javacNodeUp = node;
            while (true) {
                classNode = javacNodeUp;
                if (classNode == null || !noneOf(classNode.get(), JCTree$JCBlock.class, JCTree$JCMethodDecl.class, JCTree$JCVariableDecl.class)) {
                    break;
                }
                javacNodeUp = classNode.up();
            }
            if (classNode != null) {
                type = CLASS.resolveMember(classNode, expr);
            }
        }
        return type;
    }

    private boolean noneOf(Object o, Class<?>... clsArr) {
        for (Class<?> clazz : clsArr) {
            if (clazz.isInstance(o)) {
                return false;
            }
        }
        return true;
    }
}
