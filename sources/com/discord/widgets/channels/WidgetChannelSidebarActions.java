package com.discord.widgets.channels;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSidebarActionsBinding;
import com.discord.utilities.device.DeviceUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.channelsidebar.GuildChannelSideBarActionsView;
import com.discord.views.channelsidebar.PrivateChannelSideBarActionsView;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettings;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowser;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.search.WidgetSearch;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelSidebarActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSidebarActionsBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$5 */
    /* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
    public static final class C73415 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C73415(WidgetChannelSidebarActionsViewModel.ViewState viewState, Context context) {
            super(1);
            this.$viewState = viewState;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetSearch.INSTANCE.launchForGuild(((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).getGuildId(), this.$context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$6 */
    /* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
    public static final class C73426 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C73426(Context context, WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            super(1);
            this.$context = context;
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetThreadBrowser.INSTANCE.show(this.$context, ((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).getGuildId(), ((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).getChannelId(), "Channel Side Bar");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$7 */
    /* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
    public static final class C73437 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C73437(Context context, long j) {
            super(1);
            this.$context = context;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetChannelPinnedMessages.INSTANCE.show(this.$context, this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$8 */
    /* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
    public static final class C73448 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C73448(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long j = this.$channelId;
            FragmentManager parentFragmentManager = WidgetChannelSidebarActions.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(j, parentFragmentManager);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$9 */
    /* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
    public static final class C73459 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C73459(WidgetChannelSidebarActionsViewModel.ViewState viewState, long j, Context context) {
            super(1);
            this.$viewState = viewState;
            this.$channelId = j;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            if (((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).isThread()) {
                WidgetThreadSettings.INSTANCE.launch(this.$channelId, this.$context);
            } else {
                WidgetTextChannelSettings.INSTANCE.launch(this.$channelId, this.$context);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
    public static final class C73461 extends AbstractC12240o implements Function1<WidgetChannelSidebarActionsViewModel.ViewState, Unit> {
        public C73461() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetChannelSidebarActions.this.configureUI(viewState);
        }
    }

    public WidgetChannelSidebarActions() {
        super(C5419R.layout.widget_channel_sidebar_actions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSidebarActions$binding$2.INSTANCE, null, 2, null);
        WidgetChannelSidebarActions$viewModel$2 widgetChannelSidebarActions$viewModel$2 = WidgetChannelSidebarActions$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetChannelSidebarActionsViewModel.class), new WidgetChannelSidebarActions$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetChannelSidebarActions$viewModel$2));
    }

    private final void configureUI(final WidgetChannelSidebarActionsViewModel.ViewState viewState) {
        DeviceUtils deviceUtils = DeviceUtils.INSTANCE;
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        boolean zIsSmallScreen = deviceUtils.isSmallScreen(resources);
        if (C12238m.areEqual(viewState, WidgetChannelSidebarActionsViewModel.ViewState.Uninitialized.INSTANCE)) {
            View view = getView();
            if (view != null) {
                ViewKt.setVisible(view, false);
                return;
            }
            return;
        }
        if (viewState instanceof WidgetChannelSidebarActionsViewModel.ViewState.Private) {
            View view2 = getView();
            if (view2 != null) {
                ViewKt.setVisible(view2, true);
            }
            GuildChannelSideBarActionsView guildChannelSideBarActionsView = getBinding().f15959b;
            C12238m.checkNotNullExpressionValue(guildChannelSideBarActionsView, "binding.widgetChannelSidebarActionsGuildView");
            guildChannelSideBarActionsView.setVisibility(8);
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView = getBinding().f15960c;
            C12238m.checkNotNullExpressionValue(privateChannelSideBarActionsView, "binding.widgetChannelSidebarActionsPrivateView");
            privateChannelSideBarActionsView.setVisibility(0);
            WidgetChannelSidebarActionsViewModel.ViewState.Private r2 = (WidgetChannelSidebarActionsViewModel.ViewState.Private) viewState;
            final long channelId = r2.getChannelId();
            final Context contextRequireContext = requireContext();
            getBinding().f15960c.m8590a(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetChannelSidebarActions.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WidgetChannelSidebarActions.this.startPrivateCall(((WidgetChannelSidebarActionsViewModel.ViewState.Private) viewState).getChannelId(), false);
                }
            }, new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetChannelSidebarActions.configureUI.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WidgetChannelSidebarActions.this.startPrivateCall(((WidgetChannelSidebarActionsViewModel.ViewState.Private) viewState).getChannelId(), true);
                }
            }, new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetChannelSidebarActions.configureUI.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
                    long j = channelId;
                    FragmentManager parentFragmentManager = WidgetChannelSidebarActions.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.showForChannel(j, parentFragmentManager);
                }
            }, new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetChannelSidebarActions.configureUI.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WidgetSearch.INSTANCE.launchForChannel(channelId, contextRequireContext);
                }
            }, r2.isMuted());
            return;
        }
        if (viewState instanceof WidgetChannelSidebarActionsViewModel.ViewState.Guild) {
            WidgetChannelSidebarActionsViewModel.ViewState.Guild guild = (WidgetChannelSidebarActionsViewModel.ViewState.Guild) viewState;
            long channelId2 = guild.getChannelId();
            Context contextRequireContext2 = requireContext();
            GuildChannelSideBarActionsView guildChannelSideBarActionsView2 = getBinding().f15959b;
            C73415 c73415 = new C73415(viewState, contextRequireContext2);
            C73426 c73426 = new C73426(contextRequireContext2, viewState);
            C73437 c73437 = new C73437(contextRequireContext2, channelId2);
            guildChannelSideBarActionsView2.m8589a(c73415, c73426, new C73448(channelId2), c73437, new C73459(viewState, channelId2, contextRequireContext2), guild.getHasUnreadPins(), guild.isMuted(), guild.getDisablePins(), zIsSmallScreen || guild.isGuildForumPost() || guild.isGuildForumChannel());
            View view3 = getView();
            if (view3 != null) {
                ViewKt.setVisible(view3, true);
            }
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView2 = getBinding().f15960c;
            C12238m.checkNotNullExpressionValue(privateChannelSideBarActionsView2, "binding.widgetChannelSidebarActionsPrivateView");
            privateChannelSideBarActionsView2.setVisibility(8);
            GuildChannelSideBarActionsView guildChannelSideBarActionsView3 = getBinding().f15959b;
            C12238m.checkNotNullExpressionValue(guildChannelSideBarActionsView3, "binding.widgetChannelSidebarActionsGuildView");
            guildChannelSideBarActionsView3.setVisibility(guild.getShouldHideChannelSidebar() ^ true ? 0 : 8);
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
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetChannelSidebarActions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C73461());
    }
}
