package com.discord.utilities.cache;

import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import d0.g0.Strings4;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.utilities.cache.SharedPreferenceExtensionsKt, reason: use source file name */
/* JADX INFO: compiled from: SharedPreferenceExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SharedPreferenceExtensions {

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* JADX INFO: renamed from: com.discord.utilities.cache.SharedPreferenceExtensionsKt$putStringEntrySetAsMap$1, reason: invalid class name */
    /* JADX INFO: compiled from: SharedPreferenceExtensions.kt */
    public static final class AnonymousClass1<V> extends Lambda implements Function1<V, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(V v) {
            return String.valueOf(v);
        }
    }

    public static final String getString(SharedPreferences sharedPreferences, String str) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "$this$getString");
        Intrinsics3.checkNotNullParameter(str, "key");
        return sharedPreferences.getString(str, null);
    }

    public static final <K, V> Map<K, V> getStringEntrySetAsMap(SharedPreferences sharedPreferences, String str, String str2, Function2<? super String, ? super String, ? extends Tuples2<? extends K, ? extends V>> function2) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "$this$getStringEntrySetAsMap");
        Intrinsics3.checkNotNullParameter(str, "cacheKey");
        Intrinsics3.checkNotNullParameter(str2, "delimiter");
        Intrinsics3.checkNotNullParameter(function2, "transformer");
        Set stringSetNonNull$default = getStringSetNonNull$default(sharedPreferences, str, null, 2, null);
        HashMap map = new HashMap(stringSetNonNull$default.size());
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(stringSetNonNull$default, 10));
        Iterator it = stringSetNonNull$default.iterator();
        while (it.hasNext()) {
            List listSplit$default = Strings4.split$default((CharSequence) it.next(), new String[]{str2}, false, 2, 2, (Object) null);
            arrayList.add(function2.invoke(listSplit$default.get(0), listSplit$default.get(1)));
        }
        return Maps6.toMap(arrayList, map);
    }

    public static /* synthetic */ Map getStringEntrySetAsMap$default(SharedPreferences sharedPreferences, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = ",";
        }
        return getStringEntrySetAsMap(sharedPreferences, str, str2, function2);
    }

    public static final String getStringNonNull(SharedPreferences sharedPreferences, String str, String str2) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "$this$getStringNonNull");
        Intrinsics3.checkNotNullParameter(str, "key");
        Intrinsics3.checkNotNullParameter(str2, "defValue");
        String string = sharedPreferences.getString(str, str2);
        return string != null ? string : str2;
    }

    public static final Set<String> getStringSetNonNull(SharedPreferences sharedPreferences, String str, Set<String> set) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "$this$getStringSetNonNull");
        Intrinsics3.checkNotNullParameter(str, "key");
        Intrinsics3.checkNotNullParameter(set, "defValues");
        Set<String> stringSet = sharedPreferences.getStringSet(str, set);
        return stringSet != null ? stringSet : Sets5.emptySet();
    }

    public static /* synthetic */ Set getStringSetNonNull$default(SharedPreferences sharedPreferences, String str, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            set = Sets5.emptySet();
        }
        return getStringSetNonNull(sharedPreferences, str, set);
    }

    public static final <K, V> void putStringEntrySetAsMap(SharedPreferences.Editor editor, String str, Map<K, ? extends V> map, String str2, Function1<? super V, String> function1) {
        Intrinsics3.checkNotNullParameter(editor, "$this$putStringEntrySetAsMap");
        Intrinsics3.checkNotNullParameter(str, "cacheKey");
        Intrinsics3.checkNotNullParameter(map, "value");
        Intrinsics3.checkNotNullParameter(str2, "delimiter");
        Intrinsics3.checkNotNullParameter(function1, "transformer");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + str2 + function1.invoke(entry.getValue()));
        }
        editor.putStringSet(str, _Collections.toSet(arrayList));
    }

    public static /* synthetic */ void putStringEntrySetAsMap$default(SharedPreferences.Editor editor, String str, Map map, String str2, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = ",";
        }
        if ((i & 8) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        putStringEntrySetAsMap(editor, str, map, str2, function1);
    }
}
