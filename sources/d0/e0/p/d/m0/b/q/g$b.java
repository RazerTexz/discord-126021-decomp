package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.c.w;
import d0.e0.p.d.m0.n.j0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$b extends d0.z.d.o implements Function0<j0> {
    public final /* synthetic */ d0.e0.p.d.m0.m.o $storageManager;
    public final /* synthetic */ g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g$b(g gVar, d0.e0.p.d.m0.m.o oVar) {
        super(0);
        this.this$0 = gVar;
        this.$storageManager = oVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ j0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final j0 invoke() {
        return w.findNonGenericClassAcrossDependencies(g.access$getSettings(this.this$0).getOwnerModuleDescriptor(), e.a.getCLONEABLE_CLASS_ID(), new d0(this.$storageManager, g.access$getSettings(this.this$0).getOwnerModuleDescriptor())).getDefaultType();
    }
}
