package d0.e0.p.d.m0.m;

import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$d<K, V> extends f$e<K, V> implements a<K, V> {
    public f$d(f fVar, ConcurrentMap concurrentMap, f$a f_a) {
        super(fVar, concurrentMap, null);
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 3 ? 3 : 2];
        if (i == 1) {
            objArr[0] = "map";
        } else if (i == 2) {
            objArr[0] = "computation";
        } else if (i != 3) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
        }
        if (i != 3) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
        } else {
            objArr[1] = "computeIfAbsent";
        }
        if (i == 2) {
            objArr[2] = "computeIfAbsent";
        } else if (i != 3) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i == 3) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // d0.e0.p.d.m0.m.f$e
    public V computeIfAbsent(K k, Function0<? extends V> function0) {
        if (function0 == null) {
            a(2);
            throw null;
        }
        V v = (V) super.computeIfAbsent(k, function0);
        if (v != null) {
            return v;
        }
        a(3);
        throw null;
    }
}
