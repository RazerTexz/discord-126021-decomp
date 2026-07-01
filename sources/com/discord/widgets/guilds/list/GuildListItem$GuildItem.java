package com.discord.widgets.guilds.list;

import b.d.b.a.a;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.models.guild.Guild;
import com.discord.widgets.channels.list.WidgetChannelListUnreads$UnreadItem;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildListItem$GuildItem extends GuildListItem implements WidgetChannelListUnreads$UnreadItem {
    private final ApplicationStatus applicationStatus;
    private final Long folderId;
    private final Guild guild;
    private final boolean hasActiveScheduledEvent;
    private final boolean hasActiveStageChannel;
    private final boolean hasOngoingApplicationStream;
    private final boolean isConnectedToStageChannel;
    private final boolean isConnectedToVoice;
    private final Boolean isLastGuildInFolder;
    private final boolean isLurkingGuild;
    private final boolean isPendingGuild;
    private final boolean isSelected;
    private final boolean isTargetedForFolderCreation;
    private final boolean isUnread;
    private final int mentionCount;

    public /* synthetic */ GuildListItem$GuildItem(Guild guild, int i, boolean z2, boolean z3, boolean z4, Long l, boolean z5, boolean z6, boolean z7, Boolean bool, ApplicationStatus applicationStatus, boolean z8, boolean z9, boolean z10, boolean z11, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(guild, i, z2, z3, z4, l, (i2 & 64) != 0 ? false : z5, (i2 & 128) != 0 ? false : z6, (i2 & 256) != 0 ? false : z7, (i2 & 512) != 0 ? null : bool, (i2 & 1024) != 0 ? null : applicationStatus, (i2 & 2048) != 0 ? false : z8, (i2 & 4096) != 0 ? false : z9, (i2 & 8192) != 0 ? false : z10, (i2 & 16384) != 0 ? false : z11);
    }

    public static /* synthetic */ GuildListItem$GuildItem copy$default(GuildListItem$GuildItem guildListItem$GuildItem, Guild guild, int i, boolean z2, boolean z3, boolean z4, Long l, boolean z5, boolean z6, boolean z7, Boolean bool, ApplicationStatus applicationStatus, boolean z8, boolean z9, boolean z10, boolean z11, int i2, Object obj) {
        return guildListItem$GuildItem.copy((i2 & 1) != 0 ? guildListItem$GuildItem.guild : guild, (i2 & 2) != 0 ? guildListItem$GuildItem.getMentionCount() : i, (i2 & 4) != 0 ? guildListItem$GuildItem.isLurkingGuild : z2, (i2 & 8) != 0 ? guildListItem$GuildItem.getIsUnread() : z3, (i2 & 16) != 0 ? guildListItem$GuildItem.isSelected : z4, (i2 & 32) != 0 ? guildListItem$GuildItem.folderId : l, (i2 & 64) != 0 ? guildListItem$GuildItem.isConnectedToVoice : z5, (i2 & 128) != 0 ? guildListItem$GuildItem.hasOngoingApplicationStream : z6, (i2 & 256) != 0 ? guildListItem$GuildItem.isTargetedForFolderCreation : z7, (i2 & 512) != 0 ? guildListItem$GuildItem.isLastGuildInFolder : bool, (i2 & 1024) != 0 ? guildListItem$GuildItem.applicationStatus : applicationStatus, (i2 & 2048) != 0 ? guildListItem$GuildItem.isPendingGuild : z8, (i2 & 4096) != 0 ? guildListItem$GuildItem.hasActiveStageChannel : z9, (i2 & 8192) != 0 ? guildListItem$GuildItem.isConnectedToStageChannel : z10, (i2 & 16384) != 0 ? guildListItem$GuildItem.hasActiveScheduledEvent : z11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getIsLastGuildInFolder() {
        return this.isLastGuildInFolder;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsPendingGuild() {
        return this.isPendingGuild;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getHasActiveStageChannel() {
        return this.hasActiveStageChannel;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getIsConnectedToStageChannel() {
        return this.isConnectedToStageChannel;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getHasActiveScheduledEvent() {
        return this.hasActiveScheduledEvent;
    }

    public final int component2() {
        return getMentionCount();
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsLurkingGuild() {
        return this.isLurkingGuild;
    }

    public final boolean component4() {
        return getIsUnread();
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getFolderId() {
        return this.folderId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsConnectedToVoice() {
        return this.isConnectedToVoice;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getHasOngoingApplicationStream() {
        return this.hasOngoingApplicationStream;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsTargetedForFolderCreation() {
        return this.isTargetedForFolderCreation;
    }

    public final GuildListItem$GuildItem copy(Guild guild, int mentionCount, boolean isLurkingGuild, boolean isUnread, boolean isSelected, Long folderId, boolean isConnectedToVoice, boolean hasOngoingApplicationStream, boolean isTargetedForFolderCreation, Boolean isLastGuildInFolder, ApplicationStatus applicationStatus, boolean isPendingGuild, boolean hasActiveStageChannel, boolean isConnectedToStageChannel, boolean hasActiveScheduledEvent) {
        m.checkNotNullParameter(guild, "guild");
        return new GuildListItem$GuildItem(guild, mentionCount, isLurkingGuild, isUnread, isSelected, folderId, isConnectedToVoice, hasOngoingApplicationStream, isTargetedForFolderCreation, isLastGuildInFolder, applicationStatus, isPendingGuild, hasActiveStageChannel, isConnectedToStageChannel, hasActiveScheduledEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildListItem$GuildItem)) {
            return false;
        }
        GuildListItem$GuildItem guildListItem$GuildItem = (GuildListItem$GuildItem) other;
        return m.areEqual(this.guild, guildListItem$GuildItem.guild) && getMentionCount() == guildListItem$GuildItem.getMentionCount() && this.isLurkingGuild == guildListItem$GuildItem.isLurkingGuild && getIsUnread() == guildListItem$GuildItem.getIsUnread() && this.isSelected == guildListItem$GuildItem.isSelected && m.areEqual(this.folderId, guildListItem$GuildItem.folderId) && this.isConnectedToVoice == guildListItem$GuildItem.isConnectedToVoice && this.hasOngoingApplicationStream == guildListItem$GuildItem.hasOngoingApplicationStream && this.isTargetedForFolderCreation == guildListItem$GuildItem.isTargetedForFolderCreation && m.areEqual(this.isLastGuildInFolder, guildListItem$GuildItem.isLastGuildInFolder) && m.areEqual(this.applicationStatus, guildListItem$GuildItem.applicationStatus) && this.isPendingGuild == guildListItem$GuildItem.isPendingGuild && this.hasActiveStageChannel == guildListItem$GuildItem.hasActiveStageChannel && this.isConnectedToStageChannel == guildListItem$GuildItem.isConnectedToStageChannel && this.hasActiveScheduledEvent == guildListItem$GuildItem.hasActiveScheduledEvent;
    }

    public final ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    public final Long getFolderId() {
        return this.folderId;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final boolean getHasActiveScheduledEvent() {
        return this.hasActiveScheduledEvent;
    }

    public final boolean getHasActiveStageChannel() {
        return this.hasActiveStageChannel;
    }

    public final boolean getHasOngoingApplicationStream() {
        return this.hasOngoingApplicationStream;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads$UnreadItem
    public int getMentionCount() {
        return this.mentionCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Guild guild = this.guild;
        int mentionCount = (getMentionCount() + ((guild != null ? guild.hashCode() : 0) * 31)) * 31;
        boolean z2 = this.isLurkingGuild;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (mentionCount + r0) * 31;
        boolean isUnread = getIsUnread();
        ?? r1 = isUnread;
        if (isUnread) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean z3 = this.isSelected;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i3 = (i2 + r2) * 31;
        Long l = this.folderId;
        int iHashCode = (i3 + (l != null ? l.hashCode() : 0)) * 31;
        boolean z4 = this.isConnectedToVoice;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i4 = (iHashCode + r3) * 31;
        boolean z5 = this.hasOngoingApplicationStream;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i5 = (i4 + r4) * 31;
        boolean z6 = this.isTargetedForFolderCreation;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i6 = (i5 + r5) * 31;
        Boolean bool = this.isLastGuildInFolder;
        int iHashCode2 = (i6 + (bool != null ? bool.hashCode() : 0)) * 31;
        ApplicationStatus applicationStatus = this.applicationStatus;
        int iHashCode3 = (iHashCode2 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
        boolean z7 = this.isPendingGuild;
        ?? r6 = z7;
        if (z7) {
            r6 = 1;
        }
        int i7 = (iHashCode3 + r6) * 31;
        boolean z8 = this.hasActiveStageChannel;
        ?? r7 = z8;
        if (z8) {
            r7 = 1;
        }
        int i8 = (i7 + r7) * 31;
        boolean z9 = this.isConnectedToStageChannel;
        ?? r8 = z9;
        if (z9) {
            r8 = 1;
        }
        int i9 = (i8 + r8) * 31;
        boolean z10 = this.hasActiveScheduledEvent;
        return i9 + (z10 ? 1 : z10);
    }

    public final boolean isConnectedToStageChannel() {
        return this.isConnectedToStageChannel;
    }

    public final boolean isConnectedToVoice() {
        return this.isConnectedToVoice;
    }

    public final Boolean isLastGuildInFolder() {
        return this.isLastGuildInFolder;
    }

    public final boolean isLurkingGuild() {
        return this.isLurkingGuild;
    }

    public final boolean isPendingGuild() {
        return this.isPendingGuild;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final boolean isTargetedForFolderCreation() {
        return this.isTargetedForFolderCreation;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads$UnreadItem
    /* JADX INFO: renamed from: isUnread, reason: from getter */
    public boolean getIsUnread() {
        return this.isUnread;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildItem(guild=");
        sbU.append(this.guild);
        sbU.append(", mentionCount=");
        sbU.append(getMentionCount());
        sbU.append(", isLurkingGuild=");
        sbU.append(this.isLurkingGuild);
        sbU.append(", isUnread=");
        sbU.append(getIsUnread());
        sbU.append(", isSelected=");
        sbU.append(this.isSelected);
        sbU.append(", folderId=");
        sbU.append(this.folderId);
        sbU.append(", isConnectedToVoice=");
        sbU.append(this.isConnectedToVoice);
        sbU.append(", hasOngoingApplicationStream=");
        sbU.append(this.hasOngoingApplicationStream);
        sbU.append(", isTargetedForFolderCreation=");
        sbU.append(this.isTargetedForFolderCreation);
        sbU.append(", isLastGuildInFolder=");
        sbU.append(this.isLastGuildInFolder);
        sbU.append(", applicationStatus=");
        sbU.append(this.applicationStatus);
        sbU.append(", isPendingGuild=");
        sbU.append(this.isPendingGuild);
        sbU.append(", hasActiveStageChannel=");
        sbU.append(this.hasActiveStageChannel);
        sbU.append(", isConnectedToStageChannel=");
        sbU.append(this.isConnectedToStageChannel);
        sbU.append(", hasActiveScheduledEvent=");
        return a.O(sbU, this.hasActiveScheduledEvent, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListItem$GuildItem(Guild guild, int i, boolean z2, boolean z3, boolean z4, Long l, boolean z5, boolean z6, boolean z7, Boolean bool, ApplicationStatus applicationStatus, boolean z8, boolean z9, boolean z10, boolean z11) {
        super(guild.getId(), null);
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
        this.mentionCount = i;
        this.isLurkingGuild = z2;
        this.isUnread = z3;
        this.isSelected = z4;
        this.folderId = l;
        this.isConnectedToVoice = z5;
        this.hasOngoingApplicationStream = z6;
        this.isTargetedForFolderCreation = z7;
        this.isLastGuildInFolder = bool;
        this.applicationStatus = applicationStatus;
        this.isPendingGuild = z8;
        this.hasActiveStageChannel = z9;
        this.isConnectedToStageChannel = z10;
        this.hasActiveScheduledEvent = z11;
    }
}
