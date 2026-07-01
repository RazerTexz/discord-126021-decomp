package lombok.javac.handlers;

import com.sun.source.tree.MethodInvocationTree;
import com.sun.source.util.TreeScanner;
import com.sun.tools.javac.tree.JCTree$JCIdent;
import com.sun.tools.javac.tree.JCTree$JCMethodInvocation;
import com.sun.tools.javac.util.Name;
import java.util.Arrays;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleHelper$1.SCL.lombok */
class HandleHelper$1 extends TreeScanner<Void, Void> {
    final /* synthetic */ HandleHelper this$0;
    private final /* synthetic */ String[] val$knownMethodNames_;
    private final /* synthetic */ JavacTreeMaker val$maker;
    private final /* synthetic */ Name val$helperName;
    private final /* synthetic */ boolean[] val$helperUsed;

    public /* bridge */ /* synthetic */ Object visitMethodInvocation(MethodInvocationTree methodInvocationTree, Object obj) {
        return visitMethodInvocation(methodInvocationTree, (Void) obj);
    }

    HandleHelper$1(HandleHelper handleHelper, String[] strArr, JavacTreeMaker javacTreeMaker, Name name, boolean[] zArr) {
        this.this$0 = handleHelper;
        this.val$knownMethodNames_ = strArr;
        this.val$maker = javacTreeMaker;
        this.val$helperName = name;
        this.val$helperUsed = zArr;
    }

    public Void visitMethodInvocation(MethodInvocationTree node, Void p) {
        JCTree$JCMethodInvocation jcmi = (JCTree$JCMethodInvocation) node;
        apply(jcmi);
        return (Void) super.visitMethodInvocation(node, p);
    }

    private void apply(JCTree$JCMethodInvocation jcmi) {
        if (jcmi.meth instanceof JCTree$JCIdent) {
            JCTree$JCIdent jci = jcmi.meth;
            if (Arrays.binarySearch(this.val$knownMethodNames_, jci.name.toString()) < 0) {
                return;
            }
            jcmi.meth = this.val$maker.Select(this.val$maker.Ident(this.val$helperName), jci.name);
            this.val$helperUsed[0] = true;
        }
    }
}
