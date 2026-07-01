package lombok.javac;

import com.sun.tools.javac.code.Symbol$TypeSymbol;
import com.sun.tools.javac.code.Type;
import javax.lang.model.type.NoType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

/* JADX INFO: loaded from: app.apk:lombok/javac/Javac$JCNoType.SCL.lombok */
class Javac$JCNoType extends Type implements NoType {
    public Javac$JCNoType(int tag) {
        super(tag, (Symbol$TypeSymbol) null);
    }

    public TypeKind getKind() {
        if (this.tag == ((Integer) Javac.CTC_VOID.value).intValue()) {
            return TypeKind.VOID;
        }
        if (this.tag == ((Integer) Javac.CTC_NONE.value).intValue()) {
            return TypeKind.NONE;
        }
        throw new AssertionError("Unexpected tag: " + this.tag);
    }

    public <R, P> R accept(TypeVisitor<R, P> typeVisitor, P p) {
        return (R) typeVisitor.visitNoType(this, p);
    }
}
