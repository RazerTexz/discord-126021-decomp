package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.ModuleCapability;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.r, reason: use source file name */
/* JADX INFO: compiled from: ResolutionAnchorProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ResolutionAnchorProvider2 {
    public static final ModuleCapability<ResolutionAnchorProvider> a = new ModuleCapability<>("ResolutionAnchorProvider");

    public static final ModuleDescriptor2 getResolutionAnchorIfAny(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        ResolutionAnchorProvider resolutionAnchorProvider = (ResolutionAnchorProvider) moduleDescriptor2.getCapability(a);
        if (resolutionAnchorProvider == null) {
            return null;
        }
        return resolutionAnchorProvider.getResolutionAnchor(moduleDescriptor2);
    }
}
