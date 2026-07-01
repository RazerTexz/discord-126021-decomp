package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.j0;

/* JADX INFO: compiled from: JavaFlexibleTypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements d0.e0.p.d.m0.l.b.q {
    public static final h a = new h();

    @Override // d0.e0.p.d.m0.l.b.q
    public c0 create(d0.e0.p.d.m0.f.q qVar, String str, j0 j0Var, j0 j0Var2) {
        d0.z.d.m.checkNotNullParameter(qVar, "proto");
        d0.z.d.m.checkNotNullParameter(str, "flexibleId");
        d0.z.d.m.checkNotNullParameter(j0Var, "lowerBound");
        d0.z.d.m.checkNotNullParameter(j0Var2, "upperBound");
        if (d0.z.d.m.areEqual(str, "kotlin.jvm.PlatformType")) {
            if (qVar.hasExtension(d0.e0.p.d.m0.f.a0.a.g)) {
                return new d0.e0.p.d.m0.e.a.i0.m.g(j0Var, j0Var2);
            }
            d0 d0Var = d0.a;
            return d0.flexibleType(j0Var, j0Var2);
        }
        j0 j0VarCreateErrorType = d0.e0.p.d.m0.n.t.createErrorType("Error java flexible type with id: " + str + ". (" + j0Var + ".." + j0Var2 + ')');
        d0.z.d.m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(\"Error java flexible type with id: $flexibleId. ($lowerBound..$upperBound)\")");
        return j0VarCreateErrorType;
    }
}
