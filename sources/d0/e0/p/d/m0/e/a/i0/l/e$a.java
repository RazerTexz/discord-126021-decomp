package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.e.a.a0;
import d0.t.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJavaAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a extends d0.z.d.o implements Function0<Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>>> {
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$a(e eVar) {
        super(0);
        this.this$0 = eVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>> invoke2() {
        Collection<d0.e0.p.d.m0.e.a.k0.b> arguments = e.access$getJavaAnnotation$p(this.this$0).getArguments();
        e eVar = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (d0.e0.p.d.m0.e.a.k0.b bVar : arguments) {
            d0.e0.p.d.m0.g.e name = bVar.getName();
            if (name == null) {
                name = a0.f3305b;
            }
            d0.e0.p.d.m0.k.v.g gVarAccess$resolveAnnotationArgument = e.access$resolveAnnotationArgument(eVar, bVar);
            Pair pair = gVarAccess$resolveAnnotationArgument == null ? null : d0.o.to(name, gVarAccess$resolveAnnotationArgument);
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return h0.toMap(arrayList);
    }
}
