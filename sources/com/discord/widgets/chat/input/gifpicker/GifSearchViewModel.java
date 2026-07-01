package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreGifPicker;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.discord.widgets.chat.input.gifpicker.GifSearchViewModel;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifSearchViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MessageManager messageManager;
    private final BehaviorSubject<String> searchSubject;
    private final StoreAnalytics storeAnalytics;
    private final StoreGifPicker storeGifPicker;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GifSearchViewModel.kt */
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
            GifSearchViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GifSearchViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeQueryState(BehaviorSubject<String> searchSubject, final StoreAnalytics storeAnalytics, final StoreGifPicker storeGifPicker, final List<String> trendingSearchTerms) {
            Observable<String> observableR = searchSubject.J(Schedulers2.c()).r();
            Observable<StoreState> observableY = Observable.h0(new OnSubscribeLift(observableR.j, new LeadingEdgeThrottle(1000L, TimeUnit.MILLISECONDS, Schedulers2.c()))).u(new Action1<String>() { // from class: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$1
                @Override // rx.functions.Action1
                public final void call(String str) {
                    StoreAnalytics.trackSearchStarted$default(storeAnalytics, SearchType.GIF, null, false, 6, null);
                }
            }).Y(new Func1<String, Observable<? extends StoreState>>() { // from class: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2
                @Override // j0.k.Func1
                public final Observable<? extends GifSearchViewModel.StoreState> call(final String str) {
                    Intrinsics3.checkNotNullExpressionValue(str, "query");
                    return str.length() == 0 ? new ScalarSynchronousObservable(new GifSearchViewModel.StoreState.TrendingSearchTermsResults(trendingSearchTerms)) : Observable.j(storeGifPicker.observeGifsForSearchQuery(str).y(new Func1<List<? extends ModelGif>, Boolean>() { // from class: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2.1
                        @Override // j0.k.Func1
                        public /* bridge */ /* synthetic */ Boolean call(List<? extends ModelGif> list) {
                            return call2((List<ModelGif>) list);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final Boolean call2(List<ModelGif> list) {
                            return Boolean.valueOf(list != StoreGifPicker.INSTANCE.getSearchResultsLoadingList());
                        }
                    }), storeGifPicker.observeSuggestedSearchTerms(str), new Func2<List<? extends ModelGif>, List<? extends String>, GifSearchViewModel.StoreState.SearchResults>() { // from class: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2.2
                        @Override // rx.functions.Func2
                        public /* bridge */ /* synthetic */ GifSearchViewModel.StoreState.SearchResults call(List<? extends ModelGif> list, List<? extends String> list2) {
                            return call2((List<ModelGif>) list, (List<String>) list2);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final GifSearchViewModel.StoreState.SearchResults call2(List<ModelGif> list, List<String> list2) {
                            Intrinsics3.checkNotNullExpressionValue(list, "gifResults");
                            Intrinsics3.checkNotNullExpressionValue(list2, "searchTerms");
                            return new GifSearchViewModel.StoreState.SearchResults(list, list2, trendingSearchTerms, str);
                        }
                    });
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "searchSubject\n          …          }\n            }");
            return observableY;
        }

        private final Observable<StoreState> observeStoreState(final BehaviorSubject<String> searchSubject, final StoreAnalytics storeAnalytics, final StoreGifPicker storeGifPicker) {
            Observable observableY = storeGifPicker.observeGifTrendingSearchTerms().Y(new Func1<List<? extends String>, Observable<? extends StoreState>>() { // from class: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeStoreState$1
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Observable<? extends GifSearchViewModel.StoreState> call(List<? extends String> list) {
                    return call2((List<String>) list);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends GifSearchViewModel.StoreState> call2(List<String> list) {
                    GifSearchViewModel.Companion companion = GifSearchViewModel.INSTANCE;
                    BehaviorSubject behaviorSubject = searchSubject;
                    StoreAnalytics storeAnalytics2 = storeAnalytics;
                    StoreGifPicker storeGifPicker2 = storeGifPicker;
                    Intrinsics3.checkNotNullExpressionValue(list, "terms");
                    return companion.observeQueryState(behaviorSubject, storeAnalytics2, storeGifPicker2, list);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeGifPicker.observeGi…fPicker, terms)\n        }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GifSearchViewModel.kt */
    public static abstract class StoreState {
        private final List<String> trendingSearchTerms;

        /* JADX INFO: compiled from: GifSearchViewModel.kt */
        public static final /* data */ class SearchResults extends StoreState {
            private final List<ModelGif> gifs;
            private final String searchQuery;
            private final List<String> suggested;
            private final List<String> trending;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SearchResults(List<ModelGif> list, List<String> list2, List<String> list3, String str) {
                super(list3, null);
                Intrinsics3.checkNotNullParameter(list, "gifs");
                Intrinsics3.checkNotNullParameter(list2, "suggested");
                Intrinsics3.checkNotNullParameter(list3, "trending");
                this.gifs = list;
                this.suggested = list2;
                this.trending = list3;
                this.searchQuery = str;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SearchResults copy$default(SearchResults searchResults, List list, List list2, List list3, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = searchResults.gifs;
                }
                if ((i & 2) != 0) {
                    list2 = searchResults.suggested;
                }
                if ((i & 4) != 0) {
                    list3 = searchResults.trending;
                }
                if ((i & 8) != 0) {
                    str = searchResults.searchQuery;
                }
                return searchResults.copy(list, list2, list3, str);
            }

            public final List<ModelGif> component1() {
                return this.gifs;
            }

            public final List<String> component2() {
                return this.suggested;
            }

            public final List<String> component3() {
                return this.trending;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getSearchQuery() {
                return this.searchQuery;
            }

            public final SearchResults copy(List<ModelGif> gifs, List<String> suggested, List<String> trending, String searchQuery) {
                Intrinsics3.checkNotNullParameter(gifs, "gifs");
                Intrinsics3.checkNotNullParameter(suggested, "suggested");
                Intrinsics3.checkNotNullParameter(trending, "trending");
                return new SearchResults(gifs, suggested, trending, searchQuery);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SearchResults)) {
                    return false;
                }
                SearchResults searchResults = (SearchResults) other;
                return Intrinsics3.areEqual(this.gifs, searchResults.gifs) && Intrinsics3.areEqual(this.suggested, searchResults.suggested) && Intrinsics3.areEqual(this.trending, searchResults.trending) && Intrinsics3.areEqual(this.searchQuery, searchResults.searchQuery);
            }

            public final List<ModelGif> getGifs() {
                return this.gifs;
            }

            public final String getSearchQuery() {
                return this.searchQuery;
            }

            public final List<String> getSuggested() {
                return this.suggested;
            }

            public final List<String> getTrending() {
                return this.trending;
            }

            public int hashCode() {
                List<ModelGif> list = this.gifs;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                List<String> list2 = this.suggested;
                int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
                List<String> list3 = this.trending;
                int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
                String str = this.searchQuery;
                return iHashCode3 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("SearchResults(gifs=");
                sbU.append(this.gifs);
                sbU.append(", suggested=");
                sbU.append(this.suggested);
                sbU.append(", trending=");
                sbU.append(this.trending);
                sbU.append(", searchQuery=");
                return outline.J(sbU, this.searchQuery, ")");
            }
        }

        /* JADX INFO: compiled from: GifSearchViewModel.kt */
        public static final /* data */ class TrendingSearchTermsResults extends StoreState {
            private final List<String> trending;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TrendingSearchTermsResults(List<String> list) {
                super(list, null);
                Intrinsics3.checkNotNullParameter(list, "trending");
                this.trending = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ TrendingSearchTermsResults copy$default(TrendingSearchTermsResults trendingSearchTermsResults, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = trendingSearchTermsResults.trending;
                }
                return trendingSearchTermsResults.copy(list);
            }

            public final List<String> component1() {
                return this.trending;
            }

            public final TrendingSearchTermsResults copy(List<String> trending) {
                Intrinsics3.checkNotNullParameter(trending, "trending");
                return new TrendingSearchTermsResults(trending);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof TrendingSearchTermsResults) && Intrinsics3.areEqual(this.trending, ((TrendingSearchTermsResults) other).trending);
                }
                return true;
            }

            public final List<String> getTrending() {
                return this.trending;
            }

            public int hashCode() {
                List<String> list = this.trending;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("TrendingSearchTermsResults(trending="), this.trending, ")");
            }
        }

        private StoreState(List<String> list) {
            this.trendingSearchTerms = list;
        }

        public final List<String> getTrendingSearchTerms() {
            return this.trendingSearchTerms;
        }

        public /* synthetic */ StoreState(List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(list);
        }
    }

    /* JADX INFO: compiled from: GifSearchViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GifSearchViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<GifAdapterItem> adapterItems;

            /* JADX INFO: renamed from: gifCount$delegate, reason: from kotlin metadata */
            private final Lazy gifCount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends GifAdapterItem> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "adapterItems");
                this.adapterItems = list;
                this.gifCount = LazyJVM.lazy(new GifSearchViewModel5(this));
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.adapterItems;
                }
                return loaded.copy(list);
            }

            public final List<GifAdapterItem> component1() {
                return this.adapterItems;
            }

            public final Loaded copy(List<? extends GifAdapterItem> adapterItems) {
                Intrinsics3.checkNotNullParameter(adapterItems, "adapterItems");
                return new Loaded(adapterItems);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.adapterItems, ((Loaded) other).adapterItems);
                }
                return true;
            }

            public final List<GifAdapterItem> getAdapterItems() {
                return this.adapterItems;
            }

            public final int getGifCount() {
                return ((Number) this.gifCount.getValue()).intValue();
            }

            public int hashCode() {
                List<GifAdapterItem> list = this.adapterItems;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(adapterItems="), this.adapterItems, ")");
            }
        }

        /* JADX INFO: compiled from: GifSearchViewModel.kt */
        public static final class LoadingSearchResults extends ViewState {
            public static final LoadingSearchResults INSTANCE = new LoadingSearchResults();

            private LoadingSearchResults() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GifSearchViewModel(Context context, BehaviorSubject behaviorSubject, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, MessageManager messageManager, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        BehaviorSubject behaviorSubjectL0;
        if ((i & 2) != 0) {
            behaviorSubjectL0 = BehaviorSubject.l0("");
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        } else {
            behaviorSubjectL0 = behaviorSubject;
        }
        StoreGifPicker gifPicker = (i & 4) != 0 ? StoreStream.INSTANCE.getGifPicker() : storeGifPicker;
        StoreAnalytics analytics = (i & 8) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        this(context, behaviorSubjectL0, gifPicker, analytics, (i & 16) != 0 ? new MessageManager(context, null, null, null, null, null, null, null, null, 510, null) : messageManager, (i & 32) != 0 ? INSTANCE.observeStoreState(behaviorSubjectL0, analytics, gifPicker) : observable);
    }

    private final void handleStoreState(StoreState storeState) {
        DiffKeyProvider suggestedTermsEmptyResults;
        ArrayList arrayList = new ArrayList();
        List<String> trendingSearchTerms = storeState.getTrendingSearchTerms();
        boolean z2 = storeState instanceof StoreState.SearchResults;
        if (z2) {
            StoreState.SearchResults searchResults = (StoreState.SearchResults) storeState;
            List<ModelGif> gifs = searchResults.getGifs();
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(gifs, 10));
            Iterator<T> it = gifs.iterator();
            while (it.hasNext()) {
                arrayList2.add(new GifAdapterItem.GifItem((ModelGif) it.next(), searchResults.getSearchQuery()));
            }
            arrayList.addAll(arrayList2);
            List<String> suggested = searchResults.getSuggested();
            boolean z3 = arrayList.size() > 0;
            boolean z4 = searchResults.getSuggested().size() > 0;
            String strN0 = this.searchSubject.n0();
            Intrinsics3.checkNotNullExpressionValue(strN0, "searchSubject.value");
            boolean z5 = strN0.length() > 0;
            if (z3) {
                suggestedTermsEmptyResults = new GifAdapterItem.SuggestedTermsItem.SuggestedTermsNonEmptyResults(suggested, R.string.gif_picker_related_search);
            } else if (!z5 || z4) {
                suggestedTermsEmptyResults = (z5 && z4) ? new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, R.string.no_gif_search_results_with_related_search) : new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, R.string.gif_picker_enter_search);
            } else {
                suggestedTermsEmptyResults = new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, R.string.no_gif_search_results_without_related_search);
            }
            arrayList.add(suggestedTermsEmptyResults);
        } else if (storeState instanceof StoreState.TrendingSearchTermsResults) {
            arrayList.add(new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(trendingSearchTerms, R.string.gif_picker_enter_search));
        }
        ViewState.Loaded loaded = new ViewState.Loaded(arrayList);
        if (z2) {
            this.storeAnalytics.trackSearchResultViewed(SearchType.GIF, loaded.getGifCount(), (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? false : false);
        }
        updateViewState(loaded);
    }

    public final void selectGif(GifAdapterItem.GifItem gifItem) {
        Intrinsics3.checkNotNullParameter(gifItem, "gifItem");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            StoreAnalytics.trackSearchResultSelected$default(this.storeAnalytics, SearchType.GIF, loaded.getGifCount(), null, new Traits.Source(null, null, Traits.Source.Obj.GIF_PICKER, null, null, 27, null), 4, null);
        }
        MessageManager messageManager = this.messageManager;
        messageManager.sendMessage((510 & 1) != 0 ? "" : gifItem.getGif().getTenorGifUrl(), (510 & 2) != 0 ? null : null, (510 & 4) != 0 ? null : null, (510 & 8) != 0 ? null : null, (510 & 16) != 0 ? Collections2.emptyList() : null, (510 & 32) != 0, (510 & 64) != 0 ? null : null, (510 & 128) == 0 ? null : null, (510 & 256) != 0 ? messageManager.defaultMessageResultHandler : null);
    }

    public final void setSearchText(String searchText) {
        Intrinsics3.checkNotNullParameter(searchText, "searchText");
        if (!Intrinsics3.areEqual(this.searchSubject.n0(), searchText)) {
            if (searchText.length() > 0) {
                updateViewState(ViewState.LoadingSearchResults.INSTANCE);
            }
        }
        this.searchSubject.onNext(searchText);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifSearchViewModel(Context context, BehaviorSubject<String> behaviorSubject, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, MessageManager messageManager, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(behaviorSubject, "searchSubject");
        Intrinsics3.checkNotNullParameter(storeGifPicker, "storeGifPicker");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.searchSubject = behaviorSubject;
        this.storeGifPicker = storeGifPicker;
        this.storeAnalytics = storeAnalytics;
        this.messageManager = messageManager;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) GifSearchViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
