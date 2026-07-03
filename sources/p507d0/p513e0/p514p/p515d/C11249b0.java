package p507d0.p513e0.p514p.p515d;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.C11418k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.b0 */
/* JADX INFO: compiled from: moduleByClassLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11249b0 {

    /* JADX INFO: renamed from: a */
    public static final ConcurrentMap<C11267k0, WeakReference<C11418k>> f22321a = new ConcurrentHashMap();

    public static final C11418k getOrCreateModule(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "$this$getOrCreateModule");
        ClassLoader safeClassLoader = C11423b.getSafeClassLoader(cls);
        C11267k0 c11267k0 = new C11267k0(safeClassLoader);
        ConcurrentMap<C11267k0, WeakReference<C11418k>> concurrentMap = f22321a;
        WeakReference<C11418k> weakReference = concurrentMap.get(c11267k0);
        if (weakReference != null) {
            C11418k c11418k = weakReference.get();
            if (c11418k != null) {
                C12238m.checkNotNullExpressionValue(c11418k, "it");
                return c11418k;
            }
            concurrentMap.remove(c11267k0, weakReference);
        }
        C11418k c11418kCreate = C11418k.f23022a.create(safeClassLoader);
        while (true) {
            try {
                ConcurrentMap<C11267k0, WeakReference<C11418k>> concurrentMap2 = f22321a;
                WeakReference<C11418k> weakReferencePutIfAbsent = concurrentMap2.putIfAbsent(c11267k0, new WeakReference<>(c11418kCreate));
                if (weakReferencePutIfAbsent == null) {
                    c11267k0.setTemporaryStrongRef(null);
                    return c11418kCreate;
                }
                C11418k c11418k2 = weakReferencePutIfAbsent.get();
                if (c11418k2 != null) {
                    c11267k0.setTemporaryStrongRef(null);
                    return c11418k2;
                }
                concurrentMap2.remove(c11267k0, weakReferencePutIfAbsent);
            } catch (Throwable th) {
                c11267k0.setTemporaryStrongRef(null);
                throw th;
            }
        }
    }
}
