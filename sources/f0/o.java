package f0;

import java.util.List;

/* JADX INFO: compiled from: CookieJar.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements p {
    @Override // f0.p
    public void a(w wVar, List<n> list) {
        d0.z.d.m.checkParameterIsNotNull(wVar, "url");
        d0.z.d.m.checkParameterIsNotNull(list, "cookies");
    }

    @Override // f0.p
    public List<n> b(w wVar) {
        d0.z.d.m.checkParameterIsNotNull(wVar, "url");
        return d0.t.n.emptyList();
    }
}
