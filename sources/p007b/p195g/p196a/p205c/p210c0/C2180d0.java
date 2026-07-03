package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.util.Map;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2199t;
import p007b.p195g.p196a.p205c.p218h0.C2323b;

/* JADX INFO: renamed from: b.g.a.c.c0.d0 */
/* JADX INFO: compiled from: SimpleMixInResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2180d0 implements AbstractC2199t.a, Serializable {
    private static final long serialVersionUID = 1;
    public Map<C2323b, Class<?>> _localMixIns;
    public final AbstractC2199t.a _overrides = null;

    public C2180d0(AbstractC2199t.a aVar) {
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2199t.a
    /* JADX INFO: renamed from: a */
    public Class<?> mo1885a(Class<?> cls) {
        Map<C2323b, Class<?>> map;
        AbstractC2199t.a aVar = this._overrides;
        Class<?> clsMo1885a = aVar == null ? null : aVar.mo1885a(cls);
        return (clsMo1885a != null || (map = this._localMixIns) == null) ? clsMo1885a : map.get(new C2323b(cls));
    }

    /* JADX INFO: renamed from: b */
    public boolean m1886b() {
        if (this._localMixIns != null) {
            return true;
        }
        AbstractC2199t.a aVar = this._overrides;
        if (aVar == null) {
            return false;
        }
        if (aVar instanceof C2180d0) {
            return ((C2180d0) aVar).m1886b();
        }
        return true;
    }
}
