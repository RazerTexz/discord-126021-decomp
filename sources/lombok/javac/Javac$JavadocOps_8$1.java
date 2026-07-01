package lombok.javac;

import com.sun.tools.javac.parser.Tokens$Comment;
import com.sun.tools.javac.parser.Tokens$Comment$CommentStyle;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;

/* JADX INFO: loaded from: app.apk:lombok/javac/Javac$JavadocOps_8$1.SCL.lombok */
class Javac$JavadocOps_8$1 implements Tokens$Comment {
    private final /* synthetic */ String val$text;
    private final /* synthetic */ JCTree val$field;

    Javac$JavadocOps_8$1(String str, JCTree jCTree) {
        this.val$text = str;
        this.val$field = jCTree;
    }

    public String getText() {
        return this.val$text;
    }

    public int getSourcePos(int index) {
        return -1;
    }

    public Tokens$Comment$CommentStyle getStyle() {
        return Tokens$Comment$CommentStyle.JAVADOC;
    }

    public boolean isDeprecated() {
        return this.val$text.contains("@deprecated") && (this.val$field instanceof JCTree$JCVariableDecl) && Javac.isFieldDeprecated(this.val$field);
    }
}
