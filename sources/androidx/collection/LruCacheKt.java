package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int i, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        m.checkParameterIsNotNull(function2, "sizeOf");
        m.checkParameterIsNotNull(function1, "create");
        m.checkParameterIsNotNull(function4, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(function2, function1, function4, i, i);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, Function2 function2, Function1 function1, Function4 function4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function2 = LruCacheKt$lruCache$1.INSTANCE;
        }
        Function2 function3 = function2;
        if ((i2 & 4) != 0) {
            function1 = LruCacheKt$lruCache$2.INSTANCE;
        }
        Function1 function5 = function1;
        if ((i2 & 8) != 0) {
            function4 = LruCacheKt$lruCache$3.INSTANCE;
        }
        Function4 function6 = function4;
        m.checkParameterIsNotNull(function3, "sizeOf");
        m.checkParameterIsNotNull(function5, "create");
        m.checkParameterIsNotNull(function6, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(function3, function5, function6, i, i);
    }
}
