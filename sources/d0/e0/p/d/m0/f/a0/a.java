package d0.e0.p.d.m0.f.a0;

import d0.e0.p.d.m0.f.b;
import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.f.d;
import d0.e0.p.d.m0.f.i;
import d0.e0.p.d.m0.f.l;
import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.i.e;
import d0.e0.p.d.m0.i.g;
import d0.e0.p.d.m0.i.g$f;
import d0.e0.p.d.m0.i.w$b;
import java.util.List;

/* JADX INFO: compiled from: JvmProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final g$f<d, a$c> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g$f<i, a$c> f3384b;
    public static final g$f<i, Integer> c;
    public static final g$f<n, a$d> d;
    public static final g$f<n, Integer> e;
    public static final g$f<q, List<b>> f;
    public static final g$f<q, Boolean> g;
    public static final g$f<s, List<b>> h;
    public static final g$f<c, Integer> i;
    public static final g$f<c, List<n>> j;
    public static final g$f<c, Integer> k;
    public static final g$f<c, Integer> l;
    public static final g$f<l, Integer> m;
    public static final g$f<l, List<n>> n;

    static {
        d defaultInstance = d.getDefaultInstance();
        a$c defaultInstance2 = a$c.getDefaultInstance();
        a$c defaultInstance3 = a$c.getDefaultInstance();
        w$b w_b = w$b.t;
        a = g.newSingularGeneratedExtension(defaultInstance, defaultInstance2, defaultInstance3, null, 100, w_b, a$c.class);
        f3384b = g.newSingularGeneratedExtension(i.getDefaultInstance(), a$c.getDefaultInstance(), a$c.getDefaultInstance(), null, 100, w_b, a$c.class);
        i defaultInstance4 = i.getDefaultInstance();
        w$b w_b2 = w$b.n;
        c = g.newSingularGeneratedExtension(defaultInstance4, 0, null, null, 101, w_b2, Integer.class);
        d = g.newSingularGeneratedExtension(n.getDefaultInstance(), a$d.getDefaultInstance(), a$d.getDefaultInstance(), null, 100, w_b, a$d.class);
        e = g.newSingularGeneratedExtension(n.getDefaultInstance(), 0, null, null, 101, w_b2, Integer.class);
        f = g.newRepeatedGeneratedExtension(q.getDefaultInstance(), b.getDefaultInstance(), null, 100, w_b, false, b.class);
        g = g.newSingularGeneratedExtension(q.getDefaultInstance(), Boolean.FALSE, null, null, 101, w$b.q, Boolean.class);
        h = g.newRepeatedGeneratedExtension(s.getDefaultInstance(), b.getDefaultInstance(), null, 100, w_b, false, b.class);
        i = g.newSingularGeneratedExtension(c.getDefaultInstance(), 0, null, null, 101, w_b2, Integer.class);
        j = g.newRepeatedGeneratedExtension(c.getDefaultInstance(), n.getDefaultInstance(), null, 102, w_b, false, n.class);
        k = g.newSingularGeneratedExtension(c.getDefaultInstance(), 0, null, null, 103, w_b2, Integer.class);
        l = g.newSingularGeneratedExtension(c.getDefaultInstance(), 0, null, null, 104, w_b2, Integer.class);
        m = g.newSingularGeneratedExtension(l.getDefaultInstance(), 0, null, null, 101, w_b2, Integer.class);
        n = g.newRepeatedGeneratedExtension(l.getDefaultInstance(), n.getDefaultInstance(), null, 102, w_b, false, n.class);
    }

    public static void registerAllExtensions(e eVar) {
        eVar.add(a);
        eVar.add(f3384b);
        eVar.add(c);
        eVar.add(d);
        eVar.add(e);
        eVar.add(f);
        eVar.add(g);
        eVar.add(h);
        eVar.add(i);
        eVar.add(j);
        eVar.add(k);
        eVar.add(l);
        eVar.add(m);
        eVar.add(n);
    }
}
