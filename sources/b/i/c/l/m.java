package b.i.c.l;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: CycleDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public class m {
    public final d<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<m> f1666b = new HashSet();
    public final Set<m> c = new HashSet();

    public m(d<?> dVar) {
        this.a = dVar;
    }

    public boolean a() {
        return this.c.isEmpty();
    }
}
