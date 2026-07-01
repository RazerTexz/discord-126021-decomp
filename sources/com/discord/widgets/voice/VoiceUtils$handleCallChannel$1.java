package com.discord.widgets.voice;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppComponent;
import com.discord.app.AppPermissionsRequests;
import com.discord.app.AppTransitionActivity$Transition;
import com.discord.utilities.stage.StageChannelUtils;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$FeatureContext;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VoiceUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceUtils$handleCallChannel$1 extends o implements Function0<Unit> {
    public final /* synthetic */ AppComponent $appComponent;
    public final /* synthetic */ AppPermissionsRequests $appPermissionsRequests;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ FragmentManager $fragmentManager;
    public final /* synthetic */ boolean $hasUserSeenVoiceChannelOnboarding;
    public final /* synthetic */ boolean $isNewUser;
    public final /* synthetic */ Channel $selectedVoiceChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceUtils$handleCallChannel$1(Channel channel, AppPermissionsRequests appPermissionsRequests, AppComponent appComponent, Context context, FragmentManager fragmentManager, boolean z2, boolean z3, Channel channel2) {
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
            WidgetGuildCallOnboardingSheet.Companion.show(this.$fragmentManager, this.$channel.getId());
            return;
        }
        if (!TextInVoiceFeatureFlag.Companion.getINSTANCE().isEnabled(Long.valueOf(this.$channel.getGuildId()))) {
            WidgetVoiceBottomSheet.Companion.show(this.$fragmentManager, this.$channel.getId(), true, WidgetVoiceBottomSheet$FeatureContext.HOME);
            return;
        }
        Channel channel = this.$selectedVoiceChannel;
        if (channel == null || ChannelUtils.B(channel) || this.$selectedVoiceChannel.getId() != this.$channel.getId()) {
            WidgetCallPreviewFullscreen.Companion.launch(this.$context, this.$channel.getId(), AppTransitionActivity$Transition.TYPE_SLIDE_VERTICAL_WITH_FADE);
        } else {
            WidgetCallFullscreen$Companion.launch$default(WidgetCallFullscreen.Companion, this.$context, this.$channel.getId(), false, null, AppTransitionActivity$Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 12, null);
        }
    }
}
