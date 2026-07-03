package androidx.collection;

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
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$1 */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class C01671<K, V> extends AbstractC12240o implements Function2<K, V, Integer> {
        public static final C01671 INSTANCE = new C01671();

        public C01671() {
            super(2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(K k, V v) {
            C12238m.checkParameterIsNotNull(k, "<anonymous parameter 0>");
            C12238m.checkParameterIsNotNull(v, "<anonymous parameter 1>");
            return 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(Object obj, Object obj2) {
            return Integer.valueOf(invoke2(obj, obj2));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$2 */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class C01682<K, V> extends AbstractC12240o implements Function1<K, V> {
        public static final C01682 INSTANCE = new C01682();

        public C01682() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final V invoke(K k) {
            C12238m.checkParameterIsNotNull(k, "it");
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$3 */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class C01693<K, V> extends AbstractC12240o implements Function4<Boolean, K, V, V, Unit> {
        public static final C01693 INSTANCE = new C01693();

        public C01693() {
            super(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
            invoke(bool.booleanValue(), obj, obj2, obj3);
            return Unit.f27425a;
        }

        public final void invoke(boolean z2, K k, V v, V v2) {
            C12238m.checkParameterIsNotNull(k, "<anonymous parameter 1>");
            C12238m.checkParameterIsNotNull(v, "<anonymous parameter 2>");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$4 */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class C01704<K, V> extends LruCache<K, V> {
        public final /* synthetic */ Function1 $create;
        public final /* synthetic */ int $maxSize;
        public final /* synthetic */ Function4 $onEntryRemoved;
        public final /* synthetic */ Function2 $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01704(Function2 function2, Function1 function1, Function4 function4, int i, int i2) {
            super(i2);
            this.$sizeOf = function2;
            this.$create = function1;
            this.$onEntryRemoved = function4;
            this.$maxSize = i;
        }

        @Override // androidx.collection.LruCache
        public V create(K key) {
            C12238m.checkParameterIsNotNull(key, "key");
            return (V) this.$create.invoke(key);
        }

        @Override // androidx.collection.LruCache
        public void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
            C12238m.checkParameterIsNotNull(key, "key");
            C12238m.checkParameterIsNotNull(oldValue, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(evicted), key, oldValue, newValue);
        }

        @Override // androidx.collection.LruCache
        public int sizeOf(K key, V value) {
            C12238m.checkParameterIsNotNull(key, "key");
            C12238m.checkParameterIsNotNull(value, "value");
            return ((Number) this.$sizeOf.invoke(key, value)).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int i, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        C12238m.checkParameterIsNotNull(function2, "sizeOf");
        C12238m.checkParameterIsNotNull(function1, "create");
        C12238m.checkParameterIsNotNull(function4, "onEntryRemoved");
        return new C01704(function2, function1, function4, i, i);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, Function2 function2, Function1 function1, Function4 function4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function2 = C01671.INSTANCE;
        }
        Function2 function3 = function2;
        if ((i2 & 4) != 0) {
            function1 = C01682.INSTANCE;
        }
        Function1 function5 = function1;
        if ((i2 & 8) != 0) {
            function4 = C01693.INSTANCE;
        }
        Function4 function6 = function4;
        C12238m.checkParameterIsNotNull(function3, "sizeOf");
        C12238m.checkParameterIsNotNull(function5, "create");
        C12238m.checkParameterIsNotNull(function6, "onEntryRemoved");
        return new C01704(function3, function5, function6, i, i);
    }
}
