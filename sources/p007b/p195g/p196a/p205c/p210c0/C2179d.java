package p007b.p195g.p196a.p205c.p210c0;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2194o;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2199t;
import p007b.p195g.p196a.p205c.p218h0.C2334m;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;
import p007b.p195g.p196a.p205c.p221z.AbstractC2395m;

/* JADX INFO: renamed from: b.g.a.c.c0.d */
/* JADX INFO: compiled from: AnnotatedClassResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2179d {

    /* JADX INFO: renamed from: a */
    public static final Class<?> f4692a = List.class;

    /* JADX INFO: renamed from: b */
    public static final Class<?> f4693b = Map.class;

    /* JADX INFO: renamed from: c */
    public final AbstractC2394l<?> f4694c;

    /* JADX INFO: renamed from: d */
    public final AbstractC2165b f4695d;

    /* JADX INFO: renamed from: e */
    public final AbstractC2199t.a f4696e;

    /* JADX INFO: renamed from: f */
    public final C2334m f4697f;

    /* JADX INFO: renamed from: g */
    public final AbstractC2360j f4698g;

    /* JADX INFO: renamed from: h */
    public final Class<?> f4699h;

    /* JADX INFO: renamed from: i */
    public final Class<?> f4700i;

    /* JADX INFO: renamed from: j */
    public final boolean f4701j;

    public C2179d(AbstractC2394l<?> abstractC2394l, AbstractC2360j abstractC2360j, AbstractC2199t.a aVar) {
        this.f4694c = abstractC2394l;
        this.f4698g = abstractC2360j;
        Class<?> cls = abstractC2360j._class;
        this.f4699h = cls;
        this.f4696e = aVar;
        this.f4697f = abstractC2360j.mo2136j();
        AbstractC2165b abstractC2165bM2267e = abstractC2394l.m2278p() ? abstractC2394l.m2267e() : null;
        this.f4695d = abstractC2165bM2267e;
        this.f4700i = aVar != null ? aVar.mo1885a(cls) : null;
        this.f4701j = (abstractC2165bM2267e == null || (C2342d.m2186r(cls) && abstractC2360j.mo2104v())) ? false : true;
    }

    /* JADX INFO: renamed from: d */
    public static void m1876d(AbstractC2360j abstractC2360j, List<AbstractC2360j> list, boolean z2) {
        Class<?> cls = abstractC2360j._class;
        if (z2) {
            if (m1878f(list, cls)) {
                return;
            }
            list.add(abstractC2360j);
            if (cls == f4692a || cls == f4693b) {
                return;
            }
        }
        Iterator<AbstractC2360j> it = abstractC2360j.mo2145n().iterator();
        while (it.hasNext()) {
            m1876d(it.next(), list, true);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1877e(AbstractC2360j abstractC2360j, List<AbstractC2360j> list, boolean z2) {
        Class<?> cls = abstractC2360j._class;
        if (cls == Object.class || cls == Enum.class) {
            return;
        }
        if (z2) {
            if (m1878f(list, cls)) {
                return;
            } else {
                list.add(abstractC2360j);
            }
        }
        Iterator<AbstractC2360j> it = abstractC2360j.mo2145n().iterator();
        while (it.hasNext()) {
            m1876d(it.next(), list, true);
        }
        AbstractC2360j abstractC2360jMo2137q = abstractC2360j.mo2137q();
        if (abstractC2360jMo2137q != null) {
            m1877e(abstractC2360jMo2137q, list, true);
        }
    }

    /* JADX INFO: renamed from: f */
    public static boolean m1878f(List<AbstractC2360j> list, Class<?> cls) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i)._class == cls) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: h */
    public static C2177c m1879h(AbstractC2394l<?> abstractC2394l, Class<?> cls) {
        if (cls.isArray() && m1880i(abstractC2394l, cls)) {
            return new C2177c(cls);
        }
        C2179d c2179d = new C2179d(abstractC2394l, cls, abstractC2394l);
        List<AbstractC2360j> listEmptyList = Collections.emptyList();
        return new C2177c(null, cls, listEmptyList, c2179d.f4700i, c2179d.m1884g(listEmptyList), c2179d.f4697f, c2179d.f4695d, abstractC2394l, abstractC2394l._base._typeFactory, c2179d.f4701j);
    }

    /* JADX INFO: renamed from: i */
    public static boolean m1880i(AbstractC2394l<?> abstractC2394l, Class<?> cls) {
        return abstractC2394l == null || ((AbstractC2395m) abstractC2394l)._mixIns.mo1885a(cls) == null;
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC2194o m1881a(AbstractC2194o abstractC2194o, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!abstractC2194o.mo1914d(annotation)) {
                    abstractC2194o = abstractC2194o.mo1911a(annotation);
                    if (this.f4695d.mo1774b0(annotation)) {
                        abstractC2194o = m1883c(abstractC2194o, annotation);
                    }
                }
            }
        }
        return abstractC2194o;
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC2194o m1882b(AbstractC2194o abstractC2194o, Class<?> cls, Class<?> cls2) {
        if (cls2 != null) {
            abstractC2194o = m1881a(abstractC2194o, C2342d.m2177i(cls2));
            Iterator it = ((ArrayList) C2342d.m2178j(cls2, cls, false)).iterator();
            while (it.hasNext()) {
                abstractC2194o = m1881a(abstractC2194o, C2342d.m2177i((Class) it.next()));
            }
        }
        return abstractC2194o;
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC2194o m1883c(AbstractC2194o abstractC2194o, Annotation annotation) {
        for (Annotation annotation2 : C2342d.m2177i(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !abstractC2194o.mo1914d(annotation2)) {
                abstractC2194o = abstractC2194o.mo1911a(annotation2);
                if (this.f4695d.mo1774b0(annotation2)) {
                    abstractC2194o = m1883c(abstractC2194o, annotation2);
                }
            }
        }
        return abstractC2194o;
    }

    /* JADX INFO: renamed from: g */
    public final InterfaceC2339a m1884g(List<AbstractC2360j> list) {
        if (this.f4695d == null) {
            return AbstractC2194o.f4725a;
        }
        AbstractC2199t.a aVar = this.f4696e;
        boolean z2 = aVar != null && (!(aVar instanceof C2180d0) || ((C2180d0) aVar).m1886b());
        if (!z2 && !this.f4701j) {
            return AbstractC2194o.f4725a;
        }
        AbstractC2194o abstractC2194oM1882b = AbstractC2194o.a.f4727c;
        Class<?> cls = this.f4700i;
        if (cls != null) {
            abstractC2194oM1882b = m1882b(abstractC2194oM1882b, this.f4699h, cls);
        }
        if (this.f4701j) {
            abstractC2194oM1882b = m1881a(abstractC2194oM1882b, C2342d.m2177i(this.f4699h));
        }
        for (AbstractC2360j abstractC2360j : list) {
            if (z2) {
                Class<?> cls2 = abstractC2360j._class;
                abstractC2194oM1882b = m1882b(abstractC2194oM1882b, cls2, this.f4696e.mo1885a(cls2));
            }
            if (this.f4701j) {
                abstractC2194oM1882b = m1881a(abstractC2194oM1882b, C2342d.m2177i(abstractC2360j._class));
            }
        }
        if (z2) {
            abstractC2194oM1882b = m1882b(abstractC2194oM1882b, Object.class, this.f4696e.mo1885a(Object.class));
        }
        return abstractC2194oM1882b.mo1913c();
    }

    public C2179d(AbstractC2394l<?> abstractC2394l, Class<?> cls, AbstractC2199t.a aVar) {
        this.f4694c = abstractC2394l;
        this.f4698g = null;
        this.f4699h = cls;
        this.f4696e = aVar;
        this.f4697f = C2334m.f4908l;
        if (abstractC2394l == null) {
            this.f4695d = null;
            this.f4700i = null;
        } else {
            this.f4695d = abstractC2394l.m2278p() ? abstractC2394l.m2267e() : null;
            this.f4700i = aVar != null ? aVar.mo1885a(cls) : null;
        }
        this.f4701j = this.f4695d != null;
    }
}
