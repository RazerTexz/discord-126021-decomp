package lombok.javac.handlers.singulars;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.javac.JavacNode;
import lombok.javac.handlers.JavacSingularsRecipes$ExpressionMaker;
import lombok.javac.handlers.JavacSingularsRecipes$SingularData;
import lombok.javac.handlers.JavacSingularsRecipes$StatementMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/singulars/JavacGuavaMapSingularizer.SCL.lombok */
public class JavacGuavaMapSingularizer extends JavacGuavaSingularizer {
    private static final LombokImmutableList<String> SUFFIXES = LombokImmutableList.of("key", "value");
    private static final LombokImmutableList<String> SUPPORTED_TYPES = LombokImmutableList.of("com.google.common.collect.ImmutableMap", "com.google.common.collect.ImmutableBiMap", "com.google.common.collect.ImmutableSortedMap");

    @Override // lombok.javac.handlers.singulars.JavacGuavaSingularizer, lombok.javac.handlers.JavacSingularsRecipes$JavacSingularizer
    public /* bridge */ /* synthetic */ List generateFields(JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, JavacNode javacNode, JCTree jCTree) {
        return super.generateFields(javacSingularsRecipes$SingularData, javacNode, jCTree);
    }

    @Override // lombok.javac.handlers.singulars.JavacGuavaSingularizer, lombok.javac.handlers.JavacSingularsRecipes$JavacSingularizer
    public /* bridge */ /* synthetic */ void generateMethods(CheckerFrameworkVersion checkerFrameworkVersion, JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, boolean z2, JavacNode javacNode, JCTree jCTree, boolean z3, JavacSingularsRecipes$ExpressionMaker javacSingularsRecipes$ExpressionMaker, JavacSingularsRecipes$StatementMaker javacSingularsRecipes$StatementMaker, AccessLevel accessLevel) {
        super.generateMethods(checkerFrameworkVersion, javacSingularsRecipes$SingularData, z2, javacNode, jCTree, z3, javacSingularsRecipes$ExpressionMaker, javacSingularsRecipes$StatementMaker, accessLevel);
    }

    @Override // lombok.javac.handlers.singulars.JavacGuavaSingularizer, lombok.javac.handlers.JavacSingularsRecipes$JavacSingularizer
    public /* bridge */ /* synthetic */ void appendBuildCode(JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData, JavacNode javacNode, JCTree jCTree, ListBuffer listBuffer, Name name, String str) {
        super.appendBuildCode(javacSingularsRecipes$SingularData, javacNode, jCTree, listBuffer, name, str);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes$JavacSingularizer
    public LombokImmutableList<String> getSupportedTypes() {
        return SUPPORTED_TYPES;
    }

    @Override // lombok.javac.handlers.singulars.JavacGuavaSingularizer
    protected LombokImmutableList<String> getArgumentSuffixes() {
        return SUFFIXES;
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes$JavacSingularizer
    protected String getAddMethodName() {
        return "put";
    }

    @Override // lombok.javac.handlers.singulars.JavacGuavaSingularizer
    protected String getAddAllTypeName() {
        return "java.util.Map";
    }
}
