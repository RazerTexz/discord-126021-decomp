package d0.e0.p.d;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 {
    public static final String access$getSignature$p(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        d0.z.d.m.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        sb.append(d0.t.k.joinToString$default(parameterTypes, "", "(", ")", 0, (CharSequence) null, g0.j, 24, (Object) null));
        Class<?> returnType = method.getReturnType();
        d0.z.d.m.checkNotNullExpressionValue(returnType, "returnType");
        sb.append(d0.e0.p.d.m0.c.k1.b.b.getDesc(returnType));
        return sb.toString();
    }
}
