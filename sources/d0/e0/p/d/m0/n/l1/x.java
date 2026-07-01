package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.c0;
import d0.z.d.a0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class x extends d0.z.d.j implements Function2<c0, c0, Boolean> {
    public x(v vVar) {
        super(2, vVar);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "isStrictSupertype";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return a0.getOrCreateKotlinClass(v.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(c0 c0Var, c0 c0Var2) {
        return Boolean.valueOf(invoke2(c0Var, c0Var2));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(c0 c0Var, c0 c0Var2) {
        d0.z.d.m.checkNotNullParameter(c0Var, "p0");
        d0.z.d.m.checkNotNullParameter(c0Var2, "p1");
        return v.access$isStrictSupertype((v) this.receiver, c0Var, c0Var2);
    }
}
