package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.n0, reason: use source file name */
/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StarProjectionImpl extends TypeProjectionBase {
    public final KotlinType a;

    public StarProjectionImpl(KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "kotlinBuiltIns");
        KotlinType4 nullableAnyType = kotlinBuiltIns.getNullableAnyType();
        Intrinsics3.checkNotNullExpressionValue(nullableAnyType, "kotlinBuiltIns.nullableAnyType");
        this.a = nullableAnyType;
    }

    @Override // d0.e0.p.d.m0.n.TypeProjection
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // d0.e0.p.d.m0.n.TypeProjection
    public KotlinType getType() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.n.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // d0.e0.p.d.m0.n.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
