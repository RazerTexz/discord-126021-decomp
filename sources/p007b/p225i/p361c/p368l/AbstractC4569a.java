package p007b.p225i.p361c.p368l;

import java.util.Set;
import p007b.p225i.p361c.p400t.InterfaceC4836a;

/* JADX INFO: renamed from: b.i.c.l.a */
/* JADX INFO: compiled from: AbstractComponentContainer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4569a implements InterfaceC4573e {
    @Override // p007b.p225i.p361c.p368l.InterfaceC4573e
    /* JADX INFO: renamed from: a */
    public <T> T mo6346a(Class<T> cls) {
        InterfaceC4836a<T> interfaceC4836aMo6355b = mo6355b(cls);
        if (interfaceC4836aMo6355b == null) {
            return null;
        }
        return interfaceC4836aMo6355b.get();
    }

    @Override // p007b.p225i.p361c.p368l.InterfaceC4573e
    /* JADX INFO: renamed from: d */
    public <T> Set<T> mo6347d(Class<T> cls) {
        return mo6356c(cls).get();
    }
}
