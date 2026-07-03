package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.e */
/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11813e extends AbstractC11824p<Character> {
    public C11813e(char c) {
        super(Character.valueOf(c));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
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
        return C1643a.m828P(objArr, 2, "\\u%04X ('%s')", "java.lang.String.format(this, *args)");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public AbstractC11934j0 getType(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        AbstractC11934j0 charType = interfaceC11325c0.getBuiltIns().getCharType();
        C12238m.checkNotNullExpressionValue(charType, "module.builtIns.charType");
        return charType;
    }
}
