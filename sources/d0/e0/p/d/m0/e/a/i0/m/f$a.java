package d0.e0.p.d.m0.e.a.i0.m;

import d0.e0.p.d.m0.n.j0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RawType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$a extends o implements Function1<d0.e0.p.d.m0.n.l1.g, j0> {
    public final /* synthetic */ a $attr;
    public final /* synthetic */ d0.e0.p.d.m0.c.e $declaration;
    public final /* synthetic */ j0 $type;
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$a(d0.e0.p.d.m0.c.e eVar, f fVar, j0 j0Var, a aVar) {
        super(1);
        this.$declaration = eVar;
        this.this$0 = fVar;
        this.$type = j0Var;
        this.$attr = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ j0 invoke(d0.e0.p.d.m0.n.l1.g gVar) {
        return invoke2(gVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final j0 invoke2(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.e0.p.d.m0.c.e eVarFindClassAcrossModuleDependencies;
        m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        d0.e0.p.d.m0.c.e eVar = this.$declaration;
        if (!(eVar instanceof d0.e0.p.d.m0.c.e)) {
            eVar = null;
        }
        d0.e0.p.d.m0.g.a classId = eVar == null ? null : d0.e0.p.d.m0.k.x.a.getClassId(eVar);
        if (classId == null || (eVarFindClassAcrossModuleDependencies = gVar.findClassAcrossModuleDependencies(classId)) == null || m.areEqual(eVarFindClassAcrossModuleDependencies, this.$declaration)) {
            return null;
        }
        return (j0) f.access$eraseInflexibleBasedOnClassDescriptor(this.this$0, this.$type, eVarFindClassAcrossModuleDependencies, this.$attr).getFirst();
    }
}
