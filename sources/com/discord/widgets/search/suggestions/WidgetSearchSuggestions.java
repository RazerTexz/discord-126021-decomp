package com.discord.widgets.search.suggestions;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchSuggestionsBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasNode2;
import com.discord.utilities.search.strings.ContextSearchStringProvider;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.SearchSuggestionEngine;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.FilterSuggestion;
import com.discord.utilities.search.suggestion.entries.HasSuggestion;
import com.discord.utilities.search.suggestion.entries.RecentQuerySuggestion;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import com.discord.utilities.search.validation.SearchData;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.search.suggestions.WidgetSearchSuggestions;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSearchSuggestions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchSuggestionsBinding;", 0)};
    private WidgetSearchSuggestionsAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private SearchStringProvider searchStringProvider;

    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<QueryNode> query;
        private final List<SearchSuggestion> suggestionEntries;
        private final List<MGRecyclerDataPayload> suggestionItems;

        /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(final SearchStringProvider searchStringProvider) {
                Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getSearch().getStoreSearchData().get(), companion.getSearch().getStoreSearchInput().getCurrentParsedInput(), companion.getSearch().getHistory(), new Func3<SearchData, List<? extends QueryNode>, Collection<? extends List<? extends QueryNode>>, Model>() { // from class: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$Model$Companion$get$1
                    @Override // rx.functions.Func3
                    public final WidgetSearchSuggestions.Model call(SearchData searchData, List<? extends QueryNode> list, Collection<? extends List<? extends QueryNode>> collection) {
                        Intrinsics3.checkNotNullParameter(searchData, "searchData");
                        Intrinsics3.checkNotNullParameter(list, "queryNodes");
                        Intrinsics3.checkNotNullParameter(collection, "history");
                        List<QueryNode> mutableList = _Collections.toMutableList((Collection) list);
                        QueryNode.INSTANCE.preprocess(mutableList, searchData);
                        return new WidgetSearchSuggestions.Model(mutableList, SearchSuggestionEngine.getSuggestions(mutableList, searchData, searchStringProvider, collection));
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…gestionEntries)\n        }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…().distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                SearchSuggestion.Category.values();
                int[] iArr = new int[7];
                $EnumSwitchMapping$0 = iArr;
                iArr[SearchSuggestion.Category.FILTER.ordinal()] = 1;
                iArr[SearchSuggestion.Category.FROM_USER.ordinal()] = 2;
                iArr[SearchSuggestion.Category.MENTIONS_USER.ordinal()] = 3;
                iArr[SearchSuggestion.Category.IN_CHANNEL.ordinal()] = 4;
                iArr[SearchSuggestion.Category.HAS.ordinal()] = 5;
                iArr[SearchSuggestion.Category.RECENT_QUERY.ordinal()] = 6;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(List<QueryNode> list, List<? extends SearchSuggestion> list2) {
            Intrinsics3.checkNotNullParameter(list, "query");
            Intrinsics3.checkNotNullParameter(list2, "suggestionEntries");
            this.query = list;
            this.suggestionEntries = list2;
            this.suggestionItems = new ArrayList();
            SearchSuggestion.Category category = null;
            for (SearchSuggestion searchSuggestion : list2) {
                SearchSuggestion.Category category2 = searchSuggestion.getCategory();
                if (category == null || category2 != category) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getHeaderItem(category2));
                    category = category2;
                }
                int iOrdinal = category2.ordinal();
                if (iOrdinal == 0) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getFilterItem((FilterSuggestion) searchSuggestion));
                } else if (iOrdinal == 1 || iOrdinal == 2) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getUserItem((UserSuggestion) searchSuggestion));
                } else if (iOrdinal == 3) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getHasItem((HasSuggestion) searchSuggestion));
                } else if (iOrdinal == 5) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getInChannelItem((ChannelSuggestion) searchSuggestion));
                } else if (iOrdinal == 6) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getRecentQueryItem((RecentQuerySuggestion) searchSuggestion));
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = model.query;
            }
            if ((i & 2) != 0) {
                list2 = model.suggestionEntries;
            }
            return model.copy(list, list2);
        }

        public final List<QueryNode> component1() {
            return this.query;
        }

        public final List<SearchSuggestion> component2() {
            return this.suggestionEntries;
        }

        public final Model copy(List<QueryNode> query, List<? extends SearchSuggestion> suggestionEntries) {
            Intrinsics3.checkNotNullParameter(query, "query");
            Intrinsics3.checkNotNullParameter(suggestionEntries, "suggestionEntries");
            return new Model(query, suggestionEntries);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.query, model.query) && Intrinsics3.areEqual(this.suggestionEntries, model.suggestionEntries);
        }

        public final List<QueryNode> getQuery() {
            return this.query;
        }

        public final List<SearchSuggestion> getSuggestionEntries() {
            return this.suggestionEntries;
        }

        public final List<MGRecyclerDataPayload> getSuggestionItems() {
            return this.suggestionItems;
        }

        public int hashCode() {
            List<QueryNode> list = this.query;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<SearchSuggestion> list2 = this.suggestionEntries;
            return iHashCode + (list2 != null ? list2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(query=");
            sbU.append(this.query);
            sbU.append(", suggestionEntries=");
            return outline.L(sbU, this.suggestionEntries, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            UserSuggestion.TargetType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[UserSuggestion.TargetType.FROM.ordinal()] = 1;
            iArr[UserSuggestion.TargetType.MENTIONS.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<FilterType, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FilterType filterType) {
            invoke2(filterType);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FilterType filterType) {
            Intrinsics3.checkNotNullParameter(filterType, "filterType");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onFilterClicked(filterType, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this), this.$model.getQuery());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<UserSuggestion, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserSuggestion userSuggestion) {
            invoke2(userSuggestion);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserSuggestion userSuggestion) {
            Intrinsics3.checkNotNullParameter(userSuggestion, "userSuggestion");
            int iOrdinal = userSuggestion.getTargetType().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    return;
                }
                StoreStream.INSTANCE.getSearch().getStoreSearchInput().onMentionsUserClicked(userSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getMentionsFilterString(), this.$model.getQuery());
            } else {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                companion.getSearch().getStoreSearchInput().onFromUserClicked(userSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getFromFilterString(), this.$model.getQuery());
                companion.getSearch().getStoreSearchInput().onMentionsUserClicked(userSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getMentionsFilterString(), this.$model.getQuery());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<ChannelSuggestion, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelSuggestion channelSuggestion) {
            invoke2(channelSuggestion);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelSuggestion channelSuggestion) {
            Intrinsics3.checkNotNullParameter(channelSuggestion, "channelSuggestion");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onInChannelClicked(channelSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getInFilterString(), this.$model.getQuery());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<HasNode2, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HasNode2 hasNode2) {
            invoke2(hasNode2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HasNode2 hasNode2) {
            Intrinsics3.checkNotNullParameter(hasNode2, "hasAnswerOption");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onHasClicked(hasNode2, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getHasFilterString(), hasNode2.getLocalizedInputText(WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this)), this.$model.getQuery());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<List<? extends QueryNode>, Unit> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends QueryNode> list) {
            Intrinsics3.checkNotNullParameter(list, "queryNodes");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onQueryClicked(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.INSTANCE.getSearch().clearHistory();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "model");
            WidgetSearchSuggestions.this.configureUI(model);
        }
    }

    public WidgetSearchSuggestions() {
        super(R.layout.widget_search_suggestions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSearchSuggestions3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ SearchStringProvider access$getSearchStringProvider$p(WidgetSearchSuggestions widgetSearchSuggestions) {
        SearchStringProvider searchStringProvider = widgetSearchSuggestions.searchStringProvider;
        if (searchStringProvider == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("searchStringProvider");
        }
        return searchStringProvider;
    }

    private final void configureUI(Model model) {
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter = this.adapter;
        if (widgetSearchSuggestionsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter.setData(model.getSuggestionItems());
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter2 = this.adapter;
        if (widgetSearchSuggestionsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter2.setOnFilterClicked(new AnonymousClass1(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter3 = this.adapter;
        if (widgetSearchSuggestionsAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter3.setOnUserClicked(new AnonymousClass2(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter4 = this.adapter;
        if (widgetSearchSuggestionsAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter4.setOnChannelClicked(new AnonymousClass3(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter5 = this.adapter;
        if (widgetSearchSuggestionsAdapter5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter5.setOnHasClicked(new AnonymousClass4(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter6 = this.adapter;
        if (widgetSearchSuggestionsAdapter6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter6.setOnRecentQueryClicked(AnonymousClass5.INSTANCE);
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter7 = this.adapter;
        if (widgetSearchSuggestionsAdapter7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter7.setOnClearHistoryClicked(AnonymousClass6.INSTANCE);
    }

    private final WidgetSearchSuggestionsBinding getBinding() {
        return (WidgetSearchSuggestionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2526b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.searchSuggestionsRecycler");
        this.adapter = (WidgetSearchSuggestionsAdapter) companion.configure(new WidgetSearchSuggestionsAdapter(recyclerView));
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            RecyclerView recyclerView2 = getBinding().f2526b;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.searchSuggestionsRecycler");
            recyclerView2.setItemAnimator(null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ContextSearchStringProvider contextSearchStringProvider = new ContextSearchStringProvider(requireContext());
        this.searchStringProvider = contextSearchStringProvider;
        Model.Companion companion = Model.INSTANCE;
        if (contextSearchStringProvider == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("searchStringProvider");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.get(contextSearchStringProvider), this, null, 2, null), (Class<?>) WidgetSearchSuggestions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
