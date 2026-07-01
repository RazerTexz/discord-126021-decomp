package lombok.eclipse.handlers.singulars;

import java.util.List;
import lombok.AccessLevel;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseSingularsRecipes$SingularData;
import lombok.eclipse.handlers.EclipseSingularsRecipes$StatementMaker;
import lombok.eclipse.handlers.EclipseSingularsRecipes$TypeReferenceMaker;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/singulars/EclipseGuavaMapSingularizer.SCL.lombok */
public class EclipseGuavaMapSingularizer extends EclipseGuavaSingularizer {
    private static final LombokImmutableList<String> SUFFIXES = LombokImmutableList.of("key", "value");
    private static final LombokImmutableList<String> SUPPORTED_TYPES = LombokImmutableList.of("com.google.common.collect.ImmutableMap", "com.google.common.collect.ImmutableBiMap", "com.google.common.collect.ImmutableSortedMap");

    @Override // lombok.eclipse.handlers.singulars.EclipseGuavaSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public /* bridge */ /* synthetic */ List generateFields(EclipseSingularsRecipes$SingularData eclipseSingularsRecipes$SingularData, EclipseNode eclipseNode) {
        return super.generateFields(eclipseSingularsRecipes$SingularData, eclipseNode);
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseGuavaSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public /* bridge */ /* synthetic */ void generateMethods(CheckerFrameworkVersion checkerFrameworkVersion, EclipseSingularsRecipes$SingularData eclipseSingularsRecipes$SingularData, boolean z2, EclipseNode eclipseNode, boolean z3, EclipseSingularsRecipes$TypeReferenceMaker eclipseSingularsRecipes$TypeReferenceMaker, EclipseSingularsRecipes$StatementMaker eclipseSingularsRecipes$StatementMaker, AccessLevel accessLevel) {
        super.generateMethods(checkerFrameworkVersion, eclipseSingularsRecipes$SingularData, z2, eclipseNode, z3, eclipseSingularsRecipes$TypeReferenceMaker, eclipseSingularsRecipes$StatementMaker, accessLevel);
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseGuavaSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public /* bridge */ /* synthetic */ void appendBuildCode(EclipseSingularsRecipes$SingularData eclipseSingularsRecipes$SingularData, EclipseNode eclipseNode, List list, char[] cArr, String str) {
        super.appendBuildCode(eclipseSingularsRecipes$SingularData, eclipseNode, list, cArr, str);
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
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
