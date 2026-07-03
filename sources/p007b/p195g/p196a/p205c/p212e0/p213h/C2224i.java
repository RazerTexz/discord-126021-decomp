package p007b.p195g.p196a.p205c.p212e0.p213h;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p210c0.C2177c;
import p007b.p195g.p196a.p205c.p210c0.C2179d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2212d;
import p007b.p195g.p196a.p205c.p212e0.C2210b;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.e0.h.i */
/* JADX INFO: compiled from: StdSubtypeResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2224i extends AbstractC2212d implements Serializable {
    private static final long serialVersionUID = 1;
    public LinkedHashSet<C2210b> _registeredSubtypes;

    @Override // p007b.p195g.p196a.p205c.p212e0.AbstractC2212d
    /* JADX INFO: renamed from: a */
    public Collection<C2210b> mo1945a(AbstractC2394l<?> abstractC2394l, AbstractC2188i abstractC2188i, AbstractC2360j abstractC2360j) {
        List<C2210b> listMo1758N;
        AbstractC2165b abstractC2165bM2267e = abstractC2394l.m2267e();
        Class<?> clsMo1820d = abstractC2360j == null ? abstractC2188i.mo1820d() : abstractC2360j._class;
        HashMap<C2210b, C2210b> map = new HashMap<>();
        LinkedHashSet<C2210b> linkedHashSet = this._registeredSubtypes;
        if (linkedHashSet != null) {
            for (C2210b c2210b : linkedHashSet) {
                if (clsMo1820d.isAssignableFrom(c2210b._class)) {
                    m1965b(C2179d.m1879h(abstractC2394l, c2210b._class), c2210b, abstractC2394l, abstractC2165bM2267e, map);
                }
            }
        }
        if (abstractC2188i != null && (listMo1758N = abstractC2165bM2267e.mo1758N(abstractC2188i)) != null) {
            for (C2210b c2210b2 : listMo1758N) {
                m1965b(C2179d.m1879h(abstractC2394l, c2210b2._class), c2210b2, abstractC2394l, abstractC2165bM2267e, map);
            }
        }
        m1965b(C2179d.m1879h(abstractC2394l, clsMo1820d), new C2210b(clsMo1820d, null), abstractC2394l, abstractC2165bM2267e, map);
        return new ArrayList(map.values());
    }

    /* JADX INFO: renamed from: b */
    public void m1965b(C2177c c2177c, C2210b c2210b, AbstractC2394l<?> abstractC2394l, AbstractC2165b abstractC2165b, HashMap<C2210b, C2210b> map) {
        String strMo1759O;
        if (!c2210b.m1944a() && (strMo1759O = abstractC2165b.mo1759O(c2177c)) != null) {
            c2210b = new C2210b(c2210b._class, strMo1759O);
        }
        C2210b c2210b2 = new C2210b(c2210b._class, null);
        if (map.containsKey(c2210b2)) {
            if (!c2210b.m1944a() || map.get(c2210b2).m1944a()) {
                return;
            }
            map.put(c2210b2, c2210b);
            return;
        }
        map.put(c2210b2, c2210b);
        List<C2210b> listMo1758N = abstractC2165b.mo1758N(c2177c);
        if (listMo1758N == null || listMo1758N.isEmpty()) {
            return;
        }
        for (C2210b c2210b3 : listMo1758N) {
            m1965b(C2179d.m1879h(abstractC2394l, c2210b3._class), c2210b3, abstractC2394l, abstractC2165b, map);
        }
    }
}
