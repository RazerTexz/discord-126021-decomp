package com.discord.widgets.voice;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.app.AppPermissionsRequests;
import com.discord.app.AppTransitionActivity;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.stage.StageChannelUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.stage.StageChannelAPI;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: VoiceUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceUtils {
    public static final VoiceUtils INSTANCE = new VoiceUtils();

    /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleCallChannel$1 */
    /* JADX INFO: compiled from: VoiceUtils.kt */
    public static final class C104031 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ AppPermissionsRequests $appPermissionsRequests;
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ boolean $hasUserSeenVoiceChannelOnboarding;
        public final /* synthetic */ boolean $isNewUser;
        public final /* synthetic */ Channel $selectedVoiceChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C104031(Channel channel, AppPermissionsRequests appPermissionsRequests, AppComponent appComponent, Context context, FragmentManager fragmentManager, boolean z2, boolean z3, Channel channel2) {
            super(0);
            this.$channel = channel;
            this.$appPermissionsRequests = appPermissionsRequests;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$hasUserSeenVoiceChannelOnboarding = z2;
            this.$isNewUser = z3;
            this.$selectedVoiceChannel = channel2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (ChannelUtils.m7667B(this.$channel)) {
                new PrivateCallLauncher(this.$appPermissionsRequests, this.$appComponent, this.$context, this.$fragmentManager).launchVoiceCall(this.$channel.getId());
                return;
            }
            if (ChannelUtils.m7669D(this.$channel)) {
                StageChannelUtils.INSTANCE.connectToStageChannel(this.$channel, this.$context, this.$fragmentManager);
                return;
            }
            if (!this.$hasUserSeenVoiceChannelOnboarding && this.$isNewUser) {
                WidgetGuildCallOnboardingSheet.INSTANCE.show(this.$fragmentManager, this.$channel.getId());
                return;
            }
            if (!TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(this.$channel.getGuildId()))) {
                WidgetVoiceBottomSheet.INSTANCE.show(this.$fragmentManager, this.$channel.getId(), true, WidgetVoiceBottomSheet.FeatureContext.HOME);
                return;
            }
            Channel channel = this.$selectedVoiceChannel;
            if (channel == null || ChannelUtils.m7667B(channel) || this.$selectedVoiceChannel.getId() != this.$channel.getId()) {
                WidgetCallPreviewFullscreen.INSTANCE.launch(this.$context, this.$channel.getId(), AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE);
            } else {
                WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, this.$context, this.$channel.getId(), false, null, AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 12, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$1 */
    /* JADX INFO: compiled from: VoiceUtils.kt */
    public static final class C104041 extends AbstractC12240o implements Function0<Unit> {
        public static final C104041 INSTANCE = new C104041();

        public C104041() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$2 */
    /* JADX INFO: compiled from: VoiceUtils.kt */
    public static final class C104052 extends AbstractC12240o implements Function0<Unit> {
        public static final C104052 INSTANCE = new C104052();

        public C104052() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$3 */
    /* JADX INFO: compiled from: VoiceUtils.kt */
    public static final class C104063 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ AppPermissionsRequests $appPermissionsRequests;
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Function0 $onEventStarted;

        /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: VoiceUtils.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$3$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: VoiceUtils.kt */
            public static final class C132961 extends AbstractC12240o implements Function1<Void, Unit> {
                public static final C132961 INSTANCE = new C132961();

                public C132961() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r1) {
                }
            }

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.setUserSuppressedInChannel$default(StageChannelAPI.INSTANCE, C104063.this.$channel, StoreStream.INSTANCE.getUsers().getMeSnapshot().getId(), false, 0L, 8, null), false, 1, null), (Class<?>) VoiceUtils.INSTANCE.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C132961.INSTANCE);
                C104063.this.$onEventStarted.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C104063(AppPermissionsRequests appPermissionsRequests, Channel channel, Function0 function0) {
            super(0);
            this.$appPermissionsRequests = appPermissionsRequests;
            this.$channel = channel;
            this.$onEventStarted = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            C1460d.m473S1(this.$appPermissionsRequests, null, new AnonymousClass1(), 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$4 */
    /* JADX INFO: compiled from: VoiceUtils.kt */
    public static final class C104074 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ Function0 $onEventStarted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C104074(Channel channel, Context context, FragmentManager fragmentManager, Function0 function0) {
            super(0);
            this.$channel = channel;
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$onEventStarted = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.INSTANCE.getVoiceChannelSelected().selectVoiceChannel(this.$channel.getId());
            if (TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(this.$channel.getGuildId()))) {
                WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, this.$context, this.$channel.getId(), false, null, null, 28, null);
            } else {
                WidgetVoiceBottomSheet.INSTANCE.show(this.$fragmentManager, this.$channel.getId(), true, WidgetVoiceBottomSheet.FeatureContext.HOME);
            }
            this.$onEventStarted.invoke();
        }
    }

    private VoiceUtils() {
    }

    public static final void handleCallChannel(Channel channel, AppBottomSheet appBottomSheet) {
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(appBottomSheet, "appBottomSheet");
        Context contextRequireContext = appBottomSheet.requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "appBottomSheet.requireContext()");
        FragmentManager parentFragmentManager = appBottomSheet.getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "appBottomSheet.parentFragmentManager");
        handleCallChannel(channel, appBottomSheet, appBottomSheet, contextRequireContext, parentFragmentManager);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppBottomSheet appBottomSheet, Function0<Unit> onEventStarted) {
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(appBottomSheet, "appBottomSheet");
        C12238m.checkNotNullParameter(onEventStarted, "onEventStarted");
        Context contextRequireContext = appBottomSheet.requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "appBottomSheet.requireContext()");
        FragmentManager parentFragmentManager = appBottomSheet.getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "appBottomSheet.parentFragmentManager");
        handleConnectToEventChannel(channel, appBottomSheet, contextRequireContext, parentFragmentManager, onEventStarted);
    }

    public static /* synthetic */ void handleConnectToEventChannel$default(Channel channel, AppBottomSheet appBottomSheet, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = C104041.INSTANCE;
        }
        handleConnectToEventChannel(channel, appBottomSheet, (Function0<Unit>) function0);
    }

    public static /* synthetic */ void handleConnectToEventChannel$default(Channel channel, AppFragment appFragment, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = C104052.INSTANCE;
        }
        handleConnectToEventChannel(channel, appFragment, (Function0<Unit>) function0);
    }

    public static final void handleCallChannel(Channel channel, AppFragment appFragment) {
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(appFragment, "appFragment");
        Context contextRequireContext = appFragment.requireContext();
        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
        handleCallChannel(channel, appFragment, appFragment, contextRequireContext, parentFragmentManager);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppFragment appFragment, Function0<Unit> onEventStarted) {
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(appFragment, "appFragment");
        C12238m.checkNotNullParameter(onEventStarted, "onEventStarted");
        Context contextRequireContext = appFragment.requireContext();
        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
        handleConnectToEventChannel(channel, appFragment, contextRequireContext, parentFragmentManager, onEventStarted);
    }

    public static final void handleCallChannel(Channel channel, AppComponent appComponent, AppPermissionsRequests appPermissionsRequests, Context context, FragmentManager fragmentManager) {
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        C12238m.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        UserUtils userUtils = UserUtils.INSTANCE;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        boolean zIsNewUser$default = UserUtils.isNewUser$default(userUtils, companion.getUsers().getMeSnapshot(), null, 1, null);
        Channel selectedVoiceChannel = companion.getVoiceChannelSelected().getSelectedVoiceChannel();
        MemberVerificationUtils.INSTANCE.maybeShowVerificationGate(context, fragmentManager, channel.getGuildId(), "Guild Voice", (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? MemberVerificationUtils.C67681.INSTANCE : null, new C104031(channel, appPermissionsRequests, appComponent, context, fragmentManager, WidgetGuildCallOnboardingSheet.INSTANCE.hasUserSeenVoiceChannelOnboarding(context), zIsNewUser$default, selectedVoiceChannel));
    }

    public static final void handleConnectToEventChannel(Channel channel, AppPermissionsRequests appPermissionsRequests, Context context, FragmentManager fragmentManager, Function0<Unit> onEventStarted) {
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(onEventStarted, "onEventStarted");
        if (ChannelUtils.m7669D(channel)) {
            StageChannelJoinHelper.connectToStage$default(StageChannelJoinHelper.INSTANCE, context, fragmentManager, channel.getId(), false, false, null, null, null, null, new C104063(appPermissionsRequests, channel, onEventStarted), 504, null);
        } else if (ChannelUtils.m7675J(channel)) {
            C1460d.m473S1(appPermissionsRequests, null, new C104074(channel, context, fragmentManager, onEventStarted), 1, null);
        }
    }
}
