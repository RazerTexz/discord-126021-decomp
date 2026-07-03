package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import java.util.Map;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p197a.InterfaceC2104z;
import p007b.p195g.p196a.p205c.p210c0.InterfaceC2186g0;

/* JADX INFO: renamed from: b.g.a.c.z.g */
/* JADX INFO: compiled from: ConfigOverrides.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2389g implements Serializable {
    private static final long serialVersionUID = 1;
    public InterfaceC2094p.b _defaultInclusion;
    public Boolean _defaultLeniency;
    public Boolean _defaultMergeable;
    public InterfaceC2104z.a _defaultSetterInfo;
    public Map<Class<?>, ?> _overrides;
    public InterfaceC2186g0<?> _visibilityChecker;

    public C2389g() {
        InterfaceC2094p.b bVar = InterfaceC2094p.b.f4436j;
        InterfaceC2094p.b bVar2 = InterfaceC2094p.b.f4436j;
        InterfaceC2104z.a aVar = InterfaceC2104z.a.f4443j;
        InterfaceC2186g0.a aVar2 = InterfaceC2186g0.a.f4709j;
        this._overrides = null;
        this._defaultInclusion = bVar2;
        this._defaultSetterInfo = aVar;
        this._visibilityChecker = aVar2;
        this._defaultMergeable = null;
        this._defaultLeniency = null;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC2388f m2263a(Class<?> cls) {
        Map<Class<?>, ?> map = this._overrides;
        if (map == null) {
            return null;
        }
        return (AbstractC2388f) map.get(cls);
    }
}
