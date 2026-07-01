package androidx.core.util;

import android.util.LruCache;
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
        m.checkNotNullParameter(function2, "sizeOf");
        m.checkNotNullParameter(function1, "create");
        m.checkNotNullParameter(function4, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(function2, function1, function4, i);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, Function2 function2, Function1 function1, Function4 function4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function2 = LruCacheKt$lruCache$1.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            function1 = LruCacheKt$lruCache$2.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            function4 = LruCacheKt$lruCache$3.INSTANCE;
        }
        m.checkNotNullParameter(function2, "sizeOf");
        m.checkNotNullParameter(function1, "create");
        m.checkNotNullParameter(function4, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(function2, function1, function4, i);
    }
}
