package d0.e0.p.d;

import d0.e0.p.d.m0.c.k1.a.RuntimeModuleData;
import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: renamed from: d0.e0.p.d.b0, reason: use source file name */
/* JADX INFO: compiled from: moduleByClassLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class moduleByClassLoader {
    public static final ConcurrentMap<moduleByClassLoader2, WeakReference<RuntimeModuleData>> a = new ConcurrentHashMap();

    public static final RuntimeModuleData getOrCreateModule(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "$this$getOrCreateModule");
        ClassLoader safeClassLoader = reflectClassUtil.getSafeClassLoader(cls);
        moduleByClassLoader2 modulebyclassloader2 = new moduleByClassLoader2(safeClassLoader);
        ConcurrentMap<moduleByClassLoader2, WeakReference<RuntimeModuleData>> concurrentMap = a;
        WeakReference<RuntimeModuleData> weakReference = concurrentMap.get(modulebyclassloader2);
        if (weakReference != null) {
            RuntimeModuleData runtimeModuleData = weakReference.get();
            if (runtimeModuleData != null) {
                Intrinsics3.checkNotNullExpressionValue(runtimeModuleData, "it");
                return runtimeModuleData;
            }
            concurrentMap.remove(modulebyclassloader2, weakReference);
        }
        RuntimeModuleData runtimeModuleDataCreate = RuntimeModuleData.a.create(safeClassLoader);
        while (true) {
            try {
                ConcurrentMap<moduleByClassLoader2, WeakReference<RuntimeModuleData>> concurrentMap2 = a;
                WeakReference<RuntimeModuleData> weakReferencePutIfAbsent = concurrentMap2.putIfAbsent(modulebyclassloader2, new WeakReference<>(runtimeModuleDataCreate));
                if (weakReferencePutIfAbsent == null) {
                    modulebyclassloader2.setTemporaryStrongRef(null);
                    return runtimeModuleDataCreate;
                }
                RuntimeModuleData runtimeModuleData2 = weakReferencePutIfAbsent.get();
                if (runtimeModuleData2 != null) {
                    modulebyclassloader2.setTemporaryStrongRef(null);
                    return runtimeModuleData2;
                }
                concurrentMap2.remove(modulebyclassloader2, weakReferencePutIfAbsent);
            } catch (Throwable th) {
                modulebyclassloader2.setTemporaryStrongRef(null);
                throw th;
            }
        }
    }
}
