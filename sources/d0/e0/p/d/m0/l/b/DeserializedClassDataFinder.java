package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentProvider;
import d0.e0.p.d.m0.c.PackageFragmentProvider2;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.m, reason: use source file name */
/* JADX INFO: compiled from: DeserializedClassDataFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedClassDataFinder implements ClassDataFinder {
    public final PackageFragmentProvider a;

    public DeserializedClassDataFinder(PackageFragmentProvider packageFragmentProvider) {
        Intrinsics3.checkNotNullParameter(packageFragmentProvider, "packageFragmentProvider");
        this.a = packageFragmentProvider;
    }

    @Override // d0.e0.p.d.m0.l.b.ClassDataFinder
    public ClassData findClassData(ClassId classId) {
        ClassData classDataFindClassData;
        Intrinsics3.checkNotNullParameter(classId, "classId");
        PackageFragmentProvider packageFragmentProvider = this.a;
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        for (PackageFragmentDescriptor packageFragmentDescriptor : PackageFragmentProvider2.packageFragments(packageFragmentProvider, packageFqName)) {
            if ((packageFragmentDescriptor instanceof DeserializedPackageFragment) && (classDataFindClassData = ((DeserializedPackageFragment) packageFragmentDescriptor).getClassDataFinder().findClassData(classId)) != null) {
                return classDataFindClassData;
            }
        }
        return null;
    }
}
