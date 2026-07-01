package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import lombok.core.handlers.HandlerUtil;
import lombok.javac.Javac;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$CopyJavadoc$2.SCL.lombok */
enum JavacHandlerUtil$CopyJavadoc$2 extends JavacHandlerUtil$CopyJavadoc {
    JavacHandlerUtil$CopyJavadoc$2(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.javac.handlers.JavacHandlerUtil$CopyJavadoc
    public String apply(JCTree$JCCompilationUnit cu, JavacNode node) {
        JCTree n = node.get();
        String javadoc = Javac.getDocComment(cu, n);
        String out = HandlerUtil.getJavadocSection(javadoc, "GETTER");
        boolean sectionBased = out != null;
        if (!sectionBased) {
            out = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc), "@param(?:eter)?\\s+.*");
        }
        node.getAst().cleanupTask("javadocfilter-getter", n, new JavacHandlerUtil$CopyJavadoc$2$1(this, cu, n, sectionBased));
        return out;
    }
}
