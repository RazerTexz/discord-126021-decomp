package d0.e0.p.d.m0.c.k1.b;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$e extends d0.z.d.o implements Function1<Class<?>, Boolean> {
    public static final j$e j = new j$e();

    public j$e() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Class<?> cls) {
        return Boolean.valueOf(invoke2(cls));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        d0.z.d.m.checkNotNullExpressionValue(simpleName, "it.simpleName");
        return simpleName.length() == 0;
    }
}
