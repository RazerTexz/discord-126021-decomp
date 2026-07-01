package d0.e0.p.d.m0.c;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.a0, reason: use source file name */
/* JADX INFO: compiled from: ModalityUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ModalityUtils {
    public static final boolean isFinalClass(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        return classDescriptor.getModality() == Modality.FINAL && classDescriptor.getKind() != ClassKind.ENUM_CLASS;
    }
}
