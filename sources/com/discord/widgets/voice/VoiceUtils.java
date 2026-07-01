package com.discord.widgets.voice;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.app.AppPermissionsRequests;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VoiceUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceUtils {
    public static final VoiceUtils INSTANCE = new VoiceUtils();

    private VoiceUtils() {
    }

    public static final void handleCallChannel(Channel channel, AppBottomSheet appBottomSheet) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(appBottomSheet, "appBottomSheet");
        Context contextRequireContext = appBottomSheet.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "appBottomSheet.requireContext()");
        FragmentManager parentFragmentManager = appBottomSheet.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "appBottomSheet.parentFragmentManager");
        handleCallChannel(channel, appBottomSheet, appBottomSheet, contextRequireContext, parentFragmentManager);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppBottomSheet appBottomSheet, Function0<Unit> onEventStarted) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(appBottomSheet, "appBottomSheet");
        m.checkNotNullParameter(onEventStarted, "onEventStarted");
        Context contextRequireContext = appBottomSheet.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "appBottomSheet.requireContext()");
        FragmentManager parentFragmentManager = appBottomSheet.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "appBottomSheet.parentFragmentManager");
        handleConnectToEventChannel(channel, appBottomSheet, contextRequireContext, parentFragmentManager, onEventStarted);
    }

    public static /* synthetic */ void handleConnectToEventChannel$default(Channel channel, AppBottomSheet appBottomSheet, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = VoiceUtils$handleConnectToEventChannel$1.INSTANCE;
        }
        handleConnectToEventChannel(channel, appBottomSheet, (Function0<Unit>) function0);
    }

    public static /* synthetic */ void handleConnectToEventChannel$default(Channel channel, AppFragment appFragment, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = VoiceUtils$handleConnectToEventChannel$2.INSTANCE;
        }
        handleConnectToEventChannel(channel, appFragment, (Function0<Unit>) function0);
    }

    public static final void handleCallChannel(Channel channel, AppFragment appFragment) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(appFragment, "appFragment");
        Context contextRequireContext = appFragment.requireContext();
        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
        handleCallChannel(channel, appFragment, appFragment, contextRequireContext, parentFragmentManager);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppFragment appFragment, Function0<Unit> onEventStarted) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(appFragment, "appFragment");
        m.checkNotNullParameter(onEventStarted, "onEventStarted");
        Context contextRequireContext = appFragment.requireContext();
        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
        handleConnectToEventChannel(channel, appFragment, contextRequireContext, parentFragmentManager, onEventStarted);
    }

    public static final void handleCallChannel(Channel channel, AppComponent appComponent, AppPermissionsRequests appPermissionsRequests, Context context, FragmentManager fragmentManager) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        UserUtils userUtils = UserUtils.INSTANCE;
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        boolean zIsNewUser$default = UserUtils.isNewUser$default(userUtils, storeStream$Companion.getUsers().getMeSnapshot(), null, 1, null);
        Channel selectedVoiceChannel = storeStream$Companion.getVoiceChannelSelected().getSelectedVoiceChannel();
        MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, context, fragmentManager, channel.getGuildId(), "Guild Voice", null, null, new VoiceUtils$handleCallChannel$1(channel, appPermissionsRequests, appComponent, context, fragmentManager, WidgetGuildCallOnboardingSheet.Companion.hasUserSeenVoiceChannelOnboarding(context), zIsNewUser$default, selectedVoiceChannel), 48, null);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppPermissionsRequests appPermissionsRequests, Context context, FragmentManager fragmentManager, Function0<Unit> onEventStarted) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(onEventStarted, "onEventStarted");
        if (ChannelUtils.D(channel)) {
            StageChannelJoinHelper.connectToStage$default(StageChannelJoinHelper.INSTANCE, context, fragmentManager, channel.getId(), false, false, null, null, null, null, new VoiceUtils$handleConnectToEventChannel$3(appPermissionsRequests, channel, onEventStarted), 504, null);
        } else if (ChannelUtils.J(channel)) {
            d.S1(appPermissionsRequests, null, new VoiceUtils$handleConnectToEventChannel$4(channel, context, fragmentManager, onEventStarted), 1, null);
        }
    }
}
