package d0.e0.p.d.m0.e.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: FakePureImplementationsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public static final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.g.b> f3356b;

    static {
        q qVar = new q();
        a = qVar;
        f3356b = new HashMap<>();
        qVar.b(d0.e0.p.d.m0.b.k$a.S, qVar.a("java.util.ArrayList", "java.util.LinkedList"));
        qVar.b(d0.e0.p.d.m0.b.k$a.U, qVar.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        qVar.b(d0.e0.p.d.m0.b.k$a.V, qVar.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        qVar.b(new d0.e0.p.d.m0.g.b("java.util.function.Function"), qVar.a("java.util.function.UnaryOperator"));
        qVar.b(new d0.e0.p.d.m0.g.b("java.util.function.BiFunction"), qVar.a("java.util.function.BinaryOperator"));
    }

    public final List<d0.e0.p.d.m0.g.b> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new d0.e0.p.d.m0.g.b(str));
        }
        return arrayList;
    }

    public final void b(d0.e0.p.d.m0.g.b bVar, List<d0.e0.p.d.m0.g.b> list) {
        HashMap<d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.g.b> map = f3356b;
        for (Object obj : list) {
            map.put((d0.e0.p.d.m0.g.b) obj, bVar);
        }
    }

    public final d0.e0.p.d.m0.g.b getPurelyImplementedInterface(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "classFqName");
        return f3356b.get(bVar);
    }
}
