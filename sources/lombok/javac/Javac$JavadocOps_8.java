package lombok.javac;

import com.sun.tools.javac.parser.Tokens$Comment;
import com.sun.tools.javac.tree.DocCommentTable;
import com.sun.tools.javac.tree.JCTree;

/* JADX INFO: loaded from: app.apk:lombok/javac/Javac$JavadocOps_8.SCL.lombok */
class Javac$JavadocOps_8 {
    private Javac$JavadocOps_8() {
    }

    static String getJavadoc(Object dc, JCTree node) {
        DocCommentTable dct = (DocCommentTable) dc;
        Tokens$Comment javadoc = dct.getComment(node);
        if (javadoc == null) {
            return null;
        }
        return javadoc.getText();
    }

    static void setJavadoc(Object dc, JCTree node, String javadoc) {
        DocCommentTable dct = (DocCommentTable) dc;
        Tokens$Comment newCmt = createJavadocComment(javadoc, node);
        dct.putComment(node, newCmt);
    }

    private static Tokens$Comment createJavadocComment(String text, JCTree field) {
        return new Javac$JavadocOps_8$1(text, field);
    }
}
