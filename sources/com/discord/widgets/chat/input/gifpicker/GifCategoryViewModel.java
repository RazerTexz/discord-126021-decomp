package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreGifPicker;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import com.discord.widgets.chat.input.gifpicker.GifCategoryViewModel;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: GifCategoryViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifCategoryViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GifCategoryItem gifCategoryItem;
    private final MessageManager messageManager;
    private final StoreAnalytics storeAnalytics;
    private final StoreGifPicker storeGifPicker;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.GifCategoryViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GifCategoryViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GifCategoryViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GifCategoryViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(GifCategoryItem gifCategoryItem, StoreGifPicker storeGifPicker) {
            Observable<List<ModelGif>> observableObserveTrendingCategoryGifs;
            if (gifCategoryItem instanceof GifCategoryItem.Standard) {
                observableObserveTrendingCategoryGifs = storeGifPicker.observeGifsForSearchQuery(((GifCategoryItem.Standard) gifCategoryItem).getGifCategory().getCategoryName());
            } else {
                if (!(gifCategoryItem instanceof GifCategoryItem.Trending)) {
                    throw new NoWhenBranchMatchedException();
                }
                observableObserveTrendingCategoryGifs = storeGifPicker.observeTrendingCategoryGifs();
            }
            Observable observableG = observableObserveTrendingCategoryGifs.G(new Func1<List<? extends ModelGif>, StoreState>() { // from class: com.discord.widgets.chat.input.gifpicker.GifCategoryViewModel$Companion$observeStoreState$1
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ GifCategoryViewModel.StoreState call(List<? extends ModelGif> list) {
                    return call2((List<ModelGif>) list);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final GifCategoryViewModel.StoreState call2(List<ModelGif> list) {
                    Intrinsics3.checkNotNullExpressionValue(list, "gifs");
                    return new GifCategoryViewModel.StoreState(list);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "gifsObservable.map { gifs -> StoreState(gifs) }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GifCategoryViewModel.kt */
    public static final /* data */ class StoreState {
        private final List<ModelGif> gifs;

        public StoreState(List<ModelGif> list) {
            Intrinsics3.checkNotNullParameter(list, "gifs");
            this.gifs = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.gifs;
            }
            return storeState.copy(list);
        }

        public final List<ModelGif> component1() {
            return this.gifs;
        }

        public final StoreState copy(List<ModelGif> gifs) {
            Intrinsics3.checkNotNullParameter(gifs, "gifs");
            return new StoreState(gifs);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && Intrinsics3.areEqual(this.gifs, ((StoreState) other).gifs);
            }
            return true;
        }

        public final List<ModelGif> getGifs() {
            return this.gifs;
        }

        public int hashCode() {
            List<ModelGif> list = this.gifs;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.L(outline.U("StoreState(gifs="), this.gifs, ")");
        }
    }

    /* JADX INFO: compiled from: GifCategoryViewModel.kt */
    public static final /* data */ class ViewState {

        /* JADX INFO: renamed from: gifCount$delegate, reason: from kotlin metadata */
        private final Lazy gifCount;
        private final List<GifAdapterItem.GifItem> gifItems;

        public ViewState(List<GifAdapterItem.GifItem> list) {
            Intrinsics3.checkNotNullParameter(list, "gifItems");
            this.gifItems = list;
            this.gifCount = LazyJVM.lazy(new GifCategoryViewModel3(this));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.gifItems;
            }
            return viewState.copy(list);
        }

        public static /* synthetic */ void getGifCount$annotations() {
        }

        public final List<GifAdapterItem.GifItem> component1() {
            return this.gifItems;
        }

        public final ViewState copy(List<GifAdapterItem.GifItem> gifItems) {
            Intrinsics3.checkNotNullParameter(gifItems, "gifItems");
            return new ViewState(gifItems);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ViewState) && Intrinsics3.areEqual(this.gifItems, ((ViewState) other).gifItems);
            }
            return true;
        }

        public final int getGifCount() {
            return ((Number) this.gifCount.getValue()).intValue();
        }

        public final List<GifAdapterItem.GifItem> getGifItems() {
            return this.gifItems;
        }

        public int hashCode() {
            List<GifAdapterItem.GifItem> list = this.gifItems;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.L(outline.U("ViewState(gifItems="), this.gifItems, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GifCategoryViewModel(Context context, GifCategoryItem gifCategoryItem, MessageManager messageManager, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        MessageManager messageManager2 = (i & 4) != 0 ? new MessageManager(context, null, null, null, null, null, null, null, null, 510, null) : messageManager;
        StoreGifPicker gifPicker = (i & 8) != 0 ? StoreStream.INSTANCE.getGifPicker() : storeGifPicker;
        this(context, gifCategoryItem, messageManager2, gifPicker, (i & 16) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, (i & 32) != 0 ? INSTANCE.observeStoreState(gifCategoryItem, gifPicker) : observable);
    }

    private final void handleStoreState(StoreState storeState) {
        List<ModelGif> gifs = storeState.getGifs();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(gifs, 10));
        Iterator<T> it = gifs.iterator();
        while (it.hasNext()) {
            arrayList.add(new GifAdapterItem.GifItem((ModelGif) it.next(), null, 2, null));
        }
        ViewState viewState = new ViewState(arrayList);
        this.storeAnalytics.trackSearchResultViewed(SearchType.GIF, viewState.getGifCount(), (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? false : false);
        updateViewState(viewState);
    }

    public final void selectGif(GifAdapterItem.GifItem gifItem) {
        Intrinsics3.checkNotNullParameter(gifItem, "gifItem");
        ViewState viewState = getViewState();
        if (viewState != null) {
            StoreAnalytics.trackSearchResultSelected$default(this.storeAnalytics, SearchType.GIF, viewState.getGifCount(), null, new Traits.Source(null, null, Traits.Source.Obj.GIF_PICKER, null, null, 27, null), 4, null);
        }
        MessageManager messageManager = this.messageManager;
        messageManager.sendMessage((510 & 1) != 0 ? "" : gifItem.getGif().getTenorGifUrl(), (510 & 2) != 0 ? null : null, (510 & 4) != 0 ? null : null, (510 & 8) != 0 ? null : null, (510 & 16) != 0 ? Collections2.emptyList() : null, (510 & 32) != 0, (510 & 64) != 0 ? null : null, (510 & 128) == 0 ? null : null, (510 & 256) != 0 ? messageManager.defaultMessageResultHandler : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifCategoryViewModel(Context context, GifCategoryItem gifCategoryItem, MessageManager messageManager, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
        Intrinsics3.checkNotNullParameter(storeGifPicker, "storeGifPicker");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.gifCategoryItem = gifCategoryItem;
        this.messageManager = messageManager;
        this.storeGifPicker = storeGifPicker;
        this.storeAnalytics = storeAnalytics;
        StoreAnalytics.trackSearchStarted$default(storeAnalytics, SearchType.GIF, null, false, 6, null);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observable, false, 1, null), this, null, 2, null), (Class<?>) GifCategoryViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
