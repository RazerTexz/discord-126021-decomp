package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.z, reason: use source file name */
/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeSubstitution4 extends TypeSubstitution5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeParameterDescriptor[] f3544b;
    public final TypeProjection[] c;
    public final boolean d;

    public /* synthetic */ TypeSubstitution4(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeParameterDescriptorArr, typeProjectionArr, (i & 4) != 0 ? false : z2);
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public boolean approximateContravariantCapturedTypes() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "key");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
        if (typeParameterDescriptor == null) {
            return null;
        }
        int index = typeParameterDescriptor.getIndex();
        TypeParameterDescriptor[] typeParameterDescriptorArr = this.f3544b;
        if (index >= typeParameterDescriptorArr.length || !Intrinsics3.areEqual(typeParameterDescriptorArr[index].getTypeConstructor(), typeParameterDescriptor.getTypeConstructor())) {
            return null;
        }
        return this.c[index];
    }

    public final TypeProjection[] getArguments() {
        return this.c;
    }

    public final TypeParameterDescriptor[] getParameters() {
        return this.f3544b;
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public boolean isEmpty() {
        return this.c.length == 0;
    }

    public TypeSubstitution4(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z2) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptorArr, "parameters");
        Intrinsics3.checkNotNullParameter(typeProjectionArr, "arguments");
        this.f3544b = typeParameterDescriptorArr;
        this.c = typeProjectionArr;
        this.d = z2;
        int length = typeParameterDescriptorArr.length;
        int length2 = typeProjectionArr.length;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TypeSubstitution4(List<? extends TypeParameterDescriptor> list, List<? extends TypeProjection> list2) {
        Intrinsics3.checkNotNullParameter(list, "parameters");
        Intrinsics3.checkNotNullParameter(list2, "argumentsList");
        Object[] array = list.toArray(new TypeParameterDescriptor[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        TypeParameterDescriptor[] typeParameterDescriptorArr = (TypeParameterDescriptor[]) array;
        Object[] array2 = list2.toArray(new TypeProjection[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        this(typeParameterDescriptorArr, (TypeProjection[]) array2, false, 4, null);
    }
}
