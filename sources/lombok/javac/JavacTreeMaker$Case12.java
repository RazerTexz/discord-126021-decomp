package lombok.javac;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCCase;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.List;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker$Case12.SCL.lombok */
public class JavacTreeMaker$Case12 {
    private static final Class<?> CASE_KIND_CLASS = JavacTreeMaker.classForName(TreeMaker.class, "com.sun.source.tree.CaseTree$CaseKind");
    static final JavacTreeMaker$MethodId<JCTree$JCCase> Case12 = JavacTreeMaker.MethodId("Case", JCTree$JCCase.class, CASE_KIND_CLASS, List.class, List.class, JCTree.class);
    static final Object CASE_KIND_STATEMENT = CASE_KIND_CLASS.getEnumConstants()[0];
}
