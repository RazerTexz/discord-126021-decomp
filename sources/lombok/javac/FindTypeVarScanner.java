package lombok.javac;

import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.util.Name;
import java.util.HashSet;
import java.util.Set;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.AbstractTypeVisitor6;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/FindTypeVarScanner.SCL.lombok */
public class FindTypeVarScanner extends AbstractTypeVisitor6<Void, Void> {
    private Set<String> typeVariables = new HashSet();

    public /* bridge */ /* synthetic */ Object visitError(ErrorType errorType, Object obj) {
        return visitError(errorType, (Void) obj);
    }

    public /* bridge */ /* synthetic */ Object visitWildcard(WildcardType wildcardType, Object obj) {
        return visitWildcard(wildcardType, (Void) obj);
    }

    public /* bridge */ /* synthetic */ Object visitArray(ArrayType arrayType, Object obj) {
        return visitArray(arrayType, (Void) obj);
    }

    public /* bridge */ /* synthetic */ Object visitExecutable(ExecutableType executableType, Object obj) {
        return visitExecutable(executableType, (Void) obj);
    }

    public /* bridge */ /* synthetic */ Object visitDeclared(DeclaredType declaredType, Object obj) {
        return visitDeclared(declaredType, (Void) obj);
    }

    public /* bridge */ /* synthetic */ Object visitUnknown(TypeMirror typeMirror, Object obj) {
        return visitUnknown(typeMirror, (Void) obj);
    }

    public /* bridge */ /* synthetic */ Object visitTypeVariable(TypeVariable typeVariable, Object obj) {
        return visitTypeVariable(typeVariable, (Void) obj);
    }

    public /* bridge */ /* synthetic */ Object visitNull(NullType nullType, Object obj) {
        return visitNull(nullType, (Void) obj);
    }

    public /* bridge */ /* synthetic */ Object visitPrimitive(PrimitiveType primitiveType, Object obj) {
        return visitPrimitive(primitiveType, (Void) obj);
    }

    public /* bridge */ /* synthetic */ Object visitNoType(NoType noType, Object obj) {
        return visitNoType(noType, (Void) obj);
    }

    public Set<String> getTypeVariables() {
        return this.typeVariables;
    }

    private Void subVisit(TypeMirror mirror) {
        if (mirror == null) {
            return null;
        }
        return (Void) mirror.accept(this, (Object) null);
    }

    public Void visitPrimitive(PrimitiveType t, Void p) {
        return null;
    }

    public Void visitNull(NullType t, Void p) {
        return null;
    }

    public Void visitNoType(NoType t, Void p) {
        return null;
    }

    public Void visitUnknown(TypeMirror t, Void p) {
        return null;
    }

    public Void visitError(ErrorType t, Void p) {
        return null;
    }

    public Void visitArray(ArrayType t, Void p) {
        return subVisit(t.getComponentType());
    }

    public Void visitDeclared(DeclaredType t, Void p) {
        for (TypeMirror subT : t.getTypeArguments()) {
            subVisit(subT);
        }
        return null;
    }

    public Void visitTypeVariable(TypeVariable t, Void p) {
        Name name = null;
        try {
            name = ((Type) t).tsym.name;
        } catch (NullPointerException unused) {
        }
        if (name != null) {
            this.typeVariables.add(name.toString());
        }
        subVisit(t.getLowerBound());
        subVisit(t.getUpperBound());
        return null;
    }

    public Void visitWildcard(WildcardType t, Void p) {
        subVisit(t.getSuperBound());
        subVisit(t.getExtendsBound());
        return null;
    }

    public Void visitExecutable(ExecutableType t, Void p) {
        subVisit(t.getReturnType());
        for (TypeMirror subT : t.getParameterTypes()) {
            subVisit(subT);
        }
        for (TypeMirror subT2 : t.getThrownTypes()) {
            subVisit(subT2);
        }
        for (TypeVariable subT3 : t.getTypeVariables()) {
            subVisit(subT3);
        }
        return null;
    }
}
