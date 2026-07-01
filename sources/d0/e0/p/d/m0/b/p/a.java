package d0.e0.p.d.m0.b.p;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.f;
import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.m.o;
import d0.g0.t;
import d0.g0.w;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: BuiltInFictitiousFunctionClassFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements d0.e0.p.d.m0.c.h1.b {
    public final o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f3233b;

    public a(o oVar, c0 c0Var) {
        m.checkNotNullParameter(oVar, "storageManager");
        m.checkNotNullParameter(c0Var, "module");
        this.a = oVar;
        this.f3233b = c0Var;
    }

    @Override // d0.e0.p.d.m0.c.h1.b
    public d0.e0.p.d.m0.c.e createClass(d0.e0.p.d.m0.g.a aVar) {
        m.checkNotNullParameter(aVar, "classId");
        if (aVar.isLocal() || aVar.isNestedClass()) {
            return null;
        }
        String strAsString = aVar.getRelativeClassName().asString();
        m.checkNotNullExpressionValue(strAsString, "classId.relativeClassName.asString()");
        if (!w.contains$default((CharSequence) strAsString, (CharSequence) "Function", false, 2, (Object) null)) {
            return null;
        }
        d0.e0.p.d.m0.g.b packageFqName = aVar.getPackageFqName();
        m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        c$a$a className = c.j.parseClassName(strAsString, packageFqName);
        if (className == null) {
            return null;
        }
        c cVarComponent1 = className.component1();
        int iComponent2 = className.component2();
        List<e0> fragments = this.f3233b.getPackage(packageFqName).getFragments();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof d0.e0.p.d.m0.b.b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof f) {
                arrayList2.add(obj2);
            }
        }
        e0 e0Var = (f) u.firstOrNull((List) arrayList2);
        if (e0Var == null) {
            e0Var = (d0.e0.p.d.m0.b.b) u.first((List) arrayList);
        }
        return new b(this.a, e0Var, cVarComponent1, iComponent2);
    }

    @Override // d0.e0.p.d.m0.c.h1.b
    public Collection<d0.e0.p.d.m0.c.e> getAllContributedClassesIfPossible(d0.e0.p.d.m0.g.b bVar) {
        m.checkNotNullParameter(bVar, "packageFqName");
        return n0.emptySet();
    }

    @Override // d0.e0.p.d.m0.c.h1.b
    public boolean shouldCreateClass(d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.g.e eVar) {
        m.checkNotNullParameter(bVar, "packageFqName");
        m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strAsString = eVar.asString();
        m.checkNotNullExpressionValue(strAsString, "name.asString()");
        return (t.startsWith$default(strAsString, "Function", false, 2, null) || t.startsWith$default(strAsString, "KFunction", false, 2, null) || t.startsWith$default(strAsString, "SuspendFunction", false, 2, null) || t.startsWith$default(strAsString, "KSuspendFunction", false, 2, null)) && c.j.parseClassName(strAsString, bVar) != null;
    }
}
