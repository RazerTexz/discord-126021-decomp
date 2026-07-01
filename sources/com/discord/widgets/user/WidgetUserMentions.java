package com.discord.widgets.user;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserMentionsBinding;
import com.discord.stores.StoreChat$InteractionState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.fragment.FragmentExtensionsKt;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.list.ThreadSpineItemDecoration;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.search.WidgetGlobalSearchDismissModel;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions extends AppFragment implements OnTabSelectedListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserMentions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMentionsBinding;", 0)};
    public static final WidgetUserMentions$Companion Companion = new WidgetUserMentions$Companion(null);
    private static final String EXTRA_IS_EMBEDDED = "EXTRA_HIDE_TITLE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: dismissViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dismissViewModel;

    /* JADX INFO: renamed from: isEmbedded$delegate, reason: from kotlin metadata */
    private final Lazy isEmbedded;
    private WidgetChatListAdapter mentionsAdapter;
    private final WidgetUserMentions$Model$MessageLoader mentionsLoader;
    private final StoreTabsNavigation storeTabsNavigation;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetUserMentions() {
        super(R$layout.widget_user_mentions);
        this.isEmbedded = FragmentExtensionsKt.booleanExtra$default(this, EXTRA_IS_EMBEDDED, false, 2, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserMentions$binding$2.INSTANCE, null, 2, null);
        this.mentionsLoader = new WidgetUserMentions$Model$MessageLoader(1000L);
        this.storeTabsNavigation = StoreStream.Companion.getTabsNavigation();
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetUserMentions$$special$$inlined$activityViewModels$1(this), new WidgetUserMentions$$special$$inlined$activityViewModels$2(this));
        WidgetUserMentions$viewModel$2 widgetUserMentions$viewModel$2 = WidgetUserMentions$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetUserMentionsViewModel.class), new WidgetUserMentions$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetUserMentions$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserMentions widgetUserMentions, WidgetUserMentions$Model widgetUserMentions$Model) {
        widgetUserMentions.configureUI(widgetUserMentions$Model);
    }

    public static final /* synthetic */ WidgetGlobalSearchDismissModel access$getDismissViewModel$p(WidgetUserMentions widgetUserMentions) {
        return widgetUserMentions.getDismissViewModel();
    }

    public static final /* synthetic */ WidgetUserMentions$Model$MessageLoader access$getMentionsLoader$p(WidgetUserMentions widgetUserMentions) {
        return widgetUserMentions.mentionsLoader;
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().c.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureToolbar(String guildName) {
        AppFragment.bindToolbar$default(this, null, 1, null);
        String string = this.mentionsLoader.getFilters().getAllGuilds() ? getString(2131886413) : guildName;
        if (isEmbedded()) {
            setActionBarTitle(string);
        } else {
            setActionBarSubtitle(string);
        }
        AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_user_mentions, new WidgetUserMentions$configureToolbar$1(this, guildName), null, 4, null);
    }

    private final void configureUI(WidgetUserMentions$Model widgetUserMentions$Model) {
        boolean allGuilds = widgetUserMentions$Model.getGuildId() > 0 ? this.mentionsLoader.getFilters().getAllGuilds() : true;
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setData(widgetUserMentions$Model);
        }
        WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader = this.mentionsLoader;
        widgetUserMentions$Model$MessageLoader.setFilters(WidgetUserMentions$Model$MessageLoader$Filters.copy$default(widgetUserMentions$Model$MessageLoader.getFilters(), widgetUserMentions$Model.getGuildId(), allGuilds, false, false, 12, null));
        this.mentionsLoader.setIsFocused(widgetUserMentions$Model.getSelectedTab() == NavigationTab.MENTIONS);
        if (isEmbedded() || isOnMentionsTab()) {
            configureToolbar(widgetUserMentions$Model.getGuildName());
        }
        getViewModel().setModel$app_productionGoogleRelease(widgetUserMentions$Model);
    }

    private final WidgetChatListAdapter createAdapter(Function1<? super StoreChat$InteractionState, Unit> onInteractionStateUpdated) {
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.userMentionsList");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new WidgetUserMentions$UserMentionsAdapterEventHandler(isEmbedded(), ChannelSelector.Companion.getInstance(), onInteractionStateUpdated), null, null, 48, null);
        addThreadSpineItemDecoration(widgetChatListAdapter);
        return widgetChatListAdapter;
    }

    private final WidgetUserMentionsBinding getBinding() {
        return (WidgetUserMentionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGlobalSearchDismissModel getDismissViewModel() {
        return (WidgetGlobalSearchDismissModel) this.dismissViewModel.getValue();
    }

    private final WidgetUserMentionsViewModel getViewModel() {
        return (WidgetUserMentionsViewModel) this.viewModel.getValue();
    }

    private final boolean isEmbedded() {
        return ((Boolean) this.isEmbedded.getValue()).booleanValue();
    }

    private final boolean isOnMentionsTab() {
        return this.storeTabsNavigation.getSelectedTab() == NavigationTab.MENTIONS;
    }

    private final Observable<WidgetUserMentions$Model> observeModel() {
        if (isEmbedded()) {
            return WidgetUserMentions$Model.Companion.get(this.mentionsLoader, NavigationTab.MENTIONS);
        }
        Observable observableY = StoreStream.Companion.getTabsNavigation().observeSelectedTab().Y(new WidgetUserMentions$observeModel$1(this));
        m.checkNotNullExpressionValue(observableY, "StoreStream.getTabsNavig…          }\n            }");
        return observableY;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.dispose();
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.disposeHandlers();
        }
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        WidgetUserMentions$Model model = getViewModel().getModel();
        if (model != null) {
            configureToolbar(model.getGuildName());
        }
        setActionBarTitleAccessibilityViewFocused();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        LinearLayoutManager layoutManager;
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (isEmbedded()) {
            onTabSelected();
            AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
            getBinding().f2682b.setNavigationOnClickListener(new WidgetUserMentions$onViewBound$1(this));
        } else {
            setActionBarTitle(2131894708);
        }
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) MGRecyclerAdapter.Companion.configure(createAdapter(new WidgetUserMentions$onViewBound$2(this.mentionsLoader)));
        this.mentionsAdapter = widgetChatListAdapter;
        if (widgetChatListAdapter != null && (layoutManager = widgetChatListAdapter.getLayoutManager()) != null) {
            layoutManager.setSmoothScrollbarEnabled(true);
        }
        WidgetChatListAdapter widgetChatListAdapter2 = this.mentionsAdapter;
        if (widgetChatListAdapter2 != null) {
            widgetChatListAdapter2.setMentionMeMessageLevelHighlighting(false);
        }
        Fragment parentFragment = getParentFragment();
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) (parentFragment instanceof WidgetTabsHost ? parentFragment : null);
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.MENTIONS, this);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observeModel()), this, null, 2, null), WidgetUserMentions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserMentions$onViewBoundOrOnResume$1(this), 62, (Object) null);
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
        WidgetUserMentions$Model$MessageLoader.tryLoad$default(this.mentionsLoader, null, 1, null);
    }
}
