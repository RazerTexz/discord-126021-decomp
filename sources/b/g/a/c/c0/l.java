package b.g.a.c.c0;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: AnnotatedMethodMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements Iterable<j> {
    public Map<y, j> j;

    public l() {
    }

    @Override // java.lang.Iterable
    public Iterator<j> iterator() {
        Map<y, j> map = this.j;
        return map == null ? Collections.emptyIterator() : map.values().iterator();
    }

    public l(Map<y, j> map) {
        this.j = map;
    }
}
