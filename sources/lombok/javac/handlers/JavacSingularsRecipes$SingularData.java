package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacSingularsRecipes$SingularData.SCL.lombok */
public final class JavacSingularsRecipes$SingularData {
    private final JavacNode annotation;
    private final Name singularName;
    private final Name pluralName;
    private final List<JCTree$JCExpression> typeArgs;
    private final String targetFqn;
    private final JavacSingularsRecipes$JavacSingularizer singularizer;
    private final String setterPrefix;
    private final boolean ignoreNullCollections;

    static /* synthetic */ JavacNode access$2(JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData) {
        return javacSingularsRecipes$SingularData.annotation;
    }

    static /* synthetic */ Name access$1(JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData) {
        return javacSingularsRecipes$SingularData.singularName;
    }

    static /* synthetic */ Name access$0(JavacSingularsRecipes$SingularData javacSingularsRecipes$SingularData) {
        return javacSingularsRecipes$SingularData.pluralName;
    }

    public JavacSingularsRecipes$SingularData(JavacNode annotation, Name singularName, Name pluralName, List<JCTree$JCExpression> typeArgs, String targetFqn, JavacSingularsRecipes$JavacSingularizer singularizer, boolean ignoreNullCollections) {
        this(annotation, singularName, pluralName, typeArgs, targetFqn, singularizer, ignoreNullCollections, "");
    }

    public JavacSingularsRecipes$SingularData(JavacNode annotation, Name singularName, Name pluralName, List<JCTree$JCExpression> typeArgs, String targetFqn, JavacSingularsRecipes$JavacSingularizer singularizer, boolean ignoreNullCollections, String setterPrefix) {
        this.annotation = annotation;
        this.singularName = singularName;
        this.pluralName = pluralName;
        this.typeArgs = typeArgs;
        this.targetFqn = targetFqn;
        this.singularizer = singularizer;
        this.setterPrefix = setterPrefix;
        this.ignoreNullCollections = ignoreNullCollections;
    }

    public JavacNode getAnnotation() {
        return this.annotation;
    }

    public Name getSingularName() {
        return this.singularName;
    }

    public Name getPluralName() {
        return this.pluralName;
    }

    public String getSetterPrefix() {
        return this.setterPrefix;
    }

    public List<JCTree$JCExpression> getTypeArgs() {
        return this.typeArgs;
    }

    public String getTargetFqn() {
        return this.targetFqn;
    }

    public JavacSingularsRecipes$JavacSingularizer getSingularizer() {
        return this.singularizer;
    }

    public boolean isIgnoreNullCollections() {
        return this.ignoreNullCollections;
    }

    public String getTargetSimpleType() {
        int idx = this.targetFqn.lastIndexOf(".");
        return idx == -1 ? this.targetFqn : this.targetFqn.substring(idx + 1);
    }
}
