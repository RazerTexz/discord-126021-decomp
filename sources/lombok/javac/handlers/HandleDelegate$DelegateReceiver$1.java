package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleDelegate$DelegateReceiver$1.SCL.lombok */
enum HandleDelegate$DelegateReceiver$1 extends HandleDelegate$DelegateReceiver {
    HandleDelegate$DelegateReceiver$1(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.javac.handlers.HandleDelegate$DelegateReceiver
    public JCTree$JCExpression get(JavacNode node, Name name) {
        List<JCTree$JCExpression> nilExprs = List.nil();
        JavacTreeMaker maker = node.getTreeMaker();
        return maker.Apply(nilExprs, maker.Select(maker.Ident(node.toName("this")), name), nilExprs);
    }
}
