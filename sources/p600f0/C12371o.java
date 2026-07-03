package p600f0;

import java.util.List;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.o */
/* JADX INFO: compiled from: CookieJar.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12371o implements InterfaceC12372p {
    @Override // p600f0.InterfaceC12372p
    /* JADX INFO: renamed from: a */
    public void mo8745a(C12379w c12379w, List<C12370n> list) {
        C12238m.checkParameterIsNotNull(c12379w, "url");
        C12238m.checkParameterIsNotNull(list, "cookies");
    }

    @Override // p600f0.InterfaceC12372p
    /* JADX INFO: renamed from: b */
    public List<C12370n> mo8746b(C12379w c12379w) {
        C12238m.checkParameterIsNotNull(c12379w, "url");
        return C12147n.emptyList();
    }
}
