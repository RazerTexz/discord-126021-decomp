package d0.e0.p.d.m0.p;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DFS.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
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

    public static <N, R> R dfs(Collection<N> collection, b$c<N> b_c, b$e<N> b_e, b$d<N, R> b_d) {
        if (collection == null) {
            a(0);
            throw null;
        }
        if (b_c == null) {
            a(1);
            throw null;
        }
        if (b_e == null) {
            a(2);
            throw null;
        }
        if (b_d == null) {
            a(3);
            throw null;
        }
        Iterator<N> it = collection.iterator();
        while (it.hasNext()) {
            doDfs(it.next(), b_c, b_e, b_d);
        }
        return b_d.result();
    }

    public static <N> void doDfs(N n, b$c<N> b_c, b$e<N> b_e, b$d<N, ?> b_d) {
        if (n == null) {
            a(22);
            throw null;
        }
        if (b_c == null) {
            a(23);
            throw null;
        }
        if (b_e == null) {
            a(24);
            throw null;
        }
        if (b_d == null) {
            a(25);
            throw null;
        }
        b$f b_f = (b$f) b_e;
        if (b_f.checkAndMarkVisited(n) && b_d.beforeChildren(n)) {
            Iterator<? extends N> it = b_c.getNeighbors(n).iterator();
            while (it.hasNext()) {
                doDfs(it.next(), b_c, b_f, b_d);
            }
            b_d.afterChildren(n);
        }
    }

    public static <N> Boolean ifAny(Collection<N> collection, b$c<N> b_c, Function1<N, Boolean> function1) {
        if (collection == null) {
            a(7);
            throw null;
        }
        if (b_c == null) {
            a(8);
            throw null;
        }
        if (function1 != null) {
            return (Boolean) dfs(collection, b_c, new b$a(function1, new boolean[1]));
        }
        a(9);
        throw null;
    }

    public static <N, R> R dfs(Collection<N> collection, b$c<N> b_c, b$d<N, R> b_d) {
        if (collection == null) {
            a(4);
            throw null;
        }
        if (b_c == null) {
            a(5);
            throw null;
        }
        if (b_d != null) {
            return (R) dfs(collection, b_c, new b$f(), b_d);
        }
        a(6);
        throw null;
    }
}
