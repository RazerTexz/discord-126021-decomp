package d0.e0.p.d.m0.n.p1;

import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.l1.KotlinTypeChecker;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p1.d, reason: use source file name */
/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CapturedTypeApproximation4 {
    public final TypeParameterDescriptor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KotlinType f3535b;
    public final KotlinType c;

    public CapturedTypeApproximation4(TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics3.checkNotNullParameter(kotlinType, "inProjection");
        Intrinsics3.checkNotNullParameter(kotlinType2, "outProjection");
        this.a = typeParameterDescriptor;
        this.f3535b = kotlinType;
        this.c = kotlinType2;
    }

    public final KotlinType getInProjection() {
        return this.f3535b;
    }

    public final KotlinType getOutProjection() {
        return this.c;
    }

    public final TypeParameterDescriptor getTypeParameter() {
        return this.a;
    }

    public final boolean isConsistent() {
        return KotlinTypeChecker.a.isSubtypeOf(this.f3535b, this.c);
    }
}
