package d0.e0.p.d;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a$b extends d0.z.d.o implements Function1<Method, CharSequence> {
    public static final d$a$b j = new d$a$b();

    public d$a$b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Method method) {
        return invoke2(method);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Method method) {
        d0.z.d.m.checkNotNullExpressionValue(method, "it");
        Class<?> returnType = method.getReturnType();
        d0.z.d.m.checkNotNullExpressionValue(returnType, "it.returnType");
        return d0.e0.p.d.m0.c.k1.b.b.getDesc(returnType);
    }
}
