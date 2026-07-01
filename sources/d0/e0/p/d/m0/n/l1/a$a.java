package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.f$b$a;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.v0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a {
    public a$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f$b$a classicSubstitutionSupertypePolicy(c cVar, d0.e0.p.d.m0.n.n1.i iVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "<this>");
        d0.z.d.m.checkNotNullParameter(iVar, "type");
        if (iVar instanceof j0) {
            return new a$a$a(cVar, v0.f3542b.create((c0) iVar).buildSubstitutor());
        }
        throw new IllegalArgumentException(b.access$errorMessage(iVar).toString());
    }
}
