package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.f */
/* JADX INFO: compiled from: ExternalOverridabilityCondition.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11788f {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.f$a */
    /* JADX INFO: compiled from: ExternalOverridabilityCondition.java */
    public enum a {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.f$b */
    /* JADX INFO: compiled from: ExternalOverridabilityCondition.java */
    public enum b {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN
    }

    a getContract();

    b isOverridable(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2, InterfaceC11330e interfaceC11330e);
}
