package d0.e0;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class m extends d0.z.d.k implements Function1<Class<? extends Object>, Class<?>> {
    public static final m j = new m();

    public m() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Class<?> invoke2(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "p1");
        return cls.getComponentType();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Class<?> invoke(Class<? extends Object> cls) {
        return invoke2((Class<?>) cls);
    }
}
