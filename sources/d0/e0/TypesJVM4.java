package d0.e0;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.m, reason: use source file name */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class TypesJVM4 extends FunctionReferenceImpl implements Function1<Class<? extends Object>, Class<?>> {
    public static final TypesJVM4 j = new TypesJVM4();

    public TypesJVM4() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Class<?> invoke2(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "p1");
        return cls.getComponentType();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Class<?> invoke(Class<? extends Object> cls) {
        return invoke2((Class<?>) cls);
    }
}
