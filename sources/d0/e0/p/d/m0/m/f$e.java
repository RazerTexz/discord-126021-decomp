package d0.e0.p.d.m0.m;

import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$e<K, V> extends f$l<f$g<K, V>, V> implements b<K, V> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$e(f fVar, ConcurrentMap concurrentMap, f$a f_a) {
        super(fVar, concurrentMap, new g());
        if (fVar == null) {
            a(0);
            throw null;
        }
        if (concurrentMap != null) {
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "map";
        } else if (i != 2) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "computation";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
        if (i != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "computeIfAbsent";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public V computeIfAbsent(K k, Function0<? extends V> function0) {
        if (function0 != null) {
            return invoke(new f$g(k, function0));
        }
        a(2);
        throw null;
    }
}
