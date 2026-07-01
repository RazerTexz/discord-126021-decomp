package b.g.a.c.e0.h;

import b.g.a.c.c0.q;
import b.g.a.c.h0.n;
import b.g.a.c.p;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: TypeNameIdResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends k {
    public final b.g.a.c.z.l<?> c;
    public final ConcurrentHashMap<String, String> d;
    public final Map<String, b.g.a.c.j> e;

    public l(b.g.a.c.z.l<?> lVar, b.g.a.c.j jVar, ConcurrentHashMap<String, String> concurrentHashMap, HashMap<String, b.g.a.c.j> map) {
        super(jVar, lVar._base._typeFactory);
        this.c = lVar;
        this.d = concurrentHashMap;
        this.e = map;
        lVar.q(p.ACCEPT_CASE_INSENSITIVE_VALUES);
    }

    public static String d(Class<?> cls) {
        String name = cls.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf < 0 ? name : name.substring(iLastIndexOf + 1);
    }

    @Override // b.g.a.c.e0.e
    public String a(Object obj) {
        return e(obj.getClass());
    }

    @Override // b.g.a.c.e0.e
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
            Class<?> cls2 = this.a.b(null, cls, n.l)._class;
            if (this.c.p()) {
                strD = this.c.e().O(((q) this.c.o(cls2)).f);
            }
            if (strD == null) {
                strD = d(cls2);
            }
            this.d.put(name, strD);
        }
        return strD;
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", l.class.getName(), this.e);
    }
}
