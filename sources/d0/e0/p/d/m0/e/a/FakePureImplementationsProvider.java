package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.g.FqName;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.q, reason: use source file name */
/* JADX INFO: compiled from: FakePureImplementationsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<FqName, FqName> f3356b;

    static {
        FakePureImplementationsProvider fakePureImplementationsProvider = new FakePureImplementationsProvider();
        a = fakePureImplementationsProvider;
        f3356b = new HashMap<>();
        fakePureImplementationsProvider.b(StandardNames.a.S, fakePureImplementationsProvider.a("java.util.ArrayList", "java.util.LinkedList"));
        fakePureImplementationsProvider.b(StandardNames.a.U, fakePureImplementationsProvider.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        fakePureImplementationsProvider.b(StandardNames.a.V, fakePureImplementationsProvider.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        fakePureImplementationsProvider.b(new FqName("java.util.function.Function"), fakePureImplementationsProvider.a("java.util.function.UnaryOperator"));
        fakePureImplementationsProvider.b(new FqName("java.util.function.BiFunction"), fakePureImplementationsProvider.a("java.util.function.BinaryOperator"));
    }

    public final List<FqName> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new FqName(str));
        }
        return arrayList;
    }

    public final void b(FqName fqName, List<FqName> list) {
        HashMap<FqName, FqName> map = f3356b;
        for (Object obj : list) {
            map.put((FqName) obj, fqName);
        }
    }

    public final FqName getPurelyImplementedInterface(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "classFqName");
        return f3356b.get(fqName);
    }
}
