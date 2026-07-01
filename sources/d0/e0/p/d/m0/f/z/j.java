package d0.e0.p.d.m0.f.z;

import d0.z.d.m;

/* JADX INFO: compiled from: versionSpecificBehavior.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final boolean isKotlin1Dot4OrLater(a aVar) {
        m.checkNotNullParameter(aVar, "version");
        return aVar.getMajor() == 1 && aVar.getMinor() >= 4;
    }

    public static final boolean isVersionRequirementTableWrittenCorrectly(a aVar) {
        m.checkNotNullParameter(aVar, "version");
        return isKotlin1Dot4OrLater(aVar);
    }
}
