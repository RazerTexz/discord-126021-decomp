package com.discord.widgets.channels.list.items;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: ChannelListItemHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelListItemHeader implements ChannelListItem {
    private final boolean ableToManageChannel;
    private final long id;
    private final String key;
    private final long selectedGuildId;
    private final int textResId;
    private final int type = 6;

    public ChannelListItemHeader(long j, int i, boolean z2, long j2) {
        this.id = j;
        this.textResId = i;
        this.ableToManageChannel = z2;
        this.selectedGuildId = j2;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        sb.append(i);
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemHeader copy$default(ChannelListItemHeader channelListItemHeader, long j, int i, boolean z2, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = channelListItemHeader.id;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            i = channelListItemHeader.textResId;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            z2 = channelListItemHeader.ableToManageChannel;
        }
        boolean z3 = z2;
        if ((i2 & 8) != 0) {
            j2 = channelListItemHeader.selectedGuildId;
        }
        return channelListItemHeader.copy(j3, i3, z3, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTextResId() {
        return this.textResId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAbleToManageChannel() {
        return this.ableToManageChannel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final ChannelListItemHeader copy(long id2, int textResId, boolean ableToManageChannel, long selectedGuildId) {
        return new ChannelListItemHeader(id2, textResId, ableToManageChannel, selectedGuildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemHeader)) {
            return false;
        }
        ChannelListItemHeader channelListItemHeader = (ChannelListItemHeader) other;
        return this.id == channelListItemHeader.id && this.textResId == channelListItemHeader.textResId && this.ableToManageChannel == channelListItemHeader.ableToManageChannel && this.selectedGuildId == channelListItemHeader.selectedGuildId;
    }

    public final boolean getAbleToManageChannel() {
        return this.ableToManageChannel;
    }

    public final long getId() {
        return this.id;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final int getTextResId() {
        return this.textResId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iA = ((b.a(this.id) * 31) + this.textResId) * 31;
        boolean z2 = this.ableToManageChannel;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return b.a(this.selectedGuildId) + ((iA + r1) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelListItemHeader(id=");
        sbU.append(this.id);
        sbU.append(", textResId=");
        sbU.append(this.textResId);
        sbU.append(", ableToManageChannel=");
        sbU.append(this.ableToManageChannel);
        sbU.append(", selectedGuildId=");
        return a.C(sbU, this.selectedGuildId, ")");
    }
}
