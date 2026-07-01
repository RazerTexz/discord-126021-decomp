package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.models.gifpicker.dto.ModelGif;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: GifCategoryViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifCategoryViewModel$Companion$observeStoreState$1<T, R> implements b<List<? extends ModelGif>, GifCategoryViewModel$StoreState> {
    public static final GifCategoryViewModel$Companion$observeStoreState$1 INSTANCE = new GifCategoryViewModel$Companion$observeStoreState$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ GifCategoryViewModel$StoreState call(List<? extends ModelGif> list) {
        return call2((List<ModelGif>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GifCategoryViewModel$StoreState call2(List<ModelGif> list) {
        m.checkNotNullExpressionValue(list, "gifs");
        return new GifCategoryViewModel$StoreState(list);
    }
}
