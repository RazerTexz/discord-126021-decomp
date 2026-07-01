package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.l.b.ClassData;
import d0.e0.p.d.m0.l.b.ClassDataFinder;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.g, reason: use source file name */
/* JADX INFO: compiled from: JavaClassDataFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaClassDataFinder implements ClassDataFinder {
    public final KotlinClassFinder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DeserializedDescriptorResolver f3377b;

    public JavaClassDataFinder(KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver) {
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        Intrinsics3.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.a = kotlinClassFinder;
        this.f3377b = deserializedDescriptorResolver;
    }

    @Override // d0.e0.p.d.m0.l.b.ClassDataFinder
    public ClassData findClassData(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        KotlinJvmBinaryClass kotlinJvmBinaryClassFindKotlinClass = KotlinClassFinder2.findKotlinClass(this.a, classId);
        if (kotlinJvmBinaryClassFindKotlinClass == null) {
            return null;
        }
        Intrinsics3.areEqual(kotlinJvmBinaryClassFindKotlinClass.getClassId(), classId);
        return this.f3377b.readClassData$descriptors_jvm(kotlinJvmBinaryClassFindKotlinClass);
    }
}
