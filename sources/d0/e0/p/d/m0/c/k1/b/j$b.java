package d0.e0.p.d.m0.c.k1.b;

import d0.z.d.a0;
import java.lang.reflect.Constructor;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class j$b extends d0.z.d.j implements Function1<Constructor<?>, m> {
    public static final j$b j = new j$b();

    public j$b() {
        super(1);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "<init>";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return a0.getOrCreateKotlinClass(m.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Constructor;)V";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ m invoke(Constructor<?> constructor) {
        return invoke2(constructor);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final m invoke2(Constructor<?> constructor) {
        d0.z.d.m.checkNotNullParameter(constructor, "p0");
        return new m(constructor);
    }
}
