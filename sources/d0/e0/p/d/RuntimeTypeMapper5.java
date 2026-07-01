package d0.e0.p.d;

import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: d0.e0.p.d.h0, reason: use source file name */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeTypeMapper5 {
    public static final String access$getSignature$p(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        Intrinsics3.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        sb.append(_Arrays.joinToString$default(parameterTypes, "", "(", ")", 0, (CharSequence) null, RuntimeTypeMapper4.j, 24, (Object) null));
        Class<?> returnType = method.getReturnType();
        Intrinsics3.checkNotNullExpressionValue(returnType, "returnType");
        sb.append(reflectClassUtil.getDesc(returnType));
        return sb.toString();
    }
}
