package com.discord.utilities.cache;

import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SharedPreferenceExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SharedPreferenceExtensionsKt {

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* JADX INFO: renamed from: com.discord.utilities.cache.SharedPreferenceExtensionsKt$putStringEntrySetAsMap$1 */
    /* JADX INFO: compiled from: SharedPreferenceExtensions.kt */
    public static final class C67121<V> extends AbstractC12240o implements Function1<V, String> {
        public static final C67121 INSTANCE = new C67121();

        public C67121() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(V v) {
            return String.valueOf(v);
        }
    }

    public static final String getString(SharedPreferences sharedPreferences, String str) {
        C12238m.checkNotNullParameter(sharedPreferences, "$this$getString");
        C12238m.checkNotNullParameter(str, "key");
        return sharedPreferences.getString(str, null);
    }

    public static final <K, V> Map<K, V> getStringEntrySetAsMap(SharedPreferences sharedPreferences, String str, String str2, Function2<? super String, ? super String, ? extends Pair<? extends K, ? extends V>> function2) {
        C12238m.checkNotNullParameter(sharedPreferences, "$this$getStringEntrySetAsMap");
        C12238m.checkNotNullParameter(str, "cacheKey");
        C12238m.checkNotNullParameter(str2, "delimiter");
        C12238m.checkNotNullParameter(function2, "transformer");
        Set stringSetNonNull$default = getStringSetNonNull$default(sharedPreferences, str, null, 2, null);
        HashMap map = new HashMap(stringSetNonNull$default.size());
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(stringSetNonNull$default, 10));
        Iterator it = stringSetNonNull$default.iterator();
        while (it.hasNext()) {
            List listSplit$default = C12106w.split$default((CharSequence) it.next(), new String[]{str2}, false, 2, 2, (Object) null);
            arrayList.add(function2.invoke(listSplit$default.get(0), listSplit$default.get(1)));
        }
        return C12136h0.toMap(arrayList, map);
    }

    public static /* synthetic */ Map getStringEntrySetAsMap$default(SharedPreferences sharedPreferences, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = ",";
        }
        return getStringEntrySetAsMap(sharedPreferences, str, str2, function2);
    }

    public static final String getStringNonNull(SharedPreferences sharedPreferences, String str, String str2) {
        C12238m.checkNotNullParameter(sharedPreferences, "$this$getStringNonNull");
        C12238m.checkNotNullParameter(str, "key");
        C12238m.checkNotNullParameter(str2, "defValue");
        String string = sharedPreferences.getString(str, str2);
        return string != null ? string : str2;
    }

    public static final Set<String> getStringSetNonNull(SharedPreferences sharedPreferences, String str, Set<String> set) {
        C12238m.checkNotNullParameter(sharedPreferences, "$this$getStringSetNonNull");
        C12238m.checkNotNullParameter(str, "key");
        C12238m.checkNotNullParameter(set, "defValues");
        Set<String> stringSet = sharedPreferences.getStringSet(str, set);
        return stringSet != null ? stringSet : C12148n0.emptySet();
    }

    public static /* synthetic */ Set getStringSetNonNull$default(SharedPreferences sharedPreferences, String str, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            set = C12148n0.emptySet();
        }
        return getStringSetNonNull(sharedPreferences, str, set);
    }

    public static final <K, V> void putStringEntrySetAsMap(SharedPreferences.Editor editor, String str, Map<K, ? extends V> map, String str2, Function1<? super V, String> function1) {
        C12238m.checkNotNullParameter(editor, "$this$putStringEntrySetAsMap");
        C12238m.checkNotNullParameter(str, "cacheKey");
        C12238m.checkNotNullParameter(map, "value");
        C12238m.checkNotNullParameter(str2, "delimiter");
        C12238m.checkNotNullParameter(function1, "transformer");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + str2 + function1.invoke(entry.getValue()));
        }
        editor.putStringSet(str, C12163u.toSet(arrayList));
    }

    public static /* synthetic */ void putStringEntrySetAsMap$default(SharedPreferences.Editor editor, String str, Map map, String str2, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = ",";
        }
        if ((i & 8) != 0) {
            function1 = C67121.INSTANCE;
        }
        putStringEntrySetAsMap(editor, str, map, str2, function1);
    }
}
