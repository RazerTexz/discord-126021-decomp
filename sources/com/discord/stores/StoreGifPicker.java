package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.models.gifpicker.dto.GifCategoryDto;
import com.discord.models.gifpicker.dto.GifDto;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.models.gifpicker.dto.TrendingGifCategoriesResponseDto;
import com.discord.models.gifpicker.dto.TrendingGifPreviewDto;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker extends StoreV2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<ModelGif> searchResultsLoadingList = C12147n.emptyList();
    private static final List<String> searchTermsLoadingList = C12147n.emptyList();
    private final Dispatcher dispatcher;
    private final List<ModelGifCategory> gifCategories;
    private List<ModelGifCategory> gifCategoriesSnapshot;
    private final CacheHistory<String, List<ModelGif>> gifSearchHistory;
    private Map<String, ? extends List<ModelGif>> gifSearchHistorySnapshot;
    private final CacheHistory<String, List<String>> gifSuggestedSearchTermsHistory;
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

    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class CacheHistory<K, V> extends LinkedHashMap<K, V> {
        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
            return getEntries();
        }

        public /* bridge */ Set getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set getKeys() {
            return super.keySet();
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<K> keySet() {
            return getKeys();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > 20;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<V> values() {
            return getValues();
        }
    }

    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class Companion {
        private Companion() {
        }

        public final List<ModelGif> getSearchResultsLoadingList() {
            return StoreGifPicker.searchResultsLoadingList;
        }

        public final List<String> getSearchTermsLoadingList() {
            return StoreGifPicker.searchTermsLoadingList;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifCategories$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59561 extends AbstractC12240o implements Function1<Error, Unit> {
        public C59561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreGifPicker.this.handleFetchGifCategoriesError();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifCategories$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final /* synthetic */ class C59572 extends C12236k implements Function1<TrendingGifCategoriesResponseDto, Unit> {
        public C59572(StoreGifPicker storeGifPicker) {
            super(1, storeGifPicker, StoreGifPicker.class, "handleFetchGifCategoriesOnNext", "handleFetchGifCategoriesOnNext(Lcom/discord/models/gifpicker/dto/TrendingGifCategoriesResponseDto;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
            invoke2(trendingGifCategoriesResponseDto);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
            C12238m.checkNotNullParameter(trendingGifCategoriesResponseDto, "p1");
            ((StoreGifPicker) this.receiver).handleFetchGifCategoriesOnNext(trendingGifCategoriesResponseDto);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifTrendingSearchTerms$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59581 extends AbstractC12240o implements Function1<Error, Unit> {
        public C59581() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreGifPicker.this.handleFetchTrendingSearchTermsError();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifTrendingSearchTerms$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final /* synthetic */ class C59592 extends C12236k implements Function1<List<? extends String>, Unit> {
        public C59592(StoreGifPicker storeGifPicker) {
            super(1, storeGifPicker, StoreGifPicker.class, "handleFetchTrendingSearchTermsOnNext", "handleFetchTrendingSearchTermsOnNext(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> list) {
            C12238m.checkNotNullParameter(list, "p1");
            ((StoreGifPicker) this.receiver).handleFetchTrendingSearchTermsOnNext(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59612 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ String $query;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifPicker.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C59612 c59612 = C59612.this;
                StoreGifPicker.this.handleGifSearchResults(c59612.$query, C12147n.emptyList());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59612(String str) {
            super(1);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreGifPicker.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$3 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59623 extends AbstractC12240o implements Function1<List<? extends ModelGif>, Unit> {
        public final /* synthetic */ String $query;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifPicker.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $gifs;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$gifs = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C59623 c59623 = C59623.this;
                StoreGifPicker storeGifPicker = StoreGifPicker.this;
                String str = c59623.$query;
                List list = this.$gifs;
                C12238m.checkNotNullExpressionValue(list, "gifs");
                storeGifPicker.handleGifSearchResults(str, list);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59623(String str) {
            super(1);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGif> list) {
            invoke2((List<ModelGif>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGif> list) {
            StoreGifPicker.this.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchSuggestedSearchTerms$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59631 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ String $query;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchSuggestedSearchTerms$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifPicker.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C59631 c59631 = C59631.this;
                StoreGifPicker.this.handleSuggestedSearchTerms(c59631.$query, C12147n.emptyList());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59631(String str) {
            super(1);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreGifPicker.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchSuggestedSearchTerms$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59642 extends AbstractC12240o implements Function1<List<? extends String>, Unit> {
        public final /* synthetic */ String $query;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchSuggestedSearchTerms$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifPicker.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $suggestedSearchTerms;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$suggestedSearchTerms = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C59642 c59642 = C59642.this;
                StoreGifPicker.this.handleSuggestedSearchTerms(c59642.$query, this.$suggestedSearchTerms);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59642(String str) {
            super(1);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> list) {
            C12238m.checkNotNullParameter(list, "suggestedSearchTerms");
            StoreGifPicker.this.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchTrendingCategoryGifs$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59662 extends AbstractC12240o implements Function1<Error, Unit> {
        public C59662() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreGifPicker.this.handleFetchTrendingGifsError();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchTrendingCategoryGifs$3 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final /* synthetic */ class C59673 extends C12236k implements Function1<List<? extends ModelGif>, Unit> {
        public C59673(StoreGifPicker storeGifPicker) {
            super(1, storeGifPicker, StoreGifPicker.class, "handleFetchTrendingGifsOnNext", "handleFetchTrendingGifsOnNext(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGif> list) {
            invoke2((List<ModelGif>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGif> list) {
            C12238m.checkNotNullParameter(list, "p1");
            ((StoreGifPicker) this.receiver).handleFetchTrendingGifsOnNext(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$handleFetchGifCategoriesError$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59681 extends AbstractC12240o implements Function0<Unit> {
        public C59681() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.this.isFetchingGifCategories = false;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$handleFetchGifCategoriesOnNext$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59691 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ TrendingGifCategoriesResponseDto $trendingGifsResponseRaw;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59691(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
            super(0);
            this.$trendingGifsResponseRaw = trendingGifCategoriesResponseDto;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.this.handleTrendingCategoriesResponse(this.$trendingGifsResponseRaw);
            StoreGifPicker.this.isFetchingGifCategories = false;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$handleFetchTrendingGifsError$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59701 extends AbstractC12240o implements Function0<Unit> {
        public C59701() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.this.isFetchingTrendingCategoryGifs = false;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$handleFetchTrendingGifsOnNext$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59711 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ List $gifs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59711(List list) {
            super(0);
            this.$gifs = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.this.updateTrendingCategoryGifs(this.$gifs);
            StoreGifPicker.this.isFetchingTrendingCategoryGifs = false;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$handleFetchTrendingSearchTermsError$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59721 extends AbstractC12240o implements Function0<Unit> {
        public C59721() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.this.isFetchingTrendingSearchTerms = false;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$handleFetchTrendingSearchTermsOnNext$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59731 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ List $trendingSearchTerms;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59731(List list) {
            super(0);
            this.$trendingSearchTerms = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.this.updateTrendingSearchTerms(this.$trendingSearchTerms);
            StoreGifPicker.this.isFetchingTrendingSearchTerms = false;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeGifCategories$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59741 extends AbstractC12240o implements Function0<Unit> {
        public C59741() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreGifPicker.this.gifCategories.isEmpty() || StoreGifPicker.this.isFetchingGifCategories) {
                return;
            }
            StoreGifPicker.this.fetchGifCategories();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeGifCategories$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59752 extends AbstractC12240o implements Function0<List<? extends ModelGifCategory>> {
        public C59752() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends ModelGifCategory> invoke() {
            return StoreGifPicker.this.getGifCategories();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeGifTrendingSearchTerms$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59761 extends AbstractC12240o implements Function0<Unit> {
        public C59761() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreGifPicker.this.gifTrendingSearchTerms.isEmpty() || StoreGifPicker.this.isFetchingTrendingSearchTerms) {
                return;
            }
            StoreGifPicker.this.fetchGifTrendingSearchTerms();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeGifTrendingSearchTerms$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59772 extends AbstractC12240o implements Function0<List<? extends String>> {
        public C59772() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends String> invoke() {
            return StoreGifPicker.this.getGifTrendingSearchTerms();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeGifsForSearchQuery$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59781 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59781(String str) {
            super(0);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreGifPicker.this.gifSearchHistory.containsKey(this.$query)) {
                return;
            }
            StoreGifPicker.this.gifSearchHistory.put(this.$query, StoreGifPicker.INSTANCE.getSearchResultsLoadingList());
            StoreGifPicker.this.fetchGifsForSearchQuery(this.$query);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeSearchHistory$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59801 extends AbstractC12240o implements Function0<Map<String, ? extends List<? extends ModelGif>>> {
        public C59801() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends List<? extends ModelGif>> invoke() {
            return StoreGifPicker.this.getSearchHistory();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeSuggestedSearchTerms$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59811 extends AbstractC12240o implements Function0<Map<String, ? extends List<? extends String>>> {
        public C59811() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends List<? extends String>> invoke() {
            return StoreGifPicker.this.getSuggestedSearchTermsHistory();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeSuggestedSearchTerms$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59822 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59822(String str) {
            super(0);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreGifPicker.this.gifSuggestedSearchTermsHistory.containsKey(this.$query)) {
                return;
            }
            StoreGifPicker.this.gifSuggestedSearchTermsHistory.put(this.$query, StoreGifPicker.INSTANCE.getSearchTermsLoadingList());
            StoreGifPicker.this.fetchSuggestedSearchTerms(this.$query);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeTrendingCategoryGifs$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59841 extends AbstractC12240o implements Function0<Unit> {
        public C59841() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreGifPicker.this.trendingCategoryGifs.isEmpty() || StoreGifPicker.this.isFetchingTrendingCategoryGifs) {
                return;
            }
            StoreGifPicker.this.fetchTrendingCategoryGifs();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeTrendingCategoryGifs$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59852 extends AbstractC12240o implements Function0<List<? extends ModelGif>> {
        public C59852() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends ModelGif> invoke() {
            return StoreGifPicker.this.getTrendingCategoryGifs();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeTrendingGifCategoryPreviewUrl$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59861 extends AbstractC12240o implements Function0<String> {
        public C59861() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return StoreGifPicker.this.getTrendingGifCategoryPreviewUrl();
        }
    }

    public /* synthetic */ StoreGifPicker(Dispatcher dispatcher, StoreUserSettingsSystem storeUserSettingsSystem, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUserSettingsSystem, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    private final void fetchGifTrendingSearchTerms() {
        this.isFetchingTrendingSearchTerms = true;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGifTrendingSearchTerms("tenor", this.storeUserSettingsSystem.getLocale(), 5), false, 1, null), (Class<?>) StoreGifPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C59581()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C59592(this));
    }

    private final void fetchGifsForSearchQuery(String query) {
        Observable<R> observableM11083G = this.restAPI.getGifSearchResults(query, "tenor", this.storeUserSettingsSystem.getLocale(), "tinygif", 50).m11083G(new InterfaceC12589b<List<? extends GifDto>, List<? extends ModelGif>>() { // from class: com.discord.stores.StoreGifPicker.fetchGifsForSearchQuery.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ List<? extends ModelGif> call(List<? extends GifDto> list) {
                return call2((List<GifDto>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<ModelGif> call2(List<GifDto> list) {
                C12238m.checkNotNullExpressionValue(list, "gifDtos");
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(ModelGif.INSTANCE.createFromGifDto((GifDto) it.next()));
                }
                return arrayList;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "restAPI.getGifSearchResu…to)\n          }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(observableM11083G, false, 1, null), (Class<?>) StoreGifPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C59612(query)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C59623(query));
    }

    private final void fetchSuggestedSearchTerms(String query) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGifSuggestedSearchTerms("tenor", query, this.storeUserSettingsSystem.getLocale(), 5), false, 1, null), (Class<?>) StoreGifPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C59631(query)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C59642(query));
    }

    private final void fetchTrendingCategoryGifs() {
        this.isFetchingTrendingCategoryGifs = true;
        Observable<R> observableM11083G = this.restAPI.getTrendingGifCategory("tenor", this.storeUserSettingsSystem.getLocale(), "tinygif", 50).m11083G(new InterfaceC12589b<List<? extends GifDto>, List<? extends ModelGif>>() { // from class: com.discord.stores.StoreGifPicker.fetchTrendingCategoryGifs.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ List<? extends ModelGif> call(List<? extends GifDto> list) {
                return call2((List<GifDto>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<ModelGif> call2(List<GifDto> list) {
                C12238m.checkNotNullExpressionValue(list, "gifDtos");
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(ModelGif.INSTANCE.createFromGifDto((GifDto) it.next()));
                }
                return arrayList;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "restAPI.getTrendingGifCa…to)\n          }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(observableM11083G, false, 1, null), (Class<?>) StoreGifPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C59662()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C59673(this));
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
        this.dispatcher.schedule(new C59681());
    }

    private final void handleFetchGifCategoriesOnNext(TrendingGifCategoriesResponseDto trendingGifsResponseRaw) {
        this.dispatcher.schedule(new C59691(trendingGifsResponseRaw));
    }

    private final void handleFetchTrendingGifsError() {
        this.dispatcher.schedule(new C59701());
    }

    private final void handleFetchTrendingGifsOnNext(List<ModelGif> gifs) {
        this.dispatcher.schedule(new C59711(gifs));
    }

    private final void handleFetchTrendingSearchTermsError() {
        this.dispatcher.schedule(new C59721());
    }

    private final void handleFetchTrendingSearchTermsOnNext(List<String> trendingSearchTerms) {
        this.dispatcher.schedule(new C59731(trendingSearchTerms));
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
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(categories, 10));
        for (GifCategoryDto gifCategoryDto : categories) {
            arrayList.add(new ModelGifCategory(gifCategoryDto.getName(), gifCategoryDto.getSrc()));
        }
        updateGifCategories(arrayList);
        List<TrendingGifPreviewDto> gifs = trendingGifCategoriesResponseDto.getGifs();
        this.trendingGifCategoryPreviewUrl = gifs.isEmpty() ^ true ? gifs.get(0).getSrc() : "";
        markChanged();
    }

    private final Observable<Map<String, List<ModelGif>>> observeSearchHistory() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new C59801(), 12, null);
    }

    private final Observable<Map<String, List<String>>> observeSuggestedSearchTerms() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new C59811(), 12, null);
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getTrendingGifCategories("tenor", this.storeUserSettingsSystem.getLocale(), "tinygif"), false, 1, null), (Class<?>) StoreGifPicker.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C59561()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C59572(this));
    }

    public final Observable<List<ModelGifCategory>> observeGifCategories() {
        this.dispatcher.schedule(new C59741());
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new C59752(), 12, null);
    }

    public final Observable<List<String>> observeGifTrendingSearchTerms() {
        this.dispatcher.schedule(new C59761());
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new C59772(), 12, null);
    }

    public final Observable<List<ModelGif>> observeGifsForSearchQuery(final String query) {
        C12238m.checkNotNullParameter(query, "query");
        this.dispatcher.schedule(new C59781(query));
        Observable<R> observableM11083G = observeSearchHistory().m11083G(new InterfaceC12589b<Map<String, ? extends List<? extends ModelGif>>, List<? extends ModelGif>>() { // from class: com.discord.stores.StoreGifPicker.observeGifsForSearchQuery.2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ List<? extends ModelGif> call(Map<String, ? extends List<? extends ModelGif>> map) {
                return call2((Map<String, ? extends List<ModelGif>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<ModelGif> call2(Map<String, ? extends List<ModelGif>> map) {
                return map.get(query);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "observeSearchHistory().m…gifSearchHistory[query] }");
        Observable<List<ModelGif>> observableM11083G2 = observableM11083G.m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G2, "filter { it != null }.map { it!! }");
        return observableM11083G2;
    }

    public final Observable<List<ModelGif>> observeTrendingCategoryGifs() {
        this.dispatcher.schedule(new C59841());
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new C59852(), 12, null);
    }

    public final Observable<String> observeTrendingGifCategoryPreviewUrl() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new C59861(), 12, null);
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

    public final Observable<List<String>> observeSuggestedSearchTerms(final String query) {
        C12238m.checkNotNullParameter(query, "query");
        this.dispatcher.schedule(new C59822(query));
        Observable<R> observableM11083G = observeSuggestedSearchTerms().m11083G(new InterfaceC12589b<Map<String, ? extends List<? extends String>>, List<? extends String>>() { // from class: com.discord.stores.StoreGifPicker.observeSuggestedSearchTerms.3
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ List<? extends String> call(Map<String, ? extends List<? extends String>> map) {
                return call2((Map<String, ? extends List<String>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<String> call2(Map<String, ? extends List<String>> map) {
                return map.get(query);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "observeSuggestedSearchTe…archTermsHistory[query] }");
        Observable<List<String>> observableM11083G2 = observableM11083G.m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G2, "filter { it != null }.map { it!! }");
        return observableM11083G2;
    }

    public StoreGifPicker(Dispatcher dispatcher, StoreUserSettingsSystem storeUserSettingsSystem, RestAPI restAPI, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(storeUserSettingsSystem, "storeUserSettingsSystem");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeUserSettingsSystem = storeUserSettingsSystem;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.gifCategoriesSnapshot = C12147n.emptyList();
        this.gifTrendingSearchTermsSnapshot = C12147n.emptyList();
        this.gifSearchHistorySnapshot = C12136h0.emptyMap();
        this.suggestedSearchTermsSnapshot = C12136h0.emptyMap();
        this.trendingCategoryGifsSnapshot = C12147n.emptyList();
        this.gifCategories = new ArrayList();
        this.gifTrendingSearchTerms = new ArrayList();
        this.trendingCategoryGifs = new ArrayList();
        this.trendingGifCategoryPreviewUrl = "";
        this.gifSearchHistory = new CacheHistory<>();
        this.gifSuggestedSearchTermsHistory = new CacheHistory<>();
    }
}
