package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import java.util.Map;
import p007b.p085c.p086a.p095y.C1563b;

/* JADX INFO: renamed from: b.g.a.c.z.d */
/* JADX INFO: compiled from: CoercionConfigs.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2386d implements Serializable {
    private static final long serialVersionUID = 1;
    public EnumC2384b _defaultAction;
    public final C2396n _defaultCoercions;
    public Map<Class<?>, C2396n> _perClassCoercions;
    public C2396n[] _perTypeCoercions;

    static {
        C1563b.com$fasterxml$jackson$databind$type$LogicalType$s$values();
    }

    public C2386d() {
        EnumC2384b enumC2384b = EnumC2384b.TryConvert;
        this._defaultCoercions = new C2396n();
        this._defaultAction = enumC2384b;
        this._perTypeCoercions = null;
        this._perClassCoercions = null;
    }
}
