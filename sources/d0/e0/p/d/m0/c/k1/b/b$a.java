package d0.e0.p.d.m0.c.k1.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: reflectClassUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a extends d0.z.d.o implements Function1<ParameterizedType, ParameterizedType> {
    public static final b$a j = new b$a();

    public b$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ParameterizedType invoke(ParameterizedType parameterizedType) {
        return invoke2(parameterizedType);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ParameterizedType invoke2(ParameterizedType parameterizedType) {
        d0.z.d.m.checkNotNullParameter(parameterizedType, "it");
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            return (ParameterizedType) ownerType;
        }
        return null;
    }
}
