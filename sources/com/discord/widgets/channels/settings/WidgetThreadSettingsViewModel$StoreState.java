package com.discord.widgets.channels.settings;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadSettingsViewModel$StoreState {
    private final boolean canManageThread;
    private final Channel channel;

    public WidgetThreadSettingsViewModel$StoreState(Channel channel, boolean z2) {
        this.channel = channel;
        this.canManageThread = z2;
    }

    public static /* synthetic */ WidgetThreadSettingsViewModel$StoreState copy$default(WidgetThreadSettingsViewModel$StoreState widgetThreadSettingsViewModel$StoreState, Channel channel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetThreadSettingsViewModel$StoreState.channel;
        }
        if ((i & 2) != 0) {
            z2 = widgetThreadSettingsViewModel$StoreState.canManageThread;
        }
        return widgetThreadSettingsViewModel$StoreState.copy(channel, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanManageThread() {
        return this.canManageThread;
    }

    public final WidgetThreadSettingsViewModel$StoreState copy(Channel channel, boolean canManageThread) {
        return new WidgetThreadSettingsViewModel$StoreState(channel, canManageThread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadSettingsViewModel$StoreState)) {
            return false;
        }
        WidgetThreadSettingsViewModel$StoreState widgetThreadSettingsViewModel$StoreState = (WidgetThreadSettingsViewModel$StoreState) other;
        return m.areEqual(this.channel, widgetThreadSettingsViewModel$StoreState.channel) && this.canManageThread == widgetThreadSettingsViewModel$StoreState.canManageThread;
    }

    public final boolean getCanManageThread() {
        return this.canManageThread;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.canManageThread;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(channel=");
        sbU.append(this.channel);
        sbU.append(", canManageThread=");
        return a.O(sbU, this.canManageThread, ")");
    }
}
