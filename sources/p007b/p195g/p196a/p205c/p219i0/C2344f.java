package p007b.p195g.p196a.p205c.p219i0;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.InterfaceC2115k;
import p007b.p195g.p196a.p198b.p200p.C2130j;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.i0.f */
/* JADX INFO: compiled from: EnumValues.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2344f implements Serializable {
    private static final long serialVersionUID = 1;
    private final Class<Enum<?>> _enumClass;
    private final InterfaceC2115k[] _textual;
    private final Enum<?>[] _values;

    public C2344f(Class<Enum<?>> cls, InterfaceC2115k[] interfaceC2115kArr) {
        this._enumClass = cls;
        this._values = cls.getEnumConstants();
        this._textual = interfaceC2115kArr;
    }

    /* JADX INFO: renamed from: a */
    public static C2344f m2198a(AbstractC2394l<?> abstractC2394l, Class<Enum<?>> cls) {
        Annotation[] annotationArr = C2342d.f4944a;
        Class<Enum<?>> superclass = cls.getSuperclass() != Enum.class ? cls.getSuperclass() : cls;
        Enum<?>[] enumConstants = superclass.getEnumConstants();
        if (enumConstants == null) {
            StringBuilder sbM833U = C1643a.m833U("Cannot determine enum constants for Class ");
            sbM833U.append(cls.getName());
            throw new IllegalArgumentException(sbM833U.toString());
        }
        String[] strArrMo1781f = abstractC2394l.m2267e().mo1781f(superclass, enumConstants, new String[enumConstants.length]);
        InterfaceC2115k[] interfaceC2115kArr = new InterfaceC2115k[enumConstants.length];
        int length = enumConstants.length;
        for (int i = 0; i < length; i++) {
            Enum<?> r4 = enumConstants[i];
            String strName = strArrMo1781f[i];
            if (strName == null) {
                strName = r4.name();
            }
            interfaceC2115kArr[r4.ordinal()] = new C2130j(strName);
        }
        return new C2344f(cls, interfaceC2115kArr);
    }

    /* JADX INFO: renamed from: b */
    public Class<Enum<?>> m2199b() {
        return this._enumClass;
    }

    /* JADX INFO: renamed from: c */
    public InterfaceC2115k m2200c(Enum<?> r2) {
        return this._textual[r2.ordinal()];
    }
}
