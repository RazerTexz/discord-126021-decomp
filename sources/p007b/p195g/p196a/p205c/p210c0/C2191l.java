package p007b.p195g.p196a.p205c.p210c0;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: b.g.a.c.c0.l */
/* JADX INFO: compiled from: AnnotatedMethodMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2191l implements Iterable<C2189j> {

    /* JADX INFO: renamed from: j */
    public Map<C2204y, C2189j> f4724j;

    public C2191l() {
    }

    @Override // java.lang.Iterable
    public Iterator<C2189j> iterator() {
        Map<C2204y, C2189j> map = this.f4724j;
        return map == null ? Collections.emptyIterator() : map.values().iterator();
    }

    public C2191l(Map<C2204y, C2189j> map) {
        this.f4724j = map;
    }
}
