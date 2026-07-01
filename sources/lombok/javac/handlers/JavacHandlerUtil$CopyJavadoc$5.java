package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$CopyJavadoc$5.SCL.lombok */
enum JavacHandlerUtil$CopyJavadoc$5 extends JavacHandlerUtil$CopyJavadoc {
    JavacHandlerUtil$CopyJavadoc$5(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.javac.handlers.JavacHandlerUtil$CopyJavadoc
    public String apply(JCTree$JCCompilationUnit cu, JavacNode node) {
        return JavacHandlerUtil$CopyJavadoc.access$3(cu, node, "WITHBY|WITH_BY");
    }
}
