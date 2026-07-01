package d0.e0.p.d.m0.c.k1.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: reflectClassUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b extends d0.z.d.o implements Function1<ParameterizedType, Sequence<? extends Type>> {
    public static final b$b j = new b$b();

    public b$b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Sequence<? extends Type> invoke(ParameterizedType parameterizedType) {
        return invoke2(parameterizedType);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Sequence<Type> invoke2(ParameterizedType parameterizedType) {
        d0.z.d.m.checkNotNullParameter(parameterizedType, "it");
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        d0.z.d.m.checkNotNullExpressionValue(actualTypeArguments, "it.actualTypeArguments");
        return d0.t.k.asSequence(actualTypeArguments);
    }
}
