package com.discord.widgets.chat.list.entries;

import com.discord.models.message.Message;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BlockedMessagesEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class BlockedMessagesEntry extends ChatListEntry {
    private final int blockedCount;
    private final boolean isExpandedBlock;
    private final String key;
    private final Message message;
    private final int type;

    public BlockedMessagesEntry(Message message, int i, boolean z2) {
        C12238m.checkNotNullParameter(message, "message");
        this.message = message;
        this.blockedCount = i;
        this.isExpandedBlock = z2;
        this.type = 10;
        this.key = String.valueOf(getType());
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final boolean getIsExpandedBlock() {
        return this.isExpandedBlock;
    }

    public static /* synthetic */ BlockedMessagesEntry copy$default(BlockedMessagesEntry blockedMessagesEntry, Message message, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            message = blockedMessagesEntry.message;
        }
        if ((i2 & 2) != 0) {
            i = blockedMessagesEntry.blockedCount;
        }
        if ((i2 & 4) != 0) {
            z2 = blockedMessagesEntry.isExpandedBlock;
        }
        return blockedMessagesEntry.copy(message, i, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBlockedCount() {
        return this.blockedCount;
    }

    public final BlockedMessagesEntry copy(Message message, int blockedCount, boolean isExpandedBlock) {
        C12238m.checkNotNullParameter(message, "message");
        return new BlockedMessagesEntry(message, blockedCount, isExpandedBlock);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlockedMessagesEntry)) {
            return false;
        }
        BlockedMessagesEntry blockedMessagesEntry = (BlockedMessagesEntry) other;
        return C12238m.areEqual(this.message, blockedMessagesEntry.message) && this.blockedCount == blockedMessagesEntry.blockedCount && this.isExpandedBlock == blockedMessagesEntry.isExpandedBlock;
    }

    public final int getBlockedCount() {
        return this.blockedCount;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        Message message = this.message;
        int iHashCode = (((message != null ? message.hashCode() : 0) * 31) + this.blockedCount) * 31;
        boolean z2 = this.isExpandedBlock;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    @Override // com.discord.widgets.chat.list.entries.ChatListEntry
    public boolean isInExpandedBlockedMessageChunk() {
        return this.isExpandedBlock;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("BlockedMessagesEntry(message=");
        sbM833U.append(this.message);
        sbM833U.append(", blockedCount=");
        sbM833U.append(this.blockedCount);
        sbM833U.append(", isExpandedBlock=");
        return C1643a.m827O(sbM833U, this.isExpandedBlock, ")");
    }
}
