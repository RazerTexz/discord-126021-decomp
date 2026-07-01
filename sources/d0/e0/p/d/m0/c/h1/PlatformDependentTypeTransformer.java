package d0.e0.p.d.m0.c.h1;

import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.e, reason: use source file name */
/* JADX INFO: compiled from: PlatformDependentTypeTransformer.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface PlatformDependentTypeTransformer {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.e$a */
    /* JADX INFO: compiled from: PlatformDependentTypeTransformer.kt */
    public static final class a implements PlatformDependentTypeTransformer {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.c.h1.PlatformDependentTypeTransformer
        public KotlinType4 transformPlatformType(ClassId classId, KotlinType4 kotlinType4) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            Intrinsics3.checkNotNullParameter(kotlinType4, "computedType");
            return kotlinType4;
        }
    }

    KotlinType4 transformPlatformType(ClassId classId, KotlinType4 kotlinType4);
}
