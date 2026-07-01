package b.g.a.c.i0;

import b.d.b.a.outline;
import b.g.a.b.SerializableString;
import b.g.a.b.p.SerializedString;
import b.g.a.c.z.MapperConfig;
import java.io.Serializable;
import java.lang.annotation.Annotation;

/* JADX INFO: renamed from: b.g.a.c.i0.f, reason: use source file name */
/* JADX INFO: compiled from: EnumValues.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumValues implements Serializable {
    private static final long serialVersionUID = 1;
    private final Class<Enum<?>> _enumClass;
    private final SerializableString[] _textual;
    private final Enum<?>[] _values;

    public EnumValues(Class<Enum<?>> cls, SerializableString[] serializableStringArr) {
        this._enumClass = cls;
        this._values = cls.getEnumConstants();
        this._textual = serializableStringArr;
    }

    public static EnumValues a(MapperConfig<?> mapperConfig, Class<Enum<?>> cls) {
        Annotation[] annotationArr = ClassUtil.a;
        Class<Enum<?>> superclass = cls.getSuperclass() != Enum.class ? cls.getSuperclass() : cls;
        Enum<?>[] enumConstants = superclass.getEnumConstants();
        if (enumConstants == null) {
            StringBuilder sbU = outline.U("Cannot determine enum constants for Class ");
            sbU.append(cls.getName());
            throw new IllegalArgumentException(sbU.toString());
        }
        String[] strArrF = mapperConfig.e().f(superclass, enumConstants, new String[enumConstants.length]);
        SerializableString[] serializableStringArr = new SerializableString[enumConstants.length];
        int length = enumConstants.length;
        for (int i = 0; i < length; i++) {
            Enum<?> r4 = enumConstants[i];
            String strName = strArrF[i];
            if (strName == null) {
                strName = r4.name();
            }
            serializableStringArr[r4.ordinal()] = new SerializedString(strName);
        }
        return new EnumValues(cls, serializableStringArr);
    }

    public Class<Enum<?>> b() {
        return this._enumClass;
    }

    public SerializableString c(Enum<?> r2) {
        return this._textual[r2.ordinal()];
    }
}
