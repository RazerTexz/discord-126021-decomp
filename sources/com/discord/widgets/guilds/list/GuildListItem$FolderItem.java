package com.discord.widgets.guilds.list;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.widgets.channels.list.WidgetChannelListUnreads$UnreadItem;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildListItem$FolderItem extends GuildListItem implements WidgetChannelListUnreads$UnreadItem {
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

    public /* synthetic */ GuildListItem$FolderItem(long j, Integer num, String str, boolean z2, List list, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, num, str, z2, list, z3, z4, z5, i, z6, (i2 & 1024) != 0 ? false : z7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildListItem$FolderItem copy$default(GuildListItem$FolderItem guildListItem$FolderItem, long j, Integer num, String str, boolean z2, List list, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, int i2, Object obj) {
        return guildListItem$FolderItem.copy((i2 & 1) != 0 ? guildListItem$FolderItem.folderId : j, (i2 & 2) != 0 ? guildListItem$FolderItem.color : num, (i2 & 4) != 0 ? guildListItem$FolderItem.name : str, (i2 & 8) != 0 ? guildListItem$FolderItem.isOpen : z2, (i2 & 16) != 0 ? guildListItem$FolderItem.guilds : list, (i2 & 32) != 0 ? guildListItem$FolderItem.isAnyGuildSelected : z3, (i2 & 64) != 0 ? guildListItem$FolderItem.isAnyGuildConnectedToVoice : z4, (i2 & 128) != 0 ? guildListItem$FolderItem.isAnyGuildConnectedToStageChannel : z5, (i2 & 256) != 0 ? guildListItem$FolderItem.getMentionCount() : i, (i2 & 512) != 0 ? guildListItem$FolderItem.getIsUnread() : z6, (i2 & 1024) != 0 ? guildListItem$FolderItem.isTargetedForFolderAddition : z7);
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

    public final GuildListItem$FolderItem copy(long folderId, Integer color, String name, boolean isOpen, List<Guild> guilds, boolean isAnyGuildSelected, boolean isAnyGuildConnectedToVoice, boolean isAnyGuildConnectedToStageChannel, int mentionCount, boolean isUnread, boolean isTargetedForFolderAddition) {
        m.checkNotNullParameter(guilds, "guilds");
        return new GuildListItem$FolderItem(folderId, color, name, isOpen, guilds, isAnyGuildSelected, isAnyGuildConnectedToVoice, isAnyGuildConnectedToStageChannel, mentionCount, isUnread, isTargetedForFolderAddition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildListItem$FolderItem)) {
            return false;
        }
        GuildListItem$FolderItem guildListItem$FolderItem = (GuildListItem$FolderItem) other;
        return this.folderId == guildListItem$FolderItem.folderId && m.areEqual(this.color, guildListItem$FolderItem.color) && m.areEqual(this.name, guildListItem$FolderItem.name) && this.isOpen == guildListItem$FolderItem.isOpen && m.areEqual(this.guilds, guildListItem$FolderItem.guilds) && this.isAnyGuildSelected == guildListItem$FolderItem.isAnyGuildSelected && this.isAnyGuildConnectedToVoice == guildListItem$FolderItem.isAnyGuildConnectedToVoice && this.isAnyGuildConnectedToStageChannel == guildListItem$FolderItem.isAnyGuildConnectedToStageChannel && getMentionCount() == guildListItem$FolderItem.getMentionCount() && getIsUnread() == guildListItem$FolderItem.getIsUnread() && this.isTargetedForFolderAddition == guildListItem$FolderItem.isTargetedForFolderAddition;
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

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads$UnreadItem
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

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads$UnreadItem
    /* JADX INFO: renamed from: isUnread, reason: from getter */
    public boolean getIsUnread() {
        return this.isUnread;
    }

    public String toString() {
        StringBuilder sbU = a.U("FolderItem(folderId=");
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
        return a.O(sbU, this.isTargetedForFolderAddition, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListItem$FolderItem(long j, Integer num, String str, boolean z2, List<Guild> list, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7) {
        super(j, null);
        m.checkNotNullParameter(list, "guilds");
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
