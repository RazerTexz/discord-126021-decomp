package lombok.javac;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import com.sun.tools.javac.tree.JCTree$JCFieldAccess;
import com.sun.tools.javac.tree.JCTree$JCImport;
import com.sun.tools.javac.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import lombok.core.ImportList;
import lombok.core.LombokInternalAliasing;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacImportList.SCL.lombok */
public class JavacImportList implements ImportList {
    private final String pkgStr;
    private final List<JCTree> defs;

    public JavacImportList(JCTree$JCCompilationUnit cud) {
        this.pkgStr = PackageName.getPackageName(cud);
        this.defs = cud.defs;
    }

    @Override // lombok.core.ImportList
    public String getFullyQualifiedNameForSimpleName(String unqualified) {
        String q = getFullyQualifiedNameForSimpleNameNoAliasing(unqualified);
        if (q == null) {
            return null;
        }
        return LombokInternalAliasing.processAliases(q);
    }

    @Override // lombok.core.ImportList
    public String getFullyQualifiedNameForSimpleNameNoAliasing(String unqualified) {
        Iterator it = this.defs.iterator();
        while (it.hasNext()) {
            JCTree$JCImport jCTree$JCImport = (JCTree) it.next();
            if (jCTree$JCImport instanceof JCTree$JCImport) {
                JCTree$JCFieldAccess jCTree$JCFieldAccess = jCTree$JCImport.qualid;
                if (jCTree$JCFieldAccess instanceof JCTree$JCFieldAccess) {
                    String simpleName = jCTree$JCFieldAccess.name.toString();
                    if (simpleName.equals(unqualified)) {
                        return jCTree$JCFieldAccess.toString();
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    @Override // lombok.core.ImportList
    public boolean hasStarImport(String packageName) {
        if ((this.pkgStr != null && this.pkgStr.equals(packageName)) || "java.lang".equals(packageName)) {
            return true;
        }
        Iterator it = this.defs.iterator();
        while (it.hasNext()) {
            JCTree$JCImport jCTree$JCImport = (JCTree) it.next();
            if ((jCTree$JCImport instanceof JCTree$JCImport) && !jCTree$JCImport.staticImport) {
                JCTree$JCFieldAccess jCTree$JCFieldAccess = jCTree$JCImport.qualid;
                if (jCTree$JCFieldAccess instanceof JCTree$JCFieldAccess) {
                    String simpleName = jCTree$JCFieldAccess.name.toString();
                    if ("*".equals(simpleName)) {
                        String starImport = jCTree$JCFieldAccess.selected.toString();
                        if (packageName.equals(starImport)) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    @Override // lombok.core.ImportList
    public Collection<String> applyNameToStarImports(String startsWith, String name) {
        ArrayList<String> out = new ArrayList<>();
        if (this.pkgStr != null && topLevelName(this.pkgStr).equals(startsWith)) {
            out.add(String.valueOf(this.pkgStr) + "." + name);
        }
        Iterator it = this.defs.iterator();
        while (it.hasNext()) {
            JCTree$JCImport jCTree$JCImport = (JCTree) it.next();
            if ((jCTree$JCImport instanceof JCTree$JCImport) && !jCTree$JCImport.staticImport) {
                JCTree$JCFieldAccess jCTree$JCFieldAccess = jCTree$JCImport.qualid;
                if (jCTree$JCFieldAccess instanceof JCTree$JCFieldAccess) {
                    String simpleName = jCTree$JCFieldAccess.name.toString();
                    if ("*".equals(simpleName)) {
                        String topLevelName = topLevelName((JCTree) jCTree$JCFieldAccess);
                        if (topLevelName.equals(startsWith)) {
                            out.add(String.valueOf(jCTree$JCFieldAccess.selected.toString()) + "." + name);
                        }
                    }
                }
            }
        }
        return out;
    }

    private String topLevelName(JCTree tree) {
        while (tree instanceof JCTree$JCFieldAccess) {
            tree = ((JCTree$JCFieldAccess) tree).selected;
        }
        return tree.toString();
    }

    private String topLevelName(String packageName) {
        int idx = packageName.indexOf(".");
        return idx == -1 ? packageName : packageName.substring(0, idx);
    }

    @Override // lombok.core.ImportList
    public String applyUnqualifiedNameToPackage(String unqualified) {
        return this.pkgStr == null ? unqualified : String.valueOf(this.pkgStr) + "." + unqualified;
    }
}
