package b.g.a.c.c0;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AnnotatedClassResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static final Class<?> a = List.class;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f689b = Map.class;
    public final b.g.a.c.z.l<?> c;
    public final b.g.a.c.b d;
    public final t$a e;
    public final b.g.a.c.h0.m f;
    public final b.g.a.c.j g;
    public final Class<?> h;
    public final Class<?> i;
    public final boolean j;

    public d(b.g.a.c.z.l<?> lVar, b.g.a.c.j jVar, t$a t_a) {
        this.c = lVar;
        this.g = jVar;
        Class<?> cls = jVar._class;
        this.h = cls;
        this.e = t_a;
        this.f = jVar.j();
        b.g.a.c.b bVarE = lVar.p() ? lVar.e() : null;
        this.d = bVarE;
        this.i = t_a != null ? t_a.a(cls) : null;
        this.j = (bVarE == null || (b.g.a.c.i0.d.r(cls) && jVar.v())) ? false : true;
    }

    public static void d(b.g.a.c.j jVar, List<b.g.a.c.j> list, boolean z2) {
        Class<?> cls = jVar._class;
        if (z2) {
            if (f(list, cls)) {
                return;
            }
            list.add(jVar);
            if (cls == a || cls == f689b) {
                return;
            }
        }
        Iterator<b.g.a.c.j> it = jVar.n().iterator();
        while (it.hasNext()) {
            d(it.next(), list, true);
        }
    }

    public static void e(b.g.a.c.j jVar, List<b.g.a.c.j> list, boolean z2) {
        Class<?> cls = jVar._class;
        if (cls == Object.class || cls == Enum.class) {
            return;
        }
        if (z2) {
            if (f(list, cls)) {
                return;
            } else {
                list.add(jVar);
            }
        }
        Iterator<b.g.a.c.j> it = jVar.n().iterator();
        while (it.hasNext()) {
            d(it.next(), list, true);
        }
        b.g.a.c.j jVarQ = jVar.q();
        if (jVarQ != null) {
            e(jVarQ, list, true);
        }
    }

    public static boolean f(List<b.g.a.c.j> list, Class<?> cls) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i)._class == cls) {
                return true;
            }
        }
        return false;
    }

    public static c h(b.g.a.c.z.l<?> lVar, Class<?> cls) {
        if (cls.isArray() && i(lVar, cls)) {
            return new c(cls);
        }
        d dVar = new d(lVar, cls, lVar);
        List<b.g.a.c.j> listEmptyList = Collections.emptyList();
        return new c(null, cls, listEmptyList, dVar.i, dVar.g(listEmptyList), dVar.f, dVar.d, lVar, lVar._base._typeFactory, dVar.j);
    }

    public static boolean i(b.g.a.c.z.l<?> lVar, Class<?> cls) {
        return lVar == null || ((b.g.a.c.z.m) lVar)._mixIns.a(cls) == null;
    }

    public final o a(o oVar, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!oVar.d(annotation)) {
                    oVar = oVar.a(annotation);
                    if (this.d.b0(annotation)) {
                        oVar = c(oVar, annotation);
                    }
                }
            }
        }
        return oVar;
    }

    public final o b(o oVar, Class<?> cls, Class<?> cls2) {
        if (cls2 != null) {
            oVar = a(oVar, b.g.a.c.i0.d.i(cls2));
            Iterator it = ((ArrayList) b.g.a.c.i0.d.j(cls2, cls, false)).iterator();
            while (it.hasNext()) {
                oVar = a(oVar, b.g.a.c.i0.d.i((Class) it.next()));
            }
        }
        return oVar;
    }

    public final o c(o oVar, Annotation annotation) {
        for (Annotation annotation2 : b.g.a.c.i0.d.i(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !oVar.d(annotation2)) {
                oVar = oVar.a(annotation2);
                if (this.d.b0(annotation2)) {
                    oVar = c(oVar, annotation2);
                }
            }
        }
        return oVar;
    }

    public final b.g.a.c.i0.a g(List<b.g.a.c.j> list) {
        if (this.d == null) {
            return o.a;
        }
        t$a t_a = this.e;
        boolean z2 = t_a != null && (!(t_a instanceof d0) || ((d0) t_a).b());
        if (!z2 && !this.j) {
            return o.a;
        }
        o oVarB = o$a.c;
        Class<?> cls = this.i;
        if (cls != null) {
            oVarB = b(oVarB, this.h, cls);
        }
        if (this.j) {
            oVarB = a(oVarB, b.g.a.c.i0.d.i(this.h));
        }
        for (b.g.a.c.j jVar : list) {
            if (z2) {
                Class<?> cls2 = jVar._class;
                oVarB = b(oVarB, cls2, this.e.a(cls2));
            }
            if (this.j) {
                oVarB = a(oVarB, b.g.a.c.i0.d.i(jVar._class));
            }
        }
        if (z2) {
            oVarB = b(oVarB, Object.class, this.e.a(Object.class));
        }
        return oVarB.c();
    }

    public d(b.g.a.c.z.l<?> lVar, Class<?> cls, t$a t_a) {
        this.c = lVar;
        this.g = null;
        this.h = cls;
        this.e = t_a;
        this.f = b.g.a.c.h0.m.l;
        if (lVar == null) {
            this.d = null;
            this.i = null;
        } else {
            this.d = lVar.p() ? lVar.e() : null;
            this.i = t_a != null ? t_a.a(cls) : null;
        }
        this.j = this.d != null;
    }
}
