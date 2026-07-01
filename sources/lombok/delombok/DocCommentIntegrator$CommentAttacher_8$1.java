package lombok.delombok;

import com.sun.tools.javac.parser.Tokens$Comment;
import com.sun.tools.javac.parser.Tokens$Comment$CommentStyle;
import com.sun.tools.javac.tree.JCTree;
import lombok.javac.handlers.JavacHandlerUtil;

/* JADX INFO: loaded from: app.apk:lombok/delombok/DocCommentIntegrator$CommentAttacher_8$1.SCL.lombok */
class DocCommentIntegrator$CommentAttacher_8$1 implements Tokens$Comment {
    private final /* synthetic */ String val$docCommentContent_;
    private final /* synthetic */ JCTree val$node;

    DocCommentIntegrator$CommentAttacher_8$1(String str, JCTree jCTree) {
        this.val$docCommentContent_ = str;
        this.val$node = jCTree;
    }

    public String getText() {
        return this.val$docCommentContent_;
    }

    public int getSourcePos(int index) {
        return -1;
    }

    public Tokens$Comment$CommentStyle getStyle() {
        return Tokens$Comment$CommentStyle.JAVADOC;
    }

    public boolean isDeprecated() {
        return JavacHandlerUtil.nodeHasDeprecatedFlag(this.val$node);
    }
}
