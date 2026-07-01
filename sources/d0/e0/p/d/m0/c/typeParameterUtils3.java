package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.n.TypeProjection;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.l0, reason: use source file name */
/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeParameterUtils3 {
    public final ClassifierDescriptorWithTypeParameters a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TypeProjection> f3298b;
    public final typeParameterUtils3 c;

    /* JADX WARN: Multi-variable type inference failed */
    public typeParameterUtils3(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, List<? extends TypeProjection> list, typeParameterUtils3 typeparameterutils3) {
        Intrinsics3.checkNotNullParameter(classifierDescriptorWithTypeParameters, "classifierDescriptor");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        this.a = classifierDescriptorWithTypeParameters;
        this.f3298b = list;
        this.c = typeparameterutils3;
    }

    public final List<TypeProjection> getArguments() {
        return this.f3298b;
    }

    public final ClassifierDescriptorWithTypeParameters getClassifierDescriptor() {
        return this.a;
    }

    public final typeParameterUtils3 getOuterType() {
        return this.c;
    }
}
