package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import lombok.javac.Javac;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$CopyJavadoc$1.SCL.lombok */
enum JavacHandlerUtil$CopyJavadoc$1 extends JavacHandlerUtil$CopyJavadoc {
    JavacHandlerUtil$CopyJavadoc$1(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.javac.handlers.JavacHandlerUtil$CopyJavadoc
    public String apply(JCTree$JCCompilationUnit cu, JavacNode node) {
        return Javac.getDocComment(cu, node.get());
    }
}
