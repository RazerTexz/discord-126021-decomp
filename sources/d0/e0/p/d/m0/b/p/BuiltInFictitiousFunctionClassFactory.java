package d0.e0.p.d.m0.b.p;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.BuiltInsPackageFragment;
import d0.e0.p.d.m0.b.FunctionInterfacePackageFragment;
import d0.e0.p.d.m0.b.p.FunctionClassKind;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.h1.ClassDescriptorFactory;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.m.StorageManager;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.a, reason: use source file name */
/* JADX INFO: compiled from: BuiltInFictitiousFunctionClassFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    public final StorageManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleDescriptor2 f3233b;

    public BuiltInFictitiousFunctionClassFactory(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        this.a = storageManager;
        this.f3233b = moduleDescriptor2;
    }

    @Override // d0.e0.p.d.m0.c.h1.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        if (classId.isLocal() || classId.isNestedClass()) {
            return null;
        }
        String strAsString = classId.getRelativeClassName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "classId.relativeClassName.asString()");
        if (!Strings4.contains$default((CharSequence) strAsString, (CharSequence) "Function", false, 2, (Object) null)) {
            return null;
        }
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        FunctionClassKind.a.C0378a className = FunctionClassKind.j.parseClassName(strAsString, packageFqName);
        if (className == null) {
            return null;
        }
        FunctionClassKind functionClassKindComponent1 = className.component1();
        int iComponent2 = className.component2();
        List<PackageFragmentDescriptor> fragments = this.f3233b.getPackage(packageFqName).getFragments();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof BuiltInsPackageFragment) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof FunctionInterfacePackageFragment) {
                arrayList2.add(obj2);
            }
        }
        PackageFragmentDescriptor packageFragmentDescriptor = (FunctionInterfacePackageFragment) _Collections.firstOrNull((List) arrayList2);
        if (packageFragmentDescriptor == null) {
            packageFragmentDescriptor = (BuiltInsPackageFragment) _Collections.first((List) arrayList);
        }
        return new FunctionClassDescriptor(this.a, packageFragmentDescriptor, functionClassKindComponent1, iComponent2);
    }

    @Override // d0.e0.p.d.m0.c.h1.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
        return Sets5.emptySet();
    }

    @Override // d0.e0.p.d.m0.c.h1.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName fqName, Name name) {
        Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strAsString = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        return (StringsJVM.startsWith$default(strAsString, "Function", false, 2, null) || StringsJVM.startsWith$default(strAsString, "KFunction", false, 2, null) || StringsJVM.startsWith$default(strAsString, "SuspendFunction", false, 2, null) || StringsJVM.startsWith$default(strAsString, "KSuspendFunction", false, 2, null)) && FunctionClassKind.j.parseClassName(strAsString, fqName) != null;
    }
}
