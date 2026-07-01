package d0.e0.p.d.m0;

import d0.e0.p.d.m0.e.a.a0;
import d0.e0.p.d.m0.g.b;
import d0.t.n;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SpecialJvmAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<d0.e0.p.d.m0.g.a> f3208b;

    static {
        List listListOf = n.listOf((Object[]) new b[]{a0.a, a0.h, a0.i, a0.c, a0.d, a0.f});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(d0.e0.p.d.m0.g.a.topLevel((b) it.next()));
        }
        f3208b = linkedHashSet;
    }

    public final Set<d0.e0.p.d.m0.g.a> getSPECIAL_ANNOTATIONS() {
        return f3208b;
    }
}
