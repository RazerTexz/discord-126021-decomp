package b.g.a.c.z;

import b.g.a.a.JsonInclude;
import b.g.a.a.JsonSetter;
import b.g.a.c.c0.VisibilityChecker;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: renamed from: b.g.a.c.z.g, reason: use source file name */
/* JADX INFO: compiled from: ConfigOverrides.java */
/* JADX INFO: loaded from: classes3.dex */
public class ConfigOverrides implements Serializable {
    private static final long serialVersionUID = 1;
    public JsonInclude.b _defaultInclusion;
    public Boolean _defaultLeniency;
    public Boolean _defaultMergeable;
    public JsonSetter.a _defaultSetterInfo;
    public Map<Class<?>, ?> _overrides;
    public VisibilityChecker<?> _visibilityChecker;

    public ConfigOverrides() {
        JsonInclude.b bVar = JsonInclude.b.j;
        JsonInclude.b bVar2 = JsonInclude.b.j;
        JsonSetter.a aVar = JsonSetter.a.j;
        VisibilityChecker.a aVar2 = VisibilityChecker.a.j;
        this._overrides = null;
        this._defaultInclusion = bVar2;
        this._defaultSetterInfo = aVar;
        this._visibilityChecker = aVar2;
        this._defaultMergeable = null;
        this._defaultLeniency = null;
    }

    public ConfigOverride a(Class<?> cls) {
        Map<Class<?>, ?> map = this._overrides;
        if (map == null) {
            return null;
        }
        return (ConfigOverride) map.get(cls);
    }
}
