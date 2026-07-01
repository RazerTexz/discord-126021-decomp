package lombok.core;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: app.apk:lombok/core/AST$FieldAccess.SCL.lombok */
protected class AST$FieldAccess {
    public final Field field;
    public final int dim;

    AST$FieldAccess(Field field, int dim) {
        this.field = field;
        this.dim = dim;
    }
}
