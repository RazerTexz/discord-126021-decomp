package lombok.delombok;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import lombok.javac.CommentInfo;
import lombok.javac.Javac;
import lombok.javac.PackageName;

/* JADX INFO: loaded from: app.apk:lombok/delombok/DocCommentIntegrator.SCL.lombok */
public class DocCommentIntegrator {
    private static final Pattern CONTENT_STRIPPER = Pattern.compile("^(?:\\s*\\*)?(.*?)$", 8);

    public List<CommentInfo> integrate(List<CommentInfo> comments, JCTree$JCCompilationUnit unit) {
        List<CommentInfo> out = new ArrayList<>();
        CommentInfo lastExcisedComment = null;
        JCTree lastNode = null;
        for (CommentInfo cmt : comments) {
            if (!cmt.isJavadoc()) {
                out.add(cmt);
            } else {
                JCTree node = findJavadocableNodeOnOrAfter(unit, cmt.endPos);
                if (node == null) {
                    out.add(cmt);
                } else {
                    if (node == lastNode) {
                        out.add(lastExcisedComment);
                    }
                    if (!attach(unit, node, cmt)) {
                        out.add(cmt);
                    } else {
                        lastNode = node;
                        lastExcisedComment = cmt;
                    }
                }
            }
        }
        return out;
    }

    private boolean attach(JCTree$JCCompilationUnit top, JCTree node, CommentInfo cmt) {
        String docCommentContent = cmt.content;
        if (docCommentContent.startsWith("/**")) {
            docCommentContent = docCommentContent.substring(3);
        }
        if (docCommentContent.endsWith("*/")) {
            docCommentContent = docCommentContent.substring(0, docCommentContent.length() - 2);
        }
        String docCommentContent2 = CONTENT_STRIPPER.matcher(docCommentContent).replaceAll("$1").trim();
        if (Javac.getDocComments(top) == null) {
            Javac.initDocComments(top);
        }
        Object map_ = Javac.getDocComments(top);
        if (map_ instanceof Map) {
            ((Map) map_).put(node, docCommentContent2);
            return true;
        }
        if (Javac.instanceOfDocCommentTable(map_)) {
            DocCommentIntegrator$CommentAttacher_8.attach(node, docCommentContent2, map_);
            return true;
        }
        return false;
    }

    private JCTree findJavadocableNodeOnOrAfter(JCTree$JCCompilationUnit unit, int endPos) {
        JCTree pid = PackageName.getPackageNode(unit);
        if (pid != null && endPos <= pid.pos) {
            return null;
        }
        Iterator<JCTree> it = unit.defs.iterator();
        while (it.hasNext()) {
            JCTree next = it.next();
            if (next.pos < endPos) {
                if (next instanceof JCTree$JCClassDecl) {
                    com.sun.tools.javac.util.List<JCTree> defs = ((JCTree$JCClassDecl) next).defs;
                    if (!defs.isEmpty()) {
                        while (!defs.tail.isEmpty()) {
                            defs = defs.tail;
                        }
                    }
                    if (defs.head != null && ((JCTree) defs.head).pos >= endPos) {
                        it = ((JCTree$JCClassDecl) next).defs.iterator();
                    }
                }
            } else {
                if ((next instanceof JCTree$JCMethodDecl) || (next instanceof JCTree$JCClassDecl) || (next instanceof JCTree$JCVariableDecl)) {
                    return next;
                }
                return null;
            }
        }
        return null;
    }
}
