package d0.e0.p;

import d0.e0.n;
import d0.e0.p.d.x;
import d0.z.d.m;
import java.lang.reflect.Type;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: ReflectJvmMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final Type getJavaType(KType kType) {
        m.checkNotNullParameter(kType, "$this$javaType");
        Type javaType = ((x) kType).getJavaType();
        return javaType != null ? javaType : n.getJavaType(kType);
    }
}
