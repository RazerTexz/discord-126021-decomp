package d0.e0.p.d.m0.e.a.i0.l;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$d extends d0.z.d.o implements Function1<d0.e0.p.d.m0.n.l1.g, h> {
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$d(f fVar) {
        super(1);
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ h invoke(d0.e0.p.d.m0.n.l1.g gVar) {
        return invoke2(gVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final h invoke2(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "it");
        d0.e0.p.d.m0.e.a.i0.g gVarAccess$getC$p = f.access$getC$p(this.this$0);
        f fVar = this.this$0;
        return new h(gVarAccess$getC$p, fVar, fVar.getJClass(), f.access$getAdditionalSupertypeClassDescriptor$p(this.this$0) != null, f.access$getUnsubstitutedMemberScope$p(this.this$0));
    }
}
