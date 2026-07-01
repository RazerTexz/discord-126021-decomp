package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.d, reason: use source file name */
/* JADX INFO: compiled from: CompanionObjectMappingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CompanionObjectMappingUtils {
    public static final boolean isMappedIntrinsicCompanionObject(CompanionObjectMapping companionObjectMapping, ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(companionObjectMapping, "<this>");
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (DescriptorUtils.isCompanionObject(classDescriptor)) {
            Set<ClassId> classIds = companionObjectMapping.getClassIds();
            ClassId classId = DescriptorUtils2.getClassId(classDescriptor);
            if (_Collections.contains(classIds, classId == null ? null : classId.getOuterClassId())) {
                return true;
            }
        }
        return false;
    }
}
