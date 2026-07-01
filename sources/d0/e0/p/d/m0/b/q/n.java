package d0.e0.p.d.m0.b.q;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends d0.z.d.o implements Function1<d0.e0.p.d.m0.c.b, Boolean> {
    public final /* synthetic */ g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(g gVar) {
        super(1);
        this.this$0 = gVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.c.b bVar) {
        return invoke2(bVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(d0.e0.p.d.m0.c.b bVar) {
        return Boolean.valueOf(bVar.getKind() == d0.e0.p.d.m0.c.b$a.DECLARATION && g.access$getJ2kClassMapper$p(this.this$0).isMutable((d0.e0.p.d.m0.c.e) bVar.getContainingDeclaration()));
    }
}
