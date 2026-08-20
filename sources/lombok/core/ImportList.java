package lombok.core;

import java.util.Collection;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/ImportList.SCL.lombok */
public interface ImportList {
    String getFullyQualifiedNameForSimpleName(String str);

    String getFullyQualifiedNameForSimpleNameNoAliasing(String str);

    boolean hasStarImport(String str);

    Collection<String> applyNameToStarImports(String str, String str2);

    String applyUnqualifiedNameToPackage(String str);
}
