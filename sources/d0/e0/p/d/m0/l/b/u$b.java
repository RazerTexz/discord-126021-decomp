package d0.e0.p.d.m0.l.b;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MemberDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u$b extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.m0.c.g1.c>> {
    public final /* synthetic */ b $kind;
    public final /* synthetic */ d0.e0.p.d.m0.i.n $proto;
    public final /* synthetic */ u this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u$b(u uVar, d0.e0.p.d.m0.i.n nVar, b bVar) {
        super(0);
        this.this$0 = uVar;
        this.$proto = nVar;
        this.$kind = bVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.c.g1.c> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends d0.e0.p.d.m0.c.g1.c> invoke2() {
        List<? extends d0.e0.p.d.m0.c.g1.c> list;
        u uVar = this.this$0;
        y yVarAccess$asProtoContainer = u.access$asProtoContainer(uVar, u.access$getC$p(uVar).getContainingDeclaration());
        if (yVarAccess$asProtoContainer == null) {
            list = null;
        } else {
            list = d0.t.u.toList(u.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(yVarAccess$asProtoContainer, this.$proto, this.$kind));
        }
        return list != null ? list : d0.t.n.emptyList();
    }
}
