package p507d0.p513e0;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.m */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11240m extends C12236k implements Function1<Class<? extends Object>, Class<?>> {

    /* JADX INFO: renamed from: j */
    public static final C11240m f22313j = new C11240m();

    public C11240m() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Class<?> invoke2(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "p1");
        return cls.getComponentType();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Class<?> invoke(Class<? extends Object> cls) {
        return invoke2((Class<?>) cls);
    }
}
