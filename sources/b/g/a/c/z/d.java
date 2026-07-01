package b.g.a.c.z;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: CoercionConfigs.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements Serializable {
    private static final long serialVersionUID = 1;
    public b _defaultAction;
    public final n _defaultCoercions;
    public Map<Class<?>, n> _perClassCoercions;
    public n[] _perTypeCoercions;

    static {
        b.c.a.y.b.com$fasterxml$jackson$databind$type$LogicalType$s$values();
    }

    public d() {
        b bVar = b.TryConvert;
        this._defaultCoercions = new n();
        this._defaultAction = bVar;
        this._perTypeCoercions = null;
        this._perClassCoercions = null;
    }
}
