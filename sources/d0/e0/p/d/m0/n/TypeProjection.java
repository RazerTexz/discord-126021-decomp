package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.w0, reason: use source file name */
/* JADX INFO: compiled from: TypeProjection.java */
/* JADX INFO: loaded from: classes3.dex */
public interface TypeProjection extends d0.e0.p.d.m0.n.n1.k {
    Variance getProjectionKind();

    KotlinType getType();

    boolean isStarProjection();

    TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner);
}
