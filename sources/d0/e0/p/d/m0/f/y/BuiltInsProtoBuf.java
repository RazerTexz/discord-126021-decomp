package d0.e0.p.d.m0.f.y;

import d0.e0.p.d.m0.f.b;
import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.f.d;
import d0.e0.p.d.m0.f.g;
import d0.e0.p.d.m0.f.i;
import d0.e0.p.d.m0.f.l;
import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.u;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.WireFormat;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.y.b, reason: use source file name */
/* JADX INFO: compiled from: BuiltInsProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInsProtoBuf {
    public static final GeneratedMessageLite.f<l, Integer> a = GeneratedMessageLite.newSingularGeneratedExtension(l.getDefaultInstance(), 0, null, null, Opcodes.DCMPL, WireFormat.b.n, Integer.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageLite.f<c, List<d0.e0.p.d.m0.f.b>> f3410b;
    public static final GeneratedMessageLite.f<d, List<d0.e0.p.d.m0.f.b>> c;
    public static final GeneratedMessageLite.f<i, List<d0.e0.p.d.m0.f.b>> d;
    public static final GeneratedMessageLite.f<n, List<d0.e0.p.d.m0.f.b>> e;
    public static final GeneratedMessageLite.f<n, List<d0.e0.p.d.m0.f.b>> f;
    public static final GeneratedMessageLite.f<n, List<d0.e0.p.d.m0.f.b>> g;
    public static final GeneratedMessageLite.f<n, b.C0393b.c> h;
    public static final GeneratedMessageLite.f<g, List<d0.e0.p.d.m0.f.b>> i;
    public static final GeneratedMessageLite.f<u, List<d0.e0.p.d.m0.f.b>> j;
    public static final GeneratedMessageLite.f<q, List<d0.e0.p.d.m0.f.b>> k;
    public static final GeneratedMessageLite.f<s, List<d0.e0.p.d.m0.f.b>> l;

    static {
        c defaultInstance = c.getDefaultInstance();
        d0.e0.p.d.m0.f.b defaultInstance2 = d0.e0.p.d.m0.f.b.getDefaultInstance();
        WireFormat.b bVar = WireFormat.b.t;
        f3410b = GeneratedMessageLite.newRepeatedGeneratedExtension(defaultInstance, defaultInstance2, null, 150, bVar, false, d0.e0.p.d.m0.f.b.class);
        c = GeneratedMessageLite.newRepeatedGeneratedExtension(d.getDefaultInstance(), d0.e0.p.d.m0.f.b.getDefaultInstance(), null, 150, bVar, false, d0.e0.p.d.m0.f.b.class);
        d = GeneratedMessageLite.newRepeatedGeneratedExtension(i.getDefaultInstance(), d0.e0.p.d.m0.f.b.getDefaultInstance(), null, 150, bVar, false, d0.e0.p.d.m0.f.b.class);
        e = GeneratedMessageLite.newRepeatedGeneratedExtension(n.getDefaultInstance(), d0.e0.p.d.m0.f.b.getDefaultInstance(), null, 150, bVar, false, d0.e0.p.d.m0.f.b.class);
        f = GeneratedMessageLite.newRepeatedGeneratedExtension(n.getDefaultInstance(), d0.e0.p.d.m0.f.b.getDefaultInstance(), null, Opcodes.DCMPG, bVar, false, d0.e0.p.d.m0.f.b.class);
        g = GeneratedMessageLite.newRepeatedGeneratedExtension(n.getDefaultInstance(), d0.e0.p.d.m0.f.b.getDefaultInstance(), null, 153, bVar, false, d0.e0.p.d.m0.f.b.class);
        h = GeneratedMessageLite.newSingularGeneratedExtension(n.getDefaultInstance(), b.C0393b.c.getDefaultInstance(), b.C0393b.c.getDefaultInstance(), null, Opcodes.DCMPL, bVar, b.C0393b.c.class);
        i = GeneratedMessageLite.newRepeatedGeneratedExtension(g.getDefaultInstance(), d0.e0.p.d.m0.f.b.getDefaultInstance(), null, 150, bVar, false, d0.e0.p.d.m0.f.b.class);
        j = GeneratedMessageLite.newRepeatedGeneratedExtension(u.getDefaultInstance(), d0.e0.p.d.m0.f.b.getDefaultInstance(), null, 150, bVar, false, d0.e0.p.d.m0.f.b.class);
        k = GeneratedMessageLite.newRepeatedGeneratedExtension(q.getDefaultInstance(), d0.e0.p.d.m0.f.b.getDefaultInstance(), null, 150, bVar, false, d0.e0.p.d.m0.f.b.class);
        l = GeneratedMessageLite.newRepeatedGeneratedExtension(s.getDefaultInstance(), d0.e0.p.d.m0.f.b.getDefaultInstance(), null, 150, bVar, false, d0.e0.p.d.m0.f.b.class);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(a);
        extensionRegistryLite.add(f3410b);
        extensionRegistryLite.add(c);
        extensionRegistryLite.add(d);
        extensionRegistryLite.add(e);
        extensionRegistryLite.add(f);
        extensionRegistryLite.add(g);
        extensionRegistryLite.add(h);
        extensionRegistryLite.add(i);
        extensionRegistryLite.add(j);
        extensionRegistryLite.add(k);
        extensionRegistryLite.add(l);
    }
}
