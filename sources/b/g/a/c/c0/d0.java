package b.g.a.c.c0;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: SimpleMixInResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class d0 implements t$a, Serializable {
    private static final long serialVersionUID = 1;
    public Map<b.g.a.c.h0.b, Class<?>> _localMixIns;
    public final t$a _overrides = null;

    public d0(t$a t_a) {
    }

    @Override // b.g.a.c.c0.t$a
    public Class<?> a(Class<?> cls) {
        Map<b.g.a.c.h0.b, Class<?>> map;
        t$a t_a = this._overrides;
        Class<?> clsA = t_a == null ? null : t_a.a(cls);
        return (clsA != null || (map = this._localMixIns) == null) ? clsA : map.get(new b.g.a.c.h0.b(cls));
    }

    public boolean b() {
        if (this._localMixIns != null) {
            return true;
        }
        t$a t_a = this._overrides;
        if (t_a == null) {
            return false;
        }
        if (t_a instanceof d0) {
            return ((d0) t_a).b();
        }
        return true;
    }
}
