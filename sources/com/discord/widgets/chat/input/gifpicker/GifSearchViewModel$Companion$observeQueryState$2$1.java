package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreGifPicker;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifSearchViewModel$Companion$observeQueryState$2$1<T, R> implements b<List<? extends ModelGif>, Boolean> {
    public static final GifSearchViewModel$Companion$observeQueryState$2$1 INSTANCE = new GifSearchViewModel$Companion$observeQueryState$2$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(List<? extends ModelGif> list) {
        return call2((List<ModelGif>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(List<ModelGif> list) {
        return Boolean.valueOf(list != StoreGifPicker.Companion.getSearchResultsLoadingList());
    }
}
