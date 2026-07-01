package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.m.f$m;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NotFoundClasses.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0$c extends d0.z.d.o implements Function1<d0$a, e> {
    public final /* synthetic */ d0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0$c(d0 d0Var) {
        super(1);
        this.this$0 = d0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ e invoke(d0$a d0_a) {
        return invoke2(d0_a);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final e invoke2(d0$a d0_a) {
        d0.z.d.m.checkNotNullParameter(d0_a, "$dstr$classId$typeParametersCount");
        d0.e0.p.d.m0.g.a aVarComponent1 = d0_a.component1();
        List<Integer> listComponent2 = d0_a.component2();
        if (aVarComponent1.isLocal()) {
            throw new UnsupportedOperationException(d0.z.d.m.stringPlus("Unresolved local class: ", aVarComponent1));
        }
        d0.e0.p.d.m0.g.a outerClassId = aVarComponent1.getOuterClassId();
        g gVar = outerClassId == null ? null : this.this$0.getClass(outerClassId, d0.t.u.drop(listComponent2, 1));
        if (gVar == null) {
            d0.e0.p.d.m0.m.h hVarAccess$getPackageFragments$p = d0.access$getPackageFragments$p(this.this$0);
            d0.e0.p.d.m0.g.b packageFqName = aVarComponent1.getPackageFqName();
            d0.z.d.m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            gVar = (g) ((f$m) hVarAccess$getPackageFragments$p).invoke(packageFqName);
        }
        g gVar2 = gVar;
        boolean zIsNestedClass = aVarComponent1.isNestedClass();
        d0.e0.p.d.m0.m.o oVarAccess$getStorageManager$p = d0.access$getStorageManager$p(this.this$0);
        d0.e0.p.d.m0.g.e shortClassName = aVarComponent1.getShortClassName();
        d0.z.d.m.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        Integer num = (Integer) d0.t.u.firstOrNull((List) listComponent2);
        return new d0$b(oVarAccess$getStorageManager$p, gVar2, shortClassName, zIsNestedClass, num == null ? 0 : num.intValue());
    }
}
