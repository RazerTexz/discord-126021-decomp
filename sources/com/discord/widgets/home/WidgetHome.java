package com.discord.widgets.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.i5;
import b.a.i.j5;
import b.a.i.k5;
import b.a.i.l5;
import b.a.i.n5;
import b.a.o.b;
import b.a.o.b$a;
import b.a.o.b$b;
import b.d.b.a.a;
import com.discord.R$anim;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHomeBinding;
import com.discord.panels.OverlappingPanelsLayout$LockState;
import com.discord.panels.OverlappingPanelsLayout$Panel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$Channel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
import com.discord.stores.StoreConnectionOpen;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreNux$NuxState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUser;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.utilities.surveys.SurveyUtils;
import com.discord.utilities.surveys.SurveyUtils$Survey;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.accessibility.AccessibilityDetectionNavigator;
import com.discord.widgets.botuikit.ModalComponent;
import com.discord.widgets.botuikit.ModalComponent$Companion;
import com.discord.widgets.botuikit.ModalComponent$Options;
import com.discord.widgets.channels.WidgetChannelOnboarding;
import com.discord.widgets.channels.WidgetChannelOnboarding$Companion;
import com.discord.widgets.chat.input.SmoothKeyboardReactionHelper;
import com.discord.widgets.chat.list.WidgetChatList;
import com.discord.widgets.directories.WidgetDirectoryChannel;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheet;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheet$Companion;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet$Companion;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.notice.WidgetNoticeNuxSamsungLink;
import com.discord.widgets.playstation.WidgetPlaystationIntegrationUpsellBottomSheet;
import com.discord.widgets.playstation.WidgetPlaystationIntegrationUpsellBottomSheet$Companion;
import com.discord.widgets.servers.guild_role_subscription.upsell.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet;
import com.discord.widgets.servers.guild_role_subscription.upsell.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$Companion;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState$State;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$Companion;
import com.google.android.material.appbar.AppBarLayout;
import d0.t.m0;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome extends AppFragment implements OnTabSelectedListener, b$a {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHome.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHomeBinding;", 0)};
    public static final WidgetHome$Companion Companion = new WidgetHome$Companion(null);
    private static final long DELAY_DRAWER_OPEN_FINISH = 2000;
    private static final long DELAY_DRAWER_OPEN_START = 1000;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Set<Integer> fixedPositionViewIds;
    private final WidgetGlobalStatusIndicatorState globalStatusIndicatorStateObserver;
    private final LeftPanelManager leftPanelManager;
    private final LocaleManager localeManager;
    private Function1<? super View, Unit> onGuildListAddHintCreate;
    private WidgetHomePanelLoading panelLoading;
    private WidgetHomePanelNsfw panelNsfw;
    private final StoreTabsNavigation storeTabsNavigation;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetHome() {
        super(R$layout.widget_home);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHome$binding$2.INSTANCE, null, 2, null);
        WidgetHome$viewModel$2 widgetHome$viewModel$2 = WidgetHome$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHomeViewModel.class), new WidgetHome$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetHome$viewModel$2));
        this.fixedPositionViewIds = m0.setOf(Integer.valueOf(R$id.unread));
        this.leftPanelManager = new LeftPanelManager(null, null, 3, null);
        this.localeManager = new LocaleManager();
        this.onGuildListAddHintCreate = WidgetHome$onGuildListAddHintCreate$1.INSTANCE;
        this.storeTabsNavigation = StoreStream.Companion.getTabsNavigation();
        this.globalStatusIndicatorStateObserver = WidgetGlobalStatusIndicatorState.Provider.get();
    }

    public static final /* synthetic */ void access$configureFirstOpen(WidgetHome widgetHome) {
        widgetHome.configureFirstOpen();
    }

    public static final /* synthetic */ void access$configureUI(WidgetHome widgetHome, WidgetHomeModel widgetHomeModel) {
        widgetHome.configureUI(widgetHomeModel);
    }

    public static final /* synthetic */ WidgetHomeBinding access$getBinding$p(WidgetHome widgetHome) {
        return widgetHome.getBinding();
    }

    public static final /* synthetic */ LocaleManager access$getLocaleManager$p(WidgetHome widgetHome) {
        return widgetHome.localeManager;
    }

    public static final /* synthetic */ WidgetHomePanelNsfw access$getPanelNsfw$p(WidgetHome widgetHome) {
        return widgetHome.panelNsfw;
    }

    public static final /* synthetic */ WidgetHomeViewModel access$getViewModel$p(WidgetHome widgetHome) {
        return widgetHome.getViewModel();
    }

    public static final /* synthetic */ boolean access$handleBackPressed(WidgetHome widgetHome) {
        return widgetHome.handleBackPressed();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetHome widgetHome, WidgetHomeViewModel$Event widgetHomeViewModel$Event) {
        widgetHome.handleEvent(widgetHomeViewModel$Event);
    }

    public static final /* synthetic */ void access$handleGlobalStatusIndicatorState(WidgetHome widgetHome, WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State) {
        widgetHome.handleGlobalStatusIndicatorState(widgetGlobalStatusIndicatorState$State);
    }

    public static final /* synthetic */ void access$handleViewState(WidgetHome widgetHome, WidgetHomeViewModel$ViewState widgetHomeViewModel$ViewState) {
        widgetHome.handleViewState(widgetHomeViewModel$ViewState);
    }

    public static final /* synthetic */ void access$maybeShowHubEmailUpsell(WidgetHome widgetHome) {
        widgetHome.maybeShowHubEmailUpsell();
    }

    public static final /* synthetic */ void access$maybeToggleChannel(WidgetHome widgetHome, WidgetHomeModel widgetHomeModel) {
        widgetHome.maybeToggleChannel(widgetHomeModel);
    }

    public static final /* synthetic */ void access$onNsfwToggle(WidgetHome widgetHome, boolean z2) {
        widgetHome.onNsfwToggle(z2);
    }

    public static final /* synthetic */ void access$setPanelNsfw$p(WidgetHome widgetHome, WidgetHomePanelNsfw widgetHomePanelNsfw) {
        widgetHome.panelNsfw = widgetHomePanelNsfw;
    }

    public static final /* synthetic */ void access$showInteractionModal(WidgetHome widgetHome, InteractionModalCreate interactionModalCreate) {
        widgetHome.showInteractionModal(interactionModalCreate);
    }

    public static final /* synthetic */ void access$showSurvey(WidgetHome widgetHome, SurveyUtils$Survey surveyUtils$Survey) {
        widgetHome.showSurvey(surveyUtils$Survey);
    }

    public static final /* synthetic */ void access$showUrgentMessageDialog(WidgetHome widgetHome) {
        widgetHome.showUrgentMessageDialog();
    }

    private final void animatePeek(WidgetHomeViewModel$Event event) {
        View view;
        View view2;
        long j;
        float right;
        float right2;
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            return;
        }
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R$id.widget_chat_list);
        if (!(fragmentFindFragmentById instanceof WidgetChatList)) {
            fragmentFindFragmentById = null;
        }
        WidgetChatList widgetChatList = (WidgetChatList) fragmentFindFragmentById;
        if (widgetChatList != null) {
            i5 i5Var = getBinding().d;
            m.checkNotNullExpressionValue(i5Var, "binding.panelCenter");
            RoundedRelativeLayout roundedRelativeLayout = i5Var.a;
            m.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelCenter.root");
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(roundedRelativeLayout.getMeasuredWidth(), roundedRelativeLayout.getMeasuredHeight(), Bitmap$Config.ARGB_8888);
            roundedRelativeLayout.draw(new Canvas(bitmapCreateBitmap));
            getBinding().g.setImageBitmap(bitmapCreateBitmap);
            if (event instanceof WidgetHomeViewModel$Event$AnimatePeekIn) {
                ImageView imageView = getBinding().g;
                m.checkNotNullExpressionValue(imageView, "binding.peekTransitionBitmap");
                right2 = roundedRelativeLayout.getRight();
                view2 = imageView;
                view = roundedRelativeLayout;
                j = 250;
                right = 0.0f;
            } else {
                view = getBinding().g;
                m.checkNotNullExpressionValue(view, "binding.peekTransitionBitmap");
                view2 = roundedRelativeLayout;
                j = 200;
                right = roundedRelativeLayout.getRight();
                right2 = 0.0f;
            }
            view.setTranslationX(right2);
            view.animate().setDuration(j).translationX(right).withEndAction(new WidgetHome$animatePeek$1(this, widgetChatList)).start();
            view2.setTranslationX(right2 - roundedRelativeLayout.getMeasuredWidth());
            view2.animate().setDuration(j).translationX(right - roundedRelativeLayout.getMeasuredWidth()).start();
            widgetChatList.disableItemAnimations();
            ImageView imageView2 = getBinding().g;
            m.checkNotNullExpressionValue(imageView2, "binding.peekTransitionBitmap");
            imageView2.setVisibility(0);
        }
    }

    private final void configureFirstOpen() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableZ = Observable.j(StoreConnectionOpen.observeConnectionOpen$default(storeStream$Companion.getConnectionOpen(), false, 1, null), storeStream$Companion.getChannels().observeGuildAndPrivateChannels(), WidgetHome$configureFirstOpen$1.INSTANCE).z();
        m.checkNotNullExpressionValue(observableZ, "Observable\n        .comb…       }\n        .first()");
        ObservableExtensionsKt.appSubscribe$default(observableZ, WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$configureFirstOpen$2(this), 62, (Object) null);
    }

    private final void configureLeftPanel() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(this.leftPanelManager.observeLockState()), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$configureLeftPanel$1(this), 62, (Object) null);
    }

    private final void configureNavigationDrawerAction(StoreNavigation storeNavigation) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeNavigation.getNavigationPanelAction(), this, null, 2, null), StoreNavigation.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$configureNavigationDrawerAction$1(this, storeNavigation), 62, (Object) null);
    }

    private final void configureOverlappingPanels() {
        getBinding().c.registerStartPanelStateListeners(new WidgetHome$configureOverlappingPanels$1(this));
        getBinding().c.registerEndPanelStateListeners(new WidgetHome$configureOverlappingPanels$2(this));
    }

    private final void configureUI(WidgetHomeModel widgetHomeModel) {
        getViewModel().setWidgetHomeModel$app_productionGoogleRelease(widgetHomeModel);
        if (isOnHomeTab()) {
            WidgetHomeHeaderManager widgetHomeHeaderManager = WidgetHomeHeaderManager.INSTANCE;
            WidgetHomeBinding binding = getBinding();
            m.checkNotNullExpressionValue(binding, "binding");
            widgetHomeHeaderManager.configure(this, widgetHomeModel, binding);
        }
    }

    private final void enqueueEventDetails(long guildScheduledEventId) {
        WidgetGuildScheduledEventDetailsBottomSheet.Companion.enqueue(guildScheduledEventId);
    }

    private final WidgetHomeBinding getBinding() {
        return (WidgetHomeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetHomeViewModel getViewModel() {
        return (WidgetHomeViewModel) this.viewModel.getValue();
    }

    private final boolean handleBackPressed() {
        int iOrdinal = getBinding().c.getSelectedPanel().ordinal();
        if (iOrdinal == 0) {
            requireActivity().moveTaskToBack(true);
        } else if (iOrdinal == 1) {
            handleCenterPanelBack$app_productionGoogleRelease();
        } else if (iOrdinal == 2) {
            getBinding().c.closePanels();
        }
        return true;
    }

    private final void handleEvent(WidgetHomeViewModel$Event event) {
        if (m.areEqual(event, WidgetHomeViewModel$Event$OpenLeftPanel.INSTANCE)) {
            getBinding().c.openStartPanel();
            return;
        }
        if (m.areEqual(event, WidgetHomeViewModel$Event$ClosePanels.INSTANCE)) {
            getBinding().c.closePanels();
            return;
        }
        if (m.areEqual(event, WidgetHomeViewModel$Event$UnlockLeftPanel.INSTANCE)) {
            getBinding().c.setStartPanelLockState(OverlappingPanelsLayout$LockState.UNLOCKED);
            return;
        }
        if (m.areEqual(event, WidgetHomeViewModel$Event$ShowChannelOnboardingSheet.INSTANCE)) {
            showChannelOnboardingSheet();
            return;
        }
        if (m.areEqual(event, WidgetHomeViewModel$Event$AnimatePeekIn.INSTANCE) || m.areEqual(event, WidgetHomeViewModel$Event$AnimatePeekOut.INSTANCE)) {
            animatePeek(event);
            return;
        }
        if (event instanceof WidgetHomeViewModel$Event$ShowGuildWelcomeSheet) {
            showWelcomeSheet$default(this, ((WidgetHomeViewModel$Event$ShowGuildWelcomeSheet) event).getGuildId(), null, 2, null);
            return;
        }
        if (event instanceof WidgetHomeViewModel$Event$ShowGuildEventUpsell) {
            showGuildEventUpsell(((WidgetHomeViewModel$Event$ShowGuildEventUpsell) event).getGuildId());
        } else if (event instanceof WidgetHomeViewModel$Event$ShowPlaystationUpsell) {
            showPlaystationUpsell();
        } else {
            if (!(event instanceof WidgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell)) {
                throw new NoWhenBranchMatchedException();
            }
            showGuildRoleSubscriptionUpsell(((WidgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell) event).getGuildId());
        }
    }

    private final void handleGlobalStatusIndicatorState(WidgetGlobalStatusIndicatorState$State state) {
        if (state.isCustomBackground()) {
            unroundPanelCorners();
        } else {
            roundPanelCorners();
        }
    }

    private final void handleHomeConfig(HomeConfig homeConfig) {
        if ((homeConfig != null ? homeConfig.getGuildWelcomeSheetId() : null) != null && homeConfig.getGuildScheduledEventId() != null) {
            showWelcomeSheet(homeConfig.getGuildWelcomeSheetId().longValue(), homeConfig.getGuildScheduledEventId());
            return;
        }
        if ((homeConfig != null ? homeConfig.getGuildWelcomeSheetId() : null) != null) {
            showWelcomeSheet$default(this, homeConfig.getGuildWelcomeSheetId().longValue(), null, 2, null);
            return;
        }
        if ((homeConfig != null ? homeConfig.getGuildScheduledEventId() : null) != null) {
            enqueueEventDetails(homeConfig.getGuildScheduledEventId().longValue());
        }
    }

    private final void handleViewState(WidgetHomeViewModel$ViewState viewState) {
        getBinding().c.handleStartPanelState(viewState.getLeftPanelState());
        getBinding().c.handleEndPanelState(viewState.getRightPanelState());
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            WidgetHomePanelNsfw.configureUI$default(widgetHomePanelNsfw, viewState.getGuildId(), viewState.isChannelNsfw(), viewState.isNsfwUnconsented(), viewState.getNsfwAllowed(), getBinding().d.c.f142b, new WidgetHome$handleViewState$1(this), null, 64, null);
        }
    }

    private final boolean isOnHomeTab() {
        return this.storeTabsNavigation.getSelectedTab() == NavigationTab.HOME;
    }

    private final void maybeShowHubEmailUpsell() {
        StoreNotices notices = StoreStream.Companion.getNotices();
        String name = WidgetHubEmailFlow.Companion.getNAME();
        m.checkNotNullExpressionValue(name, "WidgetHubEmailFlow.NAME");
        notices.requestToShow(new StoreNotices$Notice(name, null, 0L, 0, true, d0.t.m.listOf(a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, true, RecyclerView.FOREVER_NS, WidgetHome$maybeShowHubEmailUpsell$1.INSTANCE, 6, null));
    }

    private final void maybeToggleChannel(WidgetHomeModel widgetHomeModel) {
        Channel channel = widgetHomeModel.getChannel();
        boolean z2 = channel != null && ChannelUtils.o(channel);
        Channel channel2 = widgetHomeModel.getChannel();
        Long lValueOf = channel2 != null ? Long.valueOf(channel2.getGuildId()) : null;
        boolean z3 = lValueOf != null && ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, lValueOf.longValue(), null, 2, null);
        Channel channel3 = widgetHomeModel.getChannel();
        boolean z4 = channel3 != null && ChannelUtils.q(channel3) && z3;
        FragmentContainerView fragmentContainerView = getBinding().d.d;
        m.checkNotNullExpressionValue(fragmentContainerView, "binding.panelCenter.widgetHomePanelDirectory");
        fragmentContainerView.setVisibility(z2 ? 0 : 8);
        FragmentContainerView fragmentContainerView2 = getBinding().d.f136b;
        m.checkNotNullExpressionValue(fragmentContainerView2, "binding.panelCenter.widgetForumChannelList");
        fragmentContainerView2.setVisibility(z4 ? 0 : 8);
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R$id.widget_home_panel_directory);
        if (!(fragmentFindFragmentById instanceof WidgetDirectoryChannel)) {
            fragmentFindFragmentById = null;
        }
        WidgetDirectoryChannel widgetDirectoryChannel = (WidgetDirectoryChannel) fragmentFindFragmentById;
        if (widgetDirectoryChannel != null) {
            WidgetDirectoryChannel.bindGestureObservers$default(widgetDirectoryChannel, z2, null, 2, null);
        }
        j5 j5Var = getBinding().d.c;
        m.checkNotNullExpressionValue(j5Var, "binding.panelCenter.widgetHomePanelCenterChat");
        ConstraintLayout constraintLayout = j5Var.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.panelCenter.widgetHomePanelCenterChat.root");
        constraintLayout.setVisibility((z2 || z4) ? false : true ? 0 : 8);
    }

    private final void onNsfwToggle(boolean isHidden) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        Fragment fragmentFindFragmentById = childFragmentManager.findFragmentById(R$id.widget_chat_list);
        if (fragmentFindFragmentById != null) {
            m.checkNotNullExpressionValue(fragmentFindFragmentById, "fragmentManager.findFrag…dget_chat_list) ?: return");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
            if (isHidden) {
                fragmentTransactionBeginTransaction.hide(fragmentFindFragmentById);
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentById);
            }
            fragmentTransactionBeginTransaction.commit();
        }
    }

    private final void roundPanelCorners() {
        setPanelCorners(DimenUtils.dpToPixels(8));
    }

    private final void setPanelCorners(float radius) {
        i5 i5Var = getBinding().d;
        m.checkNotNullExpressionValue(i5Var, "binding.panelCenter");
        i5Var.a.updateTopLeftRadius(radius);
        i5 i5Var2 = getBinding().d;
        m.checkNotNullExpressionValue(i5Var2, "binding.panelCenter");
        i5Var2.a.updateTopRightRadius(radius);
        getBinding().f.f169b.updateTopLeftRadius(radius);
        getBinding().f.f169b.updateTopRightRadius(radius);
    }

    private final void setPanelWindowInsetsListeners() {
        FrameLayout frameLayout = getBinding().h;
        m.checkNotNullExpressionValue(frameLayout, "binding.widgetHomeContainer");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout);
        HomePanelsLayout homePanelsLayout = getBinding().c;
        m.checkNotNullExpressionValue(homePanelsLayout, "binding.overlappingPanels");
        ViewExtensions.setForwardingWindowInsetsListener(homePanelsLayout);
        l5 l5Var = getBinding().e;
        m.checkNotNullExpressionValue(l5Var, "binding.panelLeft");
        ViewCompat.setOnApplyWindowInsetsListener(l5Var.a, new WidgetHome$setPanelWindowInsetsListeners$1(this));
        i5 i5Var = getBinding().d;
        m.checkNotNullExpressionValue(i5Var, "binding.panelCenter");
        ViewCompat.setOnApplyWindowInsetsListener(i5Var.a, new WidgetHome$setPanelWindowInsetsListeners$2(this));
        n5 n5Var = getBinding().f;
        m.checkNotNullExpressionValue(n5Var, "binding.panelRight");
        ViewCompat.setOnApplyWindowInsetsListener(n5Var.a, new WidgetHome$setPanelWindowInsetsListeners$3(this));
    }

    private final void setupSmoothKeyboardReaction() {
        i5 i5Var = getBinding().d;
        m.checkNotNullExpressionValue(i5Var, "binding.panelCenter");
        RoundedRelativeLayout roundedRelativeLayout = i5Var.a;
        m.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelCenter.root");
        Iterator<View> it = ViewGroupKt.iterator(roundedRelativeLayout);
        while (it.hasNext()) {
            View next = it.next();
            if (!(next instanceof AppBarLayout) && !this.fixedPositionViewIds.contains(Integer.valueOf(next.getId()))) {
                SmoothKeyboardReactionHelper.INSTANCE.install(next);
            }
        }
    }

    private final void showChannelOnboardingSheet() {
        WidgetChannelOnboarding$Companion widgetChannelOnboarding$Companion = WidgetChannelOnboarding.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetChannelOnboarding$Companion.show(parentFragmentManager);
    }

    private final void showGuildEventUpsell(long guildId) {
        WidgetGuildScheduledEventUpsellBottomSheet$Companion widgetGuildScheduledEventUpsellBottomSheet$Companion = WidgetGuildScheduledEventUpsellBottomSheet.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetGuildScheduledEventUpsellBottomSheet$Companion.launch(parentFragmentManager, guildId);
    }

    private final void showGuildRoleSubscriptionUpsell(long guildId) {
        WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$Companion widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$Companion = WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$Companion.show(parentFragmentManager, guildId);
    }

    private final void showInteractionModal(InteractionModalCreate modal) {
        Context context = getContext();
        if (context != null) {
            ModalComponent$Companion modalComponent$Companion = ModalComponent.Companion;
            m.checkNotNullExpressionValue(context, "context");
            modalComponent$Companion.show(context, new ModalComponent$Options(modal));
        }
    }

    private final void showPlaystationUpsell() {
        WidgetPlaystationIntegrationUpsellBottomSheet$Companion widgetPlaystationIntegrationUpsellBottomSheet$Companion = WidgetPlaystationIntegrationUpsellBottomSheet.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetPlaystationIntegrationUpsellBottomSheet$Companion.show(parentFragmentManager);
    }

    private final void showSurvey(SurveyUtils$Survey survey) {
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice(survey.getNoticeKey(), null, 0L, 5, true, null, 0L, false, 0L, new WidgetHome$showSurvey$1(survey), 486, null));
    }

    private final void showUrgentMessageDialog() {
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice("URGENT_MESSAGE_DIALOG", null, 0L, 0, false, null, 0L, false, 0L, WidgetHome$showUrgentMessageDialog$1.INSTANCE, Opcodes.IF_ACMPNE, null));
    }

    private final void showWelcomeSheet(long guildId, Long guildScheduledEventId) {
        if (StoreStream.Companion.getGuildWelcomeScreens().hasWelcomeScreenBeenSeen(guildId)) {
            return;
        }
        WidgetGuildWelcomeSheet$Companion widgetGuildWelcomeSheet$Companion = WidgetGuildWelcomeSheet.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetGuildWelcomeSheet$Companion.show(parentFragmentManager, guildId, guildScheduledEventId);
    }

    public static /* synthetic */ void showWelcomeSheet$default(WidgetHome widgetHome, long j, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        widgetHome.showWelcomeSheet(j, l);
    }

    private final void unroundPanelCorners() {
        setPanelCorners(0.0f);
    }

    public final PanelLayout getPanelLayout() {
        HomePanelsLayout homePanelsLayout = getBinding().c;
        m.checkNotNullExpressionValue(homePanelsLayout, "binding.overlappingPanels");
        return homePanelsLayout;
    }

    public final Toolbar getToolbar() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.toolbar;
        }
        return null;
    }

    public final TextView getUnreadCountView() {
        k5 k5Var = getBinding().d.c.c;
        m.checkNotNullExpressionValue(k5Var, "binding.panelCenter.widg…omePanelCenterChat.unread");
        TextView textView = k5Var.a;
        m.checkNotNullExpressionValue(textView, "binding.panelCenter.widg…nelCenterChat.unread.root");
        return textView;
    }

    public final void handleCenterPanelBack$app_productionGoogleRelease() {
        WidgetHomeModel widgetHomeModel$app_productionGoogleRelease = getViewModel().getWidgetHomeModel();
        StoreChannelsSelected$ResolvedSelectedChannel selectedChannel = widgetHomeModel$app_productionGoogleRelease != null ? widgetHomeModel$app_productionGoogleRelease.getSelectedChannel() : null;
        WidgetHomeModel widgetHomeModel$app_productionGoogleRelease2 = getViewModel().getWidgetHomeModel();
        Channel selectedVoiceChannel = widgetHomeModel$app_productionGoogleRelease2 != null ? widgetHomeModel$app_productionGoogleRelease2.getSelectedVoiceChannel() : null;
        if (selectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft) {
            ChannelSelector.Companion.getInstance().dismissCreateThread();
            return;
        }
        boolean z2 = selectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$Channel;
        if (z2) {
            StoreChannelsSelected$ResolvedSelectedChannel$Channel storeChannelsSelected$ResolvedSelectedChannel$Channel = (StoreChannelsSelected$ResolvedSelectedChannel$Channel) selectedChannel;
            if (storeChannelsSelected$ResolvedSelectedChannel$Channel.getPeekParent() != null) {
                ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), storeChannelsSelected$ResolvedSelectedChannel$Channel.getChannel().getGuildId(), storeChannelsSelected$ResolvedSelectedChannel$Channel.getPeekParent().longValue(), null, null, 12, null);
                return;
            }
        }
        if (z2) {
            StoreChannelsSelected$ResolvedSelectedChannel$Channel storeChannelsSelected$ResolvedSelectedChannel$Channel2 = (StoreChannelsSelected$ResolvedSelectedChannel$Channel) selectedChannel;
            if (ChannelUtils.J(storeChannelsSelected$ResolvedSelectedChannel$Channel2.getChannel())) {
                if (selectedVoiceChannel == null || ChannelUtils.B(selectedVoiceChannel) || selectedVoiceChannel.getId() != selectedChannel.getId()) {
                    WidgetCallPreviewFullscreen$Companion.launch$default(WidgetCallPreviewFullscreen.Companion, requireContext(), storeChannelsSelected$ResolvedSelectedChannel$Channel2.getChannel().getId(), null, 4, null);
                    requireAppActivity().overridePendingTransition(R$anim.activity_slide_horizontal_close_in, R$anim.activity_slide_horizontal_close_out);
                    return;
                } else {
                    WidgetCallFullscreen$Companion.launch$default(WidgetCallFullscreen.Companion, requireContext(), ((StoreChannelsSelected$ResolvedSelectedChannel$Channel) selectedChannel).getChannel().getId(), false, null, null, 28, null);
                    requireAppActivity().overridePendingTransition(R$anim.activity_slide_horizontal_close_in, R$anim.activity_slide_horizontal_close_out);
                    return;
                }
            }
        }
        getBinding().c.openStartPanel();
    }

    public final void lockCloseRightPanel(boolean lock) {
        getBinding().c.setEndPanelLockState(lock ? OverlappingPanelsLayout$LockState.CLOSE : OverlappingPanelsLayout$LockState.UNLOCKED);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b.a.o.a aVar = b.a.o.a.f251b;
        WidgetHome$onCreate$1 widgetHome$onCreate$1 = new WidgetHome$onCreate$1(this);
        m.checkParameterIsNotNull(widgetHome$onCreate$1, "provider");
        b.a.o.a.a = widgetHome$onCreate$1;
    }

    @Override // b.a.o.b$a
    public void onGestureRegionsUpdate(List<Rect> gestureRegions) {
        m.checkNotNullParameter(gestureRegions, "gestureRegions");
        getBinding().c.setChildGestureRegions(gestureRegions);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        b bVarA = b$b.a();
        m.checkParameterIsNotNull(this, "gestureRegionsListener");
        bVarA.l.remove(this);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        b bVarA = b$b.a();
        m.checkParameterIsNotNull(this, "gestureRegionsListener");
        onGestureRegionsUpdate(u.toList(bVarA.j.values()));
        bVarA.l.add(this);
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        WidgetHomeModel widgetHomeModel$app_productionGoogleRelease = getViewModel().getWidgetHomeModel();
        if (widgetHomeModel$app_productionGoogleRelease != null) {
            WidgetHomeHeaderManager widgetHomeHeaderManager = WidgetHomeHeaderManager.INSTANCE;
            WidgetHomeBinding binding = getBinding();
            m.checkNotNullExpressionValue(binding, "binding");
            widgetHomeHeaderManager.configure(this, widgetHomeModel$app_productionGoogleRelease, binding);
        }
        if (getBinding().c.getSelectedPanel() == OverlappingPanelsLayout$Panel.CENTER) {
            setActionBarTitleAccessibilityViewFocused();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        boolean z2 = TextUtils.getLayoutDirectionFromLocale(new LocaleManager().getPrimaryLocale(requireContext())) == 0;
        RoundedRelativeLayout roundedRelativeLayout = getBinding().f.f169b;
        m.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelRight.mainPanelRightRoundedContainer");
        ViewGroup$LayoutParams layoutParams = roundedRelativeLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        int iDpToPixels = DimenUtils.dpToPixels(8);
        int i = z2 ? viewGroup$MarginLayoutParams.leftMargin : iDpToPixels;
        if (!z2) {
            iDpToPixels = viewGroup$MarginLayoutParams.rightMargin;
        }
        viewGroup$MarginLayoutParams.setMargins(i, viewGroup$MarginLayoutParams.topMargin, iDpToPixels, viewGroup$MarginLayoutParams.bottomMargin);
        RoundedRelativeLayout roundedRelativeLayout2 = getBinding().f.f169b;
        m.checkNotNullExpressionValue(roundedRelativeLayout2, "binding.panelRight.mainPanelRightRoundedContainer");
        roundedRelativeLayout2.setLayoutParams(viewGroup$MarginLayoutParams);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetTabsHost)) {
            parentFragment = null;
        }
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) parentFragment;
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.HOME, this);
        }
        this.panelNsfw = new WidgetHomePanelNsfw(this);
        WidgetHomeBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        this.panelLoading = new WidgetHomePanelLoading(binding);
        Function1<? super View, Unit> function1 = this.onGuildListAddHintCreate;
        TextView textView = getBinding().e.f155b;
        m.checkNotNullExpressionValue(textView, "binding.panelLeft.guildListAddHint");
        function1.invoke(textView);
        AppFragment.setOnBackPressed$default(this, new WidgetHome$onViewBound$1(this), 0, 2, null);
        WidgetNoticeNuxSamsungLink.Companion.enqueue(requireContext(), ClockFactory.get());
        setPanelWindowInsetsListeners();
        setupSmoothKeyboardReaction();
        Observable<StoreNux$NuxState> observableZ = StoreStream.Companion.getNux().getNuxState().y(new WidgetHome$onViewBound$2(this)).z();
        m.checkNotNullExpressionValue(observableZ, "StoreStream\n        .get…       }\n        .first()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableZ, 0L, false, 1, null), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$onViewBound$3(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG");
        if (!(serializableExtra instanceof HomeConfig)) {
            serializableExtra = null;
        }
        handleHomeConfig((HomeConfig) serializableExtra);
        WidgetHomePanelLoading widgetHomePanelLoading = this.panelLoading;
        if (widgetHomePanelLoading != null) {
            widgetHomePanelLoading.configure(this);
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$onViewBoundOrOnResume$2(this), 62, (Object) null);
        WidgetHomeModel$Companion widgetHomeModel$Companion = WidgetHomeModel.Companion;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(widgetHomeModel$Companion.get(), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$onViewBoundOrOnResume$3(this), 62, (Object) null);
        Observable observableS = ObservableExtensionsKt.ui$default(widgetHomeModel$Companion.get(), this, null, 2, null).s(WidgetHome$onViewBoundOrOnResume$4.INSTANCE);
        m.checkNotNullExpressionValue(observableS, "WidgetHomeModel\n        …lId == model2.channelId }");
        ObservableExtensionsKt.appSubscribe$default(observableS, WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$onViewBoundOrOnResume$5(this), 62, (Object) null);
        AccessibilityDetectionNavigator.INSTANCE.enqueueNoticeWhenEnabled(this);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        configureNavigationDrawerAction(storeStream$Companion.getNavigation());
        configureOverlappingPanels();
        Observable observableG = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(SurveyUtils.INSTANCE.getSurveyToShow(), 0L, false, 3, null), this, null, 2, null).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableY = observableG.y(WidgetHome$onViewBoundOrOnResume$6.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "SurveyUtils\n        .get…SurveyUtils.Survey.None }");
        ObservableExtensionsKt.appSubscribe$default(observableY, WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$onViewBoundOrOnResume$7(this), 62, (Object) null);
        Observable<StoreNux$NuxState> observableY2 = storeStream$Companion.getNux().getNuxState().y(WidgetHome$onViewBoundOrOnResume$8.INSTANCE);
        m.checkNotNullExpressionValue(observableY2, "StoreStream\n        .get… .filter { it.firstOpen }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY2, 0L, false, 1, null), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$onViewBoundOrOnResume$9(this), 62, (Object) null);
        Observable observableY3 = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null).y(WidgetHome$onViewBoundOrOnResume$10.INSTANCE);
        m.checkNotNullExpressionValue(observableY3, "StoreStream\n        .get…hasUnreadUrgentMessages }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableY3, this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$onViewBoundOrOnResume$11(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeStream$Companion.getInteractions().observeModalCreate(), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$onViewBoundOrOnResume$12(this), 62, (Object) null);
        configureLeftPanel();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(this.globalStatusIndicatorStateObserver.observeState(), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHome$onViewBoundOrOnResume$13(this), 62, (Object) null);
    }

    public final void setOnGuildListAddHintCreate(Function1<? super View, Unit> onGuildListAddHintCreate) {
        m.checkNotNullParameter(onGuildListAddHintCreate, "onGuildListAddHintCreate");
        this.onGuildListAddHintCreate = onGuildListAddHintCreate;
    }
}
