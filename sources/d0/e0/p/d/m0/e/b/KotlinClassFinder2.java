package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.e.b.KotlinClassFinder;
import d0.e0.p.d.m0.g.ClassId;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.o, reason: use source file name */
/* JADX INFO: compiled from: KotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinClassFinder2 {
    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder kotlinClassFinder, ClassId classId) {
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "<this>");
        Intrinsics3.checkNotNullParameter(classId, "classId");
        KotlinClassFinder.a aVarFindKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(classId);
        if (aVarFindKotlinClassOrContent == null) {
            return null;
        }
        return aVarFindKotlinClassOrContent.toKotlinJvmBinaryClass();
    }

    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder kotlinClassFinder, d0.e0.p.d.m0.e.a.k0.g gVar) {
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "<this>");
        Intrinsics3.checkNotNullParameter(gVar, "javaClass");
        KotlinClassFinder.a aVarFindKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(gVar);
        if (aVarFindKotlinClassOrContent == null) {
            return null;
        }
        return aVarFindKotlinClassOrContent.toKotlinJvmBinaryClass();
    }
}
