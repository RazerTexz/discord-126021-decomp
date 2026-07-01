package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.util.Name;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleDelegate$DelegateReceiver$2.SCL.lombok */
enum HandleDelegate$DelegateReceiver$2 extends HandleDelegate$DelegateReceiver {
    HandleDelegate$DelegateReceiver$2(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.javac.handlers.HandleDelegate$DelegateReceiver
    public JCTree$JCExpression get(JavacNode node, Name name) {
        JavacTreeMaker maker = node.getTreeMaker();
        return maker.Select(maker.Ident(node.toName("this")), name);
    }
}
