package lombok.javac;

import com.sun.tools.javac.tree.JCTree;
import java.lang.reflect.Method;
import lombok.permit.Permit;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/PackageName.SCL.lombok */
public class PackageName {
    private static final Method packageNameMethod = getPackageNameMethod();

    private static Method getPackageNameMethod() {
        try {
            return Permit.getMethod(JCTree.JCCompilationUnit.class, "getPackageName", new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getPackageName(JCTree.JCCompilationUnit cu) {
        JCTree t = getPackageNode(cu);
        if (t != null) {
            return t.toString();
        }
        return null;
    }

    public static JCTree getPackageNode(JCTree.JCCompilationUnit cu) {
        if (packageNameMethod != null) {
            try {
                Object pkg = packageNameMethod.invoke(cu, new Object[0]);
                if ((pkg instanceof JCTree.JCFieldAccess) || (pkg instanceof JCTree.JCIdent)) {
                    return (JCTree) pkg;
                }
                return null;
            } catch (Exception unused) {
            }
        }
        if ((cu.pid instanceof JCTree.JCFieldAccess) || (cu.pid instanceof JCTree.JCIdent)) {
            return cu.pid;
        }
        return null;
    }
}
