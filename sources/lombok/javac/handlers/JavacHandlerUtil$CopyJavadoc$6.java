package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import lombok.core.CleanupTask;
import lombok.core.handlers.HandlerUtil;
import lombok.javac.Javac;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$CopyJavadoc$6.SCL.lombok */
class JavacHandlerUtil$CopyJavadoc$6 implements CleanupTask {
    private final /* synthetic */ JCTree$JCCompilationUnit val$cu;
    private final /* synthetic */ JCTree val$n;
    private final /* synthetic */ boolean val$sectionBased;

    JavacHandlerUtil$CopyJavadoc$6(JCTree$JCCompilationUnit jCTree$JCCompilationUnit, JCTree jCTree, boolean z2) {
        this.val$cu = jCTree$JCCompilationUnit;
        this.val$n = jCTree;
        this.val$sectionBased = z2;
    }

    @Override // lombok.core.CleanupTask
    public void cleanup() {
        String javadoc = Javac.getDocComment(this.val$cu, this.val$n);
        if (javadoc == null || javadoc.isEmpty()) {
            return;
        }
        String javadoc2 = HandlerUtil.stripSectionsFromJavadoc(javadoc);
        if (!this.val$sectionBased) {
            javadoc2 = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc2), "@param(?:eter)?\\s+.*");
        }
        Javac.setDocComment(this.val$cu, this.val$n, javadoc2);
    }
}
