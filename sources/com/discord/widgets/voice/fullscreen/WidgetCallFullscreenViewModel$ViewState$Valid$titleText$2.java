package com.discord.widgets.voice.fullscreen;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$ViewState$Valid$titleText$2 extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel$ViewState$Valid$titleText$2(WidgetCallFullscreenViewModel.ViewState.Valid valid) {
        super(0);
        this.this$0 = valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        Channel channel = this.this$0.getCallModel().getChannel();
        if (ChannelUtils.m7669D(channel) || this.this$0.getActiveEvent() != null) {
            return null;
        }
        String strM7679c = ChannelUtils.m7679c(channel);
        if (this.this$0.getCallModel().isStreaming() || this.this$0.getVisibleVideoParticipants().size() != 1 || !ChannelUtils.m7667B(channel) || !(this.this$0.getVisibleVideoParticipants().get(0) instanceof CallParticipant.UserOrStreamParticipant)) {
            return strM7679c;
        }
        CallParticipant callParticipant = this.this$0.getVisibleVideoParticipants().get(0);
        Objects.requireNonNull(callParticipant, "null cannot be cast to non-null type com.discord.widgets.voice.fullscreen.CallParticipant.UserOrStreamParticipant");
        return ((CallParticipant.UserOrStreamParticipant) callParticipant).getParticipantData().voiceParticipant.getDisplayName();
    }
}
