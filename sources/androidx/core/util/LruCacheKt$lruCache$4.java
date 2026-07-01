package androidx.core.util;

import android.util.LruCache;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    public final /* synthetic */ Function1<K, V> $create;
    public final /* synthetic */ int $maxSize;
    public final /* synthetic */ Function4<Boolean, K, V, V, Unit> $onEntryRemoved;
    public final /* synthetic */ Function2<K, V, Integer> $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LruCacheKt$lruCache$4(Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4, int i) {
        super(i);
        this.$sizeOf = function2;
        this.$create = function1;
        this.$onEntryRemoved = function4;
        this.$maxSize = i;
    }

    @Override // android.util.LruCache
    public V create(K key) {
        m.checkNotNullParameter(key, "key");
        return this.$create.invoke(key);
    }

    @Override // android.util.LruCache
    public void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        m.checkNotNullParameter(key, "key");
        m.checkNotNullParameter(oldValue, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(evicted), key, oldValue, newValue);
    }

    @Override // android.util.LruCache
    public int sizeOf(K key, V value) {
        m.checkNotNullParameter(key, "key");
        m.checkNotNullParameter(value, "value");
        return this.$sizeOf.invoke(key, value).intValue();
    }
}
