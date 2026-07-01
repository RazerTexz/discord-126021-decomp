package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.e.a.y;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a extends o implements Function0<y> {
    public final /* synthetic */ d0.e0.p.d.m0.c.g $containingDeclaration;
    public final /* synthetic */ g $this_childForClassOrPackage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$a(g gVar, d0.e0.p.d.m0.c.g gVar2) {
        super(0);
        this.$this_childForClassOrPackage = gVar;
        this.$containingDeclaration = gVar2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ y invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final y invoke() {
        return a.computeNewDefaultTypeQualifiers(this.$this_childForClassOrPackage, this.$containingDeclaration.getAnnotations());
    }
}
