package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.z0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazySubstitutingClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$a implements Function1<z0, Boolean> {
    public t$a(t tVar) {
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(z0 z0Var) {
        return invoke2(z0Var);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Boolean invoke2(z0 z0Var) {
        return Boolean.valueOf(!z0Var.isCapturedFromOuterDeclaration());
    }
}
