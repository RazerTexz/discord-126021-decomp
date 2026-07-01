package b.g.a.c.z;

import b.g.a.a.p$b;
import b.g.a.a.z$a;
import b.g.a.c.c0.g0;
import b.g.a.c.c0.g0$a;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: ConfigOverrides.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements Serializable {
    private static final long serialVersionUID = 1;
    public p$b _defaultInclusion;
    public Boolean _defaultLeniency;
    public Boolean _defaultMergeable;
    public z$a _defaultSetterInfo;
    public Map<Class<?>, ?> _overrides;
    public g0<?> _visibilityChecker;

    public g() {
        p$b p_b = p$b.j;
        p$b p_b2 = p$b.j;
        z$a z_a = z$a.j;
        g0$a g0_a = g0$a.j;
        this._overrides = null;
        this._defaultInclusion = p_b2;
        this._defaultSetterInfo = z_a;
        this._visibilityChecker = g0_a;
        this._defaultMergeable = null;
        this._defaultLeniency = null;
    }

    public f a(Class<?> cls) {
        Map<Class<?>, ?> map = this._overrides;
        if (map == null) {
            return null;
        }
        return (f) map.get(cls);
    }
}
