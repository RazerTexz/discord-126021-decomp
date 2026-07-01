package d0.e0.p.d;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: moduleByClassLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 {
    public static final ConcurrentMap<k0, WeakReference<d0.e0.p.d.m0.c.k1.a.k>> a = new ConcurrentHashMap();

    public static final d0.e0.p.d.m0.c.k1.a.k getOrCreateModule(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "$this$getOrCreateModule");
        ClassLoader safeClassLoader = d0.e0.p.d.m0.c.k1.b.b.getSafeClassLoader(cls);
        k0 k0Var = new k0(safeClassLoader);
        ConcurrentMap<k0, WeakReference<d0.e0.p.d.m0.c.k1.a.k>> concurrentMap = a;
        WeakReference<d0.e0.p.d.m0.c.k1.a.k> weakReference = concurrentMap.get(k0Var);
        if (weakReference != null) {
            d0.e0.p.d.m0.c.k1.a.k kVar = weakReference.get();
            if (kVar != null) {
                d0.z.d.m.checkNotNullExpressionValue(kVar, "it");
                return kVar;
            }
            concurrentMap.remove(k0Var, weakReference);
        }
        d0.e0.p.d.m0.c.k1.a.k kVarCreate = d0.e0.p.d.m0.c.k1.a.k.a.create(safeClassLoader);
        while (true) {
            try {
                ConcurrentMap<k0, WeakReference<d0.e0.p.d.m0.c.k1.a.k>> concurrentMap2 = a;
                WeakReference<d0.e0.p.d.m0.c.k1.a.k> weakReferencePutIfAbsent = concurrentMap2.putIfAbsent(k0Var, new WeakReference<>(kVarCreate));
                if (weakReferencePutIfAbsent == null) {
                    k0Var.setTemporaryStrongRef(null);
                    return kVarCreate;
                }
                d0.e0.p.d.m0.c.k1.a.k kVar2 = weakReferencePutIfAbsent.get();
                if (kVar2 != null) {
                    k0Var.setTemporaryStrongRef(null);
                    return kVar2;
                }
                concurrentMap2.remove(k0Var, weakReferencePutIfAbsent);
            } catch (Throwable th) {
                k0Var.setTemporaryStrongRef(null);
                throw th;
            }
        }
    }
}
