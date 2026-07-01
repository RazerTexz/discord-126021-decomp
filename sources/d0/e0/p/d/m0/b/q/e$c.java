package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.z;
import d0.t.n0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$c extends d0.z.d.o implements Function0<d0.e0.p.d.m0.c.i1.i> {
    public final /* synthetic */ d0.e0.p.d.m0.m.o $storageManager;
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$c(e eVar, d0.e0.p.d.m0.m.o oVar) {
        super(0);
        this.this$0 = eVar;
        this.$storageManager = oVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.i1.i invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.c.i1.i invoke() {
        d0.e0.p.d.m0.c.i1.i iVar = new d0.e0.p.d.m0.c.i1.i((d0.e0.p.d.m0.c.m) e.access$getComputeContainingDeclaration$p(this.this$0).invoke(e.access$getModuleDescriptor$p(this.this$0)), e.access$getCLONEABLE_NAME$cp(), z.ABSTRACT, d0.e0.p.d.m0.c.f.INTERFACE, d0.t.m.listOf(e.access$getModuleDescriptor$p(this.this$0).getBuiltIns().getAnyType()), u0.a, false, this.$storageManager);
        iVar.initialize(new a(this.$storageManager, iVar), n0.emptySet(), null);
        return iVar;
    }
}
