package com.discord.widgets.voice.fullscreen;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$ViewState$Valid$titleText$2 extends o implements Function0<String> {
    public final /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel$ViewState$Valid$titleText$2(WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid) {
        super(0);
        this.this$0 = widgetCallFullscreenViewModel$ViewState$Valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        Channel channel = this.this$0.getCallModel().getChannel();
        if (ChannelUtils.D(channel) || this.this$0.getActiveEvent() != null) {
            return null;
        }
        String strC = ChannelUtils.c(channel);
        if (this.this$0.getCallModel().isStreaming() || this.this$0.getVisibleVideoParticipants().size() != 1 || !ChannelUtils.B(channel) || !(this.this$0.getVisibleVideoParticipants().get(0) instanceof CallParticipant$UserOrStreamParticipant)) {
            return strC;
        }
        CallParticipant callParticipant = this.this$0.getVisibleVideoParticipants().get(0);
        Objects.requireNonNull(callParticipant, "null cannot be cast to non-null type com.discord.widgets.voice.fullscreen.CallParticipant.UserOrStreamParticipant");
        return ((CallParticipant$UserOrStreamParticipant) callParticipant).getParticipantData().voiceParticipant.getDisplayName();
    }
}
