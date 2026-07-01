package lombok.javac;

import com.sun.tools.javac.comp.AttrContext;
import com.sun.tools.javac.comp.Enter;
import com.sun.tools.javac.comp.Env;
import com.sun.tools.javac.comp.MemberEnter;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.tree.JCTree$Visitor;
import com.sun.tools.javac.util.Context;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacResolution$EnvFinder.SCL.lombok */
final class JavacResolution$EnvFinder extends JCTree$Visitor {
    private Enter enter;
    private MemberEnter memberEnter;
    private Env<AttrContext> env = null;
    private JCTree copyAt = null;

    JavacResolution$EnvFinder(Context context) {
        this.enter = Enter.instance(context);
        this.memberEnter = MemberEnter.instance(context);
    }

    Env<AttrContext> get() {
        return this.env;
    }

    JCTree copyAt() {
        return this.copyAt;
    }

    public void visitTopLevel(JCTree$JCCompilationUnit tree) {
        if (this.copyAt != null) {
            return;
        }
        this.env = this.enter.getTopLevelEnv(tree);
    }

    public void visitClassDef(JCTree$JCClassDecl tree) {
        if (this.copyAt == null && tree.sym != null) {
            this.env = this.enter.getClassEnv(tree.sym);
        }
    }

    public void visitMethodDef(JCTree$JCMethodDecl tree) {
        if (this.copyAt != null) {
            return;
        }
        this.env = this.memberEnter.getMethodEnv(tree, this.env);
        this.copyAt = tree;
    }

    public void visitVarDef(JCTree$JCVariableDecl tree) {
        if (this.copyAt != null) {
            return;
        }
        this.env = this.memberEnter.getInitEnv(tree, this.env);
        this.copyAt = tree;
    }

    public void visitBlock(JCTree$JCBlock tree) {
        if (this.copyAt != null) {
            return;
        }
        this.copyAt = tree;
    }

    public void visitTree(JCTree that) {
    }
}
