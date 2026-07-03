package com.discord.widgets.search.suggestions;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchSuggestionsBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasAnswerOption;
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
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.search.suggestions.WidgetSearchSuggestions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSearchSuggestions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchSuggestionsBinding;", 0)};
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
                C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11075i = Observable.m11075i(companion.getSearch().getStoreSearchData().get(), companion.getSearch().getStoreSearchInput().getCurrentParsedInput(), companion.getSearch().getHistory(), new Func3<SearchData, List<? extends QueryNode>, Collection<? extends List<? extends QueryNode>>, Model>() { // from class: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$Model$Companion$get$1
                    @Override // p658rx.functions.Func3
                    public final WidgetSearchSuggestions.Model call(SearchData searchData, List<? extends QueryNode> list, Collection<? extends List<? extends QueryNode>> collection) {
                        C12238m.checkNotNullParameter(searchData, "searchData");
                        C12238m.checkNotNullParameter(list, "queryNodes");
                        C12238m.checkNotNullParameter(collection, "history");
                        List<QueryNode> mutableList = C12163u.toMutableList((Collection) list);
                        QueryNode.INSTANCE.preprocess(mutableList, searchData);
                        return new WidgetSearchSuggestions.Model(mutableList, SearchSuggestionEngine.getSuggestions(mutableList, searchData, searchStringProvider, collection));
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…gestionEntries)\n        }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11075i).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…().distinctUntilChanged()");
                return observableM11112r;
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
            C12238m.checkNotNullParameter(list, "query");
            C12238m.checkNotNullParameter(list2, "suggestionEntries");
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
            C12238m.checkNotNullParameter(query, "query");
            C12238m.checkNotNullParameter(suggestionEntries, "suggestionEntries");
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
            return C12238m.areEqual(this.query, model.query) && C12238m.areEqual(this.suggestionEntries, model.suggestionEntries);
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
            StringBuilder sbM833U = C1643a.m833U("Model(query=");
            sbM833U.append(this.query);
            sbM833U.append(", suggestionEntries=");
            return C1643a.m824L(sbM833U, this.suggestionEntries, ")");
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

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$1 */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class C91361 extends AbstractC12240o implements Function1<FilterType, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C91361(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FilterType filterType) {
            invoke2(filterType);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FilterType filterType) {
            C12238m.checkNotNullParameter(filterType, "filterType");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onFilterClicked(filterType, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this), this.$model.getQuery());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$2 */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class C91372 extends AbstractC12240o implements Function1<UserSuggestion, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C91372(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserSuggestion userSuggestion) {
            invoke2(userSuggestion);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserSuggestion userSuggestion) {
            C12238m.checkNotNullParameter(userSuggestion, "userSuggestion");
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

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$3 */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class C91383 extends AbstractC12240o implements Function1<ChannelSuggestion, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C91383(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelSuggestion channelSuggestion) {
            invoke2(channelSuggestion);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelSuggestion channelSuggestion) {
            C12238m.checkNotNullParameter(channelSuggestion, "channelSuggestion");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onInChannelClicked(channelSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getInFilterString(), this.$model.getQuery());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$4 */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class C91394 extends AbstractC12240o implements Function1<HasAnswerOption, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C91394(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HasAnswerOption hasAnswerOption) {
            invoke2(hasAnswerOption);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HasAnswerOption hasAnswerOption) {
            C12238m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onHasClicked(hasAnswerOption, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getHasFilterString(), hasAnswerOption.getLocalizedInputText(WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this)), this.$model.getQuery());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$5 */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class C91405 extends AbstractC12240o implements Function1<List<? extends QueryNode>, Unit> {
        public static final C91405 INSTANCE = new C91405();

        public C91405() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends QueryNode> list) {
            C12238m.checkNotNullParameter(list, "queryNodes");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onQueryClicked(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$6 */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class C91416 extends AbstractC12240o implements Function0<Unit> {
        public static final C91416 INSTANCE = new C91416();

        public C91416() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.INSTANCE.getSearch().clearHistory();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
    public static final class C91421 extends AbstractC12240o implements Function1<Model, Unit> {
        public C91421() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "model");
            WidgetSearchSuggestions.this.configureUI(model);
        }
    }

    public WidgetSearchSuggestions() {
        super(C5419R.layout.widget_search_suggestions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSearchSuggestions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ SearchStringProvider access$getSearchStringProvider$p(WidgetSearchSuggestions widgetSearchSuggestions) {
        SearchStringProvider searchStringProvider = widgetSearchSuggestions.searchStringProvider;
        if (searchStringProvider == null) {
            C12238m.throwUninitializedPropertyAccessException("searchStringProvider");
        }
        return searchStringProvider;
    }

    private final void configureUI(Model model) {
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter = this.adapter;
        if (widgetSearchSuggestionsAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter.setData(model.getSuggestionItems());
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter2 = this.adapter;
        if (widgetSearchSuggestionsAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter2.setOnFilterClicked(new C91361(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter3 = this.adapter;
        if (widgetSearchSuggestionsAdapter3 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter3.setOnUserClicked(new C91372(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter4 = this.adapter;
        if (widgetSearchSuggestionsAdapter4 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter4.setOnChannelClicked(new C91383(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter5 = this.adapter;
        if (widgetSearchSuggestionsAdapter5 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter5.setOnHasClicked(new C91394(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter6 = this.adapter;
        if (widgetSearchSuggestionsAdapter6 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter6.setOnRecentQueryClicked(C91405.INSTANCE);
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter7 = this.adapter;
        if (widgetSearchSuggestionsAdapter7 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter7.setOnClearHistoryClicked(C91416.INSTANCE);
    }

    private final WidgetSearchSuggestionsBinding getBinding() {
        return (WidgetSearchSuggestionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17431b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.searchSuggestionsRecycler");
        this.adapter = (WidgetSearchSuggestionsAdapter) companion.configure(new WidgetSearchSuggestionsAdapter(recyclerView));
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            RecyclerView recyclerView2 = getBinding().f17431b;
            C12238m.checkNotNullExpressionValue(recyclerView2, "binding.searchSuggestionsRecycler");
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
            C12238m.throwUninitializedPropertyAccessException("searchStringProvider");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.get(contextSearchStringProvider), this, null, 2, null), (Class<?>) WidgetSearchSuggestions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C91421());
    }
}
