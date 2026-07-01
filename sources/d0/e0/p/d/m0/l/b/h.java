package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.f0;
import d0.e0.p.d.m0.c.h0;
import d0.e0.p.d.m0.c.u0;
import d0.t.m0;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ClassDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final h$b a = new h$b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<d0.e0.p.d.m0.g.a> f3500b = m0.setOf(d0.e0.p.d.m0.g.a.topLevel(d0.e0.p.d.m0.b.k$a.d.toSafe()));
    public final j c;
    public final Function1<h$a, d0.e0.p.d.m0.c.e> d;

    public h(j jVar) {
        d0.z.d.m.checkNotNullParameter(jVar, "components");
        this.c = jVar;
        this.d = jVar.getStorageManager().createMemoizedFunctionWithNullableValues(new h$c(this));
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00bf  */
    public static final d0.e0.p.d.m0.c.e access$createClass(h hVar, h$a h_a) {
        Object next;
        l lVarCreateContext;
        boolean z2;
        Objects.requireNonNull(hVar);
        d0.e0.p.d.m0.g.a classId = h_a.getClassId();
        Iterator<d0.e0.p.d.m0.c.h1.b> it = hVar.c.getFictitiousClassDescriptorFactories().iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.e eVarCreateClass = it.next().createClass(classId);
            if (eVarCreateClass != null) {
                return eVarCreateClass;
            }
        }
        if (a.getBLACK_LIST().contains(classId)) {
            return null;
        }
        f classData = h_a.getClassData();
        if (classData == null && (classData = hVar.c.getClassDataFinder().findClassData(classId)) == null) {
            return null;
        }
        d0.e0.p.d.m0.f.z.c cVarComponent1 = classData.component1();
        d0.e0.p.d.m0.f.c cVarComponent2 = classData.component2();
        d0.e0.p.d.m0.f.z.a aVarComponent3 = classData.component3();
        u0 u0VarComponent4 = classData.component4();
        d0.e0.p.d.m0.g.a outerClassId = classId.getOuterClassId();
        if (outerClassId != null) {
            d0.e0.p.d.m0.c.e eVarDeserializeClass$default = deserializeClass$default(hVar, outerClassId, null, 2, null);
            d0.e0.p.d.m0.l.b.e0.d dVar = eVarDeserializeClass$default instanceof d0.e0.p.d.m0.l.b.e0.d ? (d0.e0.p.d.m0.l.b.e0.d) eVarDeserializeClass$default : null;
            if (dVar == null) {
                return null;
            }
            d0.e0.p.d.m0.g.e shortClassName = classId.getShortClassName();
            d0.z.d.m.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
            if (!dVar.hasNestedClass$deserialization(shortClassName)) {
                return null;
            }
            lVarCreateContext = dVar.getC();
        } else {
            f0 packageFragmentProvider = hVar.c.getPackageFragmentProvider();
            d0.e0.p.d.m0.g.b packageFqName = classId.getPackageFqName();
            d0.z.d.m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            Iterator<T> it2 = h0.packageFragments(packageFragmentProvider, packageFqName).iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                e0 e0Var = (e0) next;
                if (e0Var instanceof n) {
                    d0.e0.p.d.m0.g.e shortClassName2 = classId.getShortClassName();
                    d0.z.d.m.checkNotNullExpressionValue(shortClassName2, "classId.shortClassName");
                    if (((n) e0Var).hasTopLevelClass(shortClassName2)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = true;
                }
            } while (!z2);
            e0 e0Var2 = (e0) next;
            if (e0Var2 == null) {
                return null;
            }
            j jVar = hVar.c;
            d0.e0.p.d.m0.f.t typeTable = cVarComponent2.getTypeTable();
            d0.z.d.m.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
            d0.e0.p.d.m0.f.z.g gVar = new d0.e0.p.d.m0.f.z.g(typeTable);
            d0.e0.p.d.m0.f.z.i$a i_a = d0.e0.p.d.m0.f.z.i.a;
            d0.e0.p.d.m0.f.w versionRequirementTable = cVarComponent2.getVersionRequirementTable();
            d0.z.d.m.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
            lVarCreateContext = jVar.createContext(e0Var2, cVarComponent1, gVar, i_a.create(versionRequirementTable), aVarComponent3, null);
        }
        return new d0.e0.p.d.m0.l.b.e0.d(lVarCreateContext, cVarComponent2, cVarComponent1, aVarComponent3, u0VarComponent4);
    }

    public static final /* synthetic */ Set access$getBLACK_LIST$cp() {
        return f3500b;
    }

    public static /* synthetic */ d0.e0.p.d.m0.c.e deserializeClass$default(h hVar, d0.e0.p.d.m0.g.a aVar, f fVar, int i, Object obj) {
        if ((i & 2) != 0) {
            fVar = null;
        }
        return hVar.deserializeClass(aVar, fVar);
    }

    public final d0.e0.p.d.m0.c.e deserializeClass(d0.e0.p.d.m0.g.a aVar, f fVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        return this.d.invoke(new h$a(aVar, fVar));
    }
}
