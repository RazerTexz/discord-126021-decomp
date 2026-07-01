package d0.e0.p.d.m0.c.k1.b;

import d0.z.d.a0;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class j$h extends d0.z.d.j implements Function1<Method, s> {
    public static final j$h j = new j$h();

    public j$h() {
        super(1);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "<init>";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return a0.getOrCreateKotlinClass(s.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Method;)V";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ s invoke(Method method) {
        return invoke2(method);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final s invoke2(Method method) {
        d0.z.d.m.checkNotNullParameter(method, "p0");
        return new s(method);
    }
}
