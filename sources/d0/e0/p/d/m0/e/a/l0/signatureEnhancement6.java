package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType6;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.r, reason: use source file name */
/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class signatureEnhancement6 {
    public static final boolean access$isNullabilityFlexible(KotlinType kotlinType) {
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        KotlinType6 kotlinType6 = kotlinType3Unwrap instanceof KotlinType6 ? (KotlinType6) kotlinType3Unwrap : null;
        return (kotlinType6 == null || kotlinType6.getLowerBound().isMarkedNullable() == kotlinType6.getUpperBound().isMarkedNullable()) ? false : true;
    }
}
