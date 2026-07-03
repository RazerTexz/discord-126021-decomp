package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.r */
/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11612r {
    public static final boolean access$isNullabilityFlexible(AbstractC11913c0 abstractC11913c0) {
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        AbstractC12009v abstractC12009v = abstractC11932i1Unwrap instanceof AbstractC12009v ? (AbstractC12009v) abstractC11932i1Unwrap : null;
        return (abstractC12009v == null || abstractC12009v.getLowerBound().isMarkedNullable() == abstractC12009v.getUpperBound().isMarkedNullable()) ? false : true;
    }
}
