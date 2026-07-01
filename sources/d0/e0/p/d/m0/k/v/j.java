package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;
import kotlin.Pair;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends g<Pair<? extends d0.e0.p.d.m0.g.a, ? extends d0.e0.p.d.m0.g.e>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.g.a f3473b;
    public final d0.e0.p.d.m0.g.e c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar) {
        super(d0.o.to(aVar, eVar));
        d0.z.d.m.checkNotNullParameter(aVar, "enumClassId");
        d0.z.d.m.checkNotNullParameter(eVar, "enumEntryName");
        this.f3473b = aVar;
        this.c = eVar;
    }

    public final d0.e0.p.d.m0.g.e getEnumEntryName() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public c0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.e0.p.d.m0.c.e eVarFindClassAcrossModuleDependencies = d0.e0.p.d.m0.c.w.findClassAcrossModuleDependencies(c0Var, this.f3473b);
        j0 defaultType = null;
        if (eVarFindClassAcrossModuleDependencies != null) {
            if (!d0.e0.p.d.m0.k.e.isEnumClass(eVarFindClassAcrossModuleDependencies)) {
                eVarFindClassAcrossModuleDependencies = null;
            }
            if (eVarFindClassAcrossModuleDependencies != null) {
                defaultType = eVarFindClassAcrossModuleDependencies.getDefaultType();
            }
        }
        if (defaultType != null) {
            return defaultType;
        }
        StringBuilder sbU = b.d.b.a.a.U("Containing class for error-class based enum entry ");
        sbU.append(this.f3473b);
        sbU.append('.');
        sbU.append(this.c);
        j0 j0VarCreateErrorType = d0.e0.p.d.m0.n.t.createErrorType(sbU.toString());
        d0.z.d.m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(\"Containing class for error-class based enum entry $enumClassId.$enumEntryName\")");
        return j0VarCreateErrorType;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3473b.getShortClassName());
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }
}
