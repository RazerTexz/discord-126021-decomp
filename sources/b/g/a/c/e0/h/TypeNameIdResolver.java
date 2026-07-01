package b.g.a.c.e0.h;

import b.g.a.c.JavaType;
import b.g.a.c.MapperFeature;
import b.g.a.c.c0.BasicBeanDescription;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.z.MapperConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: b.g.a.c.e0.h.l, reason: use source file name */
/* JADX INFO: compiled from: TypeNameIdResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeNameIdResolver extends TypeIdResolverBase {
    public final MapperConfig<?> c;
    public final ConcurrentHashMap<String, String> d;
    public final Map<String, JavaType> e;

    public TypeNameIdResolver(MapperConfig<?> mapperConfig, JavaType javaType, ConcurrentHashMap<String, String> concurrentHashMap, HashMap<String, JavaType> map) {
        super(javaType, mapperConfig._base._typeFactory);
        this.c = mapperConfig;
        this.d = concurrentHashMap;
        this.e = map;
        mapperConfig.q(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES);
    }

    public static String d(Class<?> cls) {
        String name = cls.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf < 0 ? name : name.substring(iLastIndexOf + 1);
    }

    @Override // b.g.a.c.e0.TypeIdResolver
    public String a(Object obj) {
        return e(obj.getClass());
    }

    @Override // b.g.a.c.e0.TypeIdResolver
    public String c(Object obj, Class<?> cls) {
        return obj == null ? e(cls) : e(obj.getClass());
    }

    public String e(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        String strD = this.d.get(name);
        if (strD == null) {
            Class<?> cls2 = this.a.b(null, cls, TypeFactory.l)._class;
            if (this.c.p()) {
                strD = this.c.e().O(((BasicBeanDescription) this.c.o(cls2)).f);
            }
            if (strD == null) {
                strD = d(cls2);
            }
            this.d.put(name, strD);
        }
        return strD;
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", TypeNameIdResolver.class.getName(), this.e);
    }
}
