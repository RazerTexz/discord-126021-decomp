package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.gifpicker.dto.GifDto;
import com.discord.models.gifpicker.dto.ModelGif;
import d0.t.o;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$fetchGifsForSearchQuery$1<T, R> implements b<List<? extends GifDto>, List<? extends ModelGif>> {
    public static final StoreGifPicker$fetchGifsForSearchQuery$1 INSTANCE = new StoreGifPicker$fetchGifsForSearchQuery$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends ModelGif> call(List<? extends GifDto> list) {
        return call2((List<GifDto>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ModelGif> call2(List<GifDto> list) {
        m.checkNotNullExpressionValue(list, "gifDtos");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ModelGif.Companion.createFromGifDto((GifDto) it.next()));
        }
        return arrayList;
    }
}
