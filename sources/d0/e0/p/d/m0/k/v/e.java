package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends p<Character> {
    public e(char c) {
        super(Character.valueOf(c));
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public /* bridge */ /* synthetic */ c0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        return getType(c0Var);
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        String strValueOf;
        Object[] objArr = new Object[2];
        boolean z2 = false;
        objArr[0] = Integer.valueOf(getValue().charValue());
        char cCharValue = getValue().charValue();
        if (cCharValue == '\b') {
            strValueOf = "\\b";
        } else if (cCharValue == '\t') {
            strValueOf = "\\t";
        } else if (cCharValue == '\n') {
            strValueOf = "\\n";
        } else if (cCharValue == '\f') {
            strValueOf = "\\f";
        } else if (cCharValue == '\r') {
            strValueOf = "\\r";
        } else {
            byte type = (byte) Character.getType(cCharValue);
            if (type != 0 && type != 13 && type != 14 && type != 15 && type != 16 && type != 18 && type != 19) {
                z2 = true;
            }
            strValueOf = z2 ? String.valueOf(cCharValue) : "?";
        }
        objArr[1] = strValueOf;
        return b.d.b.a.a.P(objArr, 2, "\\u%04X ('%s')", "java.lang.String.format(this, *args)");
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public j0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        j0 charType = c0Var.getBuiltIns().getCharType();
        d0.z.d.m.checkNotNullExpressionValue(charType, "module.builtIns.charType");
        return charType;
    }
}
