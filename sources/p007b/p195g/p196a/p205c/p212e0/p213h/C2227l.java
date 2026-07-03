package p007b.p195g.p196a.p205c.p212e0.p213h;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.EnumC2366p;
import p007b.p195g.p196a.p205c.p210c0.C2196q;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.e0.h.l */
/* JADX INFO: compiled from: TypeNameIdResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2227l extends AbstractC2226k {

    /* JADX INFO: renamed from: c */
    public final AbstractC2394l<?> f4776c;

    /* JADX INFO: renamed from: d */
    public final ConcurrentHashMap<String, String> f4777d;

    /* JADX INFO: renamed from: e */
    public final Map<String, AbstractC2360j> f4778e;

    public C2227l(AbstractC2394l<?> abstractC2394l, AbstractC2360j abstractC2360j, ConcurrentHashMap<String, String> concurrentHashMap, HashMap<String, AbstractC2360j> map) {
        super(abstractC2360j, abstractC2394l._base._typeFactory);
        this.f4776c = abstractC2394l;
        this.f4777d = concurrentHashMap;
        this.f4778e = map;
        abstractC2394l.m2279q(EnumC2366p.ACCEPT_CASE_INSENSITIVE_VALUES);
    }

    /* JADX INFO: renamed from: d */
    public static String m1967d(Class<?> cls) {
        String name = cls.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf < 0 ? name : name.substring(iLastIndexOf + 1);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.InterfaceC2213e
    /* JADX INFO: renamed from: a */
    public String mo1946a(Object obj) {
        return m1968e(obj.getClass());
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.InterfaceC2213e
    /* JADX INFO: renamed from: c */
    public String mo1948c(Object obj, Class<?> cls) {
        return obj == null ? m1968e(cls) : m1968e(obj.getClass());
    }

    /* JADX INFO: renamed from: e */
    public String m1968e(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        String strM1967d = this.f4777d.get(name);
        if (strM1967d == null) {
            Class<?> cls2 = this.f4774a.m2160b(null, cls, C2335n.f4926l)._class;
            if (this.f4776c.m2278p()) {
                strM1967d = this.f4776c.m2267e().mo1759O(((C2196q) this.f4776c.m2277o(cls2)).f4736f);
            }
            if (strM1967d == null) {
                strM1967d = m1967d(cls2);
            }
            this.f4777d.put(name, strM1967d);
        }
        return strM1967d;
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", C2227l.class.getName(), this.f4778e);
    }
}
