package com.discord.widgets.guilds.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildsListBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$Companion;
import com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu;
import com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$Companion;
import com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu;
import com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$Companion;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.hubs.HubEmailArgs;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.nux.WidgetGuildTemplates;
import com.discord.widgets.nux.WidgetNavigationHelp;
import com.discord.widgets.nux.WidgetNavigationHelp$Companion;
import com.discord.widgets.tabs.BottomNavViewObserver;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList extends AppFragment implements WidgetGuildListAdapter$InteractionListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildsList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildsListBinding;", 0)};
    private WidgetGuildListAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BottomNavViewObserver bottomNavViewObserver;
    private View guildListAddHint;
    private WidgetChannelListUnreads guildListUnreads;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildsList() {
        super(R$layout.widget_guilds_list);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildsList$binding$2.INSTANCE, null, 2, null);
        this.bottomNavViewObserver = BottomNavViewObserver.Companion.getINSTANCE();
        WidgetGuildsList$viewModel$2 widgetGuildsList$viewModel$2 = WidgetGuildsList$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildsListViewModel.class), new WidgetGuildsList$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildsList$viewModel$2));
    }

    public static final /* synthetic */ void access$configureAddGuildHint(WidgetGuildsList widgetGuildsList, WidgetGuildsList$AddGuildHint widgetGuildsList$AddGuildHint) {
        widgetGuildsList.configureAddGuildHint(widgetGuildsList$AddGuildHint);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildsList widgetGuildsList, WidgetGuildsListViewModel$ViewState widgetGuildsListViewModel$ViewState) {
        widgetGuildsList.configureUI(widgetGuildsListViewModel$ViewState);
    }

    public static final /* synthetic */ void access$dismissAddGuildHint(WidgetGuildsList widgetGuildsList, boolean z2) {
        widgetGuildsList.dismissAddGuildHint(z2);
    }

    public static final /* synthetic */ WidgetGuildListAdapter access$getAdapter$p(WidgetGuildsList widgetGuildsList) {
        WidgetGuildListAdapter widgetGuildListAdapter = widgetGuildsList.adapter;
        if (widgetGuildListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        return widgetGuildListAdapter;
    }

    public static final /* synthetic */ WidgetGuildsListBinding access$getBinding$p(WidgetGuildsList widgetGuildsList) {
        return widgetGuildsList.getBinding();
    }

    public static final /* synthetic */ View access$getGuildListAddHint$p(WidgetGuildsList widgetGuildsList) {
        return widgetGuildsList.guildListAddHint;
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildsList widgetGuildsList, WidgetGuildsListViewModel$Event widgetGuildsListViewModel$Event) {
        widgetGuildsList.handleEvent(widgetGuildsListViewModel$Event);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetGuildsList widgetGuildsList, WidgetGuildListAdapter widgetGuildListAdapter) {
        widgetGuildsList.adapter = widgetGuildListAdapter;
    }

    public static final /* synthetic */ void access$setGuildListAddHint$p(WidgetGuildsList widgetGuildsList, View view) {
        widgetGuildsList.guildListAddHint = view;
    }

    private final void announceFolderToggle(GuildListItem$FolderItem item) {
        Object[] objArr = new Object[2];
        objArr[0] = b.k(this, item.isOpen() ? 2131887705 : 2131888963, new Object[0], null, 4);
        String name = item.getName();
        if (name == null) {
            name = "";
        }
        objArr[1] = name;
        AccessibilityUtils.INSTANCE.sendAnnouncement(requireContext(), a.P(objArr, 2, "%s, %s", "java.lang.String.format(this, *args)"));
    }

    private final void configureAddGuildHint(WidgetGuildsList$AddGuildHint addGuildHint) {
        if (addGuildHint.isAddGuildHint()) {
            StoreStream.Companion.getNux().updateNux(WidgetGuildsList$configureAddGuildHint$1.INSTANCE);
        }
        if (addGuildHint.isEligible()) {
            AnalyticsTracker.INSTANCE.showFirstServerTipTutorial();
            View view = this.guildListAddHint;
            if (view != null) {
                ViewExtensions.fadeIn$default(view, 0L, null, null, null, 15, null);
            }
        }
    }

    private final void configureBottomNavSpace() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(this.bottomNavViewObserver.observeHeight(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildsList$configureBottomNavSpace$1(this), 62, (Object) null);
    }

    private final void configureUI(WidgetGuildsListViewModel$ViewState viewState) {
        View view;
        if (viewState instanceof WidgetGuildsListViewModel$ViewState$Loaded) {
            WidgetGuildListAdapter widgetGuildListAdapter = this.adapter;
            if (widgetGuildListAdapter == null) {
                m.throwUninitializedPropertyAccessException("adapter");
            }
            WidgetGuildsListViewModel$ViewState$Loaded widgetGuildsListViewModel$ViewState$Loaded = (WidgetGuildsListViewModel$ViewState$Loaded) viewState;
            widgetGuildListAdapter.setItems(widgetGuildsListViewModel$ViewState$Loaded.getItems(), !widgetGuildsListViewModel$ViewState$Loaded.getWasDragResult());
            WidgetChannelListUnreads widgetChannelListUnreads = this.guildListUnreads;
            if (widgetChannelListUnreads != null) {
                widgetChannelListUnreads.onDatasetChanged(widgetGuildsListViewModel$ViewState$Loaded.getItems());
            }
            if (widgetGuildsListViewModel$ViewState$Loaded.getHasChannels() && (view = this.guildListAddHint) != null && view.getVisibility() == 0) {
                dismissAddGuildHint(false);
            }
        }
    }

    private final void dismissAddGuildHint(boolean wasAcknowledged) {
        if (wasAcknowledged) {
            View view = this.guildListAddHint;
            if (view != null) {
                ViewExtensions.fadeOut$default(view, 0L, null, null, 7, null);
            }
            AnalyticsTracker.INSTANCE.closeFirstServerTipTutorial(true);
            return;
        }
        View view2 = this.guildListAddHint;
        if (view2 == null || view2.getVisibility() != 0) {
            return;
        }
        View view3 = this.guildListAddHint;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        AnalyticsTracker.INSTANCE.closeFirstServerTipTutorial(false);
    }

    private final void focusFirstElement() {
        View childAt = getBinding().f2458b.getChildAt(0);
        if (childAt != null) {
            childAt.sendAccessibilityEvent(8);
        }
    }

    private final WidgetGuildsListBinding getBinding() {
        return (WidgetGuildsListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildsListViewModel getViewModel() {
        return (WidgetGuildsListViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildsListViewModel$Event event) {
        if (event instanceof WidgetGuildsListViewModel$Event$ShowChannelActions) {
            showChannelActions(((WidgetGuildsListViewModel$Event$ShowChannelActions) event).getChannelId());
            return;
        }
        if (event instanceof WidgetGuildsListViewModel$Event$ShowUnavailableGuilds) {
            showUnavailableGuildsToast(((WidgetGuildsListViewModel$Event$ShowUnavailableGuilds) event).getUnavailableGuildCount());
            return;
        }
        if (event instanceof WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility) {
            announceFolderToggle(((WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility) event).getItem());
            return;
        }
        if (m.areEqual(event, WidgetGuildsListViewModel$Event$ShowCreateGuild.INSTANCE)) {
            showCreateGuild();
            return;
        }
        if (m.areEqual(event, WidgetGuildsListViewModel$Event$ShowHubVerification.INSTANCE)) {
            showHubVerification();
        } else if (m.areEqual(event, WidgetGuildsListViewModel$Event$ShowHelp.INSTANCE)) {
            showHelp();
        } else {
            if (!m.areEqual(event, WidgetGuildsListViewModel$Event$FocusFirstElement.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            focusFirstElement();
        }
    }

    private final void setupRecycler() {
        RecyclerView recyclerView = getBinding().f2458b;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildList");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        WidgetGuildListAdapter widgetGuildListAdapter = new WidgetGuildListAdapter(linearLayoutManager, this);
        this.adapter = widgetGuildListAdapter;
        if (widgetGuildListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetGuildListAdapter.setHasStableIds(true);
        RecyclerView recyclerView2 = getBinding().f2458b;
        m.checkNotNullExpressionValue(recyclerView2, "binding.guildList");
        recyclerView2.setItemAnimator(null);
        RecyclerView recyclerView3 = getBinding().f2458b;
        m.checkNotNullExpressionValue(recyclerView3, "binding.guildList");
        recyclerView3.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView4 = getBinding().f2458b;
        m.checkNotNullExpressionValue(recyclerView4, "binding.guildList");
        WidgetGuildListAdapter widgetGuildListAdapter2 = this.adapter;
        if (widgetGuildListAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView4.setAdapter(widgetGuildListAdapter2);
        WidgetGuildListAdapter widgetGuildListAdapter3 = this.adapter;
        if (widgetGuildListAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        new ItemTouchHelper(new GuildsDragAndDropCallback(widgetGuildListAdapter3)).attachToRecyclerView(getBinding().f2458b);
        RecyclerView recyclerView5 = getBinding().f2458b;
        Drawable drawable = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), 2130968712, 0, 2, (Object) null));
        m.checkNotNull(drawable);
        m.checkNotNullExpressionValue(drawable, "ContextCompat.getDrawabl…children)\n            )!!");
        Drawable drawable2 = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), 2130968713, 0, 2, (Object) null));
        m.checkNotNull(drawable2);
        m.checkNotNullExpressionValue(drawable2, "ContextCompat.getDrawabl…children)\n            )!!");
        Drawable drawable3 = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), 2130968714, 0, 2, (Object) null));
        m.checkNotNull(drawable3);
        m.checkNotNullExpressionValue(drawable3, "ContextCompat.getDrawabl…children)\n            )!!");
        recyclerView5.addItemDecoration(new FolderItemDecoration(drawable, drawable2, drawable3, requireContext().getResources().getDimensionPixelSize(2131165293)));
    }

    private final void showChannelActions(long channelId) {
        WidgetChannelsListItemChannelActions$Companion widgetChannelsListItemChannelActions$Companion = WidgetChannelsListItemChannelActions.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetChannelsListItemChannelActions$Companion.show(parentFragmentManager, channelId);
    }

    private final void showCreateGuild() {
        dismissAddGuildHint(true);
        WidgetGuildTemplates.Companion.launch(requireContext(), CreateGuildTrigger.IN_APP, false);
    }

    private final void showHelp() {
        dismissAddGuildHint(true);
        WidgetNavigationHelp$Companion widgetNavigationHelp$Companion = WidgetNavigationHelp.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetNavigationHelp$Companion.show(parentFragmentManager);
    }

    private final void showHubVerification() {
        j.d(requireContext(), WidgetHubEmailFlow.class, new HubEmailArgs(null, 0, null, 7, null));
    }

    private final void showUnavailableGuildsToast(int unavailableGuildCount) {
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        b.a.d.m.h(getContext(), b.l(StringResourceUtilsKt.getQuantityString(resources, requireContext(), R$plurals.partial_outage_count, unavailableGuildCount, Integer.valueOf(unavailableGuildCount)), new Object[0], null, 2), 0, null, 12);
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter$InteractionListener
    public boolean onDrop() {
        return getViewModel().onDrop();
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter$InteractionListener
    public void onItemClicked(View view, GuildListItem item) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(item, "item");
        WidgetGuildsListViewModel viewModel = getViewModel();
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        viewModel.onItemClicked(item, contextRequireContext, parentFragmentManager);
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter$InteractionListener
    public void onItemLongPressed(View view, GuildListItem item) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(item, "item");
        boolean z2 = item instanceof GuildListItem$GuildItem;
        if (!z2 && !(item instanceof GuildListItem$FolderItem)) {
            getViewModel().onItemLongPressed(item);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        PointF pointF = new PointF(iArr[0] + DimenUtils.dpToPixels(64), iArr[1]);
        if (z2) {
            WidgetGuildContextMenu$Companion widgetGuildContextMenu$Companion = WidgetGuildContextMenu.Companion;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            widgetGuildContextMenu$Companion.show(fragmentActivityRequireActivity, pointF, ((GuildListItem$GuildItem) item).getGuild().getId());
            return;
        }
        if (item instanceof GuildListItem$FolderItem) {
            WidgetFolderContextMenu$Companion widgetFolderContextMenu$Companion = WidgetFolderContextMenu.Companion;
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
            widgetFolderContextMenu$Companion.show(fragmentActivityRequireActivity2, pointF, ((GuildListItem$FolderItem) item).getFolderId());
        }
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter$InteractionListener
    public void onItemMoved() {
        WidgetGuildContextMenu$Companion widgetGuildContextMenu$Companion = WidgetGuildContextMenu.Companion;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        widgetGuildContextMenu$Companion.hide(fragmentActivityRequireActivity, true);
        WidgetFolderContextMenu$Companion widgetFolderContextMenu$Companion = WidgetFolderContextMenu.Companion;
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
        widgetFolderContextMenu$Companion.hide(fragmentActivityRequireActivity2, true);
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter$InteractionListener
    public void onOperation(WidgetGuildListAdapter$Operation operation) {
        m.checkNotNullParameter(operation, "operation");
        if (operation instanceof WidgetGuildListAdapter$Operation$MoveAbove) {
            WidgetGuildListAdapter$Operation$MoveAbove widgetGuildListAdapter$Operation$MoveAbove = (WidgetGuildListAdapter$Operation$MoveAbove) operation;
            getViewModel().moveAbove(widgetGuildListAdapter$Operation$MoveAbove.getFromPosition(), widgetGuildListAdapter$Operation$MoveAbove.getTargetPosition());
        } else if (operation instanceof WidgetGuildListAdapter$Operation$MoveBelow) {
            WidgetGuildListAdapter$Operation$MoveBelow widgetGuildListAdapter$Operation$MoveBelow = (WidgetGuildListAdapter$Operation$MoveBelow) operation;
            getViewModel().moveBelow(widgetGuildListAdapter$Operation$MoveBelow.getFromPosition(), widgetGuildListAdapter$Operation$MoveBelow.getTargetPosition());
        } else if (operation instanceof WidgetGuildListAdapter$Operation$TargetOperation) {
            WidgetGuildListAdapter$Operation$TargetOperation widgetGuildListAdapter$Operation$TargetOperation = (WidgetGuildListAdapter$Operation$TargetOperation) operation;
            getViewModel().target(widgetGuildListAdapter$Operation$TargetOperation.getFromPosition(), widgetGuildListAdapter$Operation$TargetOperation.getTargetPosition());
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildsList$onResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().listenForEvents(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildsList$onResume$2(this), 62, (Object) null);
        WidgetGuildsList$AddGuildHint$Companion widgetGuildsList$AddGuildHint$Companion = WidgetGuildsList$AddGuildHint.Companion;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(widgetGuildsList$AddGuildHint$Companion.get(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildsList$onResume$3(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(widgetGuildsList$AddGuildHint$Companion.getDismissAction(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildsList$onResume$4(this), 62, (Object) null);
        configureBottomNavSpace();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setupRecycler();
        ViewStub viewStub = getBinding().c;
        m.checkNotNullExpressionValue(viewStub, "binding.guildListUnreadsStub");
        RecyclerView recyclerView = getBinding().f2458b;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildList");
        WidgetChannelListUnreads widgetChannelListUnreads = new WidgetChannelListUnreads(viewStub, recyclerView, null, new WidgetGuildsList$onViewBound$1(this), 0, 0, false, 116, null);
        this.guildListUnreads = widgetChannelListUnreads;
        if (widgetChannelListUnreads != null) {
            widgetChannelListUnreads.setMentionResId(2131886090);
        }
        WidgetChannelListUnreads widgetChannelListUnreads2 = this.guildListUnreads;
        if (widgetChannelListUnreads2 != null) {
            widgetChannelListUnreads2.setUnreadsEnabled(false);
        }
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetHome)) {
            parentFragment = null;
        }
        WidgetHome widgetHome = (WidgetHome) parentFragment;
        if (widgetHome != null) {
            widgetHome.setOnGuildListAddHintCreate(new WidgetGuildsList$onViewBound$2(this));
        }
    }
}
