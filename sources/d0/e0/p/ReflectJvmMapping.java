package d0.e0.p;

import d0.e0.TypesJVM5;
import d0.e0.p.d.KTypeImpl;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Type;
import kotlin.reflect.KType;

/* JADX INFO: renamed from: d0.e0.p.b, reason: use source file name */
/* JADX INFO: compiled from: ReflectJvmMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJvmMapping {
    public static final Type getJavaType(KType kType) {
        Intrinsics3.checkNotNullParameter(kType, "$this$javaType");
        Type javaType = ((KTypeImpl) kType).getJavaType();
        return javaType != null ? javaType : TypesJVM5.getJavaType(kType);
    }
}
