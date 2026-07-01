package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.TypeSubstitution3;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.q, reason: use source file name */
/* JADX INFO: compiled from: mappingUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class mappingUtil {
    public static final TypeSubstitution3 createMappedTypeParametersSubstitution(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "from");
        Intrinsics3.checkNotNullParameter(classDescriptor2, "to");
        classDescriptor.getDeclaredTypeParameters().size();
        classDescriptor2.getDeclaredTypeParameters().size();
        TypeSubstitution3.a aVar = TypeSubstitution3.f3542b;
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "from.declaredTypeParameters");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(declaredTypeParameters, 10));
        Iterator<T> it = declaredTypeParameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeParameterDescriptor) it.next()).getTypeConstructor());
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = classDescriptor2.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters2, "to.declaredTypeParameters");
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(declaredTypeParameters2, 10));
        Iterator<T> it2 = declaredTypeParameters2.iterator();
        while (it2.hasNext()) {
            KotlinType4 defaultType = ((TypeParameterDescriptor) it2.next()).getDefaultType();
            Intrinsics3.checkNotNullExpressionValue(defaultType, "it.defaultType");
            arrayList2.add(TypeUtils2.asTypeProjection(defaultType));
        }
        return TypeSubstitution3.a.createByConstructorsMap$default(aVar, Maps6.toMap(_Collections.zip(arrayList, arrayList2)), false, 2, null);
    }
}
