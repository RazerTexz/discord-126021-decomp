package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.j */
/* JADX INFO: compiled from: versionSpecificBehavior.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11711j {
    public static final boolean isKotlin1Dot4OrLater(AbstractC11702a abstractC11702a) {
        C12238m.checkNotNullParameter(abstractC11702a, "version");
        return abstractC11702a.getMajor() == 1 && abstractC11702a.getMinor() >= 4;
    }

    public static final boolean isVersionRequirementTableWrittenCorrectly(AbstractC11702a abstractC11702a) {
        C12238m.checkNotNullParameter(abstractC11702a, "version");
        return isKotlin1Dot4OrLater(abstractC11702a);
    }
}
