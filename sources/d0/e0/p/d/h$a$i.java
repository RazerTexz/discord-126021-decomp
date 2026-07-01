package d0.e0.p.d;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a$i extends d0.z.d.o implements Function0<d0.e0.p.d.m0.c.e> {
    public final /* synthetic */ h$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a$i(h$a h_a) {
        super(0);
        this.this$0 = h_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.c.e invoke() {
        d0.e0.p.d.m0.g.a aVarAccess$getClassId$p = h.access$getClassId$p(this.this$0.p);
        d0.e0.p.d.m0.c.k1.a.k moduleData = ((h$a) this.this$0.p.getData().invoke()).getModuleData();
        d0.e0.p.d.m0.c.e eVarDeserializeClass = aVarAccess$getClassId$p.isLocal() ? moduleData.getDeserialization().deserializeClass(aVarAccess$getClassId$p) : d0.e0.p.d.m0.c.w.findClassAcrossModuleDependencies(moduleData.getModule(), aVarAccess$getClassId$p);
        if (eVarDeserializeClass != null) {
            return eVarDeserializeClass;
        }
        h.access$reportUnresolvedClass(this.this$0.p);
        throw null;
    }
}
