package b.g.a.c.i0;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: EnumValues.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements Serializable {
    private static final long serialVersionUID = 1;
    private final Class<Enum<?>> _enumClass;
    private final b.g.a.b.k[] _textual;
    private final Enum<?>[] _values;

    public f(Class<Enum<?>> cls, b.g.a.b.k[] kVarArr) {
        this._enumClass = cls;
        this._values = cls.getEnumConstants();
        this._textual = kVarArr;
    }

    public static f a(b.g.a.c.z.l<?> lVar, Class<Enum<?>> cls) {
        Annotation[] annotationArr = d.a;
        Class<Enum<?>> superclass = cls.getSuperclass() != Enum.class ? cls.getSuperclass() : cls;
        Enum<?>[] enumConstants = superclass.getEnumConstants();
        if (enumConstants == null) {
            StringBuilder sbU = b.d.b.a.a.U("Cannot determine enum constants for Class ");
            sbU.append(cls.getName());
            throw new IllegalArgumentException(sbU.toString());
        }
        String[] strArrF = lVar.e().f(superclass, enumConstants, new String[enumConstants.length]);
        b.g.a.b.k[] kVarArr = new b.g.a.b.k[enumConstants.length];
        int length = enumConstants.length;
        for (int i = 0; i < length; i++) {
            Enum<?> r4 = enumConstants[i];
            String strName = strArrF[i];
            if (strName == null) {
                strName = r4.name();
            }
            kVarArr[r4.ordinal()] = new b.g.a.b.p.j(strName);
        }
        return new f(cls, kVarArr);
    }

    public Class<Enum<?>> b() {
        return this._enumClass;
    }

    public b.g.a.b.k c(Enum<?> r2) {
        return this._textual[r2.ordinal()];
    }
}
