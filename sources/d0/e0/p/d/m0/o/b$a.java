package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.z.d.m;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a {
    public static String invoke(b bVar, x xVar) {
        m.checkNotNullParameter(bVar, "this");
        m.checkNotNullParameter(xVar, "functionDescriptor");
        if (bVar.check(xVar)) {
            return null;
        }
        return bVar.getDescription();
    }
}
