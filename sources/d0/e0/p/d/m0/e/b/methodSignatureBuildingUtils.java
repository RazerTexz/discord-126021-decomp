package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.t, reason: use source file name */
/* JADX INFO: compiled from: methodSignatureBuildingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class methodSignatureBuildingUtils {
    public static final String signature(SignatureBuildingComponents signatureBuildingComponents, ClassDescriptor classDescriptor, String str) {
        Intrinsics3.checkNotNullParameter(signatureBuildingComponents, "<this>");
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics3.checkNotNullParameter(str, "jvmDescriptor");
        return signatureBuildingComponents.signature(methodSignatureMapping3.getInternalName(classDescriptor), str);
    }
}
