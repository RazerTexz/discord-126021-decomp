package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.l.b.p;
import java.util.List;

/* JADX INFO: compiled from: RuntimeErrorReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f3286b = new j();

    @Override // d0.e0.p.d.m0.l.b.p
    public void reportCannotInferVisibility(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "descriptor");
        throw new IllegalStateException(d0.z.d.m.stringPlus("Cannot infer visibility for ", bVar));
    }

    @Override // d0.e0.p.d.m0.l.b.p
    public void reportIncompleteHierarchy(d0.e0.p.d.m0.c.e eVar, List<String> list) {
        d0.z.d.m.checkNotNullParameter(eVar, "descriptor");
        d0.z.d.m.checkNotNullParameter(list, "unresolvedSuperClasses");
        StringBuilder sbU = b.d.b.a.a.U("Incomplete hierarchy for class ");
        sbU.append(eVar.getName());
        sbU.append(", unresolved classes ");
        sbU.append(list);
        throw new IllegalStateException(sbU.toString());
    }
}
