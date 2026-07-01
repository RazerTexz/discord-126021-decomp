package com.discord.widgets.stage.sheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess extends WidgetStageStartEventBottomSheetViewModel$Event {
    private final Channel channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess(Channel channel) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
    }

    public static /* synthetic */ WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess copy$default(WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess widgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess.channel;
        }
        return widgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess.copy(channel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess copy(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return new WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess(channel);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess) && m.areEqual(this.channel, ((WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess) other).channel);
        }
        return true;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public int hashCode() {
        Channel channel = this.channel;
        if (channel != null) {
            return channel.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("SetTopicSuccess(channel=");
        sbU.append(this.channel);
        sbU.append(")");
        return sbU.toString();
    }
}
