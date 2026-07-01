package d0.e0.p.d.m0.e.a.i0.l;

import java.util.HashMap;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$b extends d0.z.d.o implements Function0<HashMap<d0.e0.p.d.m0.k.y.c, d0.e0.p.d.m0.k.y.c>> {
    public final /* synthetic */ i this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i$b(i iVar) {
        super(0);
        this.this$0 = iVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ HashMap<d0.e0.p.d.m0.k.y.c, d0.e0.p.d.m0.k.y.c> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final HashMap<d0.e0.p.d.m0.k.y.c, d0.e0.p.d.m0.k.y.c> invoke2() {
        String multifileClassName;
        HashMap<d0.e0.p.d.m0.k.y.c, d0.e0.p.d.m0.k.y.c> map = new HashMap<>();
        for (Map$Entry<String, d0.e0.p.d.m0.e.b.p> map$Entry : this.this$0.getBinaryClasses$descriptors_jvm().entrySet()) {
            String key = map$Entry.getKey();
            d0.e0.p.d.m0.e.b.p value = map$Entry.getValue();
            d0.e0.p.d.m0.k.y.c cVarByInternalName = d0.e0.p.d.m0.k.y.c.byInternalName(key);
            d0.z.d.m.checkNotNullExpressionValue(cVarByInternalName, "byInternalName(partInternalName)");
            d0.e0.p.d.m0.e.b.b0.a classHeader = value.getClassHeader();
            int iOrdinal = classHeader.getKind().ordinal();
            if (iOrdinal == 2) {
                map.put(cVarByInternalName, cVarByInternalName);
            } else if (iOrdinal == 5 && (multifileClassName = classHeader.getMultifileClassName()) != null) {
                d0.e0.p.d.m0.k.y.c cVarByInternalName2 = d0.e0.p.d.m0.k.y.c.byInternalName(multifileClassName);
                d0.z.d.m.checkNotNullExpressionValue(cVarByInternalName2, "byInternalName(header.multifileClassName ?: continue@kotlinClasses)");
                map.put(cVarByInternalName, cVarByInternalName2);
            }
        }
        return map;
    }
}
