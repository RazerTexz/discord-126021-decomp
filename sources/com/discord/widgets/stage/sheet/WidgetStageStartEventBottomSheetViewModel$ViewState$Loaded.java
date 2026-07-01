package com.discord.widgets.stage.sheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded extends WidgetStageStartEventBottomSheetViewModel$ViewState {
    private final Channel channel;
    private final StageInstance stageInstance;
    private final String topic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded(Channel channel, String str, StageInstance stageInstance) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        this.channel = channel;
        this.topic = str;
        this.stageInstance = stageInstance;
    }

    public static /* synthetic */ WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded copy$default(WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded widgetStageStartEventBottomSheetViewModel$ViewState$Loaded, Channel channel, String str, StageInstance stageInstance, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.channel;
        }
        if ((i & 2) != 0) {
            str = widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.topic;
        }
        if ((i & 4) != 0) {
            stageInstance = widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.stageInstance;
        }
        return widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.copy(channel, str, stageInstance);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    public final WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded copy(Channel channel, String topic, StageInstance stageInstance) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        return new WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded(channel, topic, stageInstance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded widgetStageStartEventBottomSheetViewModel$ViewState$Loaded = (WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded) other;
        return m.areEqual(this.channel, widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.channel) && m.areEqual(this.topic, widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.topic) && m.areEqual(this.stageInstance, widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.stageInstance);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    public final String getTopic() {
        return this.topic;
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        String str = this.topic;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        StageInstance stageInstance = this.stageInstance;
        return iHashCode2 + (stageInstance != null ? stageInstance.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(channel=");
        sbU.append(this.channel);
        sbU.append(", topic=");
        sbU.append(this.topic);
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(")");
        return sbU.toString();
    }
}
