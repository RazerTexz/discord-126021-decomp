package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.i1.AbstractLazyTypeParameterDescriptor;
import d0.e0.p.d.m0.e.a.g0.TypeUsage;
import d0.e0.p.d.m0.e.a.i0.LazyJavaAnnotations;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.i0.m.JavaTypeResolver5;
import d0.e0.p.d.m0.e.a.k0.javaTypes3;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.Variance;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.s, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    public final context4 t;
    public final y u;
    public final LazyJavaAnnotations v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaTypeParameterDescriptor(context4 context4Var, y yVar, int i, DeclarationDescriptor declarationDescriptor) {
        super(context4Var.getStorageManager(), declarationDescriptor, yVar.getName(), Variance.INVARIANT, false, i, SourceElement.a, context4Var.getComponents().getSupertypeLoopChecker());
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(yVar, "javaTypeParameter");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        this.t = context4Var;
        this.u = yVar;
        this.v = new LazyJavaAnnotations(context4Var, yVar, false, 4, null);
    }

    @Override // d0.e0.p.d.m0.c.i1.AbstractTypeParameterDescriptor
    public List<KotlinType> b(List<? extends KotlinType> list) {
        Intrinsics3.checkNotNullParameter(list, "bounds");
        return this.t.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, list, this.t);
    }

    @Override // d0.e0.p.d.m0.c.i1.AbstractTypeParameterDescriptor
    public void c(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
    }

    @Override // d0.e0.p.d.m0.c.i1.AbstractTypeParameterDescriptor
    public List<KotlinType> d() {
        Collection<javaTypes3> upperBounds = this.u.getUpperBounds();
        if (upperBounds.isEmpty()) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            KotlinType4 anyType = this.t.getModule().getBuiltIns().getAnyType();
            Intrinsics3.checkNotNullExpressionValue(anyType, "c.module.builtIns.anyType");
            KotlinType4 nullableAnyType = this.t.getModule().getBuiltIns().getNullableAnyType();
            Intrinsics3.checkNotNullExpressionValue(nullableAnyType, "c.module.builtIns.nullableAnyType");
            return CollectionsJVM.listOf(KotlinTypeFactory.flexibleType(anyType, nullableAnyType));
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(this.t.getTypeResolver().transformJavaType((javaTypes3) it.next(), JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotatedImpl, d0.e0.p.d.m0.c.g1.Annotations3
    public LazyJavaAnnotations getAnnotations() {
        return this.v;
    }
}
