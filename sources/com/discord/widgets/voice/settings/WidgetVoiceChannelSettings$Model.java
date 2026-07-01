package com.discord.widgets.voice.settings;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelVoiceRegion;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceChannelSettings$Model {
    public static final WidgetVoiceChannelSettings$Model$Companion Companion = new WidgetVoiceChannelSettings$Model$Companion(null);
    private final boolean canManageChannel;
    private final boolean canManagePermissions;
    private final Channel channel;
    private final long guildID;
    private final int maxBitrate;
    private final List<ModelVoiceRegion> regions;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetVoiceChannelSettings$Model(Channel channel, boolean z2, boolean z3, int i, List<? extends ModelVoiceRegion> list, long j) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(list, "regions");
        this.channel = channel;
        this.canManageChannel = z2;
        this.canManagePermissions = z3;
        this.maxBitrate = i;
        this.regions = list;
        this.guildID = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetVoiceChannelSettings$Model copy$default(WidgetVoiceChannelSettings$Model widgetVoiceChannelSettings$Model, Channel channel, boolean z2, boolean z3, int i, List list, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = widgetVoiceChannelSettings$Model.channel;
        }
        if ((i2 & 2) != 0) {
            z2 = widgetVoiceChannelSettings$Model.canManageChannel;
        }
        boolean z4 = z2;
        if ((i2 & 4) != 0) {
            z3 = widgetVoiceChannelSettings$Model.canManagePermissions;
        }
        boolean z5 = z3;
        if ((i2 & 8) != 0) {
            i = widgetVoiceChannelSettings$Model.maxBitrate;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            list = widgetVoiceChannelSettings$Model.regions;
        }
        List list2 = list;
        if ((i2 & 32) != 0) {
            j = widgetVoiceChannelSettings$Model.guildID;
        }
        return widgetVoiceChannelSettings$Model.copy(channel, z4, z5, i3, list2, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanManageChannel() {
        return this.canManageChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanManagePermissions() {
        return this.canManagePermissions;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getMaxBitrate() {
        return this.maxBitrate;
    }

    public final List<ModelVoiceRegion> component5() {
        return this.regions;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getGuildID() {
        return this.guildID;
    }

    public final WidgetVoiceChannelSettings$Model copy(Channel channel, boolean canManageChannel, boolean canManagePermissions, int maxBitrate, List<? extends ModelVoiceRegion> regions, long guildID) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(regions, "regions");
        return new WidgetVoiceChannelSettings$Model(channel, canManageChannel, canManagePermissions, maxBitrate, regions, guildID);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetVoiceChannelSettings$Model)) {
            return false;
        }
        WidgetVoiceChannelSettings$Model widgetVoiceChannelSettings$Model = (WidgetVoiceChannelSettings$Model) other;
        return m.areEqual(this.channel, widgetVoiceChannelSettings$Model.channel) && this.canManageChannel == widgetVoiceChannelSettings$Model.canManageChannel && this.canManagePermissions == widgetVoiceChannelSettings$Model.canManagePermissions && this.maxBitrate == widgetVoiceChannelSettings$Model.maxBitrate && m.areEqual(this.regions, widgetVoiceChannelSettings$Model.regions) && this.guildID == widgetVoiceChannelSettings$Model.guildID;
    }

    public final boolean getCanManageChannel() {
        return this.canManageChannel;
    }

    public final boolean getCanManagePermissions() {
        return this.canManagePermissions;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getGuildID() {
        return this.guildID;
    }

    public final int getMaxBitrate() {
        return this.maxBitrate;
    }

    public final List<ModelVoiceRegion> getRegions() {
        return this.regions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.canManageChannel;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.canManagePermissions;
        int i2 = (((i + (z3 ? 1 : z3)) * 31) + this.maxBitrate) * 31;
        List<ModelVoiceRegion> list = this.regions;
        return b.a(this.guildID) + ((i2 + (list != null ? list.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(channel=");
        sbU.append(this.channel);
        sbU.append(", canManageChannel=");
        sbU.append(this.canManageChannel);
        sbU.append(", canManagePermissions=");
        sbU.append(this.canManagePermissions);
        sbU.append(", maxBitrate=");
        sbU.append(this.maxBitrate);
        sbU.append(", regions=");
        sbU.append(this.regions);
        sbU.append(", guildID=");
        return a.C(sbU, this.guildID, ")");
    }
}
