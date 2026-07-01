package lombok.javac;

import com.sun.source.tree.LabeledStatementTree;
import com.sun.source.tree.VariableTree;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.tree.TreeCopier;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: app.apk:lombok/javac/TreeMirrorMaker.SCL.lombok */
public class TreeMirrorMaker extends TreeCopier<Void> {
    private final IdentityHashMap<JCTree, JCTree> originalToCopy;

    public /* bridge */ /* synthetic */ JCTree visitLabeledStatement(LabeledStatementTree labeledStatementTree, Object obj) {
        return visitLabeledStatement(labeledStatementTree, (Void) obj);
    }

    public /* bridge */ /* synthetic */ JCTree visitVariable(VariableTree variableTree, Object obj) {
        return visitVariable(variableTree, (Void) obj);
    }

    public /* bridge */ /* synthetic */ List copy(List list, Object obj) {
        return copy(list, (Void) obj);
    }

    public /* bridge */ /* synthetic */ JCTree copy(JCTree jCTree, Object obj) {
        return copy(jCTree, (Void) obj);
    }

    public TreeMirrorMaker(JavacTreeMaker maker, Context context) {
        super(maker.getUnderlyingTreeMaker());
        this.originalToCopy = new IdentityHashMap<>();
    }

    public <T extends JCTree> T copy(T t) {
        T t2 = (T) super.copy(t);
        this.originalToCopy.put(t, t2);
        return t2;
    }

    public <T extends JCTree> T copy(T t, Void r6) {
        T t2 = (T) super.copy(t, r6);
        this.originalToCopy.put(t, t2);
        return t2;
    }

    public <T extends JCTree> List<T> copy(List<T> originals) {
        List<T> copies = super.copy(originals);
        if (originals != null) {
            Iterator<T> it1 = originals.iterator();
            Iterator<T> it2 = copies.iterator();
            while (it1.hasNext()) {
                this.originalToCopy.put(it1.next(), it2.next());
            }
        }
        return copies;
    }

    public <T extends JCTree> List<T> copy(List<T> originals, Void p) {
        List<T> copies = super.copy(originals, p);
        if (originals != null) {
            Iterator<T> it1 = originals.iterator();
            Iterator<T> it2 = copies.iterator();
            while (it1.hasNext()) {
                this.originalToCopy.put(it1.next(), it2.next());
            }
        }
        return copies;
    }

    public Map<JCTree, JCTree> getOriginalToCopyMap() {
        return Collections.unmodifiableMap(this.originalToCopy);
    }

    public JCTree visitVariable(VariableTree node, Void p) {
        JCTree$JCVariableDecl original = node instanceof JCTree$JCVariableDecl ? (JCTree$JCVariableDecl) node : null;
        JCTree$JCVariableDecl copy = super.visitVariable(node, p);
        if (original == null) {
            return copy;
        }
        copy.sym = original.sym;
        if (copy.sym != null) {
            copy.type = original.type;
        }
        if (copy.type != null) {
            boolean wipeSymAndType = copy.type.isErroneous();
            if (!wipeSymAndType) {
                JavacTreeMaker$TypeTag typeTag = JavacTreeMaker$TypeTag.typeTag(copy.type);
                wipeSymAndType = Javac.CTC_NONE.equals(typeTag) || Javac.CTC_ERROR.equals(typeTag) || Javac.CTC_UNKNOWN.equals(typeTag) || Javac.CTC_UNDETVAR.equals(typeTag);
            }
            if (wipeSymAndType) {
                copy.sym = null;
                copy.type = null;
            }
        }
        return copy;
    }

    public JCTree visitLabeledStatement(LabeledStatementTree node, Void p) {
        return (JCTree) node.getStatement().accept(this, p);
    }
}
