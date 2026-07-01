package com.discord.widgets.channels;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSidebarActionsBinding;
import com.discord.utilities.device.DeviceUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.channelsidebar.GuildChannelSideBarActionsView;
import com.discord.views.channelsidebar.PrivateChannelSideBarActionsView;
import com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettings;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowser;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.search.WidgetSearch;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelSidebarActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSidebarActionsBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(WidgetChannelSidebarActionsViewModel.ViewState viewState, Context context) {
            super(1);
            this.$viewState = viewState;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetSearch.INSTANCE.launchForGuild(((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).getGuildId(), this.$context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
    public static final class AnonymousClass6 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Context context, WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            super(1);
            this.$context = context;
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetThreadBrowser.INSTANCE.show(this.$context, ((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).getGuildId(), ((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).getChannelId(), "Channel Side Bar");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$7, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
    public static final class AnonymousClass7 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(Context context, long j) {
            super(1);
            this.$context = context;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetChannelPinnedMessages.INSTANCE.show(this.$context, this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$8, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
    public static final class AnonymousClass8 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long j = this.$channelId;
            FragmentManager parentFragmentManager = WidgetChannelSidebarActions.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(j, parentFragmentManager);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$9, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
    public static final class AnonymousClass9 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(WidgetChannelSidebarActionsViewModel.ViewState viewState, long j, Context context) {
            super(1);
            this.$viewState = viewState;
            this.$channelId = j;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).isThread()) {
                WidgetThreadSettings.INSTANCE.launch(this.$channelId, this.$context);
            } else {
                WidgetTextChannelSettings.INSTANCE.launch(this.$channelId, this.$context);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetChannelSidebarActionsViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetChannelSidebarActions.this.configureUI(viewState);
        }
    }

    public WidgetChannelSidebarActions() {
        super(R.layout.widget_channel_sidebar_actions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSidebarActions2.INSTANCE, null, 2, null);
        WidgetChannelSidebarActions3 widgetChannelSidebarActions3 = WidgetChannelSidebarActions3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelSidebarActionsViewModel.class), new WidgetChannelSidebarActions$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelSidebarActions3));
    }

    private final void configureUI(final WidgetChannelSidebarActionsViewModel.ViewState viewState) {
        DeviceUtils deviceUtils = DeviceUtils.INSTANCE;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        boolean zIsSmallScreen = deviceUtils.isSmallScreen(resources);
        if (Intrinsics3.areEqual(viewState, WidgetChannelSidebarActionsViewModel.ViewState.Uninitialized.INSTANCE)) {
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
            GuildChannelSideBarActionsView guildChannelSideBarActionsView = getBinding().f2280b;
            Intrinsics3.checkNotNullExpressionValue(guildChannelSideBarActionsView, "binding.widgetChannelSidebarActionsGuildView");
            guildChannelSideBarActionsView.setVisibility(8);
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(privateChannelSideBarActionsView, "binding.widgetChannelSidebarActionsPrivateView");
            privateChannelSideBarActionsView.setVisibility(0);
            WidgetChannelSidebarActionsViewModel.ViewState.Private r2 = (WidgetChannelSidebarActionsViewModel.ViewState.Private) viewState;
            final long channelId = r2.getChannelId();
            final Context contextRequireContext = requireContext();
            getBinding().c.a(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetChannelSidebarActions.configureUI.1
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
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
            GuildChannelSideBarActionsView guildChannelSideBarActionsView2 = getBinding().f2280b;
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(viewState, contextRequireContext2);
            AnonymousClass6 anonymousClass6 = new AnonymousClass6(contextRequireContext2, viewState);
            AnonymousClass7 anonymousClass7 = new AnonymousClass7(contextRequireContext2, channelId2);
            guildChannelSideBarActionsView2.a(anonymousClass5, anonymousClass6, new AnonymousClass8(channelId2), anonymousClass7, new AnonymousClass9(viewState, channelId2, contextRequireContext2), guild.getHasUnreadPins(), guild.isMuted(), guild.getDisablePins(), zIsSmallScreen || guild.isGuildForumPost() || guild.isGuildForumChannel());
            View view3 = getView();
            if (view3 != null) {
                ViewKt.setVisible(view3, true);
            }
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(privateChannelSideBarActionsView2, "binding.widgetChannelSidebarActionsPrivateView");
            privateChannelSideBarActionsView2.setVisibility(8);
            GuildChannelSideBarActionsView guildChannelSideBarActionsView3 = getBinding().f2280b;
            Intrinsics3.checkNotNullExpressionValue(guildChannelSideBarActionsView3, "binding.widgetChannelSidebarActionsGuildView");
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
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetChannelSidebarActions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
