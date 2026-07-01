package lombok.eclipse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lombok.core.ImportList;
import lombok.core.LombokInternalAliasing;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/EclipseImportList.SCL.lombok */
public class EclipseImportList implements ImportList {
    private ImportReference[] imports;
    private ImportReference pkg;

    public EclipseImportList(CompilationUnitDeclaration cud) {
        this.pkg = cud.currentPackage;
        this.imports = cud.imports;
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
        if (this.imports != null) {
            for (ImportReference imp : this.imports) {
                if ((imp.bits & 131072) == 0) {
                    char[][] tokens = imp.tokens;
                    char[] token = tokens.length == 0 ? new char[0] : tokens[tokens.length - 1];
                    int len = token.length;
                    if (len == unqualified.length()) {
                        for (int i = 0; i < len; i++) {
                            if (token[i] == unqualified.charAt(i)) {
                            }
                        }
                        return Eclipse.toQualifiedName(tokens);
                    }
                    continue;
                }
            }
            return null;
        }
        return null;
    }

    @Override // lombok.core.ImportList
    public boolean hasStarImport(String packageName) {
        if (isEqual(packageName, this.pkg) || "java.lang".equals(packageName)) {
            return true;
        }
        if (this.imports != null) {
            for (ImportReference imp : this.imports) {
                if ((imp.bits & 131072) != 0 && !imp.isStatic() && isEqual(packageName, imp)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean isEqual(String packageName, ImportReference pkgOrStarImport) {
        if (pkgOrStarImport == null || pkgOrStarImport.tokens == null || pkgOrStarImport.tokens.length == 0) {
            return packageName.isEmpty();
        }
        int pos = 0;
        int len = packageName.length();
        for (int i = 0; i < pkgOrStarImport.tokens.length; i++) {
            if (i != 0) {
                if (pos >= len) {
                    return false;
                }
                int i2 = pos;
                pos++;
                if (packageName.charAt(i2) != '.') {
                    return false;
                }
            }
            for (int j = 0; j < pkgOrStarImport.tokens[i].length; j++) {
                if (pos >= len) {
                    return false;
                }
                int i3 = pos;
                pos++;
                if (packageName.charAt(i3) != pkgOrStarImport.tokens[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // lombok.core.ImportList
    public Collection<String> applyNameToStarImports(String startsWith, String name) {
        List<String> out = Collections.emptyList();
        if (this.pkg != null && this.pkg.tokens != null && this.pkg.tokens.length != 0) {
            char[] first = this.pkg.tokens[0];
            int len = first.length;
            boolean match = true;
            if (startsWith.length() == len) {
                for (int i = 0; match && i < len; i++) {
                    if (startsWith.charAt(i) != first[i]) {
                        match = false;
                    }
                }
                if (match) {
                    out.add(String.valueOf(Eclipse.toQualifiedName(this.pkg.tokens)) + "." + name);
                }
            }
        }
        if (this.imports != null) {
            for (ImportReference imp : this.imports) {
                if ((imp.bits & 131072) != 0 && !imp.isStatic() && imp.tokens != null && imp.tokens.length != 0) {
                    char[] firstToken = imp.tokens[0];
                    if (firstToken.length == startsWith.length()) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= firstToken.length) {
                                String fqn = String.valueOf(Eclipse.toQualifiedName(imp.tokens)) + "." + name;
                                if (!out.isEmpty()) {
                                    if (out.size() == 1) {
                                        out = new ArrayList<>(out);
                                        out.add(fqn);
                                        break;
                                    }
                                    out.add(fqn);
                                    break;
                                }
                                out = Collections.singletonList(fqn);
                                break;
                            }
                            if (startsWith.charAt(i2) != firstToken[i2]) {
                                break;
                            }
                            i2++;
                        }
                    }
                }
            }
        }
        return out;
    }

    @Override // lombok.core.ImportList
    public String applyUnqualifiedNameToPackage(String unqualified) {
        return (this.pkg == null || this.pkg.tokens == null || this.pkg.tokens.length == 0) ? unqualified : String.valueOf(Eclipse.toQualifiedName(this.pkg.tokens)) + "." + unqualified;
    }
}
