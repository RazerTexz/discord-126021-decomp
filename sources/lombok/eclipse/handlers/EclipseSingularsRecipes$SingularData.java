package lombok.eclipse.handlers;

import java.util.List;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseSingularsRecipes$SingularData.SCL.lombok */
public final class EclipseSingularsRecipes$SingularData {
    private final EclipseNode annotation;
    private final char[] singularName;
    private final char[] pluralName;
    private final char[] setterPrefix;
    private final List<TypeReference> typeArgs;
    private final String targetFqn;
    private final EclipseSingularsRecipes$EclipseSingularizer singularizer;
    private final boolean ignoreNullCollections;
    private final ASTNode source;

    static /* synthetic */ char[] access$1(EclipseSingularsRecipes$SingularData eclipseSingularsRecipes$SingularData) {
        return eclipseSingularsRecipes$SingularData.singularName;
    }

    static /* synthetic */ char[] access$0(EclipseSingularsRecipes$SingularData eclipseSingularsRecipes$SingularData) {
        return eclipseSingularsRecipes$SingularData.pluralName;
    }

    public EclipseSingularsRecipes$SingularData(EclipseNode annotation, char[] singularName, char[] pluralName, List<TypeReference> typeArgs, String targetFqn, EclipseSingularsRecipes$EclipseSingularizer singularizer, ASTNode source, boolean ignoreNullCollections) {
        this(annotation, singularName, pluralName, typeArgs, targetFqn, singularizer, source, ignoreNullCollections, new char[0]);
    }

    public EclipseSingularsRecipes$SingularData(EclipseNode annotation, char[] singularName, char[] pluralName, List<TypeReference> typeArgs, String targetFqn, EclipseSingularsRecipes$EclipseSingularizer singularizer, ASTNode source, boolean ignoreNullCollections, char[] setterPrefix) {
        this.annotation = annotation;
        this.singularName = singularName;
        this.pluralName = pluralName;
        this.typeArgs = typeArgs;
        this.targetFqn = targetFqn;
        this.singularizer = singularizer;
        this.source = source;
        this.ignoreNullCollections = ignoreNullCollections;
        this.setterPrefix = setterPrefix;
    }

    public void setGeneratedByRecursive(ASTNode target) {
        SetGeneratedByVisitor visitor = new SetGeneratedByVisitor(this.source);
        if (target instanceof AbstractMethodDeclaration) {
            ((AbstractMethodDeclaration) target).traverse(visitor, (ClassScope) null);
        } else if (target instanceof FieldDeclaration) {
            ((FieldDeclaration) target).traverse(visitor, (MethodScope) null);
        } else {
            target.traverse(visitor, (BlockScope) null);
        }
    }

    public ASTNode getSource() {
        return this.source;
    }

    public EclipseNode getAnnotation() {
        return this.annotation;
    }

    public char[] getSingularName() {
        return this.singularName;
    }

    public char[] getPluralName() {
        return this.pluralName;
    }

    public char[] getSetterPrefix() {
        return this.setterPrefix;
    }

    public List<TypeReference> getTypeArgs() {
        return this.typeArgs;
    }

    public String getTargetFqn() {
        return this.targetFqn;
    }

    public EclipseSingularsRecipes$EclipseSingularizer getSingularizer() {
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
