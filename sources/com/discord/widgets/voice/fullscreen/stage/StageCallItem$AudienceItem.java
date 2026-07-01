package com.discord.widgets.voice.fullscreen.stage;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.guilds.RoleUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: StageCallItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StageCallItem$AudienceItem extends StageCallItem implements StageCallParticipantItem, Comparable<StageCallItem$AudienceItem> {
    private final Channel channel;
    private final GuildRole hoistedGuildRole;
    private final boolean isBlocked;
    private final StoreVoiceParticipants$VoiceUser voiceUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallItem$AudienceItem(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, Channel channel, GuildRole guildRole, boolean z2) {
        super("audience-" + storeVoiceParticipants$VoiceUser.getUser().getId(), 3, null);
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "voiceUser");
        m.checkNotNullParameter(channel, "channel");
        this.voiceUser = storeVoiceParticipants$VoiceUser;
        this.channel = channel;
        this.hoistedGuildRole = guildRole;
        this.isBlocked = z2;
    }

    public static /* synthetic */ StageCallItem$AudienceItem copy$default(StageCallItem$AudienceItem stageCallItem$AudienceItem, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, Channel channel, GuildRole guildRole, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            storeVoiceParticipants$VoiceUser = stageCallItem$AudienceItem.getVoiceUser();
        }
        if ((i & 2) != 0) {
            channel = stageCallItem$AudienceItem.getChannel();
        }
        if ((i & 4) != 0) {
            guildRole = stageCallItem$AudienceItem.hoistedGuildRole;
        }
        if ((i & 8) != 0) {
            z2 = stageCallItem$AudienceItem.isBlocked;
        }
        return stageCallItem$AudienceItem.copy(storeVoiceParticipants$VoiceUser, channel, guildRole, z2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(StageCallItem$AudienceItem stageCallItem$AudienceItem) {
        return compareTo2(stageCallItem$AudienceItem);
    }

    public final StoreVoiceParticipants$VoiceUser component1() {
        return getVoiceUser();
    }

    public final Channel component2() {
        return getChannel();
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildRole getHoistedGuildRole() {
        return this.hoistedGuildRole;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsBlocked() {
        return this.isBlocked;
    }

    public final StageCallItem$AudienceItem copy(StoreVoiceParticipants$VoiceUser voiceUser, Channel channel, GuildRole hoistedGuildRole, boolean isBlocked) {
        m.checkNotNullParameter(voiceUser, "voiceUser");
        m.checkNotNullParameter(channel, "channel");
        return new StageCallItem$AudienceItem(voiceUser, channel, hoistedGuildRole, isBlocked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCallItem$AudienceItem)) {
            return false;
        }
        StageCallItem$AudienceItem stageCallItem$AudienceItem = (StageCallItem$AudienceItem) other;
        return m.areEqual(getVoiceUser(), stageCallItem$AudienceItem.getVoiceUser()) && m.areEqual(getChannel(), stageCallItem$AudienceItem.getChannel()) && m.areEqual(this.hoistedGuildRole, stageCallItem$AudienceItem.hoistedGuildRole) && this.isBlocked == stageCallItem$AudienceItem.isBlocked;
    }

    @Override // com.discord.widgets.voice.fullscreen.stage.StageCallParticipantItem
    public Channel getChannel() {
        return this.channel;
    }

    public final GuildRole getHoistedGuildRole() {
        return this.hoistedGuildRole;
    }

    @Override // com.discord.widgets.voice.fullscreen.stage.StageCallParticipantItem
    public StoreVoiceParticipants$VoiceUser getVoiceUser() {
        return this.voiceUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        StoreVoiceParticipants$VoiceUser voiceUser = getVoiceUser();
        int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
        Channel channel = getChannel();
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        GuildRole guildRole = this.hoistedGuildRole;
        int iHashCode3 = (iHashCode2 + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
        boolean z2 = this.isBlocked;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public String toString() {
        StringBuilder sbU = a.U("AudienceItem(voiceUser=");
        sbU.append(getVoiceUser());
        sbU.append(", channel=");
        sbU.append(getChannel());
        sbU.append(", hoistedGuildRole=");
        sbU.append(this.hoistedGuildRole);
        sbU.append(", isBlocked=");
        return a.O(sbU, this.isBlocked, ")");
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(StageCallItem$AudienceItem other) {
        m.checkNotNullParameter(other, "other");
        return RoleUtils.getROLE_COMPARATOR().compare(this.hoistedGuildRole, other.hoistedGuildRole);
    }
}
