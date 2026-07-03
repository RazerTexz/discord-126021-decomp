package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.q */
/* JADX INFO: compiled from: FakePureImplementationsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11623q {

    /* JADX INFO: renamed from: a */
    public static final C11623q f23516a;

    /* JADX INFO: renamed from: b */
    public static final HashMap<C11713b, C11713b> f23517b;

    static {
        C11623q c11623q = new C11623q();
        f23516a = c11623q;
        f23517b = new HashMap<>();
        c11623q.m9519b(C11291k.a.f22522S, c11623q.m9518a("java.util.ArrayList", "java.util.LinkedList"));
        c11623q.m9519b(C11291k.a.f22524U, c11623q.m9518a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        c11623q.m9519b(C11291k.a.f22525V, c11623q.m9518a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        c11623q.m9519b(new C11713b("java.util.function.Function"), c11623q.m9518a("java.util.function.UnaryOperator"));
        c11623q.m9519b(new C11713b("java.util.function.BiFunction"), c11623q.m9518a("java.util.function.BinaryOperator"));
    }

    /* JADX INFO: renamed from: a */
    public final List<C11713b> m9518a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new C11713b(str));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public final void m9519b(C11713b c11713b, List<C11713b> list) {
        HashMap<C11713b, C11713b> map = f23517b;
        for (Object obj : list) {
            map.put((C11713b) obj, c11713b);
        }
    }

    public final C11713b getPurelyImplementedInterface(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "classFqName");
        return f23517b.get(c11713b);
    }
}
