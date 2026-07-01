package com.discord.stores;

import android.content.Context;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.models.gifpicker.dto.GifCategoryDto;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.models.gifpicker.dto.TrendingGifCategoriesResponseDto;
import com.discord.models.gifpicker.dto.TrendingGifPreviewDto;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.t.h0;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker extends StoreV2 {
    public static final StoreGifPicker$Companion Companion = new StoreGifPicker$Companion(null);
    private static final List<ModelGif> searchResultsLoadingList = n.emptyList();
    private static final List<String> searchTermsLoadingList = n.emptyList();
    private final Dispatcher dispatcher;
    private final List<ModelGifCategory> gifCategories;
    private List<ModelGifCategory> gifCategoriesSnapshot;
    private final StoreGifPicker$CacheHistory<String, List<ModelGif>> gifSearchHistory;
    private Map<String, ? extends List<ModelGif>> gifSearchHistorySnapshot;
    private final StoreGifPicker$CacheHistory<String, List<String>> gifSuggestedSearchTermsHistory;
    private final List<String> gifTrendingSearchTerms;
    private List<String> gifTrendingSearchTermsSnapshot;
    private boolean isFetchingGifCategories;
    private boolean isFetchingTrendingCategoryGifs;
    private boolean isFetchingTrendingSearchTerms;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final StoreUserSettingsSystem storeUserSettingsSystem;
    private Map<String, ? extends List<String>> suggestedSearchTermsSnapshot;
    private final List<ModelGif> trendingCategoryGifs;
    private List<ModelGif> trendingCategoryGifsSnapshot;
    private String trendingGifCategoryPreviewUrl;

    public /* synthetic */ StoreGifPicker(Dispatcher dispatcher, StoreUserSettingsSystem storeUserSettingsSystem, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUserSettingsSystem, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 8) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ void access$fetchGifTrendingSearchTerms(StoreGifPicker storeGifPicker) {
        storeGifPicker.fetchGifTrendingSearchTerms();
    }

    public static final /* synthetic */ void access$fetchGifsForSearchQuery(StoreGifPicker storeGifPicker, String str) {
        storeGifPicker.fetchGifsForSearchQuery(str);
    }

    public static final /* synthetic */ void access$fetchSuggestedSearchTerms(StoreGifPicker storeGifPicker, String str) {
        storeGifPicker.fetchSuggestedSearchTerms(str);
    }

    public static final /* synthetic */ void access$fetchTrendingCategoryGifs(StoreGifPicker storeGifPicker) {
        storeGifPicker.fetchTrendingCategoryGifs();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.dispatcher;
    }

    public static final /* synthetic */ List access$getGifCategories(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getGifCategories();
    }

    public static final /* synthetic */ List access$getGifCategories$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.gifCategories;
    }

    public static final /* synthetic */ StoreGifPicker$CacheHistory access$getGifSearchHistory$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.gifSearchHistory;
    }

    public static final /* synthetic */ StoreGifPicker$CacheHistory access$getGifSuggestedSearchTermsHistory$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.gifSuggestedSearchTermsHistory;
    }

    public static final /* synthetic */ List access$getGifTrendingSearchTerms(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getGifTrendingSearchTerms();
    }

    public static final /* synthetic */ List access$getGifTrendingSearchTerms$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.gifTrendingSearchTerms;
    }

    public static final /* synthetic */ Map access$getSearchHistory(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getSearchHistory();
    }

    public static final /* synthetic */ List access$getSearchResultsLoadingList$cp() {
        return searchResultsLoadingList;
    }

    public static final /* synthetic */ List access$getSearchTermsLoadingList$cp() {
        return searchTermsLoadingList;
    }

    public static final /* synthetic */ Map access$getSuggestedSearchTermsHistory(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getSuggestedSearchTermsHistory();
    }

    public static final /* synthetic */ List access$getTrendingCategoryGifs(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getTrendingCategoryGifs();
    }

    public static final /* synthetic */ List access$getTrendingCategoryGifs$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.trendingCategoryGifs;
    }

    public static final /* synthetic */ String access$getTrendingGifCategoryPreviewUrl(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getTrendingGifCategoryPreviewUrl();
    }

    public static final /* synthetic */ void access$handleFetchGifCategoriesError(StoreGifPicker storeGifPicker) {
        storeGifPicker.handleFetchGifCategoriesError();
    }

    public static final /* synthetic */ void access$handleFetchGifCategoriesOnNext(StoreGifPicker storeGifPicker, TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
        storeGifPicker.handleFetchGifCategoriesOnNext(trendingGifCategoriesResponseDto);
    }

    public static final /* synthetic */ void access$handleFetchTrendingGifsError(StoreGifPicker storeGifPicker) {
        storeGifPicker.handleFetchTrendingGifsError();
    }

    public static final /* synthetic */ void access$handleFetchTrendingGifsOnNext(StoreGifPicker storeGifPicker, List list) {
        storeGifPicker.handleFetchTrendingGifsOnNext(list);
    }

    public static final /* synthetic */ void access$handleFetchTrendingSearchTermsError(StoreGifPicker storeGifPicker) {
        storeGifPicker.handleFetchTrendingSearchTermsError();
    }

    public static final /* synthetic */ void access$handleFetchTrendingSearchTermsOnNext(StoreGifPicker storeGifPicker, List list) {
        storeGifPicker.handleFetchTrendingSearchTermsOnNext(list);
    }

    public static final /* synthetic */ void access$handleGifSearchResults(StoreGifPicker storeGifPicker, String str, List list) {
        storeGifPicker.handleGifSearchResults(str, list);
    }

    public static final /* synthetic */ void access$handleSuggestedSearchTerms(StoreGifPicker storeGifPicker, String str, List list) {
        storeGifPicker.handleSuggestedSearchTerms(str, list);
    }

    public static final /* synthetic */ void access$handleTrendingCategoriesResponse(StoreGifPicker storeGifPicker, TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
        storeGifPicker.handleTrendingCategoriesResponse(trendingGifCategoriesResponseDto);
    }

    public static final /* synthetic */ boolean access$isFetchingGifCategories$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.isFetchingGifCategories;
    }

    public static final /* synthetic */ boolean access$isFetchingTrendingCategoryGifs$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.isFetchingTrendingCategoryGifs;
    }

    public static final /* synthetic */ boolean access$isFetchingTrendingSearchTerms$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.isFetchingTrendingSearchTerms;
    }

    public static final /* synthetic */ void access$setFetchingGifCategories$p(StoreGifPicker storeGifPicker, boolean z2) {
        storeGifPicker.isFetchingGifCategories = z2;
    }

    public static final /* synthetic */ void access$setFetchingTrendingCategoryGifs$p(StoreGifPicker storeGifPicker, boolean z2) {
        storeGifPicker.isFetchingTrendingCategoryGifs = z2;
    }

    public static final /* synthetic */ void access$setFetchingTrendingSearchTerms$p(StoreGifPicker storeGifPicker, boolean z2) {
        storeGifPicker.isFetchingTrendingSearchTerms = z2;
    }

    public static final /* synthetic */ void access$updateTrendingCategoryGifs(StoreGifPicker storeGifPicker, List list) {
        storeGifPicker.updateTrendingCategoryGifs(list);
    }

    public static final /* synthetic */ void access$updateTrendingSearchTerms(StoreGifPicker storeGifPicker, List list) {
        storeGifPicker.updateTrendingSearchTerms(list);
    }

    private final void fetchGifTrendingSearchTerms() {
        this.isFetchingTrendingSearchTerms = true;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGifTrendingSearchTerms("tenor", this.storeUserSettingsSystem.getLocale(), 5), false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new StoreGifPicker$fetchGifTrendingSearchTerms$1(this), (Function0) null, (Function0) null, new StoreGifPicker$fetchGifTrendingSearchTerms$2(this), 54, (Object) null);
    }

    private final void fetchGifsForSearchQuery(String query) {
        Observable<R> observableG = this.restAPI.getGifSearchResults(query, "tenor", this.storeUserSettingsSystem.getLocale(), "tinygif", 50).G(StoreGifPicker$fetchGifsForSearchQuery$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "restAPI.getGifSearchResu…to)\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observableG, false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new StoreGifPicker$fetchGifsForSearchQuery$2(this, query), (Function0) null, (Function0) null, new StoreGifPicker$fetchGifsForSearchQuery$3(this, query), 54, (Object) null);
    }

    private final void fetchSuggestedSearchTerms(String query) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGifSuggestedSearchTerms("tenor", query, this.storeUserSettingsSystem.getLocale(), 5), false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new StoreGifPicker$fetchSuggestedSearchTerms$1(this, query), (Function0) null, (Function0) null, new StoreGifPicker$fetchSuggestedSearchTerms$2(this, query), 54, (Object) null);
    }

    private final void fetchTrendingCategoryGifs() {
        this.isFetchingTrendingCategoryGifs = true;
        Observable<R> observableG = this.restAPI.getTrendingGifCategory("tenor", this.storeUserSettingsSystem.getLocale(), "tinygif", 50).G(StoreGifPicker$fetchTrendingCategoryGifs$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "restAPI.getTrendingGifCa…to)\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observableG, false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new StoreGifPicker$fetchTrendingCategoryGifs$2(this), (Function0) null, (Function0) null, new StoreGifPicker$fetchTrendingCategoryGifs$3(this), 54, (Object) null);
    }

    private final List<ModelGifCategory> getGifCategories() {
        return this.gifCategoriesSnapshot;
    }

    private final List<String> getGifTrendingSearchTerms() {
        return this.gifTrendingSearchTermsSnapshot;
    }

    private final Map<String, List<ModelGif>> getSearchHistory() {
        return this.gifSearchHistorySnapshot;
    }

    private final Map<String, List<String>> getSuggestedSearchTermsHistory() {
        return this.gifSuggestedSearchTermsHistory;
    }

    private final List<ModelGif> getTrendingCategoryGifs() {
        return this.trendingCategoryGifsSnapshot;
    }

    private final String getTrendingGifCategoryPreviewUrl() {
        return this.trendingGifCategoryPreviewUrl;
    }

    private final void handleFetchGifCategoriesError() {
        this.dispatcher.schedule(new StoreGifPicker$handleFetchGifCategoriesError$1(this));
    }

    private final void handleFetchGifCategoriesOnNext(TrendingGifCategoriesResponseDto trendingGifsResponseRaw) {
        this.dispatcher.schedule(new StoreGifPicker$handleFetchGifCategoriesOnNext$1(this, trendingGifsResponseRaw));
    }

    private final void handleFetchTrendingGifsError() {
        this.dispatcher.schedule(new StoreGifPicker$handleFetchTrendingGifsError$1(this));
    }

    private final void handleFetchTrendingGifsOnNext(List<ModelGif> gifs) {
        this.dispatcher.schedule(new StoreGifPicker$handleFetchTrendingGifsOnNext$1(this, gifs));
    }

    private final void handleFetchTrendingSearchTermsError() {
        this.dispatcher.schedule(new StoreGifPicker$handleFetchTrendingSearchTermsError$1(this));
    }

    private final void handleFetchTrendingSearchTermsOnNext(List<String> trendingSearchTerms) {
        this.dispatcher.schedule(new StoreGifPicker$handleFetchTrendingSearchTermsOnNext$1(this, trendingSearchTerms));
    }

    @StoreThread
    private final void handleGifSearchResults(String query, List<ModelGif> gifs) {
        this.gifSearchHistory.put(query, gifs);
        markChanged();
    }

    @StoreThread
    private final void handleSuggestedSearchTerms(String query, List<String> suggestedSearchTerms) {
        this.gifSuggestedSearchTermsHistory.put(query, suggestedSearchTerms);
        markChanged();
    }

    @StoreThread
    private final void handleTrendingCategoriesResponse(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
        List<GifCategoryDto> categories = trendingGifCategoriesResponseDto.getCategories();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(categories, 10));
        for (GifCategoryDto gifCategoryDto : categories) {
            arrayList.add(new ModelGifCategory(gifCategoryDto.getName(), gifCategoryDto.getSrc()));
        }
        updateGifCategories(arrayList);
        List<TrendingGifPreviewDto> gifs = trendingGifCategoriesResponseDto.getGifs();
        this.trendingGifCategoryPreviewUrl = gifs.isEmpty() ^ true ? gifs.get(0).getSrc() : "";
        markChanged();
    }

    private final Observable<Map<String, List<ModelGif>>> observeSearchHistory() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, true, null, null, new StoreGifPicker$observeSearchHistory$1(this), 12, null);
    }

    private final Observable<Map<String, List<String>>> observeSuggestedSearchTerms() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, true, null, null, new StoreGifPicker$observeSuggestedSearchTerms$1(this), 12, null);
    }

    @StoreThread
    private final void updateGifCategories(List<ModelGifCategory> categories) {
        this.gifCategories.clear();
        this.gifCategories.addAll(categories);
        markChanged();
    }

    @StoreThread
    private final void updateTrendingCategoryGifs(List<ModelGif> gifs) {
        this.trendingCategoryGifs.clear();
        this.trendingCategoryGifs.addAll(gifs);
        markChanged();
    }

    @StoreThread
    private final void updateTrendingSearchTerms(List<String> trendingGifSearchTerms) {
        this.gifTrendingSearchTerms.clear();
        this.gifTrendingSearchTerms.addAll(trendingGifSearchTerms);
        markChanged();
    }

    public final void fetchGifCategories() {
        this.isFetchingGifCategories = true;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getTrendingGifCategories("tenor", this.storeUserSettingsSystem.getLocale(), "tinygif"), false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new StoreGifPicker$fetchGifCategories$1(this), (Function0) null, (Function0) null, new StoreGifPicker$fetchGifCategories$2(this), 54, (Object) null);
    }

    public final Observable<List<ModelGifCategory>> observeGifCategories() {
        this.dispatcher.schedule(new StoreGifPicker$observeGifCategories$1(this));
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, true, null, null, new StoreGifPicker$observeGifCategories$2(this), 12, null);
    }

    public final Observable<List<String>> observeGifTrendingSearchTerms() {
        this.dispatcher.schedule(new StoreGifPicker$observeGifTrendingSearchTerms$1(this));
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, true, null, null, new StoreGifPicker$observeGifTrendingSearchTerms$2(this), 12, null);
    }

    public final Observable<List<ModelGif>> observeGifsForSearchQuery(String query) {
        m.checkNotNullParameter(query, "query");
        this.dispatcher.schedule(new StoreGifPicker$observeGifsForSearchQuery$1(this, query));
        Observable<R> observableG = observeSearchHistory().G(new StoreGifPicker$observeGifsForSearchQuery$2(query));
        m.checkNotNullExpressionValue(observableG, "observeSearchHistory().m…gifSearchHistory[query] }");
        Observable<List<ModelGif>> observableG2 = observableG.y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG2, "filter { it != null }.map { it!! }");
        return observableG2;
    }

    public final Observable<List<ModelGif>> observeTrendingCategoryGifs() {
        this.dispatcher.schedule(new StoreGifPicker$observeTrendingCategoryGifs$1(this));
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, true, null, null, new StoreGifPicker$observeTrendingCategoryGifs$2(this), 12, null);
    }

    public final Observable<String> observeTrendingGifCategoryPreviewUrl() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, true, null, null, new StoreGifPicker$observeTrendingGifCategoryPreviewUrl$1(this), 12, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.gifCategoriesSnapshot = new ArrayList(this.gifCategories);
        this.gifTrendingSearchTermsSnapshot = new ArrayList(this.gifTrendingSearchTerms);
        this.gifSearchHistorySnapshot = new HashMap(this.gifSearchHistory);
        this.suggestedSearchTermsSnapshot = new HashMap(this.gifSuggestedSearchTermsHistory);
        this.trendingCategoryGifsSnapshot = new ArrayList(this.trendingCategoryGifs);
    }

    public final Observable<List<String>> observeSuggestedSearchTerms(String query) {
        m.checkNotNullParameter(query, "query");
        this.dispatcher.schedule(new StoreGifPicker$observeSuggestedSearchTerms$2(this, query));
        Observable<R> observableG = observeSuggestedSearchTerms().G(new StoreGifPicker$observeSuggestedSearchTerms$3(query));
        m.checkNotNullExpressionValue(observableG, "observeSuggestedSearchTe…archTermsHistory[query] }");
        Observable<List<String>> observableG2 = observableG.y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG2, "filter { it != null }.map { it!! }");
        return observableG2;
    }

    public StoreGifPicker(Dispatcher dispatcher, StoreUserSettingsSystem storeUserSettingsSystem, RestAPI restAPI, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeUserSettingsSystem, "storeUserSettingsSystem");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeUserSettingsSystem = storeUserSettingsSystem;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.gifCategoriesSnapshot = n.emptyList();
        this.gifTrendingSearchTermsSnapshot = n.emptyList();
        this.gifSearchHistorySnapshot = h0.emptyMap();
        this.suggestedSearchTermsSnapshot = h0.emptyMap();
        this.trendingCategoryGifsSnapshot = n.emptyList();
        this.gifCategories = new ArrayList();
        this.gifTrendingSearchTerms = new ArrayList();
        this.trendingCategoryGifs = new ArrayList();
        this.trendingGifCategoryPreviewUrl = "";
        this.gifSearchHistory = new StoreGifPicker$CacheHistory<>();
        this.gifSuggestedSearchTermsHistory = new StoreGifPicker$CacheHistory<>();
    }
}
