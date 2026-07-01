package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.k0.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$c extends d0.z.d.o implements Function0<List<? extends z0>> {
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$c(f fVar) {
        super(0);
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends z0> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends z0> invoke2() {
        List<y> typeParameters = this.this$0.getJClass().getTypeParameters();
        f fVar = this.this$0;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(typeParameters, 10));
        for (y yVar : typeParameters) {
            z0 z0VarResolveTypeParameter = f.access$getC$p(fVar).getTypeParameterResolver().resolveTypeParameter(yVar);
            if (z0VarResolveTypeParameter == null) {
                throw new AssertionError("Parameter " + yVar + " surely belongs to class " + fVar.getJClass() + ", so it must be resolved");
            }
            arrayList.add(z0VarResolveTypeParameter);
        }
        return arrayList;
    }
}
