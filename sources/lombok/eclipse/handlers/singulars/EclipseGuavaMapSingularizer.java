package lombok.eclipse.handlers.singulars;

import java.util.List;
import lombok.AccessLevel;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseSingularsRecipes;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/handlers/singulars/EclipseGuavaMapSingularizer.SCL.lombok */
public class EclipseGuavaMapSingularizer extends EclipseGuavaSingularizer {
    private static final LombokImmutableList<String> SUFFIXES = LombokImmutableList.m10920of("key", "value");
    private static final LombokImmutableList<String> SUPPORTED_TYPES = LombokImmutableList.m10921of("com.google.common.collect.ImmutableMap", "com.google.common.collect.ImmutableBiMap", "com.google.common.collect.ImmutableSortedMap");

    @Override // lombok.eclipse.handlers.singulars.EclipseGuavaSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public /* bridge */ /* synthetic */ List generateFields(EclipseSingularsRecipes.SingularData singularData, EclipseNode eclipseNode) {
        return super.generateFields(singularData, eclipseNode);
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseGuavaSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public /* bridge */ /* synthetic */ void generateMethods(CheckerFrameworkVersion checkerFrameworkVersion, EclipseSingularsRecipes.SingularData singularData, boolean z2, EclipseNode eclipseNode, boolean z3, EclipseSingularsRecipes.TypeReferenceMaker typeReferenceMaker, EclipseSingularsRecipes.StatementMaker statementMaker, AccessLevel accessLevel) {
        super.generateMethods(checkerFrameworkVersion, singularData, z2, eclipseNode, z3, typeReferenceMaker, statementMaker, accessLevel);
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseGuavaSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public /* bridge */ /* synthetic */ void appendBuildCode(EclipseSingularsRecipes.SingularData singularData, EclipseNode eclipseNode, List list, char[] cArr, String str) {
        super.appendBuildCode(singularData, eclipseNode, list, cArr, str);
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer
    public LombokImmutableList<String> getSupportedTypes() {
        return SUPPORTED_TYPES;
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseGuavaSingularizer
    protected LombokImmutableList<String> getArgumentSuffixes() {
        return SUFFIXES;
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseGuavaSingularizer
    protected String getAddMethodName() {
        return "put";
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseGuavaSingularizer
    protected String getAddAllTypeName() {
        return "java.util.Map";
    }
}
