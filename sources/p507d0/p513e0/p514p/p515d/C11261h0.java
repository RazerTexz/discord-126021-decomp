package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.Method;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.h0 */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11261h0 {
    public static final String access$getSignature$p(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        C12238m.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        sb.append(C12141k.joinToString$default(parameterTypes, "", "(", ")", 0, (CharSequence) null, C11259g0.f22360j, 24, (Object) null));
        Class<?> returnType = method.getReturnType();
        C12238m.checkNotNullExpressionValue(returnType, "returnType");
        sb.append(C11423b.getDesc(returnType));
        return sb.toString();
    }
}
