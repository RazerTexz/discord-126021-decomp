package lombok.eclipse.agent;

import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate$BindingTuple.SCL.lombok */
final class PatchDelegate$BindingTuple {
    final MethodBinding parameterized;
    final MethodBinding base;
    final char[] fieldName;
    final ASTNode responsible;

    PatchDelegate$BindingTuple(MethodBinding parameterized, MethodBinding base, char[] fieldName, ASTNode responsible) {
        this.parameterized = parameterized;
        this.base = base;
        this.fieldName = fieldName;
        this.responsible = responsible;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = this.parameterized == null ? "(null)" : PatchDelegate.access$0(this.parameterized);
        objArr[1] = this.base == null ? "(null)" : PatchDelegate.access$0(this.base);
        objArr[2] = new String(this.fieldName);
        return String.format("{param: %s, base: %s, fieldName: %s}", objArr);
    }
}
