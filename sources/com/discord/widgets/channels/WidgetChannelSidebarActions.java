package com.discord.widgets.channels;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSidebarActionsBinding;
import com.discord.utilities.device.DeviceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.channelsidebar.GuildChannelSideBarActionsView;
import com.discord.views.channelsidebar.PrivateChannelSideBarActionsView;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelSidebarActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSidebarActionsBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetChannelSidebarActions() {
        super(R$layout.widget_channel_sidebar_actions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSidebarActions$binding$2.INSTANCE, null, 2, null);
        WidgetChannelSidebarActions$viewModel$2 widgetChannelSidebarActions$viewModel$2 = WidgetChannelSidebarActions$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetChannelSidebarActionsViewModel.class), new WidgetChannelSidebarActions$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetChannelSidebarActions$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSidebarActions widgetChannelSidebarActions, WidgetChannelSidebarActionsViewModel$ViewState widgetChannelSidebarActionsViewModel$ViewState) {
        widgetChannelSidebarActions.configureUI(widgetChannelSidebarActionsViewModel$ViewState);
    }

    public static final /* synthetic */ void access$startPrivateCall(WidgetChannelSidebarActions widgetChannelSidebarActions, long j, boolean z2) {
        widgetChannelSidebarActions.startPrivateCall(j, z2);
    }

    private final void configureUI(WidgetChannelSidebarActionsViewModel$ViewState viewState) {
        DeviceUtils deviceUtils = DeviceUtils.INSTANCE;
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        boolean zIsSmallScreen = deviceUtils.isSmallScreen(resources);
        if (m.areEqual(viewState, WidgetChannelSidebarActionsViewModel$ViewState$Uninitialized.INSTANCE)) {
            View view = getView();
            if (view != null) {
                ViewKt.setVisible(view, false);
                return;
            }
            return;
        }
        if (viewState instanceof WidgetChannelSidebarActionsViewModel$ViewState$Private) {
            View view2 = getView();
            if (view2 != null) {
                ViewKt.setVisible(view2, true);
            }
            GuildChannelSideBarActionsView guildChannelSideBarActionsView = getBinding().f2280b;
            m.checkNotNullExpressionValue(guildChannelSideBarActionsView, "binding.widgetChannelSidebarActionsGuildView");
            guildChannelSideBarActionsView.setVisibility(8);
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView = getBinding().c;
            m.checkNotNullExpressionValue(privateChannelSideBarActionsView, "binding.widgetChannelSidebarActionsPrivateView");
            privateChannelSideBarActionsView.setVisibility(0);
            WidgetChannelSidebarActionsViewModel$ViewState$Private widgetChannelSidebarActionsViewModel$ViewState$Private = (WidgetChannelSidebarActionsViewModel$ViewState$Private) viewState;
            long channelId = widgetChannelSidebarActionsViewModel$ViewState$Private.getChannelId();
            getBinding().c.a(new WidgetChannelSidebarActions$configureUI$1(this, viewState), new WidgetChannelSidebarActions$configureUI$2(this, viewState), new WidgetChannelSidebarActions$configureUI$3(this, channelId), new WidgetChannelSidebarActions$configureUI$4(channelId, requireContext()), widgetChannelSidebarActionsViewModel$ViewState$Private.isMuted());
            return;
        }
        if (viewState instanceof WidgetChannelSidebarActionsViewModel$ViewState$Guild) {
            WidgetChannelSidebarActionsViewModel$ViewState$Guild widgetChannelSidebarActionsViewModel$ViewState$Guild = (WidgetChannelSidebarActionsViewModel$ViewState$Guild) viewState;
            long channelId2 = widgetChannelSidebarActionsViewModel$ViewState$Guild.getChannelId();
            Context contextRequireContext = requireContext();
            GuildChannelSideBarActionsView guildChannelSideBarActionsView2 = getBinding().f2280b;
            WidgetChannelSidebarActions$configureUI$5 widgetChannelSidebarActions$configureUI$5 = new WidgetChannelSidebarActions$configureUI$5(viewState, contextRequireContext);
            WidgetChannelSidebarActions$configureUI$6 widgetChannelSidebarActions$configureUI$6 = new WidgetChannelSidebarActions$configureUI$6(contextRequireContext, viewState);
            WidgetChannelSidebarActions$configureUI$7 widgetChannelSidebarActions$configureUI$7 = new WidgetChannelSidebarActions$configureUI$7(contextRequireContext, channelId2);
            guildChannelSideBarActionsView2.a(widgetChannelSidebarActions$configureUI$5, widgetChannelSidebarActions$configureUI$6, new WidgetChannelSidebarActions$configureUI$8(this, channelId2), widgetChannelSidebarActions$configureUI$7, new WidgetChannelSidebarActions$configureUI$9(viewState, channelId2, contextRequireContext), widgetChannelSidebarActionsViewModel$ViewState$Guild.getHasUnreadPins(), widgetChannelSidebarActionsViewModel$ViewState$Guild.isMuted(), widgetChannelSidebarActionsViewModel$ViewState$Guild.getDisablePins(), zIsSmallScreen || widgetChannelSidebarActionsViewModel$ViewState$Guild.isGuildForumPost() || widgetChannelSidebarActionsViewModel$ViewState$Guild.isGuildForumChannel());
            View view3 = getView();
            if (view3 != null) {
                ViewKt.setVisible(view3, true);
            }
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView2 = getBinding().c;
            m.checkNotNullExpressionValue(privateChannelSideBarActionsView2, "binding.widgetChannelSidebarActionsPrivateView");
            privateChannelSideBarActionsView2.setVisibility(8);
            GuildChannelSideBarActionsView guildChannelSideBarActionsView3 = getBinding().f2280b;
            m.checkNotNullExpressionValue(guildChannelSideBarActionsView3, "binding.widgetChannelSidebarActionsGuildView");
            guildChannelSideBarActionsView3.setVisibility(widgetChannelSidebarActionsViewModel$ViewState$Guild.getShouldHideChannelSidebar() ^ true ? 0 : 8);
        }
    }

    private final WidgetChannelSidebarActionsBinding getBinding() {
        return (WidgetChannelSidebarActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetChannelSidebarActionsViewModel getViewModel() {
        return (WidgetChannelSidebarActionsViewModel) this.viewModel.getValue();
    }

    private final void startPrivateCall(long channelId, boolean useVideo) {
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        PrivateCallLauncher privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
        if (useVideo) {
            privateCallLauncher.launchVideoCall(channelId);
        } else {
            privateCallLauncher.launchVoiceCall(channelId);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelSidebarActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSidebarActions$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
