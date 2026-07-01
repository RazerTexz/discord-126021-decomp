package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.util.Name;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$GetterMethod.SCL.lombok */
class JavacHandlerUtil$GetterMethod {
    private final Name name;
    private final JCTree$JCExpression type;

    static /* synthetic */ Name access$1(JavacHandlerUtil$GetterMethod javacHandlerUtil$GetterMethod) {
        return javacHandlerUtil$GetterMethod.name;
    }

    static /* synthetic */ JCTree$JCExpression access$0(JavacHandlerUtil$GetterMethod javacHandlerUtil$GetterMethod) {
        return javacHandlerUtil$GetterMethod.type;
    }

    JavacHandlerUtil$GetterMethod(Name name, JCTree$JCExpression type) {
        this.name = name;
        this.type = type;
    }
}
