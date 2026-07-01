package d0.e0.p.d.m0.k.x;

import d0.e0.p.d.m0.c.c1;
import d0.z.d.a0;
import d0.z.d.j;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: DescriptorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class a$b extends j implements Function1<c1, Boolean> {
    public static final a$b j = new a$b();

    public a$b() {
        super(1);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "declaresDefaultValue";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return a0.getOrCreateKotlinClass(c1.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "declaresDefaultValue()Z";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(c1 c1Var) {
        return Boolean.valueOf(invoke2(c1Var));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(c1 c1Var) {
        m.checkNotNullParameter(c1Var, "p0");
        return c1Var.declaresDefaultValue();
    }
}
