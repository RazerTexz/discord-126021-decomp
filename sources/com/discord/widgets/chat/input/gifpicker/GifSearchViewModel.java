package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import com.discord.C5419R;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreGifPicker;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.LeadingEdgeThrottle;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.widgets.chat.MessageManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12666r;
import p637j0.p642l.p647e.C12721k;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifSearchViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MessageManager messageManager;
    private final BehaviorSubject<String> searchSubject;
    private final StoreAnalytics storeAnalytics;
    private final StoreGifPicker storeGifPicker;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$1 */
    /* JADX INFO: compiled from: GifSearchViewModel.kt */
    public static final class C78711 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C78711() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            GifSearchViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GifSearchViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeQueryState(BehaviorSubject<String> searchSubject, final StoreAnalytics storeAnalytics, final StoreGifPicker storeGifPicker, final List<String> trendingSearchTerms) {
            Observable<String> observableM11112r = searchSubject.m11084J(C12781a.m10875c()).m11112r();
            Observable<StoreState> observableM11099Y = Observable.m11074h0(new C12666r(observableM11112r.f27640j, new LeadingEdgeThrottle(1000L, TimeUnit.MILLISECONDS, C12781a.m10875c()))).m11115u(new Action1<String>() { // from class: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$1
                @Override // p658rx.functions.Action1
                public final void call(String str) {
                    StoreAnalytics.trackSearchStarted$default(storeAnalytics, SearchType.GIF, null, false, 6, null);
                }
            }).m11099Y(new InterfaceC12589b<String, Observable<? extends StoreState>>() { // from class: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends GifSearchViewModel.StoreState> call(final String str) {
                    C12238m.checkNotNullExpressionValue(str, "query");
                    return str.length() == 0 ? new C12721k(new GifSearchViewModel.StoreState.TrendingSearchTermsResults(trendingSearchTerms)) : Observable.m11076j(storeGifPicker.observeGifsForSearchQuery(str).m11118y(new InterfaceC12589b<List<? extends ModelGif>, Boolean>() { // from class: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2.1
                        @Override // p637j0.p641k.InterfaceC12589b
                        public /* bridge */ /* synthetic */ Boolean call(List<? extends ModelGif> list) {
                            return call2((List<ModelGif>) list);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final Boolean call2(List<ModelGif> list) {
                            return Boolean.valueOf(list != StoreGifPicker.INSTANCE.getSearchResultsLoadingList());
                        }
                    }), storeGifPicker.observeSuggestedSearchTerms(str), new Func2<List<? extends ModelGif>, List<? extends String>, GifSearchViewModel.StoreState.SearchResults>() { // from class: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2.2
                        @Override // p658rx.functions.Func2
                        public /* bridge */ /* synthetic */ GifSearchViewModel.StoreState.SearchResults call(List<? extends ModelGif> list, List<? extends String> list2) {
                            return call2((List<ModelGif>) list, (List<String>) list2);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final GifSearchViewModel.StoreState.SearchResults call2(List<ModelGif> list, List<String> list2) {
                            C12238m.checkNotNullExpressionValue(list, "gifResults");
                            C12238m.checkNotNullExpressionValue(list2, "searchTerms");
                            return new GifSearchViewModel.StoreState.SearchResults(list, list2, trendingSearchTerms, str);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "searchSubject\n          …          }\n            }");
            return observableM11099Y;
        }

        private final Observable<StoreState> observeStoreState(final BehaviorSubject<String> searchSubject, final StoreAnalytics storeAnalytics, final StoreGifPicker storeGifPicker) {
            Observable observableM11099Y = storeGifPicker.observeGifTrendingSearchTerms().m11099Y(new InterfaceC12589b<List<? extends String>, Observable<? extends StoreState>>() { // from class: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ Observable<? extends GifSearchViewModel.StoreState> call(List<? extends String> list) {
                    return call2((List<String>) list);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends GifSearchViewModel.StoreState> call2(List<String> list) {
                    GifSearchViewModel.Companion companion = GifSearchViewModel.INSTANCE;
                    BehaviorSubject behaviorSubject = searchSubject;
                    StoreAnalytics storeAnalytics2 = storeAnalytics;
                    StoreGifPicker storeGifPicker2 = storeGifPicker;
                    C12238m.checkNotNullExpressionValue(list, "terms");
                    return companion.observeQueryState(behaviorSubject, storeAnalytics2, storeGifPicker2, list);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "storeGifPicker.observeGi…fPicker, terms)\n        }");
            return observableM11099Y;
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
                C12238m.checkNotNullParameter(list, "gifs");
                C12238m.checkNotNullParameter(list2, "suggested");
                C12238m.checkNotNullParameter(list3, "trending");
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
                C12238m.checkNotNullParameter(gifs, "gifs");
                C12238m.checkNotNullParameter(suggested, "suggested");
                C12238m.checkNotNullParameter(trending, "trending");
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
                return C12238m.areEqual(this.gifs, searchResults.gifs) && C12238m.areEqual(this.suggested, searchResults.suggested) && C12238m.areEqual(this.trending, searchResults.trending) && C12238m.areEqual(this.searchQuery, searchResults.searchQuery);
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
                StringBuilder sbM833U = C1643a.m833U("SearchResults(gifs=");
                sbM833U.append(this.gifs);
                sbM833U.append(", suggested=");
                sbM833U.append(this.suggested);
                sbM833U.append(", trending=");
                sbM833U.append(this.trending);
                sbM833U.append(", searchQuery=");
                return C1643a.m822J(sbM833U, this.searchQuery, ")");
            }
        }

        /* JADX INFO: compiled from: GifSearchViewModel.kt */
        public static final /* data */ class TrendingSearchTermsResults extends StoreState {
            private final List<String> trending;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TrendingSearchTermsResults(List<String> list) {
                super(list, null);
                C12238m.checkNotNullParameter(list, "trending");
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
                C12238m.checkNotNullParameter(trending, "trending");
                return new TrendingSearchTermsResults(trending);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof TrendingSearchTermsResults) && C12238m.areEqual(this.trending, ((TrendingSearchTermsResults) other).trending);
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
                return C1643a.m824L(C1643a.m833U("TrendingSearchTermsResults(trending="), this.trending, ")");
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
                C12238m.checkNotNullParameter(list, "adapterItems");
                this.adapterItems = list;
                this.gifCount = C12083g.lazy(new GifSearchViewModel$ViewState$Loaded$gifCount$2(this));
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
                C12238m.checkNotNullParameter(adapterItems, "adapterItems");
                return new Loaded(adapterItems);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.adapterItems, ((Loaded) other).adapterItems);
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
                return C1643a.m824L(C1643a.m833U("Loaded(adapterItems="), this.adapterItems, ")");
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
        BehaviorSubject behaviorSubjectM11130l0;
        if ((i & 2) != 0) {
            behaviorSubjectM11130l0 = BehaviorSubject.m11130l0("");
            C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(\"\")");
        } else {
            behaviorSubjectM11130l0 = behaviorSubject;
        }
        StoreGifPicker gifPicker = (i & 4) != 0 ? StoreStream.INSTANCE.getGifPicker() : storeGifPicker;
        StoreAnalytics analytics = (i & 8) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        this(context, behaviorSubjectM11130l0, gifPicker, analytics, (i & 16) != 0 ? new MessageManager(context, null, null, null, null, null, null, null, null, 510, null) : messageManager, (i & 32) != 0 ? INSTANCE.observeStoreState(behaviorSubjectM11130l0, analytics, gifPicker) : observable);
    }

    private final void handleStoreState(StoreState storeState) {
        DiffKeyProvider suggestedTermsEmptyResults;
        ArrayList arrayList = new ArrayList();
        List<String> trendingSearchTerms = storeState.getTrendingSearchTerms();
        boolean z2 = storeState instanceof StoreState.SearchResults;
        if (z2) {
            StoreState.SearchResults searchResults = (StoreState.SearchResults) storeState;
            List<ModelGif> gifs = searchResults.getGifs();
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(gifs, 10));
            Iterator<T> it = gifs.iterator();
            while (it.hasNext()) {
                arrayList2.add(new GifAdapterItem.GifItem((ModelGif) it.next(), searchResults.getSearchQuery()));
            }
            arrayList.addAll(arrayList2);
            List<String> suggested = searchResults.getSuggested();
            boolean z3 = arrayList.size() > 0;
            boolean z4 = searchResults.getSuggested().size() > 0;
            String strM11132n0 = this.searchSubject.m11132n0();
            C12238m.checkNotNullExpressionValue(strM11132n0, "searchSubject.value");
            boolean z5 = strM11132n0.length() > 0;
            if (z3) {
                suggestedTermsEmptyResults = new GifAdapterItem.SuggestedTermsItem.SuggestedTermsNonEmptyResults(suggested, C5419R.string.gif_picker_related_search);
            } else if (!z5 || z4) {
                suggestedTermsEmptyResults = (z5 && z4) ? new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, C5419R.string.no_gif_search_results_with_related_search) : new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, C5419R.string.gif_picker_enter_search);
            } else {
                suggestedTermsEmptyResults = new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, C5419R.string.no_gif_search_results_without_related_search);
            }
            arrayList.add(suggestedTermsEmptyResults);
        } else if (storeState instanceof StoreState.TrendingSearchTermsResults) {
            arrayList.add(new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(trendingSearchTerms, C5419R.string.gif_picker_enter_search));
        }
        ViewState.Loaded loaded = new ViewState.Loaded(arrayList);
        if (z2) {
            this.storeAnalytics.trackSearchResultViewed(SearchType.GIF, loaded.getGifCount(), (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? false : false);
        }
        updateViewState(loaded);
    }

    public final void selectGif(GifAdapterItem.GifItem gifItem) {
        C12238m.checkNotNullParameter(gifItem, "gifItem");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            StoreAnalytics.trackSearchResultSelected$default(this.storeAnalytics, SearchType.GIF, loaded.getGifCount(), null, new Traits.Source(null, null, Traits.Source.Obj.GIF_PICKER, null, null, 27, null), 4, null);
        }
        MessageManager messageManager = this.messageManager;
        messageManager.sendMessage((510 & 1) != 0 ? "" : gifItem.getGif().getTenorGifUrl(), (510 & 2) != 0 ? null : null, (510 & 4) != 0 ? null : null, (510 & 8) != 0 ? null : null, (510 & 16) != 0 ? C12147n.emptyList() : null, (510 & 32) != 0, (510 & 64) != 0 ? null : null, (510 & 128) == 0 ? null : null, (510 & 256) != 0 ? messageManager.defaultMessageResultHandler : null);
    }

    public final void setSearchText(String searchText) {
        C12238m.checkNotNullParameter(searchText, "searchText");
        if (!C12238m.areEqual(this.searchSubject.m11132n0(), searchText)) {
            if (searchText.length() > 0) {
                updateViewState(ViewState.LoadingSearchResults.INSTANCE);
            }
        }
        this.searchSubject.onNext(searchText);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifSearchViewModel(Context context, BehaviorSubject<String> behaviorSubject, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, MessageManager messageManager, Observable<StoreState> observable) {
        super(null);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(behaviorSubject, "searchSubject");
        C12238m.checkNotNullParameter(storeGifPicker, "storeGifPicker");
        C12238m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        C12238m.checkNotNullParameter(messageManager, "messageManager");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.searchSubject = behaviorSubject;
        this.storeGifPicker = storeGifPicker;
        this.storeAnalytics = storeAnalytics;
        this.messageManager = messageManager;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) GifSearchViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C78711());
    }
}
