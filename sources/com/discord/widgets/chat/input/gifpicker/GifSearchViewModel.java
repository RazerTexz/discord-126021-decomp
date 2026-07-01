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
import com.discord.utilities.recycler.DiffKeyProvider;
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
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifSearchViewModel extends d0<GifSearchViewModel$ViewState> {
    public static final GifSearchViewModel$Companion Companion = new GifSearchViewModel$Companion(null);
    private final MessageManager messageManager;
    private final BehaviorSubject<String> searchSubject;
    private final StoreAnalytics storeAnalytics;
    private final StoreGifPicker storeGifPicker;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GifSearchViewModel(Context context, BehaviorSubject behaviorSubject, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, MessageManager messageManager, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        BehaviorSubject behaviorSubjectL0;
        if ((i & 2) != 0) {
            behaviorSubjectL0 = BehaviorSubject.l0("");
            m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        } else {
            behaviorSubjectL0 = behaviorSubject;
        }
        StoreGifPicker gifPicker = (i & 4) != 0 ? StoreStream.Companion.getGifPicker() : storeGifPicker;
        StoreAnalytics analytics = (i & 8) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics;
        this(context, behaviorSubjectL0, gifPicker, analytics, (i & 16) != 0 ? new MessageManager(context, null, null, null, null, null, null, null, null, 510, null) : messageManager, (i & 32) != 0 ? GifSearchViewModel$Companion.access$observeStoreState(Companion, behaviorSubjectL0, analytics, gifPicker) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GifSearchViewModel gifSearchViewModel, GifSearchViewModel$StoreState gifSearchViewModel$StoreState) {
        gifSearchViewModel.handleStoreState(gifSearchViewModel$StoreState);
    }

    private final void handleStoreState(GifSearchViewModel$StoreState storeState) {
        DiffKeyProvider gifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults;
        ArrayList arrayList = new ArrayList();
        List<String> trendingSearchTerms = storeState.getTrendingSearchTerms();
        boolean z2 = storeState instanceof GifSearchViewModel$StoreState$SearchResults;
        if (z2) {
            GifSearchViewModel$StoreState$SearchResults gifSearchViewModel$StoreState$SearchResults = (GifSearchViewModel$StoreState$SearchResults) storeState;
            List<ModelGif> gifs = gifSearchViewModel$StoreState$SearchResults.getGifs();
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(gifs, 10));
            Iterator<T> it = gifs.iterator();
            while (it.hasNext()) {
                arrayList2.add(new GifAdapterItem$GifItem((ModelGif) it.next(), gifSearchViewModel$StoreState$SearchResults.getSearchQuery()));
            }
            arrayList.addAll(arrayList2);
            List<String> suggested = gifSearchViewModel$StoreState$SearchResults.getSuggested();
            boolean z3 = arrayList.size() > 0;
            boolean z4 = gifSearchViewModel$StoreState$SearchResults.getSuggested().size() > 0;
            String strN0 = this.searchSubject.n0();
            m.checkNotNullExpressionValue(strN0, "searchSubject.value");
            boolean z5 = strN0.length() > 0;
            if (z3) {
                gifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults = new GifAdapterItem$SuggestedTermsItem$SuggestedTermsNonEmptyResults(suggested, 2131889627);
            } else if (!z5 || z4) {
                gifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults = (z5 && z4) ? new GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults(suggested, 2131893255) : new GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults(suggested, 2131889626);
            } else {
                gifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults = new GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults(suggested, 2131893256);
            }
            arrayList.add(gifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults);
        } else if (storeState instanceof GifSearchViewModel$StoreState$TrendingSearchTermsResults) {
            arrayList.add(new GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults(trendingSearchTerms, 2131889626));
        }
        GifSearchViewModel$ViewState$Loaded gifSearchViewModel$ViewState$Loaded = new GifSearchViewModel$ViewState$Loaded(arrayList);
        if (z2) {
            StoreAnalytics.trackSearchResultViewed$default(this.storeAnalytics, SearchType.GIF, gifSearchViewModel$ViewState$Loaded.getGifCount(), null, null, false, 28, null);
        }
        updateViewState(gifSearchViewModel$ViewState$Loaded);
    }

    public final void selectGif(GifAdapterItem$GifItem gifItem) {
        m.checkNotNullParameter(gifItem, "gifItem");
        GifSearchViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof GifSearchViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        GifSearchViewModel$ViewState$Loaded gifSearchViewModel$ViewState$Loaded = (GifSearchViewModel$ViewState$Loaded) viewState;
        if (gifSearchViewModel$ViewState$Loaded != null) {
            StoreAnalytics.trackSearchResultSelected$default(this.storeAnalytics, SearchType.GIF, gifSearchViewModel$ViewState$Loaded.getGifCount(), null, new Traits$Source(null, null, Traits$Source$Obj.GIF_PICKER, null, null, 27, null), 4, null);
        }
        MessageManager.sendMessage$default(this.messageManager, gifItem.getGif().getTenorGifUrl(), null, null, null, null, false, null, null, null, 510, null);
    }

    public final void setSearchText(String searchText) {
        m.checkNotNullParameter(searchText, "searchText");
        if (!m.areEqual(this.searchSubject.n0(), searchText)) {
            if (searchText.length() > 0) {
                updateViewState(GifSearchViewModel$ViewState$LoadingSearchResults.INSTANCE);
            }
        }
        this.searchSubject.onNext(searchText);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifSearchViewModel(Context context, BehaviorSubject<String> behaviorSubject, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, MessageManager messageManager, Observable<GifSearchViewModel$StoreState> observable) {
        super(null);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(behaviorSubject, "searchSubject");
        m.checkNotNullParameter(storeGifPicker, "storeGifPicker");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(messageManager, "messageManager");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.searchSubject = behaviorSubject;
        this.storeGifPicker = storeGifPicker;
        this.storeAnalytics = storeAnalytics;
        this.messageManager = messageManager;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), GifSearchViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GifSearchViewModel$1(this), 62, (Object) null);
    }
}
