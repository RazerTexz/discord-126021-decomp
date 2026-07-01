package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState$State;
import d0.z.d.m;

/* JADX INFO: compiled from: AttachmentEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AttachmentEntry extends ChatListEntry {
    private final boolean allowAnimatedEmojis;
    private final MessageAttachment attachment;
    private final boolean autoPlayGifs;
    private final int embedIndex;
    private final long guildId;
    private final boolean isBlockedExpanded;
    private final boolean isThreadStarterMessage;
    private final String key;
    private final Message message;
    private final StoreMessageState$State messageState;
    private final int type;

    public AttachmentEntry(int i, long j, Message message, StoreMessageState$State storeMessageState$State, MessageAttachment messageAttachment, boolean z2, boolean z3, boolean z4, boolean z5) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(messageAttachment, "attachment");
        this.embedIndex = i;
        this.guildId = j;
        this.message = message;
        this.messageState = storeMessageState$State;
        this.attachment = messageAttachment;
        this.isBlockedExpanded = z2;
        this.allowAnimatedEmojis = z3;
        this.autoPlayGifs = z4;
        this.isThreadStarterMessage = z5;
        this.type = 28;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(message.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ AttachmentEntry copy$default(AttachmentEntry attachmentEntry, int i, long j, Message message, StoreMessageState$State storeMessageState$State, MessageAttachment messageAttachment, boolean z2, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
        return attachmentEntry.copy((i2 & 1) != 0 ? attachmentEntry.embedIndex : i, (i2 & 2) != 0 ? attachmentEntry.guildId : j, (i2 & 4) != 0 ? attachmentEntry.message : message, (i2 & 8) != 0 ? attachmentEntry.messageState : storeMessageState$State, (i2 & 16) != 0 ? attachmentEntry.attachment : messageAttachment, (i2 & 32) != 0 ? attachmentEntry.isBlockedExpanded : z2, (i2 & 64) != 0 ? attachmentEntry.allowAnimatedEmojis : z3, (i2 & 128) != 0 ? attachmentEntry.autoPlayGifs : z4, (i2 & 256) != 0 ? attachmentEntry.isThreadStarterMessage : z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getEmbedIndex() {
        return this.embedIndex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreMessageState$State getMessageState() {
        return this.messageState;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MessageAttachment getAttachment() {
        return this.attachment;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsBlockedExpanded() {
        return this.isBlockedExpanded;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsThreadStarterMessage() {
        return this.isThreadStarterMessage;
    }

    public final AttachmentEntry copy(int embedIndex, long guildId, Message message, StoreMessageState$State messageState, MessageAttachment attachment, boolean isBlockedExpanded, boolean allowAnimatedEmojis, boolean autoPlayGifs, boolean isThreadStarterMessage) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(attachment, "attachment");
        return new AttachmentEntry(embedIndex, guildId, message, messageState, attachment, isBlockedExpanded, allowAnimatedEmojis, autoPlayGifs, isThreadStarterMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttachmentEntry)) {
            return false;
        }
        AttachmentEntry attachmentEntry = (AttachmentEntry) other;
        return this.embedIndex == attachmentEntry.embedIndex && this.guildId == attachmentEntry.guildId && m.areEqual(this.message, attachmentEntry.message) && m.areEqual(this.messageState, attachmentEntry.messageState) && m.areEqual(this.attachment, attachmentEntry.attachment) && this.isBlockedExpanded == attachmentEntry.isBlockedExpanded && this.allowAnimatedEmojis == attachmentEntry.allowAnimatedEmojis && this.autoPlayGifs == attachmentEntry.autoPlayGifs && this.isThreadStarterMessage == attachmentEntry.isThreadStarterMessage;
    }

    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final MessageAttachment getAttachment() {
        return this.attachment;
    }

    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
    }

    public final int getEmbedIndex() {
        return this.embedIndex;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final StoreMessageState$State getMessageState() {
        return this.messageState;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int iA = (b.a(this.guildId) + (this.embedIndex * 31)) * 31;
        Message message = this.message;
        int iHashCode = (iA + (message != null ? message.hashCode() : 0)) * 31;
        StoreMessageState$State storeMessageState$State = this.messageState;
        int iHashCode2 = (iHashCode + (storeMessageState$State != null ? storeMessageState$State.hashCode() : 0)) * 31;
        MessageAttachment messageAttachment = this.attachment;
        int iHashCode3 = (iHashCode2 + (messageAttachment != null ? messageAttachment.hashCode() : 0)) * 31;
        boolean z2 = this.isBlockedExpanded;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode3 + r0) * 31;
        boolean z3 = this.allowAnimatedEmojis;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean z4 = this.autoPlayGifs;
        ?? r2 = z4;
        if (z4) {
            r2 = 1;
        }
        int i3 = (i2 + r2) * 31;
        boolean z5 = this.isThreadStarterMessage;
        return i3 + (z5 ? 1 : z5);
    }

    public final boolean isBlockedExpanded() {
        return this.isBlockedExpanded;
    }

    @Override // com.discord.widgets.chat.list.entries.ChatListEntry
    public boolean isInExpandedBlockedMessageChunk() {
        return this.isBlockedExpanded;
    }

    public final boolean isThreadStarterMessage() {
        return this.isThreadStarterMessage;
    }

    public String toString() {
        StringBuilder sbU = a.U("AttachmentEntry(embedIndex=");
        sbU.append(this.embedIndex);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", messageState=");
        sbU.append(this.messageState);
        sbU.append(", attachment=");
        sbU.append(this.attachment);
        sbU.append(", isBlockedExpanded=");
        sbU.append(this.isBlockedExpanded);
        sbU.append(", allowAnimatedEmojis=");
        sbU.append(this.allowAnimatedEmojis);
        sbU.append(", autoPlayGifs=");
        sbU.append(this.autoPlayGifs);
        sbU.append(", isThreadStarterMessage=");
        return a.O(sbU, this.isThreadStarterMessage, ")");
    }
}
