package com.discord.utilities.cache;

import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import androidx.exifinterface.media.ExifInterface;
import d0.g0.w;
import d0.t.h0;
import d0.t.n0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SharedPreferenceExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SharedPreferenceExtensionsKt {
    public static final String getString(SharedPreferences sharedPreferences, String str) {
        m.checkNotNullParameter(sharedPreferences, "$this$getString");
        m.checkNotNullParameter(str, "key");
        return sharedPreferences.getString(str, null);
    }

    public static final <K, V> Map<K, V> getStringEntrySetAsMap(SharedPreferences sharedPreferences, String str, String str2, Function2<? super String, ? super String, ? extends Pair<? extends K, ? extends V>> function2) {
        m.checkNotNullParameter(sharedPreferences, "$this$getStringEntrySetAsMap");
        m.checkNotNullParameter(str, "cacheKey");
        m.checkNotNullParameter(str2, "delimiter");
        m.checkNotNullParameter(function2, "transformer");
        Set stringSetNonNull$default = getStringSetNonNull$default(sharedPreferences, str, null, 2, null);
        HashMap map = new HashMap(stringSetNonNull$default.size());
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(stringSetNonNull$default, 10));
        Iterator it = stringSetNonNull$default.iterator();
        while (it.hasNext()) {
            List listSplit$default = w.split$default((CharSequence) it.next(), new String[]{str2}, false, 2, 2, (Object) null);
            arrayList.add(function2.invoke(listSplit$default.get(0), listSplit$default.get(1)));
        }
        return h0.toMap(arrayList, map);
    }

    public static /* synthetic */ Map getStringEntrySetAsMap$default(SharedPreferences sharedPreferences, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = ",";
        }
        return getStringEntrySetAsMap(sharedPreferences, str, str2, function2);
    }

    public static final String getStringNonNull(SharedPreferences sharedPreferences, String str, String str2) {
        m.checkNotNullParameter(sharedPreferences, "$this$getStringNonNull");
        m.checkNotNullParameter(str, "key");
        m.checkNotNullParameter(str2, "defValue");
        String string = sharedPreferences.getString(str, str2);
        return string != null ? string : str2;
    }

    public static final Set<String> getStringSetNonNull(SharedPreferences sharedPreferences, String str, Set<String> set) {
        m.checkNotNullParameter(sharedPreferences, "$this$getStringSetNonNull");
        m.checkNotNullParameter(str, "key");
        m.checkNotNullParameter(set, "defValues");
        Set<String> stringSet = sharedPreferences.getStringSet(str, set);
        return stringSet != null ? stringSet : n0.emptySet();
    }

    public static /* synthetic */ Set getStringSetNonNull$default(SharedPreferences sharedPreferences, String str, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            set = n0.emptySet();
        }
        return getStringSetNonNull(sharedPreferences, str, set);
    }

    public static final <K, V> void putStringEntrySetAsMap(SharedPreferences$Editor sharedPreferences$Editor, String str, Map<K, ? extends V> map, String str2, Function1<? super V, String> function1) {
        m.checkNotNullParameter(sharedPreferences$Editor, "$this$putStringEntrySetAsMap");
        m.checkNotNullParameter(str, "cacheKey");
        m.checkNotNullParameter(map, "value");
        m.checkNotNullParameter(str2, "delimiter");
        m.checkNotNullParameter(function1, "transformer");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map$Entry<K, ? extends V> map$Entry : map.entrySet()) {
            arrayList.add(map$Entry.getKey() + str2 + function1.invoke(map$Entry.getValue()));
        }
        sharedPreferences$Editor.putStringSet(str, u.toSet(arrayList));
    }

    public static /* synthetic */ void putStringEntrySetAsMap$default(SharedPreferences$Editor sharedPreferences$Editor, String str, Map map, String str2, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = ",";
        }
        if ((i & 8) != 0) {
            function1 = SharedPreferenceExtensionsKt$putStringEntrySetAsMap$1.INSTANCE;
        }
        putStringEntrySetAsMap(sharedPreferences$Editor, str, map, str2, function1);
    }
}
