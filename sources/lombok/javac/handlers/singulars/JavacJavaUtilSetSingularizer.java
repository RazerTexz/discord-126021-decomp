package lombok.javac.handlers.singulars;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCStatement;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.JavacSingularsRecipes$ExpressionMaker;
import lombok.javac.handlers.JavacSingularsRecipes$SingularData;
import lombok.javac.handlers.JavacSingularsRecipes$StatementMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/singulars/JavacJavaUtilSetSingularizer.SCL.lombok */
public class JavacJavaUtilSetSingularizer extends JavacJavaUtilListSetSingularizer {
    @Override // lombok.javac.handlers.singulars.JavacJavaUtilListSetSingularizer, lombok.javac.handlers.JavacSingularsRecipes$JavacSingularizer
    public /* bridge */ /* synthetic */ List generateFields(JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, JavacNode javacNode, JCTree jCTree) {
        return super.generateFields(javacSingularsRecipes$SingularData, javacNode, jCTree);
    }

    @Override // lombok.javac.handlers.singulars.JavacJavaUtilListSetSingularizer, lombok.javac.handlers.JavacSingularsRecipes$JavacSingularizer
    public /* bridge */ /* synthetic */ void generateMethods(CheckerFrameworkVersion checkerFrameworkVersion, JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, boolean z2, JavacNode javacNode, JCTree jCTree, boolean z3, JavacSingularsRecipes$ExpressionMaker javacSingularsRecipes$ExpressionMaker, JavacSingularsRecipes$StatementMaker javacSingularsRecipes$StatementMaker, AccessLevel accessLevel) {
        super.generateMethods(checkerFrameworkVersion, javacSingularsRecipes$SingularData, z2, javacNode, jCTree, z3, javacSingularsRecipes$ExpressionMaker, javacSingularsRecipes$StatementMaker, accessLevel);
    }

    @Override // lombok.javac.handlers.singulars.JavacJavaUtilListSetSingularizer, lombok.javac.handlers.JavacSingularsRecipes$JavacSingularizer
    public /* bridge */ /* synthetic */ List listFieldsToBeGenerated(JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, JavacNode javacNode) {
        return super.listFieldsToBeGenerated(javacSingularsRecipes$SingularData, javacNode);
    }

    @Override // lombok.javac.handlers.singulars.JavacJavaUtilListSetSingularizer, lombok.javac.handlers.JavacSingularsRecipes$JavacSingularizer
    public /* bridge */ /* synthetic */ List listMethodsToBeGenerated(JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, JavacNode javacNode) {
        return super.listMethodsToBeGenerated(javacSingularsRecipes$SingularData, javacNode);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes$JavacSingularizer
    public LombokImmutableList<String> getSupportedTypes() {
        return LombokImmutableList.of("java.util.Set", "java.util.SortedSet", "java.util.NavigableSet");
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes$JavacSingularizer
    protected String getEmptyMaker(String target) {
        if (target.endsWith("SortedSet")) {
            return "java.util.Collections.emptySortedSet";
        }
        return target.endsWith("NavigableSet") ? "java.util.Collections.emptyNavigableSet" : "java.util.Collections.emptySet";
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes$JavacSingularizer
    public void appendBuildCode(JavacSingularsRecipes$SingularData data, JavacNode builderType, JCTree source, ListBuffer<JCTree$JCStatement> statements, Name targetVariableName, String builderVariable) {
        JavacTreeMaker maker = builderType.getTreeMaker();
        if (data.getTargetFqn().equals("java.util.Set")) {
            statements.appendList(createJavaUtilSetMapInitialCapacitySwitchStatements(maker, data, builderType, false, "emptySet", "singleton", "LinkedHashSet", source, builderVariable));
        } else {
            statements.appendList(createJavaUtilSimpleCreationAndFillStatements(maker, data, builderType, false, true, false, true, "TreeSet", source, builderVariable));
        }
    }
}
