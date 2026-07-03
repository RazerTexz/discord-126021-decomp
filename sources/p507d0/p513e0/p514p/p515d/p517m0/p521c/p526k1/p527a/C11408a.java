package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11387n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11645f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11654o;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.C11636a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11763b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.C11839c;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.a */
/* JADX INFO: compiled from: PackagePartScopeCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11408a {

    /* JADX INFO: renamed from: a */
    public final C11645f f23009a;

    /* JADX INFO: renamed from: b */
    public final C11414g f23010b;

    /* JADX INFO: renamed from: c */
    public final ConcurrentHashMap<C11712a, InterfaceC11770i> f23011c;

    public C11408a(C11645f c11645f, C11414g c11414g) {
        C12238m.checkNotNullParameter(c11645f, "resolver");
        C12238m.checkNotNullParameter(c11414g, "kotlinClassFinder");
        this.f23009a = c11645f;
        this.f23010b = c11414g;
        this.f23011c = new ConcurrentHashMap<>();
    }

    public final InterfaceC11770i getPackagePartScope(C11413f c11413f) {
        Collection collectionListOf;
        C12238m.checkNotNullParameter(c11413f, "fileClass");
        ConcurrentHashMap<C11712a, InterfaceC11770i> concurrentHashMap = this.f23011c;
        C11712a classId = c11413f.getClassId();
        InterfaceC11770i interfaceC11770i = concurrentHashMap.get(classId);
        if (interfaceC11770i == null) {
            C11713b packageFqName = c11413f.getClassId().getPackageFqName();
            C12238m.checkNotNullExpressionValue(packageFqName, "fileClass.classId.packageFqName");
            if (c11413f.getClassHeader().getKind() == C11636a.a.MULTIFILE_CLASS) {
                List<String> multifilePartNames = c11413f.getClassHeader().getMultifilePartNames();
                collectionListOf = new ArrayList();
                Iterator<T> it = multifilePartNames.iterator();
                while (it.hasNext()) {
                    C11712a c11712a = C11712a.topLevel(C11839c.byInternalName((String) it.next()).getFqNameForTopLevelClassMaybeWithDollars());
                    C12238m.checkNotNullExpressionValue(c11712a, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                    InterfaceC11655p interfaceC11655pFindKotlinClass = C11654o.findKotlinClass(this.f23010b, c11712a);
                    if (interfaceC11655pFindKotlinClass != null) {
                        collectionListOf.add(interfaceC11655pFindKotlinClass);
                    }
                }
            } else {
                collectionListOf = C12145m.listOf(c11413f);
            }
            C11387n c11387n = new C11387n(this.f23009a.getComponents().getModuleDescriptor(), packageFqName);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = collectionListOf.iterator();
            while (it2.hasNext()) {
                InterfaceC11770i interfaceC11770iCreateKotlinPackagePartScope = this.f23009a.createKotlinPackagePartScope(c11387n, (InterfaceC11655p) it2.next());
                if (interfaceC11770iCreateKotlinPackagePartScope != null) {
                    arrayList.add(interfaceC11770iCreateKotlinPackagePartScope);
                }
            }
            List list = C12163u.toList(arrayList);
            InterfaceC11770i interfaceC11770iCreate = C11763b.f24333b.create("package " + packageFqName + " (" + c11413f + ')', list);
            InterfaceC11770i interfaceC11770iPutIfAbsent = concurrentHashMap.putIfAbsent(classId, interfaceC11770iCreate);
            interfaceC11770i = interfaceC11770iPutIfAbsent != null ? interfaceC11770iPutIfAbsent : interfaceC11770iCreate;
        }
        C12238m.checkNotNullExpressionValue(interfaceC11770i, "cache.getOrPut(fileClass.classId) {\n        val fqName = fileClass.classId.packageFqName\n\n        val parts =\n            if (fileClass.classHeader.kind == KotlinClassHeader.Kind.MULTIFILE_CLASS)\n                fileClass.classHeader.multifilePartNames.mapNotNull { partName ->\n                    val classId = ClassId.topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)\n                    kotlinClassFinder.findKotlinClass(classId)\n                }\n            else listOf(fileClass)\n\n        val packageFragment = EmptyPackageFragmentDescriptor(resolver.components.moduleDescriptor, fqName)\n\n        val scopes = parts.mapNotNull { part ->\n            resolver.createKotlinPackagePartScope(packageFragment, part)\n        }.toList()\n\n        ChainedMemberScope.create(\"package $fqName ($fileClass)\", scopes)\n    }");
        return interfaceC11770i;
    }
}
