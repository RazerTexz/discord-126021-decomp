package d0.e0.p.d.m0.n.p1;

import d0.e0.p.d.m0.k.u.a.CapturedTypeConstructor2;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeProjectionImpl;
import d0.e0.p.d.m0.n.TypeSubstitution3;
import d0.e0.p.d.m0.n.Variance;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p1.c, reason: use source file name */
/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CapturedTypeApproximation3 extends TypeSubstitution3 {
    @Override // d0.e0.p.d.m0.n.TypeSubstitution3
    public TypeProjection get(TypeConstructor typeConstructor) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "key");
        CapturedTypeConstructor2 capturedTypeConstructor2 = typeConstructor instanceof CapturedTypeConstructor2 ? (CapturedTypeConstructor2) typeConstructor : null;
        if (capturedTypeConstructor2 == null) {
            return null;
        }
        return capturedTypeConstructor2.getProjection().isStarProjection() ? new TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor2.getProjection().getType()) : capturedTypeConstructor2.getProjection();
    }
}
