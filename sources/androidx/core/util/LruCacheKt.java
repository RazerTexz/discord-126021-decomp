package androidx.core.util;

import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$1 */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class C02641<K, V> extends AbstractC12240o implements Function2<K, V, Integer> {
        public static final C02641 INSTANCE = new C02641();

        public C02641() {
            super(2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(K k, V v) {
            C12238m.checkNotNullParameter(k, "$noName_0");
            C12238m.checkNotNullParameter(v, "$noName_1");
            return 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(Object obj, Object obj2) {
            return Integer.valueOf(invoke2(obj, obj2));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$2 */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class C02652<K, V> extends AbstractC12240o implements Function1<K, V> {
        public static final C02652 INSTANCE = new C02652();

        public C02652() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final V invoke(K k) {
            C12238m.checkNotNullParameter(k, "it");
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$3 */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class C02663<K, V> extends AbstractC12240o implements Function4<Boolean, K, V, V, Unit> {
        public static final C02663 INSTANCE = new C02663();

        public C02663() {
            super(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
            invoke(bool.booleanValue(), obj, obj2, obj3);
            return Unit.f27425a;
        }

        public final void invoke(boolean z2, K k, V v, V v2) {
            C12238m.checkNotNullParameter(k, "$noName_1");
            C12238m.checkNotNullParameter(v, "$noName_2");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$4 */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class C02674<K, V> extends LruCache<K, V> {
        public final /* synthetic */ Function1<K, V> $create;
        public final /* synthetic */ int $maxSize;
        public final /* synthetic */ Function4<Boolean, K, V, V, Unit> $onEntryRemoved;
        public final /* synthetic */ Function2<K, V, Integer> $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C02674(Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4, int i) {
            super(i);
            this.$sizeOf = function2;
            this.$create = function1;
            this.$onEntryRemoved = function4;
            this.$maxSize = i;
        }

        @Override // android.util.LruCache
        public V create(K key) {
            C12238m.checkNotNullParameter(key, "key");
            return this.$create.invoke(key);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
            C12238m.checkNotNullParameter(key, "key");
            C12238m.checkNotNullParameter(oldValue, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(evicted), key, oldValue, newValue);
        }

        @Override // android.util.LruCache
        public int sizeOf(K key, V value) {
            C12238m.checkNotNullParameter(key, "key");
            C12238m.checkNotNullParameter(value, "value");
            return this.$sizeOf.invoke(key, value).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int i, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        C12238m.checkNotNullParameter(function2, "sizeOf");
        C12238m.checkNotNullParameter(function1, "create");
        C12238m.checkNotNullParameter(function4, "onEntryRemoved");
        return new C02674(function2, function1, function4, i);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, Function2 function2, Function1 function1, Function4 function4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function2 = C02641.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            function1 = C02652.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            function4 = C02663.INSTANCE;
        }
        C12238m.checkNotNullParameter(function2, "sizeOf");
        C12238m.checkNotNullParameter(function1, "create");
        C12238m.checkNotNullParameter(function4, "onEntryRemoved");
        return new C02674(function2, function1, function4, i);
    }
}
