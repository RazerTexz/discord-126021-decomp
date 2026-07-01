package com.discord.widgets.servers;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsChannelListAdapter$ChannelItem implements CategoricalDragAndDropAdapter$Payload {
    private final boolean canManageCategoryOfChannel;
    private final Channel channel;
    private final boolean isDraggable;
    private final String key;
    private final long parentId;
    private final int type;

    public SettingsChannelListAdapter$ChannelItem(Channel channel, boolean z2, long j, boolean z3) {
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.isDraggable = z2;
        this.parentId = j;
        this.canManageCategoryOfChannel = z3;
        this.key = String.valueOf(channel.getId());
    }

    public static /* synthetic */ SettingsChannelListAdapter$ChannelItem copy$default(SettingsChannelListAdapter$ChannelItem settingsChannelListAdapter$ChannelItem, Channel channel, boolean z2, long j, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = settingsChannelListAdapter$ChannelItem.channel;
        }
        if ((i & 2) != 0) {
            z2 = settingsChannelListAdapter$ChannelItem.isDraggable;
        }
        boolean z4 = z2;
        if ((i & 4) != 0) {
            j = settingsChannelListAdapter$ChannelItem.parentId;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z3 = settingsChannelListAdapter$ChannelItem.canManageCategoryOfChannel;
        }
        return settingsChannelListAdapter$ChannelItem.copy(channel, z4, j2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsDraggable() {
        return this.isDraggable;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getParentId() {
        return this.parentId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanManageCategoryOfChannel() {
        return this.canManageCategoryOfChannel;
    }

    public final SettingsChannelListAdapter$ChannelItem copy(Channel channel, boolean isDraggable, long parentId, boolean canManageCategoryOfChannel) {
        m.checkNotNullParameter(channel, "channel");
        return new SettingsChannelListAdapter$ChannelItem(channel, isDraggable, parentId, canManageCategoryOfChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsChannelListAdapter$ChannelItem)) {
            return false;
        }
        SettingsChannelListAdapter$ChannelItem settingsChannelListAdapter$ChannelItem = (SettingsChannelListAdapter$ChannelItem) other;
        return m.areEqual(this.channel, settingsChannelListAdapter$ChannelItem.channel) && this.isDraggable == settingsChannelListAdapter$ChannelItem.isDraggable && this.parentId == settingsChannelListAdapter$ChannelItem.parentId && this.canManageCategoryOfChannel == settingsChannelListAdapter$ChannelItem.canManageCategoryOfChannel;
    }

    public final boolean getCanManageCategoryOfChannel() {
        return this.canManageCategoryOfChannel;
    }

    @Override // com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload
    public String getCategory() {
        return String.valueOf(getType());
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getParentId() {
        return this.parentId;
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload
    public int getPosition() {
        return this.channel.getPosition();
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.isDraggable;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int iA = (b.a(this.parentId) + ((iHashCode + r1) * 31)) * 31;
        boolean z3 = this.canManageCategoryOfChannel;
        return iA + (z3 ? 1 : z3);
    }

    public final boolean isDraggable() {
        return this.isDraggable;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelItem(channel=");
        sbU.append(this.channel);
        sbU.append(", isDraggable=");
        sbU.append(this.isDraggable);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", canManageCategoryOfChannel=");
        return a.O(sbU, this.canManageCategoryOfChannel, ")");
    }
}
