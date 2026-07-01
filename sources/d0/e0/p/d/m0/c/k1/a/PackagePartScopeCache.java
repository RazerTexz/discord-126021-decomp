package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.c.i1.EmptyPackageFragmentDesciptor;
import d0.e0.p.d.m0.e.b.DeserializedDescriptorResolver;
import d0.e0.p.d.m0.e.b.KotlinClassFinder2;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass;
import d0.e0.p.d.m0.e.b.b0.KotlinClassHeader;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.k.a0.ChainedMemberScope;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.y.JvmClassName;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.a, reason: use source file name */
/* JADX INFO: compiled from: PackagePartScopeCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PackagePartScopeCache {
    public final DeserializedDescriptorResolver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReflectKotlinClassFinder f3282b;
    public final ConcurrentHashMap<ClassId, MemberScope3> c;

    public PackagePartScopeCache(DeserializedDescriptorResolver deserializedDescriptorResolver, ReflectKotlinClassFinder reflectKotlinClassFinder) {
        Intrinsics3.checkNotNullParameter(deserializedDescriptorResolver, "resolver");
        Intrinsics3.checkNotNullParameter(reflectKotlinClassFinder, "kotlinClassFinder");
        this.a = deserializedDescriptorResolver;
        this.f3282b = reflectKotlinClassFinder;
        this.c = new ConcurrentHashMap<>();
    }

    public final MemberScope3 getPackagePartScope(ReflectKotlinClass2 reflectKotlinClass2) {
        Collection collectionListOf;
        Intrinsics3.checkNotNullParameter(reflectKotlinClass2, "fileClass");
        ConcurrentHashMap<ClassId, MemberScope3> concurrentHashMap = this.c;
        ClassId classId = reflectKotlinClass2.getClassId();
        MemberScope3 memberScope3 = concurrentHashMap.get(classId);
        if (memberScope3 == null) {
            FqName packageFqName = reflectKotlinClass2.getClassId().getPackageFqName();
            Intrinsics3.checkNotNullExpressionValue(packageFqName, "fileClass.classId.packageFqName");
            if (reflectKotlinClass2.getClassHeader().getKind() == KotlinClassHeader.a.MULTIFILE_CLASS) {
                List<String> multifilePartNames = reflectKotlinClass2.getClassHeader().getMultifilePartNames();
                collectionListOf = new ArrayList();
                Iterator<T> it = multifilePartNames.iterator();
                while (it.hasNext()) {
                    ClassId classId2 = ClassId.topLevel(JvmClassName.byInternalName((String) it.next()).getFqNameForTopLevelClassMaybeWithDollars());
                    Intrinsics3.checkNotNullExpressionValue(classId2, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                    KotlinJvmBinaryClass kotlinJvmBinaryClassFindKotlinClass = KotlinClassFinder2.findKotlinClass(this.f3282b, classId2);
                    if (kotlinJvmBinaryClassFindKotlinClass != null) {
                        collectionListOf.add(kotlinJvmBinaryClassFindKotlinClass);
                    }
                }
            } else {
                collectionListOf = CollectionsJVM.listOf(reflectKotlinClass2);
            }
            EmptyPackageFragmentDesciptor emptyPackageFragmentDesciptor = new EmptyPackageFragmentDesciptor(this.a.getComponents().getModuleDescriptor(), packageFqName);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = collectionListOf.iterator();
            while (it2.hasNext()) {
                MemberScope3 memberScope3CreateKotlinPackagePartScope = this.a.createKotlinPackagePartScope(emptyPackageFragmentDesciptor, (KotlinJvmBinaryClass) it2.next());
                if (memberScope3CreateKotlinPackagePartScope != null) {
                    arrayList.add(memberScope3CreateKotlinPackagePartScope);
                }
            }
            List list = _Collections.toList(arrayList);
            MemberScope3 memberScope3Create = ChainedMemberScope.f3451b.create("package " + packageFqName + " (" + reflectKotlinClass2 + ')', list);
            MemberScope3 memberScope3PutIfAbsent = concurrentHashMap.putIfAbsent(classId, memberScope3Create);
            memberScope3 = memberScope3PutIfAbsent != null ? memberScope3PutIfAbsent : memberScope3Create;
        }
        Intrinsics3.checkNotNullExpressionValue(memberScope3, "cache.getOrPut(fileClass.classId) {\n        val fqName = fileClass.classId.packageFqName\n\n        val parts =\n            if (fileClass.classHeader.kind == KotlinClassHeader.Kind.MULTIFILE_CLASS)\n                fileClass.classHeader.multifilePartNames.mapNotNull { partName ->\n                    val classId = ClassId.topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)\n                    kotlinClassFinder.findKotlinClass(classId)\n                }\n            else listOf(fileClass)\n\n        val packageFragment = EmptyPackageFragmentDescriptor(resolver.components.moduleDescriptor, fqName)\n\n        val scopes = parts.mapNotNull { part ->\n            resolver.createKotlinPackagePartScope(packageFragment, part)\n        }.toList()\n\n        ChainedMemberScope.create(\"package $fqName ($fileClass)\", scopes)\n    }");
        return memberScope3;
    }
}
