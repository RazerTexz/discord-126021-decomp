package com.discord.widgets.mobile_reports;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportsViewModel$StoreState {
    private final Map<Long, Integer> blockedUsers;
    private final Channel channel;
    private final DirectoryEntryGuild directoryEntry;
    private final GuildScheduledEvent event;
    private final Guild guild;
    private final Message message;
    private final StageInstance stageInstance;

    public MobileReportsViewModel$StoreState(Message message, Channel channel, Guild guild, DirectoryEntryGuild directoryEntryGuild, StageInstance stageInstance, Map<Long, Integer> map, GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(map, "blockedUsers");
        this.message = message;
        this.channel = channel;
        this.guild = guild;
        this.directoryEntry = directoryEntryGuild;
        this.stageInstance = stageInstance;
        this.blockedUsers = map;
        this.event = guildScheduledEvent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MobileReportsViewModel$StoreState copy$default(MobileReportsViewModel$StoreState mobileReportsViewModel$StoreState, Message message, Channel channel, Guild guild, DirectoryEntryGuild directoryEntryGuild, StageInstance stageInstance, Map map, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            message = mobileReportsViewModel$StoreState.message;
        }
        if ((i & 2) != 0) {
            channel = mobileReportsViewModel$StoreState.channel;
        }
        Channel channel2 = channel;
        if ((i & 4) != 0) {
            guild = mobileReportsViewModel$StoreState.guild;
        }
        Guild guild2 = guild;
        if ((i & 8) != 0) {
            directoryEntryGuild = mobileReportsViewModel$StoreState.directoryEntry;
        }
        DirectoryEntryGuild directoryEntryGuild2 = directoryEntryGuild;
        if ((i & 16) != 0) {
            stageInstance = mobileReportsViewModel$StoreState.stageInstance;
        }
        StageInstance stageInstance2 = stageInstance;
        if ((i & 32) != 0) {
            map = mobileReportsViewModel$StoreState.blockedUsers;
        }
        Map map2 = map;
        if ((i & 64) != 0) {
            guildScheduledEvent = mobileReportsViewModel$StoreState.event;
        }
        return mobileReportsViewModel$StoreState.copy(message, channel2, guild2, directoryEntryGuild2, stageInstance2, map2, guildScheduledEvent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DirectoryEntryGuild getDirectoryEntry() {
        return this.directoryEntry;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    public final Map<Long, Integer> component6() {
        return this.blockedUsers;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    public final MobileReportsViewModel$StoreState copy(Message message, Channel channel, Guild guild, DirectoryEntryGuild directoryEntry, StageInstance stageInstance, Map<Long, Integer> blockedUsers, GuildScheduledEvent event) {
        m.checkNotNullParameter(blockedUsers, "blockedUsers");
        return new MobileReportsViewModel$StoreState(message, channel, guild, directoryEntry, stageInstance, blockedUsers, event);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileReportsViewModel$StoreState)) {
            return false;
        }
        MobileReportsViewModel$StoreState mobileReportsViewModel$StoreState = (MobileReportsViewModel$StoreState) other;
        return m.areEqual(this.message, mobileReportsViewModel$StoreState.message) && m.areEqual(this.channel, mobileReportsViewModel$StoreState.channel) && m.areEqual(this.guild, mobileReportsViewModel$StoreState.guild) && m.areEqual(this.directoryEntry, mobileReportsViewModel$StoreState.directoryEntry) && m.areEqual(this.stageInstance, mobileReportsViewModel$StoreState.stageInstance) && m.areEqual(this.blockedUsers, mobileReportsViewModel$StoreState.blockedUsers) && m.areEqual(this.event, mobileReportsViewModel$StoreState.event);
    }

    public final Map<Long, Integer> getBlockedUsers() {
        return this.blockedUsers;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final DirectoryEntryGuild getDirectoryEntry() {
        return this.directoryEntry;
    }

    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
        DirectoryEntryGuild directoryEntryGuild = this.directoryEntry;
        int iHashCode4 = (iHashCode3 + (directoryEntryGuild != null ? directoryEntryGuild.hashCode() : 0)) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode5 = (iHashCode4 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
        Map<Long, Integer> map = this.blockedUsers;
        int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.event;
        return iHashCode6 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(message=");
        sbU.append(this.message);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", directoryEntry=");
        sbU.append(this.directoryEntry);
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(", blockedUsers=");
        sbU.append(this.blockedUsers);
        sbU.append(", event=");
        sbU.append(this.event);
        sbU.append(")");
        return sbU.toString();
    }
}
