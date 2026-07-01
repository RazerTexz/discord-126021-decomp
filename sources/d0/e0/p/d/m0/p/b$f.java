package d0.e0.p.d.m0.p;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: DFS.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$f<N> implements b$e<N> {
    public final Set<N> a;

    public b$f() {
        this(new HashSet());
    }

    public boolean checkAndMarkVisited(N n) {
        return this.a.add(n);
    }

    public b$f(Set<N> set) {
        if (set == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
        }
        this.a = set;
    }
}
