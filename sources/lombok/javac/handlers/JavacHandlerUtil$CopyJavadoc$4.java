package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import lombok.core.handlers.HandlerUtil;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$CopyJavadoc$4.SCL.lombok */
enum JavacHandlerUtil$CopyJavadoc$4 extends JavacHandlerUtil$CopyJavadoc {
    JavacHandlerUtil$CopyJavadoc$4(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.javac.handlers.JavacHandlerUtil$CopyJavadoc
    public String apply(JCTree$JCCompilationUnit cu, JavacNode node) {
        return HandlerUtil.addReturnsUpdatedSelfIfNeeded(JavacHandlerUtil$CopyJavadoc.access$3(cu, node, "WITH|WITHER"));
    }
}
