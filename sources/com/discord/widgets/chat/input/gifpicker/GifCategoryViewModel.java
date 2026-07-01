package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreGifPicker;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits$Source;
import com.discord.utilities.analytics.Traits$Source$Obj;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.MessageManager;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GifCategoryViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifCategoryViewModel extends d0<GifCategoryViewModel$ViewState> {
    public static final GifCategoryViewModel$Companion Companion = new GifCategoryViewModel$Companion(null);
    private final GifCategoryItem gifCategoryItem;
    private final MessageManager messageManager;
    private final StoreAnalytics storeAnalytics;
    private final StoreGifPicker storeGifPicker;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GifCategoryViewModel(Context context, GifCategoryItem gifCategoryItem, MessageManager messageManager, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        MessageManager messageManager2 = (i & 4) != 0 ? new MessageManager(context, null, null, null, null, null, null, null, null, 510, null) : messageManager;
        StoreGifPicker gifPicker = (i & 8) != 0 ? StoreStream.Companion.getGifPicker() : storeGifPicker;
        this(context, gifCategoryItem, messageManager2, gifPicker, (i & 16) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics, (i & 32) != 0 ? GifCategoryViewModel$Companion.access$observeStoreState(Companion, gifCategoryItem, gifPicker) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GifCategoryViewModel gifCategoryViewModel, GifCategoryViewModel$StoreState gifCategoryViewModel$StoreState) {
        gifCategoryViewModel.handleStoreState(gifCategoryViewModel$StoreState);
    }

    private final void handleStoreState(GifCategoryViewModel$StoreState storeState) {
        List<ModelGif> gifs = storeState.getGifs();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(gifs, 10));
        Iterator<T> it = gifs.iterator();
        while (it.hasNext()) {
            arrayList.add(new GifAdapterItem$GifItem((ModelGif) it.next(), null, 2, null));
        }
        GifCategoryViewModel$ViewState gifCategoryViewModel$ViewState = new GifCategoryViewModel$ViewState(arrayList);
        StoreAnalytics.trackSearchResultViewed$default(this.storeAnalytics, SearchType.GIF, gifCategoryViewModel$ViewState.getGifCount(), null, null, false, 28, null);
        updateViewState(gifCategoryViewModel$ViewState);
    }

    public final void selectGif(GifAdapterItem$GifItem gifItem) {
        m.checkNotNullParameter(gifItem, "gifItem");
        GifCategoryViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            StoreAnalytics.trackSearchResultSelected$default(this.storeAnalytics, SearchType.GIF, viewState.getGifCount(), null, new Traits$Source(null, null, Traits$Source$Obj.GIF_PICKER, null, null, 27, null), 4, null);
        }
        MessageManager.sendMessage$default(this.messageManager, gifItem.getGif().getTenorGifUrl(), null, null, null, null, false, null, null, null, 510, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifCategoryViewModel(Context context, GifCategoryItem gifCategoryItem, MessageManager messageManager, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, Observable<GifCategoryViewModel$StoreState> observable) {
        super(null);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
        m.checkNotNullParameter(messageManager, "messageManager");
        m.checkNotNullParameter(storeGifPicker, "storeGifPicker");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.gifCategoryItem = gifCategoryItem;
        this.messageManager = messageManager;
        this.storeGifPicker = storeGifPicker;
        this.storeAnalytics = storeAnalytics;
        StoreAnalytics.trackSearchStarted$default(storeAnalytics, SearchType.GIF, null, false, 6, null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observable, false, 1, null), this, null, 2, null), GifCategoryViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GifCategoryViewModel$1(this), 62, (Object) null);
    }
}
