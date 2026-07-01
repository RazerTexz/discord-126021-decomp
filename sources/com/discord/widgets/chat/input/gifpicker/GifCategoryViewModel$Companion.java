package com.discord.widgets.chat.input.gifpicker;

import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreGifPicker;
import d0.z.d.m;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GifCategoryViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifCategoryViewModel$Companion {
    private GifCategoryViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(GifCategoryViewModel$Companion gifCategoryViewModel$Companion, GifCategoryItem gifCategoryItem, StoreGifPicker storeGifPicker) {
        return gifCategoryViewModel$Companion.observeStoreState(gifCategoryItem, storeGifPicker);
    }

    private final Observable<GifCategoryViewModel$StoreState> observeStoreState(GifCategoryItem gifCategoryItem, StoreGifPicker storeGifPicker) {
        Observable<List<ModelGif>> observableObserveTrendingCategoryGifs;
        if (gifCategoryItem instanceof GifCategoryItem$Standard) {
            observableObserveTrendingCategoryGifs = storeGifPicker.observeGifsForSearchQuery(((GifCategoryItem$Standard) gifCategoryItem).getGifCategory().getCategoryName());
        } else {
            if (!(gifCategoryItem instanceof GifCategoryItem$Trending)) {
                throw new NoWhenBranchMatchedException();
            }
            observableObserveTrendingCategoryGifs = storeGifPicker.observeTrendingCategoryGifs();
        }
        Observable observableG = observableObserveTrendingCategoryGifs.G(GifCategoryViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "gifsObservable.map { gifs -> StoreState(gifs) }");
        return observableG;
    }

    public /* synthetic */ GifCategoryViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
