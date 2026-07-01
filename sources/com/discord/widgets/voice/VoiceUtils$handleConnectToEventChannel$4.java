package com.discord.widgets.voice;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$FeatureContext;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VoiceUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceUtils$handleConnectToEventChannel$4 extends o implements Function0<Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ FragmentManager $fragmentManager;
    public final /* synthetic */ Function0 $onEventStarted;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceUtils$handleConnectToEventChannel$4(Channel channel, Context context, FragmentManager fragmentManager, Function0 function0) {
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
        StoreStream.Companion.getVoiceChannelSelected().selectVoiceChannel(this.$channel.getId());
        if (TextInVoiceFeatureFlag.Companion.getINSTANCE().isEnabled(Long.valueOf(this.$channel.getGuildId()))) {
            WidgetCallFullscreen$Companion.launch$default(WidgetCallFullscreen.Companion, this.$context, this.$channel.getId(), false, null, null, 28, null);
        } else {
            WidgetVoiceBottomSheet.Companion.show(this.$fragmentManager, this.$channel.getId(), true, WidgetVoiceBottomSheet$FeatureContext.HOME);
        }
        this.$onEventStarted.invoke();
    }
}
