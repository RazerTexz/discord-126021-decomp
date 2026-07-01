package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.e.b.v;
import d0.t.h0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$a extends d0.z.d.o implements Function0<Map<String, ? extends d0.e0.p.d.m0.e.b.p>> {
    public final /* synthetic */ i this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i$a(i iVar) {
        super(0);
        this.this$0 = iVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends d0.e0.p.d.m0.e.b.p> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends d0.e0.p.d.m0.e.b.p> invoke2() {
        v packagePartProvider = i.access$getC$p(this.this$0).getComponents().getPackagePartProvider();
        String strAsString = this.this$0.getFqName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "fqName.asString()");
        List<String> listFindPackageParts = packagePartProvider.findPackageParts(strAsString);
        i iVar = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (String str : listFindPackageParts) {
            d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(d0.e0.p.d.m0.k.y.c.byInternalName(str).getFqNameForTopLevelClassMaybeWithDollars());
            d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
            d0.e0.p.d.m0.e.b.p pVarFindKotlinClass = d0.e0.p.d.m0.e.b.o.findKotlinClass(i.access$getC$p(iVar).getComponents().getKotlinClassFinder(), aVar);
            Pair pair = pVarFindKotlinClass == null ? null : d0.o.to(str, pVarFindKotlinClass);
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return h0.toMap(arrayList);
    }
}
