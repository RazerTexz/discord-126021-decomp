package d0.e0.p.d.m0.c.k1.b;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ReflectJavaType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w$a {
    public w$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final w create(Type type) {
        w iVar;
        d0.z.d.m.checkNotNullParameter(type, "type");
        boolean z2 = type instanceof Class;
        if (z2) {
            Class cls = (Class) type;
            if (cls.isPrimitive()) {
                return new v(cls);
            }
        }
        if ((type instanceof GenericArrayType) || (z2 && ((Class) type).isArray())) {
            iVar = new i(type);
        } else {
            iVar = type instanceof WildcardType ? new z((WildcardType) type) : new l(type);
        }
        return iVar;
    }
}
