package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.gifpicker.dto.ModelGif;
import j0.k.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$observeGifsForSearchQuery$2<T, R> implements b<Map<String, ? extends List<? extends ModelGif>>, List<? extends ModelGif>> {
    public final /* synthetic */ String $query;

    public StoreGifPicker$observeGifsForSearchQuery$2(String str) {
        this.$query = str;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends ModelGif> call(Map<String, ? extends List<? extends ModelGif>> map) {
        return call2((Map<String, ? extends List<ModelGif>>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ModelGif> call2(Map<String, ? extends List<ModelGif>> map) {
        return map.get(this.$query);
    }
}
