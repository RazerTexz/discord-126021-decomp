package d0.e0.p.d.m0.e.a.i0.l;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.g, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaClassMemberScope extends Lambda implements Function1<d0.e0.p.d.m0.e.a.k0.q, Boolean> {
    public static final LazyJavaClassMemberScope j = new LazyJavaClassMemberScope();

    public LazyJavaClassMemberScope() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.e.a.k0.q qVar) {
        return Boolean.valueOf(invoke2(qVar));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.e.a.k0.q qVar) {
        Intrinsics3.checkNotNullParameter(qVar, "it");
        return !qVar.isStatic();
    }
}
