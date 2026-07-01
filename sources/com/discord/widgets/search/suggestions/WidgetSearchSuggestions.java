package com.discord.widgets.search.suggestions;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchSuggestionsBinding;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.strings.ContextSearchStringProvider;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSearchSuggestions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchSuggestionsBinding;", 0)};
    private WidgetSearchSuggestionsAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private SearchStringProvider searchStringProvider;

    public WidgetSearchSuggestions() {
        super(R$layout.widget_search_suggestions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSearchSuggestions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSearchSuggestions widgetSearchSuggestions, WidgetSearchSuggestions$Model widgetSearchSuggestions$Model) {
        widgetSearchSuggestions.configureUI(widgetSearchSuggestions$Model);
    }

    public static final /* synthetic */ SearchStringProvider access$getSearchStringProvider$p(WidgetSearchSuggestions widgetSearchSuggestions) {
        SearchStringProvider searchStringProvider = widgetSearchSuggestions.searchStringProvider;
        if (searchStringProvider == null) {
            m.throwUninitializedPropertyAccessException("searchStringProvider");
        }
        return searchStringProvider;
    }

    public static final /* synthetic */ void access$setSearchStringProvider$p(WidgetSearchSuggestions widgetSearchSuggestions, SearchStringProvider searchStringProvider) {
        widgetSearchSuggestions.searchStringProvider = searchStringProvider;
    }

    private final void configureUI(WidgetSearchSuggestions$Model model) {
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter = this.adapter;
        if (widgetSearchSuggestionsAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter.setData(model.getSuggestionItems());
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter2 = this.adapter;
        if (widgetSearchSuggestionsAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter2.setOnFilterClicked(new WidgetSearchSuggestions$configureUI$1(this, model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter3 = this.adapter;
        if (widgetSearchSuggestionsAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter3.setOnUserClicked(new WidgetSearchSuggestions$configureUI$2(this, model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter4 = this.adapter;
        if (widgetSearchSuggestionsAdapter4 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter4.setOnChannelClicked(new WidgetSearchSuggestions$configureUI$3(this, model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter5 = this.adapter;
        if (widgetSearchSuggestionsAdapter5 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter5.setOnHasClicked(new WidgetSearchSuggestions$configureUI$4(this, model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter6 = this.adapter;
        if (widgetSearchSuggestionsAdapter6 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter6.setOnRecentQueryClicked(WidgetSearchSuggestions$configureUI$5.INSTANCE);
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter7 = this.adapter;
        if (widgetSearchSuggestionsAdapter7 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter7.setOnClearHistoryClicked(WidgetSearchSuggestions$configureUI$6.INSTANCE);
    }

    private final WidgetSearchSuggestionsBinding getBinding() {
        return (WidgetSearchSuggestionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2526b;
        m.checkNotNullExpressionValue(recyclerView, "binding.searchSuggestionsRecycler");
        this.adapter = (WidgetSearchSuggestionsAdapter) mGRecyclerAdapter$Companion.configure(new WidgetSearchSuggestionsAdapter(recyclerView));
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            RecyclerView recyclerView2 = getBinding().f2526b;
            m.checkNotNullExpressionValue(recyclerView2, "binding.searchSuggestionsRecycler");
            recyclerView2.setItemAnimator(null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ContextSearchStringProvider contextSearchStringProvider = new ContextSearchStringProvider(requireContext());
        this.searchStringProvider = contextSearchStringProvider;
        WidgetSearchSuggestions$Model$Companion widgetSearchSuggestions$Model$Companion = WidgetSearchSuggestions$Model.Companion;
        if (contextSearchStringProvider == null) {
            m.throwUninitializedPropertyAccessException("searchStringProvider");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(widgetSearchSuggestions$Model$Companion.get(contextSearchStringProvider), this, null, 2, null), WidgetSearchSuggestions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSearchSuggestions$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
