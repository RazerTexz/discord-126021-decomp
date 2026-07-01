package d0.e0.p.d.m0.n.o1;

import d0.e0.p.d.m0.c.h;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.i1;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TypeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$b extends o implements Function1<i1, Boolean> {
    public static final a$b j = new a$b();

    public a$b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(i1 i1Var) {
        return Boolean.valueOf(invoke2(i1Var));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(i1 i1Var) {
        m.checkNotNullParameter(i1Var, "it");
        h declarationDescriptor = i1Var.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return false;
        }
        return (declarationDescriptor instanceof y0) || (declarationDescriptor instanceof z0);
    }
}
