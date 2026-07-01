package com.discord.widgets.stage.sheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetStageStartEventBottomSheetViewModel$StoreState {
    private final Channel channel;
    private final StageInstance stageInstance;

    public WidgetStageStartEventBottomSheetViewModel$StoreState(Channel channel, StageInstance stageInstance) {
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.stageInstance = stageInstance;
    }

    public static /* synthetic */ WidgetStageStartEventBottomSheetViewModel$StoreState copy$default(WidgetStageStartEventBottomSheetViewModel$StoreState widgetStageStartEventBottomSheetViewModel$StoreState, Channel channel, StageInstance stageInstance, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetStageStartEventBottomSheetViewModel$StoreState.channel;
        }
        if ((i & 2) != 0) {
            stageInstance = widgetStageStartEventBottomSheetViewModel$StoreState.stageInstance;
        }
        return widgetStageStartEventBottomSheetViewModel$StoreState.copy(channel, stageInstance);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    public final WidgetStageStartEventBottomSheetViewModel$StoreState copy(Channel channel, StageInstance stageInstance) {
        m.checkNotNullParameter(channel, "channel");
        return new WidgetStageStartEventBottomSheetViewModel$StoreState(channel, stageInstance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetStageStartEventBottomSheetViewModel$StoreState)) {
            return false;
        }
        WidgetStageStartEventBottomSheetViewModel$StoreState widgetStageStartEventBottomSheetViewModel$StoreState = (WidgetStageStartEventBottomSheetViewModel$StoreState) other;
        return m.areEqual(this.channel, widgetStageStartEventBottomSheetViewModel$StoreState.channel) && m.areEqual(this.stageInstance, widgetStageStartEventBottomSheetViewModel$StoreState.stageInstance);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        StageInstance stageInstance = this.stageInstance;
        return iHashCode + (stageInstance != null ? stageInstance.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(channel=");
        sbU.append(this.channel);
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(")");
        return sbU.toString();
    }
}
