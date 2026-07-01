package d0.e0.p.d.m0.e.a.i0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JvmPackageScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a extends d0.z.d.o implements Function0<d0.e0.p.d.m0.k.a0.i[]> {
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$a(d dVar) {
        super(0);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i[] invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.k.a0.i[] invoke2() {
        Collection<d0.e0.p.d.m0.e.b.p> collectionValues = d.access$getPackageFragment$p(this.this$0).getBinaryClasses$descriptors_jvm().values();
        d dVar = this.this$0;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.k.a0.i iVarCreateKotlinPackagePartScope = d.access$getC$p(dVar).getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(d.access$getPackageFragment$p(dVar), (d0.e0.p.d.m0.e.b.p) it.next());
            if (iVarCreateKotlinPackagePartScope != null) {
                arrayList.add(iVarCreateKotlinPackagePartScope);
            }
        }
        Object[] array = d0.e0.p.d.m0.o.n.a.listOfNonEmptyScopes(arrayList).toArray(new d0.e0.p.d.m0.k.a0.i[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (d0.e0.p.d.m0.k.a0.i[]) array;
    }
}
