package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StartOfPrivateChatEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StartOfPrivateChatEntry extends ChatListEntry {
    private final String channelIcon;
    private final long channelId;
    private final String channelName;
    private final int channelType;
    private final boolean isSystemDM;
    private final String key;
    private final List<Guild> mutualGuilds;
    private final int type;

    public StartOfPrivateChatEntry(long j, String str, int i, String str2, boolean z2, List<Guild> list) {
        m.checkNotNullParameter(str, "channelName");
        m.checkNotNullParameter(list, "mutualGuilds");
        this.channelId = j;
        this.channelName = str;
        this.channelType = i;
        this.channelIcon = str2;
        this.isSystemDM = z2;
        this.mutualGuilds = list;
        this.type = 29;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StartOfPrivateChatEntry copy$default(StartOfPrivateChatEntry startOfPrivateChatEntry, long j, String str, int i, String str2, boolean z2, List list, int i2, Object obj) {
        return startOfPrivateChatEntry.copy((i2 & 1) != 0 ? startOfPrivateChatEntry.channelId : j, (i2 & 2) != 0 ? startOfPrivateChatEntry.channelName : str, (i2 & 4) != 0 ? startOfPrivateChatEntry.channelType : i, (i2 & 8) != 0 ? startOfPrivateChatEntry.channelIcon : str2, (i2 & 16) != 0 ? startOfPrivateChatEntry.isSystemDM : z2, (i2 & 32) != 0 ? startOfPrivateChatEntry.mutualGuilds : list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getChannelIcon() {
        return this.channelIcon;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSystemDM() {
        return this.isSystemDM;
    }

    public final List<Guild> component6() {
        return this.mutualGuilds;
    }

    public final StartOfPrivateChatEntry copy(long channelId, String channelName, int channelType, String channelIcon, boolean isSystemDM, List<Guild> mutualGuilds) {
        m.checkNotNullParameter(channelName, "channelName");
        m.checkNotNullParameter(mutualGuilds, "mutualGuilds");
        return new StartOfPrivateChatEntry(channelId, channelName, channelType, channelIcon, isSystemDM, mutualGuilds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartOfPrivateChatEntry)) {
            return false;
        }
        StartOfPrivateChatEntry startOfPrivateChatEntry = (StartOfPrivateChatEntry) other;
        return this.channelId == startOfPrivateChatEntry.channelId && m.areEqual(this.channelName, startOfPrivateChatEntry.channelName) && this.channelType == startOfPrivateChatEntry.channelType && m.areEqual(this.channelIcon, startOfPrivateChatEntry.channelIcon) && this.isSystemDM == startOfPrivateChatEntry.isSystemDM && m.areEqual(this.mutualGuilds, startOfPrivateChatEntry.mutualGuilds);
    }

    public final String getChannelIcon() {
        return this.channelIcon;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final int getChannelType() {
        return this.channelType;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final List<Guild> getMutualGuilds() {
        return this.mutualGuilds;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        String str = this.channelName;
        int iHashCode = (((iA + (str != null ? str.hashCode() : 0)) * 31) + this.channelType) * 31;
        String str2 = this.channelIcon;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.isSystemDM;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        List<Guild> list = this.mutualGuilds;
        return i + (list != null ? list.hashCode() : 0);
    }

    public final boolean isSystemDM() {
        return this.isSystemDM;
    }

    public String toString() {
        StringBuilder sbU = a.U("StartOfPrivateChatEntry(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelName=");
        sbU.append(this.channelName);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", channelIcon=");
        sbU.append(this.channelIcon);
        sbU.append(", isSystemDM=");
        sbU.append(this.isSystemDM);
        sbU.append(", mutualGuilds=");
        return a.L(sbU, this.mutualGuilds, ")");
    }
}
