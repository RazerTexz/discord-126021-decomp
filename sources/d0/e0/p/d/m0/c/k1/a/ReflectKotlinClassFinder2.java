package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.g.ClassId;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.h, reason: use source file name */
/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectKotlinClassFinder2 {
    public static final String access$toRuntimeFqName(ClassId classId) {
        String strAsString = classId.getRelativeClassName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "relativeClassName.asString()");
        String strReplace$default = StringsJVM.replace$default(strAsString, '.', '$', false, 4, (Object) null);
        if (classId.getPackageFqName().isRoot()) {
            return strReplace$default;
        }
        return classId.getPackageFqName() + '.' + strReplace$default;
    }
}
