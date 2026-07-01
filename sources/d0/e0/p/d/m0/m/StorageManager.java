package d0.e0.p.d.m0.m;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.m.o, reason: use source file name */
/* JADX INFO: compiled from: StorageManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface StorageManager {
    <T> T compute(Function0<? extends T> function0);

    <K, V> storage<K, V> createCacheWithNotNullValues();

    <K, V> storage2<K, V> createCacheWithNullableValues();

    <T> storage5<T> createLazyValue(Function0<? extends T> function0);

    <T> storage5<T> createLazyValueWithPostCompute(Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, Function1<? super T, Unit> function2);

    <K, V> storage3<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1);

    <K, V> storage4<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1);

    <T> storage6<T> createNullableLazyValue(Function0<? extends T> function0);

    <T> storage5<T> createRecursionTolerantLazyValue(Function0<? extends T> function0, T t);
}
