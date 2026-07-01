package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$observeSuggestedSearchTerms$3<T, R> implements b<Map<String, ? extends List<? extends String>>, List<? extends String>> {
    public final /* synthetic */ String $query;

    public StoreGifPicker$observeSuggestedSearchTerms$3(String str) {
        this.$query = str;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends String> call(Map<String, ? extends List<? extends String>> map) {
        return call2((Map<String, ? extends List<String>>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<String> call2(Map<String, ? extends List<String>> map) {
        return map.get(this.$query);
    }
}
