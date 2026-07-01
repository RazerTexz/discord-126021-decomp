package d0.e0.p.d.m0.p;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.b, reason: use source file name */
/* JADX INFO: compiled from: DFS.java */
/* JADX INFO: loaded from: classes3.dex */
public class DFS {

    /* JADX INFO: Add missing generic type declarations: [N] */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.b$a */
    /* JADX INFO: compiled from: DFS.java */
    public static class a<N> extends b<N, Boolean> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f3561b;

        public a(Function1 function1, boolean[] zArr) {
            this.a = function1;
            this.f3561b = zArr;
        }

        @Override // d0.e0.p.d.m0.p.DFS.d
        public boolean beforeChildren(N n) {
            if (((Boolean) this.a.invoke(n)).booleanValue()) {
                this.f3561b[0] = true;
            }
            return !this.f3561b[0];
        }

        @Override // d0.e0.p.d.m0.p.DFS.d
        public Boolean result() {
            return Boolean.valueOf(this.f3561b[0]);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.b$b */
    /* JADX INFO: compiled from: DFS.java */
    public static abstract class b<N, R> implements d<N, R> {
        @Override // d0.e0.p.d.m0.p.DFS.d
        public void afterChildren(N n) {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.b$c */
    /* JADX INFO: compiled from: DFS.java */
    public interface c<N> {
        Iterable<? extends N> getNeighbors(N n);
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.b$d */
    /* JADX INFO: compiled from: DFS.java */
    public interface d<N, R> {
        void afterChildren(N n);

        boolean beforeChildren(N n);

        R result();
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.b$e */
    /* JADX INFO: compiled from: DFS.java */
    public interface e<N> {
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.b$f */
    /* JADX INFO: compiled from: DFS.java */
    public static class f<N> implements e<N> {
        public final Set<N> a;

        public f() {
            this(new HashSet());
        }

        public boolean checkAndMarkVisited(N n) {
            return this.a.add(n);
        }

        public f(Set<N> set) {
            if (set == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
            }
            this.a = set;
        }
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case 19:
            case 24:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case 25:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <N, R> R dfs(Collection<N> collection, c<N> cVar, e<N> eVar, d<N, R> dVar) {
        if (collection == null) {
            a(0);
            throw null;
        }
        if (cVar == null) {
            a(1);
            throw null;
        }
        if (eVar == null) {
            a(2);
            throw null;
        }
        if (dVar == null) {
            a(3);
            throw null;
        }
        Iterator<N> it = collection.iterator();
        while (it.hasNext()) {
            doDfs(it.next(), cVar, eVar, dVar);
        }
        return dVar.result();
    }

    public static <N> void doDfs(N n, c<N> cVar, e<N> eVar, d<N, ?> dVar) {
        if (n == null) {
            a(22);
            throw null;
        }
        if (cVar == null) {
            a(23);
            throw null;
        }
        if (eVar == null) {
            a(24);
            throw null;
        }
        if (dVar == null) {
            a(25);
            throw null;
        }
        f fVar = (f) eVar;
        if (fVar.checkAndMarkVisited(n) && dVar.beforeChildren(n)) {
            Iterator<? extends N> it = cVar.getNeighbors(n).iterator();
            while (it.hasNext()) {
                doDfs(it.next(), cVar, fVar, dVar);
            }
            dVar.afterChildren(n);
        }
    }

    public static <N> Boolean ifAny(Collection<N> collection, c<N> cVar, Function1<N, Boolean> function1) {
        if (collection == null) {
            a(7);
            throw null;
        }
        if (cVar == null) {
            a(8);
            throw null;
        }
        if (function1 != null) {
            return (Boolean) dfs(collection, cVar, new a(function1, new boolean[1]));
        }
        a(9);
        throw null;
    }

    public static <N, R> R dfs(Collection<N> collection, c<N> cVar, d<N, R> dVar) {
        if (collection == null) {
            a(4);
            throw null;
        }
        if (cVar == null) {
            a(5);
            throw null;
        }
        if (dVar != null) {
            return (R) dfs(collection, cVar, new f(), dVar);
        }
        a(6);
        throw null;
    }
}
