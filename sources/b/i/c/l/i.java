package b.i.c.l;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: ComponentRuntime.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements b.i.c.t.a {
    public final Set a;

    public i(Set set) {
        this.a = set;
    }

    @Override // b.i.c.t.a
    public Object get() {
        Set set = this.a;
        int i = k.a;
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((r) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
