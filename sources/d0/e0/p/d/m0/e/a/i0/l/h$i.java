package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.e.a.s$a;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$i extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.c.i1.h> {
    public final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g $c;
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$i(h hVar, d0.e0.p.d.m0.e.a.i0.g gVar) {
        super(1);
        this.this$0 = hVar;
        this.$c = gVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.i1.h invoke(d0.e0.p.d.m0.g.e eVar) {
        return invoke2(eVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.c.i1.h invoke2(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (!((Set) h.access$getNestedClassIndex$p(this.this$0).invoke()).contains(eVar)) {
            d0.e0.p.d.m0.e.a.k0.n nVar = (d0.e0.p.d.m0.e.a.k0.n) ((Map) h.access$getEnumEntryIndex$p(this.this$0).invoke()).get(eVar);
            if (nVar == null) {
                return null;
            }
            return d0.e0.p.d.m0.c.i1.o.create(this.$c.getStorageManager(), this.this$0.n, eVar, this.$c.getStorageManager().createLazyValue(new h$i$a(this.this$0)), d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(this.$c, nVar), this.$c.getComponents().getSourceElementFactory().source(nVar));
        }
        d0.e0.p.d.m0.e.a.s finder = this.$c.getComponents().getFinder();
        d0.e0.p.d.m0.g.a classId = d0.e0.p.d.m0.k.x.a.getClassId(this.this$0.n);
        d0.z.d.m.checkNotNull(classId);
        d0.e0.p.d.m0.g.a aVarCreateNestedClassId = classId.createNestedClassId(eVar);
        d0.z.d.m.checkNotNullExpressionValue(aVarCreateNestedClassId, "ownerDescriptor.classId!!.createNestedClassId(name)");
        d0.e0.p.d.m0.e.a.k0.g gVarFindClass = finder.findClass(new s$a(aVarCreateNestedClassId, null, h.access$getJClass$p(this.this$0), 2, null));
        if (gVarFindClass == null) {
            return null;
        }
        d0.e0.p.d.m0.e.a.i0.g gVar = this.$c;
        f fVar = new f(gVar, this.this$0.n, gVarFindClass, null, 8, null);
        gVar.getComponents().getJavaClassesTracker().reportClass(fVar);
        return fVar;
    }
}
