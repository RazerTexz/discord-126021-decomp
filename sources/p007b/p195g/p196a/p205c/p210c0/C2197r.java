package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2362l;
import p007b.p195g.p196a.p205c.p218h0.C2322a;
import p007b.p195g.p196a.p205c.p218h0.C2332k;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.c0.r */
/* JADX INFO: compiled from: BasicClassIntrospector.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2197r extends AbstractC2199t implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final Class<?> f4741j = AbstractC2362l.class;

    /* JADX INFO: renamed from: k */
    public static final C2196q f4742k;

    /* JADX INFO: renamed from: l */
    public static final C2196q f4743l;

    /* JADX INFO: renamed from: m */
    public static final C2196q f4744m;

    /* JADX INFO: renamed from: n */
    public static final C2196q f4745n;

    /* JADX INFO: renamed from: o */
    public static final C2196q f4746o;
    private static final long serialVersionUID = 2;

    static {
        C2332k c2332kM2138L = C2332k.m2138L(String.class);
        Class<?> cls = C2179d.f4692a;
        f4742k = C2196q.m1918e(null, c2332kM2138L, new C2177c(String.class));
        Class cls2 = Boolean.TYPE;
        f4743l = C2196q.m1918e(null, C2332k.m2138L(cls2), new C2177c(cls2));
        Class cls3 = Integer.TYPE;
        f4744m = C2196q.m1918e(null, C2332k.m2138L(cls3), new C2177c(cls3));
        Class cls4 = Long.TYPE;
        f4745n = C2196q.m1918e(null, C2332k.m2138L(cls4), new C2177c(cls4));
        f4746o = C2196q.m1918e(null, C2332k.m2138L(Object.class), new C2177c(Object.class));
    }

    /* JADX INFO: renamed from: a */
    public C2196q m1920a(AbstractC2394l<?> abstractC2394l, AbstractC2360j abstractC2360j) {
        Class<?> cls = abstractC2360j._class;
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return f4744m;
            }
            if (cls == Long.TYPE) {
                return f4745n;
            }
            if (cls == Boolean.TYPE) {
                return f4743l;
            }
            return null;
        }
        if (!C2342d.m2186r(cls)) {
            if (!f4741j.isAssignableFrom(cls)) {
                return null;
            }
            Class<?> cls2 = C2179d.f4692a;
            return C2196q.m1918e(abstractC2394l, abstractC2360j, new C2177c(cls));
        }
        if (cls == Object.class) {
            return f4746o;
        }
        if (cls == String.class) {
            return f4742k;
        }
        if (cls == Integer.class) {
            return f4744m;
        }
        if (cls == Long.class) {
            return f4745n;
        }
        if (cls == Boolean.class) {
            return f4743l;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public C2177c m1921b(AbstractC2394l<?> abstractC2394l, AbstractC2360j abstractC2360j, AbstractC2199t.a aVar) {
        Class<?> cls = C2179d.f4692a;
        Objects.requireNonNull(abstractC2360j);
        if ((abstractC2360j instanceof C2322a) && C2179d.m1880i(abstractC2394l, abstractC2360j._class)) {
            return new C2177c(abstractC2360j._class);
        }
        C2179d c2179d = new C2179d(abstractC2394l, abstractC2360j, aVar);
        ArrayList arrayList = new ArrayList(8);
        Class<?> cls2 = abstractC2360j._class;
        if (!(cls2 == Object.class)) {
            if (cls2.isInterface()) {
                C2179d.m1876d(abstractC2360j, arrayList, false);
            } else {
                C2179d.m1877e(abstractC2360j, arrayList, false);
            }
        }
        return new C2177c(abstractC2360j, c2179d.f4699h, arrayList, c2179d.f4700i, c2179d.m1884g(arrayList), c2179d.f4697f, c2179d.f4695d, aVar, abstractC2394l._base._typeFactory, c2179d.f4701j);
    }
}
