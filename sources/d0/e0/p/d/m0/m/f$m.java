package d0.e0.p.d.m0.m;

import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$m<K, V> extends f$l<K, V> implements h<K, V> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$m(f fVar, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
        super(fVar, concurrentMap, function1);
        if (fVar == null) {
            a(0);
            throw null;
        }
        if (concurrentMap == null) {
            a(1);
            throw null;
        }
        if (function1 != null) {
        } else {
            a(2);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 3 ? 3 : 2];
        if (i == 1) {
            objArr[0] = "map";
        } else if (i == 2) {
            objArr[0] = "compute";
        } else if (i != 3) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
        }
        if (i != 3) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
        } else {
            objArr[1] = "invoke";
        }
        if (i != 3) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i == 3) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // d0.e0.p.d.m0.m.f$l, kotlin.jvm.functions.Function1
    public V invoke(K k) {
        V v = (V) super.invoke(k);
        if (v != null) {
            return v;
        }
        a(3);
        throw null;
    }
}
