package com.discord.stores;

import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import com.discord.utilities.cache.SharedPreferenceExtensionsKt;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories$Companion {
    private StoreCollapsedChannelCategories$Companion() {
    }

    public static final /* synthetic */ Map access$fromCache(StoreCollapsedChannelCategories$Companion storeCollapsedChannelCategories$Companion, SharedPreferences sharedPreferences) {
        return storeCollapsedChannelCategories$Companion.fromCache(sharedPreferences);
    }

    public static final /* synthetic */ void access$toCache(StoreCollapsedChannelCategories$Companion storeCollapsedChannelCategories$Companion, SharedPreferences sharedPreferences, Map map) {
        storeCollapsedChannelCategories$Companion.toCache(sharedPreferences, map);
    }

    private final Map<Long, Set<Long>> fromCache(SharedPreferences prefs) {
        return SharedPreferenceExtensionsKt.getStringEntrySetAsMap$default(prefs, "STORE_COLLAPSED_CATEGORIES_V2", null, StoreCollapsedChannelCategories$Companion$fromCache$1.INSTANCE, 2, null);
    }

    private final void toCache(SharedPreferences prefs, Map<Long, Set<Long>> collapsedCategories) {
        SharedPreferences$Editor sharedPreferences$EditorEdit = prefs.edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        SharedPreferenceExtensionsKt.putStringEntrySetAsMap$default(sharedPreferences$EditorEdit, "STORE_COLLAPSED_CATEGORIES_V2", collapsedCategories, null, StoreCollapsedChannelCategories$Companion$toCache$1$1.INSTANCE, 4, null);
        sharedPreferences$EditorEdit.apply();
    }

    public /* synthetic */ StoreCollapsedChannelCategories$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
