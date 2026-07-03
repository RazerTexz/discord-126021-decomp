package p507d0.p513e0.p514p.p515d.p517m0;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11486a0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p580t.C12147n;

/* JADX INFO: renamed from: d0.e0.p.d.m0.a */
/* JADX INFO: compiled from: SpecialJvmAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11280a {

    /* JADX INFO: renamed from: a */
    public static final C11280a f22449a = new C11280a();

    /* JADX INFO: renamed from: b */
    public static final Set<C11712a> f22450b;

    static {
        List listListOf = C12147n.listOf((Object[]) new C11713b[]{C11486a0.f23147a, C11486a0.f23154h, C11486a0.f23155i, C11486a0.f23149c, C11486a0.f23150d, C11486a0.f23152f});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(C11712a.topLevel((C11713b) it.next()));
        }
        f22450b = linkedHashSet;
    }

    public final Set<C11712a> getSPECIAL_ANNOTATIONS() {
        return f22450b;
    }
}
