package com.discord.widgets.guilds.list;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildListItem {
    private static final long ID_BOTTOM_NAV_SPACE = -6;
    private static final long ID_CREATE = -3;
    private static final long ID_DIVIDER = -4;
    private static final long ID_FRIENDS_LIST = -2;
    private static final long ID_HELP = -5;
    private static final long ID_HUB = -8;
    public static final long ID_PENDING_GUILDS_FOLDER = -7;
    private static final long ID_UNIDENTIFIED = -1;
    public static final int TYPE_BOTTOM_NAV_SPACE = 8;
    public static final int TYPE_CREATE = 5;
    public static final int TYPE_DIVIDER = 1;
    public static final int TYPE_DM = 2;
    public static final int TYPE_FOLDER = 6;
    public static final int TYPE_FRIENDS = 0;
    public static final int TYPE_GUILD = 3;
    public static final int TYPE_HELP = 7;
    public static final int TYPE_HUB = 9;
    public static final int TYPE_UNAVAILABLE = 4;
    private final long itemId;

    /* JADX INFO: compiled from: GuildListItem.kt */
    public static final class CreateItem extends GuildListItem {
        public static final CreateItem INSTANCE = new CreateItem();

        private CreateItem() {
            super(-3L, null);
        }
    }

    /* JADX INFO: compiled from: GuildListItem.kt */
    public static final class DividerItem extends GuildListItem {
        public static final DividerItem INSTANCE = new DividerItem();

        private DividerItem() {
            super(GuildListItem.ID_DIVIDER, null);
        }
    }

    /* JADX INFO: compiled from: GuildListItem.kt */
    public static final /* data */ class FolderItem extends GuildListItem implements WidgetChannelListUnreads.UnreadItem {
        private final Integer color;
        private final long folderId;
        private final List<Guild> guilds;
        private final boolean isAnyGuildConnectedToStageChannel;
        private final boolean isAnyGuildConnectedToVoice;
        private final boolean isAnyGuildSelected;
        private final boolean isOpen;
        private final boolean isPendingGuildsFolder;
        private final boolean isTargetedForFolderAddition;
        private final boolean isUnread;
        private final int mentionCount;
        private final String name;

        public /* synthetic */ FolderItem(long j, Integer num, String str, boolean z2, List list, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, num, str, z2, list, z3, z4, z5, i, z6, (i2 & 1024) != 0 ? false : z7);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getFolderId() {
            return this.folderId;
        }

        public final boolean component10() {
            return getIsUnread();
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getIsTargetedForFolderAddition() {
            return this.isTargetedForFolderAddition;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsOpen() {
            return this.isOpen;
        }

        public final List<Guild> component5() {
            return this.guilds;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsAnyGuildSelected() {
            return this.isAnyGuildSelected;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsAnyGuildConnectedToVoice() {
            return this.isAnyGuildConnectedToVoice;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getIsAnyGuildConnectedToStageChannel() {
            return this.isAnyGuildConnectedToStageChannel;
        }

        public final int component9() {
            return getMentionCount();
        }

        public final FolderItem copy(long folderId, Integer color, String name, boolean isOpen, List<Guild> guilds, boolean isAnyGuildSelected, boolean isAnyGuildConnectedToVoice, boolean isAnyGuildConnectedToStageChannel, int mentionCount, boolean isUnread, boolean isTargetedForFolderAddition) {
            Intrinsics3.checkNotNullParameter(guilds, "guilds");
            return new FolderItem(folderId, color, name, isOpen, guilds, isAnyGuildSelected, isAnyGuildConnectedToVoice, isAnyGuildConnectedToStageChannel, mentionCount, isUnread, isTargetedForFolderAddition);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FolderItem)) {
                return false;
            }
            FolderItem folderItem = (FolderItem) other;
            return this.folderId == folderItem.folderId && Intrinsics3.areEqual(this.color, folderItem.color) && Intrinsics3.areEqual(this.name, folderItem.name) && this.isOpen == folderItem.isOpen && Intrinsics3.areEqual(this.guilds, folderItem.guilds) && this.isAnyGuildSelected == folderItem.isAnyGuildSelected && this.isAnyGuildConnectedToVoice == folderItem.isAnyGuildConnectedToVoice && this.isAnyGuildConnectedToStageChannel == folderItem.isAnyGuildConnectedToStageChannel && getMentionCount() == folderItem.getMentionCount() && getIsUnread() == folderItem.getIsUnread() && this.isTargetedForFolderAddition == folderItem.isTargetedForFolderAddition;
        }

        public final Integer getColor() {
            return this.color;
        }

        public final long getFolderId() {
            return this.folderId;
        }

        public final List<Guild> getGuilds() {
            return this.guilds;
        }

        @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
        public int getMentionCount() {
            return this.mentionCount;
        }

        public final String getName() {
            return this.name;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v21 */
        /* JADX WARN: Type inference failed for: r1v10, types: [int] */
        /* JADX WARN: Type inference failed for: r1v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v18, types: [int] */
        /* JADX WARN: Type inference failed for: r1v20, types: [int] */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            int iA = b.a(this.folderId) * 31;
            Integer num = this.color;
            int iHashCode = (iA + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.isOpen;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode2 + r1) * 31;
            List<Guild> list = this.guilds;
            int iHashCode3 = (i + (list != null ? list.hashCode() : 0)) * 31;
            boolean z3 = this.isAnyGuildSelected;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (iHashCode3 + r2) * 31;
            boolean z4 = this.isAnyGuildConnectedToVoice;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.isAnyGuildConnectedToStageChannel;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int mentionCount = (getMentionCount() + ((i3 + r4) * 31)) * 31;
            boolean isUnread = getIsUnread();
            ?? r0 = isUnread;
            if (isUnread) {
                r0 = 1;
            }
            int i4 = (mentionCount + r0) * 31;
            boolean z6 = this.isTargetedForFolderAddition;
            return i4 + (z6 ? 1 : z6);
        }

        public final boolean isAnyGuildConnectedToStageChannel() {
            return this.isAnyGuildConnectedToStageChannel;
        }

        public final boolean isAnyGuildConnectedToVoice() {
            return this.isAnyGuildConnectedToVoice;
        }

        public final boolean isAnyGuildSelected() {
            return this.isAnyGuildSelected;
        }

        public final boolean isOpen() {
            return this.isOpen;
        }

        /* JADX INFO: renamed from: isPendingGuildsFolder, reason: from getter */
        public final boolean getIsPendingGuildsFolder() {
            return this.isPendingGuildsFolder;
        }

        public final boolean isTargetedForFolderAddition() {
            return this.isTargetedForFolderAddition;
        }

        @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
        /* JADX INFO: renamed from: isUnread, reason: from getter */
        public boolean getIsUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbU = outline.U("FolderItem(folderId=");
            sbU.append(this.folderId);
            sbU.append(", color=");
            sbU.append(this.color);
            sbU.append(", name=");
            sbU.append(this.name);
            sbU.append(", isOpen=");
            sbU.append(this.isOpen);
            sbU.append(", guilds=");
            sbU.append(this.guilds);
            sbU.append(", isAnyGuildSelected=");
            sbU.append(this.isAnyGuildSelected);
            sbU.append(", isAnyGuildConnectedToVoice=");
            sbU.append(this.isAnyGuildConnectedToVoice);
            sbU.append(", isAnyGuildConnectedToStageChannel=");
            sbU.append(this.isAnyGuildConnectedToStageChannel);
            sbU.append(", mentionCount=");
            sbU.append(getMentionCount());
            sbU.append(", isUnread=");
            sbU.append(getIsUnread());
            sbU.append(", isTargetedForFolderAddition=");
            return outline.O(sbU, this.isTargetedForFolderAddition, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FolderItem(long j, Integer num, String str, boolean z2, List<Guild> list, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7) {
            super(j, null);
            Intrinsics3.checkNotNullParameter(list, "guilds");
            this.folderId = j;
            this.color = num;
            this.name = str;
            this.isOpen = z2;
            this.guilds = list;
            this.isAnyGuildSelected = z3;
            this.isAnyGuildConnectedToVoice = z4;
            this.isAnyGuildConnectedToStageChannel = z5;
            this.mentionCount = i;
            this.isUnread = z6;
            this.isTargetedForFolderAddition = z7;
            this.isPendingGuildsFolder = j == -7;
        }
    }

    /* JADX INFO: compiled from: GuildListItem.kt */
    public static final /* data */ class FriendsItem extends GuildListItem {
        private final boolean isSelected;

        public FriendsItem(boolean z2) {
            super(-2L, null);
            this.isSelected = z2;
        }

        public static /* synthetic */ FriendsItem copy$default(FriendsItem friendsItem, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = friendsItem.isSelected;
            }
            return friendsItem.copy(z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final FriendsItem copy(boolean isSelected) {
            return new FriendsItem(isSelected);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof FriendsItem) && this.isSelected == ((FriendsItem) other).isSelected;
            }
            return true;
        }

        public int hashCode() {
            boolean z2 = this.isSelected;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public String toString() {
            return outline.O(outline.U("FriendsItem(isSelected="), this.isSelected, ")");
        }
    }

    /* JADX INFO: compiled from: GuildListItem.kt */
    public static final /* data */ class GuildItem extends GuildListItem implements WidgetChannelListUnreads.UnreadItem {
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

        public /* synthetic */ GuildItem(Guild guild, int i, boolean z2, boolean z3, boolean z4, Long l, boolean z5, boolean z6, boolean z7, Boolean bool, ApplicationStatus applicationStatus, boolean z8, boolean z9, boolean z10, boolean z11, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(guild, i, z2, z3, z4, l, (i2 & 64) != 0 ? false : z5, (i2 & 128) != 0 ? false : z6, (i2 & 256) != 0 ? false : z7, (i2 & 512) != 0 ? null : bool, (i2 & 1024) != 0 ? null : applicationStatus, (i2 & 2048) != 0 ? false : z8, (i2 & 4096) != 0 ? false : z9, (i2 & 8192) != 0 ? false : z10, (i2 & 16384) != 0 ? false : z11);
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

        public final GuildItem copy(Guild guild, int mentionCount, boolean isLurkingGuild, boolean isUnread, boolean isSelected, Long folderId, boolean isConnectedToVoice, boolean hasOngoingApplicationStream, boolean isTargetedForFolderCreation, Boolean isLastGuildInFolder, ApplicationStatus applicationStatus, boolean isPendingGuild, boolean hasActiveStageChannel, boolean isConnectedToStageChannel, boolean hasActiveScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new GuildItem(guild, mentionCount, isLurkingGuild, isUnread, isSelected, folderId, isConnectedToVoice, hasOngoingApplicationStream, isTargetedForFolderCreation, isLastGuildInFolder, applicationStatus, isPendingGuild, hasActiveStageChannel, isConnectedToStageChannel, hasActiveScheduledEvent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildItem)) {
                return false;
            }
            GuildItem guildItem = (GuildItem) other;
            return Intrinsics3.areEqual(this.guild, guildItem.guild) && getMentionCount() == guildItem.getMentionCount() && this.isLurkingGuild == guildItem.isLurkingGuild && getIsUnread() == guildItem.getIsUnread() && this.isSelected == guildItem.isSelected && Intrinsics3.areEqual(this.folderId, guildItem.folderId) && this.isConnectedToVoice == guildItem.isConnectedToVoice && this.hasOngoingApplicationStream == guildItem.hasOngoingApplicationStream && this.isTargetedForFolderCreation == guildItem.isTargetedForFolderCreation && Intrinsics3.areEqual(this.isLastGuildInFolder, guildItem.isLastGuildInFolder) && Intrinsics3.areEqual(this.applicationStatus, guildItem.applicationStatus) && this.isPendingGuild == guildItem.isPendingGuild && this.hasActiveStageChannel == guildItem.hasActiveStageChannel && this.isConnectedToStageChannel == guildItem.isConnectedToStageChannel && this.hasActiveScheduledEvent == guildItem.hasActiveScheduledEvent;
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

        @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
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

        @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
        /* JADX INFO: renamed from: isUnread, reason: from getter */
        public boolean getIsUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildItem(guild=");
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
            return outline.O(sbU, this.hasActiveScheduledEvent, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildItem(Guild guild, int i, boolean z2, boolean z3, boolean z4, Long l, boolean z5, boolean z6, boolean z7, Boolean bool, ApplicationStatus applicationStatus, boolean z8, boolean z9, boolean z10, boolean z11) {
            super(guild.getId(), null);
            Intrinsics3.checkNotNullParameter(guild, "guild");
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

    /* JADX INFO: compiled from: GuildListItem.kt */
    public static final class HelpItem extends GuildListItem {
        public static final HelpItem INSTANCE = new HelpItem();

        private HelpItem() {
            super(GuildListItem.ID_HELP, null);
        }
    }

    /* JADX INFO: compiled from: GuildListItem.kt */
    public static final /* data */ class HubItem extends GuildListItem {
        private final boolean showSparkle;

        public HubItem(boolean z2) {
            super(GuildListItem.ID_HUB, null);
            this.showSparkle = z2;
        }

        public static /* synthetic */ HubItem copy$default(HubItem hubItem, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = hubItem.showSparkle;
            }
            return hubItem.copy(z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShowSparkle() {
            return this.showSparkle;
        }

        public final HubItem copy(boolean showSparkle) {
            return new HubItem(showSparkle);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof HubItem) && this.showSparkle == ((HubItem) other).showSparkle;
            }
            return true;
        }

        public final boolean getShowSparkle() {
            return this.showSparkle;
        }

        public int hashCode() {
            boolean z2 = this.showSparkle;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public String toString() {
            return outline.O(outline.U("HubItem(showSparkle="), this.showSparkle, ")");
        }
    }

    /* JADX INFO: compiled from: GuildListItem.kt */
    public static final /* data */ class PrivateChannelItem extends GuildListItem implements WidgetChannelListUnreads.UnreadItem {
        private final Channel channel;
        private final boolean isUnread;
        private final int mentionCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateChannelItem(Channel channel, int i) {
            super(channel.getId(), null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.mentionCount = i;
        }

        public static /* synthetic */ PrivateChannelItem copy$default(PrivateChannelItem privateChannelItem, Channel channel, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                channel = privateChannelItem.channel;
            }
            if ((i2 & 2) != 0) {
                i = privateChannelItem.getMentionCount();
            }
            return privateChannelItem.copy(channel, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final int component2() {
            return getMentionCount();
        }

        public final PrivateChannelItem copy(Channel channel, int mentionCount) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new PrivateChannelItem(channel, mentionCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PrivateChannelItem)) {
                return false;
            }
            PrivateChannelItem privateChannelItem = (PrivateChannelItem) other;
            return Intrinsics3.areEqual(this.channel, privateChannelItem.channel) && getMentionCount() == privateChannelItem.getMentionCount();
        }

        public final Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
        public int getMentionCount() {
            return this.mentionCount;
        }

        public int hashCode() {
            Channel channel = this.channel;
            return getMentionCount() + ((channel != null ? channel.hashCode() : 0) * 31);
        }

        @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
        /* JADX INFO: renamed from: isUnread, reason: from getter */
        public boolean getIsUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PrivateChannelItem(channel=");
            sbU.append(this.channel);
            sbU.append(", mentionCount=");
            sbU.append(getMentionCount());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: GuildListItem.kt */
    public static final class SpaceItem extends GuildListItem {
        public static final SpaceItem INSTANCE = new SpaceItem();

        private SpaceItem() {
            super(GuildListItem.ID_BOTTOM_NAV_SPACE, null);
        }
    }

    /* JADX INFO: compiled from: GuildListItem.kt */
    public static final /* data */ class UnavailableItem extends GuildListItem {
        private final int unavailableGuildCount;

        public UnavailableItem(int i) {
            super(-1L, null);
            this.unavailableGuildCount = i;
        }

        public static /* synthetic */ UnavailableItem copy$default(UnavailableItem unavailableItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = unavailableItem.unavailableGuildCount;
            }
            return unavailableItem.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getUnavailableGuildCount() {
            return this.unavailableGuildCount;
        }

        public final UnavailableItem copy(int unavailableGuildCount) {
            return new UnavailableItem(unavailableGuildCount);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof UnavailableItem) && this.unavailableGuildCount == ((UnavailableItem) other).unavailableGuildCount;
            }
            return true;
        }

        public final int getUnavailableGuildCount() {
            return this.unavailableGuildCount;
        }

        public int hashCode() {
            return this.unavailableGuildCount;
        }

        public String toString() {
            return outline.B(outline.U("UnavailableItem(unavailableGuildCount="), this.unavailableGuildCount, ")");
        }
    }

    private GuildListItem(long j) {
        this.itemId = j;
    }

    public final long getItemId() {
        return this.itemId;
    }

    public /* synthetic */ GuildListItem(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }
}
