package b.g.a.c.c0;

import b.g.a.c.c0.ClassIntrospector;
import b.g.a.c.h0.ClassKey;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: renamed from: b.g.a.c.c0.d0, reason: use source file name */
/* JADX INFO: compiled from: SimpleMixInResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleMixInResolver implements ClassIntrospector.a, Serializable {
    private static final long serialVersionUID = 1;
    public Map<ClassKey, Class<?>> _localMixIns;
    public final ClassIntrospector.a _overrides = null;

    public SimpleMixInResolver(ClassIntrospector.a aVar) {
    }

    @Override // b.g.a.c.c0.ClassIntrospector.a
    public Class<?> a(Class<?> cls) {
        Map<ClassKey, Class<?>> map;
        ClassIntrospector.a aVar = this._overrides;
        Class<?> clsA = aVar == null ? null : aVar.a(cls);
        return (clsA != null || (map = this._localMixIns) == null) ? clsA : map.get(new ClassKey(cls));
    }

    public boolean b() {
        if (this._localMixIns != null) {
            return true;
        }
        ClassIntrospector.a aVar = this._overrides;
        if (aVar == null) {
            return false;
        }
        if (aVar instanceof SimpleMixInResolver) {
            return ((SimpleMixInResolver) aVar).b();
        }
        return true;
    }
}
