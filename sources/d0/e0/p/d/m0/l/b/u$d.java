package d0.e0.p.d.m0.l.b;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MemberDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u$d extends d0.z.d.o implements Function0<d0.e0.p.d.m0.k.v.g<?>> {
    public final /* synthetic */ d0.e0.p.d.m0.l.b.e0.j $property;
    public final /* synthetic */ d0.e0.p.d.m0.f.n $proto;
    public final /* synthetic */ u this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u$d(u uVar, d0.e0.p.d.m0.f.n nVar, d0.e0.p.d.m0.l.b.e0.j jVar) {
        super(0);
        this.this$0 = uVar;
        this.$proto = nVar;
        this.$property = jVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.v.g<?> invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.k.v.g<?> invoke() {
        u uVar = this.this$0;
        y yVarAccess$asProtoContainer = u.access$asProtoContainer(uVar, u.access$getC$p(uVar).getContainingDeclaration());
        d0.z.d.m.checkNotNull(yVarAccess$asProtoContainer);
        c<d0.e0.p.d.m0.c.g1.c, d0.e0.p.d.m0.k.v.g<?>> annotationAndConstantLoader = u.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader();
        d0.e0.p.d.m0.f.n nVar = this.$proto;
        d0.e0.p.d.m0.n.c0 returnType = this.$property.getReturnType();
        d0.z.d.m.checkNotNullExpressionValue(returnType, "property.returnType");
        return annotationAndConstantLoader.loadPropertyConstant(yVarAccess$asProtoContainer, nVar, returnType);
    }
}
