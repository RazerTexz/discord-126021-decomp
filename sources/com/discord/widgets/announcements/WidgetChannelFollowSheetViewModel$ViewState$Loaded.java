package com.discord.widgets.announcements;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelFollowSheetViewModel$ViewState$Loaded extends WidgetChannelFollowSheetViewModel$ViewState {
    private final Set<Long> availableChannels;
    private final Set<Long> availableGuilds;
    private final Integer errorTextRes;
    private final Channel selectedChannel;
    private final Guild selectedGuild;
    private final Channel sourceChannel;
    private final Guild sourceGuild;

    public /* synthetic */ WidgetChannelFollowSheetViewModel$ViewState$Loaded(Channel channel, Guild guild, Guild guild2, Channel channel2, Set set, Set set2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, guild, guild2, channel2, set, set2, (i & 64) != 0 ? null : num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelFollowSheetViewModel$ViewState$Loaded copy$default(WidgetChannelFollowSheetViewModel$ViewState$Loaded widgetChannelFollowSheetViewModel$ViewState$Loaded, Channel channel, Guild guild, Guild guild2, Channel channel2, Set set, Set set2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetChannelFollowSheetViewModel$ViewState$Loaded.sourceChannel;
        }
        if ((i & 2) != 0) {
            guild = widgetChannelFollowSheetViewModel$ViewState$Loaded.sourceGuild;
        }
        Guild guild3 = guild;
        if ((i & 4) != 0) {
            guild2 = widgetChannelFollowSheetViewModel$ViewState$Loaded.selectedGuild;
        }
        Guild guild4 = guild2;
        if ((i & 8) != 0) {
            channel2 = widgetChannelFollowSheetViewModel$ViewState$Loaded.selectedChannel;
        }
        Channel channel3 = channel2;
        if ((i & 16) != 0) {
            set = widgetChannelFollowSheetViewModel$ViewState$Loaded.availableGuilds;
        }
        Set set3 = set;
        if ((i & 32) != 0) {
            set2 = widgetChannelFollowSheetViewModel$ViewState$Loaded.availableChannels;
        }
        Set set4 = set2;
        if ((i & 64) != 0) {
            num = widgetChannelFollowSheetViewModel$ViewState$Loaded.errorTextRes;
        }
        return widgetChannelFollowSheetViewModel$ViewState$Loaded.copy(channel, guild3, guild4, channel3, set3, set4, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getSourceChannel() {
        return this.sourceChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getSourceGuild() {
        return this.sourceGuild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Guild getSelectedGuild() {
        return this.selectedGuild;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Channel getSelectedChannel() {
        return this.selectedChannel;
    }

    public final Set<Long> component5() {
        return this.availableGuilds;
    }

    public final Set<Long> component6() {
        return this.availableChannels;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getErrorTextRes() {
        return this.errorTextRes;
    }

    public final WidgetChannelFollowSheetViewModel$ViewState$Loaded copy(Channel sourceChannel, Guild sourceGuild, Guild selectedGuild, Channel selectedChannel, Set<Long> availableGuilds, Set<Long> availableChannels, Integer errorTextRes) {
        m.checkNotNullParameter(availableGuilds, "availableGuilds");
        m.checkNotNullParameter(availableChannels, "availableChannels");
        return new WidgetChannelFollowSheetViewModel$ViewState$Loaded(sourceChannel, sourceGuild, selectedGuild, selectedChannel, availableGuilds, availableChannels, errorTextRes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelFollowSheetViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetChannelFollowSheetViewModel$ViewState$Loaded widgetChannelFollowSheetViewModel$ViewState$Loaded = (WidgetChannelFollowSheetViewModel$ViewState$Loaded) other;
        return m.areEqual(this.sourceChannel, widgetChannelFollowSheetViewModel$ViewState$Loaded.sourceChannel) && m.areEqual(this.sourceGuild, widgetChannelFollowSheetViewModel$ViewState$Loaded.sourceGuild) && m.areEqual(this.selectedGuild, widgetChannelFollowSheetViewModel$ViewState$Loaded.selectedGuild) && m.areEqual(this.selectedChannel, widgetChannelFollowSheetViewModel$ViewState$Loaded.selectedChannel) && m.areEqual(this.availableGuilds, widgetChannelFollowSheetViewModel$ViewState$Loaded.availableGuilds) && m.areEqual(this.availableChannels, widgetChannelFollowSheetViewModel$ViewState$Loaded.availableChannels) && m.areEqual(this.errorTextRes, widgetChannelFollowSheetViewModel$ViewState$Loaded.errorTextRes);
    }

    public final Set<Long> getAvailableChannels() {
        return this.availableChannels;
    }

    public final Set<Long> getAvailableGuilds() {
        return this.availableGuilds;
    }

    public final Integer getErrorTextRes() {
        return this.errorTextRes;
    }

    public final Channel getSelectedChannel() {
        return this.selectedChannel;
    }

    public final Guild getSelectedGuild() {
        return this.selectedGuild;
    }

    public final Channel getSourceChannel() {
        return this.sourceChannel;
    }

    public final Guild getSourceGuild() {
        return this.sourceGuild;
    }

    public int hashCode() {
        Channel channel = this.sourceChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Guild guild = this.sourceGuild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        Guild guild2 = this.selectedGuild;
        int iHashCode3 = (iHashCode2 + (guild2 != null ? guild2.hashCode() : 0)) * 31;
        Channel channel2 = this.selectedChannel;
        int iHashCode4 = (iHashCode3 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        Set<Long> set = this.availableGuilds;
        int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
        Set<Long> set2 = this.availableChannels;
        int iHashCode6 = (iHashCode5 + (set2 != null ? set2.hashCode() : 0)) * 31;
        Integer num = this.errorTextRes;
        return iHashCode6 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(sourceChannel=");
        sbU.append(this.sourceChannel);
        sbU.append(", sourceGuild=");
        sbU.append(this.sourceGuild);
        sbU.append(", selectedGuild=");
        sbU.append(this.selectedGuild);
        sbU.append(", selectedChannel=");
        sbU.append(this.selectedChannel);
        sbU.append(", availableGuilds=");
        sbU.append(this.availableGuilds);
        sbU.append(", availableChannels=");
        sbU.append(this.availableChannels);
        sbU.append(", errorTextRes=");
        return a.F(sbU, this.errorTextRes, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelFollowSheetViewModel$ViewState$Loaded(Channel channel, Guild guild, Guild guild2, Channel channel2, Set<Long> set, Set<Long> set2, Integer num) {
        super(null);
        m.checkNotNullParameter(set, "availableGuilds");
        m.checkNotNullParameter(set2, "availableChannels");
        this.sourceChannel = channel;
        this.sourceGuild = guild;
        this.selectedGuild = guild2;
        this.selectedChannel = channel2;
        this.availableGuilds = set;
        this.availableChannels = set2;
        this.errorTextRes = num;
    }
}
