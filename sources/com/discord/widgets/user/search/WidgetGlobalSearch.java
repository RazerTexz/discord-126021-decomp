package com.discord.widgets.user.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.n$a;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGlobalSearchBinding;
import com.discord.stores.StoreGuilds$Actions;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.g0.y;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGlobalSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGlobalSearchBinding;", 0)};
    public static final WidgetGlobalSearch$Companion Companion = new WidgetGlobalSearch$Companion(null);
    public static final String EXTRA_SEARCH_TEXT = "EXTRA_SEARCH_TEXT";
    private static final int INDEX_EMPTY = 1;
    private static final int INDEX_RESULTS = 0;
    private static final int INDEX_RESULTS_NOT_FOUND = 2;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: dismissViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dismissViewModel;
    private final BehaviorSubject<String> filterPublisher;
    private String filterString;
    private WidgetGlobalSearchGuildsAdapter guildsAdapter;
    private WidgetGlobalSearchAdapter resultsAdapter;
    private final StoreTabsNavigation storeTabsNavigation;

    public WidgetGlobalSearch() {
        super(R$layout.widget_global_search);
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetGlobalSearch$$special$$inlined$activityViewModels$1(this), new WidgetGlobalSearch$$special$$inlined$activityViewModels$2(this));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGlobalSearch$binding$2.INSTANCE, null, 2, null);
        this.storeTabsNavigation = StoreStream.Companion.getTabsNavigation();
        this.filterPublisher = BehaviorSubject.l0("");
    }

    public static final /* synthetic */ void access$configureUI(WidgetGlobalSearch widgetGlobalSearch, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        widgetGlobalSearch.configureUI(widgetGlobalSearchModel);
    }

    public static final /* synthetic */ void access$focusSearchBar(WidgetGlobalSearch widgetGlobalSearch) {
        widgetGlobalSearch.focusSearchBar();
    }

    public static final /* synthetic */ WidgetGlobalSearchBinding access$getBinding$p(WidgetGlobalSearch widgetGlobalSearch) {
        return widgetGlobalSearch.getBinding();
    }

    public static final /* synthetic */ WidgetGlobalSearchDismissModel access$getDismissViewModel$p(WidgetGlobalSearch widgetGlobalSearch) {
        return widgetGlobalSearch.getDismissViewModel();
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterPublisher$p(WidgetGlobalSearch widgetGlobalSearch) {
        return widgetGlobalSearch.filterPublisher;
    }

    public static final /* synthetic */ String access$getFilterString$p(WidgetGlobalSearch widgetGlobalSearch) {
        return widgetGlobalSearch.filterString;
    }

    public static final /* synthetic */ void access$handleOnSelected(WidgetGlobalSearch widgetGlobalSearch, WidgetGlobalSearchModel widgetGlobalSearchModel, View view, int i, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, boolean z2) {
        widgetGlobalSearch.handleOnSelected(widgetGlobalSearchModel, view, i, widgetGlobalSearchModel$ItemDataPayload, z2);
    }

    public static final /* synthetic */ void access$onSelected(WidgetGlobalSearch widgetGlobalSearch, NavigationTab navigationTab, StoreNavigation$PanelAction storeNavigation$PanelAction) {
        widgetGlobalSearch.onSelected(navigationTab, storeNavigation$PanelAction);
    }

    public static final /* synthetic */ void access$setFilterString$p(WidgetGlobalSearch widgetGlobalSearch, String str) {
        widgetGlobalSearch.filterString = str;
    }

    public static final /* synthetic */ void access$setSearchPrefix(WidgetGlobalSearch widgetGlobalSearch, String str) {
        widgetGlobalSearch.setSearchPrefix(str);
    }

    public static final /* synthetic */ void access$showFilterPickerDialog(WidgetGlobalSearch widgetGlobalSearch) {
        widgetGlobalSearch.showFilterPickerDialog();
    }

    @MainThread
    private final void configureUI(WidgetGlobalSearchModel model) {
        WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter = this.guildsAdapter;
        if (widgetGlobalSearchGuildsAdapter == null) {
            m.throwUninitializedPropertyAccessException("guildsAdapter");
        }
        List<WidgetGlobalSearchGuildsModel$Item> guildsList = model.getGuildsList();
        if (guildsList == null) {
            guildsList = n.emptyList();
        }
        widgetGlobalSearchGuildsAdapter.setData(guildsList);
        WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter2 = this.guildsAdapter;
        if (widgetGlobalSearchGuildsAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("guildsAdapter");
        }
        widgetGlobalSearchGuildsAdapter2.setOnLongClickListener(new WidgetGlobalSearch$configureUI$1(this));
        WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter3 = this.guildsAdapter;
        if (widgetGlobalSearchGuildsAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("guildsAdapter");
        }
        widgetGlobalSearchGuildsAdapter3.setOnClickListener(new WidgetGlobalSearch$configureUI$2(this, model));
        RecyclerView recyclerView = getBinding().e;
        m.checkNotNullExpressionValue(recyclerView, "binding.globalSearchGuildList");
        List<WidgetGlobalSearchGuildsModel$Item> guildsList2 = model.getGuildsList();
        recyclerView.setVisibility(guildsList2 != null && !guildsList2.isEmpty() ? 0 : 8);
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.resultsAdapter;
        if (widgetGlobalSearchAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetGlobalSearchAdapter.setOnUpdated(new WidgetGlobalSearch$configureUI$$inlined$apply$lambda$1(this, model));
        widgetGlobalSearchAdapter.setData(model.getData());
        widgetGlobalSearchAdapter.setOnSelectedListener(new WidgetGlobalSearch$configureUI$$inlined$apply$lambda$2(this, model));
        AppViewFlipper appViewFlipper = getBinding().h;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.globalSearchViewFlipper");
        appViewFlipper.setDisplayedChild(getViewIndex(model));
    }

    private final void focusSearchBar() {
        getBinding().d.requestFocus();
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = (InputMethodManager) (systemService instanceof InputMethodManager ? systemService : null);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(getBinding().d, 1);
        }
    }

    private final WidgetGlobalSearchBinding getBinding() {
        return (WidgetGlobalSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGlobalSearchDismissModel getDismissViewModel() {
        return (WidgetGlobalSearchDismissModel) this.dismissViewModel.getValue();
    }

    private final int getViewIndex(WidgetGlobalSearchModel widgetGlobalSearchModel) {
        if (!widgetGlobalSearchModel.getData().isEmpty()) {
            return 0;
        }
        return t.isBlank(widgetGlobalSearchModel.getFilter()) ^ true ? 2 : 1;
    }

    private final void handleOnSelected(WidgetGlobalSearchModel widgetGlobalSearchModel, View view, int i, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, boolean z2) {
        if (widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemUser) {
            if (z2) {
                WidgetUserSheet$Companion widgetUserSheet$Companion = WidgetUserSheet.Companion;
                long id2 = ((WidgetGlobalSearchModel$ItemUser) widgetGlobalSearchModel$ItemDataPayload).getUser().getId();
                FragmentManager parentFragmentManager = getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetUserSheet$Companion.show$default(widgetUserSheet$Companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
            } else {
                ChannelSelector channelSelector$Companion = ChannelSelector.Companion.getInstance();
                Context context = view.getContext();
                m.checkNotNullExpressionValue(context, "view.context");
                channelSelector$Companion.findAndSetDirectMessage(context, ((WidgetGlobalSearchModel$ItemUser) widgetGlobalSearchModel$ItemDataPayload).getUser().getId());
            }
        } else if (widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemChannel) {
            ChannelSelector.Companion.getInstance().findAndSet(getContext(), ((WidgetGlobalSearchModel$ItemChannel) widgetGlobalSearchModel$ItemDataPayload).getChannel().getId());
        } else if (widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemGuild) {
            StoreStream.Companion.getGuildSelected().set(((WidgetGlobalSearchModel$ItemGuild) widgetGlobalSearchModel$ItemDataPayload).getGuild().getId());
        }
        if ((widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemHeader) || z2) {
            return;
        }
        AnalyticsTracker.INSTANCE.quickSwitcherSelect(widgetGlobalSearchModel, widgetGlobalSearchModel$ItemDataPayload, i);
        onSelected(NavigationTab.HOME, widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemGuild ? StoreNavigation$PanelAction.OPEN : StoreNavigation$PanelAction.CLOSE);
    }

    private final void onSelected(NavigationTab destinationTab, StoreNavigation$PanelAction panelAction) {
        if (destinationTab == NavigationTab.HOME) {
            StoreTabsNavigation.selectHomeTab$default(this.storeTabsNavigation, panelAction, false, 2, null);
        } else {
            StoreTabsNavigation.selectTab$default(this.storeTabsNavigation, destinationTab, false, 2, null);
        }
        getDismissViewModel().dismiss();
    }

    public static /* synthetic */ void onSelected$default(WidgetGlobalSearch widgetGlobalSearch, NavigationTab navigationTab, StoreNavigation$PanelAction storeNavigation$PanelAction, int i, Object obj) {
        if ((i & 1) != 0) {
            navigationTab = NavigationTab.HOME;
        }
        if ((i & 2) != 0) {
            storeNavigation$PanelAction = StoreNavigation$PanelAction.CLOSE;
        }
        widgetGlobalSearch.onSelected(navigationTab, storeNavigation$PanelAction);
    }

    @SuppressLint({"SetTextI18n"})
    @MainThread
    private final void setSearchPrefix(String prefix) {
        CharSequence charSequenceReplace;
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.globalSearchBar");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ViewExtensions.getTextOrEmpty(textInputLayout));
        if (spannableStringBuilder.length() == 0) {
            charSequenceReplace = prefix + ((Object) spannableStringBuilder);
        } else {
            char cFirst = y.first(spannableStringBuilder);
            if (cFirst == '!' || cFirst == '#' || cFirst == '*' || cFirst == '@') {
                charSequenceReplace = spannableStringBuilder.replace(0, 1, (CharSequence) prefix);
            } else {
                charSequenceReplace = prefix + ((Object) spannableStringBuilder);
            }
        }
        m.checkNotNullExpressionValue(charSequenceReplace, "newQuery");
        if (!t.isBlank(charSequenceReplace)) {
            TextInputLayout textInputLayout2 = getBinding().c;
            ViewExtensions.setText(textInputLayout2, charSequenceReplace);
            textInputLayout2.post(new WidgetGlobalSearch$setSearchPrefix$1$1(textInputLayout2));
        }
    }

    private final void showFilterPickerDialog() {
        Pair[] pairArrAccess$getFILTER_OPTIONS_LIST$p = WidgetGlobalSearch$Companion.access$getFILTER_OPTIONS_LIST$p(Companion);
        ArrayList arrayList = new ArrayList(pairArrAccess$getFILTER_OPTIONS_LIST$p.length);
        for (Pair pair : pairArrAccess$getFILTER_OPTIONS_LIST$p) {
            arrayList.add(getString(((Number) pair.component1()).intValue()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        n$a n_a = b.a.a.n.k;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = getString(2131889032);
        m.checkNotNullExpressionValue(string, "getString(R.string.filter_options)");
        n_a.a(parentFragmentManager, string, (String[]) array, new WidgetGlobalSearch$showFilterPickerDialog$1(this));
    }

    public final void onDismiss() {
        hideKeyboard(getBinding().c);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        String string;
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().g;
        m.checkNotNullExpressionValue(recyclerView, "binding.globalSearchRecycler");
        this.resultsAdapter = (WidgetGlobalSearchAdapter) mGRecyclerAdapter$Companion.configure(new WidgetGlobalSearchAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().e;
        m.checkNotNullExpressionValue(recyclerView2, "binding.globalSearchGuildList");
        this.guildsAdapter = (WidgetGlobalSearchGuildsAdapter) mGRecyclerAdapter$Companion.configure(new WidgetGlobalSearchGuildsAdapter(recyclerView2, ColorCompat.getThemedColor(view, 2130969991)));
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.globalSearchBar");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetGlobalSearch$onViewBound$1(this));
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString(EXTRA_SEARCH_TEXT)) != null) {
            TextInputLayout textInputLayout2 = getBinding().c;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.globalSearchBar");
            ViewExtensions.setText(textInputLayout2, string);
            TextInputLayout textInputLayout3 = getBinding().c;
            m.checkNotNullExpressionValue(textInputLayout3, "binding.globalSearchBar");
            ViewExtensions.setSelectionEnd(textInputLayout3);
        }
        getBinding().c.setEndIconOnClickListener(new WidgetGlobalSearch$onViewBound$3(this));
        getBinding().c.setStartIconOnClickListener(new WidgetGlobalSearch$onViewBound$4(this));
        k kVar = new k(Unit.a);
        m.checkNotNullExpressionValue(kVar, "Observable.just(Unit)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(kVar, this, null, 2, null), WidgetGlobalSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGlobalSearch$onViewBound$5(this), 62, (Object) null);
        getBinding().f2403b.setOnClickListener(new WidgetGlobalSearch$onViewBound$6(this));
        getBinding().f.setOnClickListener(new WidgetGlobalSearch$onViewBound$7(this));
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            RecyclerView recyclerView3 = getBinding().g;
            m.checkNotNullExpressionValue(recyclerView3, "binding.globalSearchRecycler");
            recyclerView3.setItemAnimator(null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        WidgetGlobalSearchModel$Companion widgetGlobalSearchModel$Companion = WidgetGlobalSearchModel.Companion;
        BehaviorSubject<String> behaviorSubject = this.filterPublisher;
        m.checkNotNullExpressionValue(behaviorSubject, "filterPublisher");
        Observable<WidgetGlobalSearchModel> forNav = widgetGlobalSearchModel$Companion.getForNav(behaviorSubject);
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.resultsAdapter;
        if (widgetGlobalSearchAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(forNav, this, widgetGlobalSearchAdapter), WidgetGlobalSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGlobalSearch$onViewBoundOrOnResume$1(this), 62, (Object) null);
        BehaviorSubject<String> behaviorSubject2 = this.filterPublisher;
        m.checkNotNullExpressionValue(behaviorSubject2, "filterPublisher");
        StoreGuilds$Actions.requestMembers(this, behaviorSubject2, false);
    }
}
