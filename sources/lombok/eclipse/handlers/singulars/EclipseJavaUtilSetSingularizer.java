package lombok.eclipse.handlers.singulars;

import java.util.List;
import lombok.AccessLevel;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseSingularsRecipes$SingularData;
import lombok.eclipse.handlers.EclipseSingularsRecipes$StatementMaker;
import lombok.eclipse.handlers.EclipseSingularsRecipes$TypeReferenceMaker;
import org.eclipse.jdt.internal.compiler.ast.Statement;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/singulars/EclipseJavaUtilSetSingularizer.SCL.lombok */
public class EclipseJavaUtilSetSingularizer extends EclipseJavaUtilListSetSingularizer {
    private static final char[] EMPTY_SORTED_SET = {'e', 'm', 'p', 't', 'y', 'S', 'o', 'r', 't', 'e', 'd', 'S', 'e', 't'};
    private static final char[] EMPTY_NAVIGABLE_SET = {'e', 'm', 'p', 't', 'y', 'N', 'a', 'v', 'i', 'g', 'a', 'b', 'l', 'e', 'S', 'e', 't'};
    private static final char[] EMPTY_SET = {'e', 'm', 'p', 't', 'y', 'S', 'e', 't'};

    @Override // lombok.eclipse.handlers.singulars.EclipseJavaUtilListSetSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public /* bridge */ /* synthetic */ List generateFields(EclipseSingularsRecipes$SingularData eclipseSingularsRecipes$SingularData, EclipseNode eclipseNode) {
        return super.generateFields(eclipseSingularsRecipes$SingularData, eclipseNode);
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseJavaUtilListSetSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public /* bridge */ /* synthetic */ void generateMethods(CheckerFrameworkVersion checkerFrameworkVersion, EclipseSingularsRecipes$SingularData eclipseSingularsRecipes$SingularData, boolean z2, EclipseNode eclipseNode, boolean z3, EclipseSingularsRecipes$TypeReferenceMaker eclipseSingularsRecipes$TypeReferenceMaker, EclipseSingularsRecipes$StatementMaker eclipseSingularsRecipes$StatementMaker, AccessLevel accessLevel) {
        super.generateMethods(checkerFrameworkVersion, eclipseSingularsRecipes$SingularData, z2, eclipseNode, z3, eclipseSingularsRecipes$TypeReferenceMaker, eclipseSingularsRecipes$StatementMaker, accessLevel);
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseJavaUtilListSetSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public /* bridge */ /* synthetic */ List listFieldsToBeGenerated(EclipseSingularsRecipes$SingularData eclipseSingularsRecipes$SingularData, EclipseNode eclipseNode) {
        return super.listFieldsToBeGenerated(eclipseSingularsRecipes$SingularData, eclipseNode);
    }

    @Override // lombok.eclipse.handlers.singulars.EclipseJavaUtilListSetSingularizer, lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public /* bridge */ /* synthetic */ List listMethodsToBeGenerated(EclipseSingularsRecipes$SingularData eclipseSingularsRecipes$SingularData, EclipseNode eclipseNode) {
        return super.listMethodsToBeGenerated(eclipseSingularsRecipes$SingularData, eclipseNode);
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public LombokImmutableList<String> getSupportedTypes() {
        return LombokImmutableList.of("java.util.Set", "java.util.SortedSet", "java.util.NavigableSet");
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    protected char[][] getEmptyMakerReceiver(String targetFqn) {
        return JAVA_UTIL_COLLECTIONS;
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    protected char[] getEmptyMakerSelector(String targetFqn) {
        if (targetFqn.endsWith("SortedSet")) {
            return EMPTY_SORTED_SET;
        }
        return targetFqn.endsWith("NavigableSet") ? EMPTY_NAVIGABLE_SET : EMPTY_SET;
    }

    @Override // lombok.eclipse.handlers.EclipseSingularsRecipes$EclipseSingularizer
    public void appendBuildCode(EclipseSingularsRecipes$SingularData data, EclipseNode builderType, List<Statement> statements, char[] targetVariableName, String builderVariable) {
        if (useGuavaInstead(builderType)) {
            this.guavaListSetSingularizer.appendBuildCode(data, builderType, statements, targetVariableName, builderVariable);
        } else if (data.getTargetFqn().equals("java.util.Set")) {
            statements.addAll(createJavaUtilSetMapInitialCapacitySwitchStatements(data, builderType, false, "emptySet", "singleton", "LinkedHashSet", builderVariable));
        } else {
            statements.addAll(createJavaUtilSimpleCreationAndFillStatements(data, builderType, false, true, false, true, "TreeSet", builderVariable));
        }
    }
}
