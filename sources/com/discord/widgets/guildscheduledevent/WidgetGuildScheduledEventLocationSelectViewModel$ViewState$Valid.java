package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid extends WidgetGuildScheduledEventLocationSelectViewModel$ViewState {
    private final Map<Long, Channel> availableChannels;
    private final Set<Long> availableStageChannelIds;
    private final Set<Long> availableVoiceChannelIds;
    private final boolean canChangeChannel;
    private final boolean canCreateExternalEvent;
    private final String externalLocation;
    private final Channel selectedChannel;
    private final GuildScheduledEventEntityType selectedLocationOption;
    private final boolean showStageOptionIfUnavailable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid(GuildScheduledEventEntityType guildScheduledEventEntityType, Channel channel, String str, Map<Long, Channel> map, Set<Long> set, Set<Long> set2, boolean z2, boolean z3, boolean z4) {
        super(null);
        m.checkNotNullParameter(guildScheduledEventEntityType, "selectedLocationOption");
        m.checkNotNullParameter(str, "externalLocation");
        m.checkNotNullParameter(map, "availableChannels");
        m.checkNotNullParameter(set, "availableVoiceChannelIds");
        m.checkNotNullParameter(set2, "availableStageChannelIds");
        this.selectedLocationOption = guildScheduledEventEntityType;
        this.selectedChannel = channel;
        this.externalLocation = str;
        this.availableChannels = map;
        this.availableVoiceChannelIds = set;
        this.availableStageChannelIds = set2;
        this.canCreateExternalEvent = z2;
        this.showStageOptionIfUnavailable = z3;
        this.canChangeChannel = z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid copy$default(WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid, GuildScheduledEventEntityType guildScheduledEventEntityType, Channel channel, String str, Map map, Set set, Set set2, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.copy((i & 1) != 0 ? widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.selectedLocationOption : guildScheduledEventEntityType, (i & 2) != 0 ? widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.selectedChannel : channel, (i & 4) != 0 ? widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.externalLocation : str, (i & 8) != 0 ? widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.availableChannels : map, (i & 16) != 0 ? widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.availableVoiceChannelIds : set, (i & 32) != 0 ? widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.availableStageChannelIds : set2, (i & 64) != 0 ? widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.canCreateExternalEvent : z2, (i & 128) != 0 ? widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.showStageOptionIfUnavailable : z3, (i & 256) != 0 ? widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.canChangeChannel : z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildScheduledEventEntityType getSelectedLocationOption() {
        return this.selectedLocationOption;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getSelectedChannel() {
        return this.selectedChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getExternalLocation() {
        return this.externalLocation;
    }

    public final Map<Long, Channel> component4() {
        return this.availableChannels;
    }

    public final Set<Long> component5() {
        return this.availableVoiceChannelIds;
    }

    public final Set<Long> component6() {
        return this.availableStageChannelIds;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanCreateExternalEvent() {
        return this.canCreateExternalEvent;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getShowStageOptionIfUnavailable() {
        return this.showStageOptionIfUnavailable;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getCanChangeChannel() {
        return this.canChangeChannel;
    }

    public final WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid copy(GuildScheduledEventEntityType selectedLocationOption, Channel selectedChannel, String externalLocation, Map<Long, Channel> availableChannels, Set<Long> availableVoiceChannelIds, Set<Long> availableStageChannelIds, boolean canCreateExternalEvent, boolean showStageOptionIfUnavailable, boolean canChangeChannel) {
        m.checkNotNullParameter(selectedLocationOption, "selectedLocationOption");
        m.checkNotNullParameter(externalLocation, "externalLocation");
        m.checkNotNullParameter(availableChannels, "availableChannels");
        m.checkNotNullParameter(availableVoiceChannelIds, "availableVoiceChannelIds");
        m.checkNotNullParameter(availableStageChannelIds, "availableStageChannelIds");
        return new WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid(selectedLocationOption, selectedChannel, externalLocation, availableChannels, availableVoiceChannelIds, availableStageChannelIds, canCreateExternalEvent, showStageOptionIfUnavailable, canChangeChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid)) {
            return false;
        }
        WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid = (WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid) other;
        return m.areEqual(this.selectedLocationOption, widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.selectedLocationOption) && m.areEqual(this.selectedChannel, widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.selectedChannel) && m.areEqual(this.externalLocation, widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.externalLocation) && m.areEqual(this.availableChannels, widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.availableChannels) && m.areEqual(this.availableVoiceChannelIds, widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.availableVoiceChannelIds) && m.areEqual(this.availableStageChannelIds, widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.availableStageChannelIds) && this.canCreateExternalEvent == widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.canCreateExternalEvent && this.showStageOptionIfUnavailable == widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.showStageOptionIfUnavailable && this.canChangeChannel == widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.canChangeChannel;
    }

    public final Map<Long, Channel> getAvailableChannels() {
        return this.availableChannels;
    }

    public final Set<Long> getAvailableStageChannelIds() {
        return this.availableStageChannelIds;
    }

    public final Set<Long> getAvailableVoiceChannelIds() {
        return this.availableVoiceChannelIds;
    }

    public final boolean getCanChangeChannel() {
        return this.canChangeChannel;
    }

    public final boolean getCanCreateExternalEvent() {
        return this.canCreateExternalEvent;
    }

    public final String getExternalLocation() {
        return this.externalLocation;
    }

    public final Channel getSelectedChannel() {
        return this.selectedChannel;
    }

    public final GuildScheduledEventEntityType getSelectedLocationOption() {
        return this.selectedLocationOption;
    }

    public final boolean getShowStageOptionIfUnavailable() {
        return this.showStageOptionIfUnavailable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    public int hashCode() {
        GuildScheduledEventEntityType guildScheduledEventEntityType = this.selectedLocationOption;
        int iHashCode = (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0) * 31;
        Channel channel = this.selectedChannel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        String str = this.externalLocation;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Map<Long, Channel> map = this.availableChannels;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Set<Long> set = this.availableVoiceChannelIds;
        int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
        Set<Long> set2 = this.availableStageChannelIds;
        int iHashCode6 = (iHashCode5 + (set2 != null ? set2.hashCode() : 0)) * 31;
        boolean z2 = this.canCreateExternalEvent;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode6 + r1) * 31;
        boolean z3 = this.showStageOptionIfUnavailable;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canChangeChannel;
        return i2 + (z4 ? 1 : z4);
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(selectedLocationOption=");
        sbU.append(this.selectedLocationOption);
        sbU.append(", selectedChannel=");
        sbU.append(this.selectedChannel);
        sbU.append(", externalLocation=");
        sbU.append(this.externalLocation);
        sbU.append(", availableChannels=");
        sbU.append(this.availableChannels);
        sbU.append(", availableVoiceChannelIds=");
        sbU.append(this.availableVoiceChannelIds);
        sbU.append(", availableStageChannelIds=");
        sbU.append(this.availableStageChannelIds);
        sbU.append(", canCreateExternalEvent=");
        sbU.append(this.canCreateExternalEvent);
        sbU.append(", showStageOptionIfUnavailable=");
        sbU.append(this.showStageOptionIfUnavailable);
        sbU.append(", canChangeChannel=");
        return a.O(sbU, this.canChangeChannel, ")");
    }
}
