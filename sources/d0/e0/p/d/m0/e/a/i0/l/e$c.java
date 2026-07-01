package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.t;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJavaAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$c extends d0.z.d.o implements Function0<j0> {
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$c(e eVar) {
        super(0);
        this.this$0 = eVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ j0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final j0 invoke() {
        d0.e0.p.d.m0.g.b fqName = this.this$0.getFqName();
        if (fqName == null) {
            return t.createErrorType(d0.z.d.m.stringPlus("No fqName: ", e.access$getJavaAnnotation$p(this.this$0)));
        }
        d0.e0.p.d.m0.c.e eVarMapJavaToKotlin$default = d0.e0.p.d.m0.b.q.d.mapJavaToKotlin$default(d0.e0.p.d.m0.b.q.d.a, fqName, e.access$getC$p(this.this$0).getModule().getBuiltIns(), null, 4, null);
        if (eVarMapJavaToKotlin$default == null) {
            d0.e0.p.d.m0.e.a.k0.g gVarResolve = e.access$getJavaAnnotation$p(this.this$0).resolve();
            eVarMapJavaToKotlin$default = gVarResolve == null ? null : e.access$getC$p(this.this$0).getComponents().getModuleClassResolver().resolveClass(gVarResolve);
            if (eVarMapJavaToKotlin$default == null) {
                eVarMapJavaToKotlin$default = e.access$createTypeForMissingDependencies(this.this$0, fqName);
            }
        }
        return eVarMapJavaToKotlin$default.getDefaultType();
    }
}
