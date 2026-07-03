package p507d0.p513e0.p514p;

import java.lang.reflect.Type;
import kotlin.reflect.KType;
import p507d0.p513e0.C11241n;
import p507d0.p513e0.p514p.p515d.C12058x;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.b */
/* JADX INFO: compiled from: ReflectJvmMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11244b {
    public static final Type getJavaType(KType kType) {
        C12238m.checkNotNullParameter(kType, "$this$javaType");
        Type javaType = ((C12058x) kType).getJavaType();
        return javaType != null ? javaType : C11241n.getJavaType(kType);
    }
}
