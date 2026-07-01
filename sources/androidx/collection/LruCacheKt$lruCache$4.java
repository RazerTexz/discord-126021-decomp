package androidx.collection;

import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    public final /* synthetic */ Function1 $create;
    public final /* synthetic */ int $maxSize;
    public final /* synthetic */ Function4 $onEntryRemoved;
    public final /* synthetic */ Function2 $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(Function2 function2, Function1 function1, Function4 function4, int i, int i2) {
        super(i2);
        this.$sizeOf = function2;
        this.$create = function1;
        this.$onEntryRemoved = function4;
        this.$maxSize = i;
    }

    @Override // androidx.collection.LruCache
    public V create(K key) {
        m.checkParameterIsNotNull(key, "key");
        return (V) this.$create.invoke(key);
    }

    @Override // androidx.collection.LruCache
    public void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        m.checkParameterIsNotNull(key, "key");
        m.checkParameterIsNotNull(oldValue, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(evicted), key, oldValue, newValue);
    }

    @Override // androidx.collection.LruCache
    public int sizeOf(K key, V value) {
        m.checkParameterIsNotNull(key, "key");
        m.checkParameterIsNotNull(value, "value");
        return ((Number) this.$sizeOf.invoke(key, value)).intValue();
    }
}
