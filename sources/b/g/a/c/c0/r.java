package b.g.a.c.c0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: BasicClassIntrospector.java */
/* JADX INFO: loaded from: classes3.dex */
public class r extends t implements Serializable {
    public static final Class<?> j = b.g.a.c.l.class;
    public static final q k;
    public static final q l;
    public static final q m;
    public static final q n;
    public static final q o;
    private static final long serialVersionUID = 2;

    static {
        b.g.a.c.h0.k kVarL = b.g.a.c.h0.k.L(String.class);
        Class<?> cls = d.a;
        k = q.e(null, kVarL, new c(String.class));
        Class cls2 = Boolean.TYPE;
        l = q.e(null, b.g.a.c.h0.k.L(cls2), new c(cls2));
        Class cls3 = Integer.TYPE;
        m = q.e(null, b.g.a.c.h0.k.L(cls3), new c(cls3));
        Class cls4 = Long.TYPE;
        n = q.e(null, b.g.a.c.h0.k.L(cls4), new c(cls4));
        o = q.e(null, b.g.a.c.h0.k.L(Object.class), new c(Object.class));
    }

    public q a(b.g.a.c.z.l<?> lVar, b.g.a.c.j jVar) {
        Class<?> cls = jVar._class;
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return m;
            }
            if (cls == Long.TYPE) {
                return n;
            }
            if (cls == Boolean.TYPE) {
                return l;
            }
            return null;
        }
        if (!b.g.a.c.i0.d.r(cls)) {
            if (!j.isAssignableFrom(cls)) {
                return null;
            }
            Class<?> cls2 = d.a;
            return q.e(lVar, jVar, new c(cls));
        }
        if (cls == Object.class) {
            return o;
        }
        if (cls == String.class) {
            return k;
        }
        if (cls == Integer.class) {
            return m;
        }
        if (cls == Long.class) {
            return n;
        }
        if (cls == Boolean.class) {
            return l;
        }
        return null;
    }

    public c b(b.g.a.c.z.l<?> lVar, b.g.a.c.j jVar, t$a t_a) {
        Class<?> cls = d.a;
        Objects.requireNonNull(jVar);
        if ((jVar instanceof b.g.a.c.h0.a) && d.i(lVar, jVar._class)) {
            return new c(jVar._class);
        }
        d dVar = new d(lVar, jVar, t_a);
        ArrayList arrayList = new ArrayList(8);
        Class<?> cls2 = jVar._class;
        if (!(cls2 == Object.class)) {
            if (cls2.isInterface()) {
                d.d(jVar, arrayList, false);
            } else {
                d.e(jVar, arrayList, false);
            }
        }
        return new c(jVar, dVar.h, arrayList, dVar.i, dVar.g(arrayList), dVar.f, dVar.d, t_a, lVar._base._typeFactory, dVar.j);
    }
}
