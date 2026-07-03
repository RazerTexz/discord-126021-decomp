package p507d0.p513e0.p514p.p515d.p517m0.p566m;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.m.o */
/* JADX INFO: compiled from: StorageManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11905o {
    <T> T compute(Function0<? extends T> function0);

    <K, V> InterfaceC11891a<K, V> createCacheWithNotNullValues();

    <K, V> InterfaceC11892b<K, V> createCacheWithNullableValues();

    <T> InterfaceC11900j<T> createLazyValue(Function0<? extends T> function0);

    <T> InterfaceC11900j<T> createLazyValueWithPostCompute(Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, Function1<? super T, Unit> function2);

    <K, V> InterfaceC11898h<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1);

    <K, V> InterfaceC11899i<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1);

    <T> InterfaceC11901k<T> createNullableLazyValue(Function0<? extends T> function0);

    <T> InterfaceC11900j<T> createRecursionTolerantLazyValue(Function0<? extends T> function0, T t);
}
