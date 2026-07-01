package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.e.b.b0.a$a;
import d0.e0.p.d.m0.e.b.o;
import d0.e0.p.d.m0.e.b.p;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PackagePartScopeCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final d0.e0.p.d.m0.e.b.f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f3282b;
    public final ConcurrentHashMap<d0.e0.p.d.m0.g.a, d0.e0.p.d.m0.k.a0.i> c;

    public a(d0.e0.p.d.m0.e.b.f fVar, g gVar) {
        d0.z.d.m.checkNotNullParameter(fVar, "resolver");
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinClassFinder");
        this.a = fVar;
        this.f3282b = gVar;
        this.c = new ConcurrentHashMap<>();
    }

    public final d0.e0.p.d.m0.k.a0.i getPackagePartScope(f fVar) {
        Collection collectionListOf;
        d0.z.d.m.checkNotNullParameter(fVar, "fileClass");
        ConcurrentHashMap<d0.e0.p.d.m0.g.a, d0.e0.p.d.m0.k.a0.i> concurrentHashMap = this.c;
        d0.e0.p.d.m0.g.a classId = fVar.getClassId();
        d0.e0.p.d.m0.k.a0.i iVar = concurrentHashMap.get(classId);
        if (iVar == null) {
            d0.e0.p.d.m0.g.b packageFqName = fVar.getClassId().getPackageFqName();
            d0.z.d.m.checkNotNullExpressionValue(packageFqName, "fileClass.classId.packageFqName");
            if (fVar.getClassHeader().getKind() == a$a.MULTIFILE_CLASS) {
                List<String> multifilePartNames = fVar.getClassHeader().getMultifilePartNames();
                collectionListOf = new ArrayList();
                Iterator<T> it = multifilePartNames.iterator();
                while (it.hasNext()) {
                    d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(d0.e0.p.d.m0.k.y.c.byInternalName((String) it.next()).getFqNameForTopLevelClassMaybeWithDollars());
                    d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                    p pVarFindKotlinClass = o.findKotlinClass(this.f3282b, aVar);
                    if (pVarFindKotlinClass != null) {
                        collectionListOf.add(pVarFindKotlinClass);
                    }
                }
            } else {
                collectionListOf = d0.t.m.listOf(fVar);
            }
            d0.e0.p.d.m0.c.i1.n nVar = new d0.e0.p.d.m0.c.i1.n(this.a.getComponents().getModuleDescriptor(), packageFqName);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = collectionListOf.iterator();
            while (it2.hasNext()) {
                d0.e0.p.d.m0.k.a0.i iVarCreateKotlinPackagePartScope = this.a.createKotlinPackagePartScope(nVar, (p) it2.next());
                if (iVarCreateKotlinPackagePartScope != null) {
                    arrayList.add(iVarCreateKotlinPackagePartScope);
                }
            }
            List list = u.toList(arrayList);
            d0.e0.p.d.m0.k.a0.i iVarCreate = d0.e0.p.d.m0.k.a0.b.f3451b.create("package " + packageFqName + " (" + fVar + ')', list);
            d0.e0.p.d.m0.k.a0.i iVarPutIfAbsent = concurrentHashMap.putIfAbsent(classId, iVarCreate);
            iVar = iVarPutIfAbsent != null ? iVarPutIfAbsent : iVarCreate;
        }
        d0.z.d.m.checkNotNullExpressionValue(iVar, "cache.getOrPut(fileClass.classId) {\n        val fqName = fileClass.classId.packageFqName\n\n        val parts =\n            if (fileClass.classHeader.kind == KotlinClassHeader.Kind.MULTIFILE_CLASS)\n                fileClass.classHeader.multifilePartNames.mapNotNull { partName ->\n                    val classId = ClassId.topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)\n                    kotlinClassFinder.findKotlinClass(classId)\n                }\n            else listOf(fileClass)\n\n        val packageFragment = EmptyPackageFragmentDescriptor(resolver.components.moduleDescriptor, fqName)\n\n        val scopes = parts.mapNotNull { part ->\n            resolver.createKotlinPackagePartScope(packageFragment, part)\n        }.toList()\n\n        ChainedMemberScope.create(\"package $fqName ($fileClass)\", scopes)\n    }");
        return iVar;
    }
}
