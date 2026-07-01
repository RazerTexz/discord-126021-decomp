package lombok.delombok;

import com.sun.tools.javac.tree.DocCommentTable;
import com.sun.tools.javac.tree.JCTree;

/* JADX INFO: loaded from: app.apk:lombok/delombok/DocCommentIntegrator$CommentAttacher_8.SCL.lombok */
class DocCommentIntegrator$CommentAttacher_8 {
    private DocCommentIntegrator$CommentAttacher_8() {
    }

    static void attach(JCTree node, String docCommentContent, Object map_) {
        ((DocCommentTable) map_).putComment(node, new DocCommentIntegrator$CommentAttacher_8$1(docCommentContent, node));
    }
}
