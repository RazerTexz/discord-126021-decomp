package d0.e0.p.d.m0.m;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StorageManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface o {
    <T> T compute(Function0<? extends T> function0);

    <K, V> a<K, V> createCacheWithNotNullValues();

    <K, V> b<K, V> createCacheWithNullableValues();

    <T> j<T> createLazyValue(Function0<? extends T> function0);

    <T> j<T> createLazyValueWithPostCompute(Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, Function1<? super T, Unit> function2);

    <K, V> h<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1);

    <K, V> i<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1);

    <T> k<T> createNullableLazyValue(Function0<? extends T> function0);

    <T> j<T> createRecursionTolerantLazyValue(Function0<? extends T> function0, T t);
}
