package com.discord.widgets.voice;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.AnimatableValueParser;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.app.AppPermissions2;
import com.discord.app.AppTransitionActivity;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
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
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: VoiceUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceUtils {
    public static final VoiceUtils INSTANCE = new VoiceUtils();

    /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleCallChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: VoiceUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ AppPermissions2 $appPermissionsRequests;
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ boolean $hasUserSeenVoiceChannelOnboarding;
        public final /* synthetic */ boolean $isNewUser;
        public final /* synthetic */ Channel $selectedVoiceChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, AppPermissions2 appPermissions2, AppComponent appComponent, Context context, FragmentManager fragmentManager, boolean z2, boolean z3, Channel channel2) {
            super(0);
            this.$channel = channel;
            this.$appPermissionsRequests = appPermissions2;
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
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (ChannelUtils.B(this.$channel)) {
                new PrivateCallLauncher(this.$appPermissionsRequests, this.$appComponent, this.$context, this.$fragmentManager).launchVoiceCall(this.$channel.getId());
                return;
            }
            if (ChannelUtils.D(this.$channel)) {
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
            if (channel == null || ChannelUtils.B(channel) || this.$selectedVoiceChannel.getId() != this.$channel.getId()) {
                WidgetCallPreviewFullscreen.INSTANCE.launch(this.$context, this.$channel.getId(), AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE);
            } else {
                WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, this.$context, this.$channel.getId(), false, null, AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 12, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: VoiceUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$2, reason: invalid class name */
    /* JADX INFO: compiled from: VoiceUtils.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$3, reason: invalid class name */
    /* JADX INFO: compiled from: VoiceUtils.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppPermissions2 $appPermissionsRequests;
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Function0 $onEventStarted;

        /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: VoiceUtils.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$3$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: VoiceUtils.kt */
            public static final class C03561 extends Lambda implements Function1<Void, Unit> {
                public static final C03561 INSTANCE = new C03561();

                public C03561() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.a;
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
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.setUserSuppressedInChannel$default(StageChannelAPI.INSTANCE, AnonymousClass3.this.$channel, StoreStream.INSTANCE.getUsers().getMeSnapshot().getId(), false, 0L, 8, null), false, 1, null), (Class<?>) VoiceUtils.INSTANCE.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), C03561.INSTANCE);
                AnonymousClass3.this.$onEventStarted.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AppPermissions2 appPermissions2, Channel channel, Function0 function0) {
            super(0);
            this.$appPermissionsRequests = appPermissions2;
            this.$channel = channel;
            this.$onEventStarted = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnimatableValueParser.S1(this.$appPermissionsRequests, null, new AnonymousClass1(), 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$4, reason: invalid class name */
    /* JADX INFO: compiled from: VoiceUtils.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ Function0 $onEventStarted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Channel channel, Context context, FragmentManager fragmentManager, Function0 function0) {
            super(0);
            this.$channel = channel;
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$onEventStarted = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(appBottomSheet, "appBottomSheet");
        Context contextRequireContext = appBottomSheet.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "appBottomSheet.requireContext()");
        FragmentManager parentFragmentManager = appBottomSheet.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appBottomSheet.parentFragmentManager");
        handleCallChannel(channel, appBottomSheet, appBottomSheet, contextRequireContext, parentFragmentManager);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppBottomSheet appBottomSheet, Function0<Unit> onEventStarted) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(appBottomSheet, "appBottomSheet");
        Intrinsics3.checkNotNullParameter(onEventStarted, "onEventStarted");
        Context contextRequireContext = appBottomSheet.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "appBottomSheet.requireContext()");
        FragmentManager parentFragmentManager = appBottomSheet.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appBottomSheet.parentFragmentManager");
        handleConnectToEventChannel(channel, appBottomSheet, contextRequireContext, parentFragmentManager, onEventStarted);
    }

    public static /* synthetic */ void handleConnectToEventChannel$default(Channel channel, AppBottomSheet appBottomSheet, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = AnonymousClass1.INSTANCE;
        }
        handleConnectToEventChannel(channel, appBottomSheet, (Function0<Unit>) function0);
    }

    public static /* synthetic */ void handleConnectToEventChannel$default(Channel channel, AppFragment appFragment, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = AnonymousClass2.INSTANCE;
        }
        handleConnectToEventChannel(channel, appFragment, (Function0<Unit>) function0);
    }

    public static final void handleCallChannel(Channel channel, AppFragment appFragment) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(appFragment, "appFragment");
        Context contextRequireContext = appFragment.requireContext();
        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
        handleCallChannel(channel, appFragment, appFragment, contextRequireContext, parentFragmentManager);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppFragment appFragment, Function0<Unit> onEventStarted) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(appFragment, "appFragment");
        Intrinsics3.checkNotNullParameter(onEventStarted, "onEventStarted");
        Context contextRequireContext = appFragment.requireContext();
        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
        handleConnectToEventChannel(channel, appFragment, contextRequireContext, parentFragmentManager, onEventStarted);
    }

    public static final void handleCallChannel(Channel channel, AppComponent appComponent, AppPermissions2 appPermissionsRequests, Context context, FragmentManager fragmentManager) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        UserUtils userUtils = UserUtils.INSTANCE;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        boolean zIsNewUser$default = UserUtils.isNewUser$default(userUtils, companion.getUsers().getMeSnapshot(), null, 1, null);
        Channel selectedVoiceChannel = companion.getVoiceChannelSelected().getSelectedVoiceChannel();
        MemberVerificationUtils.INSTANCE.maybeShowVerificationGate(context, fragmentManager, channel.getGuildId(), "Guild Voice", (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? MemberVerificationUtils.AnonymousClass1.INSTANCE : null, new AnonymousClass1(channel, appPermissionsRequests, appComponent, context, fragmentManager, WidgetGuildCallOnboardingSheet.INSTANCE.hasUserSeenVoiceChannelOnboarding(context), zIsNewUser$default, selectedVoiceChannel));
    }

    public static final void handleConnectToEventChannel(Channel channel, AppPermissions2 appPermissionsRequests, Context context, FragmentManager fragmentManager, Function0<Unit> onEventStarted) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(onEventStarted, "onEventStarted");
        if (ChannelUtils.D(channel)) {
            StageChannelJoinHelper.connectToStage$default(StageChannelJoinHelper.INSTANCE, context, fragmentManager, channel.getId(), false, false, null, null, null, null, new AnonymousClass3(appPermissionsRequests, channel, onEventStarted), 504, null);
        } else if (ChannelUtils.J(channel)) {
            AnimatableValueParser.S1(appPermissionsRequests, null, new AnonymousClass4(channel, context, fragmentManager, onEventStarted), 1, null);
        }
    }
}
