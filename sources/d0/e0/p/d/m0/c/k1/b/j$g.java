package d0.e0.p.d.m0.c.k1.b;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$g extends d0.z.d.o implements Function1<Method, Boolean> {
    public final /* synthetic */ j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$g(j jVar) {
        super(1);
        this.this$0 = jVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Method method) {
        return Boolean.valueOf(invoke2(method));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Method method) {
        if (!method.isSynthetic()) {
            if (!this.this$0.isEnum()) {
                return true;
            }
            j jVar = this.this$0;
            d0.z.d.m.checkNotNullExpressionValue(method, "method");
            if (!j.access$isEnumValuesOrValueOf(jVar, method)) {
                return true;
            }
        }
        return false;
    }
}
