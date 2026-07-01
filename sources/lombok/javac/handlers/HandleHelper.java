package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCCase;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCStatement;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import lombok.ConfigurationKeys;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.Helper;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleHelper.SCL.lombok */
public class HandleHelper extends JavacAnnotationHandler<Helper> {
    private List<JCTree$JCStatement> getStatementsFromJcNode(JCTree tree) {
        if (tree instanceof JCTree$JCBlock) {
            return ((JCTree$JCBlock) tree).stats;
        }
        if (tree instanceof JCTree$JCCase) {
            return ((JCTree$JCCase) tree).stats;
        }
        return null;
    }

    private void setStatementsOfJcNode(JCTree tree, List<JCTree$JCStatement> statements) {
        if (!(tree instanceof JCTree$JCBlock)) {
            if (!(tree instanceof JCTree$JCCase)) {
                throw new IllegalArgumentException("Can't set statements on node type: " + tree.getClass());
            }
            ((JCTree$JCCase) tree).stats = statements;
            return;
        }
        ((JCTree$JCBlock) tree).stats = statements;
    }

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Helper> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        String n;
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.HELPER_FLAG_USAGE, "@Helper");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) Helper.class);
        JavacNode annotatedType = annotationNode.up();
        JavacNode containingBlock = annotatedType == null ? null : annotatedType.directUp();
        List<JCTree$JCStatement> origStatements = getStatementsFromJcNode(containingBlock == null ? null : containingBlock.get());
        if (annotatedType == null || annotatedType.getKind() != AST$Kind.TYPE || origStatements == null) {
            annotationNode.addError("@Helper is legal only on method-local classes.");
            return;
        }
        JCTree$JCStatement jCTree$JCStatement = (JCTree$JCClassDecl) annotatedType.get();
        Iterator<JCTree$JCStatement> it = origStatements.iterator();
        while (it.hasNext() && it.next() != jCTree$JCStatement) {
        }
        java.util.List<String> knownMethodNames = new ArrayList<>();
        for (JavacNode ch : annotatedType.down()) {
            if (ch.getKind() == AST$Kind.METHOD && (n = ch.getName()) != null && !n.isEmpty() && n.charAt(0) != '<') {
                knownMethodNames.add(n);
            }
        }
        Collections.sort(knownMethodNames);
        String[] knownMethodNames_ = (String[]) knownMethodNames.toArray(new String[0]);
        Name helperName = annotationNode.toName("$" + ((JCTree$JCClassDecl) jCTree$JCStatement).name);
        boolean[] helperUsed = new boolean[1];
        JavacTreeMaker maker = annotationNode.getTreeMaker();
        HandleHelper$1 handleHelper$1 = new HandleHelper$1(this, knownMethodNames_, maker, helperName, helperUsed);
        while (it.hasNext()) {
            it.next().accept(handleHelper$1, (Object) null);
        }
        if (!helperUsed[0]) {
            annotationNode.addWarning("No methods of this helper class are ever used.");
            return;
        }
        ListBuffer<JCTree$JCStatement> newStatements = new ListBuffer<>();
        boolean mark = false;
        for (JCTree$JCStatement stat : origStatements) {
            newStatements.append(stat);
            if (!mark && stat == jCTree$JCStatement) {
                mark = true;
                JCTree$JCVariableDecl decl = maker.VarDef(maker.Modifiers(16L), helperName, maker.Ident(((JCTree$JCClassDecl) jCTree$JCStatement).name), maker.NewClass(null, List.nil(), maker.Ident(((JCTree$JCClassDecl) jCTree$JCStatement).name), List.nil(), null));
                newStatements.append(decl);
            }
        }
        setStatementsOfJcNode(containingBlock.get(), newStatements.toList());
    }
}
