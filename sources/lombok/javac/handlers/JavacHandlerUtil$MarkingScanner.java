package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeScanner;
import com.sun.tools.javac.util.Context;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$MarkingScanner.SCL.lombok */
class JavacHandlerUtil$MarkingScanner extends TreeScanner {
    private final JCTree source;
    private final Context context;

    JavacHandlerUtil$MarkingScanner(JCTree source, Context context) {
        this.source = source;
        this.context = context;
    }

    public void scan(JCTree tree) {
        if (tree == null) {
            return;
        }
        JavacHandlerUtil.setGeneratedBy(tree, this.source, this.context);
        super.scan(tree);
    }
}
